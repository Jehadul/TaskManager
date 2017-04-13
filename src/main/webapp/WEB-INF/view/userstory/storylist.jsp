<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">


	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">User Story List</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>User Story</span></li>
				<li class="active"><span>User Story List</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
	
		<fieldset>
		
			<legend> User Story List &nbsp;&nbsp; </legend>
			
			<center>
				<a href="http://localhost:8080/?desturl=/taskman/userstory/story/create">Create New User Story</a>
				 | <a style="margin-right:15px" href="http://localhost:8080">Dashboard</a>
			</center>
			
			
							
				
			<div class="table-responsive">

					<table class="table table-striped table-hover" id="user-story">
					  <thead>
					    <tr>
					      	<th>Code</th>
							<th>Title</th>
							<th>Description</th>
							<th>Priority</th>
							<th>Business Value</th>
							<th>Size</th>
							<th data-orderable="false">Action</th>
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach var="story" items="${data.userStoryLi}">
					  
					    <tr>
					      <td>
					      		<input type="hidden" name="id1" class="story_id" value="${story.getId()}" />
					      		<input type="hidden" name="suite_name" value="${story.getSuiteName()}" />
					     		<input type="hidden" name="suite_code" value="${story.getSuiteCode()}" />
					    
					      		<input type="hidden" name="module_name" value="${story.getModuleName()}"/>
					     		<input type="hidden" name="module_code" value="${story.getModuleCode()}"/>
						  
						  		<input type="hidden" name="priv_grp_name" value="${story.getPrivGrpName()}"/>
					     		<input type="hidden" name="priv_grp_code" value="${story.getPrivGrpCode()}"/>
						 
						  		<input type="hidden" name="privilege_name" value="${story.getPrivilegeName()}"/>
					     		<input type="hidden" name="privilege_code" value="${story.getPrivilegeCode()}"/>
								<input type="hidden" name="story_status" class="story_status1" value="${story.getStoryStatus()}"/>
								 
								
						  		<c:out value="${story.getUserStoryCode()}" />
						  </td>
						  <td>
						  		<c:out value="${story.getUserStoryTitle()}"/>
						  </td>
						  <td>
						  		<c:out value="${story.getDescription()}"/>
						  </td>
						  <td>
						  		<c:out value="${story.getPriority()}"/>
					     		<input type="hidden" name="priority_code" value="${story.getPriorityCode()}"/>
					     		<input type="hidden" name="story_order" value="${story.getStoryOrder()}"/>
					     		<input type="hidden" name="acceptance_criteria" value="${story.getAcceptanceCriteria()}"/>
						  </td>
						  <td>
						  		<c:out value="${story.getBusinessValue()}"/>
						  </td>
						  <td>
						  		<c:out value="${story.getStoryStatus()}"/>
						  </td>
						  <%-- <td>
						  		<c:out value="${story.getStoryStatus()}"/>
						  </td> --%>
					      <td width="7%">
									<button type="button" class="btn-edit btn btn-xs">
										<span class="fa fa-edit"></span>
									</button>
									<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs">
										<span class="fa fa-trash"></span>
									</button>
						  </td>
					    </tr>
					    </c:forEach>
					  </tbody>
					</table>
			
			</div>
					
					
			&nbsp;
		</fieldset>
		
		
		<form method="POST" action="/taskman/userstory/story/destroy"
			class="ajax delete_form">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<cts:Hidden name="id" value="" />
			<input type="hidden" name="story_status" value=""/>
		</form>
		
		
		<div class="row">
			<div class="col-md-8">
				<cts:Button cssClass="back" spanClass="arrow-left" dAjax="true"
					dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=SA" />
				<button class="btn btn-refresh" type="button">
					<span class="fa fa-refresh"></span>
				</button>
				<button class="btn btn-help" type="button">
					<span class="fa fa-question"></span>
				</button>
			</div>
			<div class="col-md-4">
				<!-- <button id="submit" class="btn btn-save pull-right" type="submit">
					<span class="fa fa-save"></span> &nbsp;Save
				</button> -->
			</div>
		</div>
		
		
		
	</div>
</div>

<script>
	InitHandlers();


	InitDataTableWithoutSorting("#user-story");
	
	var delRow = function(el) {
		
		var storyStatus = $(el).closest("tr").find(".story_status1").val();
		if(storyStatus=="To Do"){
		console.log(storyStatus);
			swal({
				title : "Are you sure?",
				text : "Are you sure to delete this user story?",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#007AFF",
				confirmButtonText : "Yes, delete it!",
				closeOnConfirm : true
			}, function() {
				$("input[name='id']").val(
						$(el).closest("tr").find(".story_id").val());
				$("input[name='story_status']").val(
						$(el).closest("tr").find(".story_status1").val());
				$(el).closest("tr").remove();
				$(".delete_form").submit();
				
				$.ajax({
					type : 'GET',
					url : '/taskman/tman/sprint/sprintlist',
					success : function(response, status, xhr) {
						LoadMainContent("/taskman/userstory/story/storylist");
					}
				});
				
				
			});
		
		}else{
			swal({
				title : "Can't Delete This Story",
				text : "Story is in "+ storyStatus,
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

		var taskId = currentRow.find(".story_id").val();

		LoadMainContent('/taskman/userstory/story/edit/' + taskId);
	});
	
	function InitDataTableWithoutSorting(table){
		var oTable = $(table).dataTable({
			"oLanguage" : {
				"sSearch" : "",
				"oPaginate" : {
					"sPrevious" : "<span class='fa fa-chevron-left'></span>",
					"sNext" : "<span class='fa fa-chevron-right'></span>"
				}
			},
			"ordering": false,
			"aLengthMenu" : [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"] // change per page values here
			],
			// set the initial value
			"iDisplayLength" : 20,
		});
		
	}
</script>