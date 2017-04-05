<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Show Team</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Show Team</span>
				</li>
			</ol>
		</div>
	</section>

	<!-- end: PAGE TITLE -->
	<!-- start: USER PROFILE -->
	<div class="container-fluid container-fullw bg-white">
	

		<form method="POST" action="/taskman/team/destroy" class="ajax delete_form">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<cts:Hidden name="id" value="${map.team.id }"/>
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
                            <td class="width-150"><cts:Label name="Team Code" labelFor="suite_name"/></td>
								<td class="width-50">:</td>

								<td><b>${map.team.teamCode}</b>
								</td>


                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Team Name" labelFor="module_name"/></td>
								<td class="width-50">:</td>
								<td><b>${map.team.teamName}</b></td>
                        </tr>
                    </table>

				</div>
				<div class="col-md-6">
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="No of Team Member" labelFor="sprint_name"/></td>
								<td class="width-50">:</td>
								<td><b>${map.team.teamSize}</b></td>
                        </tr>
                    </table>
					<table>
                        <tr>
                            <td class="width-150"><cts:Label name="Description" labelFor="sprint_code"/></td>
								<td class="width-50">:</td>
								<td><b>${map.team.description}</b></td>
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
										<th>Code</th>
										<th>Name</th>
										<th>Username</th>
									</tr>
								</thead>
								<tbody>									
									<c:forEach var="teamDetails" items="${map.teamMemberDetailsList}">
										<tr>
											<td>${teamDetails.empCode}</td>
											<td>${teamDetails.empName}</td>
											<td>${teamDetails.username}</td>
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
				<!-- <button id="del_btn" class="btn btn-del" type="button">
					<span class="fa fa-trash"></span>
				</button> -->
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
</div>

<script>
	InitHandlers();
	
	$('#edit_btn').on("click",function(){
		LoadMainContent('/taskman/team/edit/' + "${map.team.id}");			
	});
	
	
</script>

