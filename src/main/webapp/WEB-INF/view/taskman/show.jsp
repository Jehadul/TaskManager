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
			
			
			<!-- div 1................. -->
			<div class="row">
				<div class="col-md-6">
					<!-- <div class="denotes-required">denotes a required field.</div> -->
					
					
					<div class="row">
						<div class="col-md-4"><cts:Label name="Suite Name" labelFor="suite_code"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.suiteName}</b></div>
					</div>
					
					<div class="row">
						<div class="col-md-4"><cts:Label name="Module Name" labelFor="module_code"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.moduleName}</b></div>
					</div>
					
					<div class="row">
						<div class="col-md-4"><cts:Label name="Priv Group Name" labelFor="priv_grp_code"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.privGrpName}</b></div>
					</div>
					
					<div class="row">
						<div class="col-md-4"><cts:Label name="Story Code" labelFor="story_code"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.storyCode}</b></div>
					</div>
					
					<div class="row">
						<div class="col-md-4"><cts:Label name="Task Code" labelFor="task_code"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.taskCode}</b></div>
					</div>
					
					
					<%-- <div class="form-group">
						<cts:Label name="Branch Name" labelFor="branch_code"/>
						 :     <b>${map.tasks.taskTitle}</b>
					</div> --%>
					
				</div>
				<!-- div 2............. -->
				<div class="col-md-6">
				
					<div class="row">
						<div class="col-md-4"><cts:Label name="Task Title" labelFor="task_title"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.taskTitle}</b></div>
					</div>
					
					<div class="row">
						<div class="col-md-4"><cts:Label name="Estimated Time" labelFor="estimated_time"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.estimatedTime}</b></div>
					</div>
					
					<div class="row">
						<div class="col-md-4"><cts:Label name="Assignee" labelFor="assignee"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.asignee}</b></div>
					</div>
					
					<div class="row">
						<div class="col-md-4"><cts:Label name="Description" labelFor="description"/></div>
						<div class="col-md-1">:</div>
						<div class="col-md-7"><b>${map.tasks.description}</b></div>
					</div>
					
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
		$(".delete_form").submit();
		LoadMainContent("/taskman/tman/tasks/create");			
	});
	
	
</script>
