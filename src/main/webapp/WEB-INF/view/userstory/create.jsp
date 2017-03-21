<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create User Story</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>User Story</span>
				</li>
				<li class="active">
					<span>Create User Story</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/userstory/story/store" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="alert alert-block alert-danger hidden">
					Please check the fields marked with 
					<span class="text-red fa fa-close"></span>.
				</div>
				<div class="denotes-required">denotes a required field.</div>
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						
						<div class="form-group">
							<cts:Label labelFor="suite_code" name="Suite Name"/>
							<cts:Select list="${data.suiteCodes}"  name="suite_code" value="${data.suiteCode }" cssClass="required"/>
							<cts:Hidden name="suite_name" value=""/>
						</div>
						 <div class="form-group">
							<cts:Label labelFor="module_code" name="Module Name"/>
							<cts:Select list="${data.moduleCodes}"  name="module_code" value="${data.moduleCode}" cssClass="required"/>
							<cts:Hidden name="module_name" value=""/>
						</div>
						<div class="form-group">
							<cts:Label labelFor="priv_grp_code" name="Privilege Group"/>
							<cts:Select list="${data.privgroups}"  name="priv_grp_code" value="${data.privGroupCode }" cssClass="required"/>
							<cts:Hidden name="priv_grp_name" value=""/>
						</div>
						<div class="form-group">
							<cts:Label labelFor="privilege_code" name="Privilege Name"/>
							<cts:Select list="${data.privileges}"  name="privilege_code" value="${data.privCode }" cssClass="required"/>
							<cts:Hidden name="privilege_name" value=""/>
						</div>
						<div class="form-group">
							<cts:Label labelFor="priority_code" name="Priority"/>
							<cts:Select list="${data.priorities}"  name="priority_code" value="${data.priority }" cssClass="required"/>
							<cts:Hidden name="priority" value=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Story Code" labelFor="user_story_code"/>
							<cts:TextBox name="user_story_code" cssClass="dirty-check required uppercase" readonly=""/>
						</div>
						<div class="form-group">						
							<cts:Label name="Story Title" labelFor="user_story_title"/>
							<cts:TextBox name="user_story_title" cssClass="dirty-check required" readonly=""/>
						</div>
						
						
					</div>
					<div class="col-md-6">
						<div class="form-group">						
							<cts:Label name="Story Order" labelFor="story_order"/>
							<cts:TextBox name="story_order" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Story Size" labelFor="size"/>
							<cts:TextBox name="size" cssClass="dirty-check number" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Business Value" labelFor="business_value"/>
							<cts:TextBox name="business_value" cssClass="dirty-check number" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Acceptance Criteria" labelFor="acceptance_criteria"/>
							<cts:TextArea name="acceptance_criteria" cssClass="dirty-check" readonly="" rows="3" cols=""/>
						</div>
						<div class="form-group">
								<cts:Label name="Description" labelFor="description"/>
								<cts:TextArea name="description" cssClass="dirty-check" readonly="" rows="3" cols=""/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8">
						 <cts:Button cssClass="back" spanClass="arrow-left" dAjax="true" dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=SA" />
						<button class="btn btn-refresh" type="button">
							<span class="fa fa-refresh"></span>
						</button>
						<button class="btn btn-help" type="button">
							<span class="fa fa-question"></span>
						</button>
					</div>
					<div class="col-md-4">
						<button id="submit" class="btn btn-save pull-right" type="submit">
									<span class="fa fa-save"></span> &nbsp;Save
						</button>
					</div>
				</div>
			</div>
		</cts:AjaxForm>
	</div>
</div>
<script>
InitHandlers();

	$("input[name='suite_name']").val($("#suite_code option:selected").text());
	$("input[name='module_name']").val($("#module_code option:selected").text());
	$("input[name='priv_grp_name']").val($("#priv_grp_code option:selected").text());
	

	$('#suite_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		LoadMainContent("/taskman/userstory/story/create/?suite_code=" + newSuiteCode);
	
	});
	
	$('#module_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		LoadMainContent("/taskman/userstory/story/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode);
	
	});
	
	$('#priv_grp_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		var newPrivGroupCode = $("#priv_grp_code").val();
		LoadMainContent("/taskman/userstory/story/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode + "&" + "priv_grp_code=" + newPrivGroupCode);
	});
	
	$('#privilege_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		var newPrivGroupCode = $("#priv_grp_code").val();
		var newPrivCode = $("#privilege_code").val();
		//LoadMainContent("/taskman/userstory/story/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode + "&" + "priv_grp_code=" + newPrivGroupCode + "&" + "priv_grp_code=" +  newPrivCode);
	});
	
	$("#priority_code").on("change", function(){
		$("input[name='priority']").val($("#priority_code option:selected").text());
	});
	
	function showMessage(data) {
		if (data.outcome == 'success') {
			ShowSuccessMsg('User Story created', data.message);
			isDirty = false;
			LoadMainContent('/taskman/userstory/story/show/' + data.id );
		} else {
			ShowErrorMsg('User Story was not created', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}
	
	/*  $("#priv_grp_code").on("change", function(){
		 
		 	$("#privilege_code").val("");
			var newSuiteCode = $("#suite_code").val();  
			var newModuleCode = $("#module_code").val();
			var newPrivGroupCode = $("#priv_grp_code").val();
			var newPrivCode = newSuiteCode+ "_" + newModuleCode + "_" + newPrivGroupCode + "_";
				$("#privilege_code").val(newPrivCode);
	 });  */
	 
	 $("#privilege_code").on("change", function(){
		 $("input[name='priv_name']").val($("#privilege_code option:selected").text());
		 $("#user_story_code").val("");
		 var newSuiteCode = $("#suite_code").val();  
		 var newModuleCode = $("#module_code").val();
		 var newPrivGroupCode = $("#priv_grp_code").val();
		 var newPrivilegeCode = $("#privilege_code").val();
		 var newUserStoryCode = newSuiteCode+ "_" + newModuleCode + "_" + newPrivGroupCode + "_" + newPrivilegeCode + ".";
		 $("#user_story_code").val(newUserStoryCode);
		 
	 });
	 
	
	 function validate(){
		 
		 	var storyCode = $("#user_story_code").val().trim();
			var storyName = $("#user_story_title").val().trim();
			var storyOrder = $("#story_order").val().trim();
			
			SyncOptionText();
			
			var error = "";
			var result = CheckRequired();
			
			 if ( $("#suite_code").val() =="-1") {
					error +="Please select Suite Code <br/>";
					result = false;
					
				}  
				 
				 if ( $("#module_code").val() =="-1") {
						error +="Please select Module Code <br/>";
						result = false;
						
					}  
				 
				 if ( $("#priv_grp_code").val() =="-1") {
						error +="Please select Priv Grp Code <br/>";
						result = false;
						
					} 
				 
				 if ($("#privilege_code").val() =="-1" ) {
						error +="Please select Privilege Code <br/> ";
						result = false;
						
					} 
				 
				 if ($("#priority_code").val() =="-1" ) {
						error +="Please select Priority Code <br/> ";
						result = false;
						
					} 
				 
				 
			
			/* if ($("#privilege_name").val() =="") {
				error +="Please Enter privilege Name <br/> ";
				result = false;
				
			} 
			 */

			if ($("#user_story_code").val() =="" ) {
				error +="Please Enter User Story Code <br/> ";
				result = false;
				
			} 
			

			if ($("#user_story_title").val() =="" ) {
				error +="Please Enter User Story Title <br/> ";
				result = false;
				
			} 
			
			 if ( $("#priority_code").val() =="-1") {
					error +="Please select Priority Code <br/>";
					result = false;
					
				} 
			
			if ($("#story_order").val() =="" ) {
				error +="Please Enter Story Order <br/> ";
				result = false;
				
			} 

			 if (!result) {
					
					error +="Please check the fields marked with X";
					ShowErrorMsg('User Story was not created', "Please check details.");
					InitErrorChange();
					$(".alert").html(error);
					$(".alert").removeClass("hidden");
			 }
			 else if(storyCode == ""|| storyName == "" || storyOrder == ""){
					
					error +="Only space is not allowed in required fields";
					ShowErrorMsg('User Story was not created', "Please check details.");
					InitErrorChange();
					$(".alert").html(error);
					$(".alert").removeClass("hidden");
					return false;
			 }
				
				
			return result;
		}
	
</script>