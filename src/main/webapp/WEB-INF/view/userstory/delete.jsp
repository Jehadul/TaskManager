<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Delete User Story</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>User Story</span></li>
				<li class="active"><span>User Story List</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
			<fieldset>
				<legend> User Story List&nbsp;&nbsp; </legend>
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
								<th>Story Title</th>
								<th>Priority</th>
								<th>Order</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="story" items="${data.userStoryLi}">
								<tr>
									<td><input type="hidden" name="id1" class="story_id"
										value="${story.getId()}" /></td>
									<td><c:out value="${story.getSuiteCode()}" /></td>
									<td><c:out value="${story.getModuleCode()}" /></td>
									<td><c:out value="${story.getPrivGrpName()}" /></td>
									<td><c:out value="${story.getDescription()}" /></td>
									<td><c:out value="${story.getUserStoryCode()}" /></td>
									<td><c:out value="${story.getUserStoryTitle()}" /></td>
									<td><c:out value="${story.getPriority()}" /></td>
									<td><c:out value="${story.getStoryOrder()}" /></td>
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
		<form method="POST" action="/taskman/userstory/story/destroy" class="ajax delete_form">
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
			$("input[name='id']").val($(el).closest("tr").find(".story_id").val());
			$(el).closest("tr").remove();
			$(".delete_form").submit();
		});
	};
</script>