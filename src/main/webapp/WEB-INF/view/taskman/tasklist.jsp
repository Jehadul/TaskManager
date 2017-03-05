<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<script>
	if(!window.jQuery){window.location = "/?desturl=" + window.location.href;}
</script>
<div class="wrap-content container" id="container">
	<!-- start: PAGE TITLE -->
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Tasks List</h1>
			</div>
			
		</div>
	</section>
	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="" dataHandler="showMessage">
		<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token}" />
	<fieldset>
						<legend>
						Tasks List&nbsp;&nbsp;
						<cts:Button cssClass="find" spanClass="search" id="btnTasks"/>			
						</legend>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<cts:Label name="Task Title" labelFor="task_title"/>
									<cts:TextBox name="task_title" cssClass="readonly  dirty-check"/>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								<cts:Label name="Estimated Time" labelFor="es_time"/>
								<cts:TextBox name="es_time" cssClass="readonly dirty-check"/>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								<cts:Label name="Spent Time" labelFor="sp_time"/>
								<cts:TextBox name="sp_time" cssClass="readonly dirty-check"/>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								<cts:Label name="Remaining Time" labelFor="rm_time"/>
								<cts:TextBox name="rm_time" cssClass="readonly dirty-check"/>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								<cts:Label name="Assignee" labelFor="assignee"/>
								<cts:TextBox name="assignee" cssClass=" readonly dirty-check"/>
								</div>
							</div>
														
						</div>
					</fieldset>
					
					<div class="row margin-top-10">
			<div class="col-md-8">
			 	
			</div>
			<div class="col-md-2">
			 	<button class="btn btn-edit pull-right" type="edit">
				<span class="fa fa-save"></span> Edit 
				
			</button>
			</div>
			<div class="col-md-2">
			 	
				<button class="btn btn-red btn-o pull-right" type="delete">
				<span class="fa fa-close"></span> Delete 
			</button>
			</div>
		</div>
					</cts:AjaxForm>
					</div>
</div>
<script>
	InitHandlers();
	
	$("#btnTasks").on("click",function(){	
		ShowModal("/taskman/tman/tasks/searchtasklist/?action_type_code=SELECT&actioncallback=loadChief");
	});
	
	function loadChief(taskdata){ 
		var tsk = JSON.parse(unescape(taskdata));
		$("#task_title").val(tsk.taskTitle);		
		$("#es_time").val(tsk.estimatedTime);	
		$("#sp_time").val(tsk.spentTime);	
		$("#rm_time").val(tsk.remainingTime);	
		$("#assignee").val(tsk.asignee);		
		
		HideModal('search-modal');	
	}
</script>