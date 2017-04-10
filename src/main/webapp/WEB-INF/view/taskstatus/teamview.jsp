<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Sprint Board Team View</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Taskman</span></li>
				<li class="active"><span>Sprint Board Team View</span></li>
			</ol>
		</div>
	</section>
	<center>
		<a style="margin-right: 15px" href="http://localhost:8080">Dashboard</a>
	</center>
	<!-- start: USER PROFILE -->
	<div class="container-fluid  bg-white">
			<div>
				<div class="alert alert-block alert-danger hidden">
					Please check the fields marked with <span
						class="text-red fa fa-close"></span>.
				</div>
				<!-- <div class="denotes-required">denotes a required field.</div> -->
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<cts:Label name="Sprint Name" labelFor="sprint_code" />
							<cts:Select list="${data.sprintCodes}" name="sprint_code"
								value="${data.sprintCode}" cssClass="required"
								emptyValue="--SELECT--" />
							<input name="sprint_name" type="hidden" value="">
						</div>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table">
						<tbody>
							<tr style="vertical-align: baseline;">
								<td style="vertical-align: top;">
									<div class="width-300">
										<fieldset>
											<legend>
												Stories&nbsp;&nbsp;
												<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
											</legend>
											<div class="table-responsive">
												<table class="data-grid" id="story">
													<thead>
														<tr>
															<th class="code-item" style="width:150px !important;">Story Code</th>
															<th class="story_name">Story Name</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>

													</tbody>
												</table>
											</div>
										</fieldset>
									</div>
								</td>
								<td style="vertical-align: top;">
									<div class="width-300">
										<fieldset>
											<legend>
												Tasks&nbsp;&nbsp;
												<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
											</legend>
											<div class="table-responsive">
												<table class="data-grid" id="taskAll">
													<thead>
														<tr>
															<th class="sortIdcheck">Task Code</th>
															<th>Task Name</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>
													</tbody>
												</table>
											</div>
										</fieldset>
									</div>
								</td>
								<td style="vertical-align: top;">
									<div class="width-300">
										<fieldset>
											<legend>
												Progress&nbsp;&nbsp;
												<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
											</legend>
											<div class="table-responsive">
												<table class="data-grid" id="inProgressTask">
													<thead>
														<tr>
															<th id="inprogress" class="code-item">Item Code</th>
															<th id="story_code_sort">Item Name</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>
													</tbody>
												</table>
											</div>
										</fieldset>
									</div>
								</td>
								<td style="vertical-align: top;">
									<div class="width-300">
										<fieldset>
											<legend>
												Review&nbsp;&nbsp;
												<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
											</legend>
											<div class="table-responsive">
												<table class="data-grid" id="inReviewTask">
													<thead>
														<tr>
															<th class="code-item">Item Code</th>
															<th>Item Name</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>
													</tbody>
												</table>
											</div>
										</fieldset>
									</div>
								</td>
								<td style="vertical-align: top;">
									<div class="width-300">
										<fieldset>
											<legend>
												QA&nbsp;&nbsp;
												<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
											</legend>
											<div class="table-responsive">
												<table class="data-grid" id="QAStory">
													<thead>
														<tr>
															<th class="code-item">Story Code</th>
															<th>Story Name</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>
													</tbody>
												</table>
											</div>
										</fieldset>
									</div>
								</td>
								<td style="vertical-align: top;">
									<div class="width-300">
										<fieldset>
											<legend>
												Done&nbsp;&nbsp;
												<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button> -->
											</legend>
											<div class="table-responsive">
												<table class="data-grid" id="done">
													<thead>
														<tr>
															<th class="code-item">Story Code</th>
															<th>Story Name</th>
															
														</tr>
													</thead>
													<tbody>
													</tbody>
												</table>
											</div>
										</fieldset>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row margin-top-10">
				<div class="col-md-8">
					<cts:Button dAjax="true"
						dHref="/toc?type=privgrp&currprivgrp=3&currmodcode=PR"
						cssClass="back" spanClass="arrow-left" />
					<cts:Button cssClass="refresh" spanClass="refresh" />
					<cts:Button cssClass="help" spanClass="question" />
				</div>
			</div>
	</div>
</div>
<script src="/assets/js/jquery.sortElements.js"></script>
<script>
	InitHandlers();

	var code;
	var name;

	$("input[name='sprint_name']")
			.val($("#sprint_code option:selected").text());

	$("#sprint_code").on('change',function() {
						var newSprintCode = $("#sprint_code").val();
						$.ajax({
							url : "/taskman/sprintboard/loaddedsprintmanagerdetail?sprint_code="
								+ newSprintCode,
							success : function(data) {
										//console.log(data);
										var objType = eval(data.toStory);
										var objType2 = eval(data.toDoAllTask);
										var inProgressTask = eval(data.toInProgressAllTask);
										var toReviewAllTask = eval(data.toReviewAllTask);
										var toStory = eval(data.toStory);
										var toQA = eval(data.toQA);
										
										var toDone = eval(data.toDone);
										console.log(toDone);
										addRowStory(objType);
										addRowTasks(objType2);
										addInProgress(inProgressTask);
										addReviewAllTask(toReviewAllTask);
										addQA(toQA);
										addDone(toDone);
										

									}
								});

					});

	//FOR STORY BOARD TABLE
	function addRowStory(objType) {

		var html = "";
		for (var i = 0; i < objType.length; i++) {
			for(var j=0; j<objType[i].length; j++){
			var id = objType[i][j].id;
			var code = objType[i][j].sprintStoryCode;
			var name = objType[i][j].sprintStoryName;
			var sprintCode = objType[i][j].sprintCode;
			var sprintId = objType[i][j].sprintId;

			html += ""
                + '<tr>'
                + '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
                + '<td><input type="text" class="sprint-story-code width-50" readonly value="'+ code  + '"/></td>'
                + '<td class="width-300"><input type="text" class="sprint-story-name" value="'+ name  + '" /></td>'
                + '<td>'
                + '<button type="button" onclick="storyToQA(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
                + '</td>'
                + '<input type="hidden" class="sprint-Code" value="'+ sprintCode  + '" /></td>'
                + '<input type="hidden" class="sprint-id" value="'+ sprintId  + '" /></td>'
                + '</tr>';
			}
		}
		InitHandlers();
		$("#story tbody").html(html);

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
				//console.log(id);
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
						+ '</td>' 
						+ '</tr>';
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
						+ '</td>' 
						+ '</tr>';
			}
		}

		InitHandlers();
		$("#inReviewTask tbody").html(html);
	}
	
	
	
	
	//For QA Board Table
	function addQA(toQA) {
		var html = "";
		for (var i = 0; i < toQA.length; i++) {
			for (var j = 0; j < toQA[i].length; j++) {
				var id = toQA[i][j].id;
				var code = toQA[i][j].sprintStoryCode;
				var name = toQA[i][j].sprintStoryName;
				html += ""
						+ '<tr>'
						+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
						+ '<td><input type="text" class="sprint-story-code width-50" readonly value="'+ code  + '"/></td>'
		                + '<td class="width-300"><input type="text" class="sprint-story-name" value="'+ name  + '" /></td>'
		                + '<td>'
						+ '<button type="button" onclick="qaToDone(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
						+ '<button type="button" onclick="fromQAToStory(this);" class="btn btn-xs"><span class="fa fa-arrow-left trash">'
						+ '</td>' 
		                + '</tr>';
			}
		}

		InitHandlers();
		$("#QAStory tbody").append(html);
	}
	
	
	
	
	function addDone(toDone) {
		var html = "";
		for (var i = 0; i < toDone.length; i++) {
			for (var j = 0; j < toDone[i].length; j++) {
				var id = toDone[i][j].id;
				var code = toDone[i][j].sprintStoryCode;
				var name = toDone[i][j].sprintStoryName;
				html += ""
						+ '<tr>'
						+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
						+ '<td><input type="text" class="sprint-story-code width-50" readonly value="'+ code  + '"/></td>'
		                + '<td class="width-300"><input type="text" class="sprint-story-name" value="'+ name  + '" /></td>'
		                 
		                + '</tr>';
			}
		}

		InitHandlers();
		$("#done tbody").append(html);
	}
	
	
	//From Story To QA
	function storyToQA(el) {
		var count1 = ($("#QAStory tr ").length) - 1;
		count1 = count1 + 1;
		var qaval = $(el).closest("tr");
		var id = qaval.find(".id").val();
		var code = qaval.find(".sprint-story-code").val();
		var name = qaval.find(".sprint-story-name").val();
				$.ajax({
					type : 'GET',
					url : '/taskman/sprintboard/storystatus/update/' + id
					+ '/QA',
					success : function(data, status, xhr) {
						//console.log(status);
						if (status == "success") {
							html = ""
									+ '<tr>'
									+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
									+ '<td><input name="sprint-story-code" type="text" class="sprint-story-code width-50" value="'+ code  + '"/></td>'
									+ '<td class="width-300"><input name="sprint-story-name" type="text" class="sprint-story-name" value="'+ name  + '" /></td>'
									+ '<td>'
									+ '<button type="button" onclick="qaToDone(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
									+ '<button type="button" onclick="fromQAToStory(this);" class="btn btn-xs"><span class="fa fa-arrow-left trash">'
									+ '</td>' + '</tr>';
							InitHandlers();
							$("#QAStory tbody").append(html);

							$(el).closest("tr").remove();
						}
					}
				});

	}
	
	//From QA To Story
	function fromQAToStory(el) {
		var count1 = ($("#story tr ").length) - 1;
		count1 = count1 + 1;
		var qaval = $(el).closest("tr");
		var id = qaval.find(".id").val();
		var code = qaval.find(".sprint-story-code").val();
		var name = qaval.find(".sprint-story-name").val();
				$.ajax({
					type : 'GET',
					url : '/taskman/sprintboard/storystatus/update/' + id
					+ '/Story',
					success : function(data, status, xhr) {
						//console.log(status);
						if (status == "success") {
							html = ""
									+ '<tr>'
									+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
									+ '<td><input name="sprint-story-code" type="text" class="sprint-story-code width-50" value="'+ code  + '"/></td>'
									+ '<td class="width-300"><input name="sprint-story-name" type="text" class="sprint-story-name" value="'+ name  + '" /></td>'
									+ '<td>'
									+ '<button type="button" onclick="storyToQA(this);" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;'
									+ '</td>' + '</tr>';
							InitHandlers();
							$("#story tbody").append(html);

							$(el).closest("tr").remove();
						}
					}
				});
	}
	
	
	
	
	//From QA To Done
	function qaToDone(el) {
		var count1 = ($("#done tr ").length) - 1;
		count1 = count1 + 1;
		var qaval = $(el).closest("tr");
		var id = qaval.find(".id").val();
		var code = qaval.find(".sprint-story-code").val();
		var name = qaval.find(".sprint-story-name").val();
				$.ajax({
					type : 'GET',
					url : '/taskman/sprintboard/storystatus/update/' + id
					+ '/Done',
					success : function(data, status, xhr) {
						console.log(status);
						if (status == "success") {
							html = ""
									+ '<tr>'
									+ '<input type="hidden" class="id" width-50"  value="'+ id  + '"/>'
									+ '<td><input name="sprint-story-code" type="text" class="sprint-story-code width-50" value="'+ code  + '"/></td>'
									+ '<td class="width-300"><input name="sprint-story-name" type="text" class="sprint-story-name" value="'+ name  + '" /></td>'
									+ '</tr>';
							InitHandlers();
							$("#done tbody").append(html);

							$(el).closest("tr").remove();
						}
					}
				});

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
					url : '/taskman/sprintboard/taskstatus/update/' + id
					+ '/In Progress',
					success : function(data, status, xhr) {
						//console.log(status);
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
					url : '/taskman/sprintboard/taskstatus/update/' + id+ '/To Be Review',
					success : function(data, status, xhr) {
						//console.log(status);
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
					url : '/taskman/sprintboard/taskstatus/update/' + id
					+ '/In Progress',
					success : function(data, status, xhr) {
						//console.log(status);
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
					url : '/taskman/sprintboard/taskstatus/update/' + id
					+ '/To Do',
					success : function(data, status, xhr) {
						//console.log(status);
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
	
	
	 var table = $('#inProgressTask');
	    
	    $("#story_code_sort,#inprogress")
	        .wrapInner('<span title="sort this column"/>')
	        .each(function(){
	            
	            var th = $(this),
	                thIndex = th.index(),
	                inverse = false;
	            
	            th.click(function(){
	            	
	                
	            	table.find('td').filter(function(){
	            		
	                    return $(this).index() === thIndex;
	                    
	                }).sortElements(function(a, b){
	                    
	                    return $.text([a]) > $.text([b]) ?
	                        inverse ? -1 : 1
	                        : inverse ? 1 : -1;
	                    
	                }, function(){
	                    
	                    // parentNode is the element we want to move
	                    return this.parentNode; 
	                    
	                });
	                
	                inverse = !inverse;
	                //alert(inverse);
	            });
	           
	                
	        });
	    
</script>
<style>
.table-scroll {
	overflow: auto;
	height: 350px;
}
</style>