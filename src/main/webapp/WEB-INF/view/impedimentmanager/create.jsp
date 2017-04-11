<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create Impediment Manager</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Impediment Manager</span>
				</li>
				<li class="active">
					<span>Create Impediment Manager</span>
				</li>
			</ol>
		</div>
	</section>
	<center>
		<a href="http://localhost:8080/?desturl=/taskman/tman/sprint/sprintlist">Back</a>
	</center>
	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/sprint/store" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="alert alert-block alert-danger hidden">
					Please check the fields marked with 
					<span class="text-red fa fa-close"></span>.
			</div>
			
			<div class="denotes-required">denotes a required field.</div>
			
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<cts:Label name="Impediment Code" labelFor="impediment_code"/>
							<cts:TextBox name="impediment_code" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Impediment Name" labelFor="impediment_name"/>
							<cts:TextBox name="impediment_name" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">		
							<cts:Datepicker label="Impediment Submitted Date" name="impediment_submitted_date" cssClass="start-date-picker dirty-check width-200 required"/>
						</div>	
						<%-- <div class="row">
							<div class="col-md-6">
								<div class="form-group">		
									<cts:Datepicker label="Impediment Submitted Date" name="impediment_submitted_date" cssClass="start-date-picker dirty-check width-200 required"/>
								</div>	
							</div>
							<div class="col-md-6">							
								<div class="form-group">		
									<cts:Datepicker label="Impediment Solved Date" name="impediment_solved_date" cssClass="dirty-check required width-200"/>
								</div>
							</div>
						</div>	 --%>
						<div class="form-group">
							<cts:Label labelFor="impediment_type_code" name="Impediment Type"/>
							<cts:Select list="${data.taskStatus}"  name="impediment_type_code" value="" cssClass="required"/>
							<cts:Hidden name="impediment_type" value=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Description" labelFor="description"/>
							<cts:TextArea name="description" cssClass="dirty-check" readonly="" rows="3" cols=""/>
						</div>
					</div>
					<div class="col-md-6">
						<fieldset>
							<legend>
								Reporting Managers' Information&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnStory" />
							</legend>
							<div class="form-group">
								<cts:Label labelFor="reporting_manager_code" name="RM Code" />
								<cts:TextBox name="reporting_manager_code" cssClass="dirty-check required"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<cts:Label labelFor="reporting_manager_name" name="RM Name" />
								<cts:TextBox name="reporting_manager_name" cssClass="dirty-check required"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<cts:Label labelFor="username" name="Username" />
								<cts:TextBox name="username" cssClass="dirty-check required"
									readonly="readonly" />
							</div>

						</fieldset>
					</div>
				</div>
					
				<div class="row margin-top-30 margin-bottom-30 margin-right-5">
					<div class="col-md-auto">
						 <cts:Button cssClass="back" spanClass="arrow-left" dAjax="true" dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=SA" />
						<button class="btn btn-refresh" type="button">
							<span class="fa fa-refresh"></span>
						</button>
						<button class="btn btn-help" type="button">
							<span class="fa fa-question"></span>
						</button>
					</div>
					<div class="align-right">
						<button id="submit" class="btn btn-save pull-right" type="submit">
									<span class="fa fa-save"></span> &nbsp;Save
						</button>
					</div>
				</div>
				
			</div>
		</cts:AjaxForm>
	</div>
</div>
<script>
InitHandlers();

</script>