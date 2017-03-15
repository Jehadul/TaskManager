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
								<th>Suite</th>
								<th></th>
								<th>Module</th>
								<th></th>
								<th>Privilege Group</th>
								<th></th>
								<th>Description</th>
								<th>Story Code</th>
								<th>Story Title</th>
								<th>Priority</th>
								<th>Order</th>
								<th></th>
								<th></th>
								<th></th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="story" items="${data.userStoryLi}">
								<tr>
									<td><cts:Hidden name="id1" value="${story.getId()}" cssClass="story_id view"/></td>
									<td><cts:TextBox name="suite_name" value="${story.getSuiteName()}" cssClass="view"/></td>
									<td><cts:Hidden name="suite_code" value="${story.getSuiteCode()}" cssClass="view"/></td>
									<td><cts:TextBox name="module_name" value="${story.getModuleName()}" cssClass="view"/></td>
									<td><cts:Hidden name="module_code" value="${story.getModuleCode()}" cssClass="view"/></td>
									<td><cts:TextBox name="priv_grp_name" value="${story.getPrivGrpName()}" cssClass="view"/></td>
									<td><cts:Hidden name="priv_grp_code" value="${story.getPrivGrpCode()}" cssClass="view"/></td>
									<td><cts:TextBox name="description" value="${story.getDescription()}" cssClass="view"/></td>
									<td><cts:TextBox name="user_story_code" value="${story.getUserStoryCode()}" cssClass="view"/></td>
									<td><cts:TextBox name="user_story_title" value="${story.getUserStoryTitle()}" cssClass="view"/></td>
									<td><cts:TextBox name="priority" value="${story.getPriority()}" cssClass="view"/></td>
									<td><cts:Hidden name="priority_code" value="${story.getPriorityCode()}" cssClass="view"/></td>
									<td><cts:TextBox name="story_order" value="${story.getStoryOrder()}" cssClass="view"/></td>
									<td><cts:Hidden name="size" value="${story.getSize()}" cssClass="view"/></td>
									<td><cts:Hidden name="acceptance_criteria" value="${story.getAcceptanceCriteria()}" cssClass="view"/></td>
									<td><cts:Hidden name="business_value" value="${story.getBusinessValue()}" cssClass="view"/></td>
									<td>
									<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs">
											<span class="fa fa-trash"></span>
									</button>
									<button type="button" class="btn-edit btn btn-xs">
											<span class="fa fa-edit"></span>
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
	
	$('.btn-edit').on("click",function(){/* console.log($(".task_id").val()) */
		 var currentRow = $(this).closest("tr");
		 currentRow.addClass("current-row");
		 
		 var taskId = currentRow.find(".story_id").val();
		 
		LoadMainContent('/taskman/userstory/story/edit/' + taskId);			
	});
</script>