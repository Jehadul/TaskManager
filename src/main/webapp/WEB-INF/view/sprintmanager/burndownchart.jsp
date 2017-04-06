<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Burndown Chart</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Sprint</span></li>
				<li class="active"><span>Burndown Chart</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">

		<div id="burndown"></div>
	</div>
</div>

<script src="/assets/js/highcharts.js"></script>

<script>
var map = '${map}';
var jsonMap = JSON.parse(map);
var burnData = [jsonMap.allDayremaingTime];
var chartDays = [jsonMap.days];
var days = [];
var burnValues = [];

var c =0;
var cc =0;
for(var i = 0; i<chartDays.length; i++){
	for(var j =0; j<chartDays[i].length; j++){
		days[j]=chartDays[i][j];
	}	 
}
for(var i = 0; i<burnData.length; i++){
	for(var j =0; j<burnData[i].length; j++){
		burnValues[j]=burnData[i][j];
	}	 
}
console.log(burnValues);

$(function () {
	  $('#burndown').highcharts({
	    title: {
	      text: 'Burndown Chart',
	      x: -20 //center
	    },
	    colors: ['blue', 'red'],
	    plotOptions: {
	      line: {
	        lineWidth: 3
	      },
	      tooltip: {
	        hideDelay: 200
	      }
	    },
	    subtitle: {
	      text: 'Sprint 1',
	      x: -20
	    },
	    xAxis: {
	       /* categories: ['Day 1', 'Day 2', 'Day 3', 'Day 4', 'Day 5', 'Day 6',
	                   'Day 7', 'Day 8', 'Day 9', 'Day 10', 'Day 11', 'Day 12'] */
	    	categories: days
	    },
	    yAxis: {
	      title: {
	        text: 'Hours'
	      },
	      plotLines: [{
	        value: 0,
	        width: 1
	      }]
	    },
	    tooltip: {
	      valueSuffix: ' hrs',
	      crosshairs: true,
	      shared: true
	    },
	    legend: {
	      layout: 'vertical',
	      align: 'right',
	      verticalAlign: 'middle',
	      borderWidth: 0
	    },
	    series: [{
	      name: 'Ideal Burn',
	      color: 'rgba(255,0,0,0.25)',
	      lineWidth: 2,
	      data: [110, 100]
	    	//data: burnValues
	    }, {
	      name: 'Actual Burn',
	      color: 'rgba(0,120,200,0.75)',
	      marker: {
	        radius: 6
	      },
	      //data: [100, 110, 125, 95, 64, 76, 62, 44, 35, 29, 18, 2]
	      //data: burnValues
	    }]
	  });
	});
	//console.log(days);
</script>
<style>
#burndown {
	width: 600px;
	min-width: 310px;
	height: 250px;
	margin: 0 auto;
}
</style>