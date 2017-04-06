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
	
	<center>
		<a href="http://localhost:8080/?desturl=/taskman/team/create">Create Team</a>
		 | <a href="http://localhost:8080">Dashboard</a>
	</center>
	
		<fieldset>
			<legend> Team List&nbsp;&nbsp; </legend>
			<c:if test="${data.teamLi.size() > 0}">
				<c:forEach var="i" begin="0" end="${data.teamLi.size()-1}">
					<div id="teamlists" class="panel-group accordion">
						<c:set var="prevBlockId" value="" />
						<c:set var="nextBlockId" value="" />
							<c:if test="${!data.teamLi[i].teamCode.equals(prevBlockId)}">
								<div class="wf-block panel panel-light-grey" data-id="${data.teamLi[i].teamCode}">
									<div class="panel-heading">
										<h5 class="panel-title">
										 	<a class="accordion-toggle bold" data-toggle="collapse"
												data-parent="#accordion"
												href="#wf_block${data.teamLi[i].teamCode}"><i
												class="icon-arrow"> </i>
												<span class="wf-block-title">
												<cts:Label name="Team Code  :" labelFor="team_code"/>&nbsp;&nbsp;${data.teamLi[i].teamCode}&nbsp;&nbsp;&nbsp;&nbsp; <cts:Label name="Team Name  :" labelFor="team_name"/>&nbsp;&nbsp;${data.teamLi[i].teamName}&nbsp;&nbsp;&nbsp;&nbsp; <cts:Label name="Number of Members  :" labelFor="nt_member"/>&nbsp;&nbsp;${data.teamLi[i].teamSize}
													<%-- <div class="row">
													<div class="col-md-4">
														<cts:Label name="Team Code  :" labelFor="team_code"/>&nbsp;&nbsp;${data.teamLi[i].teamCode}
													</div>
													<div class="col-md-4">
														<cts:Label name="Team Name  :" labelFor="team_name"/>&nbsp;&nbsp;${data.teamLi[i].teamName}
													</div>
													<div class="col-md-4">
														<cts:Label name="Number of Members  :" labelFor="nt_member"/>&nbsp;&nbsp;${data.teamLi[i].teamSize}
													</div>
														 
													</div> --%>
													
													<button type="button" onclick="delRow(this);" class="pull-right btn-del btn btn-xs">
														<span class="fa fa-trash"></span>
														<input type="hidden" name="team_id" value="${data.teamLi[i].id}" />
													</button>
												</span>
											</a>
	
										</h5>
									</div>
									<div id="wf_block${data.teamLi[i].teamCode}"
										class="panel-collapse collapse in">
										<div class="panel-body">
											<table class="wf-step-list table table-striped table-hover">
												<thead>
													<tr>
														<th>Employee Code</th>
														<th>Employee Name</th>
														<th>Username</th>
													</tr>
												</thead>
												<tbody>
													</c:if>
													<c:choose>
														<c:when test="${i < data.teamLi.size()-1}">
															<c:set var="nextBlockId"
																value="${data.teamLi[i+1].teamCode}" />
														</c:when>
														<c:otherwise>
															<c:set var="nextBlockId" value="" />
														</c:otherwise>
													</c:choose>
													<%-- <c:forEach var="teamDetails" items ="${data.teamLi[i].teamDetails}" > --%>
													<c:forEach var="j" begin="0" end="${data.teamLi[i].teamDetails.size()-1}">
													<tr>
														<td>${data.teamLi[i].teamDetails[j].empCode}</td>
														<td>${data.teamLi[i].teamDetails[j].empName}</td>
														<td>${data.teamLi[i].teamDetails[j].username}</td>
													</tr>
													</c:forEach>
												</tbody>
												<c:if test="${!data.teamLi[i].teamCode.equals(nextBlockId)}">
											</table>
											
										</div>
	
									</div>
								</div>
							</c:if>
							<c:set var="prevBlockId" value="${data.teamLi[i].teamCode}" />
					</div>	
				</c:forEach>
			</c:if>
		</fieldset>
	</div>
</div>	

<script>
	InitHandlers();


	
	var delRow = function(el) {
		swal({
			title : "Are you sure?",
			text : "Are you sure to delete this team?",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#007AFF",
			confirmButtonText : "Yes, delete it!",
			closeOnConfirm : true
		}, function() {
			
			var teamId = $(el).find("input").val();
			data  = "teamId="+teamId;
			$.ajax({
				type : 'GET',
				url : '/taskman/team/delete',
				data: data,
				success : function(response, status, xhr) {
					LoadMainContent("/taskman/team/teamlist");
				}
			});
		});
	};


</script>


