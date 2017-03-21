<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Show User Story</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>User Story</span></li>
				<li class="active"><span>User Story</span></li>
			</ol>
		</div>
	</section>

	<!-- end: PAGE TITLE -->
	<!-- start: USER PROFILE -->
	<div class="container-fluid container-fullw bg-white">

		<form method="POST" action="/taskman/userstory/story/destroy"
			class="ajax delete_form">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<cts:Hidden name="id" value="${map.userStory.id }" />
		</form>

		<div>
			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with <span
					class="text-red fa fa-close"></span>.
			</div>



			<div class="row">
				<div class="col-sm-6">
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Suite Name"
									labelFor="suite_name" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.suiteName}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Module Name"
									labelFor="module_name" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.moduleName}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Privilege Group Name"
									labelFor="priv_grp_name" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.privGrpName}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Privilege Code"
									labelFor="privilege_code" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.privilegeCode}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Privilege Name"
									labelFor="privilege_name" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.privilegeName}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="User Story Code"
									labelFor="user_story_code" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.userStoryCode}</b></td>
						</tr>
					</table>
				</div>
				<div class="col-sm-6">
					<table>
						<tr>
							<td class="width-150"><cts:Label name="User Story Title"
									labelFor="user_story_title" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.userStoryTitle}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Priority"
									labelFor="priority" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.priority}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Story Order"
									labelFor="story_order" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.storyOrder}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Acceptance Criteria"
									labelFor="acceptance_criteria" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.acceptanceCriteria}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Business Value"
									labelFor="business_value" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.businessValue}</b></td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Size" labelFor="size" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.size}</b></td>
						</tr>
					</table>
				</div>

				<div class="col-md-12">
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Description"
									labelFor="description" /></td>
							<td class="width-50">:</td>
							<td><b>${map.userStory.description}</b></td>
						</tr>
					</table>
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
						<span class="fa fa-edit"></span> Edit
					</button>
					<button id="del_btn" class="btn btn-del" type="submit">
						<span class="fa fa-trash"></span> Delete
					</button>
				</div>
				
			</div>


		</div>





	</div>
</div>

<script>
	InitHandlers();
	$(function() {
		$("#suite_code").focus();
	});

	$('#edit_btn').on(
			"click",
			function() {
				LoadMainContent('/taskman/userstory/story/edit/'
						+ "${map.userStory.id}");
			});

	$('#del_btn').on("click", function() {

		swal({
			title : "Are you sure?",
			text : "Are you sure to delete this privilege?",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#007AFF",
			confirmButtonText : "Yes, delete it!",
			closeOnConfirm : true
		}, function() {
			$(".delete_form").submit();
			LoadMainContent("/taskman/userstory/story/create");
		});

	});
</script>