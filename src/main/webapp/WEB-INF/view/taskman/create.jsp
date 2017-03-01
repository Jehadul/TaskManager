<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create Task</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Create Task</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="sys/aa/privilege/updateprivs" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<cts:Label labelFor="product_name" name="Product Name"/>
							<cts:Select list="${data.productCodes}"  name="priv_grp_code" value="${data.privGroupCode }" cssClass="required" emptyValue="--SELECT--"/>
							<cts:Hidden name="product_name"/>
						</div>
						<div class="form-group">
							<cts:Label labelFor="suite_code" name="Suite Name"/>
							<cts:Select list="${data.suiteCodes}"  name="suite_code" value="${data.suiteCode }" cssClass="required" emptyValue="--SELECT--"/>
							<cts:Hidden name="suite_name"/>
						</div>
						<div class="form-group">
							<cts:Label labelFor="module_code" name="Module Name"/>
							<cts:Select list="${data.moduleCodes}"  name="module_code" value="${data.moduleCode }" cssClass="required" emptyValue="--SELECT--"/>
							<cts:Hidden name="module_name"/>
						</div>
						<div class="form-group">
								<cts:Label name="Description" labelFor="description"/>
								<cts:TextArea name="description" cssClass="dirty-check required" readonly="" rows="3" cols=""/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<cts:Label name="Story Code" labelFor="story_code"/>
							<cts:TextBox name="story_code" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">						
							<cts:Label name="Title" labelFor="title"/>
							<cts:TextBox name="title" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Estimate" labelFor="father1"/>
							<cts:TextBox name="father1" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">						
							<cts:Label name="Assignee" labelFor="assignee"/>
							<cts:TextBox name="assignee" cssClass="dirty-check" readonly=""/>
						</div>
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
									<span class="fa fa-save"></span> &nbspSave
						</button>
					</div>
				</div>
			</div>
		</cts:AjaxForm>
	</div>
</div>
<script>
	$('#suite_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		LoadMainContent("/taskman/tman/tasks/create/?suite_code=" + newSuiteCode);
	
	});
	
	$('#module_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		LoadMainContent("/taskman/tman/tasks/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode);
	
	});
</script>