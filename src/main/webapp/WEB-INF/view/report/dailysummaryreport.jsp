<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Daily Summary</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Task</span></li>
				<li class="active"><span>Daily Summary</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action=""
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
							<div class="col-md-12">
								<div class="form-group">		
									<cts:Datepicker label="Start Date" name="start_date" cssClass="start-date-picker   required"/>
								</div>	
							</div>
							</div>
				<%-- <div class="row">
					<div class="col-md-6">
						<fieldset>
							<legend>
								Select Employee&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnUser" />
							</legend>
							<div class="form-group">
								<cts:Label name="Assignee Code" labelFor="emp_code" />
								<cts:TextBox name="emp_code" cssClass="dirty-check required"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<cts:Label name="Assignee Name" labelFor="emp_name" />
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
				</div> --%>

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
						<button id="generate_btn" class="btn btn-save" type="button" onclick=generatereport()>
							<span class="fa fa-save"></span> Generate
						</button>
					</div>
				</div>
			</div>
		</cts:AjaxForm>
	</div>
</div>
<script>
	InitHandlers();

	$("#btnUser")
			.on(
					"click",
					function() {
						ShowModal("/ac/user/searchuser/?action_type_code=SELECT&actioncallback=loadUser");
					});

	function loadUser(userdata) {
		var emp = JSON.parse(unescape(userdata));
		$("#emp_code").val(emp.empCode);
		$("#emp_name").val(emp.empName);
		$("#username").val(emp.username);
		HideModal('search-modal');
	};
	
	$("#start_date").datepicker().datepicker("setDate", new Date());
	
	function generatereport(){
		var startdate = $("#start_date").val();
		console.log(startdate);
		LoadMainContent("taskman/report/generateDailySummaryPdfReport/"+startdate);
	}
	
</script> 