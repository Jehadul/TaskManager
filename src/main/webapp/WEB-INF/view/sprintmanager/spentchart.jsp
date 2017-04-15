<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>


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
		<div id="spentChart"></div>
	</div>
</div>
<script src="/assets/js/highcharts.js"></script>
<script>
	InitHandlers();
	var mapAll = ${map};
	var spenttimeAndDays = mapAll.spenttime;
	
	var spentDays = [];
	var spTime = [];
	for (var i = 0; i < spenttimeAndDays.length; i++) {
		for (var j = 0; j < spenttimeAndDays[i].length; j++) {
			if (j == 0) {
				spentDays[i] = spenttimeAndDays[i][j];
				//console.log(spenttimeAndDays[i][j]);
			} else {
				spTime[i] = spenttimeAndDays[i][j];
				//console.log(spenttimeAndDays[i][j]);
			}

		}

	}
	console.log(spTime);
	var sp = mapAll.sprint;
	var chart = Highcharts.chart('spentChart', {
		 chart: {
		     backgroundColor: '#fff',
		     polar: true,
		     type: 'line'
		  },
		title : {
			text : ''
		},

		subtitle : {
			
			text: ''
			
			
		},

		xAxis : {
			/* categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul',
					'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ] */
			categories: spentDays,
			 title: {
		            text: 'Spent Days'
		        }
		},
		
		 yAxis: {
		        title: {
		            text: 'Spent Hours'
		        }

		    },
		    credits: {
			      enabled: false
			  },

		series : [ {
			type : 'column',
			title: 'Spent Hours',
			
			colorByPoint : true,
			/* data : [ 29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5,
					216.4, 194.1, 95.6, 54.4 ],  */
			   name: 'Spent Hours',
			   data : spTime,
			showInLegend : false
		} ]
		
		
		

	});
	

	/* $('#plain').click(function() {
		chart.update({
			chart : {
				inverted : false,
				polar : false
			},
			subtitle : {
				text : 'Plain'
			}
		});
	});

	$('#inverted').click(function() {
		chart.update({
			chart : {
				inverted : true,
				polar : false
			},
			subtitle : {
				text : 'Inverted'
			}
		});
	}); */

	/* $('#polar').click(function() {
		chart.update({
			chart : {
				inverted : false,
				polar : true
			},
			subtitle : {
				text : 'Polar'
			}
		});
	});
	 */
	
	var sp = mapAll.sprint;
	console.log(sp);
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
							+' <td>'+sp[0].sprintName+'</td>'
							+' <td>'+sp[0].sprintCode+'</td>'
							+' <td>'+sp[0].startDate+'</td>'
							+' <td>'+sp[0].endDate+'</td>'
						+'</tr>'
					+'</tbody>'
					+' </table>';
			$("#spentCharttext").append(html);
</script>

<style>
	#spentChart {
    height:400px;
    width:900px;
    margin-right:100px;
    position:relative;
}
</style>