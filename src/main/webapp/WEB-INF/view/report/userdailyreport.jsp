<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<div class="wrap-content container" id="container"> 
	<!-- start: PAGE TITLE -->
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">User Wise Daily Report</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Taskman</span></li>
				<li class="active"><span>User Wise Daily Report</span></li>
			</ol>
		</div>
	</section>
	<center>
		<a style="margin-right:15px" href="http://localhost:8080">Dashboard</a>
	</center>
	<br/>
	<div class="container-fluid container-fullw bg-white">
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
			<div id="step-1">
				<div class="row">
					<div class="col-md-6">
					
						<fieldset>
							<legend>
							Company Name
							</legend>

	
									<div class="form-group">	
										<cts:Select list="${data.companyCodes}" name="company_code" value="${data.companyCode}" cssClass="required"/>
										<input name="company_name" type="hidden" value="">
									</div>	
													
						</fieldset>	
						<fieldset>				
							<div class="form-group">		
								<cts:Datepicker label="Pick a date" name="start_date" cssClass="start-date-picker required"/>
							</div>				
						</fieldset> 
					</div>
					
					<div class="col-md-6">
						<fieldset>
							<legend>
								User&nbsp;&nbsp;
								<cts:Button cssClass="find" spanClass="search" id="btnUser" />
							</legend>
							<div class="form-group">
								<cts:Label name="User Code" labelFor="emp_code" />
								<cts:TextBox name="emp_code" cssClass="dirty-check required"
									readonly="readonly" />
							</div>
							<div class="form-group">
								<cts:Label name="Name" labelFor="emp_name" />
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
				


			</div><div class="row margin-top-10">
				<div class="col-md-8">
					<cts:Button cssClass="back" spanClass="arrow-left" dAjax="true" dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=ED"/>
					<button class="btn btn-refresh refresh-linked" type="button">
						<span class="fa fa-refresh"></span>
					</button>
					<button class="btn btn-help" type="button">
						<span class="fa fa-question"></span>
					</button>

				</div>

				<div class="col-md-4 pull-right align-right">
					<a class="btn btn-save generate" onclick="generateReport();" target="_blank">
						<span class="fa fa-save"></span> Generate
					</a>
				</div>
			</div>
	</div>
</div>

<script>
	InitHandlers();
	
	function generateReport() {
		var startDate = $("#start_date").val();
		var companyCode =$("#company_code").val();
		var empCode = $("#emp_code").val();
		var empName = $("#emp_name").val();
		var empUsername = $("#username").val();
		
		if ($.trim(empCode) == "") {
			ShowErrorMsg('Error', "Please select a date.");
			InitErrorChange();
			return false;
		}
		console.log(companyCode+empCode+empName+empUsername);
		LoadMainContent("taskman/report/generateuserwisereport/?start_date="+startDate+"&company_code="+companyCode+"&emp_code=" + empCode + "&emp_name="+empName+"&username="+empUsername);
	}
	
	
	$("#btnUser").on("click",function() {
		ShowModal("/ac/user/searchuser/?action_type_code=SELECT&actioncallback=loadUser");
	});

	function loadUser(userdata) {
		var emp = JSON.parse(unescape(userdata));
		$("#emp_code").val(emp.empCode);
		$("#emp_name").val(emp.empName);
		$("#username").val(emp.username);
		HideModal('search-modal');
	}
</script>