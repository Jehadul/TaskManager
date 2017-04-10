 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
   <section id="page-title" class="padding-top-10 padding-bottom-10">
      <div class="row">
         <div class="col-sm-8">
            <h1 class="mainTitle">Sprint Board</h1>
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
                     <cts:Select list="${data.sprintCodes}" name="sprint_code" value="${data.sprintCode}" cssClass="required"/>
                     <input name="sprint_name" type="hidden" value=""> 
                  </div>
               </div>
            </div>
            <div class="row">
	            <div class="col-md-6">
	                  <div class="form-group">
	                     <cts:Label name="Sprint Goal" labelFor="sprint_goal"/> : <p id="sprint_goal"></p>
	                     <!--<cts:TextBox name="sprint_goal" value="Hello Goal" readonly="readonly"/> -->
	                  </div>
	            </div>
            </div>
			
			<div id="story_list">
			
			</div>
			
			
			
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

	var code;
	var name;

	$("input[name='sprint_name']")
			.val($("#sprint_code option:selected").text());


	$("#sprint_code").on('change',function() {
						var newSprintCode = $("#sprint_code").val();
							$.ajax({
									url : "/taskman/sprintboard/storyview/loadsprintmanager?sprint_code="
											+ newSprintCode,
									success : function(data) {
										console.log(data);
										
										var mainRow = '';
										
										$.each(data, function(i, item){
											//alert(item.sprintStoryName);
											var rowId = 'row_'+i
											mainRow += '<div class="row" id="'+ rowId +'"><div class="col-md-3">'+ item.sprintStoryName +'</div>';
											$.ajax({
												url : "/taskman/sprintboard/storyview/loadtask?story_code="
														+ item.sprintStoryCode,
													success : function(taskData) {
														console.log(taskData);
														var tempToDo = '<div class="col-md-3 todo"><ul>';
														var tempProgress = '<div class="col-md-3 porgress"><ul>';
														var tempReview = '<div class="col-md-3 review"><ul>';
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
														tempReview += '</ul></div>';
														tempProgress += '</ul></div>';
														tempToDo += '</ul></div>';
														console.log(tempToDo);
														console.log(tempProgress);
														console.log(tempReview);
														//mainRow += tempToDo + tempProgress +tempReview;
														$("#"+rowId).append(tempToDo + tempProgress +tempReview);
														console.log("#"+rowId);
													}
														
											});
											
											mainRow += '</div>';
											
											
											$('#story_list').html(mainRow);
											
											
										}); // end inner each loop
										
										
									}
							});

	});

	//FOR STORY BOARD TABLE
	/*
	function addRowStory(objType) {

		var html = "";
		for (var i = 0; i < objType.length; i++) {
			var code = objType[i].sprintStoryCode;
			var name = objType[i].sprintStoryName;
			var sprintCode = objType[i].sprintCode;
			var sprintId = objType[i].sprintId;

			html += ""
					+ '<tr>'
					+ '<td><input type="text" class="sprint-story-code width-50" readonly value="'+ code  + '"/></td>'
					+ '<td class="width-300"><input type="text" class="sprint-story-name" readonly value="'+ name  + '" /></td>'
					+ '<td>'
					+ '<button type="button" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
					+ '</td>'
					+ '<input type="hidden" class="sprint-Code" readonly value="'+ sprintCode  + '" /></td>'
					+ '<input type="hidden" class="sprint-id" readonly value="'+ sprintId  + '" /></td>'
					+ '</tr>';

		}
		InitHandlers();
		$("#sprintmanagerdetail tbody").html(html);

		if (objType.length > 2) {
			$(".table-responsive").addClass("table-scroll");
		}
	}

	//FOR TASK BOARD TABLE
	function addRowTasks(objType2) {
		var html = "";
		for (var i = 0; i < objType2.length; i++) {
			for (var j = 0; j < objType2[i].length; j++) {
				var id = objType2[i][j].id;
				var code = objType2[i][j].taskCode;
				var name = objType2[i][j].taskTitle;
				console.log(id);
				html += ""
						+ '<tr>'
						+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
						+ '<td><input type="text" class="task-code width-50"  value="'+ code  + '"/></td>'
						+ '<td class="width-300"><input type="text" class="task-name"  value="'+ name  + '" /></td>'
						+ '<td>'
						+ '<button type="button" onclick="toDoToInProgress(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
						+ '</td>' + '</tr>';
			}
		}

		InitHandlers();
		$("#taskAll tbody").html(html);
	}

	//in progress
	function addInProgress(inProgressTask) {
		var html = "";
		for (var i = 0; i < inProgressTask.length; i++) {
			for (var j = 0; j < inProgressTask[i].length; j++) {
				var id = inProgressTask[i][j].id;
				var code = inProgressTask[i][j].taskCode;
				var name = inProgressTask[i][j].taskTitle;
				html += ""
						+ '<tr>'
						+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
						+ '<td><input type="text" class="task-code width-50"  value="'+ code  + '"/></td>'
						+ '<td class="width-300"><input type="text" class="task-name"  value="'+ name  + '" /></td>'
						+ '<td>'
						+ '<button type="button" onclick="inProgressToReview(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
						+ '<button type="button" onclick="inProgressToDoTask(this);" class="btn btn-xs"><span class="fa fa-arrow-left trash">'
						+ '</td>' + '</tr>';
			}
		}

		InitHandlers();
		$("#inProgressTask tbody").html(html);
	}

	//For Review Board Table
	function addReviewAllTask(toReviewAllTask) {
		var html = "";
		for (var i = 0; i < toReviewAllTask.length; i++) {
			for (var j = 0; j < toReviewAllTask[i].length; j++) {
				var id = toReviewAllTask[i][j].id;
				var code = toReviewAllTask[i][j].taskCode;
				var name = toReviewAllTask[i][j].taskTitle;
				html += ""
						+ '<tr>'
						+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
						+ '<td><input type="text" class="task-code width-50"  value="'+ code  + '"/></td>'
						+ '<td class="width-300"><input type="text" class="task-name"  value="'+ name  + '" /></td>'
						+ '<td>'
						+ '<button type="button" onclick="fromBeReviewToInProgress(this);" class="btn btn-xs"><span class="fa fa-arrow-left trash">'
						+ '</td>' + '</tr>';
			}
		}

		InitHandlers();
		$("#inReviewTask tbody").html(html);
	}

	//FOR PROGRESS BOARD AGAINST OF RIGHT ARROW

	function toDoToInProgress(el) {
		var count1 = ($("#inProgressTask tr ").length) - 1;
		count1 = count1 + 1;
		var qaval = $(el).closest("tr");
		var id = qaval.find(".id").val();
		var code = qaval.find(".task-code").val();
		var name = qaval.find(".task-name").val();
				$.ajax({
					type : 'GET',
					url : '/taskman/sprintboard/ui/tstatus/' + id
							+ '/In Progress',
					success : function(data, status, xhr) {
						console.log(status);
						if (status == "success") {
							html = ""
									+ '<tr>'
									+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
									+ '<td><input name="task-code[]" type="text" class="task-code width-50" value="'+ code  + '"/></td>'
									+ '<td class="width-300"><input name="task-name[]" type="text" class="task-name" value="'+ name  + '" /></td>'
									+ '<td>'
									+ '<button type="button" onclick="inProgressToReview(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
									+ '<button type="button" onclick="inProgressToDoTask(this);" class="btn btn-xs"><span class="fa fa-arrow-left trash">'
									+ '</td>' + '</tr>';
							InitHandlers();
							$("#inProgressTask tbody").append(html);

							$(el).closest("tr").remove();
						}
					}
				});

	}
	
	function inProgressToReview(el) {
		var count1 = ($("#inReviewTask tr ").length) - 1;
		count1 = count1 + 1;
		var qaval = $(el).closest("tr");
		var id = qaval.find(".id").val();
		var code = qaval.find(".task-code").val();
		var name = qaval.find(".task-name").val();
				$.ajax({
					type : 'GET',
					url : '/taskman/sprintboard/ui/tstatus/' + id+ '/To Be Review',
					success : function(data, status, xhr) {
						console.log(status);
						if (status == "success") {
							html = ""
									+ '<tr>'
									+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
									+ '<td><input name="task-code[]" type="text" class="task-code width-50"  value="'+ code  + '"/></td>'
									+ '<td class="width-300"><input name="task-name[]" type="text" class="task-name" value="'+ name  + '" /></td>'
									+ '<td>'
									+ '<button type="button" onclick="fromBeReviewToInProgress(this);" class="btn btn-xs"><span class="fa fa-arrow-left trash">'
									+ '</td>' + '</tr>';
							InitHandlers();
							$("#inReviewTask tbody").append(html);

							$(el).closest("tr").remove();
						}
					}
				});

	}
	function fromBeReviewToInProgress(el) {
		var count1 = ($("#inProgressTask tr ").length) - 1;
		count1 = count1 + 1;
		var qaval = $(el).closest("tr");
		var id = qaval.find(".id").val();
		var code = qaval.find(".task-code").val();
		var name = qaval.find(".task-name").val();
				$.ajax({
					type : 'GET',
					url : '/taskman/sprintboard/ui/tstatus/' + id
							+ '/In Progress',
					success : function(data, status, xhr) {
						console.log(status);
						if (status == "success") {
							html = ""
									+ '<tr>'
									+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
									+ '<td><input name="task-code[]" type="text" class="task-code width-50" value="'+ code  + '"/></td>'
									+ '<td class="width-300"><input name="task-name[]" type="text" class="task-name" value="'+ name  + '" /></td>'
									+ '<td>'
									+ '<button type="button" onclick="inProgressToReview(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
									+ '<button type="button" onclick="inProgressToDoTask(this);" class="btn btn-xs"><span class="fa fa-arrow-left trash">'
									+ '</td>' + '</tr>';
							InitHandlers();
							$("#inProgressTask tbody").append(html);

							$(el).closest("tr").remove();
						}
					}
				});
	} 
	
	
	function inProgressToDoTask(el) {
		var count1 = ($("#taskAll tr ").length) - 1;
		count1 = count1 + 1;
		var qaval = $(el).closest("tr");
		var id = qaval.find(".id").val();
		var code = qaval.find(".task-code").val();
		var name = qaval.find(".task-name").val();
				$.ajax({
					type : 'GET',
					url : '/taskman/sprintboard/ui/tstatus/' + id
							+ '/To Do',
					success : function(data, status, xhr) {
						console.log(status);
						if (status == "success") {
							html = ""
									+ '<tr>'
									+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
									+ '<td><input name="task-code[]" type="text" class="task-code width-50" value="'+ code  + '"/></td>'
									+ '<td class="width-300"><input name="task-name[]" type="text" class="task-name" value="'+ name  + '" /></td>'
									+ '<td>'
									+ '<button type="button" onclick="toDoToInProgress(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
									+ '</td>' + '</tr>';
							InitHandlers();
							$("#taskAll tbody").append(html);

							$(el).closest("tr").remove();
						}
					}
				});
	}
	
	 */

	//$("#taskAll").find("button.fa-arrow-right").on('click',toDoToInProgress);
</script>
<style>
.table-scroll {
	overflow: auto;
	height: 350px;
}
</style>