<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Create Task</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Taskman</span>
				</li>
				<li class="active">
					<span>Edit Task</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/tman/tasks/update" dataHandler="showMessage" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">
						<%-- <div class="form-group">
							<cts:Label labelFor="product_name" name="Product Name"/>
							<cts:Select list="${map.productCodes}"  name="priv_grp_code" value="" cssClass="required" emptyValue="--SELECT--"/>
							
						</div>  --%>
						<%-- <div class="form-group">
							<cts:Label labelFor="suite_code" name="Suite Name"/>
							<cts:Select list="${map.suiteCodes}"  name="suite_code" value="${map.suiteCode}" cssClass="required" emptyValue="--SELECT--"/>
							
						</div> --%>
						
						
						<div class="form-group">
							<label for="suite_code" class="control-label">Suite Name</label>
								<cts:Hidden name="id" value="${map.tasks.id}"/>
								<select id="suite_code" class="form-control required" name="suite_code">
									<c:forEach items="${map.suiteCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.tasks.suiteCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>			
					   </div>
						
						<div class="form-group">
							<label for="module_code" class="control-label">Module Name</label>
								<select id="module_code" class="form-control required" name="module_code">
									<c:forEach items="${map.moduleCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.tasks.moduleCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>			
					   </div>
						<%-- <div class="form-group">
							<cts:Label labelFor="module_code" name="Module Name"/>
							<cts:Select list="${map.moduleCodes}"  name="module_code" value="" cssClass="required" emptyValue="--SELECT--"/>
							
						</div> --%>
						<div class="form-group">
								<cts:Label name="Description" labelFor="description"/>
								<cts:TextArea name="description" value="${map.tasks.description}" cssClass="dirty-check required" readonly="" rows="3" cols=""/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<cts:Label name="Story Code" labelFor="story_code"/>
							<cts:TextBox name="story_code" value="${map.tasks.storyCode}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">						
							<cts:Label name="Task Title" labelFor="task_title"/>
							<cts:TextBox name="task_title" value="${map.tasks.taskTitle}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">
							<cts:Label name="Estimated Time" labelFor="estimated_time"/>
							<cts:TextBox name="estimated_time" value="${map.tasks.estimatedTime}" cssClass="dirty-check required" readonly=""/>
						</div>
						<div class="form-group">						
							<cts:Label name="Assignee" labelFor="assignee"/>
							<cts:TextBox name="assignee" value="${map.tasks.asignee}"  cssClass="dirty-check" readonly=""/>
						</div>
					</div>
				</div>
				<div class="row margin-top-10">
			<div class="col-md-8">
						<button class="btn btn-back" data-ajax="true"
						data-href="/toc?type=privgrp&currprivgrp=3&currmodcode=PM"
						title="Back" type="button">
						<span class="fa fa-arrow-left"></span>
					</button>
					<button class="btn btn-refresh refresh-linked" type="button">
						<span class="fa fa-refresh"></span>
					</button>
					<button class="btn btn-help" type="button">
						<span class="fa fa-question"></span>
					</button>

				</div>

				<div class="col-md-4">
				<button class="btn btn-save pull-right" type="submit">
						<span class="fa fa-save"></span> Save
					</button>
				</div>
			</div>
			</div>
		</cts:AjaxForm>
	</div>
</div>
<script>

   InitHandlers();
   
   function showMessage(data) {
		if (data.outcome == 'success') {
			isDirty = false ;
			ShowSuccessMsg('Tasks Updated', data.msg);
			
			LoadMainContent('/taskman/tman/tasks/show/'+ data.id);
		} else {
			ShowErrorMsg('Tasks was not Updated', data.msg);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}

	$('#suite_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		LoadMainContent("/taskman/tman/tasks/create/?suite_code=" + newSuiteCode);
	
	});
	
	$('#module_code').on('change', function(){
		var newSuiteCode = $("#suite_code").val();
		var newModuleCode = $("#module_code").val();
		
	});
</script>