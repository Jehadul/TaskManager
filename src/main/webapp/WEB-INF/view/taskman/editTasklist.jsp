<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Edit Task List</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Edit Task List</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/tasks/updateTasklist" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<cts:Hidden name="id" value="${map.tasks.id}"/>
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">						
							<cts:Label name="Task Title" labelFor="task_title"/>
							
							<cts:TextBox name="task_title" value="${map.tasks.taskTitle}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Estimated Time" labelFor="estimated_time"/>
							<cts:TextBox name="estimated_time" value="${map.tasks.estimatedTime}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Spent Time" labelFor="estimated_time"/>
							<cts:TextBox name="spent_time" value="${map.tasks.spentTime}" cssClass="dirty-check required" readonly=""/>
						</div>
						
					</div>
					<div class="col-md-6">
						
						<div class="form-group">
							<cts:Label name="Remaining Time" labelFor="estimated_time"/>
							<cts:TextBox name="remaining_time" value="${map.tasks.remainingTime}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">						
							<cts:Label name="Assignee" labelFor="assignee"/>
							<cts:TextBox name="assignee" value="${map.tasks.asignee}"  cssClass="dirty-check" readonly=""/>
						</div>
					</div>
				</div>
				<div class="row margin-top-10">
			<div class="col-md-8">
						<button class="btn btn-back" data-ajax="true"
						data-href="/toc?type=privgrp&currprivgrp=3&currmodcode=PM"
						title="Back" type="button">
						<span class="fa fa-arrow-left"></span>
					</button>
					<button class="btn btn-refresh refresh-linked" type="button">
						<span class="fa fa-refresh"></span>
					</button>
					<button class="btn btn-help" type="button">
						<span class="fa fa-question"></span>
					</button>

				</div>

				<div class="col-md-4">
				<button class="btn btn-save pull-right" type="submit">
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
   
   function showMessage(data) {
		if (data.outcome == 'success') {
			isDirty = false ;
			ShowSuccessMsg('Task List Updated', data.msg);
			
			LoadMainContent('/taskman/tman/tasks/tasklist/');
		} else {
			ShowErrorMsg('Task List was not Updated', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}

</script>