<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Edit User Story</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>User Story</span>
				</li>
				<li class="active">
					<span>Edit User Story</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/userstory/story/update" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="suite_code" class="control-label">Suite Name</label>
								<cts:Hidden name="id" value="${map.userStory.id}"/>
								<select id="suite_code" class="form-control required" name="suite_code">
									<c:forEach items="${map.suiteCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.userStory.suiteCode}">
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
										<c:when test="${item.getKey() == map.userStory.moduleCode}">
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
							<label for="suite_code" class="control-label">Privilege Group</label>
								
								<select id="priv_grp_code" class="form-control required" name="priv_grp_code">
									<c:forEach items="${map.privGrpCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.userStory.privGrpCode}">
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
							<cts:Label name="Privilege Code" labelFor="privilege_code" />
							<cts:TextBox name="privilege_code" cssClass="dirty-check required "  value="${map.userStory.privilegeCode}" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label  labelFor="privilege_name" name="Privilege Name"/>
							<cts:TextBox name="privilege_name" cssClass="dirty-check required" value="${map.userStory.privilegeName}" readonly=""/>
						</div>
					   
						<div class="form-group">
								<cts:Label name="Story Code" labelFor="user_story_code"/>
								<cts:TextBox name="user_story_code" value="${map.userStory.userStoryCode}" cssClass="dirty-check required" readonly="" />
						
						</div>
						<div class="form-group">
								<cts:Label name="Story Title" labelFor="user_story_title"/>
								<cts:TextBox name="user_story_title" value="${map.userStory.userStoryTitle}" cssClass="dirty-check required" readonly="" />
						</div>
						
					
						
					</div>
					<div class="col-md-6">
						
						<div class="form-group">
							<cts:Label labelFor="priority_code" name="Priority"/>
								<select id="priority_code" class="form-control required" name="priority_code">
									<c:forEach items="${map.priorities}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.userStory.priorityCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>
							<cts:Hidden name="priority" value=""/>
						</div>
						<div class="form-group">
								<cts:Label name="Story Order" labelFor="story_order"/>
								<cts:TextBox name="story_order" value="${map.userStory.storyOrder}" cssClass="dirty-check required number" readonly="" />
						</div>
						<div class="form-group">
								<cts:Label name="Story Size" labelFor="size"/>
								<cts:TextBox name="size" value="${map.userStory.size}" cssClass="dirty-check number" readonly=""/>
						</div>
						
						<div class="form-group">
								<cts:Label name="Business Value" labelFor="business_value"/>
								<cts:TextBox name="business_value" value="${map.userStory.businessValue}" cssClass="dirty-check number" readonly="" />
						</div>
						<div class="form-group">
								<cts:Label name="Acceptence Criteria" labelFor="acceptance_criteria"/>
								<cts:TextArea name="acceptance_criteria" value="${map.userStory.acceptanceCriteria}" cssClass="dirty-check" readonly="" rows="3" cols=""/>
						</div>
						
							
						<div class="form-group">
								<cts:Label name="Description" labelFor="description"/>
								<cts:TextArea name="description" value="${map.userStory.description}" cssClass="dirty-check" readonly="" rows="3" cols=""/>
						</div>
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
   
   	$("input[name='suite_name']").val($("#suite_code option:selected").text());
	$("input[name='module_name']").val($("#module_code option:selected").text());
	$("input[name='priv_grp_name']").val($("#priv_grp_code option:selected").text());
   
   function showMessage(data) {
		if (data.outcome == 'success') {
			isDirty = false ;
			ShowSuccessMsg('User Story Updated', data.msg);
			
			LoadMainContent('/taskman/userstory/story/show/'+ data.id);
		} else {
			ShowErrorMsg('User Story was not Updated', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}

	$('#suite_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		LoadMainContent("/taskman/userstory/story/create/?suite_code=" + newSuiteCode);
	
	});
	
	$('#module_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		LoadMainContent("/taskman/userstory/story/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode);
	
	});
	
	$('#priv_grp_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		var newPrivGroupCode = $("#priv_grp_code").val();
		LoadMainContent("/taskman/userstory/story/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode + "&" + "priv_grp_code=" + newPrivGroupCode);
	});
	
	 $("#privilege_code").on("change", function(){
		 $("#user_story_code").val("");
		 var newPrivilegeCode = $("#privilege_code").val();
		 var newUserStoryCode = newPrivilegeCode + ".";
		 $("#user_story_code").val(newUserStoryCode);
		 
	 });
	 
	 $("#priority_code").on("change", function(){
			$("input[name='priority']").val($("#priority_code option:selected").text());
		});
	
</script>