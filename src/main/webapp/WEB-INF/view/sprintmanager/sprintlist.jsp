<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Sprint List</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Sprint</span></li>
				<li class="active"><span>Sprint List</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">

			<fieldset>
				<legend> Sprint List&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover"
						id="sprint_sort_result">
						<thead>
							<tr>
								<th style="display:none"></th>
								<th>Suite Name</th>
								<th>Module Name</th>
								<th>Privilege Name</th>
								<th>Sprint Name</th>
								<th>Sprint Number</th>
								<th>Story Title</th>
								<th data-orderable="false">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sprint" items="${data.sprintlist}">
								<tr>
									<td style="display:none"><input type="hidden" name="id1" class="sprint_id" value="${sprint.getId()}" /></td>
									<td><c:out value="${sprint.getSuiteName()}" /></td>
									<td><c:out value="${sprint.getModuleName()}" /></td>
									<td><c:out value="${sprint.getPrivilegeName()}" /></td>
									<td><c:out value="${sprint.getSprintName()}" /></td>
									<td><c:out value="${sprint.getSprintNumber()}" /></td>
									<td><c:out value="${sprint.getSprintStories()}" /></td>
									<td>
										<button type="button" onclick="editRow(this);" class="btn-edit btn btn-xs">
											<span class="fa fa-edit"></span>
										</button>
										
										<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs">
											<span class="fa fa-trash"></span>
										</button>
			
									<input type="hidden" name="id[]" class="sprint_id1" value="${sprint.getId()}" />	
									<input type="hidden" name="suite_Name[]" class="suite_Name" value="${sprint.getSuiteName()}" />
									<input type="hidden" name="module_Name[]" class="module_Name" value="${sprint.getModuleName()}" />
									<input type="hidden" name="privilege_Name[]" class="privilege_Name" value="${sprint.getPrivilegeName()}" />
									<input type="hidden" name="sprint_Name[]" class="sprint_Name" value="${sprint.getSprintName()}" />
									<input type="hidden" name="sprint_Number[]" class="sprint_Number" value="${sprint.getSprintNumber()}" />
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
	
	InitDataTable("#sprint_sort_result"); 
	
	
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

			$("input[name='id']").val($(el).closest("tr").find(".sprint_id").val());
			$(el).closest("tr").remove();
			$(".delete_form").submit();
			
			$.ajax({
				type : 'GET',
				url : '/taskman/tman/sprint/sprintlist',
				success : function(response, status, xhr) {
					LoadMainContent("/taskman/tman/sprint/sprintlist");
				}
			});
			
		});
	};
	
	
	$('.btn-edit').on("click", function() {
		var currentRow = $(this).closest("tr");
		currentRow.addClass("current-row");

		var sprintId = currentRow.find(".sprint_id").val();

		LoadMainContent('/taskman/tman/sprint/edit/' + sprintId);
	});
	
	

	

</script>