var modalUrl = "";
var mainContentUrl = "";
$.mask.definitions["9"] = null;
$.mask.definitions["#"] = "[0-9]";
var isDirty = false;

function ShowModal(url, sizeClass, idClass)
{
	if (!sizeClass) {
		sizeClass = 'modal-md';
	}
	if (!idClass) {
		idClass = 'search-modal';
	}

	$("." + idClass).find('.modal-body').html('Loading...');
	if ($("." + idClass).length == 0 ) {
		var html = '';
		html += '<div class="modal fade ' + idClass + '" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" style="display: none;">';
		html += '	<div class="modal-dialog ' + sizeClass + '">';
		html += '		<div class="modal-content">';
		html += '			<div class="modal-header">';
		html += '				<button type="button" class="close text-red" data-dismiss="modal" aria-label="Close">';
		html += '					<span aria-hidden="true">x</span>';
		html += '				</button>';
		html += '				<h4 class="modal-title"></h4>';
		html += '			</div>';
		html += '			<div class="modal-body"></div>';
		html += '		</div>';
		html += '	</div>';
		html += '</div>';
		$('body').append(html);
	}

	$("." + idClass).find('.modal-body').load(url, function(){
		var title = $("." + idClass + " .modal-body .mainTitle").text();
		$("." + idClass + " .modal-body #page-title").hide();
		$("." + idClass + " .modal-title").text(title);
		$("." + idClass).modal();
		$(".modal-backdrop.fade.in").off("click");
		$(".modal").off("keydown");
	});

	modalUrl = url;
}

function SyncOptionText(selector){

	if (!selector) {
		selector = ".main-content"
	}

	$(selector).find("select.sync-option-text").each(function(i, item){
	    var target = $(item).next("input[type='hidden']");
	    target.val($(item).find("option:selected").text());
	});
}


function CheckRequired(selector){
	result = true;

	if (!selector) {
		selector = ".main-content"
	}

	$(selector).find("input.required, select.required, textarea.required").each(function(i, item){
		$(this).removeClass("error");
		MarkCross($(this).closest(".form-group").find("label"), false);
		if ($(item).val().trim() == "") {
			result = false;
			$(this).addClass("error");
			MarkCross($(this).closest(".form-group").find("label"), true);
		}
	});
	
	return result;
}

function MarkCross(selector, invalid){
	$(selector).find("span").remove();

	if (invalid) {
		$(selector).append('<span>&nbsp;&nbsp;</span><span class="text-red fa fa-close"></span>');
	}
	else{
		$(selector).append('<span>&nbsp;&nbsp;</span><span class="text-green fa fa-check"></span>');
	}
}



function FocusError(){
	var firstErrorEl = $($(".error")[0]);
	firstErrorEl.focus();
	$().animate({
	    scrollTop: (firstErrorEl.offset().top)
	},500);
}



function FocusElement(element){
	$().animate({
	    scrollTop: ($(element).offset().top)
	},100);
	$(element).focus();
}


function InitErrorChange(){
	$(".required:not(.errorchange-linked)").on("change", function(){
		$(this).closest(".form-group").find("label").find("span").remove();
		if($(this).val()){
			$(this).closest(".form-group").find("label").append('<span>&nbsp;&nbsp;</span><span class="text-green fa fa-check"></span>');
		}
		else{
			$(this).closest(".form-group").find("label").append('<span>&nbsp;&nbsp;</span><span class="text-red fa fa-close"></span>');
		}
	}).addClass("errorchange-linked");
}

function ResetErrorChange(){
	$(".errorchange-linked").off("change").removeClass(".errorchange-linked");
}

function ResetInputs(selector){
	if (!selector) {
		selector = ".main-content"
	}

	$(selector).find("input[type='text']").val("");
	$(selector).find("input[type='hidden']").val("");
	$(selector).find("input[type='number']").val("0");
	$(selector).find("input[type='checkbox']").removeProp("checked");
	$(selector).find("textarea").val("");
	$(selector).find("select").val("");
	$(selector).find(".control-label span").remove();
}

function HideModal(idClass)
{
	$("." + idClass).modal("hide");
	$("." + idClass).find('.modal-body').html("");
}

function GetInput(callback)
{
	if ($(".input-modal").length == 0 ) {
		var html = '';
		html += '<div class="modal fade input-modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" style="display: none;">';
		html += '	<div class="modal-dialog modal-sm">';
		html += '		<div class="modal-content">';
		html += '			<div class="modal-body">';
		html += '				<input type="text" id="modal_input" />';
		html += '				<button class="btn btn-cancel">Cancel</button>';
		html += '				<button class="btn btn-ok">Ok</button>';
		html += '			</div>';
		html += '		</div>';
		html += '	</div>';
		html += '</div>';
		$("body").append(html);
		$(".btn-ok").on("click", function(){
			callback($("#modal_input").val());
		});
	}
	$('.input-modal').modal();
}

function ShowSuccessMsg(title, msg)
{
	swal({
		title: title,
		text: msg,
		type: "success",
		confirmButtonColor: "#007AFF"
	});
}

function ShowErrorMsg(title, msg)
{
	swal({
		title: title,
		text: msg,
		type: "error",
		confirmButtonColor: "#007AFF"
	});
}

function LoadMainContent(url){
	var navigateAway = function(){
		mainContentUrl = url;
		$.ajax({
	        url: url,
	        success:function( response, status, xhr ) { 
	        	if(response.indexOf("<!DOCTYPE html>") != -1){
	        		window.location = url;
	        	}
	        	else{
		    		$('.main-content').hide().html(response).fadeIn(500, function(){
		    			ScrollToTop();
		    		});
	        	}
	        	
	    	}
	    });
		isDirty = false;
	};
	if(	isDirty ){
		swal({
			title: "Discard changes?",
			text: "Are you sure to navigate away?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, discard changes!",
			closeOnConfirm: true
		}, navigateAway);
	}
	else{
		navigateAway();
	}
	
}

function InitHandlers(){
	$(".dirty-check:not(.dirty-check-linked)").on("change", function(){
		isDirty = true;
	}).addClass("dirty-check-linked");
	
	$("a[data-ajax=true]:not(.linked), button[data-ajax=true]:not(.linked)").on('click', function (event) {
		event.preventDefault();
		if ($(this).attr('href')) {
			LoadMainContent($(this).attr('href'));
		}
		else{
			LoadMainContent($(this).data('href'));
		}

		$('.search-modal').modal("hide");
		return false;

	}).addClass("linked");

	$(".submenu:not(.linked)").click(function(){
		
		LoadMainContent($(this).attr('href'));

	}).addClass("linked");

	$("a[data-modal=true]:not(.linked), button[data-modal=true]:not(.linked)").on('click', function (event) {
		event.preventDefault();
		if ($(this).attr('href')) {
			ShowModal($(this).attr('href'));
		}
		else{
			ShowModal($(this).data('href'));
		}
		return false;
	}).addClass("linked");

	$("form.ajax:not(.linked)").on('submit', function (event) {
		event.preventDefault();
		var validator = window[$(this).data("validator")];

		if (validator === undefined || validator()) {
			var enctype = $(this).prop("enctype");
			
			if(!enctype || enctype == "application/x-www-form-urlencoded"){
				$.ajax({
		        	type: $(this).prop('method'),           
		            url: $(this).prop('action'),
		            data: $(this).serialize(), 
		            success: window[$(this).data("handler")]
		        });	
			}
			else{
				$.ajax({
		        	type: $(this).prop('method'),
		        	encType: enctype,
		        	contentType: false,
		        	processData: false,
		            url: $(this).prop('action'),
		            data: new FormData( $(this)[0]), 
		            dataType: 'json',
		            success: window[$(this).data("handler")]
		        });
			}

		};
		return false;
	}).addClass("linked");

    $(".btn-refresh:not(.refresh-linked)").on("click", function(){
    	LoadMainContent(mainContentUrl);
    }).addClass("refresh-linked");

	$.each($('input.datepicker:not(.datepicker-linked)'), function(i, item){ 
		$(item).datepicker({
			format: 'dd-M-yyyy',
	    	startDate: $(this).data("mindate"),
	    	endDate: $(this).data("maxdate")
		}).addClass("datepicker-linked").prop("readonly", "readonly");
	});

	$.each($('input.timepicker:not(.timepicker-linked)'), function(i, item){ 
		$(item).timepicker().addClass("timepicker-linked").prop("readonly", "readonly");
	});


	$.each($('input.integer:not(.integer-linked)'), function(i, item){ 
		$(item).on("keydown", function(e) {
			// Allow: backspace, delete, tab, escape, enter and .
	        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
	             // Allow: Ctrl+A, Command+A
	            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
	             // Allow: home, end, left, right, down, up
	            (e.keyCode >= 35 && e.keyCode <= 40)) {
	                 // let it happen, don't do anything
	                 return;
	        }
	        // Ensure that it is a number and stop the keypress
	        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	            e.preventDefault();
	        }

		}).on("focusout", function(e){
			var minVal = $(this).data("minval");
	    	var maxVal = $(this).data("maxval");
		    if (minVal && Number($(this).val()) < Number(minVal)) {
		    	$(this).val("");
		    }
		}).addClass("integer-linked");
	});

	$.each($('input.number:not(.number-linked)'), function(i, item){ 
		$(item).on("keydown", function(e) {
			// Allow: backspace, delete, tab, escape, enter and .
	        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	             // Allow: Ctrl+A, Command+A
	            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
	             // Allow: home, end, left, right, down, up
	            (e.keyCode >= 35 && e.keyCode <= 40)) {
	                 // let it happen, don't do anything
	                 return;
	        }
	        // Ensure that it is a number and stop the keypress
	        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	            e.preventDefault();
	        }

		}).on("focusout", function(e){
			var minVal = $(this).data("minval");
	    	var maxVal = $(this).data("maxval");
		    if (minVal && Number($(this).val()) < Number(minVal)) {
		    	$(this).val("");
		    }
		}).addClass("number-linked");
	});

	$.each($('input.money:not(.money-linked)'), function(i, item){ 
		$(item).on("keydown", function(e) {
			// Allow: backspace, delete, tab, escape, enter and .
	        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	             // Allow: Ctrl+A, Command+A
	            (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) ) || 
	             // Allow: home, end, left, right, down, up
	            (e.keyCode >= 35 && e.keyCode <= 40)) {
	                 // let it happen, don't do anything
	                 return;
	        }
	        // Ensure that it is a number and stop the keypress
	        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	            e.preventDefault();
	        }
		}).on("focusout", function(e){ 
			var res = FormatMoney($(this).val());
			$(this).val(res);
			//console.log($(this).val());
		}).addClass("money-linked");
	});

	$('.view:not([readonly="readonly"])').prop("readonly", "readonly");
	$('.readonly:not([readonly="readonly"])').prop("readonly", "readonly");
}

function FormatMoney(val){
	if(val == "" || val == null){
		return "0.00";
	}
	var result = RemoveComma(val).toFixed(2); 
	return result.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function RemoveComma(val){
	var result = Number(String(val).replace(/,/g, ""));
	return result;
}

function ScrollToTop()
{
	$('html, body').animate({ scrollTop: 0 }, 'slow');
}

function InitDataTable(table){
	var oTable = $(table).dataTable({
		"aoColumnDefs" : [{
			"aTargets" : [0]
		}],
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "<span class='fa fa-chevron-left'></span>",
				"sNext" : "<span class='fa fa-chevron-right'></span>"
			}
		},
		"aaSorting" : [[0, 'asc']],
		"aLengthMenu" : [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"] // change per page values here
		],
		// set the initial value
		"iDisplayLength" : 20,
	});
	
	//alert($(".paginate_button current").val());
}

function InitResizableTable(table){
	$(table).dataTable({
    	"sDom": "Rlfrtip",
    	"bSort" : false, 
    	"bFilter" : false,
    	"paging" : false,
    	"bInfo" : false
  	});
}

function ConcatWithBR(arr){ 
	if(!arr){
		return "";
	}
	var msg = "";
	for (var i = 0; i < arr.length; i++) {
		msg += arr[i] + '<br />';
	};
	return msg;
}

function GetParameterByName(url, name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)");
    results = regex.exec(url);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function CheckDuplicate(selector){
	var values = Array();
	var isFound = false; 
	$(selector).each(function(i, item){
		value = $(item).val();
		if ( values.indexOf(value) != -1) {	
			isFound = true;
		}
		values.push(value);
	});
	return isFound;
}



function PadZero(comp) {
    return ((parseInt(comp) < 10) ? ('0' + comp) : comp);
}

function PadZeros(src, num) {
	dest = "0000000000000000000000000000000000000000000000000000" + src;
	if (src.length < num) {
		return dest.substring(dest.length  -num);
	}
    return src;
}


function CommaSeparateNumber(val){
    while (/(\d+)(\d{3})/.test(val.toString())){
      val = val.toString().replace(/(\d+)(\d{3})/, '$1'+','+'$2');
    }
    return val;
}


/*convert 10-nov-2016 into yyyy-mm-dd format*/
function formatDate(inputDate,format){
	var m_names = new Array("Jan", "Feb", "Mar", 
			"Apr", "May", "Jun", "Jul", "Aug", "Sep", 
			"Oct", "Nov", "Dec");

	var d = new Date(inputDate);
	var curr_date = PadZero(d.getDate());
	var curr_month = d.getMonth();
	var curr_year = d.getFullYear();
	if(format == "dd-mm-yyyy"){
		return(curr_date + "-" + PadZero(curr_month + 1) + "-" + curr_year);
	}
	else if(format == "dd-mmm-yyyy"){
		return(curr_date + "-" + m_names[curr_month] + "-" + curr_year);
	}
	else if(format == "yyyy-mm-dd"){
		return(curr_year + "-" + PadZero(curr_month + 1) + "-" + curr_date);
	}
	else if(format == "yyyy-mmm-dd"){
		return(curr_year + "-" + m_names[curr_month] + "-" + curr_date);
	}
	else{
		alert("Invalid Data Format");
	}

}

function GetToday(){
	var d = new Date();
	return formatDate(d, "dd-mmm-yyyy");
}

function addDays(date, days) {
    var result = new Date(date);
    result.setDate(result.getDate() + days);
    return result;
}

function trimStrtoUpperCase(data){
	return data.replace(/\s/g, '').toUpperCase();
}

