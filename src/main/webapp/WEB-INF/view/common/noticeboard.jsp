<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
	<div class="wrap-content container" id="container">
		<!-- start: PAGE TITLE -->
		<section id="page-title" class="padding-top-10 padding-bottom-10">
			<div class="row">
				<div class="col-sm-8">
					<h1 class="mainTitle">Dashboard</h1>
				</div>
				<ol class="breadcrumb padding-top-20">
					<li>
						<span>Home</span>
					</li>
					<li class="active">
						<span>Dashboard</span>
					</li>
				</ol>
			</div>
		</section>
		<!-- end: PAGE TITLE -->
		<!-- start: YOUR CONTENT HERE -->
		<div class="container-fluid container-fullw bg-white">
			<div class="row">
			<fieldset>
				<legend> Current Tasks&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
							<thead>
								<tr>
								<th>Task Title</th>
								<th>Start Date</th>
								<th>Start Time</th>
								<th>Remaining Time</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="currentTasklist" items="${data.currentTasklist}">
								<tr>
									<td>
										<cts:TextBox name="curr_task_title" value="${currentTasklist.getTaskTitle() }" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="curr_date_abc" value="${currentTasklist.getDate() }" cssClass="view"/>
									</td>									
									<td>
										<cts:TextBox name="curr_start_time" value="${currentTasklist.getStartTime() }" cssClass="view"/>
									</td>													
									<td>
										<cts:TextBox name="curr_remaining_time" value="" cssClass="view"/>
									</td>						
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>	
			<fieldset>
				<legend>Task List&nbsp;&nbsp; </legend>
				<div class="table-responsive">
					<table class="table table-striped table-hover"
						id="task_sort_result">
							<thead>
								<tr>
								<th>Task Title</th>
								<th>Estimated Time</th>
								<th>Spent Time</th>
								<th>Remaining Time</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${data.tasklist}">
								<tr>
									<td>
										<cts:TextBox name="task_title" value="${task.getTaskTitle() }" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="estimate_time" value="${task.getEstimatedTime()}" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="spent_time" value="${task.getSpentTime()}" cssClass="view"/>
									</td>
									<td>
										<cts:TextBox name="remaining_time" value="${task.getRemainingTime()}" cssClass="view"/>
									</td>
							
															
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>	
			</div>
		</div>
		<!-- end: YOUR CONTENT HERE -->
	</div>

	
	<script>
		InitHandlers();
		var startDate = $("#curr_date_abc").val(); //alert(startDate);
		var startTime = $("#curr_start_time").val(); //alert(startTime)
		
		//var time = startDate 
		
		var dateString = startDate.toString()+" "+startTime.toString();
	    dateTimeParts = dateString.split(' '),
	    timeParts = dateTimeParts[1].split(':'),
	    dateParts = dateTimeParts[0].split('-');
	    var date;
		date = new Date(dateParts[0], parseInt(dateParts[1], 10) - 1, dateParts[2], timeParts[0], timeParts[1]);

		console.log("::1::"+date.getTime()); //1379426880000
		console.log("::2::"+date);
		
		var spent_time=(new Date().getTime() - date.getTime());
		
		
		//console.log(msToTime(spent_time));
		$("#curr_remaining_time").val(msToTime(spent_time));
		
		
		var dt = new Date();
		var time = dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds();  //alert(time)
		
		var reamainingTime = new Date(time) - new Date(startTime); //alert(reamainingTime)

		
		
		
		InitDataTable("#task_sort_result");
		
		
		function msToTime(duration) {
			//console.log(duration);
	        var milliseconds = parseInt((duration%1000)/100)
	            , seconds = parseInt((duration/1000)%60)
	            , minutes = parseInt((duration/(1000*60))%60)
	            , hours = parseInt((duration/(1000*60*60))%24);

	        hours = (hours < 10) ? "0" + hours : hours;
	        minutes = (minutes < 10) ? "0" + minutes : minutes;
	        seconds = (seconds < 10) ? "0" + seconds : seconds;

	        return hours + ":" + minutes + ":" + seconds + "." + milliseconds;
	    }

		/* setInterval(function(){ alert(11)
            //$('#container').load('/noticeboard');
         }, 10000);  */
		
	</script>