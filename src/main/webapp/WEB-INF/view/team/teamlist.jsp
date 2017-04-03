<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">


	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Team List</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Team</span></li>
				<li class="active"><span>Team List</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<fieldset>
			<legend> Team List&nbsp;&nbsp; </legend>
		
		<div id="teamlists" class="panel-group accordion">
				<c:set var="prevBlockId" value="" />
				<c:set var="nextBlockId" value="" />
				<c:forEach var="i" begin="0" end="${data.teamLi.teamDetails.size()-1}">
					<c:if test="${!data.teamLi.teamDetails[i].sprintCode.equals(prevBlockId)}">
						<div class="wf-block panel panel-light-grey" data-id="${map.sprint.steps[i].sprintCode}">
							<div class="panel-heading">
								<h5 class="panel-title">
									<a class="accordion-toggle bold" data-toggle="collapse"
										data-parent="#accordion"
										href="#wf_block${map.sprint.steps[i].sprintCode}"><i
										class="icon-arrow"></i> <span class="wf-block-title">
											Sprint Code:${map.sprint.steps[i].sprintCode}</span>
									</a>
								</h5>
							</div>
							<div id="wf_block${map.sprint.steps[i].sprintCode}"
								class="panel-collapse collapse in">
								<div class="panel-body">
									<table class="wf-step-list table table-striped table-hover">
										<thead>
											<tr>
												<th>Story Code</th>
												<th>Story Name</th>
											</tr>
										</thead>
										<tbody>
											</c:if>
											<c:choose>
												<c:when test="${i < map.sprint.steps.size()-1}">
													<c:set var="nextBlockId"
														value="${map.sprint.steps[i+1].sprintCode}" />
												</c:when>
												<c:otherwise>
													<c:set var="nextBlockId" value="" />
												</c:otherwise>
											</c:choose>
											<tr>
												<td>${map.sprint.steps[i].sprintStoryCode}</td>
												<td>${map.sprint.steps[i].sprintStoryName}</td>
											</tr>
										</tbody>
										<c:if test="${!map.sprint.steps[i].sprintCode.equals(nextBlockId)}">
									</table>
								</div>
							</div>
						</div>
					</c:if>
					<c:set var="prevBlockId" value="${map.sprint.steps[i].sprintCode}" />
				</c:forEach>
			</div>	
			
		</fieldset>
	
	
	
		<%-- <div id="WorkflowBlocks" class="panel-group accordion">
				<c:set var="prevBlockId" value="" />
				<c:set var="nextBlockId" value="" />
				<c:forEach var="i" begin="0" end="${data.wf.steps.size()-1}">
					<c:if test="${!data.wf.steps[i].wfBlockId.equals(prevBlockId)}">
						<div class="wf-block panel panel-light-grey" data-id="${data.wf.steps[i].wfBlockId}">
							<div class="panel-heading">
								<h5 class="panel-title">
									<a class="accordion-toggle bold" data-toggle="collapse"
										data-parent="#accordion"
										href="#wf_block${data.wf.steps[i].wfBlockId}"><i
										class="icon-arrow"></i> <span class="wf-block-title">
											DOA Type:${data.wf.steps[i].doaTypeCode}, Limit: 999999999999</span>
									</a>
								</h5>
							</div>
							<div id="wf_block${data.wf.steps[i].wfBlockId}"
								class="panel-collapse collapse in">
								<div class="panel-body">
									<table class="wf-step-list table table-striped table-hover">
										<thead>
											<tr>
												<th>Step Code</th>
												<th>Step Name</th>
												<th>Doer</th>
												<th>Alt Doer</th>
											</tr>
										</thead>
										<tbody>
											</c:if>
											<c:choose>
												<c:when test="${i < data.wf.steps.size()-1}">
													<c:set var="nextBlockId"
														value="${data.wf.steps[i+1].wfBlockId}" />
												</c:when>
												<c:otherwise>
													<c:set var="nextBlockId" value="" />
												</c:otherwise>
											</c:choose>
											<tr>
												<td>${data.wf.steps[i].stepCode}</td>
												<td>${data.wf.steps[i].stepName}</td>
												<td>${data.wf.steps[i].doerName}</td>
												<td>${data.wf.steps[i].altDoerName}</td>
											</tr>
										</tbody>
										<c:if
											test="${!data.wf.steps[i].wfBlockId.equals(nextBlockId)}">
									</table>
								</div>
							</div>
						</div>
					</c:if>
					<c:set var="prevBlockId" value="${data.wf.steps[i].wfBlockId}" />
				</c:forEach>
		</div> --%>
	</div>
</div>	