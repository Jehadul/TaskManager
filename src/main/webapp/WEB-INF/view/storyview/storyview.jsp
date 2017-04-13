 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
   <section id="page-title" class="padding-top-10 padding-bottom-10">
      <div class="row">
         <div class="col-sm-8">
            <h1 class="mainTitle">Sprint Board Story View</h1>
         </div>
         <ol class="breadcrumb padding-top-20">
            <li><span>Sprint Board</span></li>
            <li class="active"><span>Sprint Board</span></li>
         </ol>
      </div>
   </section>
   <center>
	    <a style="margin-right:15px" href="http://localhost:8080">Dashboard</a>
	</center>
   <!-- start: USER PROFILE -->
   <div class="container-fluid  bg-white">
   		
      <cts:AjaxForm action="/taskman/sprintboard/ui/manageSprintselection" dataHandler="showMessage">
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  />
         <div>
            <div class="alert alert-block alert-danger hidden">
               Please check the fields marked with 
               <span class="text-red fa fa-close"></span>.
            </div>
            <!-- <div class="denotes-required">denotes a required field.</div> -->
            <div class="row">
               <div class="col-md-6">
                  <div class="form-group">
                     <cts:Label name="Sprint Name" labelFor="sprint_code"/>
                     <cts:Select list="${data.sprintCodes}" name="sprint_code" value="${data.sprintCode}" cssClass="required" emptyValue="--SELECT--"/>
                     <input name="sprint_name" type="hidden" value=""> 
                  </div>
               </div>
            </div>
            <div class="row">
	            <div class="col-md-6">
	                  <div class="form-group">
	                     <cts:Label name="Sprint Goal" labelFor="sprint_goal"/> : <span id="goal"></span>
	                  </div>
	            </div>
	            <div class="col-md-6">
	                  <div class="form-group">
	                     <cts:Label name="Team" labelFor="sprint_team"/> : <span id="team"></span>
	                  </div>
	            </div>
            </div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Story</th>
						<th>To Do</th>
						<th>In Progress</th>
						<th>To Be Reviewed</th>
						<th>QA</th>
						<th>Done</th>
					</tr>
				</thead>
				<tbody id="story_list">
					
				</tbody>
			
			</table>
			
			
			
         </div>
         <div class="row margin-top-10">
            <div class="col-md-8">
               <cts:Button dAjax="true" dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=PR" cssClass="back" spanClass="arrow-left"/>
               <cts:Button cssClass="refresh" spanClass="refresh"/>
               <cts:Button cssClass="help" spanClass="question"/>
            </div>
            <div class="col-md-4">
               <cts:Submit cssClass="save pull-right" name="Save" spanClass="save"/>
            </div>
         </div>
      </cts:AjaxForm>
   </div>
</div>
<script>
	InitHandlers();

	var mainRow = '';

	$("input[name='sprint_name']")
			.val($("#sprint_code option:selected").text());

	

	$("#sprint_code").on('change',function() {
						mainRow = '';
						var newSprintCode = $("#sprint_code").val();
						if(newSprintCode != -1){
							//console.log(newSprintCode);
						
						
							
							$.ajax({
									url : "/taskman/sprintboard/storyview/loadsprintmanager?sprint_code="
											+ newSprintCode,
									success : function(data) {
										//console.log(data);
										
										loadSprint(newSprintCode);
										
										$.each(data, function(i, item){
											//alert(item.sprintStoryName);
											var rowId = 'row_'+i
											mainRow += '<tr class="mainrow" id="'+ rowId +'">';
											
											mainRow += '<td class="story">';
											if(item.storyStatus == 'Story'){
												mainRow += item.sprintStoryName;
											}
											mainRow += '</td>';
											
											mainRow += '<td class="qa">';
											if(item.storyStatus == 'QA'){
												mainRow += item.sprintStoryName;
											}
											mainRow += '</td>';
											
											mainRow += '<td class="done">';
											if(item.storyStatus == 'Done'){
												mainRow += item.sprintStoryName;
											}
											mainRow += '</td>';
											
											//mainRow += '<div class="col-md-2 story">'+ item.sprintStoryName +'</div>';
											$.ajax({
												url : "/taskman/sprintboard/storyview/loadtask?story_code="
														+ item.sprintStoryCode,
													success : function(taskData) {
														//console.log(taskData);
														var tempToDo = '<td class="todo"><ul>';
														var tempProgress = '<td class="porgress"><ul>';
														var tempReview = '<td class="col-md-2 review"><ul>';
														$.each(taskData, function(j, taskItem){
															//alert(taskItem.id+ " "+taskItem.storyCode + " " + taskItem.taskStatus);
															
															if(taskItem.taskStatus == 'To Do'){
																tempToDo += '<li>'+ taskItem.taskTitle+'</li>';
															}else if(taskItem.taskStatus == 'In Progress'){
																tempProgress += '<li>'+taskItem.taskTitle+'</li>';
															}else if(taskItem.taskStatus == 'To Be Review'){
																tempReview += '<li>'+taskItem.taskTitle+'</li>';
															}

														});
														tempReview += '</ul></td>';
														tempProgress += '</ul></td>';
														tempToDo += '</ul></td>';
														//console.log(tempToDo);
														//console.log(tempProgress);
														//console.log(tempReview);
														//mainRow += tempToDo + tempProgress +tempReview;
														$("#"+rowId+" > .qa").before(tempToDo + tempProgress +tempReview);
														//console.log("#"+rowId);
													}
														
											});
											

											
											
											mainRow += '</tr>';
											
											
											$('#story_list').html(mainRow);
											
											
										}); // end inner each loop
										
										
									}
							});
						}else{
							mainRow = '';
							$('#story_list').html('');
							$('#goal').html('');
							$('#team').html('');
						}

	});
	
	var loadSprint = function(newSprintCode){
		$.ajax({
			url : "/taskman/sprintboard/storyview/loadsprint?sprint_code="
					+ newSprintCode,
			success : function(sprint) {
					$('#goal').html(sprint.sprintGoal);
					$('#team').html(sprint.teamName);
				}
		});
	};


</script>
<style>
.table-scroll {
	overflow: auto;
	height: 350px;
}


</style>