<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create Task</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Task</span></li>
				<li class="active"><span>Create Task</span></li>
			</ol>
		</div>
	</section>
	<center>
		<a href="http://localhost:8080/?desturl=/taskman/tman/tasks/tasklist">Back</a>
		 | <a href="http://localhost:8080">Dashboard</a>
	</center>
	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/tasks/store"
			dataHandler="showMessage">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with <span
					class="text-red fa fa-close"></span>.
			</div>

			<div class="denotes-required">denotes a required field.</div>

			<div class="main-control">
				<div class="row">
					<div class="col-md-6">

						<fieldset>
							<legend>
								Story Details&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnStory" />
							</legend>
							<div class="form-group">
								<cts:Label labelFor="sprint_name" name="Sprint Name" />
								<cts:TextBox name="sprint_name" cssClass="dirty-check required" readonly="readonly" />
								<cts:Hidden name="sprint_name" value="" />
							</div>
							<div class="form-group">
								<cts:Label labelFor="suite_name" name="Suite Name" />
								<cts:TextBox name="suite_name" cssClass="dirty-check required"
									readonly="readonly" />
								<cts:Hidden name="suite_code" value="" />
							</div>
							<div class="form-group">
								<cts:Label labelFor="module_name" name="Module Name" />
								<cts:TextBox name="module_name" cssClass="dirty-check required"
									readonly="readonly" />
								<cts:Hidden name="module_code" value="" />
							</div>
							<div class="form-group">
								<cts:Label labelFor="priv_grp_name" name="Privilege Group" />
								<cts:TextBox name="priv_grp_name" cssClass="dirty-check required"
									readonly="readonly" />
								<cts:Hidden name="priv_grp_code" value="" />
							</div>
							<div class="form-group">
								<cts:Label labelFor="privilege_name" name="Privilege Name" />
								<cts:TextBox name="privilege_name" cssClass="dirty-check"
									readonly="readonly" />
								<cts:Hidden name="privilege_code" value="" />
							</div>
							<div class="form-group">
								<cts:Label name="Story Title" labelFor="story_title" />
								<cts:TextBox name="story_title" cssClass="dirty-check"
									readonly="readonly" />
								<cts:Hidden name="story_code" value="" />
							</div>
							
							<div class="form-group">
								<input type="hidden" id="sprint_id" name="sprint_id"	class="sprint_id" value="" />
							</div>

						</fieldset>
						<div class="form-group">
							<cts:Label labelFor="task_state" name="Task Status"/>
							<cts:Select list="${data.taskStatus}"  name="task_state" value="" cssClass="required"/>
							<cts:Hidden name="task_status" value=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Task Code" labelFor="task_code" />
							<cts:TextBox name="task_code"
								cssClass="dirty-check uppercase required" readonly="" />
						</div>



					</div>
					<div class="col-md-6">
						
						<div class="form-group">
							<cts:Label name="Task Title" labelFor="task_title" />
							<cts:TextBox name="task_title" cssClass="dirty-check required"
								readonly="" />
						</div>

						<div class="form-group">
							<cts:Label name="Estimated Time (Hour)" labelFor="estimated_time" />
							<cts:TextBox name="estimated_time"
								cssClass="dirty-check required number" readonly="" />
						</div>


						<div class="form-group">
							<cts:Label name="Description" labelFor="description" />
							<cts:TextArea name="description" cssClass="dirty-check required"
								readonly="" rows="3" cols="" />
						</div>
						<fieldset>
							<legend>
								Assignee Details&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnUser" />
							</legend>
							<div class="form-group">
								<cts:Label name="Assignee Code" labelFor="emp_code" />
								<cts:TextBox name="emp_code" cssClass="dirty-check required"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<cts:Label name="Assignee Name" labelFor="emp_name" />
								<cts:TextBox name="emp_name" cssClass="dirty-check"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<cts:Label name="Username" labelFor="username" />
								<cts:TextBox name="username" cssClass="dirty-check required"
									readonly="readonly" />
							</div>
						</fieldset>
					</div>
				</div>

				<div class="row margin-top-30 margin-bottom-30 margin-right-5">

					<div class="col-md-auto">
						<cts:Button cssClass="back" spanClass="arrow-left" dAjax="true"
							dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=WF" />
						<button class="btn btn-refresh refresh-linked" type="button">
							<span class="fa fa-refresh"></span>
						</button>
						<button class="btn btn-help" type="button">
							<span class="fa fa-question"></span>
						</button>
					</div>

					<div class="align-right">
						<button id="edit_btn" class="btn btn-save" type="submit">
							<span class="fa fa-save"></span> Save
						</button>
					</div>
				</div>
			</div>
		</cts:AjaxForm>
	</div>
</div>
<script>
	InitHandlers();
	
	$("input[name='task_status']").val($("#task_state option:selected").text());

	$("#btnUser")
			.on(
					"click",
					function() {
						ShowModal("/ac/user/searchuser/?action_type_code=SELECT&actioncallback=loadUser");
					});

	function loadUser(userdata) {
		var emp = JSON.parse(unescape(userdata));
		$("#emp_code").val(emp.empCode);
		$("#emp_name").val(emp.empName);
		$("#username").val(emp.username);
		HideModal('search-modal');
	}

	$("#btnStory")
			.on(
					"click",
					function() {
						ShowModal("/taskman/tman/sprint/searchsprint/?action_type_code=SELECT&actioncallback=loadSprintStory");
					});

	function loadSprintStory(story) {
		var storyList = JSON.parse(unescape(story));
		$("#sprint_name").val(storyList.sprintName);
		$("#suite_code").val(storyList.suiteCode);
		$("#suite_name").val(storyList.suiteName);
		$("#module_code").val(storyList.moduleCode);
		$("#module_name").val(storyList.moduleName);
		$("#priv_grp_code").val(storyList.privGrpCode);
		$("#priv_grp_name").val(storyList.privGrpName);
		$("#privilege_code").val(storyList.privilegeCode);
		$("#privilege_name").val(storyList.privilegeName);
		$("#story_code").val(storyList.sprintStoryCode);
		$("#story_title").val(storyList.sprintStoryName);
		$("#sprint_id").val(storyList.sprintId);
		HideModal('search-modal');
	}

	function showMessage(data) {
		if (data.outcome == 'success') {
			ShowSuccessMsg('Task Created', data.message);
			isDirty = false;
			LoadMainContent('/taskman/tman/tasks/show/' + data.id);
		} else {
			ShowErrorMsg('Task was not created', data.message);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}

	function validate() {
		/* var suiteName = $("#suite_name").val().trim();
		var moduleName = $("#moduleName").val().trim();
		var privGrpName = $("#priv_grp_name").val().trim(); */
		var taskCode = $("#task_code").val().trim();
		var taskName = $("#task_title").val().trim();
		var estimatedTime = $("#estimated_time").val().trim();
		var description = $("#description").val().trim();
		/* var assigneeCode = $("#emp_code").val().trim();
		var userName = $("#username").val().trim(); */
		var error = "";

		SyncOptionText();

		//return;

		var result = CheckRequired();

		if ($("#suite_code").val() == "-1") {
			error += "Must select new Suite <br/>";
			result = false;

		}

		if ($("#module_code").val() == "-1") {
			error += "Must select new Module <br/>";
			result = false;

		}

		if ($("#priv_grp_code").val() == "-1") {
			error += "Must select new Privilege Group <br/>";
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

			error += "Please check the fields marked with X";
			ShowErrorMsg('Task was not created', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
		} else if (/* suiteName == "" || moduleName == "" || privGrpName == "" ||  */taskCode == "" || taskName == "" || estimatedTime == ""
			|| description == ""/*  || assigneeCode == "" || userName == "" */) {

			error += "Only space is not allowed in required fields";
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