var doaTypeOptionsHtml = '';
doaTypeOptionsHtml += '<option value="ALL">ALL</option>';
$.each(doaTypeData,function(i, item) 
{
    doaTypeOptionsHtml += '<option value="' + item.doaTypeCode + '"">' + item.doaTypeName + '</option>';
});

function showMessage(data) {
	$(".alert").html("");
	if(data.outcome == 'success'){
		ShowSuccessMsg('Workflow saved', data.msg);
		LoadMainContent('tna/wf/workflowmanager/show/' + data.id );
	}
	else{
		ShowErrorMsg('Workflow was not saved', data.message);
		$(".alert").removeClass("hidden");
/*		var msg = "";
		for (var i = 0; i < data.message.length; i++) {
			var field = data.error[i];
			msg += data.message[i] + '<br />';
		};*/
		$(".alert").html(data.message);
	}
}

function validate(){
	$(".alert").addClass("hidden");

	$("input[name='company_name']").val($("#company_code option:selected").text());
	$("input[name='object_type_name']").val($("#object_type_code option:selected").text());
	$("input[name='action_type_name']").val($("#action_type_code option:selected").text());
	$("input[name='doa_currency_name']").val($("#doa_currency_code option:selected").text());

	var result = CheckRequired('.main-control');
	var errorMsg = "Please check the required fields.";

	$.each($(".wf-step-list").find(".doer-code"), function(i, item){
		if (!$(item).val()) {
			result = false;
			MarkCross($(item).closest(".wf-step-list").find("tr:first th:nth-child(3)"), true);
		}
		else{
			MarkCross($(item).closest(".wf-step-list").find("tr:first th:nth-child(3)"), false);
		}
	});


	$.each($(".wf-step-list"), function(i, item){
		if(CheckDuplicate($(item).find("input.step-code"))){
			errorMsg = "Workflow step code must be unique";
			result = false;
		}		
	});

	if (!result) {
		InitHandlers();
		InitErrorChange();
		$(".alert").removeClass("hidden");
		ShowErrorMsg('Workflow was not created', errorMsg);
	}

	return result;
}


var addBlock = function(){
	var id = new Date().getTime();	
	var html = '' +
	'<div class="wf-block panel panel-light-grey" data-id="' + id + '">' +
		'<div class="panel-heading">' +
			'<h5 class="panel-title">' +
				'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#wf_block' + id + '">'+
					'<i class="icon-arrow"></i>' +
					'<span class="wf-block-title"> DOA Type: ALL, Limit: 0</span>' +
				'</a>' +
			'</h5>' +
		'</div>' +
		'<div id="wf_block' + id + '" class="panel-collapse collapse in">' +
			'<div class="panel-body">' +
				'<button class="btn btn-xs btn-red btn-o pull-right" onclick="delBlock(this);"><span class="fa fa-close"> Delete</span></button>' +
				'<div class="row">' +
					'<div class="col-md-4">' +
						'<label class="control-label">DOA Type</label>' +
						'<select class="form-control required doa-type" onchange="DoaChanged(this)">' +
							doaTypeOptionsHtml +
						'</select>' +
					'</div>' +								
					'<div class="col-md-3">' +
						'<label class="control-label">DOA Limit</label>'  +
						'<input type="number" value="999999999999" class="form-control doa-limit"  onchange="DoaChanged(this)" />' +
					'</div>' +
				'</div>' +
				'<div class="row margin-top-20">' +
					'<h4 class="margin-left-15">' +
						'Workflow Steps ' + 
						'<button class="btn btn-new btn-add-step btn-xs" onclick="addRow(this);">' +
							'<span class="fa fa-plus"></span>' + 
						'</button>' +
					'</h4>' +
				'</div>' +
				'<table class="wf-step-list table table-striped table-hover">' +
					'<thead>' +
						'<tr>' +
							'<th>Step Code</th>' +
							'<th>Step Name</th>' +
							'<th>Doer</th>' +
							'<th>Alt Doer</th>' +
							'<th>Action</th>' +
						'</tr>' +
					'</thead>' +
					'<tbody>' +
					'</tbody>' +
				'</table>' +
			'</div>' +
		'</div>' +
	'</div>';

	$("#WorkflowBlocks").append(html);

	html = '' +
	'<tr>' +
		'<td>SUBMISSION</td>' +
		'<td>Submission</td>' +
		'<td>Self</td>' +
		'<td>N/A</td>' +
		'<td>' + 
			'<input type="hidden" name="wf_block_id[]" class="wf-block-id" value="' + id + '" />' +
			'<input type="hidden" name="step_id[]" class="step-id" value="" />' +
			'<input type="hidden" name="step_code[]" class="step-code" value="SUBMISSION" />' +
			'<input type="hidden" name="step_name[]" class="step-name" value="Submission" />' +
			'<input type="hidden" name="step_descr[]" class="step-descr" value="Submission for approval" />' +
			'<input type="hidden" name="step_type[]" class="step-type" value="SUBMISSION" />' +
			'<input type="hidden" name="estimated_time[]" class="estimated-time" value="0" />' +
			'<input type="hidden" name="doer_code[]" class="doer-code" value="SELF" />' +
			'<input type="hidden" name="doer_name[]" class="doer-name" value="Self" />' +
			'<input type="hidden" name="doer_type[]" class="doer-type" value="SELF" />' +
			'<input type="hidden" name="doer_company_code[]" class="doer-company-code" value="" />' +
			'<input type="hidden" name="doer_company_name[]" class="doer-company-name" value="" />' +
			'<input type="hidden" name="alt_doer_code[]" class="alt-doer-code" value="" />' +
			'<input type="hidden" name="alt_doer_name[]" class="alt-doer-name" value="" />' +
			'<input type="hidden" name="alt_doer_type[]" class="alt-doer-type" value="" />' +
			'<input type="hidden" name="alt_doer_company_code[]" class="alt-doer-company-code" value="" />' +
			'<input type="hidden" name="alt_doer_company_name[]" class="alt-doer-company-name" value="" />' +
			'<input type="hidden" name="proxy_doer_enabled[]" class="proxy-doer-enabled" value="" />' +
			'<input type="hidden" name="doa_type_code[]" class="doa-type-code" value="ALL" />' +
			'<input type="hidden" name="doa_type_name[]" class="doa-type-name" value="ALL" />' +
			'<input type="hidden" name="doa_upper_limit[]" class="doa-upper-limit" value="999999999999" />' +
		'</td>' +
	'</tr>';
	$(".wf-step-list").last().find("tbody").append(html);

	html = '' +
	'<tr>' +
		'<td>APPROVAL</td>' +
		'<td>Approval</td>' +
		'<td></td>' +
		'<td></td>' +
		'<td>' + 
			'<button type="button" onclick="editRow(this);" class="btn btn-edit btn-xs"><span class="fa fa-edit"></span></button> ' + 

			'<input type="hidden" name="wf_block_id[]" class="wf-block-id" value="' + id + '" />' +
			'<input type="hidden" name="step_id[]" class="step-id" value="" />' +
			'<input type="hidden" name="step_code[]" class="step-code" value="APPROVAL" />' +
			'<input type="hidden" name="step_name[]" class="step-name" value="Approval" />' +
			'<input type="hidden" name="step_descr[]" class="step-descr" value="Workflow approval" />' +
			'<input type="hidden" name="step_type[]" class="step-type" value="APPROVAL" />' +
			'<input type="hidden" name="estimated_time[]" class="estimated-time" value="0" />' +
			'<input type="hidden" name="doer_code[]" class="doer-code" value="" />' +
			'<input type="hidden" name="doer_name[]" class="doer-name" value="" />' +
			'<input type="hidden" name="doer_type[]" class="doer-type" value="" />' +
			'<input type="hidden" name="doer_company_code[]" class="doer-company-code" value="" />' +
			'<input type="hidden" name="doer_company_name[]" class="doer-company-name" value="" />' +
			'<input type="hidden" name="alt_doer_code[]" class="alt-doer-code" value="" />' +
			'<input type="hidden" name="alt_doer_name[]" class="alt-doer-name" value="" />' +
			'<input type="hidden" name="alt_doer_type[]" class="alt-doer-type" value="" />' +
			'<input type="hidden" name="alt_doer_company_code[]" class="alt-doer-company-code" value="" />' +
			'<input type="hidden" name="alt_doer_company_name[]" class="alt-doer-company-name" value="" />' +
			'<input type="hidden" name="proxy_doer_enabled[]" class="proxy-doer-enabled" value="" />' +
			'<input type="hidden" name="doa_type_code[]" class="doa-type-code" value="ALL" />' +
			'<input type="hidden" name="doa_type_name[]" class="doa-type-name" value="ALL" />' +
			'<input type="hidden" name="doa_upper_limit[]" class="doa-upper-limit" value="999999999999" />' +
		'</td>' +
	'</tr>';
	$(".wf-step-list tbody tr:last").after(html);
};

var delBlock = function(el){
	if ($(".wf-block").length > 1) {
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this block?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
	    	$(el).closest(".wf-block").remove();
	    	calculateTat();
		});	
	}
	else{
		ShowErrorMsg("Only block","There must be a block at least");
	}
};

var addRow = function(el){
	$(".wf-block").removeClass("current-block");
	$(".wf-step-list tr").removeClass("current-row");
	$(el).closest(".wf-block").addClass("current-block");

	ResetInputs("#wfStepModal");

	$("#modal_doer_unit").closest("div").hide();
	$("#modal_doer_code").hide();
	$("#modal_doer_name").hide();
	$("#btnDoerFind").hide();

	$("#modal_alt_doer_unit").closest("div").hide();
	$("#modal_alt_doer_code").hide();
	$("#modal_alt_doer_name").hide();
	$("#btnAltDoerFind").hide();

	$("#REVIEW").prop("checked", true);
	$("#REVIEW").prop("disabled", false);
	$("#modal_proxy_doer_enabled").removeProp("checked");
	$("#modal_step_code").prop('readonly', false);

   	$("#wfStepModal").modal();
};

var editRow = function(el){
	$(".wf-block").removeClass("current-block");
	$(".wf-step-list tr").removeClass("current-row");
	$(el).closest(".wf-block").addClass("current-block");
	var currentRow = $(el).closest("tr");
	currentRow.addClass("current-row");

	ResetInputs("#wfStepModal");

	$("#modal_step_id").val(currentRow.find(".step-id").val());
	$("#modal_step_code").val(currentRow.find(".step-code").val());
	$("#modal_step_name").val(currentRow.find(".step-name").val());
	$("#modal_step_descr").val(currentRow.find(".step-descr").val());
	if (currentRow.find(".step-type").val() == "REVIEW") {
		$("#REVIEW").prop("checked", true);
	}
	else{
		$("#APPROVAL").prop("checked", true);
	}
	$("#modal_estimated_time").val(currentRow.find(".estimated-time").val());
	
	var doerType = currentRow.find(".doer-type").val();
	$("#modal_doer_type").val(doerType);
	if (doerType == "HRROLE") {
		$("#modal_doer_code").val(currentRow.find(".doer-code").val());
		$("#modal_doer_name").val(currentRow.find(".doer-name").val());
		$("#modal_doer_company_code").val(currentRow.find(".doer-company_code").val());
		$("#modal_doer_company_name").val(currentRow.find(".doer-company_name").val());
		$("#modal_doer_unit").closest("div").hide();
		$("#modal_doer_code").show();
		$("#modal_doer_name").show();
		$("#btnDoerFind").show();
	}
	else if(doerType == "UNIT")
	{
		$("#modal_doer_unit").val(currentRow.find(".doer-code").val());
		$("#modal_doer_unit").closest("div").show();
		$("#modal_doer_code").hide();
		$("#modal_doer_name").hide();
		$("#btnDoerFind").hide();
	}
	else
	{
		$("#modal_doer_unit").closest("div").hide();
		$("#modal_doer_code").hide();
		$("#modal_doer_name").hide();
		$("#btnDoerFind").hide();
	}

	var altDoerType = currentRow.find(".alt-doer-type").val();
	$("#modal_alt_doer_type").val(altDoerType);
	if (altDoerType == "HRROLE") {
		$("#modal_alt_doer_code").val(currentRow.find(".alt-doer-code").val());
		$("#modal_alt_doer_name").val(currentRow.find(".alt-doer-name").val());
		$("#modal_alt_doer_company_code").val(currentRow.find(".alt-doer-company_code").val());
		$("#modal_alt_doer_company_name").val(currentRow.find(".alt-doer-company_name").val());
		$("#modal_alt_doer_unit").closest("div").hide();
		$("#modal_alt_doer_code").show();
		$("#modal_alt_doer_name").show();
		$("#btnAltDoerFind").show();
	}
	else if(altDoerType == "UNIT")
	{
		$("#modal_alt_doer_unit").val(currentRow.find(".alt-doer-code").val());
		$("#modal_alt_doer_unit").closest("div").show();
		$("#modal_alt_doer_code").hide();
		$("#modal_alt_doer_name").hide();
		$("#btnAltDoerFind").hide();
	}
	else
	{
		$("#modal_alt_doer_unit").closest("div").hide();
		$("#modal_alt_doer_code").hide();
		$("#modal_alt_doer_name").hide();
		$("#btnAltDoerFind").hide();
	}
	if(currentRow.find(".proxy-doer-enabled").val() == true){
		$("#modal_proxy_doer_enabled").prop("checked", "checked");
	}

	if(currentRow.next("tr").length == 0){
		$("#modal_step_code").prop('readonly', true);
		$("#REVIEW").prop("disabled", true);
	}
	else {
		$("#modal_step_code").attr('readonly', false);
		$("#REVIEW").prop("disabled", false);
	}

	$("#wfStepModal").modal('show');
};

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



$("#btnOk").on("click", function(){
	var result = true;

	result = CheckRequired(".modal-body");

	var stepCode = $("#modal_step_code").val();
	var stepName = $("#modal_step_name").val();

	var stepType = "REVIEW";
	if ($("#APPROVAL").prop("checked")) {
		stepType = "APPROVAL";
	}

	var doerCode = "";
	var doerName = "";
	var doerCompanyCode = "";
	var doerCompanyName = "";
	var doerType = $("#modal_doer_type").val();

	if (doerType == "HRROLE") {
		doerCode = $("#modal_doer_code").val(); 
		doerName = $("#modal_doer_name").val(); 
		doerCompanyCode = $("#modal_doer_company_code").val(); 
		doerCompanyName = $("#modal_doer_company_name").val(); 
	}
	else if(doerType == "UNIT")
	{
		doerCode = $("#modal_doer_unit").val();
		doerName = $("#modal_doer_unit option:selected").text();
	}
	else if(doerType == "RM"){
		doerCode = "RM";
		doerName = "Reporting Manager";
	}
	else if(doerType == "SELF"){
		doerCode = "SELF";
		doerName = "Self";
	}

	var altDoerCode = "";
	var altDoerName = "";
	var altDoerCompanyCode = "";
	var altDoerCompanyName = "";
	var altDoerType = $("#modal_alt_doer_type").val();
	
	if (altDoerType == "HRROLE") {
		altDoerCode = $("#modal_alt_doer_code").val(); 
		altDoerName = $("#modal_alt_doer_name").val(); 
		altDoerCompanyCode = $("#modal_alt_doer_company_code").val(); 
		altDoerCompanyName = $("#modal_alt_doer_company_name").val(); 
	}
	else if(altDoerType == "UNIT")
	{
		altDoerCode = $("#modal_alt_doer_unit").val();
		altDoerName = $("#modal_alt_doer_unit option:selected").text();
	}
	else if(altDoerType == "RM"){
		altDoerCode = "RM";
		altDoerName = "Reporting Manager";
	}
	else if(altDoerType == "SELF"){
		altDoerCode = "SELF";
		altDoerName = "Self";
	}

	if (!doerCode) {
		$("#modal_doer_type").closest("div").prev("div").find("label span").remove();
		$("#modal_doer_type").closest("div").prev("div").find("label").append('<span>&nbsp;&nbsp;</span><span class="text-red fa fa-close"></span>');
		result = false;
	}

	if (altDoerType && !altDoerCode) {
		$("#modal_alt_doer_type").closest("div").prev("div").find("label span").remove();
		$("#modal_alt_doer_type").closest("div").prev("div").find("label").append('<span>&nbsp;&nbsp;</span><span class="text-red fa fa-close"></span>');
		result = false;
	}

	if (!result) {
		InitHandlers();
		InitErrorChange();
		return;
	}

	if ($(".current-block .wf-step-list tr.current-row").length == 0 ) {
		$(".current-block .wf-step-list tr:last").before('<tr class="current-row"></tr>');
	}

	var blockId = $(".current-block").data("id");
	var doaTypeCode = $(".current-block").find(".doa-type").val();
	var doaTypeName = $(".current-block").find(".doa-type option:selected").text();
	var doaUpperLimit = $(".current-block").find(".doa-limit").val();

	$(".current-block .wf-step-list tr.current-row").html(
		'<td>' + stepCode + '</td>' +
		'<td>' + stepName + '</td>' +
		'<td>' + doerName + '</td>' +
		'<td>' + altDoerName + '</td>' +
		'<td>' + 
			'<button type="button" onclick="editRow(this);" class="btn btn-edit btn-xs"><span class="fa fa-edit"></span></button> ' + 
			'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button> ' + 
			'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button> ' + 
			'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>' +

			'<input type="hidden" name="wf_block_id[]" class="wf-block-id" value="' + blockId + '" />' +
			'<input type="hidden" name="step_id[]" class="step-id" value="' + $("#modal_step_id").val() + '" />' +
			'<input type="hidden" name="step_code[]" class="step-code" value="' + stepCode + '" />' +
			'<input type="hidden" name="step_name[]" class="step-name" value="' + stepName + '" />' +
			'<input type="hidden" name="step_descr[]" class="step-descr" value="' + $("#modal_step_descr").val() + '" />' +
			'<input type="hidden" name="step_type[]" class="step-type" value="' + stepType + '" />' +
			'<input type="hidden" name="estimated_time[]" class="estimated-time" value="' + $("#modal_estimated_time").val() + '" />' +
			'<input type="hidden" name="doer_code[]" class="doer-code" value="' + doerCode + '" />' +
			'<input type="hidden" name="doer_name[]" class="doer-name" value="' + doerName + '" />' +
			'<input type="hidden" name="doer_company_code[]" class="doer-company-code" value="' + doerCompanyCode + '" />' +
			'<input type="hidden" name="doer_company_name[]" class="doer-company-name" value="' + doerCompanyName + '" />' +
			'<input type="hidden" name="doer_type[]" class="doer-type" value="' + doerType + '" />' +
			'<input type="hidden" name="alt_doer_code[]" class="alt-doer-code" value="' + altDoerCode + '" />' +
			'<input type="hidden" name="alt_doer_name[]" class="alt-doer-name" value="' + altDoerName + '" />' +
			'<input type="hidden" name="alt_doer_company_code[]" class="alt-doer-company-code" value="' + altDoerCompanyCode + '" />' +
			'<input type="hidden" name="alt_doer_company_name[]" class="alt-doer-company-name" value="' + altDoerCompanyName + '" />' +
			'<input type="hidden" name="alt_doer_type[]" class="alt-doer-type" value="' + altDoerType + '" />' +
			'<input type="hidden" name="proxy_doer_enabled[]" class="proxy-doer-enabled" value="' + $("#modal_proxy_doer_enabled").prop("checked") + '" />' +
			'<input type="hidden" name="doa_type_code[]" class="doa-type-code" value="' + doaTypeCode + '" />' +
			'<input type="hidden" name="doa_type_name[]" class="doa-type-name" value="' + doaTypeName + '" />' +
			'<input type="hidden" name="doa_upper_limit[]" class="doa-upper-limit" value="' + doaUpperLimit + '" />' +
		'</td>'
	);

	$(".wf-block").removeClass("current-block");
	$(".wf-step-list tr").removeClass("current-row");
	$("#wfStepModal").modal("hide");

	calculateTat();

	removeStepButtons();
});


$("#btnCancel").on("click", function(){
	$(".wf-block").removeClass("current-block");
	$(".wf-step-list tr").removeClass("current-row");

	$("#wfStepModal").modal("hide");
});

var removeStepButtons =function (){
	$(".wf-step-list").find("tr:nth-child(1) button").remove();
	$(".wf-step-list").find("tr:last button:not(.btn-edit)").remove();
}

$("#modal_doer_type").on("change", function(){
	if ($(this).val() == "UNIT") {
		$("#modal_doer_unit").closest("div").show();
		$("#modal_doer_code").hide();
		$("#modal_doer_name").hide();
		$("#btnDoerFind").hide();
	}
	else if ($(this).val() == "HRROLE") {
		$("#modal_doer_unit").closest("div").hide();
		$("#modal_doer_code").show();
		$("#modal_doer_name").show();
		$("#btnDoerFind").show();
	}
	else {
		$("#modal_doer_unit").closest("div").hide();
		$("#modal_doer_code").hide();
		$("#modal_doer_name").hide();
		$("#btnDoerFind").hide();
	}
});

$("#modal_alt_doer_type").on("change", function(){
	if ($(this).val() == "UNIT") {
		$("#modal_alt_doer_unit").closest("div").show();
		$("#modal_alt_doer_code").hide();
		$("#modal_alt_doer_name").hide();
		$("#btnAltDoerFind").hide();
	}
	else if ($(this).val() == "HRROLE") {
		$("#modal_alt_doer_unit").closest("div").hide();
		$("#modal_alt_doer_code").show();
		$("#modal_alt_doer_name").show();
		$("#btnAltDoerFind").show();
	}
	else{
		$("#modal_alt_doer_unit").closest("div").hide();
		$("#modal_alt_doer_code").hide();
		$("#modal_alt_doer_name").hide();
		$("#btnAltDoerFind").hide();
	}
});

var calculateTat = function(){
	var sumEtc = [];
	$.each($(".wf-step-list"), function(i, item){
		var blockEtcSum = 0.0;
		$(item).find(".estimated-time").each(function() {
    		blockEtcSum += parseFloat($(this).val());
		});
		sumEtc.push(blockEtcSum);
	});
	$("#tat").val(Math.max(sumEtc)); 
};

$("#btnDoerFind").on("click",function(){	
	ShowModal("hrm/ed/hrrole/searchhrroleshow?action_type_code=SELECT&actioncallback=loadDoer");
});

var loadDoer = function(roledata){
	var role = JSON.parse(unescape(roledata));
	$("#modal_doer_code").val(role.roleCode);		
	$("#modal_doer_name").val(role.roleName);	
	$("#modal_doer_company_code").val(role.companyCode);	
	$("#modal_doer_company_name").val(role.companyName);	
	HideModal('search-modal');	
};


$("#btnAltDoerFind").on("click",function(){	
	ShowModal("hrm/ed/hrrole/searchhrroleshow?action_type_code=SELECT&actioncallback=loadAltDoer");
});

var loadAltDoer = function(roledata){
	var role = JSON.parse(unescape(roledata));
	$("#modal_alt_doer_code").val(role.roleCode);		
	$("#modal_alt_doer_name").val(role.roleName);	
	$("#modal_alt_doer_company_code").val(role.companyCode);	
	$("#modal_alt_doer_company_name").val(role.companyName);	
	HideModal('search-modal');	
};

var DoaChanged = function(el){
	var currentBlock = $(el).closest(".wf-block");
	var doaTypeCode = currentBlock.find(".doa-type").val();
	var doaTypeName = currentBlock.find(".doa-type option:selected").text();
	var doaUpperLimit = currentBlock.find(".doa-limit").val();
	var title = " DOA Type: " + doaTypeName + ", Limit: " + doaUpperLimit;
	currentBlock.find(".wf-block-title").text(title);
	currentBlock.find(".doa-type-code").val(doaTypeCode);
	currentBlock.find(".doa-type-name").val(doaTypeName);
	currentBlock.find(".doa-upper-limit").val(doaUpperLimit);
};

var loadActionTypes = function(){
	curObj = $("#object_type_code").val();
	$('#action_type_code').empty();
	$.each(actionData[curObj],function(i, item) 
	{
	    $("#action_type_code").append('<option value="' + item + '">' + item + '</option>');
	});
};

$('#object_type_code').on('change', loadActionTypes);

$('#company_code').on('change', function(){
	swal({
		title: "Are you sure?",
		text: "This will reload the page?",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#007AFF",
		confirmButtonText: "Yes, reload!",
		closeOnConfirm: true
	}, function() {
    	var newCompanyCode = $("#company_code").val(); 
    	LoadMainContent("tna/wf/workflowmanager/create?company_code=" + newCompanyCode);
	});

});

$(".btn-add-block").on("click", addBlock);