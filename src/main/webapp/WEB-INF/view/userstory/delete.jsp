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
                     <legend>
                         User Story List &nbsp;&nbsp;      
                     </legend><br>
                         <div class="col-md-12">
                             <div class="table-responsive">
                                 <table class="data-grid width-full" id="user-story">  
                                     <thead>
                                          <tr>
                                            <th class="align-center width-140">Suite</th>
											<th class="align-center width-140">Module</th>
											<th class="align-center">Privilege Group</th>
											<th class="align-center width-100">Privilege NAme</th>
											<th class="align-center width-100">Description</th>
											<th class="align-center width-80">Story Code</th>
											<th class="align-center width-80">Story Title</th>
											<th class="align-center width-60">Priority</th>
											<th class="align-center" colspan="2">Action</th>
                                         </tr>
                                     </thead>
                                     <tbody>
                                     	<c:forEach var="story" items="${data.userStoryLi}">
                                             <tr>
		                                            <td>
		                                            	<cts:Hidden name="id1" value="${story.getId()}" cssClass="story_id view"/>
														<cts:TextBox name="suite_name" value="${story.getSuiteName()}" cssClass="view"/>
														<cts:Hidden name="suite_code" value="${story.getSuiteCode()}" cssClass="view"/>
													</td>
													<td>
														<cts:TextBox name="module_name" value="${story.getModuleName()}" cssClass="view"/>
														<cts:Hidden name="module_code" value="${story.getModuleCode()}" cssClass="view"/>
													</td>
													
													<td>
														<cts:TextBox name="priv_grp_name" value="${story.getPrivGrpName()}" cssClass="view"/>
														<cts:Hidden name="priv_grp_code" value="${story.getPrivGrpCode()}" cssClass="view"/>
													</td>
													<td>
														<cts:TextBox name="privilege_name" value="${story.getPrivilegeName()}" cssClass="view"/>
														<cts:Hidden name="privilege_code" value="${story.getPrivilegeCode()}" cssClass="view"/>
													</td>
													<td>
														<cts:TextBox name="description" value="${story.getDescription()}" cssClass="view"/>
													</td>
													<td><cts:TextBox name="user_story_code" value="${story.getUserStoryCode()}" cssClass="view"/></td>
													<td><cts:TextBox name="user_story_title" value="${story.getUserStoryTitle()}" cssClass="view"/></td>
													<td>
														<cts:TextBox name="priority" value="${story.getPriority()}" cssClass="view"/>
														<cts:Hidden name="priority_code" value="${story.getPriorityCode()}" cssClass="view"/>
														<cts:Hidden name="story_order" value="${story.getStoryOrder()}" cssClass="view"/>
														<cts:Hidden name="size" value="${story.getSize()}" cssClass="view"/>
														<cts:Hidden name="acceptance_criteria" value="${story.getAcceptanceCriteria()}" cssClass="view"/>
														<cts:Hidden name="business_value" value="${story.getBusinessValue()}" cssClass="view"/>
													</td>
													<td>
														<button type="button" onclick="delRow(this);" class="btn-del btn btn-xs">
																<span class="fa fa-trash"></span>
														</button>
													</td>
													<td>
														<button type="button" class="btn-edit btn btn-xs">
																<span class="fa fa-edit"></span>
														</button>
													</td>
                                             
                                             </tr>   
                                             </c:forEach>         
                                     </tbody>
                                 </table>
                             </div>
                         </div>&nbsp;                    
                    </fieldset>
		<form method="POST" action="/taskman/userstory/story/destroy" class="ajax delete_form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<cts:Hidden name="id" value=""/>
		</form>
		<div class="row">
			<div class="col-md-8">
				<cts:Button cssClass="back" spanClass="arrow-left" dAjax="true" dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=SA" />
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