InitHandlers();
	DataGrid();
	
	$("#entry_method,#controlling_component_name,#multiplication_fact,#extra_amount").on("change", function(){
	 	if($("#entry_method").val()=="Dependent"){ 
	 		$("#controlling_component_name").prop("disabled", false);
	 		$("#extra_amount").removeAttr("readonly","readonly");
	 		$("#multiplication_fact").removeAttr("readonly","readonly")
	 		var equation =$("#salary_component_name").val()+"="+ $("#multiplication_fact").val()+"%"+ $("#controlling_component_name").val() +"+"+ $("#extra_amount").val();
	 		var y = $("#salary_component_name").val(); //alert(y);
	 		var x = $("#controlling_component_name").val();
	 		var m = $("#multiplication_fact").val();
	 			if(m.length == 0){
	 				m = "0";
	 			}
	 		var c = $("#extra_amount").val();
	 		if(c.length == 0){
	 				c = "0";
	 			}
	 		var equation = y +" = " +m +" % of "+ x +" + "+ c;
	 		$("#resulting_equation").val(equation);	
	 	}else {
	 		$("#multiplication_fact").val(0);
	 		$("#extra_amount").val(0);

	 		$("#controlling_component_name").prop("disabled", true);
	 		$("#extra_amount").attr("readonly","readonly");
	 		$("#multiplication_fact").attr("readonly","readonly");
	 	}

	 	for (var i = 0; i < salaryComponents.length; i++) {
	 		if (salaryComponents[i].salary_component_name == $("#salary_component_name").val()) {
	 			$("#salary_component_code").val(salaryComponents[i].salary_component_code);
	 		}
	 	}
	});


/*-----------------------------------------------------------------------------------------------*/
	$(".btn-add").on("click", function(){
		$("tr").removeClass("current-row");
		$("#LevelModal").modal();
		ResetInputs("#LevelModal");
		$(".modal-backdrop.in").off();
	});
	$(".btn-close, .btn-cancel").on("click", function(){
	 	$("#controlling_component_name").prop("disabled", false);
	 	$("#extra_amount").removeAttr("readonly","readonly");
	 	$("#multiplication_fact").removeAttr("readonly","readonly")		
		$("#LevelModal").modal("hide");
		$("tr").removeClass("current-row");
	});
	$(".btn-edit").on("click", editRow);

	var editRow = function(){
		var currentRow = $(this).closest("tr");
		$("tr").removeClass("current-row");
		currentRow.addClass("current-row");
		$('#salary_component_name').val(currentRow.find(".salary-component-name").val());
		$('#controlling_component_name').val(currentRow.find(".controlling-component-name").val());
		$('#entry_method').val(currentRow.find(".entry-method").val());

		$('#multiplication_fact').val(currentRow.find(".multiplication-fact").val());
		$('#extra_amount').val(currentRow.find(".extra-amount").val());
		$('#resulting_equation').val($(".current-row").find(".resulting-equation").val());

		$("#LevelModal").modal();
		$(".modal-backdrop.in").off();
	};

	$(".btn-ok").on("click", function(){
		if ($(".current-row").length == 0 ) {
			$("#LevelTable tbody").append('<tr class="current-row"></tr>');
		}

		var html = '' +
				'<td class="width-80">' + $('#salary_component_code').val() + '</td>' +
			/*	'<td>' + $('#controlling_component_name').val() + '</td>' +*/
				'<td>' + $('#resulting_equation').val() + '</td>' +
				'<td class="align-center">' +
					'<input name="salary_component_name[]" type="hidden" class="salary-component-name"  value="' + $('#salary_component_name').val() + '" />' +
					'<input name="controlling_component_name[]" type="hidden" class="controlling-component-name" value="' + $('#controlling_component_name').val() + '" />' +
					'<input name="entry_method[]" type="hidden" class="entry-method" value="' + $('#entry_method').val() + '" />' +
					'<input name="multiplication_fact[]" type="hidden" class="multiplication-fact" value="' + $('#multiplication_fact').val() + '" />' +
					'<input name="extra_amount[]" type="hidden" class="extra-amount" value="' + $('#extra_amount').val() + '" />' +
					'<input name="resulting_equation[]" type="hidden" class="resulting-equation" value="' + $('#resulting_equation').val() + '" />' +
					
					'<button type="button" onclick="editRow(this);" class="btn btn-edit btn-xs"><span class="fa fa-edit"></span></button> ' + 
					'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button> ' + 
					'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button> ' + 
					'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>' +
				'</td>' ;
		

		$("#LevelTable .current-row").html(html);
		$("#controlling_component_name").prop("disabled", false);
	 	$("#extra_amount").removeAttr("readonly","readonly");
	 	$("#multiplication_fact").removeAttr("readonly","readonly")
		$("tr").removeClass("current-row");

		$(".btn-edit").off().on("click", editRow);
		$("#LevelModal").modal("hide");
	});

/*-------------------------------------------------------*/



	function DataGrid(){ 
		var html = "";
		var nameArray = "";
		for (var i = 0 ; i < salcoFormula.length; i++) {
			var code  = salcoFormula[i].salary_component_code;
			var name  = salcoFormula[i].salary_component_name;
			var equation = salcoFormula[i].resulting_equation;
			var controlling = salcoFormula[i].controlling_component_name;
			var entry = salcoFormula[i].entry_method;
			var multiplication = salcoFormula[i].multiplication_fact;
			var extra = salcoFormula[i].extra_amount;
		
			html += "" +
			'<tr>' +
			'<td class="width-80"> <input name="salary_component_code[]" type="text" class="form-control number"  readonly value="'+ code+'" /></td>' +
			'<td> <input name="resulting_equation[]" type="text" class="form-control number" readonly  value="'+ equation +'" /></td>' +
			
			'<td class="align-center">' +
					'<button type="button" onclick="editRow(this);" class="btn btn-edit btn-xs"><span class="fa fa-edit"></span></button> ' + 
					'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button> ' + 
					'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button> ' + 
					'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>' +
					
					'<input name="salary_component_name[]" type="hidden" class="salary-component-name" value="' +name + '" />' +
					'<input name="controlling_component_name[]" type="hidden" class="controlling-component-name" value="' + controlling + '" />' +
					'<input name="resulting_equation[]" type="hidden" class="resulting-equation" value="' + equation + '" />' +
					'<input name="entry_method[]" type="hidden" class="entry-method" value="' + entry + '" />' +
					'<input name="multiplication_fact[]" type="hidden" class="multiplication-fact" value="' + multiplication + '" />' +
					'<input name="extra_amount[]" type="hidden" class="extra-amount" value="' + extra + '" />' +
				'</td>'+
			'</tr>';
		}
		$("#LevelTable tbody").html(html);
		$("tr").removeClass("current-row");

		$(".btn-edit").off().on("click", editRow);
		$("#LevelModal").modal("hide");
	}

	var delRow = function(el){
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this step?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
	    	$(el).closest("tr").remove();
	    	calculateTat();
		});
	};

	var upRow = function(el){
	    var row = $(el).closest("tr");
	    if (row.prev().find("td:first").text() != "SUBMISSION") {
	    	row.insertBefore(row.prev());
		}
	};
	var downRow = function(el){
	    var row = $(el).closest("tr");
	    if (row.next().find("td:first").text() != "APPROVAL") {
	    	row.insertAfter(row.next());
		}        
	};
	$("#company_code").on('change',function(){
		var newCompanyCode = $("#company_code").val();	//alert(newCompanyCode);
		LoadMainContent("/salarycomponentformula/create/?company_code=" + newCompanyCode);
	});	
	function showMessage(data) {
		if(data.outcome == 'success'){
    		ShowSuccessMsg('Company Bank Account created', data.msg);
    		LoadMainContent('/salarycomponentformula/' + data.id + '?mode=' + data.mode);
    	}
    	else{
    		ShowErrorMsg('salary component formula was not created', data.msg);
   			var msg = ConcatWithBR(data.error);
   			$(".alert").html(msg);
   			$(".alert").removeClass("hidden");
    	}
    }