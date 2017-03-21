<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create Task</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Create Task</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/tasks/store" dataHandler="showMessage" >
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
							<cts:Label name="Task Code" labelFor="task_code"/>
							<cts:TextBox name="task_code" cssClass="dirty-check uppercase" readonly="required"/>
						</div>
					<div class="col-md-6">
						<div class="form-group">						
							<cts:Label name="Task Code" labelFor="task_code"/>
							<cts:TextBox name="task_code" cssClass="dirty-check uppercase required" readonly=""/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">						
							<cts:Label name="Task Title" labelFor="task_title"/>
							<cts:TextBox name="task_title" cssClass="dirty-check" readonly="required"/>
						</div>
						
						<div class="form-group">
							<cts:Label name="Estimated Time (Hour)" labelFor="estimated_time"/>
							<cts:TextBox name="estimated_time" cssClass="dirty-check number" readonly="required"/>
						</div>					
					</div>
					<div class="col-md-6">
							<cts:TextBox name="estimated_time" cssClass="dirty-check required number" readonly=""/>
						</div>
						<div class="form-group">
								<cts:Label name="Description" labelFor="description"/>
								<cts:TextArea name="description" cssClass="dirty-check " readonly="" rows="3" cols="required"/>
						</div>
						<fieldset>
							<legend>
									Story Code&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnStory"/>		
							</legend>
								<div class="form-group">
									<cts:Label labelFor="suite_name" name="Suite Name"/>
									<cts:TextBox name="suite_name" cssClass="dirty-check" readonly="readonly"/>
									<cts:Hidden name="suite_code" value=""/>
								</div>
								 <div class="form-group">
									<cts:Label labelFor="module_name" name="Module Name"/>
									<cts:TextBox name="module_name" cssClass="dirty-check" readonly="readonly"/>
									<cts:Hidden name="module_code" value=""/>
								</div>
								<div class="form-group">
									<cts:Label labelFor="priv_grp_name" name="Privilege Group"/>
									<cts:TextBox name="priv_grp_name" cssClass="dirty-check" readonly="readonly"/>
									<cts:Hidden name="priv_grp_code" value=""/>
								</div>
								<div class="form-group">
									<cts:Label labelFor="privilege_name" name="Privilege Name"/>
									<cts:TextBox name="privilege_name" cssClass="dirty-check" readonly="readonly"/>
									<cts:Hidden name="privilege_code" value=""/>
								</div>
								<div class="form-group">						
									<cts:Label name="Story Title" labelFor="story_title"/>
									<cts:TextBox name="story_title" cssClass="dirty-check" readonly="readonly"/>
									<cts:Hidden name="story_code" value=""/>
								</div>
						</fieldset>
						<fieldset>
								<legend>
									Assignee Details&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnUser"/>			
								</legend>
								<div class="form-group">						
									<cts:Label name="Assignee Code" labelFor="emp_code"/>
									<cts:TextBox name="emp_code" cssClass="dirty-check" readonly="readonly"/>
								</div>
								<div class="form-group">						
									<cts:Label name="Assignee Name" labelFor="emp_name"/>
									<cts:TextBox name="emp_name" cssClass="dirty-check" readonly="readonly"/>
								</div>
								<div class="form-group">						
									<cts:Label name="Username" labelFor="username"/>
									<cts:TextBox name="username" cssClass="dirty-check" readonly="readonly"/>
								</div>
						</fieldset>
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
						<cts:Submit cssClass="save pull-right" spanClass="save" name="Save"/>
					</div>
				</div>
			</div>
		</cts:AjaxForm>
	</div>
</div>
<script>
InitHandlers();
	
	$("#btnUser").on("click",function(){
		ShowModal("/ac/user/searchuser/?action_type_code=SELECT&actioncallback=loadUser");
	});

	function loadUser(userdata){ 
		var emp = JSON.parse(unescape(userdata));
		$("#emp_code").val(emp.empCode);
		$("#emp_name").val(emp.empName);
		$("#username").val(emp.username);	
		HideModal('search-modal');	
	}
	
	$("#btnStory").on("click",function(){
		ShowModal("/taskman/userstory/story/searchstory/?action_type_code=SELECT&actioncallback=loadStory");
	});

	function loadStory(story){ 
		var storyList = JSON.parse(unescape(story));			
		$("#suite_code").val(storyList.suiteCode);	
		$("#suite_name").val(storyList.suiteName);
		$("#module_code").val(storyList.moduleCode);
		$("#module_name").val(storyList.moduleName);
		$("#priv_grp_code").val(storyList.privGrpCode);
		$("#priv_grp_name").val(storyList.privGrpName);
		$("#privilege_code").val(storyList.privilegeCode);
		$("#privilege_name").val(storyList.privilegeName);
		$("#story_code").val(storyList.userStoryCode);
		$("#story_title").val(storyList.userStoryTitle);
		HideModal('search-modal');	
	}

	function showMessage(data) {
		if (data.outcome == 'success') {
			ShowSuccessMsg('Tasks created', data.message);
			isDirty = false;
			LoadMainContent('/taskman/tman/tasks/show/' + data.id );
		} else {
			ShowErrorMsg('Tasks was not created', data.message);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}
	
	function validate() {
		var taskCode = $("#task_code").val().trim();
		var taskName = $("#task_title").val().trim();
		var estimatedTime = $("#estimated_time").val().trim();
		var description = $("#description").val().trim();
		var error = "";
		
		SyncOptionText();
		
		return;
		
		var result = CheckRequired();

			if ($("#suite_code").val() =="-1") {
				error +="Must select new Suite <br/>";
				result = false;
				
			} 
			
			 if ($("#module_code").val() =="-1") {
				error +="Must select new Module <br/>";
				result = false;
				
			}
			
			if ($("#priv_grp_code").val() =="-1") {
				error +="Must select new Privilege Group <br/>";
				result = false;
				
			}
			
			/* if ($("#assignee").val() =="") {
				error +="Must select Assignee <br/>";
				result = false;
				
			}	
			
			if ($("#story_code").val() ==""){
				error +="Must select new Story Code <br/>";
				result = false;
			} */
		
		
		if (!result) {
			
			error +="Please check the fields marked with X";
			ShowErrorMsg('Task was not created', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
		}
		else if(taskCode == ""|| taskName == "" || estimatedTime == "" || description == ""){
			
			error +="Only space is not allowed in required fields";
			ShowErrorMsg('Task was not created', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
			return false;
		}
		
		
		return result;
	}

	
/* 	$("#btnStory").on("click",function(){
		ShowModal("/taskman/userstory/story/searchstory/?action_type_code=SELECT&actioncallback=loadStory");
	});

	function loadStory(story){ 
		var storyList = JSON.parse(unescape(story));			
		$("#story_code").val(storyList.userStoryCode);	
		HideModal('search-modal');	
	} */
	
	
</script>