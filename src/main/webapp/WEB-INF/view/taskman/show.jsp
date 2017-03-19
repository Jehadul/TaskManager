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

	<!-- end: PAGE TITLE -->
	<!-- start: USER PROFILE -->
	<div class="container-fluid container-fullw bg-white">

		<div>
			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with 
				<span class="text-red fa fa-close"></span>.
			</div>
			<div class="row">
				<div class="col-md-6">
					<!-- <div class="denotes-required">denotes a required field.</div> -->
					
					<div class="form-group">
						<cts:Label name="Suite Name" labelFor="suite_code"/>
						:     <b>${map.tasks.suiteCode}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Module Name" labelFor="module_code"/>
						 :     <b>${map.tasks.moduleCode}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Priv Group Name" labelFor="priv_grp_code"/>
						:     <b>${map.tasks.privGrpCode}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="Story Code" labelFor="story_code"/>
						 :     <b>${map.tasks.storyCode}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Task Code" labelFor="task_code"/>
						 :     <b>${map.tasks.taskCode}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Task Title" labelFor="task_title"/>
						 :     <b>${map.tasks.taskTitle}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="Estimated Time" labelFor="estimated_time"/>
						 :     <b>${map.tasks.estimatedTime}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Assignee" labelFor="assignee"/>
						 :     <b>${map.tasks.asignee}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Description" labelFor="description"/>
						 :     <b>${map.tasks.description}</b>
					</div>
					<%-- <div class="form-group">
						<cts:Label name="Branch Name" labelFor="branch_code"/>
						 :     <b>${map.tasks.taskTitle}</b>
					</div> --%>
					
				</div>
				<div class="col-md-6">
					
					
				</div>
			</div>
		</div>
			<div class="row margin-top-10">
				<div class="col-md-8">
					<cts:Button cssClass="back" spanClass="arrow-left" dAjax="true" dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=WF"/>
					<button class="btn btn-refresh refresh-linked" type="button">
						<span class="fa fa-refresh"></span>
					</button>
					<button class="btn btn-help" type="button">
						<span class="fa fa-question"></span>
					</button>

				</div>

				<div class="col-md-4">
					<button id="edit_btn" class="btn btn-save" type="submit">
						<span class="fa fa-edit"></span> Edit
					</button>
					<button id="del_btn" class="btn btn-del" type="submit">
						<span class="fa fa-trash"></span> Delete
					</button>
				</div>
			</div>
		
	</div>
</div>

<script>
	InitHandlers();
	$(function() {
		$("#suite_code").focus();
	});
	
	$('#edit_btn').on("click",function(){
		LoadMainContent('/taskman/tman/tasks/edit/' + "${map.tasks.id}");			
	});
	$('#del_btn').on("click",function(){
		LoadMainContent("/taskman/tman/tasks/delete");			
	});
	
	
</script>
