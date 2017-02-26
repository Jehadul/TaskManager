


$("#btnBranch").on("click",function(){	
	ShowModal("/searchbranch/?action_type_code=SELECT&actioncallback=loadBranch");
});

function loadBranch(branchdata){
	event.preventDefault();
	var branch = JSON.parse(unescape(branchdata));
	$("#branch_code").val(branch.branch_code);		
	$("#branch_name").val(branch.branch_name);	
	$("#company_code").val(branch.company_code);	
	$("#company_name").val(branch.company_name);	
	HideModal('search-modal');	
}



$("#btnRM").on("click",function(){	
	ShowModal("/searchemployee/?action_type_code=SELECT&actioncallback=loadRM");
});

function loadRM(empdata){
	event.preventDefault();
	var emp = JSON.parse(unescape(empdata));
	$("#rm_code").val(emp.emp_code);		
	$("#rm_name").val(emp.emp_name);	
	$("#rm_desig").val(emp.desig);	
	$("#rm_email").val(emp.email);	
	$("#rm_username").val(emp.username);	
	$("#rm_mobile").val(emp.mobile);	
	HideModal('search-modal');	
}


$("#btnJobRole").on("click",function(){	
	ShowModal("/searchhrrole/?action_type_code=SELECT&actioncallback=loadJobRole");
});



function loadJobRole(jobroledata){
	event.preventDefault();
	var jobRole = JSON.parse(unescape(jobroledata));
	$("#role_code").val(jobRole.role_code);		
	$("#role_name").val(jobRole.role_name);	
	HideModal('search-modal');	
}


$("#btnJob").on("click",function(){	
	ShowModal("/searchjob/?action_type_code=SELECT&actioncallback=loadJob");
});



function loadJob(jobroledata){
	event.preventDefault();
	var job = JSON.parse(unescape(jobdata));
	$("#job_code").val(job.job_code);		
	$("#job_name").val(job.job_name);	
	HideModal('search-modal');	
}
$("#btnCostCenter").on("click",function(){	
	ShowModal("/searchcostcenter/?action_type_code=SELECT&actioncallback=loadCostCenter");
});

function loadCostCenter(ccdata){
	event.preventDefault();
	var cc = JSON.parse(unescape(ccdata));
	$("#cost_center_code").val(cc.costcenter_code);		
	$("#cost_center_name").val(cc.costcenter_name);	
	$("#profit_center_code").val(cc.profitcenter_code);	
	$("#profit_center_name").val(cc.profitcenter_name);	
	HideModal('search-modal');	
}


$("#btnDepartment").on("click",function(){	
	ShowModal("/searchdepartment/?action_type_code=SELECT&actioncallback=loadDepartment");
});

function loadDepartment(departmentdata){
	event.preventDefault();
	var department = JSON.parse(unescape(departmentdata));
	$("#department_code").val(department.department_code);		
	$("#department_name").val(department.department_name);	
	$("#division_code").val(department.division_code);	
	$("#division_name").val(department.division_name);	
	HideModal('search-modal');	
}


$("#btnLocation").on("click",function(){	
	ShowModal("/searchlocation/?action_type_code=SELECT&actioncallback=loadLocation");
});

function loadLocation(locationdata){
	event.preventDefault();
	var location = JSON.parse(unescape(locationdata));
	$("#location_code").val(location.location_code);		
	$("#location_name").val(location.location_name);	
	HideModal('search-modal');	
}


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


$("#btnLevel").on("click",function(){	
	ShowModal("/searchlevel/?action_type_code=SELECT&actioncallback=loadLevel");
});

function loadLevel(leveldata){
	event.preventDefault();
	var level = JSON.parse(unescape(leveldata));
	$("#level_code").val(level.level_code);		
	$("#level_name").val(level.level_name);	
	HideModal('search-modal');	
}

$("#first_name").keyup(function (e) {
	generateFullName($("#first_name").val(), $("#middle_name").val(), $("#last_name").val());
});

$("#middle_name").keyup(function (e) {
	generateFullName($("#first_name").val(), $("#middle_name").val(), $("#last_name").val());
});

$("#last_name").keyup(function (e) {
	generateFullName($("#first_name").val(), $("#middle_name").val(), $("#last_name").val());
});

function generateFullName(first_name, middle_name, last_name) {
	var full_name =  first_name + ' ' + middle_name + ' ' + last_name;
		$("#emp_name").val(full_name); 
}

$(".btn-back").on("click",function(){
		swal({
		title: "Are you sure to back to menu?",
		text: "This will discard all data you entered.",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#007AFF",
		confirmButtonText: "Yes, cancel the wizard!",
		closeOnConfirm: true
	}, function() {
		LoadMainContent('toc?type=privgrp&privgrp=3&currmodcode=VLC');
	});

});

function showMessage(data) {
	if(data.outcome == 'success'){
		ShowSuccessMsg('Employee created', data.msg);
		LoadMainContent('/employee/' + data.id + '?mode=' + data.mode);
	}
	else{
		ShowErrorMsg('Employee was not created', data.msg);
		var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
	}
}

function validateStep(stepNumber){
	SyncOptionText();
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


	if($(".photo .fileinput-preview img").length > 0){
		$(".photo4 img").prop("src", $(".photo .fileinput-preview img").prop("src" ));
	}
	else{
		$(".photo4 img").prop("src", $(".photo .fileinput-new img").prop("src" ));
	}

	if($(".signature .fileinput-preview img").length > 0){
		$(".signature4 img").prop("src", $(".signature .fileinput-preview img").prop("src" ));
	}
	else{
		$(".signature4 img").prop("src", $(".signature .fileinput-new img").prop("src" ));
	}

	if($(".initial .fileinput-preview img").length > 0){
		$(".initial4 img").prop("src", $(".initial .fileinput-preview img").prop("src" ));
	}
	else{
		$(".initial4 img").prop("src", $(".initial .fileinput-new img").prop("src" ));
	}   	
}



var addRowSite = function(el){
	$("#SupplierSites tbody").append(
		'<tr>' +
			'<td>' + 
				'<input name="site_id[]" type="hidden" class="site-id form-control" value="" />' +
				'<input name="site_code[]" type="text" class="site-code form-control" value="" />' +
			'</td>' +
			'<td><input name="site_name[]" type="text" class="site-name form-control" value="" /></td>' +
			'<td><input name="site_hq[]" type="radio" class="control-label" value="Y"  />' + 
			     '<input name="site_hq[]" type="hidden" class="control-label" value="N"  />' + 
			'</td>' +
			'<td><input name="site_address[]" type="text" class="form-control" value="" /></td>' +
			'<td><input name="site_division[]" type="text" class="form-control" value="" /></td>' +
			'<td><input name="site_district[]" type="text" class="form-control" value="" /></td>' +
			'<td><input name="site_contract[]" type="text" class="remarks form-control" value="" /></td>' +
			'<td>'+ currHtml +'<input name="site_currency_name[]" type="hidden" value="" /> </td>' +
			'<td>'+ payMethodHtml +'<input name="site_payment_method_name[]" type="hidden" value="" /> </td>' +
			'<td class="width-80">' +
				'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
				'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
				'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
			'</td>' +
		'</tr>'
	);
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
	});
};

var upRow = function(el){
    var row = $(el).closest("tr");
	row.insertBefore(row.prev());
};

var downRow = function(el){
    var row = $(el).closest("tr");
	row.insertAfter(row.next());
};

$(".btn-add").on("click", addRowSite);

for (var i = 0; i < 1; i++) {
	if(rowSuppSite == 0) {
		addRowSite();
	}
};

InitResizableTable('#SupplierSites');


var addRowAcc = function(el){
	$("#SupplierAccounts tbody").append(
		'<tr>' +
			'<td>'+ coyHtml +'<input name="acc_company_name[]" type="hidden" value="" /> <input name="supp_account_id[]" type="hidden" value="" /></td>' +
			'<td>' + 
				'<input name="recon_account_code[]" type="text"  onclick="searchReconAcc(this);" class="recon-account-code form-control search" value=""  readonly="readonly"/>' +
			'</td>' +
			'<td><input name="recon_account_name[]" type="text" class="recon-account-name form-control" value="" readonly="readonly" /></td>' +
			'<td>' + 
				'<input name="advance_account_code[]" type="text" onclick="searchAdvAcc(this);" class="advance-account-code form-control search" value=""  readonly="readonly"/>' +
			'</td>' +
			'<td><input name="advance_account_name[]" type="text" class="advance-account-name form-control" value="" readonly="readonly" /></td>' +
			'<td class="width-80">' +
				'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
				'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
				'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
			'</td>' +
		'</tr>'
	);
};

$(".btn-add-acc").on("click", addRowAcc);

for (var i = 0; i < 1; i++) {
	if(rowSuppAcc == 0) {
		addRowAcc();
	}
};


var addRowItem = function(el){
	$("#ApprovedItems tbody").append(
		'<tr>' +
			'<td>' + 
				'<input name="item_cat_code[]" type="text" onfocus="searchAcc(this);" onclick="searchAcc(this);" class="account-code form-control search" value=""  readonly="readonly"/>' +
			'</td>' +
			'<td><input name="item_code[]" type="text" class="item-code form-control" value="" readonly="readonly" /></td>' +
			'<td><input name="item_name[]" type="text" class="item-name form-control" value="" readonly="readonly" /></td>' +
			'<td class="width-80">' +
				'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
				'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
				'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
			'</td>' +
		'</tr>'
	);
};

$(".btn-add-item").on("click", addRowItem);

for (var i = 0; i < 1; i++) {
	addRowItem();
};

InitResizableTable('#ApprovedItems');

var addRowPrcItem = function(el){
	$("#PricingItems tbody").append(
		'<tr>' +
			'<td>' + 
				'<input name="account_code[]" type="text" onfocus="searchAcc(this);" onclick="searchAcc(this);" class="account-code form-control search" value=""  readonly="readonly"/>' +
			'</td>' +
			'<td><input name="account_name[]" type="text" class="account-name form-control" value="" readonly="readonly" /></td>' +
			'<td><input name="trans_currency_dr_amount[]" type="text" onchange="drchanged(this)" class="trans-currency-dr-amount form-control money" value="" min="0" /></td>' +
			'<td><input name="trans_currency_dr_amount[]" type="text" onchange="drchanged(this)" class="trans-currency-dr-amount form-control money" value="" min="0" /></td>' +
			'<td class="width-80">' +
				'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
				'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
				'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
			'</td>' +
		'</tr>'
	);
};

$(".btn-add-prc-item").on("click", addRowPrcItem);

for (var i = 0; i < 1; i++) {
	addRowPrcItem();
};