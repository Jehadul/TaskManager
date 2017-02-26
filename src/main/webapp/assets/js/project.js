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

var validateStep = function(stepNumber){
	// syncPreview();return true;
	$(".alert").addClass("hidden");
	
	var error = "";
	var	result = CheckRequired("#step-" + stepNumber);

	if(!result) {
    	error = "Please check the required fields.<br />";
    }

 	if (stepNumber == 1) {
		if (!checkProjectDates()) {
			result = false;
    		error += "Please ensure that the Project End Date is greater than or equal to the Start Date.<br />";
		}
	}
	else if (stepNumber == 2) {
		var wbsBlocks = $("[id^='wbs_block']");
		for (var i = 0; i < wbsBlocks.length; i++) {
			initWbsView( "#" + $(wbsBlocks[i]).prop("id"));
		}
	}
	else if (stepNumber == 3) {
		var wbsBlocks = $("[id^='wbs_block']");			
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
		}
	}
	else if (stepNumber == 4) {
		var resultPrjDate = true;	
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
		}
	}
	else if (stepNumber == 5) {
		var activityBlocks = $("[id^='activity-block']");
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
		syncPreview();
	}

	if (!result) {
		ShowErrorMsg('Project was not saved due to some error.', "Please check details.");
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
	ShowModal("tna/pm/program/searchprogram/?action_type_code=SELECT&actioncallback=loadProgram");
});

function loadProgram(prodata){ 
	var pro = JSON.parse(unescape(prodata));
	$("#portfolio_code").val(pro.portfolioCode);		
	$("#portfolio_name").val(pro.portfolioName);
	$("#program_code").val(pro.programCode);		
	$("#program_name").val(pro.programName);

	HideModal('search-modal');	
}

$("#btnManager").on("click",function(){	
	ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadManager");
});

function loadManager(empdata){ 
	var emp = JSON.parse(unescape(empdata));
	$("#project_manager_code").val(emp.empCode);		
	$("#project_manager_name").val(emp.empName);	
	$("#project_manager_username").val(emp.username);	
	$("#project_manager_desig").val(emp.desig);	
	$("#project_manager_email").val(emp.email);		
	$("#project_manager_mobile").val(emp.mobile);	
	$("#project_manager_company_code").val(emp.companyCode);	
	$("#project_manager_company_name").val(emp.companyName);	
	HideModal('search-modal');	
}

	
$("#btnAccountable").on("click",function(){	
	ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadAccountable");
});

function loadAccountable(empdata){ 
	var emp = JSON.parse(unescape(empdata));
	$("#other_accountable_code").val(emp.empCode);		
	$("#other_accountable_name").val(emp.empName);	
	$("#other_accountable_username").val(emp.username);	
	$("#other_accountable_desig").val(emp.desig);	
	$("#other_accountable_email").val(emp.email);		
	$("#other_accountable_mobile").val(emp.mobile);	
	$("#other_accountable_company_code").val(emp.companyCode);	
	$("#other_accountable_company_name").val(emp.companyName);	
	HideModal('search-modal');	
}



$("#btnSponsor").on("click",function(){	
	ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadSponsor");
});

function loadSponsor(empdata){ 
	console.log(unescape(empdata))
	var emp = JSON.parse(unescape(empdata));
	$("#project_sponsor_code").val(emp.empCode);		
	$("#project_sponsor_name").val(emp.empName);	
	$("#project_sponsor_username").val(emp.username);	
	$("#project_sponsor_desig").val(emp.desig);	
	$("#project_sponsor_email").val(emp.email);		
	$("#project_sponsor_mobile").val(emp.mobile);	
	$("#project_sponsor_company_code").val(emp.companyCode);	
	$("#project_sponsor_company_name").val(emp.companyName);	
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
		ShowModal("/crm/clc/customer/searchshow/?action_type_code=SELECT&actioncallback=loadParty");
	}	
	else if ($("#party_type").val() == "1") {
		ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadParty");
	}
	else if ($("#party_type").val() == "2") {
		ShowModal("/scm/vlc/supplier/searchshow/?action_type_code=SELECT&actioncallback=loadParty");
	}
});

var loadParty = function(empdata){ 
	var emp = JSON.parse(unescape(empdata));
    $("#party_code").val(emp.empCode);		
    $("#party_name").val(emp.empName);
	$("#party_email").val(emp.email);		
	$("#party_mobile").val(emp.mobile);	
	$("#party_username").val(emp.username);
	$("#party_address").val(emp.addr);
	$("#party_desig").val(emp.desig);
	$("#party_company_code").val(emp.companyCode);	
	$("#party_company_name").val(emp.companyName);	
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
	$("*").removeClass("required");
}

var showFindWbsOwner = function(el){	
	$(".wbs-block").removeClass("current-wbs-block");
	ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadWbsOwner");
	var currentWbsBlock = $(el).closest(".wbs-block");
	currentWbsBlock.addClass("current-wbs-block");
};

var loadWbsOwner = function(owndata){ 
	event.preventDefault();
	var own = JSON.parse(unescape(owndata));
	$(".current-wbs-block .wbs-owner-code").val(own.empCode);
	$(".current-wbs-block .wbs-owner-name").val(own.empName);	
	$(".current-wbs-block .wbs-owner-username").val(own.username);	
	$(".current-wbs-block .wbs-owner-desig").val(own.desig);	
	$(".current-wbs-block .wbs-owner-email").val(own.email);		
	$(".current-wbs-block .wbs-owner-mobile").val(own.mobile);	
	$(".current-wbs-block .wbs-owner-company-code").val(own.companyCode);	
	$(".current-wbs-block .wbs-owner-company-name").val(own.companyName);	
	HideModal('search-modal');	
};

var addWbsBlock = function(){
	var id = new Date().getTime();
	var html = '' +
	'<div class="wbs-block panel panel-light-grey" data-id="' + id + '">' +
		'<div class="panel-heading">' +
			'<h5 class="panel-title">' +
				'<a class="accordion-toggle bold" data-toggle="collapse" data-parent="#accordion" href="#wbs_block' + id + '">'+
					'<i class="icon-arrow"></i>' +
					'<span class="wbs-block-title"> WBS</span>' +
				'</a>' +
			'</h5>' +
		'</div>' +
		'<div id="wbs_block' + id + '" class="panel-collapse collapse in">' +
			'<div class="panel-body">' +
				'<div class="row">' +
					'<div class="col-md-12">' +
			   			'<button class="btn btn-xs btn-red btn-o pull-right" onclick="delWbsBlock(this);"><span class="fa fa-close"> Delete</span></button>' +
			  	 	'</div>' +			
			   	'</div>' +			
				'<div class="row">' +
					'<div class="col-md-6">' +							
						'<div class="row">' +
							'<div class="col-md-6 form-group">' +
								'<label class="control-label">WBS Code</label>' +
							    '<input name="wbs_code[]" type="text" class="wbs-wbs-code form-control required"  />' +						
							'</div>' +
							'<div class="col-md-6 form-group">' +	
								 '<label class="control-label">WBS Name</label>' +
								 '<input name="wbs_name[]" type="text" class="wbs-wbs-name form-control required" onchange="wbsNameChanged(this)"/>' +
							'</div>' +
						'</div>' +
						'<div class="row">' +
							'<div class="col-md-12 form-group">' +	
							    '<label class="control-label">Purpose</label>' +
								'<textarea name="wbs_purpose[]" type="text" class="wbs-wbs-purpose form-control"  />' +
							'</div>' +
						'</div>' +
						'<div class="row">' +
							'<div class="col-md-6 form-group">' +
								'<label class="control-label">Start Day <small>(From Project Commencement)</small></label>' + 
								'<input name="wbs_start_day[]" type="text" class="wbs-start-day form-control number required"/>' +
							'</div>' +
							'<div class="col-md-6 form-group">' +
								'<label class="control-label">Duration <small>(in days)</small></label>' + 
								'<input name="wbs_duration[]" type="text" class="wbs-duration form-control number required"/>' +
							'</div>' +
						'</div>' +							
					'</div>' +
					'<div class="col-md-6 form-group">' +
						'<fieldset class="bg-light-grey">'+
						'<legend>'+
						'Owner&nbsp;&nbsp;'+ 
						'<button id="btnWbsSearch" onclick="showFindWbsOwner(this);" class="btn btn-find" type="button"><span class="fa fa-search"></span></button>'+
						'</legend>'+
						'<div class="col-md-6 form-group">' +	
							'<label class="control-label">Owner Code</label>' + 
							'<input name="wbs_owner_code[]" type="text" class="wbs-owner-code form-control required" readonly="readonly"/>' +
							'<label class="control-label">User Name</label>' + 
							'<input name="wbs_owner_username[]" type="text" class="wbs-owner-username form-control" readonly="readonly"/>' +
							'<label class="control-label">Mobile</label>' + 
							'<input name="wbs_owner_mobile[]" type="text" class="wbs-owner-mobile form-control" readonly="readonly"/>' +
							'<label class="control-label">Company Code</label>' + 
							'<input name="wbs_owner_company_code[]" type="text" class="wbs-owner-company-code form-control" readonly="readonly"/>' +
						'</div>' +
						'<div class="col-md-6 form-group">' +	
							'<label class="control-label">Owner Name</label>' + 
							'<input name="wbs_owner_name[]" type="text" class="wbs-owner-name form-control required" readonly="readonly" />' +
							'<label class="control-label">Designation</label>' + 
							'<input name="wbs_owner_desig[]" type="text" class="wbs-owner-desig form-control" readonly="readonly" />' +
							'<label class="control-label">Email</label>' + 
							'<input name="wbs_owner_email[]" type="text" class="wbs-owner-email form-control" readonly="readonly" />' +
							'<label class="control-label">Company Name</label>' + 
							'<input name="wbs_owner_company_name[]" type="text" class="wbs-owner-company-name form-control" readonly="readonly" />' +
						'</div>' +
					    '</fieldset>'+
					'</div>' +
				'</div>' +
				'<div class="row">' +							
					'<div class="col-md-12 form-group">' +
						'<fieldset>'+
							'<legend>'+
								'WBS Deliverable&nbsp;&nbsp;'+  
							'</legend>'+
							'<div class ="wbs-wbs-deliverable bg-light-grey">'+
									'<table class="table table-striped congested-table table-hover wbs-deliverable-list" >'+
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
	$("#WbsBlocks").append(html);
	initWbsView("#wbs_block" + id);
	InitHandlers();
	
};

var wbsNameChanged = function(el){
	var currentBlock = $(el).closest(".wbs-block");
	var wbsName = currentBlock.find(".wbs-wbs-name").val();
	var title = " WBS Name : " + wbsName;
	currentBlock.find(".wbs-block-title").text(title);
};

var delWbsBlock = function(el){
	if ($(".wbs-block").length > 1) {
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this block?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
	    	$(el).closest(".wbs-block").remove();
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
	$("*").removeClass("required");
};

var showFindActivityOwner = function(el){	
	$(".activity-block").removeClass("current-activity-block");
	ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadOwnerActivity");
	var currentActivityBlock = $(el).closest(".activity-block");
	currentActivityBlock.addClass("current-activity-block");
};

var loadOwnerActivity = function(owndata){ 
	event.preventDefault();
	var own = JSON.parse(unescape(owndata));
	$(".current-activity-block .activity-owner-code").val(own.empCode);
	$(".current-activity-block .activity-owner-name").val(own.empName);	
	$(".current-activity-block .activity-owner-username").val(own.username);	
	$(".current-activity-block .activity-owner-desig").val(own.desig);	
	$(".current-activity-block .activity-owner-email").val(own.email);		
	$(".current-activity-block .activity-owner-mobile").val(own.mobile);	
	$(".current-activity-block .activity-owner-company-code").val(own.companyCode);	
	$(".current-activity-block .activity-owner-company-name").val(own.companyName);	
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
		ShowSuccessMsg('Project created', data.msg);
		//LoadMainContent('/project/' + data.id + '?mode=' + data.mode);
	}
	else{
		ShowErrorMsg('Project was not created', data.msg);
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

    default:
        break;
	}	
	if ($("#"+ tableName).find("tbody tr").length > minCount) {
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

var upRow = function(el){
	var row = $(el).closest("tr");
	row.insertBefore(row.prev());
};


var downRow = function(el){
	var row = $(el).closest("tr");
	row.insertAfter(row.next());
};

$("#scheduled_start_date, #scheduled_end_date").on('change', showProjectDuration);
$('#project_currency_code').on('change', getExRate);
$("#btnDeliverable").on("click", addRowDeliverable);
$("#btnMilestone").on("click", addRowMilestone);
$("#btnAttachment").on("click", addRowAttachment);
$("#btnBillingPlan").on("click", addRowBillingPlan);
$("#btnWbs").on("click", addWbsBlock);
$("#btnActGrp").on("click", addRowActGrp);
$("#btnActivity").on("click", addActivityBlock);
addWbsBlock();
addRowDeliverable();
addRowActGrp();
addActivityBlock();
getExRate();
$("#Accountable").hide();
$("#company_code").focus();