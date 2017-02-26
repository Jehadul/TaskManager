$("#btnSalPackage").on("click",function(){	
	ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadSalPackage");
});

var getEmpSalComponent = function(){
	 $.ajax({
		type: "GET",
		url: "hrm/pr/salarypackage/getEmployeePackage?company_code=" + $("#company_code").val()+"&emp_code="+$("#emp_code").val(), 				
		dataType: 'json',
		success:function(data){ 
					var empComponent = eval(data);
					
					var html = "";
					for(var t= 0 ; t < empComponent.length; t++){
						var componentCode = empComponent[t].componentCode; 
						  var cashAmount = empComponent[t].cashAmount;
						  var nonCashAmount = empComponent[t].nonCashAmount;
						  var amount = cashAmount+nonCashAmount; 
							html += "" +
							'<tr>' +
							    
								'<td class="width-50" style="text-align:center" > <input name="sal_component_code[]" type="text" class="form-control sal-component-code" readonly value="'+ componentCode +'" /></td>' +
								'<td align="center"> <input name="sal_component_name[]" type="text" class="form-control" value="'+empComponent[t].componentName+'" readonly /></td>' +								
								'<td align="center"> <input name="sal_amount[]" type="text" class="form-control amount amount'+ empComponent[t].salaryComponentCode +'"" value="' + amount +'" readonly /></td>' +		
																
							            '<td class="controlling-component hidden"> <input name="sal_controlling_component_code[]" type="hidden" class="form-control" value="' + empComponent[t].controllingComponentCode + '"/></td>' +
							            '<td class="partofgross hidden"> <input name="sal_part_of_gross[]" type="text" class="form-control" value="" readonly /></td>' +			
										'<td class="multiplication hidden"> <input name="sal_multiplicationfact[]" type="text" class="form-control" value="' + empComponent[t].multiplicationFact + '" readonly /></td>' +
										'<td class="extra hidden"> <input name="sal_extra_amount[]" type="text" class="form-control" value="' + empComponent[t].extraAmount + '" readonly /></td>' +
										 '<input name="sal_package_id[]" type="hidden" class="form-control ids'+ empComponent[t].salaryComponentCode +'" value=""/>' + 

											'<input name="sal_controlling_component_name[]" type="hidden" class="controlling-component-name" value="' +  empComponent[t].controllingComponentName + '" />' +
											'<input name="sal_salary_component_short_name[]"type="hidden" class="salary-component-short-name" readonly value="'+  empComponent[t].salaryComponentShortName  + '" /></td>' +
											'<input name="sal_is_enabled[]"type="hidden" class="is-enabled" readonly value="'+  empComponent[t].isEnabled  + '" /></td>' +
											'<input name="sal_salary_component_sort_name" type="hidden" class="salary-component-sort-name" value="SALARY" /></td>' +
											'<input name="sal_payment_method[]" type="hidden" class="payment-method" value="'+  empComponent[t].paymentMethod +'" /></td>' +
											'<input name="sal_part_of_gross_salary[]" type="hidden" class="part-of-gross-salary"  value="'+  empComponent[t].partOfGrossSalary +'" /></td>' +
											'<input name="sal_paid_final_settlement[]" type="hidden" class="paid-final-settlement" value="'+  empComponent[t].paidFinalSettlement +'" /></td>' +
											'<input name="sal_pay_emp_bank_account[]" type="hidden" class="pay-emp-bank-account"  value="'+  empComponent[t].payEmpBankAccount +'" /></td>' +
											'<input name="sal_pay_company_bank_account[]" type="hidden" class="pay-company-bank-account"  value="'+  empComponent[t].payCompanyBankAccount +'" /></td>' +
											'<input name="sal_payment_frequency[]" type="hidden" class="payment-frequency" value="'+  empComponent[t].paymentFrequency +'" /></td>' +
																					
											'<input name="sal_company_code" type="hidden" class="company-code" value="' + empComponent[t].companyCode + '" />' +
											'<input name="sal_company_name" type="hidden" class="company-name" value="' + empComponent[t].companyName + '" />' +

							   '</tr>';

						}
						$(".salary-table-package tbody").empty();
						$(".salary-table-package tbody").append(html);
						InitHandlers();
						calculateDeductionFormula();
					
				}
		 });
}

/**********************Deduction package************************************/

var oldTotalCash = 0;
var isFormula = 0;

var getEmpComponent = function(){
	 $.ajax({
		type: "GET",
		url: "hrm/pr/deductionpackage/loadCurrentEmployeeComponent?company_code=" + $("#company_code").val()+"&emp_code="+$("#emp_code").val(), 				
		dataType: 'json',
		success:function(data){ 
					var empComponent = eval(data);
					var html = "";
					for(var t= 0 ; t < empComponent.length; t++){
							html += "" +
							'<tr>' +
							    
								'<td class="width-50" style="text-align:center" > <input name="component_code[]" type="text" class="form-control component-code" readonly value="'+empComponent[t].salaryComponentCode+'" /></td>' +
								'<td align="center"> <input name="component_name[]" type="text" class="form-control" value="'+empComponent[t].salaryComponentName+'" readonly /></td>' +		
								'<td class="cash-benefit"> <input name="amount[]" type="text" class="form-control money amount amount'+empComponent[t].salaryComponentCode+' text-right" value="0.00" onchange="getAmount(this)"> </td>'+  
							            '<td class="controlling-component hidden"> <input name="controlling_component_code[]" type="hidden" class="form-control" value="' + empComponent[t].controllingComponentCode + '"/></td>' +
							            '<td class="partofgross hidden"> <input name="part_of_gross[]" type="text" class="form-control" value="" readonly /></td>' +			
										'<td class="multiplication hidden"> <input name="multiplicationfact[]" type="text" class="form-control" value="' + empComponent[t].multiplicationFact + '" readonly /></td>' +
										'<td class="extra hidden"> <input name="extra_amount[]" type="text" class="form-control" value="' + empComponent[t].extraAmount + '" readonly /></td>' +
										 '<input name="package_id[]" type="hidden" class="form-control ids'+ empComponent[t].salaryComponentCode +'" value=""/>' + 

										     '<td> <input name="remarks[]" type="text" class="form-control remarks'+empComponent[t].salaryComponentName+'"  value="" /></td>' +
							                 '<td class="formula width-400"><input name="formula[]" type="text" class="form-control" readonly value="'+ empComponent[t].resultingEquation +'" /></td>' +
							                 '<input name="basic_salary[]" type="text" class="form-control basic-salary" readonly value="" />' +							                 

											'<input name="controlling_component_name[]" type="hidden" class="controlling-component-name" value="' +  empComponent[t].controllingComponentName + '" />' +
											'<input name="salary_component_short_name[]"type="hidden" class="salary-component-short-name" readonly value="'+  empComponent[t].salaryComponentShortName  + '" /></td>' +
											'<input name="is_enabled[]"type="hidden" class="is-enabled" readonly value="'+  empComponent[t].isEnabled  + '" /></td>' +
											'<input name="salary_component_sort_name" type="hidden" class="salary-component-sort-name" value="Deduction" /></td>' +							
											'<input name="company_code" type="hidden" class="company-code" value="' + empComponent[t].companyCode + '" />' +
											'<input name="company_name" type="hidden" class="company-name" value="' + empComponent[t].companyName + '" />' +

							   '</tr>';

						}
						$(".deduction-table tbody").empty();
						$(".deduction-table tbody").append(html);
						InitHandlers();
						calculateDeductionFormula();
						calculateTotalDeduction();
					
				}
		 });
}

var getEmpPackage = function(){ 
	$.ajax({
		type: "GET",
		url: "hrm/pr/deductionpackage/getEmployeePackage?company_code=" + $("#company_code").val()+"&emp_code="+$("#emp_code").val(), 				
		dataType: 'json',
		success:function(data){ 
		var empSalaryPackage = eval(data); 
			  for(var t= 0 ; t < empSalaryPackage.length; t++)
				{ 
				    console.log(empSalaryPackage[t].id); //alert(empSalaryPackage[t].cashAmount);
				  	$(".ids"+empSalaryPackage[t].componentCode).val(empSalaryPackage[t].id); 
				  	
				  	$(".amount"+empSalaryPackage[t].componentCode).val(empSalaryPackage[t].amount); 
				  	$(".total").val(empSalaryPackage[0].total); 
				 	$("#gross").val(empSalaryPackage[0].gross);
				 	
				}  
		} 
	});
	HideModal('search-modal');
};	 


$("#btnEmp").on("click",function(){	
	ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadEmp");

});


$("#company_code").on('change',function(){
	var newCompanyCode = $("#company_code").val();
	LoadMainContent("hrm/pr/deductionpackage/create/?company_code=" + newCompanyCode);
});

var calculateDeductionFormula = function(){
	var rows = $(".deduction-table tbody tr");
	var gross = Number($("#gross").val());  
	var cash = 0;	
	$(rows).each(function(i,item){
		var mult = Number($(item).find("td.multiplication input").val());  
		var extra = Number($(item).find("td.extra input").val());
		//var partOfGross = Number($(item).find("td.partofgross input").val());
		var controllingComponent = $(item).find("td.controlling-component input").val(); 
		var cashfixed = 0;
		if($(item).find(".formula input").val() !="Manual"){		
			if(controllingComponent == "g-000"){		/* gross salary code will be GROSS */		
				cash = ((mult*gross)/100) + extra;
				cashfixed = cash.toFixed(2); 
			}
			else{
				var rows = $(".salary-table-package tbody tr");
				console.log($(item));
				
				$(rows).each(function(i,item){ 
					var component = $(item).find(".sal-component-code").val(); 
					if(component == controllingComponent){ 
						var basicSalary = $(this).closest("tr").find(".amount").val(); 
						cash = ((mult*basicSalary)/100) + extra;
						cashfixed = cash.toFixed(2);
					}
				});	
			}
			
			$(item).find(".amount").val(cashfixed);
		}
		
		if($(item).find(".formula input").val() =="Manual"){
			$(item).find(".amount").val("0.00");
			$(item).find(".amount").prop("readonly",false);
		}
 		else{
				
			$(item).find(".amount").val(cashfixed);
		} 
		
		calculateTotalDeduction();

	});
};


var calculateTotalDeduction = function(){
	var rows = $("#Deductiondetails tbody tr");
	var totalCash = 0;
	var totalNonCash = 0;
	
	$(rows).each(function(i,item){
		totalCash += parseFloat($(item).find(".amount").val().replace(',','')); 
		totalNonCash += Number($(item).find(".non-cash-benifit-amount").val());
		  if($("#emp_sal_brk").val() == "Formula" && $(item).find("td.formula input").val()!="" && $(item).find("td.formula input").val()!="Manual")
		  {
	    	$(item).find(".amount").prop("readonly","readonly");		
		   }
	});

	   
	$(".deductionpackage-tfoot").find(".total").val(totalCash);
			
};


$("#gross").on('change',function(){
	calculateDeductionFormula();
	calculateTotalDeduction();
});

var getAmount = function(){ 
	calculateTotalDeduction();
}

var loadSalPackage = function(empdata){ 
	var emp = JSON.parse(unescape(empdata));		
	$("#emp_code").val(emp.empCode);		
	$("#emp_sal_brk").val(emp.salBrkdnFormula);		
	$("#emp_name").val(emp.empName);
	$("#emp_pr_curr").val(emp.payrollCurrency);
	$("#emp_desig").val(emp.desig);	
	$("#emp_dept").val(emp.departmentName);	
	$("#emp_grade").val(emp.empGrade);  
				
	$("#emp_name").val(emp.empName);
	$("#sal_gross").val(emp.gross);

	if(emp.grossSalary == null || emp.grossSalary == "")	
	{
		$(".gross").val(0);	
	}

	else $(".gross").val(emp.grossSalary);

	var rows = $("#Deductiondetails tbody tr");

	if(emp.salBrkdnFormula == "Formula")
			isFormula = 1;
    
	getEmpSalComponent();
	//getEmpSalPackage();

	calculateDeductionFormula();
	getEmpComponent();
	getEmpPackage();
	
	HideModal('search-modal');	
}




function showMessage(data) {
	if(data.outcome == 'success'){
		ShowSuccessMsg('Deduction Package created', data.msg);
		LoadMainContent('/hrm/pr/deductionpackage/create?' + data.employeeCode);
	}
	else{
		ShowErrorMsg('Deduction Package was not created', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
	}
}



function validate(){
	var result = CheckRequired(); 
		
	if($("#gross").val() ==""){
		ShowErrorMsg('Deduction package created was not created ', "First save Salary package");
		result = false;
	}
	
	if($("#emp_code").val()==null){
		ShowErrorMsg('Deduction package created was not created ', "Salary package select employee &  Deduction package select employee ");
		result = false;
	}

	if(result)
		$("#btnSave").hide();
	
	
	if (!result) {
		ShowErrorMsg('Deduction package created was not created', "Please check details.");
			InitErrorChange();
			$(".alert").removeClass("hidden");
	}

	return result;
}


