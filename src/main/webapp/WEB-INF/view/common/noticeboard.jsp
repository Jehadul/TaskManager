<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
	<div class="wrap-content container" id="container">
		<!-- start: PAGE TITLE -->
		<section id="page-title" class="padding-top-10 padding-bottom-10">
			<div class="row">
				<div class="col-sm-8">
					<h1 class="mainTitle">Dashboard</h1>
				</div>
				<ol class="breadcrumb padding-top-20">
					<li>
						<span>Home</span>
					</li>
					<li class="active">
						<span>Dashboard</span>
					</li>
				</ol>
			</div>
		</section>
		<!-- end: PAGE TITLE -->
		<!-- start: YOUR CONTENT HERE -->
		<div class="container-fluid container-fullw bg-white">
			<div class="row">
			<fieldset>
				<legend> Task List&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover"
						id="task_sort_result">
							<thead>
								<tr>
								<th>Task Title</th>
								<th>Estimated Time</th>
								<th>Spent Time</th>
								<th>Remaining Time</th>
								<th>Assignee</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${data.tasklist}">
								<tr>
									<td><c:out value="${task.getTaskTitle()}" /></td>
									<td><c:out value="${task.getEstimatedTime()}" /></td>
									<td><c:out value="${task.getSpentTime()}" /></td>
									<td><c:out value="${task.getRemainingTime()}" /></td>
									<td><c:out value="${task.getAsignee()}" /></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>	
			</div>
		</div>
		<!-- end: YOUR CONTENT HERE -->
	</div>

	
	<script>
		InitHandlers();
		InitDataTable("#task_sort_result");
	</script>