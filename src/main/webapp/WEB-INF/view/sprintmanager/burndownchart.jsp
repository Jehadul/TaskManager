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
		
		 <div id="chart_div" style="width: 900px; height: 500px"></div>
	</div>
</div>

<script src="/assets/js/loader.js"></script>
 
<script>
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawBackgroundColor);
 var map = '${map}';
 var jsonMap = JSON.parse(map);
 var chartData = [jsonMap.allDayremaingTime];
 console.log(map);
function drawBackgroundColor() {
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'days');
      data.addColumn('number', ''); 
      for(var i = 0; i<chartData.length; i++){
    	  for(var j=i; j<chartData[i].length;j++){
    		  data.addRows([chartData[i][j]]);
    	  }
    } 
     // data.addRows([["1",50]]);
      

      var options = {
        hAxis: {
          title: 'Days'
        },
        vAxis: {
          title: 'Remaining Hours'
        },
        backgroundColor: '#f1f8e9'
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }	
</script>