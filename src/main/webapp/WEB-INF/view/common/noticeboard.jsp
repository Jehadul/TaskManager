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
				<legend> Current Tasks&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
							<thead>
								<tr>
								<th>Task Title</th>
								<th>Estimated Time</th>
								<th>Spent Time</th>
								<th>Remaining Time</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="currentTasklist" items="${data.currentTasklist}">
								<tr>
									<td>
										<cts:TextBox name="curr_task_title" value="${currentTasklist.getTaskTitle() }" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="curr_date_abc" value="${currentTasklist.getEstimatedTime() }" cssClass="view"/>
									</td>									
									<td>
										<cts:TextBox name="curr_start_time" value="${currentTasklist.getSpentTime() }" cssClass="view"/>
									</td>													
									<td>
										<cts:TextBox name="curr_remaining_time" value="${currentTasklist.getRemainingTime() }" cssClass="view"/>
									</td>						
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>	
			<fieldset>
				<legend>Task List&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover"
						id="task_sort_result">
							<thead>
								<tr>
								<th>Task Title</th>
								<th>Estimated Time</th>
								<th>Spent Time</th>
								<th>Remaining Time</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${data.tasklist}">
								<tr>
									<td>
										<cts:TextBox name="task_title" value="${task.getTaskTitle() }" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="estimate_time" value="${task.getEstimatedTime()}" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="spent_time" value="${task.getSpentTime()}" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="remaining_time" value="${task.getRemainingTime()}" cssClass="view"/>
									</td>
							
															
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
		var startDate = $("#curr_date_abc").val(); //alert(startDate);
		var startTime = $("#curr_start_time").val(); //alert(startTime)
		
		
		
	</script>