<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Task List</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Task</span></li>
				<li class="active"><span>Task List</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<fieldset>
			<legend> Task List&nbsp;&nbsp; </legend>
			<div class="table-responsive">
				<table class="table table-striped table-hover" id="task_sort_result">
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
									<button type="button" onclick="startTime(this)" id="start"
										class="btn-timer btn btn-xs time-start">
										<span class="fa fa-play"></span>
									</button> <!-- <button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button> 
										<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button> -->
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
	<!-- Modal -->

	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Edit Remaining Hours</h4>
				</div>
				<div id="warningmsg"></div>
				<div class="modal-body">
					<div class="form-group">
					<div class="row">
						<div class="col-md-3">
							<cts:Label labelFor="remaining_time" name="Remaining Hours"/>
						</div>
						<div class="col-md-9">
							<cts:TextBox name="remaining_time" cssClass="number" value=""/>
						</div>
					</div>
				</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="remaininghoursok" class="btn btn-default">
							<span class="fa fa-check">Ok</span>
					</button>
				</div>
			</div>

		</div>
	</div>

</div>

<script>
	InitHandlers();

	InitDataTable("#task_sort_result");

	var delRow = function(el) {

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

		var spentTime = $(el).closest("tr").find(".spent_time").val();
		console.log(spentTime + "::::::::::::::::::::spent_time:::::::::::::");
		if (spentTime == "0") {
			swal({
				title : "Are you sure?",
				text : "Are you sure to delete this task?",
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

				$.ajax({
					type : 'GET',
					url : '/taskman/tman/tasks/tasklist',
					success : function(response, status, xhr) {
						LoadMainContent("/taskman/tman/tasks/tasklist");
					}
				});
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

	//start time log
	var tnn = document.getElementById('tn'), start = document
			.getElementById('start'), stop = document.getElementById('stop'), clear = document
			.getElementById('clear'), seconds = 0, minutes = 0, hours = 0, t;
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

	function startTime(el) {
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
								+ '<button type="button" onclick="showRemainingHoursModal(this)" class="btn-del btn btn-xs" id="stop-timer">'
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
									+ startTime + '/' + taskTitle + '/' + day
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

	function showRemainingHoursModal(el) {
		$(el).attr("data-toggle","modal");
		$(el).attr("data-target","#myModal");
		//data-dismiss="modal"
		
		$("#remaininghoursok").click(function(){
			var rem = $("#remaining_time").val();
			
			if(rem =="" || rem < 0){
				$("#warningmsg").text("");
				$("#warningmsg").addClass("alert alert-block alert-danger");
				$("#warningmsg").text("Please give positive number or zero.");
				
			
			}else{
				
				stopTimer(el, rem);
				$("#remaininghoursok").attr("data-dismiss","#modal");
			}
		});
	}

	function stopTimer(el, rem) {
		
		var id = $(el).closest('tr').find('td').find('.task_id').val();

		clearTimeout(t);
		$(".time-start").removeClass("hidden");
		$("#start-timer").remove();
		$("#stop-timer").remove();
		$("#runningtask").remove();

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
		$.ajax({
			type : 'GET',
			url : '/taskman/tman/tasks/timeLogUpdate/' + id + '/' + stopTime
					+ '/' + day + '/' + rem,
			success : function(response, status, xhr) {
				LoadMainContent("/taskman/tman/tasks/tasklist");
			}
		});

	}

	//refress call
	var runningTaskLogId = "${data.tasklog.taskId}";
	var startsqlTime = "${data.tasklog.startTime}";
	console.log(startsqlTime + "::::::::::t::::::::");

	if (runningTaskLogId != " ") {
		var html1 = ' <button type="button" class="btn-edit btn btn-xs" id="start-timer">'
				+ '<span id="tn">'
				+ '<time>'
				+ '${data.spentTime}'
				+ '</time>'
				+ '</span>'
				+ '</button>'
				+ '<button type="button" onclick="showRemainingHoursModal(this)" class="btn-del btn btn-xs" id="stop-timer">'
				+ '<span class="fa fa-stop"></span></button> <span id="runningtask" style="color:green; font-size:8pt">Running</span>';

		$('.task_id').each(function(index, element) {
			if ($(this).val() == runningTaskLogId) {
				$(this).closest('tr').find('.time-start').before(html1);
				timer();
				$(this).closest('tr').find('.time-start').addClass("hidden");
				//console.log(index);
			}
		});
	}
	console.log("${data.rem[0]}");
</script>
<style>
button#stop-timer {
	margin-left: 2px;
}
</style>