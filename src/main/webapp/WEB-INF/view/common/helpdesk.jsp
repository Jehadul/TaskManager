	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="wrap-content container" id="container">
		<!-- start: PAGE TITLE -->
		<section id="page-title" class="padding-top-10 padding-bottom-10">
			<div class="row">
				<div class="col-sm-8">
					<h1 class="mainTitle">Helpdesk</h1>
				</div>
				<ol class="breadcrumb padding-top-20">
					<li>
						<span>Home</span>
					</li>
					<li class="active">
						<span>Helpdesk</span>
					</li>
				</ol>
			</div>
		</section>
		<!-- end: PAGE TITLE -->
		<div class="container-fluid container-fullw bg-white">
			<div class="row">
				<div class="col-sm-3">
					<a data-ajax="true" href="grc/ac/privilege/create">Request Access</a>
				</div>
				<div class="col-sm-3">
					<a data-ajax="true" href="grc/ac/privilege/wfstatus">Workflow Status</a>
				</div>
				<div class="col-sm-3">
					<a data-ajax="true" href="hrm/tm/leaveapplication/create">Leave Application</a>
				</div>
			</div>
			<h4>Draft access requests</h4>
			<div class="table-responsive">
				<table class="table table-striped table-hover" id="access_requests" style="width:100%;">
					<thead>
						<tr>
							<th>Date</th>
							<th>Company</th>
							<th>Branch</th>
							<th>Suite</th>
							<th class="width-400">Purpose</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${data.privReqWip.size() > 0}">
						<c:forEach var="i" begin="0" end="${data.privReqWip.size() - 1}">
							
							<tr>
								<td>${data.privReqWip[i].reqDate} </td>
								<td>${data.privReqWip[i].companyName} </td>
								<td>${data.privReqWip[i].branchName}</td>
								<td>${data.privReqWip[i].suiteShortName}</td>
								<td>
								<a data-ajax="true" href="grc/ac/privilege/show/${data.privReqWip[i].id}/wip">
									ok
								</a>
								</td>
							</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			
			<h4>Draft Leave requests</h4>
			<div class="table-responsive">
				<table class="table table-striped table-hover" id="leave_application_requests" style="width:100%;">
					<thead>
						<tr role="row">
							<th class="sorting" tabindex="0" aria-controls="journal_requests" rowspan="1" colspan="1" aria-label="Company: activate to sort column ascending" style="width: 195px;">Company Name
							</th>
							<th class="sorting" tabindex="0" aria-controls="journal_requests" rowspan="1" colspan="1" aria-label="Employee Code: activate to sort column ascending" style="width: 195px;">Employee Code
							</th>
							<th class="sorting" tabindex="0" aria-controls="journal_requests" rowspan="1" colspan="1" aria-label="Employee Name: activate to sort column ascending" style="width: 159px;">Employee Name
							<th class="sorting" tabindex="0" aria-controls="journal_requests" rowspan="1" colspan="1" aria-label="Leave Name: activate to sort column ascending" style="width: 159px;">Leave Name
							<th class="sorting width-800" tabindex="0" aria-controls="journal_requests" rowspan="1" colspan="1" aria-label="Created Date activate to sort column ascending" style="width: 159px;">Created Date
							<th class="sorting" tabindex="0" aria-controls="journal_requests" rowspan="1" colspan="1" aria-label="Branch: activate to sort column ascending" style="width: 159px;">Purpose
							</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${data.drafts.size() > 0}">
						<c:forEach var="i" begin="0" end="${data.drafts.size() - 1}">
							<tr>
	 							<td>${data.drafts[i].companyName } </td>
								<td>${data.drafts[i].empCode} </td>
								<td>${data.drafts[i].empName }</td>
								<td>${data.drafts[i].leaveName}</td> 
								<td>${data.drafts[i].createdAt}</td>
								<td>
								<a data-ajax="true" href="hrm/tm/leaveapplication/show/${data.drafts[i].id}/wip">ok</a>  
								</td>
							</tr>
						</c:forEach>
					 </c:if>
					</tbody>
				</table>
			</div>		
		</div>
	</div>
	
	<script>
		InitHandlers();
		InitDataTable("#access_requests");
	</script>
