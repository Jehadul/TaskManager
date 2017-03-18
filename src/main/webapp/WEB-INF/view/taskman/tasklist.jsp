<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Task List</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Taskman</span></li>
				<li class="active"><span>Task List</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">

		<cts:AjaxForm dataHandler="" action="/taskman/tman/tasks/destroy"
			cssClass="ajax list-form">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />


			<fieldset>
				<legend> Task List&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover"
						id="task_sort_result">
						<thead>
							<tr>
								<th></th>
								<th>Task Title</th>
								<th>Estimated Time</th>
								<th>Spent Time</th>
								<th>Remaining Time</th>
								<th>Assignee</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${data.tasklist}">
								<tr>
									<td><input type="hidden" name="id" class="task_id"
										value="${task.getId()}" /></td>
									<td><c:out value="${task.getTaskTitle()}" /></td>
									<td><c:out value="${task.getEstimatedTime()}" /></td>
									<td><c:out value="${task.getSpentTime()}" /></td>
									<td><c:out value="${task.getRemainingTime()}" /></td>
									<td><c:out value="${task.getAsignee()}" /></td>
									<td>
										<button type="button" onclick="editRow(this);"
											class="btn-edit btn btn-xs">
											<span class="fa fa-edit"></span>
										</button>

										<button type="button" onclick="delRow(this);"
											class="btn-del btn btn-xs">
											<span class="fa fa-trash"></span>
										</button>

										<button type="button" onclick="startTimer(this);"
											class="btn-timer btn btn-xs time-start">
											<span class="fa fa-play"></span>
										</button> <!-- <button type="button" onclick="upRow(this);" class="btn-up btn btn-xs"><span class="fa fa-arrow-up"></span></button> 
										<button type="button" onclick="downRow(this);" class="btn-down btn btn-xs"><span class="fa fa-arrow-down"></span></button> -->


										<input type="hidden" name="id[]" class="task_id"
										value="${task.getId()}" /> <input type="hidden"
										name="task_title[]" class="task_title"
										value="${task.getTaskTitle()}" /> <input type="hidden"
										name="estimated_time[]" class="estimated_time"
										value="${task.getEstimatedTime()}" /> <input type="hidden"
										name="spent_time[]" class="spent_time"
										value="${task.getSpentTime()}" /> <input type="hidden"
										name="remaining_time[]" class="remaining_time"
										value="${task.getRemainingTime()}" /> <input type="hidden"
										name="assignee[]" class="assignee"
										value="${task.getAsignee()}" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>
		</cts:AjaxForm>

	</div>
</div>

<script>
	InitHandlers();

	InitDataTable("#task_sort_result");
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
			$(".list-form").submit();

		});
	};

	$('.btn-edit').on("click", function() {/* console.log($(".task_id").val()) */
		var currentRow = $(this).closest("tr");
		currentRow.addClass("current-row");

		var taskId = currentRow.find(".task_id").val();

		LoadMainContent('/taskman/tman/tasks/edit/' + taskId);
	});

	//refress call
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