 $('#company_code').on('change', loadData);
var loadData = function(){
		$("text").removeClass("current-row");
	    LoadMainContent("/employeepayrolloption/create/?company_code=" + $("#company_code").val());
	};
	$('#company_code').on('change', function(){
		swal({
			title: "Are you sure?",
			text: "This will reload the page",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, reload!",
			closeOnConfirm: true
		}, function() {
	    	var newCompanyCode = $("#company_code").val();
	    	LoadMainContent("/employeepayrolloption/create/?company_code=" + newCompanyCode);
		});
	});

$("#btnStep").on("click",function(){	
	ShowModal("/searchstep/?action_type_code=SELECT&actioncallback=loadStep");
});

function loadStep(stepdata){
	event.preventDefault();
	var step = JSON.parse(unescape(stepdata));
	$("#step_code").val(step.step_code);		
	$("#step_name").val(step.step_name);	
	HideModal('search-modal');	
}

function showMessage(data) {
	if(data.outcome == 'success'){
		ShowSuccessMsg('Employee  Payroll Option created', data.msg);
		LoadMainContent('hrm/pr/employeepayrolloption/show/' + data.id + '/' + data.mode);
	}
	else{
		ShowErrorMsg('Employee payroll option was not created', data.msg);
		var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
	}
}

function validateStep(stepNumber){
    $(".alert").addClass("hidden");
	var result = CheckRequired("#step-" + stepNumber);

	if (!result) {
		ShowErrorMsg('Not valid', ":(");
			InitErrorChange();
			$(".alert").removeClass("hidden");
	}
	syncPreview();
	return result;
}

function syncPreview(){
	$.each($("[id^=preview_]"), function(i, item){
		var sourceId = $(item).prop("id").substring(8);
		var source = $("#" + sourceId);
		if (source && source.prop("type")){
			if(source.prop("type").toLowerCase() == "text") {
				$(item).text(source.val());
			}
			else if(source.prop("type").toLowerCase() == "select-one") {
				$(item).text(source.find("option:selected").text());
			}
			else if(source.prop("type").toLowerCase() == "checkbox") {
				$(item).text(source.is(":checked")? "Yes" : "No");
			}
		}
	});
}
	$("#btnBank2").on("click", function(){
		$("#bank_code2").val("");	
		$("#bank_name2").val("");	
		$("#bank_branch_code2").val("");		
		$("#bank_branch2").val("");
		$("#bank_acc2").val("");		
		$("#bank_acc_name2").val("");
	});
	$("#btnBank3").on("click", function(){
		$("#bank_code3").val("");	
		$("#bank_name3").val("");	
		$("#bank_branch_code3").val("");		
		$("#bank_branch3").val("");
		$("#bank_acc3").val("");		
		$("#bank_acc_name3").val("");
	});
	$("#btnEmployeeBankRemove1").on("click",function(){ 
		$("#emp_bank_code1").val("");
		$("#emp_bank_name1").val("");
		$("#emp_branch_code1").val("");			
		$("#emp_branch_name1").val("");
		$("#emp_bank_acc_no1").val("");		
		$("#emp_bank_acc_name1").val("");
	});

	$("#btnEmployeeBankRemove2").on("click",function(){ 
		$("#emp_bank_code2").val("");
		$("#emp_bank_name2").val("");
		$("#emp_branch_code2").val("");			
		$("#emp_branch_name2").val("");
		$("#emp_bank_acc_no2").val("");		
		$("#emp_bank_acc_name2").val("");
	});
	$("#btnEmployeeBankRemove3").on("click",function(){ 
		$("#emp_bank_code3").val("");
		$("#emp_bank_name3").val("");
		$("#emp_branch_code3").val("");			
		$("#emp_branch_name3").val("");
		$("#emp_bank_acc_no3").val("");		
		$("#emp_bank_acc_name3").val("");
	});

	$("#btnBankOne").on("click",function(){	
		$(".btn").removeClass("current-button");
		$(this).addClass("current-button");
		ShowModal("fin/try/bankbranch/index");
	});	

	$("#btnBankTwo").on("click",function(){	
		$(".btn").removeClass("current-button");
		$(this).addClass("current-button");

		if ($('#bank_name1').val()== "") { 
			ShowErrorMsg("Error", "selected 1st Account");
			return 0;
		};
		ShowModal("fin/try/bankbranch/index");
	});	

	$("#btnBankThree").on("click",function(){	
		$(".btn").removeClass("current-button");
		$(this).addClass("current-button");
		if ($('#bank_name2').val()=="") {
			ShowErrorMsg("Error", "Select 1st, 2nd Account");
			return 0;
		};
		ShowModal("fin/try/bankbranch/index");
	});	

	function selectBank(el){  
		event.preventDefault(); 
		var branch = $(el).data("branch");
		$(".btn.current-button").closest("fieldset").find(".bank-code").val(branch.bankCode);
		$(".btn.current-button").closest("fieldset").find(".bank-name").val(branch.bankName);
		$(".btn.current-button").closest("fieldset").find(".bank-branch_code").val(branch.bankBranchCode);
		$(".btn.current-button").closest("fieldset").find(".bank-branch").val(branch.bankBranchName);
		HideModal('search-modal');	
		$(".btn").removeClass("current-button");
	};
	$("#btnEmployee").on("click",function(){
		var code = $('#company_code').val();	
		ShowModal("hrm/ed/employee/searchemployeeshow?action_type_code=SELECT&actioncallback=loadEmployee&company_code="+code);
	});
	function loadEmployee(empdata){ 
		event.preventDefault();
		var bank = JSON.parse(unescape(empdata));	
		$("#emp_code").val(bank.empCode);	
		$("#emp_name").val(bank.empName);			
		HideModal('search-modal');	
	}

	$("#btnEmployeeBank").on("click",function(){	
		ShowModal("fin/try/bankaccount/searchbankaccountshow?action_type_code=SELECT&actioncallback=loadEmployeeBank");
	});

	function loadEmployeeBank(bankdata){ 
		event.preventDefault();
		var bank = JSON.parse(unescape(bankdata));	
		$("#emp_bank_code1").val(bank.bankCode);
		$("#emp_bank_name1").val(bank.bankName);
		$("#emp_branch_code1").val(bank.bankBranchCode);			
		$("#emp_branch_name1").val(bank.bankBranchName);

		$("#emp_bank_acc_no1").val(bank.bankAccountNo);		
		$("#emp_bank_acc_name1").val(bank.bankAccountName);
		HideModal('search-modal');	
	}
	$("#btnEmployeeBank2").on("click",function(){	
		ShowModal("fin/try/bankaccount/searchbankaccountshow?action_type_code=SELECT&actioncallback=loadEmployeeBank2");
	});

	function loadEmployeeBank2(bankdata){ 
		event.preventDefault();
		var bank = JSON.parse(unescape(bankdata));
		$("#emp_bank_code2").val(bank.bankCode);	
		$("#emp_bank_name2").val(bank.bankName);	
		$("#emp_branch_code2").val(bank.bankBranchCode);		
		$("#emp_branch_name2").val(bank.bankBranchName);
		$("#emp_bank_acc_no2").val(bank.bankAccountNo);		
		$("#emp_bank_acc_name2").val(bank.bankAccountName);
		HideModal('search-modal');	
	}

	$("#btnEmployeeBank3").on("click",function(){	
		ShowModal("fin/try/bankaccount/searchbankaccountshow?action_type_code=SELECT&actioncallback=loadEmployeeBank3");
	});

	function loadEmployeeBank3(bankdata){ 
		event.preventDefault();
		var bank = JSON.parse(unescape(bankdata)); 
		$("#emp_bank_code3").val(bank.bankCode);		
		$("#emp_bank_name3").val(bank.bankName);	
		$("#emp_branch_code3").val(bank.bankBranchCode);		
		$("#emp_branch_name3").val(bank.bankBranchName);
		$("#emp_bank_acc_no3").val(bank.bankAccountNo);		
		$("#emp_bank_acc_name3").val(bank.bankAccountName);
		HideModal('search-modal');	
	}



