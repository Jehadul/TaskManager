if(!window.jQuery){window.location = "/?desturl=" + window.location.href;}

$('#emp_code').keyup(function(){
	 $(this).val($(this).val().toUpperCase());
	}); 

$("#btnBranch").on("click",function(){	
	ShowModal("hrm/ed/branch/searchbranch/?action_type_code=SELECT&actioncallback=loadBranch");
});

function loadBranch(branchdata){
	event.preventDefault();
	var branch = JSON.parse(unescape(branchdata));
	$("#branch_code").val(branch.branchCode);		
	$("#branch_name").val(branch.branchName);	
	$("#company_code").val(branch.companyCode);	
	$("#company_name").val(branch.companyName);	
	HideModal('search-modal');	
}



$("#btnRM").on("click",function(){	
	ShowModal("hrm/ed/employee/searchemployeeshow/?action_type_code=SELECT&actioncallback=loadRM");
});

function loadRM(empdata){
	event.preventDefault();
	var emp = JSON.parse(unescape(empdata));
	$("#rm_code").val(emp.empCode);		
	$("#rm_name").val(emp.empName);	
	$("#rm_desig").val(emp.desig);	
	$("#rm_email").val(emp.email);	
	$("#rm_username").val(emp.username);	
	$("#rm_mobile").val(emp.mobile);	
	HideModal('search-modal');	
}


$("#btnJobRole").on("click",function(){	
	ShowModal("hrm/ed/hrrole/searchhrroleshow/?action_type_code=SELECT&actioncallback=loadJobRole");
});



function loadJobRole(jobroledata){
	event.preventDefault();
	var jobRole = JSON.parse(unescape(jobroledata));
	$("#role_code").val(jobRole.roleCode);		
	$("#role_name").val(jobRole.roleName);	
	HideModal('search-modal');	
}


$("#btnJob").on("click",function(){	
	ShowModal("hrm/ed/job/searchjobshow/?action_type_code=SELECT&actioncallback=loadJob");
});



function loadJob(jobdata){
	event.preventDefault();
	var job = JSON.parse(unescape(jobdata));
	$("#jd_code").val(job.jobCode);		
	$("#jd_name").val(job.jobName);	
	HideModal('search-modal');	
}
$("#btnCostCenter").on("click",function(){	
	ShowModal("hrm/ed/searchcostcenter/?action_type_code=SELECT&actioncallback=loadCostCenter");
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
	ShowModal("hrm/ed/department/searchdepartment/?action_type_code=SELECT&actioncallback=loadDepartment");
});

function loadDepartment(departmentdata){
	event.preventDefault();
	var department = JSON.parse(unescape(departmentdata));
	$("#department_code").val(department.departmentCode);		
	$("#department_name").val(department.departmentName);	
	$("#division_code").val(department.divisionCode);	
	$("#division_name").val(department.divisionName);	
	HideModal('search-modal');	
}


$("#btnLocation").on("click",function(){	
	ShowModal("hrm/ed/location/searchlocationshow/?action_type_code=SELECT&actioncallback=loadLocation");
});

function loadLocation(locationdata){
	event.preventDefault();
	var location = JSON.parse(unescape(locationdata)); 
	$("#office_loc_code").val(location.code);		
	$("#office_loc_name").val(location.name);	
	HideModal('search-modal');	
}


$("#btnStep").on("click",function(){	
	ShowModal("hrm/ed/step/searchstepshow/?action_type_code=SELECT&actioncallback=loadStep");
});

function loadStep(stepdata){
	event.preventDefault();
	var step = JSON.parse(unescape(stepdata));
	$("#emp_step").val(step.stepCode);		
	$("#emp_grade").val(step.gradeName);
	$("#emp_grade_cat").val(step.gradecatName);
	HideModal('search-modal');	
}

$("#btnLevel").on("click",function(){	
	ShowModal("hrm/ed/level/searchlevelshow/?action_type_code=SELECT&actioncallback=btnLevel");
});

function btnLevel(leveldata){
	event.preventDefault();
	var level = JSON.parse(unescape(leveldata));
	$("#band_code").val(level.bandCode); 	
	$("#band_name").val(level.bandName);
	$("#level_code").val(level.levelCode);
	$("#level_name").val(level.levelName);
	HideModal('search-modal');	
}


/*$("#btnLevel").on("click",function(){	
	ShowModal("hrm/ed/level/searchlevelshow/?action_type_code=SELECT&actioncallback=loadLevel");
});

function loadLevel(leveldata){
	event.preventDefault();
	var level = JSON.parse(unescape(leveldata));
	$("#band").val(level.bandName);
	$("#emp_level").val(level.levelName);	
	HideModal('search-modal');	
}*/

$("#first_name").keyup(function (e) {
	generateFullName($("#first_name").val(), $("#middle_name").val(), $("#last_name").val());
});

$("#middle_name").keyup(function (e) {
	generateFullName($("#first_name").val(), $("#middle_name").val(), $("#last_name").val());
});

$("#last_name").keyup(function (e) {
	generateFullName($("#first_name").val(), $("#middle_name").val(), $("#last_name").val());
});

function generateFullName(first_name, middle_name, last_name) { //alert(111);
	var full_name =  first_name + ' ' + middle_name + ' ' + last_name;
		$("#emp_name").val(full_name); 
}


$("#company_code,#emp_code").keyup(function (e) {
	generatePhoto($("#company_code").val(), $("#emp_code").val());
});




$("#btnMapLocation").on("click", function(){ 
	var lat = $("#location_lat").val();
	var lng = $("#location_lng").val();
	var zoom = $("#location_zoom").val();
	ShowModal("/map/selectlocation?actioncallback=setLocation&lat=" + lat + "&lng=" + lng + "&zoom=" + zoom , "modal-lg", "map-modal", "Select Location..");
});

function setLocation(data){
	$("#location_lat").val(data.lat);
	$("#location_lng").val(data.lng);
	$("#location_zoom").val(data.zoom);
	$("#location").html('<img src="https://maps.googleapis.com/maps/api/staticmap?center=' + data.lat + ',' + data.lng + '&zoom=' + data.zoom + '&size=400x100&markers=size:mid|color:blue|' + data.lat + ',' + data.lng + '&key=AIzaSyBFPFcGIvjNVJlyAuAciYeryzQq7XE6v-w">');

	ShowSuccessMsg("Location selected", "");
}

/*$(".btn-back").on("click",function(){
		swal({
		title: "Are you sure to back to menu?",
		text: "This will discard all data you entered.",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#007AFF",
		confirmButtonText: "Yes, cancel the wizard!",
		closeOnConfirm: true
	}, function() {
		LoadMainContent('toc?type=privgrp&privgrp=3&currmodcode=ED');
	});

});*/

function showMessage(data) {
	if(data.outcome == 'success'){
		
		ShowSuccessMsg('Employee', data.message);
		isDirty = false ;
		LoadMainContent('hrm/ed/employee/show/' + data.id + '/' + data.mode); 
	}
	else{
		ShowErrorMsg('Employee was not created', data.message);
		var message = ConcatWithBR(data.error);
			$(".alert").html(message);
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

function validate(){
	
	var itemCode = $("#emp_code").val().trim();
	var itemFName = $("#first_name").val().trim();
	var itemLName = $("#last_name").val().trim();
	var itemPhone   = $("#phone_off").val();
	var itemMobile  = $("#mobile").val();
	var itemEmail   = $("#email").val();
	var itemEmailAlt   = $("#email_alt").val();
	SyncOptionText();
	
	var error = "";
	var result = CheckRequired();
	
	 var patternEmail    = new RegExp("[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$");
	 var patternEmailAlt = new RegExp("[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$");
	 var resEmail        = patternEmail.test(itemEmail);
	 var resEmailAlt     = patternEmailAlt.test(itemEmailAlt);
	 
	 var patternPhone    = new RegExp("^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$");
	 var resPhone        = patternPhone.test(itemPhone);
	 var patternMobile   = new RegExp("^([0|\+[0-9]{1,5})?([0-9]{10})$");
	 var resMobile       = patternMobile.test(itemMobile);
	
	  /*$(function() {
	        $.fn.selectRange = function(start, end) {
	            return this.each(function() {
	                var self = this;
	                if (self.setSelectionRange) {
	                    self.focus();
	                    self.setSelectionRange(start, end);
	                } else if (self.createTextRange) {
	                    var range = self.createTextRange();
	                    range.collapse(true);
	                    range.moveEnd('character', end);
	                    range.moveStart('character', start);
	                    range.select();
	                }
	            });
	        };

	        if(itemCode==""){
	            $('#emp_code').selectRange(0, 0);}
	        else if(itemFName==""){
	            $('#first_name').selectRange(0, 0);}
	        else if(itemLName==""){
	            $('#last_name').selectRange(0, 0);}
	        else if(itemEmail==""){
	            $('#email').selectRange(0, 0);}
	        else if(itemEmailAlt==false){
	            $('#email_alt').selectRange(0, 0);}
	         
	        
	    }); */
	 
	 
	if ($("#company_code").val() =="" && $("#branch_code").val() =="") {
		error +="Please select Branch <br/> ";
		result = false;
		
	} 

	if ($("#emp_code").val() =="" && $("#first_name").val() =="") {
		error +="Please Enter Employee Code & Name <br/> ";
		result = false;
		
	} 

/*	if ($("#employment_type").val("-1")) {
		error +="Please Select Employment Type <br/> ";
		result = false;
		
	} 

	if ($("#nationality").val("-1")) {
		error +="Please Select Nationality <br/> ";
		result = false;
		
	} 

	if ($("#religion").val("-1")) {
		error +="Please Select Religion <br/> ";
		result = false;
		
	}*/ 

	if ( $("#marital_status").val() =="-1") {
		error +="Please select Marital status <br/>";
		result = false;
		
	} 
 
	if ( $("#blood_group").val() =="-1") {
		error +="Please select Blood Group <br/>";
		result = false;
		
	} 
	
	/*$.each($("#photo"), function (){
		if($(item).val()){
			var fileName = "/assets/photo/" + $(item).val().split("\\")[2];
			$("photo").val(fileName);
		}
	});*/


	 if(itemPhone!==""){
 		var spaceCheckPhone = itemPhone.indexOf(' ') >= 0;
 		if(spaceCheckPhone){
 			   error +="Space is not allowed in phone number";
 				ShowErrorMsg('Employee was not created', "Please check details.");
 				InitErrorChange();
 				$(".alert").html(error);
 				$(".alert").removeClass("hidden");
 				return false;
 			
 		}

 		if(resPhone==false)
 		{
 		   error +="Please enter a valid phone number";
 			ShowErrorMsg('Client was not created', "Please check details.");
 			InitErrorChange();
 			$(".alert").html(error);
 			$(".alert").removeClass("hidden");
 			return false;
 	   } 
 			
 	}
    	
    	var spaceCheckemail = itemEmail.indexOf(' ') >= 0;
    	if(spaceCheckemail){
    		   error +="Space is not allowed in e-mail address";
				ShowErrorMsg('Employee was not created', "Please check details.");
				InitErrorChange();
				$(".alert").html(error);
				$(".alert").removeClass("hidden");
				return false;
    		
    	}
    
    	
    	if(resEmail==false)
		{
		   error +="Please enter a valid email address";
			ShowErrorMsg('Client was not created', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
			return false;
	   } 
    	
 
    	

if(itemEmailAlt!==""){
	var spaceCheckemailalt = itemEmailAlt.indexOf(' ') >= 0;
	if(spaceCheckemailalt){
		   error +="Space is not allowed in alternate e-mail address";
			ShowErrorMsg('Employee was not created', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
			return false;
		
	}

	if(resEmailAlt==false)
	{
	   error +="Please enter a valid alternate email address";
		ShowErrorMsg('Client was not created', "Please check details.");
		InitErrorChange();
		$(".alert").html(error);
		$(".alert").removeClass("hidden");
		return false;
   } 
		
}

if(itemMobile!==""){
		var spaceCheckMobile = itemMobile.indexOf(' ') >= 0;
		if(spaceCheckMobile){
			   error +="Space is not allowed in mobile number";
				ShowErrorMsg('Employee was not created', "Please check details.");
				InitErrorChange();
				$(".alert").html(error);
				$(".alert").removeClass("hidden");
				return false;
			
		}

		if(resMobile==false)
		{
		   error +="Please enter a valid mobile number";
			ShowErrorMsg('Client was not created', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
			return false;
	   } 
			
	}
	
	
	if (!result) {
		InitErrorChange();
		$(".alert").html(error);
		$(".alert").removeClass("hidden");
	} 
	return result;
}
