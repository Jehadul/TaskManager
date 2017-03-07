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
		<cts:AjaxForm dataHandler="" action="" cssClass="list_form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
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
							<c:forEach var="task" items="${data.taskli}">
								<tr>
									<td><input type="hidden" name="id" class="task_id" value="${task.getId()}" /></td>
									<td><c:out value="${task.getTaskTitle()}" /></td>
									<td><c:out value="${task.getEstimatedTime()}" /></td>
									<td><c:out value="${task.getSpentTime()}" /></td>
									<td><c:out value="${task.getRemainingTime()}" /></td>
									<td><c:out value="${task.getAsignee()}" /></td>
									<td>
										<button type="button" class="btn-edit btn btn-xs">
											<span class="fa fa-edit"></span>
										</button>
										
										<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs">
											<span class="fa fa-trash"></span>
										</button>
										
									<input type="hidden" name="id[]" class="task_id" value="${task.getId()}" />	
									<input type="hidden" name="task_title[]" class="task_title" value="${task.getTaskTitle()}" />
									<input type="hidden" name="estimated_time[]" class="estimated_time" value="${task.getEstimatedTime()}" />
									<input type="hidden" name="spent_time[]" class="spent_time" value="${task.getEstimatedTime()}" />
									<input type="hidden" name="remaining_time[]" class="remaining_time" value="${task.getEstimatedTime()}" />
									<input type="hidden" name="assignee[]" class="assignee" value="${task.getAsignee()}" />
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
			$(el).closest("tr").remove();
			$(".delete_form").submit();
		});
	};
	

	$('.btn-edit').on("click",function(){
		LoadMainContent('/taskman/tman/tasks/editTasklist/' + $(".task_id").val());			
	});
	

</script>