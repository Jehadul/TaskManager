<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<div class="wrap-content container" id="container">
	<!-- start: PAGE TITLE -->

	<!-- <section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Daily Summary</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Daily Summary</span></li>
				<li class="active"><span>Daily Summary List</span></li>
			</ol>
		</div>
	</section> -->

	<div class="container-fluid container-fullw bg-white">

		<div class="align-center">
			<h3>Daily Summary</h3>
			<p>Date : ${log.reportDate}</p>
		</div>
		
		<div class="align-right">
			Date:  <%= new java.util.Date() %></span>
		</div>

		<div class="align-left" style="margin-top: -50px;">
			<img src="/assets/logo/CTS.png" width="10%" height="10%" /><br /> 
			<b>CTrends Software & Services Ltd.</b><br /> 
			Plot - 76 (5th Floor), Block - B, Road - 4,<br /> 
			Niketon, Gulshan - 1, Dhaka - 1212.<br /> <br />
		</div>

		<div class="row margin-bottom-30">
			<hr>
		</div>
		
		<%-- <center>
				<a href="http://localhost:8081/?desturl=/taskman/report/generatedailysummary"></a>
		</center> --%>

		<!-- <fieldset>
			<legend> Date &nbsp;&nbsp; </legend> -->


			<div class="table-responsive">
				<table class="table table-striped table-hover"
					id="sprint_sort_result">
					<thead>
						<tr>
							<th>Suite Name</th>
							<th>Module Name</th>
							<th>Privilege Group Name</th>
							<th>Privilege Name</th>

							<th>Employee Name</th>
							<th>Employee Code</th>
							<th>User Name</th>
							<th>Task Code</th>

							<th>Task Title</th>
<!-- 							<th>Estimated Time</th> -->
							<th>Spent Time</th>
<!-- 							<th>Remaining Time</th> -->
							<th>Start Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="d" items="${log.dsummery}">
							<tr>
								<td><c:out value="${d.getSuiteName()}" /></td>
								<td><c:out value="${d.getModuleName()}" /></td>
								<td><c:out value="${d.getPrivGrpName()}" /></td>
								<td><c:out value="${d.getPrivilegeName()}" /></td>

								<td><c:out value="${d.getEmpName()}" /></td>
								<td><c:out value="${d.getEmpCode()}" /></td>
								<td><c:out value="${d.getUsername()}" /></td>
								<td><c:out value="${d.getTaskCode()}" /></td>

								<td><c:out value="${d.getTaskTitle()}" /></td>
								<td><c:out value="${d.getSpentTimeTemp()}" /></td>
<%-- 								<td><c:out value="${d.getEstimatedTime()}" /></td> --%>
								<td colspan="2" class="align-left"><c:out value="${d.getStartDate()}" /></td>
<%-- 								<td><c:out value="${d.getRemainingTime()}" /></td> --%>
							</tr>
							
						</c:forEach>
					</tbody>
				</table>
				
				<%-- <table class="table">
					<thead>
						<tr>
							<th>Start Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dj" items="${data.tasklog}">
							<tr>
								<td><c:out value="${dj.getStartDate()}" /></td>
								<td><c:out value="${dj.getTaskId()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table> --%>
				
				
			</div>
		<!-- </fieldset> -->

	</div>

</div>



<script>
	InitHandlers();


	
</script>

