<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Edit Task</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Task</span>
				</li>
				<li class="active">
					<span>Edit Task</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/tasks/update" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with 
				<span class="text-red fa fa-close"></span>.
			</div>
		
			<div class="denotes-required">denotes a required field.</div>
			
			<div class="main-control">
			
			<div class="row">
					<div class="col-md-6">
					
						<fieldset>
							<legend>
									Story Details&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnStory"/>			
							</legend>
								<div class="form-group">
									<cts:Label labelFor="suite_name" name="Suite Name"/>
									<cts:TextBox name="suite_name" cssClass="dirty-check required" readonly="readonly" value="${map.tasks.suiteName}"/>
									<cts:Hidden name="suite_code" value="${map.tasks.suiteCode}"/>
									<cts:Hidden name="id" value="${map.tasks.id}"/>
								</div>
								 <div class="form-group">
									<cts:Label labelFor="module_name" name="Module Name"/>
									<cts:TextBox name="module_name" cssClass="dirty-check required" readonly="readonly" value="${map.tasks.moduleName}"/>
									<cts:Hidden name="module_code" value="${map.tasks.moduleCode}"/>
								</div>
								<div class="form-group">
									<cts:Label labelFor="priv_grp_name" name="Privilege Group"/>
									<cts:TextBox name="priv_grp_name" cssClass="dirty-check required" readonly="readonly" value="${map.tasks.privGrpName}"/>
									<cts:Hidden name="priv_grp_code" value="${map.tasks.privGrpCode}"/>
								</div>
								<div class="form-group">
									<cts:Label labelFor="privilege_name" name="Privilege Name"/>
									<cts:TextBox name="privilege_name" cssClass="dirty-check" readonly="readonly" value="${map.tasks.privilegeName}"/>
									<cts:Hidden name="privilege_code" value="${map.tasks.privilegeCode}"/>
								</div>
								<div class="form-group">						
									<cts:Label name="Story Title" labelFor="story_title"/>
									<cts:TextBox name="story_title" cssClass="dirty-check" readonly="readonly" value="${map.tasks.storyTitle}"/>
									<cts:Hidden name="story_code" value="${map.tasks.storyCode}"/>
								</div>
								
						</fieldset>
						
						<div class="form-group">
							<cts:Label labelFor="task_state" name="Task Status" />
							<select id="task_state" class="form-control required"
								name="task_state">
								<c:forEach items="${map.taskStatus}" var="item">
									<c:choose>
										<c:when test="${item.getValue() == map.tasks.taskStatus}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>

									</c:choose>
								</c:forEach>
							</select>
							<cts:Hidden name="task_status" value=""/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">						
							<cts:Label name="Task Code" labelFor="task_code"/>
							<cts:TextBox name="task_code" cssClass="dirty-check uppercase required" readonly="" value="${map.tasks.taskCode}"/>
						</div>
						<div class="form-group">						
							<cts:Label name="Task Title" labelFor="task_title"/>
							<cts:TextBox name="task_title" cssClass="dirty-check required" readonly="" value="${map.tasks.taskTitle}"/>
						</div>
						
						<div class="form-group">
							<cts:Label name="Estimated Time (Hour)" labelFor="estimated_time"/>
							<cts:TextBox name="estimated_time" cssClass="dirty-check required number" readonly="" value="${map.tasks.estimatedTime}"/>
						</div>
						
							
						<div class="form-group">
								<cts:Label name="Description" labelFor="description"/>
								<cts:TextArea name="description" cssClass="dirty-check required" readonly="" rows="3" cols="" value="${map.tasks.description}"/>
						</div>
						<fieldset>
								<legend>
									Assignee Details&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnUser"/>			
								</legend>
								<div class="form-group">						
									<cts:Label name="Assignee Code" labelFor="emp_code"/>
									<cts:TextBox name="emp_code" cssClass="dirty-check required" readonly="readonly" value="${map.tasks.empCode}"/>
								</div>
								<div class="form-group">						
									<cts:Label name="Assignee Name" labelFor="emp_name"/>
									<cts:TextBox name="emp_name" cssClass="dirty-check" readonly="readonly" value="${map.tasks.empName}"/>
								</div>
								<div class="form-group">						
									<cts:Label name="Username" labelFor="username"/>
									<cts:TextBox name="username" cssClass="dirty-check required" readonly="readonly" value="${map.tasks.username}"/>
								</div>
						</fieldset>
					</div>
				</div>
			
				<%-- <div class="row">
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
				</div> --%>
				
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
							<span class="fa fa-save"></span> Update
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
	
	$("#story_state").on("change", function(){
		$("input[name='task_status']").val($("#task_state option:selected").text());
	});
   
   function showMessage(data) {
		if (data.outcome == 'success') {
			isDirty = false ;
			ShowSuccessMsg('Task Updated', data.message);
			
			LoadMainContent('/taskman/tman/tasks/show/'+ data.id);
		} else {
			ShowErrorMsg('Task was not Updated', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}

	
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
	
	
	function validate() {
		var taskCode = $("#task_code").val().trim();
		var taskName = $("#task_title").val().trim();
		var estimatedTime = $("#estimated_time").val().trim();
		var description = $("#description").val().trim();
		var error = "";
		
		SyncOptionText();
		
		var result = CheckRequired();
		
		  $(function() {
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
  
		        
		    }); 
		  

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
	
</script>