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
				<li><span>Home</span></li>
				<li class="active"><span>Dashboard</span></li>
			</ol>
		</div>
	</section>
	<!-- end: PAGE TITLE -->
	<!-- start: YOUR CONTENT HERE -->
	<div class="container-fluid container-fullw bg-white">
	<center><a style="margin-right:15px" href="http://localhost:8080/?desturl=/taskman/userstory/story/storylist">Story Manager</a>
		<a href="http://localhost:8080/?desturl=/taskman/tman/sprint/sprintlist">Sprint Manager</a></center>
		
		<div class="row">
		
			<fieldset>
				<legend> Current Task&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Desc.</th>
								<th>Suite</th>
								<th>Module</th>
								<th>Privilege</th>
								<th>Estimated Time(Hours)</th>
								<th>Spent Time</th>
								<th style="width: 50px;">Remaining Time</th>
								<th style="width: 102px;">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="currentTasklist" items="${data.currentTasklist}">
								<tr>
									<%-- <td style="display:nome;"><input type="hidden" name="id1" class="task_id"
									value="${currentTasklist.getId()}" /></td> --%>
									<td><cts:TextBox name="curr_task_PrivGrpName"
											value="${currentTasklist.description}" cssClass="view" /></td>
									<td><cts:TextBox name="curr_task_SuiteName"
											value="${currentTasklist.getSuiteName() }" cssClass="view" />
									</td>
									<td><cts:TextBox name="curr_task_ModuleName"
											value="${currentTasklist.getModuleName() }" cssClass="view" />
									</td>
									<td><cts:TextBox name="curr_task_PrivGrpName"
											value="${currentTasklist.getPrivGrpName() }" cssClass="view" />
									</td>
									<td><cts:TextBox name="curr_date_est"
											value="${currentTasklist.getEstimatedTime() }"
											cssClass="view" /></td>
									<td><cts:TextBox name="curr_start_time"
											value="${data.currentSpentTime }" cssClass="view" />
									</td>
									<td style="width: 50px;"><cts:TextBox
											name="curr_remaining_time"
											value="${data.currentRemainingTime}"
											cssClass="view" /></td>
									<td style="width: 102px;">
										<button type="button" class="btn btn-xs pull-left"
											id="start-timer"
											style="border: 1px solid #008800; color: #008800">
											<span id="tn"> <time>${data.spentTime}</time>
											</span>
										</button> <span class="pull-left">&nbsp;</span>
										<button type="button" onclick="stopTimer(this);"
											class="btn-del btn btn-xs pull-left" id="stop-timer">
											<span class="fa fa-stop"></span>
										</button> <input type="hidden" name="id1" class="task_id"
										value="${currentTasklist.getId()}" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>
			<fieldset>
				<legend> Task List&nbsp;&nbsp; </legend>
				<div class="table-responsive">
				<center><a href= "http://localhost:8080/?desturl=/taskman/tman/tasks/create">Create Task</a></center>
					<table class="table table-striped table-hover"
						id="task_sort_result">
						<thead>
							<tr>
								<th style="display: none"></th>
								<th>Task Id</th>
								<th>Task Title</th>
								<th>Estimated Time(Hours)</th>
								<th>Spent Time</th>
								<th>Remaining Time</th>
								<th>Assignee</th>
								<th data-orderable="false">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="count" value="0" scope="request" />
							<c:forEach var="task" items="${data.tasklist}">
								<c:if test="${task.getId().toString() != data.running_taskId}">
									<tr>
										<td style="display: none"><input type="hidden" name="id1"
											class="task_id" value="${task.getId()}" /></td>

										<td><c:out value="${task.getTaskCode()}" /></td>
										<td><c:out value="${task.getTaskTitle()}" /></td>
										<td><c:out value="${task.getEstimatedTime()}" /></td>
										<td><c:out value="${data.sp[count]}" /></td>
										<td><c:out value="${data.rem[count]}" /></td>

										<td><c:out value="${task.empName}" /></td>
										<td>
											<button type="button" onclick="editRow(this);"
												class="btn-edit btn btn-xs">
												<span class="fa fa-edit"></span>
											</button>
											<button type="button" onclick="delRow(this);"
												class="btn-del btn btn-xs">
												<span class="fa fa-trash"></span>
											</button>

											<button type="button" onclick="startTimeFromList(this)"
												id="start" class="btn-timer btn btn-xs time-start">
												<span class="fa fa-play"></span></button> 
											<input type="hidden" name="id[]" class="task_id1"
											value="${task.getId()}" /> <input type="hidden"
											name="task_code[]" class="task_code"
											value="${task.getTaskCode()}" /> <input type="hidden"
											name="task_title[]" class="task_title"
											value="${task.getTaskTitle()}" /> <input type="hidden"
											name="estimated_time[]" class="estimated_time"
											value="${task.getEstimatedTime()}" /> <input type="hidden"
											name="spent_time[]" class="spent_time"
											value="${task.getSpentTime()}" /> <input type="hidden"
											name="remaining_time[]" class="remaining_time"
											value="${task.getRemainingTime()}" /> <input type="hidden"
											name="assignee[]" class="assignee" value="${task.empName}" />

										</td>
									</tr>
								</c:if>
								<c:set var="count" value="${count + 1}" scope="request" />
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>
			<form method="POST" action="/taskman/tman/tasks/destroy"
				class="ajax delete_form">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<cts:Hidden name="id" value="" />
			</form>
		</div>
	</div>
	<!-- end: YOUR CONTENT HERE -->
</div>


<script>
	InitHandlers();
	InitDataTable("#task_sort_result");
	var startDate = $("#curr_date_abc").val(); //alert(startDate);
	var startTime = $("#curr_start_time").val(); //alert(startTime)

	//reload();
	window.setInterval(function() {

	}, 10000);

	var delRow = function(el) {
		var spentTime = $(el).closest("tr").find(".spent_time").val();
		if (spentTime == "0") {
			swal({
				title : "Are you sure?",
				text : "Are you sure to delete this privilege?",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#007AFF",
				confirmButtonText : "Yes, delete it!",
				closeOnConfirm : true
			}, function() {
				$("input[name='id']").val(
						$(el).closest("tr").find(".task_id").val());
				$(el).closest("tr").remove();
				$(".delete_form").submit();
			});
		} else {
			swal({
				title : "Can't Delete This Task",
				text : "Task is in Progress",
				type : "warning",
				showCancelButton : false,
				confirmButtonColor : "#007AFF",
				confirmButtonText : "OK",
				closeOnConfirm : true
			});
		}

	};

	$('.btn-edit').on("click", function() {/* console.log($(".task_id").val()) */
		var currentRow = $(this).closest("tr");
		currentRow.addClass("current-row");

		var taskId = currentRow.find(".task_id").val();

		LoadMainContent('/taskman/tman/tasks/edit/' + taskId);
	});
	
	function reload() {
		$.ajax({
			url : "/reloadNoticeBoard",
			type : 'GET',
			dataType : 'json',
			success : function(response, status, xhr) {
				var curr_task = response.data;
				$('#curr_task_SuiteName').val(curr_task.suiteName);
				$('#curr_task_ModuleName').val(curr_task.moduleName);
				$('#curr_task_PrivGrpName').val(curr_task.privGrpName);
				$('#curr_date_est').val(curr_task.estimatedTime);
				$('#curr_start_time').val(curr_task.spentTime);
				$('#curr_remaining_time').val(curr_task.remainingTime);
				console.log(curr_task);
			}
		});
	}
	var seconds = 0, minutes = 0, hours = 0, t;
	var startsqlTime = "${data.spentTime}";
	if (startsqlTime != "") {
		hours += parseInt(startsqlTime.split(":")[0]);
		minutes += parseInt(startsqlTime.split(":")[1]);
		seconds += parseInt(startsqlTime.split(":")[2]);
	}
	function add() {
		seconds++;
		if (seconds >= 60) {
			seconds = 0;
			minutes++;
			if (minutes >= 60) {
				minutes = 0;
				hours++;
			}
		}

		document.getElementById("tn").textContent = (hours ? (hours > 9 ? hours
				: "0" + hours) : "00")
				+ ":"
				+ (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00")
				+ ":" + (seconds > 9 ? seconds : "0" + seconds);

		timer();
	}
	function timer() {
		t = setTimeout(add, 1000);
	}
	var running_status = "${data.running_status}";
	//console.log(running_status);
	if (running_status == "true") {
		//alert("timer on!")
		timer();
	}

	function startTimeFromList(el) {
		var runningTime = $('#tn').text();
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
								+ '<span id="tn">'
								+ '<time>00:00:00</time>'
								+ '</span>'
								+ '</button>'
								+ '<button type="button" onclick="stopTimer(this);" class="btn-del btn btn-xs" id="stop-timer">'
								+ '<span class="fa fa-stop"></span></button> <span id="runningtask" style="color:green">Running</span>';

						timer();
						$(el).before(html);
						$(el).addClass("hidden");
						var id = $(el).closest('tr').find('td')
								.find('.task_id').val();
						console.log(id + "::::::::::::::::::id::::::;;");
						var dt = new Date();

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
						var day = dd + '-' + mm + '-' + yyyy;
						var curr_hour = today.getHours();
						var curr_min = today.getMinutes();
						var curr_sec = today.getSeconds();

						var startTime = day + " " + curr_hour + ":" + curr_min
								+ ":" + curr_sec;
						console.log(startTime);
						$.ajax({
							type : 'GET',
							url : '/taskman/tman/tasks/timeLog/' + id + '/'
									+ startTime + '/' + taskTitle + '/' + day,
							success : function(response, status, xhr) {
								LoadMainContent("/");
							}
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

	function stopTimer(el) {
		var id = $(el).closest('tr').find('td').find('.task_id').val();

		clearTimeout(t);
		//$(".time-start").removeClass("hidden");
		$("#start-timer").remove();
		$("#stop-timer").remove();
		//$("#runningtask").remove();

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
		var day = dd + '-' + mm + '-' + yyyy;
		var curr_hour = today.getHours();
		var curr_min = today.getMinutes();
		var curr_sec = today.getSeconds();

		var stopTime = day + " " + curr_hour + ":" + curr_min + ":" + curr_sec;
		console.log(startTime);

		$.ajax({
			type : 'GET',
			url : '/taskman/tman/tasks/timeLogUpdate/' + id + '/' + stopTime
					+ '/' + day,
			success : function(response, status, xhr) {
				LoadMainContent("/");
			}
		});
	}
</script>