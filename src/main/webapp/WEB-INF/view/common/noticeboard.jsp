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
				<legend> Current Task&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Suite</th>
								<th>Module</th>
								<th>Privilege</th>
								<th>Estimated Time</th>
								<th>Spent Time</th>
								<th>Remaining Time</th>
								<th>Action</th>	
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
								<th>Suite</th>
								<th>Module</th>
								<th>Privilege</th>
								<th>Estimated Time</th>
								<th>Spent Time</th>
								<th>Remaining Time</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${data.tasklist}">
								<tr>
									<td>
										<cts:TextBox name="task_title" value="${task.getSuiteName() }" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="estimate_time" value="${task.getModuleName()}" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="spent_time" value="${task.getPrivGrpName()}" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="spent_time" value="${task.getEstimatedTime()}" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="spent_time" value="${task.getSpentTime()}" cssClass="view"/>
									</td> 
									<td>
										<cts:TextBox name="remaining_time" value="${task.getRemainingTime()}" cssClass="view"/>
									</td>
									<td>
										<button type="button" onclick="startTimer(this);"
											class="btn-timer btn btn-xs time-start">
											<span class="fa fa-play"></span>
										</button>
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
		
		
		var stop;
		var html;
		function startTimer(el) {

			var runningTime = $('#show-timer').text();
			if (runningTime == "") {
				swal(
						{
							title : "Do you want to start new task?",
							text : "",
							type : "warning",
							showCancelButton : true,
							confirmButtonColor : "#007AFF",
							confirmButtonText : "Yes",
							closeOnConfirm : true
						},
						function() {
							html = ' <button type="button" class="btn-edit btn btn-xs" id="start-timer">'
									+ '<div id="show-timer" >00:00:00s</div></button>'
									+ '<button type="button" onclick="stopTimertest(this);" class="btn-del btn btn-xs" id="stop-timer">'
									+ '<span class="fa fa-stop"></span></button>';
							stop = setTimeout("showTime()", 1000);
							$(el).before(html);
							$(el).addClass("hidden");
							var id = $(el).closest('tr').find('td')
									.find('.task_id').val();
							var dt = new Date();
							var startTime = dt.toLocaleTimeString();
							var taskTitle = $(el).closest('tr').find('td').find(
									'.task_title').val();

							//start date
							var today = new Date();
							var dd = today.getDate();
							var mm = today.getMonth() + 1;
							var yyyy = today.getFullYear();
							if (dd < 10) {
								dd = '0' + dd;
							}
							if (mm < 10) {
								mm = '0' + mm;
							}
							var today1 = dd + '-' + mm + '-' + yyyy;

							//console.log(today);
							$.ajax({
								type : 'GET',
								url : '/taskman/tman/tasks/timeLog/' + id + '/'
										+ startTime + '/' + taskTitle + '/'
										+ today1
							});
						});

			} else {
				swal({
					title : "Another Task is already Running",
					text : "Please stop running task",
					type : "warning",
					showCancelButton : false,
					confirmButtonColor : "#007AFF",
					confirmButtonText : "Ok",
					closeOnConfirm : true
				});
			}
		}

		function stopTimertest(el) {
			var id = $(el).closest('tr').find('td').find('.task_id').val();
			console.log(id);
			clearTimeout(stop);
			$(".time-start").removeClass("hidden");
			$("#start-timer").remove();
			$("#stop-timer").remove();

			var dt = new Date();
			var stopTime = dt.toLocaleTimeString();
			$.ajax({
				type : 'GET',
				url : '/taskman/tman/tasks/timeLogUpdate/' + id + '/' + stopTime
			});

		}

		function showTime() {
			var dt = new Date();
			$('#show-timer').html(dt.toLocaleTimeString());
			stop = setTimeout("showTime()", 1000);
		}

		var runningTaskLogId = "${data.taskloglist.taskId}";
		if (runningTaskLogId != " ") {
			var htmlRuning = ' <button type="button" class="btn-edit btn btn-xs" id="start-timer">'
					+ '<div id="show-timer" >00:00:00s</div></button>'
					+ '<button type="button" onclick="stopTimertest(this);" class="btn-del btn btn-xs" id="stop-timer">'
					+ '<span class="fa fa-stop"></span></button>';

			$('.task_id').each(function(index, element) {
				if ($(this).val() == runningTaskLogId & index == 0) {
					$(this).closest('tr').find('.time-start').before(htmlRuning);
					stop = setTimeout("showTime()", 1000);
					$(this).closest('tr').find('.time-start').addClass("hidden");
					console.log(index);
				}
			});
		}
		
		
		
	</script>