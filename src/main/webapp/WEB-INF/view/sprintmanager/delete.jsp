<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Delete Sprint</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Taskman</span></li>
				<li class="active"><span>Sprint List</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
			<fieldset>
				<legend> Task List&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover"
						id="sprint_search_result">
						<thead>
							<tr>
								<th></th>
								<th>Suite Name</th>
								<th>Module Name</th>
								<th>Privilege Name</th>
								<th>Sprint Name</th>
								<th>Sprint Number</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sprint" items="${data.sprintManagerList}">
								<tr>
									<td><input type="hidden" name="id1" class="sprint_id"
										value="${sprint.getId()}" /></td>
									<td><c:out value="${sprint.getSuiteName()}" /></td>
									<td><c:out value="${sprint.getModuleName()}" /></td>
									<td><c:out value="${sprint.getPrivilegeName()}" /></td>
									<td><c:out value="${sprint.getSprintName()}" /></td>
									<td><c:out value="${sprint.getSprintNumber()}" /></td>
									<td>
									<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs">
											<span class="fa fa-trash"></span>
									</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>
		<form method="POST" action="/taskman/tman/sprint/destroy" class="ajax delete_form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<cts:Hidden name="id" value=""/>
		</form>
	</div>
</div>
<script>
	InitHandlers();
	
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
			$("input[name='id']").val($(el).closest("tr").find(".sprint_id").val());
			$(el).closest("tr").remove();
			$(".delete_form").submit();
		});
	};
</script>