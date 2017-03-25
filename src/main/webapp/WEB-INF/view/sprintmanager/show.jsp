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
					<span>Sprint</span>
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
	

		<form method="POST" action="/taskman/tman/sprint/destroy" class="ajax delete_form">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<cts:Hidden name="id" value="${map.sprint.id }"/>
		</form>


		<div>
			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with 
				<span class="text-red fa fa-close"></span>.
			</div>
			
			<div class="row">
				
				<div class="col-md-6">
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Suite Name" labelFor="suite_name"/></td>
								<td class="width-50">:</td>

								<td><b>${map.sprint.suiteName}</b>
								</td>


                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Module Name" labelFor="module_name"/></td>
								<td class="width-50">:</td>
								<td><b>${map.sprint.moduleName}</b></td>
                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Privilege Name" labelFor="privilege_name"/></td>
								<td class="width-50">:</td>
								<td><b>${map.sprint.privilegeName}</b></td>
                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Sprint Name" labelFor="sprint_name"/></td>
								<td class="width-50">:</td>
								<td><b>${map.sprint.sprintName}</b></td>
                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Srint Code" labelFor="sprint_code"/></td>
								<td class="width-50">:</td>
								<td><b>${map.sprint.sprintCode}</b></td>
                        </tr>
                    </table>
				</div>
				<div class="col-md-6">

					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Goal" labelFor="sprint_goal"/></td>
								<td class="width-50">:</td>
								<td><b>${map.sprint.sprintGoal}</b></td>
                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Number" labelFor="sprint_number"/></td>
								<td class="width-50">:</td>
								<td><b>${map.sprint.sprintNumber}</b></td>
                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Start Date" labelFor="start_date"/></td>
								<td class="width-50">:</td>
								<td><b>${map.sprint.startDate}</b></td>
                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="End Date" labelFor="end_date"/></td>
								<td class="width-50">:</td>
								<td><b>${map.sprint.endDate}</b></td>
                        </tr>
                    </table>	
				</div>
                <div class="col-md-12">
                    <table>
                        <tr>
                            <td class="width-150"><cts:Label name="Sprint Description" labelFor="sprint_description"/></td>
                            <td class="width-50">:</td>
                            <td><b>${map.sprint.sprintDescription}</b></td>
                        </tr>
                    </table>
                </div>
			

			</div>
			<div class="row">				
				<div class="col-md-12">
					<fieldset>
						
						<div class="table-responsive">
		           			<table class="table table-striped table-hover" id=story_list>
			           			<thead>
									<tr>
										<th>Story Code</th>
										<th>Story Name</th>
									</tr>
								</thead>
								<tbody>									
									<c:forEach var="story" items="${map.sprintDetails}">
										<tr>
											<td>${story.getSprintStoryCode()}</td>
											<td>${story.getSprintStoryName()}</td>
										</tr>
									</c:forEach>									 
								</tbody>
							</table>
						</div>
					</fieldset>
				</div>
			</div>
			<br/>
			<br/>
			<br/>
			

		</div>
		
		
		
	<div class="row margin-bottom-30 margin-right-5">

			<div class="col-md-auto">
				<cts:Button cssClass="back" spanClass="arrow-left" dAjax="true"
					dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=WF" />
				<button class="btn btn-refresh refresh-linked" type="button">
					<span class="fa fa-refresh"></span>
				</button>
				<button id="del_btn" class="btn btn-del" type="button">
					<span class="fa fa-trash"></span>
				</button>
				<button class="btn btn-help" type="button">
					<span class="fa fa-question"></span>
				</button>

			</div>

			<div class="align-right">
				<button id="edit_btn" class="btn btn-save" type="submit">
					<span class="fa fa-edit"></span> Edit
				</button>
<!-- 				<button id="del_btn" class="btn btn-del" type="submit"> -->
<!-- 					<span class="fa fa-trash"></span> Delete -->
<!-- 				</button> -->
			</div>
		</div>
		
	
</div>

<script>
	InitHandlers();
	
	
	

	$("#suite_code").focus();


	$(function() {
		$("#suite_code").focus();
	});
	
	$('#edit_btn').on("click",function(){
		LoadMainContent('/taskman/tman/sprint/edit/' + "${map.sprint.id}");			
	});
	
	$('#del_btn').on("click",function(){
		
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this sprint?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
			$(".delete_form").submit();
			LoadMainContent("/taskman/tman/sprint/create");	
		});
			
});
	
	
</script>


