
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
		LoadMainContent('toc?type=privgrp&privgrp=3&currmodcode=CLC');
	});

});

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
	$("#CustomerSites tbody").append(
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
	if(rowCustSite == 0) {
		addRowSite();
	}
};

InitResizableTable('#CustomerSites');


var addRowAcc = function(el){
	$("#SupplierAccounts tbody").append(
		'<tr>' +
			'<td>'+ coyHtml +'<input name="acc_company_name[]" type="hidden" value="" /> <input name="cust_account_id[]" type="hidden" value="" /></td>' +
			'<td>' + 
				'<input name="recon_account_code[]" type="text"  onclick="searchReconAcc(this);" class="recon-account-code form-control search" value=""  readonly="readonly"/>' +
			'</td>' +
			'<td><input name="recon_account_name[]" type="text" class="recon-account-name form-control" value="" readonly="readonly" /></td>' +
			'<td>' + 
				'<input name="downpayment_account_code[]" type="text" onclick="searchDwnPayAcc(this);" class="downpayment-account-code form-control search" value=""  readonly="readonly"/>' +
			'</td>' +
			'<td><input name="downpayment_account_name[]" type="text" class="downpayment-account-name form-control" value="" readonly="readonly" /></td>' +
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
	if(rowCustAcc == 0) {
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

var addRowOrdInfo = function(el){
	$("#OrderInformations tbody").append(
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

$(".btn-add-ord-info").on("click", addRowOrdInfo);

for (var i = 0; i < 1; i++) {
	addRowOrdInfo();
};