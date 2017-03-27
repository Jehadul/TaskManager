<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Edit User Story</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>User Story</span></li>
				<li class="active"><span>Edit User Story</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="/taskman/userstory/story/update"
			dataHandler="showMessage">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with <span
					class="text-red fa fa-close"></span>.
			</div>

			<div class="denotes-required">denotes a required field.</div>
			<cts:Hidden name="id" value="${map.userStory.id}" />
			<div class="main-control">
				<div class="row">
					<div class="col-md-6">

						<div class="form-group">

							<cts:Label labelFor="suite_name" name="Suite Name" />
							<cts:TextBox name="suite_name" cssClass="dirty-check"
								readonly="readonly" value="${map.userStory.suiteName}" />
							<cts:Hidden name="suite_code" value="${map.userStory.suiteCode}" />
							<cts:Hidden name="id" value="${map.userStory.id}" />

						</div>
						<div class="form-group">

							<cts:Label labelFor="module_name" name="Module Name" />
							<cts:TextBox name="module_name" cssClass="dirty-check"
								readonly="readonly" value="${map.userStory.moduleName}" />
							<cts:Hidden name="module_code"
								value="${map.userStory.moduleCode}" />

						</div>

						<div class="form-group">
							<cts:Label labelFor="priv_grp_name" name="Privilege Group" />
							<cts:TextBox name="priv_grp_name" cssClass="dirty-check"
								readonly="readonly" value="${map.userStory.privGrpName}" />
							<cts:Hidden name="priv_grp_code"
								value="${map.userStory.privGrpCode}" />
						</div>


						<%-- <div class="form-group">
							<label for="suite_code" class="control-label">Suite Name</label>
								
								<select id="suite_code" class="form-control" name="suite_code">
									<c:forEach items="${map.suiteCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.userStory.suiteCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>	
								<cts:Hidden name="suite_name" value=""/>		
					   </div>  --%>

						<%-- <div class="form-group">
							<label for="module_code" class="control-label">Module Name</label>
								<select id="module_code" class="form-control" name="module_code">
									<c:forEach items="${map.moduleCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.userStory.moduleCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>
								<cts:Hidden name="module_name" value=""/>			
					   </div>
					   
					   <div class="form-group">
							<label for="suite_code" class="control-label">Privilege Group</label>
								
								<select id="priv_grp_code" class="form-control " name="priv_grp_code">
									<c:forEach items="${map.privGrpCodes}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.userStory.privGrpCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>
										
									</c:choose>	
									</c:forEach>
								</select>	
								<cts:Hidden name="priv_grp_name" value=""/>		
					   </div> --%>

						<div class="form-group">
							<cts:Label name="Privilege Code" labelFor="privilege_code" />
							<cts:TextBox name="privilege_code" cssClass="dirty-check "
								value="${map.userStory.privilegeCode}" readonly="readonly" />
						</div>
						<div class="form-group">
							<cts:Label labelFor="privilege_name" name="Privilege Name" />
							<cts:TextBox name="privilege_name"
								cssClass="dirty-check required"
								value="${map.userStory.privilegeName}" readonly="" />
						</div>

						<div class="form-group">
							<cts:Label name="Story Code" labelFor="user_story_code" />
							<cts:TextBox name="user_story_code"
								value="${map.userStory.userStoryCode}"
								cssClass="dirty-check required" readonly="" />

						</div>
						<div class="form-group">
							<cts:Label name="Story Title" labelFor="user_story_title" />
							<cts:TextBox name="user_story_title"
								value="${map.userStory.userStoryTitle}"
								cssClass="dirty-check required" readonly="" />
						</div>



					</div>
					<div class="col-md-6">

					<div class="form-group">
							<cts:Label labelFor="priority_code" name="Priority" />
							<select id="priority_code" class="form-control required"
								name="priority_code">
								<c:forEach items="${map.priorities}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.userStory.priorityCode}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>

									</c:choose>
								</c:forEach>
							</select>
							<cts:Hidden name="priority" value="" />
						</div>
						
						<div class="form-group">
							<cts:Label labelFor="story_state" name="Story Status" />
							<select id="story_state" class="form-control required"
								name="story_state">
								<c:forEach items="${map.storyStatus}" var="item">
									<c:choose>
										<c:when test="${item.getKey() == map.userStory.storyStatus}">
											<option selected value="${item.getKey()}">${item.getValue()}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.getKey()}">${item.getValue()}</option>
										</c:otherwise>

									</c:choose>
								</c:forEach>
							</select>
							<cts:Hidden name="story_status" value=""/>
						</div>
						
						<div class="form-group">
							<cts:Label name="Story Order" labelFor="story_order" />
							<cts:TextBox name="story_order"
								value="${map.userStory.storyOrder}"
								cssClass="dirty-check required number" readonly="" />
						</div>
						<div class="form-group">
							<cts:Label name="Story Size" labelFor="size" />
							<cts:TextBox name="size" value="${map.userStory.size}"
								cssClass="dirty-check number" readonly="" />
						</div>

						<div class="form-group">
							<cts:Label name="Business Value" labelFor="business_value" />
							<cts:TextBox name="business_value"
								value="${map.userStory.businessValue}"
								cssClass="dirty-check number" readonly="" />
						</div>
						<div class="form-group">
							<cts:Label name="Acceptence Criteria"
								labelFor="acceptance_criteria" />
							<cts:TextArea name="acceptance_criteria"
								value="${map.userStory.acceptanceCriteria}"
								cssClass="dirty-check" readonly="" rows="3" cols="" />
						</div>


						<div class="form-group">
							<cts:Label name="Description" labelFor="description" />
							<cts:TextArea name="description"
								value="${map.userStory.description}" cssClass="dirty-check"
								readonly="" rows="3" cols="" />
						</div>
					</div>
				</div>

				<div class="row margin-top-30 margin-bottom-30 margin-right-5">
					<div class="col-md-auto">
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

					<div class="align-right">
						<button class="btn btn-save pull-right" type="submit">
							<span class="fa fa-save"></span> Update
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
			isDirty = false;
			ShowSuccessMsg('User Story Updated', data.message);

			LoadMainContent('/taskman/userstory/story/show/' + data.id);
		} else {
			ShowErrorMsg('User Story was not updated', data.message);
			var msg = ConcatWithBR(data.error);
			$(".alert").html(msg);
			$(".alert").removeClass("hidden");
		}
	}

	$("input[name='priority']").val($("#priority_code option:selected").text());

	$("#priority_code").on(
			"change",
			function() {
				$("input[name='priority']").val(
						$("#priority_code option:selected").text());
			});


	function validate() {

		var itemPrivilegeName = $("#privilege_name").val().trim();

		SyncOptionText();

		var error = "";
		var result = CheckRequired();

		if ($("#privilege_name").val() == "") {
			error += "Please Enter privilege Name <br/> ";
			result = false;

		}

		if ($("#user_story_title").val() == "") {
			error += "Please Enter User Story Title <br/> ";
			result = false;

		}

		if ($("#privilege_code").val() == "") {
			error += "Please Enter Privilege Code <br/> ";
			result = false;

		}

		if ($("#user_story_code").val() == "") {
			error += "Please Enter User Story Code <br/> ";
			result = false;

		}

		if ($("#story_order").val() == "") {
			error += "Please Enter Story Order <br/> ";
			result = false;

		}

		if ($("#suite_code").val() == "-1") {
			error += "Please select Suite Code <br/>";
			result = false;

		}

		if ($("#module_code").val() == "-1") {
			error += "Please select Module Code <br/>";
			result = false;

		}

		if ($("#priv_grp_code").val() == "-1") {
			error += "Please select Priv Grp Code <br/>";
			result = false;

		}

		if ($("#priority_code").val() == "-1") {
			error += "Please select Priority Code <br/>";
			result = false;

		}

		if (!result) {

			error += "Please check the fields marked with X";
			ShowErrorMsg('User Story was not Updated', "Please check details.");
			InitErrorChange();
			$(".alert").html(error);
			$(".alert").removeClass("hidden");
		}

		return result;
	}
</script>