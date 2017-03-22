<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Edit Sprint</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Edit Sprint</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/sprint/update" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="suite_code" class="control-label">Suite Name</label>
								<cts:TextBox name="id" value="${map.sprintManager.id}"/>
								<select id="suite_code" class="form-control required" name="suite_code">
									<c:forEach items="${map.suiteCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.sprintManager.suiteCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>	
								<cts:Hidden name="suite_name" value=""/>		
					   </div>
					   
						<div class="form-group">
							<label for="module_code" class="control-label">Module Name</label>
								<select id="module_code" class="form-control required" name="module_code">
									<c:forEach items="${map.moduleCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.sprintManager.moduleCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>
								<cts:Hidden name="module_name" value=""/>			
					   </div>
					   
					   <div class="form-group">
							<label for="priv_grp_code" class="control-label">Privilege Group</label>
								
								<select id="priv_grp_code" class="form-control required" name="priv_grp_code">
									<c:forEach items="${map.privGrpCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.sprintManager.privGrpCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>	
								<cts:Hidden name="priv_grp_name" value=""/>		
					   </div>
						<div class="form-group">
								<cts:Label name="Sprint Code" labelFor="sprint_code"/>
								<cts:TextBox name="sprint_code" value="${map.sprintManager.sprintCode}" cssClass="dirty-check required" readonly="" />
						</div>
						<div class="form-group">
								<cts:Label name="Sprint Name" labelFor="sprint_name"/>
								<cts:TextBox name="sprint_name" value="${map.sprintManager.sprintName}" cssClass="dirty-check required" readonly="" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
								<cts:Label name="Sprint Goal" labelFor="sprint_goal"/>
								<cts:TextBox name="sprint_goal" value="${map.sprintManager.sprintGoal}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
								<cts:Label name="Sprint Number" labelFor="sprint_number"/>
								<cts:TextBox name="sprint_number" value="${map.sprintManager.sprintNumber}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">		
									 <cts:Datepicker label="Start Date" name="start_date" value="${map.sprintManager.startDate}" cssClass="dirty-check" />
								</div>	
							</div>
							<div class="col-md-6">							
								<div class="form-group">		
									 <cts:Datepicker label="End Date" name="end_date" value="${map.sprintManager.endDate}" cssClass="dirty-check" />
								</div>
							</div>	
						</div>
						<div class="form-group">
							<cts:Label name="Description" labelFor="sprint_description"/>
							<cts:TextArea name="sprint_description" value="${ map.sprintManager.sprintDescription}" cssClass="dirty-check" readonly="" rows="3" cols=""/>
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
													<th>Code</th>
													<th>Name</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</fieldset>
							</div>
						</div>
			<div class="row margin-top-10">
					<div class="col-md-8">
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
	
					<div class="col-md-4">
					<button class="btn btn-save pull-right" type="submit">
							<span class="fa fa-save"></span> Save
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
	
   	$("input[name='suite_name']").val($("#suite_code option:selected").text());
	$("input[name='module_name']").val($("#module_code option:selected").text());
	$("input[name='priv_grp_name']").val($("#priv_grp_code option:selected").text());
	
	//$("input[name='story_code[]']").val(map.sprintManager.)
   
   function showMessage(data) {
		if (data.outcome == 'success') {
			isDirty = false ;
			ShowSuccessMsg('Sprint Manager Updated', data.msg);
			
			LoadMainContent('/taskman/tman/sprint/show/'+ data.id);
		} else {
			ShowErrorMsg('Sprint Manager was not Updated', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}

	$('#suite_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		LoadMainContent("/taskman/tman/sprint/create/?suite_code=" + newSuiteCode);
	
	});
	
	$('#module_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		LoadMainContent("/taskman/tman/sprint/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode);
	
	});
	
	$('#priv_grp_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		var newPrivGroupCode = $("#priv_grp_code").val();
		LoadMainContent("/taskman/tman/sprint/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode + "&" + "priv_grp_code=" + newPrivGroupCode);
	});
	
	
	
	// search and select story for stories field

/* 	$("#btnStorySearch").on("click",function(){
		ShowModal("/taskman/userstory/story/searchstory/?action_type_code=SELECT&actioncallback=loadUserStory");
	}); */

/* 	function loadUserStory(storydata){ 
		var story = JSON.parse(unescape(storydata));			
		$("#sprint_stories").val(story.userStoryTitle);	
		$("#sprint_story_code").val(story.userStoryCode);
		HideModal('search-modal');	
	}
	 */
	 
	 $("#btnAddStories").on("click",function(){
			ShowModal("/taskman/userstory/story/searchstory/?action_type_code=SELECT&actioncallback=loadUserStory");
		});
	 
	 var loadUserStory = function(data){ 
			var story = JSON.parse(unescape(data));
			var storyCode          = story.userStoryCode;   
			var storyName          = story.userStoryTitle;    
			

				var html = '<tr>' +					
								'<td>'+ 
									'<input name="story_code[]" type="text" class="project_code view" value="' + storyCode + '" />' +
								'</td>'+
								'<td>'+ 
									'<input name="story_name[]" type="text" class="project_name view"  value="' + storyName + '" />' +
								'</td>'+				
							'</tr>';
			
				
				/*------------------------ project rate edit----------------- */
				
				$("#story_list tbody").append(html);
			
			HideModal('search-modal');	
		};
	
	
	function validate(){
		
		SyncOptionText();
		
		var error = "";
		var result = CheckRequired();
		

		if ( $("#suite_code").val() =="-1") {
			error +="Please select Suite Code <br/>";
			result = false;
			
		}  
		 
		 if ( $("#module_code").val() =="-1") {
				error +="Please select Module Code <br/>";
				result = false;
				
			}  
		 
		 if ( $("#priv_grp_code").val() =="-1") {
				error +="Please select Priv Grp Code <br/>";
				result = false;
				
			} 
		
		if ($("#sprint_code").val() =="") {
			error +="Please Enter Sprint Code<br/> ";
			result = false;
			
		} 

		if ($("#sprint_name").val() =="" ) {
			error +="Please Enter Sprint Name <br/> ";
			result = false;
			
		} 
		
		if ($("#sprint_number").val() =="" ) {
			error +="Please Enter Sprint Number <br/> ";
			result = false;
			
		} 
		
		if ($("#sprint_stories").val() =="" ) {
			error +="Please Enter Sprint Stories <br/> ";
			result = false;
			
		}  
		
		 if ($("#start_date").val() =="" ) {
			error +="Please Select Start Date <br/> ";
			result = false;
			
		} 

		if ($("#end_date").val() =="" ) {
			error +="Please Select End Date <br/> ";
			result = false;
			
		} 
		 
		 
		if (!result) {
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
		} 
		return result;
	}

	
</script>