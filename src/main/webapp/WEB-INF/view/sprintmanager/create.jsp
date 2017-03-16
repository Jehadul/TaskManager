<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create Sprint</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Create Sprint</span>
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
							<cts:Label labelFor="suite_code" name="Suite Name"/>
							<cts:Select list="${data.suiteCodes}"  name="suite_code" value="${data.suiteCode }" cssClass="required"/>
							<cts:Hidden name="suite_name" value=""/>
						</div>
						 <div class="form-group">
							<cts:Label labelFor="module_code" name="Module Name"/>
							<cts:Select list="${data.moduleCodes}"  name="module_code" value="${data.moduleCode}" cssClass="required"/>
							<cts:Hidden name="module_name" value=""/>
						</div>
						<div class="form-group">
							<cts:Label labelFor="priv_grp_code" name="Privilege Group"/>
							<cts:Select list="${data.privgroups}"  name="priv_grp_code" value="${data.privGroupCode }" cssClass="required"/>
							<cts:Hidden name="priv_grp_name" value=""/>
						</div>
						
						<div class="form-group">
							<cts:Label name="Sprint Code" labelFor="sprint_code"/>
							<cts:TextBox name="sprint_code" cssClass="dirty-check required" readonly=""/>
						</div>
						
						
						
						<div class="form-group">
							<cts:Label name="Sprint Name" labelFor="sprint_name"/>
							<cts:TextBox name="sprint_name" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Sprint Goal" labelFor="sprint_goal"/>
							<cts:TextBox name="sprint_goal" cssClass="dirty-check" readonly=""/>
						</div>
						

					</div>
					
					<div class="col-md-6">
				
						<div class="form-group">
							<cts:Label name="Sprint Number" labelFor="sprint_number"/>
							<cts:TextBox name="sprint_number" cssClass="dirty-check required number" readonly=""/>
						</div>
						
						<div class="form-group">
							<cts:Label name="Sprint Stories" labelFor="sprint_stories"/>
							<cts:TextBox name="sprint_stories" cssClass="dirty-check required" readonly=""/>
						</div>
						
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">		
									<cts:Datepicker label="Start Date" name="start_date" cssClass="dirty-check  required"/>
								</div>	
							</div>
							<div class="col-md-6">							
								<div class="form-group">		
									<cts:Datepicker label="End Date" name="end_date" cssClass="dirty-check required"/>
								</div>
							</div>	
						</div>	
						
					
						
							
						
						<div class="form-group">
								<cts:Label name="Description" labelFor="sprint_description"/>
								<cts:TextArea name="sprint_description" cssClass="dirty-check" readonly="" rows="3" cols=""/>
						</div>

					</div>
				<div class="row">
					<div class="col-md-8">
						 <cts:Button cssClass="back" spanClass="arrow-left" dAjax="true" dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=SA" />
						<button class="btn btn-refresh" type="button">
							<span class="fa fa-refresh"></span>
						</button>
						<button class="btn btn-help" type="button">
							<span class="fa fa-question"></span>
						</button>
					</div>
					<div class="col-md-4">
						<button id="submit" class="btn btn-save pull-right" type="submit">
									<span class="fa fa-save"></span> &nbsp;Save
						</button>
					</div>
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

function showMessage(data) {
	if (data.outcome == 'success') {
		ShowSuccessMsg('Sprint created', data.message);
		isDirty = false;
		LoadMainContent('/taskman/tman/sprint/show/' + data.id);
	} else {
		ShowErrorMsg('Sprint was not created', data.msg);
		var msg = ConcatWithBR(data.error);
		$(".alert").html(msg);
		$(".alert").removeClass("hidden");
	}
}


</script>