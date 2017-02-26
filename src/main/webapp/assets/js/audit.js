var inputTableHtml = function(selector){
	var rows = $(selector).find("tbody tr");
	var html = "";
	for (var i = 0; i < rows.length; i++) {
		html += "<tr>";
		var cols = $(rows[i]).find("td");
		for (var j = 0; j < cols.length - 1; j++) {
			if ($(cols[j]).find("input[type='text']").length > 0) {
				html += "<td>" + $(cols[j]).find("input[type='text']").val() + "</td>";
			}
			else{
				html += "<td>" + $(cols[j]).text() + "</td>";
			}
		};
		html += "</tr>";
	};
	return html;
};

var makeWbsPreviewHtml = function(){
	var html = "";
	$(".wbs-block").each(function(i, item){
		html += '<fieldset class="bg-light-grey">';
		html += 	'<div class="col-md-6">' +	
						'<div class="row">' +
							'<div class="col-md-6">' +
								'<div class="row">' +
									'<div class="col-md-6">WBS Code</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-wbs-code").val() + '</div>' +
								'</div>' +
							'</div>' +
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">WBS Name</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-wbs-name").val() + '</div>' +
								'</div>' +							
							'</div>' +
						'</div>' +
						'<div class="row">' +
							'<div class="col-md-12">' +	
								'<div class="row">' +
									'<div class="col-md-6">Purpose</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-wbs-purpose").val() + '</div>' +
								'</div>' +							
							'</div>' +
						'</div>' +
						'<div class="row">' +
							'<div class="col-md-6">' +
								'<div class="row">' +
									'<div class="col-md-6">Start Day <small>(From Project Commencement)</small></div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-start-day").val() + '</div>' +
								'</div>' +								
							'</div>' +
							'<div class="col-md-6">' +
								'<div class="row">' +
									'<div class="col-md-6">Duration <small>(in days)</small></div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-duration").val() + '</div>' +
								'</div>' +								
							'</div>' +
						'</div>' +
					'</div>' ;
		html +=		'<div class="col-md-6">' +							
						'<fieldset class="bg-light-grey">'+
							'<legend>'+
							'Owner'+ 
							'</legend>'+
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">Owner Code</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-owner-code").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Username</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-owner-username").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Mobile</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-owner-mobile").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Company Code</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-owner-company-code").val() + '</div>' +
								'</div>' +
							'</div>' +
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">Owner Name</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-owner-name").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Designation</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-owner-desig").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Email</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-owner-email").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Company Name</div>' +
									'<div class="col-md-6">' + $(item).find(".wbs-owner-company-name").val() + '</div>' +
								'</div>' +
							'</div>' +
						'</fieldset>'+
					'</div>';
		html += 	'<table class="table table-striped congested-table table-hover">' +
						'<thead><tr><th>Code</th><th>Name</th><th>Quantity</th><th>Unit of Measurement</th></tr></thead>' +
						'<tbody>';
		html += inputTableHtml($(item).find(".wbs-deliverable-list"));
		html += 		'</tbody>' +
					'</table>' ;
		html += "</fieldset>";
	});
	return html;
};

var makeActivityPreviewHtml = function(){
	var html = "";
	$(".activity-block").each(function(i, item){
		html += '<fieldset class="bg-light-grey">';
		html += 	'<div class="col-md-6">' +	
						'<div class="row">' +
							'<div class="col-md-6">' +
								'<div class="row">' +
									'<div class="col-md-6">Activity Code</div>' +
									'<div class="col-md-6">' + $(item).find(".activity_code").val() + '</div>' +
								'</div>' +
							'</div>' +
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">Activity Name</div>' +
									'<div class="col-md-6">' + $(item).find(".activity_name").val() + '</div>' +
								'</div>' +							
							'</div>' +
						'</div>' +
						'<div class="row">' +
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">WBS</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-wbs").val() + '</div>' +
								'</div>' +							
							'</div>' +
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">Activity Group</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-activitygroup").val() + '</div>' +
								'</div>' +							
							'</div>' +
						'</div>' +
						'<div class="row">' +
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">Milestone</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-milestone").val() + '</div>' +
								'</div>' +							
							'</div>' +
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">Purpose</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-purpose").val() + '</div>' +
								'</div>' +							
							'</div>' +
						'</div>' +						
						'<div class="row">' +
							'<div class="col-md-6">' +
								'<div class="row">' +
									'<div class="col-md-6">Start Day <small>(From Project Commencement)</small></div>' +
									'<div class="col-md-6">' + $(item).find(".activity-start-day").val() + '</div>' +
								'</div>' +								
							'</div>' +
							'<div class="col-md-6">' +
								'<div class="row">' +
									'<div class="col-md-6">Duration <small>(in days)</small></div>' +
									'<div class="col-md-6">' + $(item).find(".activity-duration").val() + '</div>' +
								'</div>' +								
							'</div>' +
						'</div>' +
					'</div>' ;
		html +=		'<div class="col-md-6">' +							
						'<fieldset class="bg-light-grey">'+
							'<legend>'+
							'Owner'+ 
							'</legend>'+
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">Owner Code</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-owner-code").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Username</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-owner-username").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Mobile</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-owner-mobile").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Company Code</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-owner-company-code").val() + '</div>' +
								'</div>' +
							'</div>' +
							'<div class="col-md-6">' +	
								'<div class="row">' +
									'<div class="col-md-6">Owner Name</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-owner-name").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Designation</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-owner-desig").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Email</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-owner-email").val() + '</div>' +
								'</div>' +
								'<div class="row">' +
									'<div class="col-md-6">Company Name</div>' +
									'<div class="col-md-6">' + $(item).find(".activity-owner-company-name").val() + '</div>' +
								'</div>' +
							'</div>' +
						'</fieldset>'+
					'</div>';
		html += 	'<table class="table table-striped congested-table table-hover">' +
						'<thead><tr><th>Code</th><th>Name</th><th>Quantity</th><th>Unit of Measurement</th></tr></thead>' +
						'<tbody>';
		html += inputTableHtml($(item).find(".activity-deliverable-list"));
		html += 		'</tbody>' +
					'</table>' ;
		html += "</fieldset>";
	});
	return html;
};

var syncPreview = function(){
	$.each($("[id^=preview_]"), function(i, item){
		var sourceId = $(item).prop("id").substring(8);
		var source = $("#" + sourceId);
		if (source && source.prop("type")){
			if(source.prop("type").toLowerCase() == "text" || source.prop("type").toLowerCase() == "textarea") {
				$(item).html(source.val() + "&nbsp;");
			}
			else if(source.prop("type").toLowerCase() == "select-one") {
				$(item).html(source.find("option:selected").text());
			}
			else if(source.prop("type").toLowerCase() == "checkbox") {
				$(item).html(source.is(":checked")? "Yes" : "No");
			}
			else if(source.prop("type").toLowerCase() == "radio"){
				$(item).html(source.is(":checked")? source.next().text() : "");
			}
			else{
				alert(source.prop("type").toLowerCase())
			}
		}
	});

	$("#preview_Deliverable tbody").html(inputTableHtml("#Deliverable"));
	$("#preview_milestone_list tbody").html(inputTableHtml("#milestone_list"));
	$("#preview_Attachment tbody").html(inputTableHtml("#Attachment"));
	$("#preview_BillingPlan tbody").html(inputTableHtml("#BillingPlan"));


	$("#panel_3").html(makeWbsPreviewHtml());
	$("#preview_activity_group tbody").html(inputTableHtml("#ActGrp"));
	$("#panel_5").html(makeActivityPreviewHtml());

};


//added by bappi start
/*$(".stepNumber").on("click", function() {
	if ($(this).parent().hasClass("disabled")) {
		alert("inactive");
	} else {
		alert($(this).text().trim());
	}
	//alert("Current Step Number is = " + $(this).parent().attr("href"));
});*/
//added by bappi end

var validateStep = function(stepNumber){
	// syncPreview();return true;
	$(".alert").addClass("hidden");
	
	var error = "";
	var	result = CheckRequired("#step-" + stepNumber);

	if(!result) {
    	error = "Please check the required fields.<br />";
    }

 	if (stepNumber == 1) {
		/*if (!checkProjectDates()) {
			result = false;
    		error += "Please ensure that the Project End Date is greater than or equal to the Start Date.<br />";
		}*/
	}
	else if (stepNumber == 2) {
		var selectedCompanyCounter = 0;		
		if ($('#companyCheckboxDiv').length) {
			$('#companyCheckboxDiv input:checked').each(function() {
				selectedCompanyCounter++;
			});
			if (selectedCompanyCounter == 0) {
				result = false;
	    		error += "Please select at least one Company.<br />";
			}
		}		
	}
	else if (stepNumber == 3) {
		/*var wbsBlocks = $("[id^='wbs_block']");			
		var wbsDelNumber = $(".wbs-number-of-deliverable");
		var wbsDelDisc   = $(".wbs-deliverable-code");
		var proDelNumber = $(".project-number-of-deliverable");
		var proDelDisc	 = $(".project-deliverable-code");
		for (var i =0 ;  i < proDelNumber.length ; i++) {
			var wbsValue = 0;
		 	for(var j=0; j < wbsDelNumber.length ; j++){
		 		if($(proDelDisc[i]).val()==$(wbsDelDisc[j]).val())
		 			wbsValue+=Number($(wbsDelNumber[j]).val());
		 	}
		 	if($(proDelNumber[i]).val()!=wbsValue){
		 		error  += "Deliverable " + $(proDelDisc[i]).val() + ": Project total is " + $(proDelNumber[i]).val() + ", WBS total is " + wbsValue;
		 	 	result = false;
		 	}
        }

		for (var i = 0; i < wbsBlocks.length; i++) { 
			var resultWbsDate = checkWbsDate( "#" + $(wbsBlocks[i]).prop("id"));
		    if(!resultWbsDate){
		   		error += "Please check WBS Start and End date for WBS block number : " + $(wbsBlocks[i]).find(".wbs-wbs-name").val();
		   		result = false;
		    }
		}*/
	}
	else if (stepNumber == 4) {
		/*var resultPrjDate = true;	
		var prjDuration = $("#project_duration").val();

		var rows = $("#ActGrp tbody tr");
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			var actgrpDay 			  = parseInt($(row).find('.activity-group-start-day').val());
				var actgrpDuration 	 	  = parseInt($(row).find('.activity-group-duration').val()); //alert(actgrpDuration)
			var verifyActgrpDuration  = actgrpDay + actgrpDuration;
			if(actgrpDay>prjDuration){
				error += "Please ensure that the Activity Group Start Day is in between Project Start and End Date<br />";
				//return false;
			}

			if(verifyActgrpDuration>prjDuration){
				error += "Please ensure that the Activity Group End Date never exceeds project End Date<br />";
				//return false;
			}
		}

		if (resultPrjDate) {
			var actBlocks = $("[id^='activity-block']");
			for (var i = 0; i < actBlocks.length; i++) {
				initActivityView( "#" + $(actBlocks[i]).prop("id"));
			}
		}
		else{

			result = false;
		}*/
	}
	else if (stepNumber == 8) {
		/*var activityBlocks = $("[id^='activity-block']");
		for (var i = 0; i < activityBlocks.length; i++) { 

			var resultActDate = checkActiviityDate( "#" + $(activityBlocks[i]).prop("id"));
			if(!resultActDate){
				error += "Please check Activity Start and End date for Activity : " + $(activityBlocks[i]).find(".activity_name").val();
				result = false;
			}
		}
		$(".alert").html(error);	
		$(".alert").removeClass("hidden");

		var wbsBlocks = $("[id^='wbs_block']");
		var actBlocks = $("[id^='activity-block']");
		var actWbsNames =$(".activity-wbs");
		var wbsBlockNames = $(".wbs-wbs-name");					
		InitErrorChange();	
		var warning = "";
		for (var i = 0; i < wbsBlocks.length; i++) { 

			var blkIdWbs = $(wbsBlocks[i]).prop("id");
			var wbsRows = $("#"+ blkIdWbs +" tbody tr");
			var wbsBlockName = $(wbsBlockNames[i]).val();

			for (var j =0 ;  j< wbsRows.length ; j++) {
				var sum = 0.0;
				var key;
				for (var k = 0; k < actBlocks.length; k++) {

					var blkIdAct = $(actBlocks[k]).prop("id");
					var actRows = $("#"+ blkIdAct +" tbody tr");
					var actWbsName = $("#"+blkIdAct).find(".activity-wbs").val();
					
					for(var l=0; l < actRows.length ; l++){

						if(((wbsBlockName == actWbsName) && $(wbsRows[j]).find(".wbs-deliverable-code").val() == $(actRows[l]).find(".activity-deliverable-code").val()) ){
							sum += Number($(actRows[l]).find(".activity-number-of-deliverable").val());
							key = l;
						}

			 		}
			 		
				}
				if(sum > Number($(wbsRows[j]).find(".wbs-number-of-deliverable").val())){
					warning +="WBS " + wbsBlockName +" is "+ $(wbsRows[j]).find(".wbs-deliverable-name").val()+" : "+$(wbsRows[j]).find(".wbs-number-of-deliverable").val()+" but Activity "+wbsBlockName+" "+$(actRows[key]).find(".activity-deliverable-name").val()+" is "+sum+'<br>';
				}
				if(sum < Number($(wbsRows[j]).find(".wbs-number-of-deliverable").val())){
					warning +="WBS " + wbsBlockName + " is "+ $(wbsRows[j]).find(".wbs-deliverable-name").val()+" : "+$(wbsRows[j]).find(".wbs-number-of-deliverable").val()+" but Activity "+wbsBlockName+" "+$(actRows[key]).find(".activity-deliverable-name").val()+" is "+sum+'<br>';
				}						
			 	
            }
			$(".alert").html(warning);	
			$(".alert").removeClass("hidden");
		}
		syncPreview();*/
	}

	if (!result) {
		ShowErrorMsg('Audit was not saved due to some error.', "Please check details.");
		InitErrorChange();
		$(".alert").html(error);
		$(".alert").removeClass("hidden");
	}
	
	return result;
};


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
		LoadMainContent("/project/create/?company_code=" + newCompanyCode);
	});

});

$("#btnProgram").on("click",function(){	
	ShowModal("/searchprogram/?action_type_code=SELECT&actioncallback=loadProgram");
});

function loadProgram(prodata){ 
	var pro = JSON.parse(unescape(prodata));
	$("#portfolio_code").val(pro.portfolio_code);		
	$("#portfolio_name").val(pro.portfolio_name);
	$("#program_code").val(pro.program_code);		
	$("#program_name").val(pro.program_name);

	HideModal('search-modal');	
}

$("#btnManager").on("click",function(){	
	ShowModal("/searchemployee/?action_type_code=SELECT&actioncallback=loadManager");
});

function loadManager(empdata){ 
	var emp = JSON.parse(unescape(empdata));
	$("#project_manager_code").val(emp.emp_code);		
	$("#project_manager_name").val(emp.emp_name);	
	$("#project_manager_username").val(emp.username);	
	$("#project_manager_desig").val(emp.desig);	
	$("#project_manager_email").val(emp.email);		
	$("#project_manager_mobile").val(emp.mobile);	
	$("#project_manager_company_code").val(emp.company_code);	
	$("#project_manager_company_name").val(emp.company_name);	
	HideModal('search-modal');	
}

	
$("#btnAccountable").on("click",function(){	
	ShowModal("/searchemployee/?action_type_code=SELECT&actioncallback=loadAccountable");
});

function loadAccountable(empdata){ 
	var emp = JSON.parse(unescape(empdata));
	$("#other_accountable_code").val(emp.emp_code);		
	$("#other_accountable_name").val(emp.emp_name);	
	$("#other_accountable_username").val(emp.username);	
	$("#other_accountable_desig").val(emp.desig);	
	$("#other_accountable_email").val(emp.email);		
	$("#other_accountable_mobile").val(emp.mobile);	
	$("#other_accountable_company_code").val(emp.company_code);	
	$("#other_accountable_company_name").val(emp.company_name);	
	HideModal('search-modal');	
}



$("#btnSponsor").on("click",function(){	
	ShowModal("/searchemployee/?action_type_code=SELECT&actioncallback=loadSponsor");
});

function loadSponsor(empdata){ 
	console.log(unescape(empdata))
	var emp = JSON.parse(unescape(empdata));
	$("#project_sponsor_code").val(emp.emp_code);		
	$("#project_sponsor_name").val(emp.emp_name);	
	$("#project_sponsor_username").val(emp.username);	
	$("#project_sponsor_desig").val(emp.desig);	
	$("#project_sponsor_email").val(emp.email);		
	$("#project_sponsor_mobile").val(emp.mobile);	
	$("#project_sponsor_company_code").val(emp.company_code);	
	$("#project_sponsor_company_name").val(emp.company_name);	
	HideModal('search-modal');	
}


var checkProjectDates = function()
{
	var startDate= $('#scheduled_start_date').val();
	var endDate= $('#scheduled_end_date').val();
	
	if(startDate != '' && endDate != '')
	{
		if ( new Date(startDate) > new Date(endDate)) {
			ShowErrorMsg('',"Please ensure that the Project End Date is greater than or equal to the Start Date");
			return false;
		}
	}
	return true;
};

var showProjectDuration = function(){
	var MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
	var startDate= $('#scheduled_start_date').val();
	var endDate= $('#scheduled_end_date').val();
	if(startDate != '' && endDate != '')
	{
		var projectStartDate = new Date(startDate);
		var projectEndDate =  new Date(endDate);
		var projectDuration = Math.floor((projectEndDate.getTime() - projectStartDate.getTime()) / MILLISECONDS_PER_DAY) + 1;
		$("#scheduled_duration").val(projectDuration);
		if ( projectStartDate <= projectEndDate) {
			$("#scheduled_duration").removeClass("error-value").addClass("valid-value");
		}
		else{
			$("#scheduled_duration").removeClass("valid-value").addClass("error-value");
		}
	}

};

$("#project_manager_accountable,#other_single_accountable,#multi_accountable").on("click",function(){
	if($(this).prop("id") == "other_single_accountable"){
		$("#Accountable").show();
		$("#other_accountable_code").addClass("required");
		$("#other_accountable_name").addClass("required");
	}
	else{
		$("#Accountable").hide();
		$("#other_accountable_code").removeClass("required");
		$("#other_accountable_name").removeClass("required");
	}
});	

//////////////////  CONTRACT & BILLING STEP:2  //////////////////////

$("#btnParty").on("click",function(){	
	if ($("#party_type").val() == "0") {
		ShowModal("/searchcustomer/?action_type_code=SELECT&actioncallback=loadParty");
	}	
	else if ($("#party_type").val() == "1") {
		ShowModal("/searchemployee/?action_type_code=SELECT&actioncallback=loadParty");
	}
	else if ($("#party_type").val() == "2") {
		ShowModal("/searchsupplier/?action_type_code=SELECT&actioncallback=loadParty");
	}
});

var loadParty = function(empdata){ 
	var emp = JSON.parse(unescape(empdata));
    $("#party_code").val(emp.emp_code);		
    $("#party_name").val(emp.emp_name);
	$("#party_email").val(emp.email);		
	$("#party_mobile").val(emp.mobile);	
	$("#party_company_code").val(emp.company_code);	
	$("#party_company_name").val(emp.company_name);	
	HideModal('search-modal');	
};

var getExRate = function(){
	$.ajax({
		type: "GET",
		url: "/getexrate?from_curr_code=" + $('#project_currency_code').val() + "&to_curr_code=" + $('#local_currency_code').val() + "&company_code=" + $('#company_code').val(),
		dataType: 'json',
		success:function(data){
			$("#project_currency_exrate").val(FormatMoney(data.exrate));
		}
	});
};

var addRowDeliverable = function(el){
	$("#Deliverable tbody").append(
		'<tr>' +
		'<td><input name="project_deliverable_code[]" type="text" class="project-deliverable-code form-control required" value="" /></td>' +
		'<td><input name="project_deliverable_name[]" type="text" class="project-deliverable-name form-control required" value="" /></td>' +
		'<td class="width-200"><input name="project_number_of_deliverable[]" type="text" class="project-number-of-deliverable form-control number required" value="" /></td>' +
		'<td class="width-200"><input name="project_deliverable_unit[]" type="text" class="project-deliverable-unit form-control required" value="" /></td>' +
		'<td class="width-80">' +
		'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
		'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
		'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
		'</tr>'
		);
	InitHandlers();
};

var addRowMilestone = function(el){
	$("#milestone_list tbody").append(
		'<tr>' +
		'<td><input name="milestone_code[]" type="text" class="project-milestone-code form-control required" value="" /></td>' +
		'<td><input name="milestone_name[]" type="text" class="project-milestone-name form-control required" value="" /></td>' +
		'<td class="width-80">' +
		'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
		'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
		'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
		'</tr>'
		);
	InitHandlers();
};

var addRowAttachment = function(el){
	$("#Attachment tbody").append(
		'<tr>' +
		'<td class="file-name"></td>' +
		'<td>' +
			'<input name="attachment_path[]" type="file" class="attachment-path hidden" value="" />' +
			'<input name="attachment_file_title[]" type="text" class="attachment-file-title form-control" value="" />' + 
		'</td>' +
		'<td class="width-200">' +
		'<button type="button" onclick="attachFile(this);" class="btn btn-xs btn-file-upload"><span class="fa fa-arrow-up"> Attach</span></button>&nbsp;' + 
		'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
		'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
		'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
		'</tr>'
	);
	InitHandlers();
};

var attachFile = function(el){
	var fileInput = $(el).closest("tr").find(".attachment-path");
	fileInput.click();
    fileInput.off().on("change", function(){
		if (fileInput[0].files && fileInput[0].files[0]) {
	        $(el).hide();
	        $(el).closest("tr").find(".file-name").text(fileInput[0].files[0].name);
	        $(el).closest("tr").find(".attachment-file-title").val(fileInput[0].files[0].name.split(".")[0]);
	    }
	});
	
};

var addRowBillingPlan = function(el){
	$("#BillingPlan tbody").append(
		'<tr>' +
		'<td><input name="billing_code[]" type="text" class="billing-code form-control required" value="" /></td>' +
		'<td><input name="billing_name[]" type="text" class="billing-name form-control required" value="" /></td>' +
		'<td><input name="billing_date[]" type="text" class="billing-date form-control integer" value="" /></td>' +
		'<td><input name="billing_percentage[]" type="text" class="billing-percentage form-control number" value="" /></td>' +
		'<td><input name="billing_amount[]" type="text" class="billing-amount form-control" value="" /></td>' +
		'<td class="width-80">' +
		'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
		'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
		'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
		'</tr>'
		);
	InitHandlers();
};

//////////////////    WBS STEP:3    //////////////////////

function initWbsView(blockId){
	var deliCodes = $(".project-deliverable-code");
	var deliNames = $(".project-deliverable-name");
	var deliNums = $(".project-number-of-deliverable");
	var deliUnits = $(".project-deliverable-unit");

	var html = "";
	for (var i = 0 ; i < deliCodes.length; i++) {
		var projDelNum = $(".project-deliverable-code[value='" + code + "']").closest("tr").find(".project-deliverable-unit").val();
		var code = $(deliCodes[i]).val();
		var name = $(deliNames[i]).val();
		var num = $(deliNums[i]).val();
		var unit = $(deliUnits[i]).val();
		var numOld = $(blockId).find(".wbs-deliverable-code[value='" + code + "']").closest("tr").find(".wbs-number-of-deliverable").val();
		html += "" +
		'<tr>' +
			'<td><input name="wbs_deliverable_code[]" type="text" class="wbs-deliverable-code form-control required" readonly value="'+ code  + '" /></td>' +
			'<td><input name="wbs_deliverable_name[]" type="text" class="wbs-deliverable-name form-control required" readonly value="'+ name  + '" /></td>' +
			'<td class="width-200"><input name="wbs_number_of_deliverable[]" type="text" class="wbs-number-of-deliverable form-control required" numeric value="' + (numOld === undefined ? num : numOld) + '" /></td>' +
			'<td class="width-200"><input name="wbs_deliverable_unit[]" type="text" class="wbs-deliverable-unit form-control required" readonly value="' + unit + '" /></td>' +
			'<td class="width-80">' +
				'<input type="hidden"  name="wbs_deliverable_wbs_code[]" class="wbs-deliverable-wbs-code" />' + 
				'<input type="hidden"  name="wbs_deliverable_wbs_name[]" class="wbs-deliverable-wbs-name" />' + 
				'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
				'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
				'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
			'</td>' +
		'</tr>';
	}
	$(blockId).find(".wbs-deliverable-list tbody").html(html);
}

var showFindAuditorSpoc = function(el){
	var auditorCodes = $("input[name='auditor_code[]']")
    			.map(function(){
    				return $(this).val();
    				}).get();
	
	$(".section-block").removeClass("current-section-block");
	ShowModal("grc/as/audit/auditsearchemployeeshow/?action_type_code=SELECT&isAuditorSpoc=1&auditorCodes=" + auditorCodes + "&actioncallback=loadAuditorSpoc");
	//ShowModal("grc/as/audit/auditsearchemployeeshow/?action_type_code=SELECT&auditorCodes=" + auditorCodes + "&actioncallback=loadAuditorSpoc");
	var currentSectionBlock = $(el).closest(".section-block");
	currentSectionBlock.addClass("current-section-block");
	
	var currentSectionBlock = $(el).closest(".section-block");
	currentSectionBlock.addClass("current-section-block");
};

var loadAuditorSpoc = function(auditorData){
	event.preventDefault();
	var auditor = JSON.parse(unescape(auditorData));
	//alert(concatedValue);
	/*var auditorInfoParts = auditorInfo.split("-");
	var auditorCode = auditorInfoParts[0];
	var auditorName = auditorInfoParts[1];
	var auditorDesig = auditorInfoParts[2];
	var auditorMobile = auditorInfoParts[3];
	var auditorEmail = auditorInfoParts[4];*/
	
	$(".current-section-block .section-auditor-code").val(auditor.empCode);
	$(".current-section-block .section-auditor-name").val(auditor.empName);
	$(".current-section-block .section-auditor-desig").val(auditor.desig);
	$(".current-section-block .section-auditor-mobile").val(auditor.mobile);
	$(".current-section-block .section-auditor-email").val(auditor.email);
	HideModal('search-modal');	
};


/*$(document).on("click", ".atg", function(ev){
	console.log("yyyyyyyyyyyy");
    ev.preventDefault();

    var $tr = $(this).parents('tr');
    alert($tr.find(".auditor-name").html());
    $tr.closest(".section-block .section-auditor-name").val($tr.find(".auditor-name").html());
    HideModal('search-modal');
});*/

var showFindAuditeeSpoc = function(el){	
	var auditorCodes = $("input[name='auditor_code[]']")
	.map(function(){
		return $(this).val();
		}).get();
	
	//alert(auditorCodes);
	
	
	$(".section-block").removeClass("current-section-block");
	var removableAuditorCode = $.trim($(el).closest(".section-block").find(".section-auditor-code").val());
	var removableAuditorCompanyCode = $.trim($(el).closest(".section-block").find(".section-auditor-company-code").val());
	ShowModal("grc/as/audit/auditsearchemployeeshow/?action_type_code=SELECT&auditorCodes=" + auditorCodes + "&actioncallback=loadAuditeeSpoc");
	//ShowModal("grc/as/audit/auditsearchemployeeshow/?action_type_code=SELECT&actioncallback=loadAuditeeSpoc");
	var currentSectionBlock = $(el).closest(".section-block");
	currentSectionBlock.addClass("current-section-block");
};

var loadAuditeeSpoc = function(auditeeData){ 
	event.preventDefault();	
	var auditee = JSON.parse(unescape(auditeeData));
	$(".current-section-block .section-auditee-code").val(auditee.empCode);
	$(".current-section-block .section-auditee-name").val(auditee.empName);
	$(".current-section-block .section-auditee-desig").val(auditee.desig);
	$(".current-section-block .section-auditee-mobile").val(auditee.mobile);
	$(".current-section-block .section-auditee-email").val(auditee.email);
	

	// setting for responsible person in data requirement tab
	var sectionName = $.trim($(".current-section-block .section-section-name").val());
	if (sectionName !== "") {
		localStorage.setItem(sectionName, auditee.empName);		
	}
	
	HideModal('search-modal');	
};

var sectionBlockCounter = 1;
var addSectionBlock = function() {	
	var id = new Date().getTime();
	var html = '' +
	'<div class="section-block panel panel-light-grey" data-id="' + id + '">' +
		'<div class="panel-heading">' +
			'<h5 class="panel-title">' +
				'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#section_block' + id + '">'+
					'<i class="icon-arrow"></i>' +
					'<span class="section-block-title"> Section</span>' +
				'</a>' +
			'</h5>' +
		'</div>' +
		'<div id="section_block' + id + '" class="panel-collapse collapse in">' +
			'<div class="panel-body">' +
				'<div class="row">' +
					'<div class="col-md-12 text-right">' +
						'<button type="button" mainDivClass="section-block" onclick="upSectionDiv(this);" class="btn-up btn btn-xs btn-o"><span class="fa fa-arrow-up"></span></button> &nbsp;' +
						'<button type="button" mainDivClass="section-block" onclick="downSectionDiv(this);" class="btn-up btn btn-xs btn-o"><span class="fa fa-arrow-down"></span></button> &nbsp;' +
			   			'<button class="btn btn-xs btn-red btn-o" onclick="delSectionBlock(this);"><span class="fa fa-close"> Delete</span></button>' +
			  	 	'</div>' +			
			   	'</div>' +	
				/*'<div class="col-md-2 form-group">' +
					'<label class="control-label">Section Code</label>' +
				    '<input name="section_code[]" type="text" class="section-section-code form-control required" readonly="readonly" value="'+sectionBlockCounter+'" onchange="sectionCodeChanged(this)" onclick="setLastSectionCode(this)" />' +						
				'</div>' +*/
				'<div class="col-md-12 form-group">' +	
					 '<label class="control-label">Section Name</label>' +
					 '<input name="section_code[]" type="hidden" class="section-section-code" value="'+sectionBlockCounter+'" />' +
					 '<input name="section_name[]" type="text" class="section-section-name form-control required" onchange="sectionNameChanged(this)" onblur="checkSectionName(this)"/>' +
				'</div>' +
				
				'<div class="col-md-6 form-group">' +
					'<fieldset class="bg-light-grey">'+
					'<legend>'+
					'Auditor SPOC &nbsp;&nbsp;'+ 
					'<button id="btnSectionSearch" onclick="showFindAuditorSpoc(this);" class="btn btn-find" type="button"><span class="fa fa-search"></span></button>'+
					'</legend>'+
					'<div class="col-md-6 form-group">' +	
						'<label class="control-label">Auditor Code</label>' + 
						'<input name="section_auditor_code[]" type="text" class="section-auditor-code form-control" readonly="readonly"/>' +
						'<input type="hidden" name="section_auditor_company_code[]" class="section-auditor-company-code"/>' +
					'</div>' +
					'<div class="col-md-6 form-group">' +	
						'<label class="control-label">Auditor Name</label>' + 
						'<input name="section_auditor_name[]" type="text" class="section-auditor-name form-control" readonly="readonly" />' +
					'</div>' +
					'<div class="col-md-6 form-group">' +	
						'<label class="control-label">Designation</label>' + 
						'<input name="section_auditor_desig[]" type="text" class="section-auditor-desig form-control" readonly="readonly" />' +
					'</div>' +
					'<div class="col-md-6 form-group">' +	
						'<label class="control-label">Mobile</label>' + 
						'<input name="section_auditor_mobile[]" type="text" class="section-auditor-mobile form-control" readonly="readonly"/>' +
					'</div>' +
					'<div class="col-md-12 form-group">' +	
						'<label class="control-label">Email</label>' + 
						'<input name="section_auditor_email[]" type="text" class="section-auditor-email form-control" readonly="readonly" />' +
					'</div>' +
				    '</fieldset>'+
				'</div>' +
				
				'<div class="col-md-6 form-group">' +
					'<fieldset class="bg-light-grey">'+
						'<legend>'+
						'Auditee SPOC &nbsp;&nbsp;'+ 
						'<button id="btnSectionSearch" onclick="showFindAuditeeSpoc(this);" class="btn btn-find" type="button"><span class="fa fa-search"></span></button>'+
						'</legend>'+
						'<div class="col-md-6 form-group">' +	
							'<label class="control-label">Auditor Code</label>' + 
							'<input name="section_auditee_code[]" type="text" class="section-auditee-code form-control" readonly="readonly"/>' +
						'</div>' +
						'<div class="col-md-6 form-group">' +	
							'<label class="control-label">Auditor Name</label>' + 
							'<input name="section_auditee_name[]" type="text" class="section-auditee-name form-control" readonly="readonly" />' +
						'</div>' +
						'<div class="col-md-6 form-group">' +	
							'<label class="control-label">Designation</label>' + 
							'<input name="section_auditee_desig[]" type="text" class="section-auditee-desig form-control" readonly="readonly" />' +
						'</div>' +
						'<div class="col-md-6 form-group">' +	
							'<label class="control-label">Mobile</label>' + 
							'<input name="section_auditee_mobile[]" type="text" class="section-auditee-mobile form-control" readonly="readonly"/>' +
						'</div>' +
						'<div class="col-md-12 form-group">' +	
							'<label class="control-label">Email</label>' + 
							'<input name="section_auditee_email[]" type="text" class="section-auditee-email form-control" readonly="readonly" />' +
						'</div>' +
				    '</fieldset>'+
			     '</div>' +
			'</div>' +
		'</div>' +
	'</div>';
	$("#sectionBlocks").append(html);
	sectionBlockCounter++;
	InitHandlers();
};

var addSectionBlockToActivities = function(sectionCode, sectionName){
		var eachSectionCode = sectionCode;
		var eachSectionName = sectionName;
	
	var id = new Date().getTime();
	var html = '' +
	'<div class="section-activity-block panel panel-light-grey" data-id="' + id + '">' +
		'<div class="panel-heading">' +
			'<h5 class="panel-title">' +
				'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#section_activity_block' + id + '">'+
					'<i class="icon-arrow"></i>' +
					'<span class="section-activity-block-title"> Section : ' + '<label class="last-section-name">' + eachSectionName + '</label>' + '</span>' +
				'</a>' +
			'</h5>' +
		'</div>' +
		'<div id="section_activity_block' + id + '" class="each-section-block panel-collapse collapse in">' +
			'<div class="panel-body">' +
				/*'<div class="row">' +
					'<div class="col-md-12">' +
			   			'<button class="btn btn-xs btn-red btn-o pull-right" onclick="delSectionActivityBlock(this);"><span class="fa fa-close"> Delete</span></button>' +
			  	 	'</div>' +			
			   	'</div>' +*/	
				'<div class="col-md-6 form-group">' +
					'<label class="control-label">Section Code</label>' +
				    '<input name="activityDiv_section_code[]" type="text" value="'+eachSectionCode+'" class="activityDiv-section-code readonly form-control required"  />' +						
				'</div>' +
				'<div class="col-md-6 form-group">' +	
					 '<label class="control-label">Section Name</label>' +
					 '<input name="activityDiv_section_name[]" type="text"  value="'+eachSectionName+'" class="activityDiv-section-name readonly form-control required"/>' +
				'</div>' +
											
					'<div class="col-md-12 form-group">' +
						'<fieldset>'+					
							'<legend>'+
								'Activities / Requirements &nbsp;&nbsp;'+ 
								'<button id="btnAddActivity"  class="btnAddActivity btn btn-find" type="button"><span class="fa fa-plus"></span></button>'+
							'</legend>'+
							'<div class ="bg-light-grey">'+
									'<table id="activityTable" class="table table-striped congested-table table-hover wbs-deliverable-list" >'+
										'<thead>'+
											'<tr>'+
												'<th>Activity Code</th>'+
												'<th>Activity Name</th>'+
												'<th>Details</th>'+
												'<th>Action</th>'+
											'</tr>'+
										'</thead>'+
										'<tbody>'+
										'</tbody>'+
									'</table>'+
							'</div>'+
						'</fieldset>'+
					'</div>' +
				
			'</div>' +
		'</div>' +
	'</div>';
	$("#activityDiv").append(html);
	InitHandlers();
};

/*var addSectionBlockToActivities = function(){
	//$("#sectionBlocks");
	$("#activityDiv").empty();
	$(".section-block").each(function() {
		var eachSectionCode = $(this).find(".section-section-code").val();
		var eachSectionName = $(this).find(".section-section-name").val();
	    //alert("Section Code :: " + eachSectionCode + " || Section Name :: " + eachSectionName);
	
	//alert(sectionName);
	var id = new Date().getTime();
	var html = '' +
	'<div class="section-activity-block panel panel-light-grey" data-id="' + id + '">' +
		'<div class="panel-heading">' +
			'<h5 class="panel-title">' +
				'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#section_activity_block' + id + '">'+
					'<i class="icon-arrow"></i>' +
					'<span class="section-activity-block-title"> Section : ' + '<span class="last-section-name">' + eachSectionName + '</span>' + '</span>' +
				'</a>' +
			'</h5>' +
		'</div>' +
		'<div id="section_activity_block' + id + '" class="each-section-block panel-collapse collapse in">' +
			'<div class="panel-body">' +
				'<div class="row">' +
					'<div class="col-md-12">' +
			   			'<button class="btn btn-xs btn-red btn-o pull-right" onclick="delSectionActivityBlock(this);"><span class="fa fa-close"> Delete</span></button>' +
			  	 	'</div>' +			
			   	'</div>' +	
				'<div class="col-md-6 form-group">' +
					'<label class="control-label">Section Code</label>' +
				    '<input name="activityDiv_section_code[]" type="text" value="'+eachSectionCode+'" class="activityDiv-section-code readonly form-control required"  />' +						
				'</div>' +
				'<div class="col-md-6 form-group">' +	
					 '<label class="control-label">Section Name</label>' +
					 '<input name="activityDiv_section_name[]" type="text"  value="'+eachSectionName+'" class="activityDiv-section-name readonly form-control required"/>' +
				'</div>' +
											
					'<div class="col-md-12 form-group">' +
						'<fieldset>'+					
							'<legend>'+
								'Activities / Requirements &nbsp;&nbsp;'+ 
								'<button id="btnAddActivity"  class="btnAddActivity btn btn-find" type="button"><span class="fa fa-plus"></span></button>'+
							'</legend>'+
							'<div class ="bg-light-grey">'+
									'<table id="activityTable" class="table table-striped congested-table table-hover wbs-deliverable-list" >'+
										'<thead>'+
											'<tr>'+
												'<th>Activity Code</th>'+
												'<th>Activity Name</th>'+
												'<th>Details</th>'+
												'<th>Action</th>'+
											'</tr>'+
										'</thead>'+
										'<tbody>'+
										'</tbody>'+
									'</table>'+
							'</div>'+
						'</fieldset>'+
					'</div>' +
				
			'</div>' +
		'</div>' +
	'</div>';
	$("#activityDiv").append(html);
	});
	InitHandlers();
};*/

var addActivity = function(el){
	var currentBlock = $(el).closest(".section-activity-block");
	var sectionCode = currentBlock.find(".activityDiv-section-code").val();
	var tBody = currentBlock.find("tbody");
	var html = ''+
	'<tr>'+
		'<td>'+
			'<label class="control-label">'+
				'abc'+
			'</label>'+
		'</td>'+
		'<td>'+
			'<label class="control-label">'+
				'mno'+
			'</label>'+
		'</td>'+
			'<td>'+
			'<label class="control-label">'+
				'xyz'+
			'</label>'+
		'</td>'+			
		'<td class="width-80">' +
			'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
			'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
	'</tr>';
	tBody.append(html);
}



var sectionExistCounter = 0;
var checkSectionName = function(el) {
	$(".section-block").each(function() {
		var newSectionName = $(el).val();
		var sectionName = $(this).find(".section-section-name").val();
		if ($.trim(sectionName) != "") {
			if (sectionName == newSectionName) {
				sectionExistCounter++;
			}			
		}
	});
	

	if (sectionExistCounter > 1) {
		//alert(sectionExistCounter);
		result = false;
		ShowErrorMsg("This section name already exists");
		$(el).closest(".section-block").find(".section-block-title").text(" Section Name : ");
		InitErrorChange();
		//$(".alert").html("This section name already exists");
		//$(".alert").removeClass("hidden");
		sectionExistCounter = 0;
		$(el).val("").focus();
		//alert(sectionExistCounter);
	} else {
		sectionExistCounter = 0;
	}
};

var sectionNameChanged = function(el){
	

	
	
	var sectionExistCounter = $("#activityDiv").find(".last-section-name").length;	
	var currentBlock = $(el).closest(".section-block");
	var sectionCode = currentBlock.find(".section-section-code").val();
	var sectionName = currentBlock.find(".section-section-name").val();
	var title = " Section Name : " + sectionName;
	currentBlock.find(".section-block-title").text(title);
	var currentBlockAuditteeName = currentBlock.find(".section-auditee-name").val();
	
	// setting for responsible person in data requirement tab
	localStorage.setItem(sectionName, currentBlockAuditteeName);
	
	// changing section name in the activity table
	var activityTableSectionCode;
	var activityTableRowCount = $('#activity tbody tr').length;
	if (activityTableRowCount > 0) {
		$("#activity tbody tr").each(function() {
			  $this = $(this);
			  activityTableSectionCode = $this.find(".activity-section-code").val();
			  if (activityTableSectionCode == sectionCode) {
				  $this.find(".section").html(sectionName);
				  $this.find(".activity-section-name").val(sectionName);
			  }
		});
	}
	
	// changing section name in the risk table
	var riskTableSectionCode;
	var riskTableRowCount = $('#risk tbody tr').length;
	if (riskTableRowCount > 0) {
		$("#risk tbody tr").each(function() {
			  $this = $(this);
			  riskTableSectionCode = $this.find(".risk-section-code").val();
			  if (riskTableSectionCode == sectionCode) {
				  $this.find(".section").html(sectionName);
				  $this.find(".risk-section-name").val(sectionName);
			  }
		});
	}
	
	// changing section name in the control table
	var controlTableSectionCode;
	var controlTableRowCount = $('#control tbody tr').length;
	if (controlTableRowCount > 0) {
		$("#control tbody tr").each(function() {
			  $this = $(this);
			  controlTableSectionCode = $this.find(".control-section-code").val();
			  if (controlTableSectionCode == sectionCode) {
				  $this.find(".section").html(sectionName);
				  $this.find(".control-section-name").val(sectionName);
			  }
		});
	}
	
	// changing section name in the procedure table
	var procedureTableSectionCode;
	var procedureTableRowCount = $('#procedure tbody tr').length;
	if (procedureTableRowCount > 0) {
		$("#procedure tbody tr").each(function() {
			  $this = $(this);
			  procedureTableSectionCode = $this.find(".procedure-section-code").val();
			  if (procedureTableSectionCode == sectionCode) {
				  $this.find(".section").html(sectionName);
				  $this.find(".procedure-section-name").val(sectionName);
			  }
		});
	}
	
	// changing section name in the dataRequirement table
	var dataTableSectionCode;
	var dataTableRowCount = $('#dataRequirement tbody tr').length;
	if (dataTableRowCount > 0) {
		$("#dataRequirement tbody tr").each(function() {
			  $this = $(this);
			  dataTableSectionCode = $this.find(".data-section-code").val();
			  if (dataTableSectionCode == sectionCode) {
				  $this.find(".section").html(sectionName);
				  $this.find(".data-section-name").val(sectionName);
			  }
		});
	}	
	
};

var sectionCodeChanged = function(el){
	var sectionExistCounter = $("#activityDiv").find(".last-section-name").length;	
	var currentBlock = $(el).closest(".section-block");
	var sectionCode = currentBlock.find(".section-section-code").val();
	var sectionName = currentBlock.find(".section-section-name").val();
	var title = " Section Name : " + sectionName;
	currentBlock.find(".section-block-title").text(title);
	
		$("#activityDiv .activityDiv-section-code").each(function() {
			var sectionCodeInActivityTab = $(this).val();
			if (lastSectionCode === sectionCodeInActivityTab) {
				$(this).closest(".section-activity-block").find(".activityDiv-section-code").val(sectionCode);
				return false;
			}
		});
		
		// changing the section code in risk block
		$('.section-activity-risk-block').filter(function(){
		    var $this = $(this);
		    var riskDiv_section_code = $this.find('.riskDiv-section-code').val().trim();

		    if ($this.find('.riskDiv-section-code').val() == lastSectionCode) {
		    	$this.find('.riskDiv-section-code').val(sectionCode);
		    }
		});
		
		// changing the section code in control block
		$('.section-activity-risk-control-block').filter(function(){
		    var $this = $(this);
		    var controlDiv_section_code = $this.find('.controlDiv-section-code').val().trim();

		    if ($this.find('.controlDiv-section-code').val() == lastSectionCode) {
		    	$this.find('.controlDiv-section-code').val(sectionCode);
		    }
		});
		
		// changing the section code in procedure block
		$('.section-activity-risk-control-procedure-block').filter(function(){
		    var $this = $(this);
		    var procedureDiv_section_code = $this.find('.procedureDiv-section-code').val().trim();

		    if ($this.find('.procedureDiv-section-code').val() == lastSectionCode) {
		    	$this.find('.procedureDiv-section-code').val(sectionCode);
		    }
		});
};

var lastSectionName = "";
var setLastSectionName = function(el){
	lastSectionName = $(el).val();
};

var lastSectionCode = "";
var setLastSectionCode = function(el){
	lastSectionCode = $(el).val();
};

var delSectionBlock = function(el) {
	if ($(".section-block").length > 1) {
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this block?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
			var sectionCode = $(el).closest(".section-block").find('.section-section-code').val();
			var sectionName = $(el).closest(".section-block").find('.section-section-name').val();			
	    	$(el).closest(".section-block").remove();
			removeActivitiesBySection(sectionCode);
			removeRisksBySection(sectionCode);
			removeControlsBySection(sectionCode);
			removeProceduresBySection(sectionCode);
			removeDataRequirementsBySection(sectionCode);
		});	
	} else {
		ShowErrorMsg("Only block","There must be a block at least");
	}
};

var delSectionActivityBlock = function(el){
	if ($(".section-activity-block").length > 1) {
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this block?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
	    	$(el).closest(".section-activity-block").remove();
		});	
	}
	else{
		ShowErrorMsg("Only block","There must be a block at least");
	}
};


var checkWbsDate = function (blockId){
	var prjDuration 	   = $("#project_duration").val();
	var wbsDay 			   = parseInt($(blockId).find('.wbs-start-day').val());
	var wbsDuration 	   = parseInt($(blockId).find('.wbs-duration').val()); //alert(wbsduration)
	var wbsEndFromProjectStart  = wbsDay + wbsDuration;

	if(wbsDay > prjDuration){
		ShowErrorMsg('',"Please ensure that the WBS Start Day is in between Project Start and End Date");
		return false;
	}

	if(wbsEndFromProjectStart > prjDuration){
		ShowErrorMsg('',"Please ensure that the WBS duration never exceeds project Duration");
		return false;
	}

	return true;

};

//////////////////       ACTIVITY GROUP STEP:3           //////////////////////

var addRowActGrp = function(el){
	$("#ActGrp tbody").append(
		'<tr>' +
		'<td><input name="activity_group_code[]" type="text" class="activity-group-code form-control required" value="" /></td>' +
		'<td><input name="activity_group_name[]" type="text" class="activity-group-name form-control required" value="" /></td>' +
		'<td><input name="activity_group_purpose[]" type="text" class="activity-group-purpose form-control" value="" /></td>' +
		'<td class="width-80">' +
		'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
		'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
		'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
		'</tr>'
	);
	InitHandlers();
};


var checkActiviityDate = function(blockId){
	return true;
	//read WBS code from activity block, It may have more than one WBS code.
	var wbsCode = $(blockId).find(".activity-wbs").val();   
	//read WBS code for specific code of Activity block and find its closest WBS block
	var wbsBlock = $(".wbs-wbs-code").filter(function(i){
						return $(this).val() == wbsCode;
					}).closest(".wbs-block");
	
	var actstartDate 		= $(blockId).find('.activity-start-day').val();
	var actDuration  		= $(blockId).find('.activity-duration').val();
	var wbsDuration  		= wbsBlock.find('.wbs-duration').val();
	var verifyActDuration 	= parseInt(actstartDate) + parseInt(actDuration);
	
	if(actstartDate > wbsDuration){
		ShowErrorMsg('',"You have to start activity within WBS duration");
		return false;
	}

	if(verifyActDuration > wbsDuration){
		ShowErrorMsg('',"Activity duration exceeds WBS duration");
		return false;
	}

	return true;

};
//////////////////Activity step:4//////////////////////
var ActivityChanged = function (el){
	var currentBlock = $(el).closest(".activity-block");
	var actName = currentBlock.find(".activity_name").val();
	var title = " Activity : " + actName;
	currentBlock.find(".activity-block-title").text(title);
};

var initActivityView = function(blockId){

	var wbsCodes = $(".wbs-wbs-code");
	var wbsNames = $(".wbs-wbs-name");
	var activityWbsOld = $(blockId).find(".activity-wbs").val();
	$(blockId).find(".activity-wbs").empty();
	for (var i = 0 ; i < wbsCodes.length; i++) {
	    $(blockId).find(".activity-wbs").append('<option value="' + $(wbsCodes[i]).val() + '">' + $(wbsNames[i]).val() + '</option>');
	}
	$(blockId).find(".activity-wbs").val(activityWbsOld);

	var actGrpCodes = $(".activity-group-code");
	var actGrpNames = $(".activity-group-name");
	var activityGrpOld = $(blockId).find(".activity-activitygroup").val();
	$(blockId).find(".activity-activitygroup").empty();
	for (var i = 0 ; i < actGrpCodes.length; i++) {
	    $(blockId).find(".activity-activitygroup").append('<option value="' + $(actGrpCodes[i]).val() + '">' + $(actGrpNames[i]).val() + '</option>');
	}
	$(blockId).find(".activity-activitygroup").val(activityGrpOld);

	var milestoneCodes = $(".project-milestone-code");
	var milestoneNames = $(".project-milestone-name");
	var activityMilestoneOld = $(blockId).find(".activity-milestone").val();
	$(blockId).find(".activity-milestone").empty();
	for (var i = 0 ; i < milestoneCodes.length; i++) {
	    $(blockId).find(".activity-milestone").append('<option value="' + $(milestoneCodes[i]).val() + '">' + $(milestoneNames[i]).val() + '</option>');
	}
	$(blockId).find(".activity-milestone").val(activityMilestoneOld);

	var deliCodes = $(".project-deliverable-code");
	var deliNames = $(".project-deliverable-name");
	var deliNums = $(".project-number-of-deliverable");
	var deliUnits = $(".project-deliverable-unit");

	var html = "";
	for (var i = 0 ; i < deliCodes.length; i++) {
		var code = $(deliCodes[i]).val();
		var name = $(deliNames[i]).val();
		var num = $(deliNums[i]).val();
		var unit = $(deliUnits[i]).val();
		var actNumberOld = $(blockId).find(".activity-deliverable-code[value='" + code + "']").closest("tr").find(".activity-number-of-deliverable").val();
		html += "" +
		'<tr>' +
			'<td><input name="activity_deliverable_code[]" type="text" class="activity-deliverable-code form-control required readonly" value="'+ code  + '" /></td>' +
			'<td><input name="activity_deliverable_name[]" type="text" class="activity-deliverable-name form-control required readonly" value="'+ name  + '" /></td>' +
			'<td class="width-200"><input name="activity_number_of_deliverable[]" type="text" class="activity-number-of-deliverable form-control required" numeric value="' + (actNumberOld === undefined ? num : actNumberOld) + '" /></td>' +
			'<td class="width-200"><input name="activity_deliverable_unit[]" type="text" class="activity-deliverable-unit form-control required readonly" value="' + unit + '" /></td>' +
			'<td class="width-80">' +
				'<input type="hidden"  name="activity_deliverable_activity_code[]" class="activity-deliverable-activity-code" />' + 
				'<input type="hidden"  name="activity_deliverable_activity_name[]" class="activity-deliverable-activity-name" />' + 
				'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
				'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
				'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
			'</td>' +
		'</tr>';
		InitHandlers();
	}
	$(blockId).find(".activity-deliverable-list tbody").html(html);
};

var showFindActivityOwner = function(el){	
	$(".activity-block").removeClass("current-activity-block");
	ShowModal("/searchemployee/?action_type_code=SELECT&actioncallback=loadOwnerActivity");
	var currentActivityBlock = $(el).closest(".activity-block");
	currentActivityBlock.addClass("current-activity-block");
};

var loadOwnerActivity = function(owndata){ 
	event.preventDefault();
	var own = JSON.parse(unescape(owndata));
	$(".current-activity-block .activity-owner-code").val(own.emp_code);
	$(".current-activity-block .activity-owner-name").val(own.emp_name);	
	$(".current-activity-block .activity-owner-username").val(own.username);	
	$(".current-activity-block .activity-owner-desig").val(own.desig);	
	$(".current-activity-block .activity-owner-email").val(own.email);		
	$(".current-activity-block .activity-owner-mobile").val(own.mobile);	
	$(".current-activity-block .activity-owner-company-code").val(own.company_code);	
	$(".current-activity-block .activity-owner-company-name").val(own.company_name);	
	HideModal('search-modal');	
};

var addActivityBlock = function(){
	var id = new Date().getTime();
	var html = '' +
	'<div class=" activity-block panel panel-light-grey" data-id="' + id + '">' +
		'<div class="panel-heading">' +
			'<h5 class="panel-title">' +
				'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#activity-block' + id + '">'+
					'<i class="icon-arrow"></i>' +
					'<span class="activity-block-title"> Activity</span>' +
				'</a>' +
			'</h5>' +
		'</div>' +
		'<div id="activity-block' + id + '" class="panel-collapse collapse in">' +
			'<div class="panel-body">' +
				'<div class="row">' +
					'<div class="col-md-12">' +
			   			'<button class="btn btn-xs btn-red btn-o pull-right" onclick="delActivityBlock(this);"><span class="fa fa-close"> Delete</span></button>' +
			  	 	'</div>' +			
			   	'</div>' +			
				'<div class="row">' +
					'<div class="col-md-6">' +							
						'<div class="row">' +
							'<div class="col-md-6 form-group">' +
								'<label class="control-label">Activity Code</label>' +
							    '<input name="activity_code[]" type="text" class="activity_code form-control required"  />' +						
							'</div>' +
							'<div class="col-md-6 form-group">' +	
								'<label class="control-label">Activity Name</label>' +
								'<input name="activity_name[]" type="text" class="activity_name form-control required" onchange="ActivityChanged(this)"  />' +
							'</div>' +
						'</div>' +						
						'<div class="row">' +
							'<div class="col-md-6 form-group">' +
								'<label class="control-label">WBS</label>' +
								'<select name="activity_wbs[]" class="activity-wbs form-control" onchange="ActivityChanged(this)"></select>' +
							'</div>' +
							'<div class="col-md-6 form-group">' +	
								'<label class="control-label">Activity Group</label>' +
							    '<select name="activity_activitygroup[]" class="activity-activitygroup form-control"></select>' +						
							'</div>' +
						'</div>' +
						'<div class="row">' +
							'<div class="col-md-6 form-group">' +
								'<label class="control-label">Milestone</label>' +
								'<select name="activity_milestone[]" class="activity-milestone form-control"></select>' +
							'</div>' +
						'</div>' +						
						'<div class="row">' +
							'<div class="col-md-12 form-group">' +	
							    '<label class="control-label">Purpose</label>' +
								'<textarea name="activity_purpose[]" type="text" class="activity-purpose form-control"  />' +
							'</div>' +
						'</div>' +
						'<div class="row">' +
							'<div class="col-md-6 form-group">' +
								'<label class="control-label">Start Day  <small>(From Project Commencement)</small></label>' + 
								'<input name="activity_start_day[]" type="text" class="activity-start-day form-control number required"/>' +
							'</div>' +
							'<div class="col-md-6 form-group">' +
								'<label class="control-label">Duration <small>(in days)</small></label>' + 
								'<input name="activity_duration[]" type="text" class="activity-duration form-control number required"/>' +
							'</div>' +
						'</div>' +								
					'</div>' +
					'<div class="col-md-6 form-group">' +
						'<fieldset class="bg-light-grey">'+
						'<legend>'+
						'Owner&nbsp;&nbsp;'+ 
						'<button id="btnActivitySearch" onclick="showFindActivityOwner(this);" class="btn btn-find" type="button"><span class="fa fa-search"></span></button>'+
						'</legend>'+
						'<div class="col-md-6 form-group">' +	
						'<label class="control-label">Owner Code</label>' + 
						'<input name="activity_owner_code[]" type="text" class="activity-owner-code form-control required" readonly="readonly" />' +
						'<label class="control-label">User Name</label>' + 
						'<input name="activity_owner_username[]" type="text" class="activity-owner-username form-control" readonly="readonly" />' +
						'<label class="control-label">Mobile</label>' + 
						'<input name="activity_owner_mobile[]" type="text" class="activity-owner-mobile form-control" readonly="readonly" />' +
						'<label class="control-label">Company Code</label>' + 
						'<input name="activity_owner_company_code[]" type="text" class="activity-owner-company-code form-control" readonly="readonly" />' +
						'</div>' +
						'<div class="col-md-6 form-group">' +	
						'<label class="control-label">Owner Name</label>' + 
						'<input name="activity_owner_name[]" type="text" class="activity-owner-name form-control required" readonly="readonly" />' +
						'<label class="control-label">Designation</label>' + 
						'<input name="activity_owner_desig[]" type="text" class="activity-owner-desig form-control" readonly="readonly" />' +
						'<label class="control-label">Email</label>' + 
						'<input name="activity_owner_email[]" type="text" class="activity-owner-email form-control" readonly="readonly" />' +
						'<label class="control-label">Company Name</label>' + 
						'<input name="activity_owner_company_name[]" type="text" class="activity-owner-company-name form-control" readonly="readonly" />' +
						'</div>' +
					    '</fieldset>'+
					'</div>' +
				'</div>' +
				'<div class="row">' +							
					'<div class="col-md-12 form-group">' +
						'<fieldset>'+
							'<legend>'+
								'Activity Deliverable&nbsp;&nbsp;'+
									'<button class="btn btn-find btn-activity-deliverable" type="button"><span class="fa fa-plus"></span></button>'+   
							'</legend>'+
							'<div class ="activity-activity-deliverable bg-light-grey">'+
									'<table class="table table-striped congested-table table-hover activity-deliverable-list" id="ActDeliverable" >'+
										'<thead>'+
											'<tr>'+
												'<th>Code</th>'+
												'<th>Name</th>'+										
												'<th>Quantity</th>'+
												'<th>Unit of Measurement</th>'+
												'<th>Action</th>'+
											'</tr>'+
										'</thead>'+
										'<tbody>'+
										'</tbody>'+
									'</table>'+
							'</div>'+
						'</fieldset>'+
					'</div>' +
				'</div>' +	
			'</div>' +
		'</div>' +
	'</div>';
	$("#ActivityBlocks").append(html);
	initActivityView("#activity-block" + id);
	$(".btn-activity-deliverable").on("click", addRowActDel);
	InitHandlers();
};
	
var addRowActDel = function(el){
	$("#ActDeliverable tbody").append(
		'<tr>' +
		'<td><input name="activity_deliverable_code[]" type="text" class="activity-deliverable-code form-control required" value="" /></td>' +
		'<td><input name="activity_deliverable_name[]" type="text" class="activity-deliverable-name form-control required" value="" /></td>' +
		'<td class="width-200"><input name="activity_number_of_deliverable[]" type="text" class="activity-number-of-deliverable form-control required" numeric value=""/></td>' +
		'<td class="width-200"><input name="activity_deliverable_unit[]" type="text" class="activity-deliverable-unit form-control required" value="" /></td>' +
		'<td class="width-80">' +
		'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
		'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
		'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
		'</tr>'
		);
	InitHandlers();
};

var delActivityBlock = function(el){
	if ($(".activity-block").length > 1) {
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this block?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
	    	$(el).closest(".activity-block").remove();
		});	
	}
	else{
		ShowErrorMsg("Only block","There must be a block at least");
	}
};



/////////////////////////////////////////////////////////////////////////////////////////
//                                   COMMON FUNCTIONS
/////////////////////////////////////////////////////////////////////////////////////////
function showMessage(data) {
	if(data.outcome == 'success'){
		ShowSuccessMsg('Audit created', data.message);
		LoadMainContent('grc/as/audit/show/' + data.id );
	}
	else{
		ShowErrorMsg('Audit was not created', data.message);
		var msg = ConcatWithBR(data.error);
		$(".alert").html(msg);
		$(".alert").removeClass("hidden");
	}
}

function validate(){
	SyncOptionText();
	$(".wbs-deliverable-wbs-code").each(function(i, item){
		$(item).val($(item).closest(".wbs-block").find(".wbs-wbs-code").val());
	});
	$(".wbs-deliverable-wbs-name").each(function(i, item){
		$(item).val($(item).closest(".wbs-block").find(".wbs-wbs-name").val());
	});
	$(".activity-deliverable-activity-code").each(function(i, item){
		$(item).val($(item).closest(".activity-block").find(".activity_code").val());
	});
	$(".activity-deliverable-activity-name").each(function(i, item){
		$(item).val($(item).closest(".activity-block").find(".activity_name").val());
	});
	return true;
}

var delRow = function(el){
	var tableName = $(el).closest("table").prop("id");
	var item = "item" ;
	var minCount = 0 ;
	switch(tableName) {
    case "Deliverable":
        item = "Deliverable";
        minCount = 1;
        break;
    case "Attachment":
        item = "Attachment";
        minCount = 0;
        break;
    case "BillingPlan":
        item = "BillingPlan";
        minCount = 0;
        break;
   	case "ActGrp":
        item = "ActGrp";
        minCount = 1;        
        break; 
   	case "auditTeamTable":
        item = "auditTeamTable";
        minCount = 1;        
        break; 
   	case "activityTable":
        item = "activityTable";
        minCount = 1;        
        break; 
   	case "riskTable":
        item = "riskTable";
        minCount = 1;        
        break; 
   	case "controlTable":
        item = "controlTable";
        minCount = 1;        
        break; 
   	case "procedure":
        item = "procedure";
        minCount = 1;        
        break; 
   	case "activity":
        item = "activity";
        minCount = 1;        
        break; 
   	case "risk":
        item = "risk";
        minCount = 1;        
        break; 
   	case "control":
        item = "control";
        minCount = 1;        
        break; 
   	case "dataRequirement":
        item = "dataRequirement";
        minCount = 1;        
        break;

    default:
        break;
	}
	
	if (tableName == 'activity' || tableName == 'risk' || tableName == 'control' || tableName == 'procedure' || tableName == 'dataRequirement') {
		if ($(el).closest("table").find("tbody tr").length > minCount) {
			swal({
				title: "Are you sure?",
				text: "Are you sure to delete this " + item + "?",
				type: "warning",
				showCancelButton: true,
				confirmButtonColor: "#007AFF",
				confirmButtonText: "Yes, delete it!",
				closeOnConfirm: true
			}, function() {
				if (tableName == 'activity') {
					var sectionCode = $(el).closest("tr").find(".activity-section-code").val();
					var activity = $(el).closest("tr").find(".activity-name").val();
					
					removeRisksByActivity(sectionCode, activity);
					removeControlsByActivity(sectionCode, activity);
					removeProceduresByActivity(sectionCode, activity);
					removeDataRequirementsByActivity(sectionCode, activity);
				} else if (tableName == 'risk') {
					var sectionCode = $(el).closest("tr").find(".risk-section-code").val();
					var activity = $(el).closest("tr").find(".risk-activity").val();
					var risk = $(el).closest("tr").find(".risk-name").val();
					
					removeControlsByRisk(sectionCode, activity, risk);
					removeProceduresByRisk(sectionCode, activity, risk);
					removeDataRequirementsByRisk(sectionCode, activity, risk);
				} else if (tableName == 'control') {
					var sectionCode = $(el).closest("tr").find(".control-section-code").val();
					var activity = $(el).closest("tr").find(".control-activity").val();
					var risk = $(el).closest("tr").find(".control-risk").val();
					var control = $(el).closest("tr").find(".txt-control-name").val();
					
					removeProceduresByControl(sectionCode, activity, risk, control);
					removeDataRequirementsByControl(sectionCode, activity, risk, control);
				} else if (tableName == 'procedure') {
					var sectionCode = $(el).closest("tr").find(".procedure-section-code").val();
					var activity = $(el).closest("tr").find(".procedure-activity").val();
					var risk = $(el).closest("tr").find(".procedure-risk").val();
					var control = $(el).closest("tr").find(".procedure-control").val();
					var procedure = $(el).closest("tr").find(".txt-procedure-name").val();
					
					removeDataRequirementsByProcedure(sectionCode, activity, risk, control, procedure);
				}
				$(el).closest("tr").remove();
			});	
		}
		else{
			ShowErrorMsg("Only " + item, "There must be a " + item + " at least");
		}
	}
	else if ($("#"+ tableName).find("tbody tr").length > minCount) {
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this " + item + "?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
			$(el).closest("tr").remove();
		});	
	}
	else{
		ShowErrorMsg("Only " + item, "There must be a " + item + " at least");
	}
};

var removeRisksByActivity = function(sectionCode, activity) {
	var riskTableSectionCode, riskTableActivity;
	var riskTableRowCount = $('#risk tbody tr').length;
	if (riskTableRowCount > 0) {
		$("#risk tbody tr").each(function() {
			  $this = $(this);
			  riskTableSectionCode = $this.find(".risk-section-code").val();
			  riskTableActivity = $this.find(".risk-activity").val();
			  if (riskTableSectionCode == sectionCode && riskTableActivity == activity) {
				  $this.remove();
			  }
		});
	}
};

var removeControlsByActivity = function(sectionCode, activity){
	var controlTableSectionCode, controlTableActivity;
	var controlTableRowCount = $('#control tbody tr').length;
	if (controlTableRowCount > 0) {
		$("#control tbody tr").each(function() {
			  $this = $(this);
			  controlTableSectionCode = $this.find(".control-section-code").val();
			  controlTableActivity = $this.find(".control-activity").val();
			  if (controlTableSectionCode == sectionCode && controlTableActivity == activity) {
				  $this.remove();
			  }
		});
	}
};

var removeProceduresByActivity = function(sectionCode, activity){
	var procedureTableSectionCode, procedureTableActivity;
	var procedureTableRowCount = $('#procedure tbody tr').length;
	if (procedureTableRowCount > 0) {
		$("#procedure tbody tr").each(function() {
			  $this = $(this);
			  procedureTableSectionCode = $this.find(".procedure-section-code").val();
			  procedureTableActivity = $this.find(".procedure-activity").val();
			  if (procedureTableSectionCode == sectionCode && procedureTableActivity == activity) {
				  $this.remove();
			  }
		});
	}
};

var removeDataRequirementsByActivity = function(sectionCode, activity) {
	var dataTableSectionCode, dataTableActivity;
	var dataTableRowCount = $('#dataRequirement tbody tr').length;
	if (dataTableRowCount > 0) {
		$("#dataRequirement tbody tr").each(function() {
			  $this = $(this);
			  dataTableSectionCode = $this.find(".data-section-code").val();
			  dataTableActivity = $this.find(".data-activity").val();
			  if (dataTableSectionCode == sectionCode && dataTableActivity == activity) {
				  $this.remove();
			  }
		});
	}
};

var removeControlsByRisk = function(sectionCode, activity, risk) {
	var controlTableSectionCode, controlTableActivity, controlTableRisk;
	var controlTableRowCount = $('#control tbody tr').length;
	if (controlTableRowCount > 0) {
		$("#control tbody tr").each(function() {
			  $this = $(this);
			  controlTableSectionCode = $this.find(".control-section-code").val();
			  controlTableActivity = $this.find(".control-activity").val();
			  controlTableRisk = $this.find(".control-risk").val();
			  if (controlTableSectionCode == sectionCode && controlTableActivity == activity && controlTableRisk == risk) {
				  $this.remove();
			  }
		});
	}
};

var removeProceduresByRisk = function(sectionCode, activity, risk) {
	var procedureTableSectionCode, procedureTableActivity, procedureTableRisk;
	var procedureTableRowCount = $('#procedure tbody tr').length;
	if (procedureTableRowCount > 0) {
		$("#procedure tbody tr").each(function() {
			  $this = $(this);
			  procedureTableSectionCode = $this.find(".procedure-section-code").val();
			  procedureTableActivity = $this.find(".procedure-activity").val();
			  procedureTableRisk = $this.find(".procedure-risk").val();
			  if (procedureTableSectionCode == sectionCode && procedureTableActivity == activity && procedureTableRisk == risk) {
				  $this.remove();
			  }
		});
	}
};

var removeDataRequirementsByRisk = function(sectionCode, activity, risk) {
	var dataTableSectionCode, dataTableActivity, dataTableRisk;
	var dataTableRowCount = $('#dataRequirement tbody tr').length;
	if (dataTableRowCount > 0) {
		$("#dataRequirement tbody tr").each(function() {
			  $this = $(this);
			  dataTableSectionCode = $this.find(".data-section-code").val();
			  dataTableActivity = $this.find(".data-activity").val();
			  dataTableRisk = $this.find(".data-risk").val();
			  if (dataTableSectionCode == sectionCode && dataTableActivity == activity && dataTableRisk == risk) {
				  $this.remove();
			  }
		});
	}
};

var removeProceduresByControl = function(sectionCode, activity, risk, control) {
	var procedureTableSectionCode, procedureTableActivity, procedureTableRisk, procedureTableControl;
	var procedureTableRowCount = $('#procedure tbody tr').length;
	if (procedureTableRowCount > 0) {
		$("#procedure tbody tr").each(function() {
			  $this = $(this);
			  procedureTableSectionCode = $this.find(".procedure-section-code").val();
			  procedureTableActivity = $this.find(".procedure-activity").val();
			  procedureTableRisk = $this.find(".procedure-risk").val();
			  procedureTableControl = $this.find(".procedure-control").val();
			  if (procedureTableSectionCode == sectionCode && procedureTableActivity == activity && procedureTableRisk == risk && procedureTableControl == control) {
				  $this.remove();
			  }
		});
	}
};

var removeDataRequirementsByControl = function(sectionCode, activity, risk, control) {
	var dataTableSectionCode, dataTableActivity, dataTableRisk, dataTableControl;
	var dataTableRowCount = $('#dataRequirement tbody tr').length;
	if (dataTableRowCount > 0) {
		$("#dataRequirement tbody tr").each(function() {
			  $this = $(this);
			  dataTableSectionCode = $this.find(".data-section-code").val();
			  dataTableActivity = $this.find(".data-activity").val();
			  dataTableRisk = $this.find(".data-risk").val();
			  dataTableControl = $this.find(".data-control").val();
			  if (dataTableSectionCode == sectionCode && dataTableActivity == activity && dataTableRisk == risk && dataTableControl == control) {
				  $this.remove();
			  }
		});
	}
};

var removeDataRequirementsByProcedure = function(sectionCode, activity, risk, control, procedure) {
	var dataTableSectionCode, dataTableActivity, dataTableRisk, dataTableControl, dataTableProcedure;
	var dataTableRowCount = $('#dataRequirement tbody tr').length;
	if (dataTableRowCount > 0) {
		$("#dataRequirement tbody tr").each(function() {
			  $this = $(this);
			  dataTableSectionCode = $this.find(".data-section-code").val();
			  dataTableActivity = $this.find(".data-activity").val();
			  dataTableRisk = $this.find(".data-risk").val();
			  dataTableControl = $this.find(".data-control").val();
			  dataTableProcedure = $this.find(".data-procedure").val();
			  if (dataTableSectionCode == sectionCode && dataTableActivity == activity && dataTableRisk == risk && dataTableControl == control && dataTableProcedure == procedure) {
				  $this.remove();
			  }
		});
	}
};

var removeActivitiesBySection = function(sectionCode) {
	var activityTableSectionCode;
	var activityTableRowCount = $('#activity tbody tr').length;
	if (activityTableRowCount > 0) {
		$("#activity tbody tr").each(function() {
			  $this = $(this);
			  activityTableSectionCode = $this.find(".activity-section-code").val();
			  if (activityTableSectionCode == sectionCode) {
				  $this.remove();
			  }
		});
	}
};

var removeRisksBySection = function(sectionCode) {
	var riskTableSectionCode;
	var riskTableRowCount = $('#risk tbody tr').length;
	if (riskTableRowCount > 0) {
		$("#risk tbody tr").each(function() {
			  $this = $(this);
			  riskTableSectionCode = $this.find(".risk-section-code").val();
			  if (riskTableSectionCode == sectionCode) {
				  $this.remove();
			  }
		});
	}
};

var removeControlsBySection = function(sectionCode) {
	var controlTableSectionCode;
	var controlTableRowCount = $('#control tbody tr').length;
	if (controlTableRowCount > 0) {
		$("#control tbody tr").each(function() {
			  $this = $(this);
			  controlTableSectionCode = $this.find(".control-section-code").val();
			  if (controlTableSectionCode == sectionCode) {
				  $this.remove();
			  }
		});
	}
};

var removeProceduresBySection = function(sectionCode) {
	var procedureTableSectionCode;
	var procedureTableRowCount = $('#procedure tbody tr').length;
	if (procedureTableRowCount > 0) {
		$("#procedure tbody tr").each(function() {
			  $this = $(this);
			  procedureTableSectionCode = $this.find(".procedure-section-code").val();
			  if (procedureTableSectionCode == sectionCode) {
				  $this.remove();
			  }
		});
	}
};

var removeDataRequirementsBySection = function(sectionCode) {
	var dataRequirementTableSectionCode;
	var dataRequirementTableRowCount = $('#dataRequirement tbody tr').length;
	if (dataRequirementTableRowCount > 0) {
		$("#dataRequirement tbody tr").each(function() {
			  $this = $(this);
			  dataRequirementTableSectionCode = $this.find(".data-section-code").val();
			  if (dataRequirementTableSectionCode == sectionCode) {
				  $this.remove();
			  }
		});
	}
};

var upRow = function(el){
	var row = $(el).closest("tr");
	row.insertBefore(row.prev());
};

var downRow = function(el){
	var row = $(el).closest("tr");
	row.insertAfter(row.next());
};

var upSectionDiv = function(el){
	var mainDivClass = $(el).attr("mainDivClass");
	var div = $(el).closest("." + mainDivClass);
	div.insertBefore(div.prev());
};

var downSectionDiv = function(el){
	var mainDivClass = $(el).attr("mainDivClass");
	var div = $(el).closest("." + mainDivClass);
	div.insertAfter(div.next());
};

$("#scheduled_start_date, #scheduled_end_date").on('change', showProjectDuration);
$('#project_currency_code').on('change', getExRate);
$("#btnDeliverable").on("click", addRowDeliverable);
$("#btnMilestone").on("click", addRowMilestone);
$("#btnAttachment").on("click", addRowAttachment);
$("#btnBillingPlan").on("click", addRowBillingPlan);
$("#btnAddSection").on("click", addSectionBlock);
//$("#btnAddActivity").on("click", addActivity);
$("#btnActGrp").on("click", addRowActGrp);
$("#btnActivity").on("click", addActivityBlock);

$(document).on("click", ".btnAddActivity", function(){
	//var currentBlock = $(this).closest(".section-activity-block");
	var currentBlock = $(this).closest(".each-section-block");
	var currentBlockId = currentBlock.attr("id");
	alert("currentBlockId" + currentBlockId);
	var sectionCode = currentBlock.find(".activityDiv-section-code").val();
	var currentTBody = currentBlock.find("tbody");
	
	ShowModal("grc/as/audit/activitymodal/?current_block_id='"+currentBlockId+"'");
	
	/*currentTBody.append("<tr><td>abc</td></tr>");
	alert(JSON.stringify(currentTBody));*/
});

$(document).on("click", "#btnActivityModalOk", function(){
	var currentBlockId = $("#currentBlockId").val();
	var currentTBody = $("div[id=" + currentBlockId + "]").find('tbody');
	var sectionCode = $("div[id=" + currentBlockId + "]").find(".activityDiv-section-code").val();
	var sectionName = $("div[id=" + currentBlockId + "]").find(".activityDiv-section-name").val();
	var activityCode = $("#activity_code").val();
	var activityName = $("#activity_name").val();
	var activityDetails = $("#activity_details").val();
	alert(currentBlockId);
	
	if (activityCode == '' || activityName == '' || activityDetails == '') {
		alert("Please fill all the fields");
		return false;
	}
	
	var html = ''+
	'<tr>'+
		'<td>'+
			'<label class="control-label">'+
			activityCode +
			'</label>'+
		'</td>'+
		'<td>'+
			'<label class="control-label">'+
			activityName +
			'</label>'+
		'</td>'+
			'<td>'+
			'<label class="control-label">'+
			activityDetails +
			'</label>'+
		'</td>'+			
		'<td class="width-80">' +
			'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
			'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
	'</tr>';
	currentTBody.append(html);
	HideModal('search-modal');
	addSectionActivityToRisk(sectionCode, sectionName, activityCode, activityName);
});

$(document).on("click", ".btnAddRisk", function(){
	var currentBlock = $(this).closest(".each-section-activity-risk-block");
	var currentBlockId = currentBlock.attr("id");
	//alert("currentBlockId" + currentBlockId);
	var sectionCode = currentBlock.find(".riskDiv-section-code").val();
	var currentTBody = currentBlock.find("tbody");
	//alert(sectionCode);
	
	ShowModal("grc/as/audit/riskmodal/?current_block_id='"+currentBlockId+"'");
});

$(document).on("click", "#btnRiskModalOk", function(){
	var currentBlockId = $("#currentBlockId").val();
	var currentTBody = $("div[id=" + currentBlockId + "]").find('tbody');
	var sectionCode = $("div[id=" + currentBlockId + "]").find(".riskDiv-section-code").val();
	var sectionName = $("div[id=" + currentBlockId + "]").find(".riskDiv-section-name").val();
	var activityCode = $("div[id=" + currentBlockId + "]").find(".riskDiv-activity-code").val();
	var activityName = $("div[id=" + currentBlockId + "]").find(".riskDiv-activity-name").val();
	var riskCode = $("#risk_code").val();
	var riskName = $("#risk_name").val();
	var riskDetails = $("#risk_details").val();
	//alert(currentBlockId);
	
	if (riskCode == '' || riskName == '' || riskDetails == '') {
		alert("Please fill all the fields");
		return false;
	}
	
	var html = ''+
	'<tr>'+
		'<td>'+
			'<label class="control-label">'+
			riskCode +
			'</label>'+
		'</td>'+
		'<td>'+
			'<label class="control-label">'+
			riskName +
			'</label>'+
		'</td>'+
			'<td>'+
			'<label class="control-label">'+
			riskDetails +
			'</label>'+
		'</td>'+			
		'<td class="width-80">' +
			'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
			'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
	'</tr>';
	currentTBody.append(html);
	HideModal('search-modal');
	addSectionActivityRiskToControl(sectionCode, sectionName, activityCode, activityName, riskCode, riskName);
});

$(document).on("click", ".btnAddControl", function(){
	var currentBlock = $(this).closest(".each-section-activity-risk-control-block");
	var currentBlockId = currentBlock.attr("id");
	//alert("currentBlockId" + currentBlockId);
	var sectionCode = currentBlock.find(".controlDiv-section-code").val();
	var currentTBody = currentBlock.find("tbody");
	//alert(sectionCode);
	
	ShowModal("grc/as/audit/controlmodal/?current_block_id='"+currentBlockId+"'");
});

$(document).on("click", "#btnControlModalOk", function(){
	var currentBlockId = $("#currentBlockId").val();
	var currentTBody = $("div[id=" + currentBlockId + "]").find('tbody');
	var sectionCode = $("div[id=" + currentBlockId + "]").find(".controlDiv-section-code").val();
	var sectionName = $("div[id=" + currentBlockId + "]").find(".controlDiv-section-name").val();
	var activityCode = $("div[id=" + currentBlockId + "]").find(".controlDiv-activity-code").val();
	var activityName = $("div[id=" + currentBlockId + "]").find(".controlDiv-activity-name").val();
	var riskCode = $("div[id=" + currentBlockId + "]").find(".controlDiv-risk-code").val();
	var riskName = $("div[id=" + currentBlockId + "]").find(".controlDiv-risk-name").val();
	var controlCode = $("#control_code").val();
	var controlName = $("#control_name").val();
	var controlDetails = $("#control_details").val();
	//alert(currentBlockId);
	
	if (controlCode == '' || controlName == '' || controlDetails == '') {
		alert("Please fill all the fields");
		return false;
	}
	
	var html = ''+
	'<tr>'+
		'<td>'+
			'<label class="control-label">'+
			controlCode +
			'</label>'+
		'</td>'+
		'<td>'+
			'<label class="control-label">'+
			controlName +
			'</label>'+
		'</td>'+
			'<td>'+
			'<label class="control-label">'+
			controlDetails +
			'</label>'+
		'</td>'+			
		'<td class="width-80">' +
			'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
			'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
	'</tr>';
	currentTBody.append(html);
	HideModal('search-modal');
	addSectionActivityRiskControlToTestProcedure(sectionCode, sectionName, activityCode, activityName, riskCode, riskName, controlCode, controlName);
});

$(document).on("click", ".btnAddProcedure", function(){
	var currentBlock = $(this).closest(".each-section-activity-risk-control-procedure-block");
	var currentBlockId = currentBlock.attr("id");
	//alert("currentBlockId" + currentBlockId);
	var sectionCode = currentBlock.find(".riskDiv-section-code").val();
	var currentTBody = currentBlock.find("tbody");
	//alert(sectionCode);
	
	ShowModal("grc/as/audit/testproceduremodal/?current_block_id='"+currentBlockId+"'");
});

$(document).on("click", "#btnProcedureModalOk", function(){
	var currentBlockId = $("#currentBlockId").val();
	var currentTBody = $("div[id=" + currentBlockId + "]").find('tbody');
	var sectionCode = $("div[id=" + currentBlockId + "]").find(".procedureDiv-section-code").val();
	var sectionName = $("div[id=" + currentBlockId + "]").find(".procedureDiv-section-name").val();
	var activityCode = $("div[id=" + currentBlockId + "]").find(".procedureDiv-activity-code").val();
	var activityName = $("div[id=" + currentBlockId + "]").find(".procedureDiv-activity-name").val();
	var riskCode = $("div[id=" + currentBlockId + "]").find(".procedureDiv-risk-code").val();
	var riskName = $("div[id=" + currentBlockId + "]").find(".procedureDiv-risk-name").val();
	var controlCode = $("div[id=" + currentBlockId + "]").find(".procedureDiv-control-code").val();
	var controlName = $("div[id=" + currentBlockId + "]").find(".procedureDiv-control-name").val();
	var procedureCode = $("#procedure_code").val();
	var procedureName = $("#procedure_name").val();
	var procedureDetails = $("#procedure_details").val();
	//alert(currentBlockId);
	
	if (procedureCode == '' || procedureName == '' || procedureDetails == '') {
		alert("Please fill all the fields");
		return false;
	}
	
	var html = ''+
	'<tr>'+
		'<td>'+
			'<label class="control-label">'+
			procedureCode +
			'</label>'+
		'</td>'+
		'<td>'+
			'<label class="control-label">'+
			procedureName +
			'</label>'+
		'</td>'+
			'<td>'+
			'<label class="control-label">'+
			procedureDetails +
			'</label>'+
		'</td>'+			
		'<td class="width-80">' +
			'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
			'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
	'</tr>';
	currentTBody.append(html);
	HideModal('search-modal');
	//addSectionActivityRiskControlToTestProcedure(sectionCode, sectionName, activityCode, activityName, riskCode, riskName, controlCode, controlName);
});

var addSectionActivityToRisk = function(sectionCode, sectionName, activityCode, activityName){
	alert("section Code :: " + sectionCode + " || section Name :: " + sectionName+ " || activity code :: " + activityCode+ " || activity Name :: " + activityName);
	/*return false;
	var eachSectionCode = sectionCode;
	var eachSectionName = sectionName;*/

var id = new Date().getTime();
var html = '' +
'<div class="section-activity-risk-block panel panel-light-grey" data-id="' + id + '">' +
	'<div class="panel-heading">' +
		'<h5 class="panel-title">' +
			'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#section_activity_risk_block' + id + '">'+
				'<i class="icon-arrow"></i>' +
				'<span class="section-activity-risk-block-title"> Section : ' + '<label class="last-section-name">' + sectionName + '</label>' + '&nbsp; || <b>Activity :</b> ' + '<label class="last-section-activity-name">' + activityName + '</label>' + '</span>' +
			'</a>' +
		'</h5>' +
	'</div>' +
	'<div id="section_activity_risk_block' + id + '" class="each-section-activity-risk-block panel-collapse collapse in">' +
		'<div class="panel-body">' +	
			'<div class="col-md-6 form-group">' +
				'<label class="control-label">Section Code</label>' +
			    '<input name="riskDiv_section_code[]" type="text" value="'+sectionCode+'" class="riskDiv-section-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-6 form-group">' +	
				 '<label class="control-label">Section Name</label>' +
				 '<input name="riskDiv_section_name[]" type="text"  value="'+sectionName+'" class="riskDiv-section-name readonly form-control required"/>' +
			'</div>' +	
			'<div class="col-md-6 form-group">' +
				'<label class="control-label">Activity Code</label>' +
			    '<input name="riskDiv_activity_code[]" type="text" value="'+activityCode+'" class="riskDiv-activity-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-6 form-group">' +	
				 '<label class="control-label">Activity Name</label>' +
				 '<input name="riskDiv_activity_name[]" type="text"  value="'+activityName+'" class="riskDiv-activity-name readonly form-control required"/>' +
			'</div>' +
										
				'<div class="col-md-12 form-group">' +
					'<fieldset>'+					
						'<legend>'+
							'Risk &nbsp;&nbsp;'+ 
							'<button id="btnAddRisk"  class="btnAddRisk btn btn-find" type="button"><span class="fa fa-plus"></span></button>'+
						'</legend>'+
						'<div class ="bg-light-grey">'+
								'<table id="riskTable" class="table table-striped congested-table table-hover" >'+
									'<thead>'+
										'<tr>'+
											'<th>Risk Code</th>'+
											'<th>Risk Name</th>'+
											'<th>Details</th>'+
											'<th>Action</th>'+
										'</tr>'+
									'</thead>'+
									'<tbody>'+
									'</tbody>'+
								'</table>'+
						'</div>'+
					'</fieldset>'+
				'</div>' +
			
		'</div>' +
	'</div>' +
'</div>';
$("#activityRiskDiv").append(html);
InitHandlers();
};

var addSectionActivityRiskToControl = function(sectionCode, sectionName, activityCode, activityName, riskCode, riskName){
	//alert("section Code :: " + sectionCode + " || section Name :: " + sectionName+ " || activity code :: " + activityCode+ " || activity Name :: " + activityName+ " || risk code :: " + riskCode+ " || risk Name :: " + riskName);
//return false;

var id = new Date().getTime();
var html = '' +
'<div class="section-activity-risk-control-block panel panel-light-grey" data-id="' + id + '">' +
	'<div class="panel-heading">' +
		'<h5 class="panel-title">' +
			'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#section_activity_risk_control_block' + id + '">'+
				'<i class="icon-arrow"></i>' +
				'<span class="section-activity-risk-control-block-title"> Section : ' + '<label class="last-section-name">' + sectionName + '</label>' + '&nbsp; || <b>Activity :</b> ' + '<label class="last-section-activity-name">' + activityName + '</label>' + '&nbsp; || <b>Risk :</b> ' + '<label class="last-section-activity-risk-name">' + riskName + '</label>' + '</span>' +
			'</a>' +
		'</h5>' +
	'</div>' +
	'<div id="section_activity_risk_control_block' + id + '" class="each-section-activity-risk-control-block panel-collapse collapse in">' +
		'<div class="panel-body">' +	
			'<div class="col-md-6 form-group">' +
				'<label class="control-label">Section Code</label>' +
			    '<input name="controlDiv_section_code[]" type="text" value="'+sectionCode+'" class="controlDiv-section-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-6 form-group">' +	
				 '<label class="control-label">Section Name</label>' +
				 '<input name="controlDiv_section_name[]" type="text"  value="'+sectionName+'" class="controlDiv-section-name readonly form-control required"/>' +
			'</div>' +	
			'<div class="col-md-6 form-group">' +
				'<label class="control-label">Activity Code</label>' +
			    '<input name="controlDiv_activity_code[]" type="text" value="'+activityCode+'" class="controlDiv-activity-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-6 form-group">' +	
				 '<label class="control-label">Activity Name</label>' +
				 '<input name="controlDiv_activity_name[]" type="text"  value="'+activityName+'" class="controlDiv-activity-name readonly form-control required"/>' +
			'</div>' +	
				'<div class="col-md-6 form-group">' +
				'<label class="control-label">Risk Code</label>' +
			    '<input name="controlDiv_risk_code[]" type="text" value="'+riskCode+'" class="controlDiv-risk-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-6 form-group">' +	
				 '<label class="control-label">Risk Name</label>' +
				 '<input name="controlDiv_risk_name[]" type="text"  value="'+riskName+'" class="controlDiv-risk-name readonly form-control required"/>' +
			'</div>' +
										
				'<div class="col-md-12 form-group">' +
					'<fieldset>'+					
						'<legend>'+
							'Control &nbsp;&nbsp;'+ 
							'<button id="btnAddControl"  class="btnAddControl btn btn-find" type="button"><span class="fa fa-plus"></span></button>'+
						'</legend>'+
						'<div class ="bg-light-grey">'+
								'<table id="controlTable" class="table table-striped congested-table table-hover" >'+
									'<thead>'+
										'<tr>'+
											'<th>Control Code</th>'+
											'<th>Control Name</th>'+
											'<th>Details</th>'+
											'<th>Action</th>'+
										'</tr>'+
									'</thead>'+
									'<tbody>'+
									'</tbody>'+
								'</table>'+
						'</div>'+
					'</fieldset>'+
				'</div>' +
			
		'</div>' +
	'</div>' +
'</div>';
$("#riskControlDiv").append(html);
InitHandlers();
};

var addSectionActivityRiskControlToTestProcedure = function(sectionCode, sectionName, activityCode, activityName, riskCode, riskName, controlCode, controlName){
	//alert("section Code :: " + sectionCode + " || section Name :: " + sectionName+ " || activity code :: " + activityCode+ " || activity Name :: " + activityName+ " || risk code :: " + riskCode+ " || risk Name :: " + riskName);
//return false;

var id = new Date().getTime();
var html = '' +
'<div class="section-activity-risk-control-procedure-block panel panel-light-grey" data-id="' + id + '">' +
	'<div class="panel-heading">' +
		'<h5 class="panel-title">' +
			'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#section_activity_risk_control_procedure_block' + id + '">'+
				'<i class="icon-arrow"></i>' +
				'<span class="section-activity-risk-control-procedure-block-title"> Section : ' + '<label class="last-section-name">' + sectionName + '</label>' + '&nbsp; || <b>Activity :</b> ' + '<label class="last-section-activity-name">' + activityName + '</label>' + '&nbsp; || <b>Risk :</b> ' + '<label class="last-section-activity-risk-name">' + riskName + '</label>' + '&nbsp; || <b>Control :</b> ' + '<label class="last-section-activity-risk-control-name">' + controlName + '</label>' + '</span>' +
			'</a>' +
		'</h5>' +
	'</div>' +
	'<div id="section_activity_risk_control_procedure_block' + id + '" class="each-section-activity-risk-control-procedure-block panel-collapse collapse in">' +
		'<div class="panel-body">' +	
			'<div class="col-md-3 form-group">' +
				'<label class="control-label">Section Code</label>' +
			    '<input name="procedureDiv_section_code[]" type="text" value="'+sectionCode+'" class="procedureDiv-section-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-3 form-group">' +	
				 '<label class="control-label">Section Name</label>' +
				 '<input name="procedureDiv_section_name[]" type="text"  value="'+sectionName+'" class="procedureDiv-section-name readonly form-control required"/>' +
			'</div>' +	
			'<div class="col-md-3 form-group">' +
				'<label class="control-label">Activity Code</label>' +
			    '<input name="procedureDiv_activity_code[]" type="text" value="'+activityCode+'" class="procedureDiv-activity-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-3 form-group">' +	
				 '<label class="control-label">Activity Name</label>' +
				 '<input name="procedureDiv_activity_name[]" type="text"  value="'+activityName+'" class="procedureDiv-activity-name readonly form-control required"/>' +
			'</div>' +	
			'<div class="col-md-3 form-group">' +
				'<label class="control-label">Risk Code</label>' +
			    '<input name="procedureDiv_risk_code[]" type="text" value="'+riskCode+'" class="procedureDiv-risk-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-3 form-group">' +	
				 '<label class="control-label">Risk Name</label>' +
				 '<input name="procedureDiv_risk_name[]" type="text"  value="'+riskName+'" class="procedureDiv-risk-name readonly form-control required"/>' +
			'</div>' +	
			'<div class="col-md-3 form-group">' +
				'<label class="control-label">Control Code</label>' +
			    '<input name="procedureDiv_control_code[]" type="text" value="'+controlCode+'" class="procedureDiv-control-code readonly form-control required"  />' +						
			'</div>' +
			'<div class="col-md-3 form-group">' +	
				 '<label class="control-label">Control Name</label>' +
				 '<input name="procedureDiv_control_name[]" type="text"  value="'+controlName+'" class="procedureDiv-control-name readonly form-control required"/>' +
			'</div>' +
										
				'<div class="col-md-12 form-group">' +
					'<fieldset>'+					
						'<legend>'+
							'Test Procedure &nbsp;&nbsp;'+ 
							'<button id="btnAddProcedure"  class="btnAddProcedure btn btn-find" type="button"><span class="fa fa-plus"></span></button>'+
						'</legend>'+
						'<div class ="bg-light-grey">'+
								'<table id="procedureTable" class="table table-striped congested-table table-hover" >'+
									'<thead>'+
										'<tr>'+
											'<th>Procedure Code</th>'+
											'<th>Procedure Name</th>'+
											'<th>Details</th>'+
											'<th>Action</th>'+
										'</tr>'+
									'</thead>'+
									'<tbody>'+
									'</tbody>'+
								'</table>'+
						'</div>'+
					'</fieldset>'+
				'</div>' +
			
		'</div>' +
	'</div>' +
'</div>';
$("#controlProcedureDiv").append(html);
InitHandlers();
};

function addActivityToCurrentTBody(){
	/*var currentBlock = $(el).closest(".section-activity-block");
	var sectionCode = currentBlock.find(".activityDiv-section-code").val();
	var tBody = currentBlock.find("tbody");*/

	alert("1111111");
	var currentTBody = $("#currentTbody").val();
	var activityCode = $("#activity_code").val();
	var activityName = $("#activity_name").val();
	var activityDetails = $("#activity_details").val();
	alert(activityDetails);
	var html = ''+
	'<tr>'+
		'<td>'+
			'<label class="control-label">'+
			activityCode +
			'</label>'+
		'</td>'+
		'<td>'+
			'<label class="control-label">'+
			activityName +
			'</label>'+
		'</td>'+
			'<td>'+
			'<label class="control-label">'+
			activityDetails +
			'</label>'+
		'</td>'+			
		'<td class="width-80">' +
			'<button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button>&nbsp;' + 
			'<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button>&nbsp;' +
			'<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs"><span class="fa fa-trash"></span></button>' + 
		'</td>' +
	'</tr>';
	currentTBody.append(html);
};


//addSectionBlock();
addRowDeliverable();
addRowActGrp();
addActivityBlock();
getExRate();
$("#Accountable").hide();
$("#company_code").focus();
