<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Edit Sprint</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Sprint</span></li>
				<li class="active"><span>Edit Sprint</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/sprint/update"
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
							<cts:Hidden name="id" value="${map.sprintManager.id}" />
							<cts:Label name="Sprint Code" labelFor="sprint_code" />
							<cts:TextBox name="sprint_code"
								value="${map.sprintManager.sprintCode}"	cssClass="dirty-check required" readonly="true" />
						</div>
						<div class="form-group">
							<cts:Label name="Sprint Name" labelFor="sprint_name" />
							<cts:TextBox name="sprint_name"
								value="${map.sprintManager.sprintName}"
								cssClass="dirty-check required" readonly="" />
						</div>
						<div class="form-group">
							<cts:Label name="Sprint Number" labelFor="sprint_number" />
							<cts:TextBox name="sprint_number"
								value="${map.sprintManager.sprintNumber}"
								cssClass="dirty-check required" readonly="" />
						</div>

						<div class="form-group">
							<cts:Label name="Sprint Goal" labelFor="sprint_goal" />
							<cts:TextBox name="sprint_goal"
								value="${map.sprintManager.sprintGoal}"
								cssClass="dirty-check required" readonly="" />
						</div>
					</div>
					<div class="col-md-6">
						<fieldset>
							<legend>
								Select Team&nbsp;&nbsp;
							<cts:Button cssClass="find" spanClass="search" id="btnTeamSearch"/>			
							</legend>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<cts:Label name="Team Code" labelFor="team_code" />
										<cts:TextBox name="team_code" cssClass="dirty-check"
											readonly="readonly" value="${map.sprintManager.teamCode}"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<cts:Label name="Team Name" labelFor="team_name" />
										<cts:TextBox name="team_name" cssClass="dirty-check"
											readonly="readonly" value="${map.sprintManager.teamName}"/>
									</div>
								</div>
							</div>
						</fieldset>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<cts:Datepicker label="Start Date" name="start_date"
										value="${map.sprintManager.startDate}" cssClass="dirty-check" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<cts:Datepicker label="End Date" name="end_date"
										value="${map.sprintManager.endDate}" cssClass="dirty-check" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<cts:Label name="Description" labelFor="sprint_description" />
							<cts:TextArea name="sprint_description"
								value="${ map.sprintManager.sprintDescription}"
								cssClass="dirty-check" readonly="" rows="3" cols="" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<fieldset id="fs_multiple_employees" style="display: block;">
							<legend>
								Sprint Stories&nbsp;&nbsp;
								<button id="btnAddStories" class="btn btn-find" type="button">
									<span class="fa fa-plus"></span>
								</button>
							</legend>
							<div class="table-responsive">
								<table class="table table-striped table-hover" id=story_list>
									<thead>
										<tr>
											<th>Story Code</th>
											<th>Story Name</th>
											<th>Suite Name</th>
											<th>Module Name</th>
											<th>PrivGrp Name</th>
											<th>Privilege Name</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="i" value="0" scope="request" />
										<c:forEach var="story" items="${map.sprintDetails}">
											<tr>
												<td>
													<input name="story_code[]" type="text" id="code_${i}"  class="project_code view" value="${story.getSprintStoryCode()}" />
												</td>
												<td>
													<input name="story_name[]" type="text" class="project_name view"  value="${story.getSprintStoryName()}" />

												</td>
												
												<td>
													<input name="suite_name[]" type="text" class="project_name view"  value="${story.getSuiteName()}" />
													<input name="suite_code[]" type="hidden" class="project_name view"  value="${story.getSuiteCode()}" />
												</td>
												<td>
													<input name="module_name[]" type="text" class="project_name view"  value="${story.getModuleName()}" />
													<input name="module_code[]" type="hidden" class="project_name view"  value="${story.getModuleCode()}" />
												</td>
												<td>
													<input name="priv_grp_name[]" type="text" class="project_name view"  value="${story.getPrivGrpName()}" />
													<input name="priv_grp_code[]" type="hidden" class="project_name view"  value="${story.getPrivGrpCode()}" />
												</td>
												<td> 
													<input name="privilege_name[]" type="text" class="project_name view"  value="${story.getPrivilegeName()}" />
													<input name="privilege_code[]" type="hidden" class="project_name view"  value="${story.getPrivilegeCode()}" />
												</td>	
												<td>
													<button type="button" onclick="removeStoryRow(this);" class="btn-del btn btn-xs">
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

	var startDay = "${map.sprintManager.startDate}";
	$("#start_date").datepicker("update", new Date(startDay));

	var endDay = "${map.sprintManager.endDate}";
	$("#end_date").datepicker("update", new Date(endDay));

	function showMessage(data) {
		if (data.outcome == 'success') {
			if($(".sprint-modal").is(":visible")){
				HideModal('sprint-modal');
				isDirty = false;
				ShowSuccessMsg('Sprint Updated', data.message);
				LoadMainContent('/taskman/tman/sprint/sprintlist');
			}
			
			else{
				
				isDirty = false;
				ShowSuccessMsg('Sprint Updated', data.message);
				LoadMainContent('/taskman/tman/sprint/show/' + data.id);
			}
			
		} else {
			ShowErrorMsg('Sprint was not Updated', data.message);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
		
	}



	$("#btnAddStories").on("click",function(){
		ShowModal("/taskman/userstory/story/searchstory/?action_type_code=SELECT&actioncallback=loadUserStory", "modal-md");
	});

	 var i = 0;
	 var loadUserStory = function(data){ 
	 	var story = JSON.parse(unescape(data));
	 	var storyCode          = story.userStoryCode;   
	 	var storyName          = story.userStoryTitle;   
	 	var suiteCode          = story.suiteCode; 
	 	var suiteName		   = story.suiteName;
	 	var moduleCode          = story.moduleCode; 
	 	var moduleName		   = story.moduleName;
	 	var privGrpCode          = story.privGrpCode; 
	 	var privGrpName		   = story.privGrpName;
	 	var privilegeCode          = story.privilegeCode; 
	 	var privilegeName		   = story.privilegeName;
	 	var rows = $("#story_list tbody tr");
	 	
	 	for(var i = 0; i< rows.length; i++){
	 		var code = $(rows[i]).find("#code_"+i).attr("value");
	  		if(code == storyCode){
	  			ShowErrorMsg('Sprint Stories already in use');
	  			$(".alert").html(msg);
	  			$(".alert").removeClass("hidden");
	 		}
	 		
	 	}
	 	
	  
	 	

	 		var html = '<tr>' +					
	 						'<td>'+ 
	 							'<input name="story_code[]" type="text" id="code_'+i+'" class="project_code view" value="' + storyCode + '" />' +
	 						'</td>'+
	 						'<td>'+ 
	 							'<input name="story_name[]" type="text" class="project_name view"  value="' + storyName + '" />' +
	 						'</td>'+
	 						'<td>'+ 
	 						'<input name="suite_name[]" type="text" class="project_name view"  value="' + suiteName + '" />' +
	 						'<input name="suite_code[]" type="hidden" class="project_name view"  value="' + suiteCode + '" />' +
	 						'</td>'+
	 						'<td>'+ 
	 						'<input name="module_name[]" type="text" class="project_name view"  value="' + moduleName + '" />' +
	 						'<input name="module_code[]" type="hidden" class="project_name view"  value="' + moduleCode + '" />' +
	 						'</td>'+
	 						'<td>'+ 
	 						'<input name="priv_grp_name[]" type="text" class="project_name view"  value="' + privGrpName + '" />' +
	 						'<input name="priv_grp_code[]" type="hidden" class="project_name view"  value="' + privGrpCode + '" />' +
	 						'</td>'+
	 						'<td>'+ 
	 						'<input name="privilege_name[]" type="text" class="project_name view"  value="' + privilegeName + '" />' +
	 						'<input name="privilege_code[]" type="hidden" class="project_name view"  value="' + privilegeCode + '" />' +
	 						'</td>'+
	 						'<td>'+
	 							'<button type="button" onclick="removeStoryRow(this);" class="btn-del btn btn-xs">'+
	 								'<span class="fa fa-times"></span>'+
	 							'</button>'+
	 						'</td>'
	 						
	 					'</tr>';
	 	
	 		
	 		/*------------------------ project rate edit----------------- */
	 		
	 		$("#story_list tbody").append(html);
	 		i++;
	 	
	 	HideModal('search-modal');	
	 };


	 var removeStoryRow = function(el){
	 	$(el).closest("tr").remove();
	 };

	  
	 $("#btnTeamSearch").on("click", function() {
	 	ShowModal("/taskman/team/searchteam/?action_type_code=SELECT&actioncallback=loadTeam");
	 });

	 function loadTeam(team) {
	 	var teamList = JSON.parse(unescape(team));
	 		$("#team_code").val(teamList.teamCode);
	 		$("#team_name").val(teamList.teamName);
	 	HideModal('search-modal');
	 }

	 var checkProjectDates = function()
	 {
	 	var startDate= $('#start_date').val();
	 	var endDate= $('#end_date').val();
	 	
	 	if(startDate != '' && endDate != '')
	 	{
	 		if ( new Date(startDate) > new Date(endDate)) {
	 			ShowErrorMsg('',"Please ensure that the Sprint End Date is greater than or equal to the Start Date");
	 			return false;
	 		}
	 	}
	 	return true;
	 };

	function validate() {
		
		var storyCode = $("#sprint_code").val().trim();
		var storyNumber = $("#sprint_number").val().trim();

		SyncOptionText();

		var error = "";
		var result = CheckRequired();

		if ($("#sprint_code").val() == "") {
			error += "Please Enter Sprint Code<br/> ";
			result = false;

		}

		if ($("#sprint_name").val() == "") {
			error += "Please Enter Sprint Name <br/> ";
			result = false;

		}

		if ($("#sprint_number").val() == "") {
			error += "Please Enter Sprint Number <br/> ";
			result = false;

		}


		if ($("#start_date").val() == "") {
			error += "Please Select Start Date <br/> ";
			result = false;

		}

		if ($("#end_date").val() == "") {
			error += "Please Select End Date <br/> ";
			result = false;

		}
		/* 
		if ($("#story_list").val() =="" ) {
			error +="Please Select sprint story <br/> ";
			result = false;
			
		} */
		
		
		if (!checkProjectDates()) {
			result = false;
			error += "Please ensure that the Sprint End Date is greater than or equal to the Start Date.<br />";
		}
		 

		if (!result) {
			
			error +="Please check the fields marked with X";
			ShowErrorMsg('Sprint was not created', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
		}
		else if(storyCode==""||storyNumber==""){
			
			error +="Only space is not allowed in required fields";
			ShowErrorMsg('Sprint was not created', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
			return false;
		}
		return result;
	}
</script>