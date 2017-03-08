<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Delete Task</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Taskman</span></li>
				<li class="active"><span>Task List</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<%-- <cts:AjaxForm dataHandler="" action="/taskman/tman/tasks/destroy" cssClass="ajax delete_form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
			<fieldset>
				<legend> Task List&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover"
						id="task_search_result">
						<thead>
							<tr>
								<th></th>
								<th>Suite Code</th>
								<th>Module Code</th>
								<th>Privilege Group</th>
								<th>Description</th>
								<th>Story Code</th>
								<th>Task Title</th>
								<th>Estimated Time</th>
								<th>Assignee</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${data.taskli}">
								<tr>
									<td><input type="hidden" name="id1" class="task_id"
										value="${task.getId()}" /></td>
									<td><c:out value="${task.getSuiteCode()}" /></td>
									<td><c:out value="${task.getModuleCode()}" /></td>
									<td><c:out value="${task.getPrivGrpName()}" /></td>
									<td><c:out value="${task.getDescription()}" /></td>
									<td><c:out value="${task.getStoryCode()}" /></td>
									<td><c:out value="${task.getTaskTitle()}" /></td>
									<td><c:out value="${task.getEstimatedTime()}" /></td>
									<td><c:out value="${task.getAsignee()}" /></td>
									<td>
									<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs">
											<span class="fa fa-trash"></span>
									</button>
									<%-- <input type="hidden" name="id[0]" class="task_id" value="${task.getId()}" />	
									<input type="hidden" name="suite_code[]" class="suite_code" value="${task.getSuiteCode()}"/>
									<input type="hidden" name="module_code[]" class="module_code" value="${task.getModuleCode()}" />
									<input type="hidden" name="priv_grp_code[]" class="priv_grp_code" value="${task.getPrivGrpName()}"/>
									<input type="hidden" name="description[]" class="description" value="${task.getDescription()}" />
									<input type="hidden" name="story_code[]" class="story_code" value="${task.getStoryCode()}" />
									<input type="hidden" name="task_title[]" class="task_title" value="${task.getTaskTitle()}" />
									<input type="hidden" name="estimated_time[]" class="estimated_time" value="${task.getEstimatedTime()}" />
									<input type="hidden" name="assignee[]" class="assignee" value="${task.getAsignee()}" /> --%>
									
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>
		<%-- </cts:AjaxForm> --%>
		<form method="POST" action="/taskman/tman/tasks/destroy" class="ajax delete_form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<cts:Hidden name="id" value=""/>
		</form>
	</div>
</div>
<script>
	InitHandlers();
	
	

	/* $(".btn-del").on("click", function() {
		swal({
			title : "Are you sure?",
			text : "Are you sure to delete this task?",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#007AFF",
			confirmButtonText : "Yes, delete it!",
			closeOnConfirm : true
		}, function() {
			$(this).closest("tr").remove();
			//$(".delete_form").submit();
		});
	}); */

/* 	function showMessage(data) {
		if (data.outcome == 'success') {
			isDirty = false;
			ShowSuccessMsg('Tasks Deleted', data.msg);

			LoadMainContent('/taskman/tman/tasks/destroy/' + data.id);
		} else {
			ShowErrorMsg('Tasks was not deleted', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	} */
	
	var delRow = function(el){
		swal({
			title: "Are you sure?",
			text: "Are you sure to delete this privilege?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#007AFF",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: true
		}, function() {
			$("input[name='id']").val($(el).closest("tr").find(".task_id").val());
			$(el).closest("tr").remove();
			$(".delete_form").submit();
		});
	};
</script>