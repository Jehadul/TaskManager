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
					<span>User Story</span>
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
						:     <b>${map.userStory.suiteName}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Module Name" labelFor="module_name"/>
						 :     <b>${map.userStory.moduleName}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Privilege Group Name" labelFor="priv_grp_name"/>
						:     <b>${map.userStory.privGrpName}</b>
					</div>

					<div class="form-group">
						<cts:Label name="Privilege Code" labelFor="privilege_code"/>
						:     <b>${map.userStory.privilegeCode}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="Privilege Name" labelFor="privilege_name"/>
						:     <b>${map.userStory.privilegeName}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="User Story Code" labelFor="user_story_code"/>
						:     <b>${map.userStory.userStoryCode}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="User Story Title" labelFor="user_story_title"/>
						 :     <b>${map.userStory.userStoryTitle}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="Description" labelFor="description"/>
						 :     <b>${map.userStory.description}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="Priority" labelFor="priority"/>
						 :     <b>${map.userStory.priority}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Story Order" labelFor="story_order"/>
						 :     <b>${map.userStory.storyOrder}</b>
					</div>
					
					<div class="form-group">
						<cts:Label name="Acceptance Criteria" labelFor="acceptance_criteria"/>
						:     <b>${map.userStory.acceptanceCriteria}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Business Value" labelFor="business_value"/>
						 :     <b>${map.userStory.businessValue}</b>
					</div>
					<div class="form-group">
						<cts:Label name="Size" labelFor="size"/>
						 :     <b>${map.userStory.size}</b>
					</div>
					
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
		LoadMainContent('/taskman/userstory/story/edit/' + "${map.userStory.id}");			
	});
	$('#del_btn').on("click",function(){
		LoadMainContent("/taskman/userstory/story/storylist");			
	});
	
	
</script>
