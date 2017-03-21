<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Show Task</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Taskman</span></li>
				<li class="active"><span>Show Task</span></li>
			</ol>
		</div>
	</section>

	<!-- end: PAGE TITLE -->
	<!-- start: USER PROFILE -->
	<div class="container-fluid container-fullw bg-white">

		<form method="POST" action="/taskman/tman/tasks/destroy"
			class="ajax delete_form">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<cts:Hidden name="id" value="${map.tasks.id }" />
		</form>

		<div>
			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with <span
					class="text-red fa fa-close"></span>.
			</div>


			<!-- div 1................. -->
			<div class="row">
				<div class="col-md-6">
					<!-- <div class="denotes-required">denotes a required field.</div> -->

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Suite Name"
									labelFor="suite_code" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.suiteName}</b></td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Module Name"
									labelFor="module_code" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.moduleName}</b></td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Priv Group Name"
									labelFor="priv_grp_code" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.privGrpName}</b></td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Story Code"
									labelFor="story_code" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.storyCode}</b></td>
						</tr>
					</table>


					<%-- <div class="form-group">
						<cts:Label name="Branch Name" labelFor="branch_code"/>
						 :     <b>${map.tasks.taskTitle}</b>
					</div> --%>

				</div>
				<!-- div 2............. -->
				<div class="col-md-6">

					<table>
						<tr>
							<td class="width-150"><cts:Label name="Task Code"
									labelFor="task_code" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.taskCode}</b></td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Task Title"
									labelFor="task_title" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.taskTitle}</b></td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Estimated Time"
									labelFor="estimated_time" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.estimatedTime}</b></td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Assignee"
									labelFor="assignee" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.asignee}</b></td>
						</tr>
					</table>
				</div>


				<div class="col-md-12">
					<table>
						<tr>
							<td class="width-150"><cts:Label name="Description"
									labelFor="description" /></td>
							<td class="width-50">:</td>
							<td><b>${map.tasks.description}</b></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<br /> <br /> <br />

		<div class="row margin-top-30 margin-bottom-30">

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

<script>
	InitHandlers();
	$(function() {
		$("#suite_code").focus();
	});

	$('#edit_btn').on("click", function() {
		LoadMainContent('/taskman/tman/tasks/edit/' + "${map.tasks.id}");
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
			LoadMainContent("/taskman/tman/tasks/create");
		});

	});
</script>
