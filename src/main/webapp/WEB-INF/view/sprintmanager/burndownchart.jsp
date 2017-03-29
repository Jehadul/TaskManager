<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Burndown Chart</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li>
					<span>Sprint</span>
				</li>
				<li class="active">
					<span>Burndown Chart</span>
				</li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
		
	</div>
</div>

<script src="/assets/js/loader.js"></script>
 <script type="text/javascript">
     google.charts.load('current', {packages: ['corechart','line']});  
  </script>
<script>
function drawChart() {
	   // Define the chart to be drawn.
	   
	   var data = new google.visualization.DataTable();
	   data.addColumn('number', 'Date');
	   data.addColumn('number', 'Burn Hours');
	   data.addRows([
	                 [1, 24],   [2, 18],  [3, 15],  [4, 12],  [5, 10],  [6, 0]
	               ]);
	   
	   // Set chart options
	   var options = {'title' : 'Burndown Chart',
	      hAxis: {
	         title: 'Days'
	      },
	      vAxis: {
	         title: 'Hours'
	      },   
	      'width':800,
	      'height':400,
	      pointsVisible: true	  
	   };

	   // Instantiate and draw the chart.
	   var chart = new google.visualization.LineChart(document.getElementById('container'));
	   chart.draw(data, options);
	}	
	google.charts.setOnLoadCallback(drawChart);
	
</script>