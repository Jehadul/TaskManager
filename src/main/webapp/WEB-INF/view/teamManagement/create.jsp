<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create Team</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Team</span></li>
				<li class="active"><span>Create Team</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/team/ui/store"
			dataHandler="showMessage">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with <span
					class="text-red fa fa-close"></span>.
			</div>

			<div class="denotes-required">denotes a required field.</div>

			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
					
						<div class="form-group">
							<cts:Label name="Team Code" labelFor="team_code" />
							<cts:TextBox name="team_code" cssClass="dirty-check required"
								readonly="" />
						</div>
						
						<div class="form-group">
							<cts:Label name="Team Name" labelFor="team_name" />
							<cts:TextBox name="team_name" cssClass="dirty-check required"
								readonly="" />
						</div>

						<div class="form-group">
							<cts:Label name="Number Of Team Member" labelFor="nt_member" />
							<cts:TextBox name="nt_member"
								cssClass="dirty-check required number" readonly="" />
						</div>
						
						<div class="form-group">
							<cts:Label name="Description" labelFor="description" />
							<cts:TextArea name="description" cssClass="dirty-check required"
								readonly="" rows="3" cols="" />
						</div>
					</div>
					
					<div class="col-md-6">
						<fieldset>
							<legend>
								Employee Details&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnEmp" />
							</legend>
							
							<div class="form-group">
								<cts:Label name="Employee Code" labelFor="emp_code" />
								<cts:TextBox name="emp_code" cssClass="dirty-check required"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<cts:Label name="Employee Name" labelFor="emp_name" />
								<cts:TextBox name="emp_name" cssClass="dirty-check"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<cts:Label name="Username" labelFor="username" />
								<cts:TextBox name="username" cssClass="dirty-check required"
									readonly="readonly" />
							</div>
						</fieldset>
						
					</div>
				</div>
				<div class="row margin-top-30 margin-bottom-30 margin-right-5">

					<div class="col-md-auto">
						<cts:Button cssClass="back" spanClass="arrow-left" dAjax="true"
							dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=WF" />
						<button class="btn btn-refresh refresh-linked" type="button">
							<span class="fa fa-refresh"></span>
						</button>
						<button class="btn btn-help" type="button">
							<span class="fa fa-question"></span>
						</button>
					</div>

					<div class="align-right">
						<button id="edit_btn" class="btn btn-save" type="submit">
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

</script>