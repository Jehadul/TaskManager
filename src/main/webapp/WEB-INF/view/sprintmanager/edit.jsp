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
		<cts:AjaxForm action="/taskman/tman/sprint/store" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="suite_code" class="control-label">Suite Name</label>
								<cts:Hidden name="id" value="${map.sprintManager.id}"/>
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
						
						
						<div class="form-group">
								<cts:Label name="Sprint Goal" labelFor="sprint_goal"/>
								<cts:TextBox name="sprint_goal" value="${map.sprintManager.sprintGoal}" cssClass="dirty-check required" readonly=""/>
						</div>
						
					</div>
					<div class="col-md-6">
						
						<div class="form-group">
								<cts:Label name="Sprint Number" labelFor="sprint_number"/>
								<cts:TextBox name="sprint_number" value="${map.sprintManager.sprintNumber}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
								<cts:Label name="Sprint Stories" labelFor="sprint_stories"/>
								<cts:TextBox name="sprint_stories" value="${map.sprintManager.sprintStories}" cssClass="dirty-check required" readonly=""/>
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
						
						
						
						<%-- <div class="form-group">
								
							 <cts:Datepicker label="Start Date" name="start_date" value="${map.sprintManager.startDate}" cssClass="dirty-check" />
						</div> 
						
						<div class="form-group">
								
							 <cts:Datepicker label="End Date" name="end_date" value="${map.sprintManager.endDate}" cssClass="dirty-check" />
						</div>  --%>
						
							<div class="form-group">
								<cts:Label name="Description" labelFor="sprint_description"/>
								<cts:TextArea name="sprint_description" value="${ map.sprintManager.sprintDescription}" cssClass="dirty-check" readonly="" rows="3" cols=""/>
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
   
   var startDay = "${map.sprintManager.startDate}";
	$("#start_date").datepicker("update", new Date(startDay));
	
	var endDay = "${map.sprintManager.endDate}";
	$("#end_date").datepicker("update", new Date(endDay));
	
   	$("input[name='suite_name']").val($("#suite_code option:selected").text());
	$("input[name='module_name']").val($("#module_code option:selected").text());
	$("input[name='priv_grp_name']").val($("#priv_grp_code option:selected").text());
   
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
	
</script>