<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>

<script>
if(!window.jQuery){window.location = "/?desturl=" + window.location.href;} 
</script>

 <div class="wrap-content">
	<!-- start: PAGE TITLE -->
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Search Sprint User Story</h1>
			</div>
		</div>
	</section>
	<!-- end: PAGE TITLE -->
	<div class="container-fluid">
		<c:choose>
			<c:when test="${data.action_type_code != 'CREATE'}">
			<form method="POST" class="ajax" data-handler="PopulateSearch" action="/taskman/tman/sprint/sprintstorysearch">
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}"/>
		<div class="form-group">
			<div class="row">
				<div class="col-md-3">
					<cts:Label labelFor="sprint_code" name="Sprint Name"/>
				</div>
				<div class="col-md-9">
					<cts:Hidden name="sprint_name"/>
										<cts:Select list="${data.sprintCodes}" name = "sprint_code" value="${data.sprintCode}"/>
					
				</div>
			</div>	
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-md-3">
					<cts:Label labelFor="story_code" name="Story Code"/>
				</div>
				<div class="col-md-9">
					<cts:TextBox name="story_code"/>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-md-3">
					<cts:Label labelFor="story_name" name="Story Name"/>
				</div>
				<div class="col-md-9">
					<cts:TextBox name="story_name"/>
				</div>
			</div>	
		</div>
		<div class="row margin-top-10">
			<div class="col-md-12">
				<div class="col-md-12">
					<button type="submit" class="btn btn-search pull-right">
						<span class="fa fa-search">Search</span>
					</button>
				</div>
			</div>
		</div>	
		</form>
		</c:when>
		<c:otherwise>
		<div class="row" >
			<div class="col-md-12">
				<cts:Button name=" New" cssClass="new pull-right" spanClass="plus" dAjax="true" dHref="/taskman/tman/sprint/create"/>	
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		<div class="searchresult"></div>
	</div>

</div>
<script>
	function PopulateSearch(data, mode) {
		console.log(data);
		if (mode == "success") {
			mode = "doc";
		}
		
		$('.searchresult').text("");
    	var action = GetParameterByName(modalUrl, 'action_type_code');
    	var html = '<div class="table-responsive">';
        html += '   	<table class="table table-striped table-hover" id="sprint_search_result">';
        html += '   		<thead>';
		html += '				<tr>';
		html += '					<th>Story Code</th>';
		html += '					<th>Story Title</th>';
		html += '					<th>&nbsp;</th>';
		html += '				</tr>'
		html += '			</thead>';
		html += '			</tbody>';
    	for (var i = 0; i < data.length;  i++) {
    		html += '			<tr><td><a href="/taskman/tman/sprint/show/'+data[i].sprintStoryCode +'?mode=' + mode + '" data-ajax="true">' + data[i].sprintStoryCode + '</a></td>';
    		html += '				<td>' + data[i].sprintStoryName + '</td>';
    		html += '				<td>' + '<input type = "hidden" name="sprint_id" value = "'+data[i].sprintId+'"/>'+ '</td>';
    		html += '				<td>';
    		if (action == "SELECT") {
    			var actionCallback = GetParameterByName(modalUrl, 'actioncallback'); 
	    		html += '              	<a href="#" onclick="' + actionCallback + '(\'' + escape(JSON.stringify(data[i])) + '\');">' ;
	    		html += '			    Select</a>';
			}
    		if (!data[i].is_locked) {
    			if (action == "CREATE" || action == "EDIT") {
	    			html += '              	<a href="/taskman/tman/sprint/edit/' + data[i].sprintStoryName + '?mode=' + mode + '"';
	    			html += '			    	class="btn btn-edit btn-sm" data-ajax="true"><span class="fa fa-edit"></span></a>';
	    		}
			}
    		html += '				</td>' 
    		html += '			</tr>';
    	};
		html += '			</tbody>';
    	html += '	</table>';
    	html += '</div>';
    	$('.searchresult').append(html);
    	InitDataTable("#sprint_search_result");
    	InitHandlers();
    }

	InitHandlers();
</script> 