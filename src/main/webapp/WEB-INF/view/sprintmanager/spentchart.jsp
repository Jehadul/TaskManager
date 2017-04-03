<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<script type="text/javascript">
	
</script>

<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Sprint Hour Spent Chart</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Sprint</span></li>
				<li class="active"><span>Sprint Spent Chart</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<div class="row"><div id="spentCharttext" class="center-block"></div></div>
		<div class="col-md-6" id="spentChart"></div>
	</div>
</div>
<script src="/assets/js/loader.js"></script>
<script>
	InitHandlers();
	var mapAll = ${map};
	var map = mapAll.chart;
	console.log(mapAll);

	google.charts.load('current', {
		packages : [ 'corechart' ]
	});
	function drawChart() {
		// Define the chart to be drawn.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Topping',{ role: 'style' }, { role: 'annotation' } );
		data.addColumn('number', 'Slices');	
		 data.addColumn({type: 'string', role: 'annotation'});
		 data.addRows(map);
		 var options = {
				// title: 'Spent Chart',
			       width: 800,
			       height: 400,
			       legend: 'none',
			       chartArea:{left:0,top:0,width:"100%",height:"100%"},
			       colors: ['#1b9e77', '#d95f02', '#7570b3'],
			       chartArea: {
			    	    backgroundColor: {
			    	        stroke: '#eaeaea',
			    	        strokeWidth: 3
			    	    }
			    	},
			       bar: {groupWidth: '50%'},
			       animation:{
			           duration: 1000,
			           easing: 'out',
			           startup: true
			         },
			       vAxis: { 
			             title :'Task list',
			             minValue:0, maxValue:10,
			             gridlines: { count: 1 } 
			              },
			      hAxis: {
			           viewWindow: {
	            	        min: 0,
	            	        max: 10
			            },
			            ticks: [1, 2, 3, 4, 5,6,7,8,9,10] // display labels every 25
			           
			       }
			     };

		// Instantiate and draw the chart.
		var chart = new google.visualization.BarChart(document
				.getElementById('spentChart'));
		chart.draw(data, options);
	}
	google.charts.setOnLoadCallback(drawChart);
	var sp = mapAll.sprint;
	var html = '<table class="table table-bordered info">'
					+'<thead>'
						+'<tr>'
							+' <th>Sprint Title</th>'
							+' <th>Sprint Code</th>'
							+' <th>Sprint start date</th>'
							+' <th>Sprint end date</th>'
						+'</tr>'
					+'</thead>'
					+'<tbody>'
						+'<tr>'
							+' <td>'+sp[0][0]+'</td>'
							+' <td>'+sp[0][1]+'</td>'
							+' <td>'+sp[0][3]+'</td>'
							+' <td>'+sp[0][4]+'</td>'
						+'</tr>'
					+'</tbody>'
					+' </table>';
			$("#spentCharttext").append(html);
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
</script>