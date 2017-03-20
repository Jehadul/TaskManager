<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Show Sprint</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Show Sprint</span>
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
						<cts:Label name="Suite Name" labelFor="suite_name"/>
						:     <b>${map.sprint.suiteName}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Module Name" labelFor="module_name"/>
						 :     <b>${map.sprint.moduleName}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Privilege Name" labelFor="privilege_name"/>
						:     <b>${map.sprint.privilegeName}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Sprint Name" labelFor="sprint_name"/>
						 :     <b>${map.sprint.sprintName}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Srint Code" labelFor="sprint_code"/>
						 :     <b>${map.sprint.sprintCode}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="Sprint Goal" labelFor="sprint_goal"/>
						 :     <b>${map.sprint.sprintGoal}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="Sprint Number" labelFor="sprint_number"/>
						 :     <b>${map.sprint.sprintNumber}</b>
					</div>
										
					<div class="form-group">
						<cts:Label name="Sprint Stories" labelFor="sprint_stories"/>
						 :     <b>${map.sprint.sprintStories}</b>
					</div>

										
					<div class="form-group">
						<cts:Label name="Sprint Start Date" labelFor="start_date"/>
						 :     <b>${map.sprint.startDate}</b>
					</div>
					
															
					<div class="form-group">
						<cts:Label name="Sprint End Date" labelFor="end_date"/>
						 :     <b>${map.sprint.endDate}</b>
					</div>
					
																				
					<div class="form-group">
						<cts:Label name="Sprint Description" labelFor="sprint_description"/>
						 :     <b>${map.sprint.sprintDescription}</b>
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
		LoadMainContent('/taskman/tman/sprint/edit/' + "${map.sprint.id}");			
	});
	$('#del_btn').on("click",function(){
		$(".delete_form").submit();	
		LoadMainContent("/taskman/tman/sprint/delete");			
	});
	
	
</script>
