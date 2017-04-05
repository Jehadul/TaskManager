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
            <li class="active"><span>Sprint Board UI</span></li>
         </ol>
      </div>
   </section>
   <!-- start: USER PROFILE -->
   <div class="container-fluid  bg-white">
      <cts:AjaxForm action="/taskman/sprintboard/ui/store" dataHandler="showMessage">
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
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
            <div class="table-responsive">
               <table class="table">
                  <tbody>
                     <tr>
                        <td>
                           <div class="width-300">
                              <fieldset>
<!--                                  <legend>Stories&nbsp;&nbsp;  -->
<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
<!--                                  </legend> -->
                                 <div class="table-responsive">
                                    <table class="data-grid" id="sprintmanagerdetail">
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
                        <td>
                           <div class="width-300">
                              <fieldset>
<!--                                  <legend>Tasks&nbsp;&nbsp;  -->
<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
<!--                                  </legend> -->
                                 <div class="table-responsive">
                                    <table class="data-grid" id="taskAll" >
                                       <thead>
                                          <tr>
                                             <th class="code-item">Task Code</th>
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
                        <td>
                           <div class="width-300">
                              <fieldset>
<!--                                  <legend>Progress&nbsp;&nbsp;  -->
<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
<!--                                  </legend> -->
                                 <div class="table-responsive">
                                    <table class="data-grid" id="SaleComponent2">
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
                        <td>
                           <div class="width-300">
                              <fieldset>
<!--                                  <legend>Review&nbsp;&nbsp;  -->
<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
<!--                                  </legend> -->
                                 <div class="table-responsive">
                                    <table class="data-grid" id="SaleComponent3">
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
                        <td>
                           <div class="width-300">
                              <fieldset>
<!--                                  <legend>QA&nbsp;&nbsp;  -->
<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
<!--                                  </legend> -->
                                 <div class="table-responsive">
                                    <table class="data-grid" id="SaleComponent4">
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
                        <td>
                           <div class="width-300">
                              <fieldset>
<!--                                  <legend>Done&nbsp;&nbsp;  -->
<!--                                     <button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>   -->
<!--                                  </legend> -->
                                 <div class="table-responsive">
                                    <table class="data-grid" id="SaleComponent5">
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
                     </tr>
                  </tbody>
               </table>
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
   
 
   
   $("input[name='sprint_name']").val($("#sprint_code option:selected").text());
   
    $("#sprint_code").on('change',function(){
		var newSprintCode = $("#sprint_code").val();	
		/*LoadMainContent('/taskman/sprintboard/ui/loaddedsprintmanagerdetail?sprint_code=' + newSprintCode); */
		$.ajax({
			url: "/taskman/sprintboard/ui/loaddedsprintmanagerdetail?sprint_code="+ newSprintCode,
			success:function(data){
				var objType = eval(data.sprintManagerDetail);
				var objType2 = eval(data.task);
				//console.log(objType2);
				
				addRowStory(objType);
				addRowTasks(objType2);
			}
		});
		
    });
   
   
 
  
  function addRowStory(objType){
	  
  		var html = ""; 
		for (var i = 0; i < objType.length; i++) {
			var code = objType[i].sprintStoryCode;
			var name = objType[i].sprintStoryName;
			var sprintCode = objType[i].sprintCode;
			var sprintId = objType[i].sprintId; 		
			
			
			html += "" +
			'<tr>' +
				'<td><input type="text" class="sprint-story-code width-50" readonly value="'+ code  + '"/></td>' +
				'<td class="width-300"><input type="text" class="sprint-story-name" readonly value="'+ name  + '" /></td>' +
				'<td>' +
					'<button type="button" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;' +
				'</td>'+
					'<input type="hidden" class="sprint-Code" readonly value="'+ sprintCode  + '" /></td>' +
					'<input type="hidden" class="sprint-id" readonly value="'+ sprintId  + '" /></td>' +
			'</tr>';

		} 
		
	InitHandlers();
	$("#sprintmanagerdetail tbody").html(html);
	
	if(objType.length>2){
		$(".table-responsive").addClass("table-scroll");
	}
	} 
  
  
  function addRowTasks(objType2){
	  var html = ""; 
	  for (var i = 0; i < objType2.length; i++) {
			for(var j=0; j<objType2[i].length;j++){
				var code = objType2[i][j].taskCode;
				var name = objType2[i][j].taskTitle;
				html += "" +
				'<tr>' +
					'<td><input type="text" class="task-code width-50" readonly value="'+ code  + '"/></td>' +
					'<td class="width-300"><input type="text" class="task-name" readonly value="'+ name  + '" /></td>' +
					'<td>' +
						'<button type="button" class="btn btn-xs fa fa-arrow-right"><span style="width:20px;"></span></button>&nbsp;' +
					'</td>'+
				'</tr>';
			}
			}
		
		
	InitHandlers();
	$("#taskAll tbody").html(html);
	} 

 
   
   
</script>
<style>
	.table-scroll{
		overflow:auto;
		height:350px;
	}
</style>