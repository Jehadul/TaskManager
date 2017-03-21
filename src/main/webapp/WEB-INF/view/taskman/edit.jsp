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
					<span>Taskman</span>
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
									<cts:TextBox name="suite_name" cssClass="dirty-check" readonly="readonly" value="${map.tasks.suiteCode}"/>
									<cts:Hidden name="suite_code" value=""/>
									<cts:Hidden name="id" value="${map.tasks.id}"/>
								</div>
								 <div class="form-group">
									<cts:Label labelFor="module_name" name="Module Name"/>
									<cts:TextBox name="module_name" cssClass="dirty-check" readonly="readonly" value="${map.tasks.moduleCode}"/>
									<cts:Hidden name="module_code" value=""/>
								</div>
								<div class="form-group">
									<cts:Label labelFor="priv_grp_name" name="Privilege Group"/>
									<cts:TextBox name="priv_grp_name" cssClass="dirty-check" readonly="readonly" value="${map.tasks.privGrpCode}"/>
									<cts:Hidden name="priv_grp_code" value=""/>
								</div>
								<div class="form-group">
									<cts:Label labelFor="privilege_name" name="Privilege Name"/>
									<cts:TextBox name="privilege_name" cssClass="dirty-check" readonly="readonly" value="${map.tasks.privilegeName}"/>
									<cts:Hidden name="privilege_code" value=""/>
								</div>
								<div class="form-group">						
									<cts:Label name="Story Title" labelFor="story_title"/>
									<cts:TextBox name="story_title" cssClass="dirty-check" readonly="readonly" value="${map.tasks.storyTitle}"/>
									<cts:Hidden name="story_code" value=""/>
								</div>
								
						</fieldset>
								<div class="form-group">						
									<cts:Label name="Task Code" labelFor="task_code"/>
									<cts:TextBox name="task_code" cssClass="dirty-check uppercase required" readonly="" value="${map.tasks.taskCode}"/>
								</div>
						
						
						
					</div>
					<div class="col-md-6">
						
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
									<cts:TextBox name="emp_code" cssClass="dirty-check" readonly="readonly" value="${map.tasks.empCode}"/>
								</div>
								<div class="form-group">						
									<cts:Label name="Assignee Name" labelFor="emp_name"/>
									<cts:TextBox name="emp_name" cssClass="dirty-check" readonly="readonly" value="${map.tasks.empName}"/>
								</div>
								<div class="form-group">						
									<cts:Label name="Username" labelFor="username"/>
									<cts:TextBox name="username" cssClass="dirty-check" readonly="readonly" value="${map.tasks.username}"/>
								</div>
						</fieldset>
					</div>
				</div>
			
			
				<%-- <div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="suite_code" class="control-label">Suite Name</label>
								<cts:Hidden name="id" value="${map.tasks.id}"/>
								<select id="suite_code" class="form-control required" name="suite_code">
									<c:forEach items="${map.suiteCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.tasks.suiteCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>	
								<cts:Hidden name="suite_name" value=""/>		
					   </div>
					   
						<div class="form-group">
							<label for="module_code" class="control-label">Module Name</label>
								<select id="module_code" class="form-control required" name="module_code">
									<c:forEach items="${map.moduleCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.tasks.moduleCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>
								<cts:Hidden name="module_name" value=""/>			
					   </div>
					   
					   <div class="form-group">
							<label for="suite_code" class="control-label">Privilege Group</label>
								
								<select id="priv_grp_code" class="form-control required" name="priv_grp_code">
									<c:forEach items="${map.privGrpCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.tasks.privGrpCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>	
								<cts:Hidden name="priv_grp_name" value=""/>		
					   </div>
					   <div class="form-group">
							<cts:Label name="Story Code" labelFor="story_code"/>
							<cts:TextBox name="story_code" value="${map.tasks.storyCode}" cssClass="dirty-check required" readonly=""/>
						</div>
					   <fieldset>
								<legend>
									Assignee&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnUser"/>			
								</legend>
								<div class="form-group">						
									<cts:Label name="Assignee" labelFor="assignee"/>
									<cts:TextBox name="assignee" value="${map.tasks.asignee}" cssClass="dirty-check" readonly="readonly"/>
								</div>
						</fieldset>
						<div class="form-group">						
							<cts:Label name="Task Code" labelFor="task_code"/>
							<cts:TextBox name="task_code" value="${map.tasks.taskCode}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">						
							<cts:Label name="Task Title" labelFor="task_title"/>
							<cts:TextBox name="task_title" value="${map.tasks.taskTitle}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Estimated Time (Hour)" labelFor="estimated_time"/>
							<cts:TextBox name="estimated_time" value="${map.tasks.estimatedTime}" cssClass="dirty-check required number" readonly=""/>
						</div>
					</div>
					<div class="col-md-6">
						
						
						<div class="form-group">						
							<cts:Label name="Assignee" labelFor="assignee"/>
							<cts:TextBox name="assignee" value="${map.tasks.asignee}"  cssClass="dirty-check" readonly=""/>
						</div>
						
						
						<div class="form-group">
								<cts:Label name="Description" labelFor="description"/>
								<cts:TextArea name="description" value="${map.tasks.description}" cssClass="dirty-check required" readonly="" rows="3" cols=""/>
						</div>
						<fieldset>
							<legend>
									Story Code&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnStory"/>			
							</legend>
								<div class="form-group">						
									<cts:TextBox name="story_code" value="${map.tasks.storyCode}" cssClass="dirty-check" readonly="readonly"/>
								</div>
						</fieldset>
						<fieldset>
								<legend>
									Assignee&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnUser"/>			
								</legend>
								<div class="form-group">						
									<cts:Label name="Assignee" labelFor="assignee"/>
									<cts:TextBox name="assignee" value="${map.tasks.asignee}" cssClass="dirty-check" readonly="readonly"/>
								</div>
						</fieldset>
					</div>
				</div> --%>
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
   
   function showMessage(data) {
		if (data.outcome == 'success') {
			isDirty = false ;
			ShowSuccessMsg('Tasks Updated', data.msg);
			
			LoadMainContent('/taskman/tman/tasks/show/'+ data.id);
		} else {
			ShowErrorMsg('Tasks was not Updated', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}

	$('#suite_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		LoadMainContent("/taskman/tman/tasks/create/?suite_code=" + newSuiteCode);
	
	});
	
	$('#module_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		LoadMainContent("/taskman/tman/tasks/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode);
	
	});
	
	$('#priv_grp_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		var newPrivGroupCode = $("#priv_grp_code").val();
		LoadMainContent("/taskman/tman/tasks/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode + "&" + "priv_grp_code=" + newPrivGroupCode);
	});
	
	$("#btnUser").on("click",function(){
		ShowModal("/ac/user/searchuser/?action_type_code=SELECT&actioncallback=loadUser");
	});
	
	
	$("#btnStory").on("click",function(){
		ShowModal("/taskman/userstory/story/searchstory/?action_type_code=SELECT&actioncallback=loadStory");
	});

	function loadStory(story){ 
		var storyList = JSON.parse(unescape(story));			
		$("#story_code").val(storyList.userStoryCode);	
		$("#story_name").val(storyList.userStoryTitle);	
		HideModal('search-modal');	
	}
	
	function validate() {
		var itemCode = $("#task_code").val().trim();
		var itemName = $("#task_title").val().trim();
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

		        if(itemCode==""){
		            $('#task_code').selectRange(0, 0);}
		        else if(itemName==""){
		            $('#task_title').selectRange(0, 0);}
		         
		        
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
		
		else if(itemCode==""||itemName==""){
			
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