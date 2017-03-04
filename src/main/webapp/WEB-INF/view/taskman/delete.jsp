<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create Task</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Delete Task</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/tasks/delete" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<fieldset>
			 	<legend>
			 		Head of Branch&nbsp;&nbsp;
			 	</legend>
			 	<div class="table-responsive"> 
			 		<table class="table table-striped table-hover" id="department_search_result">
			 			<thead>
			 				<tr>
			 					<th>Product Name</th>
			 					<th>Suite Name</th>
			 					<th>Module Name</th>
			 					<th>Description</th>
			 					<th>Story Code</th>
			 					<th>Task Title</th>
			 					<th>Estimated Time</th>
			 					<th>Assignee</th>
			 				</tr>
			 			</thead>
			 			<tbody>
			 				<c:forEach var="task" items="${data.taskli}">
			 					<tr>
			 						<td><c:out value="${task.getSuiteCode()}"/></td>
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
	$('#suite_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		LoadMainContent("/taskman/tman/tasks/create/?suite_code=" + newSuiteCode);
	
	});
	
	/* $('#module_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		LoadMainContent("/taskman/tman/tasks/create/?suite_code=" + newSuiteCode + "&" + "module_code=" + newModuleCode);
	
	}); */
	 
	function showMessage(data) {
		if (data.outcome == 'success') {
			ShowSuccessMsg('Program created', data.message);
			isDirty = false;
			LoadMainContent('/taskman/tman/tasks/show/' + data.id );
		} else {
			ShowErrorMsg('Program was not created', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}
	
</script>