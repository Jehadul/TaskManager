<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Edit Team</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Team</span></li>
				<li class="active"><span>Edit Team</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/team/update"
			dataHandler="showMessage">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="alert alert-block alert-danger hidden">
					Please check the fields marked with 
					<span class="text-red fa fa-close"></span>.
			</div>
			
			<div class="denotes-required">denotes a required field.</div>
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<cts:Label name="Team Code" labelFor="team_code" />
							<cts:Hidden name="id" value="${map.team.id}" />
							<cts:TextBox name="team_code"
								value="${map.team.teamCode}"	cssClass="dirty-check required" readonly="" />
						</div>

						<div class="form-group">
							<cts:Label name="Team Name" labelFor="team_name" />
							<cts:TextBox name="team_name"
								value="${map.team.teamName}"	cssClass="dirty-check required" readonly="" />
						</div>
					</div>
					
					
					<div class="col-md-6">						
						<div class="form-group">
							<cts:Label name="Number Of Team Member" labelFor="nt_member" />
							<cts:TextBox name="nt_member"
								value="${map.team.teamSize}"	cssClass="dirty-check required" readonly="readonly" />
						</div>
						<div class="form-group">
							<cts:Label name="Description" labelFor="description" />
							<cts:TextBox name="description"
								value="${map.team.description}"
								cssClass="dirty-check required" readonly="" />
						</div>


					</div>
				
					</div>
				

				<div class="row">
					<div class="col-md-12">
						<fieldset id="fs_multiple_employees" style="display: block;">
							<legend>
								Employee Details&nbsp;&nbsp;
								<button id="btnAddStories" class="btn btn-find" type="button">
									<span class="fa fa-plus"></span>
								</button>
							</legend>
							<div class="table-responsive">
								<table class="table table-striped table-hover" id=emp_list>
									<thead>
										<tr>
											<th>Code</th>
											<th>Name</th>
											<th>User Name</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="i" value="0" scope="request" />
										<c:forEach var="emp" items="${map.teamMemberDetailsList}">
											<tr>
												<td>
													<input name="emp_code[]" type="text" id="code_${i}"  class="project_code view" value="${emp.getEmpCode()}" />
												</td>
												<td>
													<input name="emp_name[]" type="text" class="project_name view"  value="${emp.getEmpName()}" />

												</td>
												<td>
													<input name="emp_username[]" type="text" class="project_username view"  value="${emp.getUsername()}" />

												</td>
												<td>
													<button type="button" onclick="removeEmpRow(this);" class="btn-del btn btn-xs">
														<span class="fa fa-times"></span>
													</button>
												</td>			
											</tr>
											<c:set var="count" value="${i + 1}" scope="request" />
										</c:forEach>
									</tbody>
								</table>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="row margin-top-30 margin-bottom-30 margin-right-5">
					<div class="col-md-auto">
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

					<div class="align-right">
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

	$("#btnAddStories").on("click",function(){
		ShowModal("/ac/user/searchuser/?action_type_code=SELECT&actioncallback=loadUserStory");
	});
	var i = 0;
	var loadUserStory = function(data){ 
		var emp = JSON.parse(unescape(data));
		var empCode          = emp.empCode;   
		var empName          = emp.empName;
		var empUserName      = emp.username;
		var rows = $("#emp_list tbody tr");
		
		for(var i = 0; i< rows.length; i++){
			var code = $(rows[i]).find("#code_"+i).attr("value");
	 		if(code == empCode){
	 			ShowErrorMsg('Employee already in use');
	 			$(".alert").html(msg);
	 			$(".alert").removeClass("hidden");
			}
			
		}
		
			var html = '<tr>' +					
							'<td>'+ 
								'<input name="emp_code[]" type="text" id="code_'+i+'" class="project_code view" value="' + empCode + '" />' +
							'</td>'+
							'<td>'+ 
								'<input name="emp_name[]" type="text" class="project_name view"  value="' + empName + '" />' +
							'</td>'+
							'<td>'+ 
								'<input name="emp_username[]" type="text" class="project_name view"  value="' + empUserName + '" />' +
							'</td>'+
							'<td>'+
								'<button type="button" onclick="removeEmpRow(this);" class="btn-del btn btn-xs">'+
									'<span class="fa fa-times"></span>'+
								'</button>'+
							'</td>'
							
						'</tr>';
		
		
			
			$("#emp_list tbody").append(html);
			i++;
			countEmp();
		
		HideModal('search-modal');	
	};

	var removeEmpRow = function(el){
		$(el).closest("tr").remove();
		countEmp();
	};
	
	
	var countEmp = function(){
		var rows = $("#emp_list tbody tr").length;
		if(rows!=0){
			$("#nt_member").val(rows);
		}else{
			$("#nt_member").val("");
		}
		
		
	}
	
	function showMessage(data) {
		if (data.outcome == 'success') {
			isDirty = false;
			ShowSuccessMsg('Team Updated', data.message);

			LoadMainContent('/taskman/team/show/' + data.id);
		} else {
			ShowErrorMsg('Team was not Updated', data.message);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}
	
</script>