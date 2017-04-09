<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<div class="wrap-content container" id="container">
	<!-- start: PAGE TITLE -->
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-2">
				<div class="col-md-auto"><img class="margin-top-8" width="140" height="70" src="assets/logo/CTS.png" /></div>
			</div>
			<div class="col-sm-8">
				
				<h1 class="mainTitle center">User Wise Daily Report</h1>
				<h6 class="center">( Date : ${data.date} )</h6> 
			</div>
			<div class="col-sm-2"></div>
		</div>
	</section>
	<center>
		<a href="http://localhost:8080">Back</a>
	</center>
	<div class="container-fluid container-fullw bg-white">	
		<div class="row">
			<div class="col-md-8">
				
				<h4>${data.tlist[0].companyName}</h4><br/><br/>
				<div class="row">
					<div class="col-md-3">
						<cts:Label name="Employee Code" labelFor="ok"/> 
					</div>
					<div class="col-md-1">:</div>
					<div class="col-md-5">${data.empCode}</div>					
				</div>
				<div class="row">
					<div class="col-md-3">
						<cts:Label name="Employee Name" labelFor="ok"/> 
					</div>
					<div class="col-md-1">:</div>
					<div class="col-md-5">${data.empName}</div>					
				</div>
				
			</div>
			<div class="col-md-4" style="text-align: right">Date : <%= new java.util.Date() %></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h5 class="center">Daily Report</h5>
				<fieldset>
						<table class="data-grid width-full" id="LevelTable">
							<thead>
								
								<tr>
									<td id="id">Story Title</td>
									<td id="id">Task Title</td>
									<td id="id">Task Code</td>
									<td id="id">Start Time</td>	
									<td id="id">End Time</td>	
									<td id="id">Spent Time</td>
								</tr>		
							</thead>
							<tbody>
								<c:forEach var="tvReportList" items="${data.taskViewReportList}">
									<tr>
										<td><c:out value=" ${tvReportList.storyTitle}"/></td>
										<td><c:out value=" ${tvReportList.taskTitle}"/></td>
										<td><c:out value=" ${tvReportList.taskCode}"/></td>
										<td>
											<c:forEach var="tLog" items="${tvReportList.taskLogList}">
												<p><c:out value=" ${tLog.startTime}"/></p>
											</c:forEach>
										</td>
										<td>
											<c:forEach var="tLog" items="${tvReportList.taskLogList}">
												<p><c:out value=" ${tLog.stopTime}"/></p>
											</c:forEach>
										</td>
										<td><c:out value=" ${tvReportList.totalDaySpentTime}"/></td>
									</tr>
									
								</c:forEach>
								
							</tbody>
							<tfoot  class="deductionpackage-tfoot" id="text" >
								<tr style="height:30px">
									
																		
								</tr>
							</tfoot>
						</table>
				</fieldset>
			</div>
			
		</div>
		
		
	</div>
</div>

<script>
	InitHandlers(); 


	
	
	
	
	
/* 
	function changeTime(tagName){
		var s = tagName.val();
		tagName.val(s);
	}

	$(".remain-time").each(function(){
		var s = $(this).val();
		$(this).val(miltoTime(s));
	});
	
	function miltoTime(ms) {
	    hours = Math.floor(ms / 3600000), // 1 Hour = 36000 Milliseconds
	    minutes = Math.floor((ms % 3600000) / 60000), // 1 Minutes = 60000 Milliseconds
	    seconds = Math.floor(((ms % 360000) % 60000) / 1000) // 1 Second = 1000 Milliseconds
	    
	    return hours + ":" + minutes + ":" + seconds
	}

console.log(miltoTime(1200000));
 */


</script>

<style type="text/css">
	tfoot {background:#C3C3C3; color:#3B3B3B; font-weight:bold; }
	th {color:#3B3B3B}
	thead th {text-align: center;}
	/* td {text-align: center;} */
	#id{text-align: center;}
}
</style>
