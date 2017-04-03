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
var a = '${map}';
var myjson = JSON.parse(a);
var date = [myjson.dateLi];
var rhours=[myjson.doubleLi];
var st= null;

console.log(date);
console.log(rhours);
var dt=new Date();
dt.setDate(dt.getDate()+1);
var n = dt.toLocaleDateString();

var newChar="-";
var ndate=n.split("/").join(newChar);
console.log(n);
console.log(ndate);
function drawChart() {
	   // Define the chart to be drawn.
	   
	   var data = new google.visualization.DataTable();
	   data.addColumn('string', 'Day');
	   data.addColumn('number', 'Burn Hours');
	   data.addColumn({type: 'string', role:'style'});
	   for(var i=0; i<date.length; i++){
		   console.log(date[i]);
		   console.log(rhours[i]);
		   for (var j=i; j<date[i].length; j++){
			   console.log(date[i][j]);
			   console.log(rhours[i][j]);
			   
			   if(ndate == date[i][j]){
				   st = 'point { visible: false; }';
			   }
				data.addRow([date[i][j], rhours[i][j], st]);
		   }
		}
	   	  
	 
	   // Set chart options
	   var options = {'title' : 'Burndown Chart',
	      hAxis: {
	         title: 'Dates'
	         
	      },
          bar: {groupWidth: '30%'},

	      vAxis: {
	         title: 'Burn Hours',
	         maxValue: rhours[0],
	         minValue: 0,
	      	 gridlines: { count: 6 }
	      },   
	      'width':800,
	      'height':400,
	      pointsVisible: true
	   };

	   // Instantiate and draw the chart.
	   var chart = new google.visualization.LineChart(document.getElementById('container'));
	   options.hAxis.format = 'MMM dd, yyyy'
	   options.vAxis.format = 'decimal'
	   chart.draw(data, options);
	}	
	google.charts.setOnLoadCallback(drawChart);
	
</script>