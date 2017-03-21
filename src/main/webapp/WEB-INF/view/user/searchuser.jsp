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
				<h1 class="mainTitle">Search User</h1>
			</div>
		</div>
	</section>
	<!-- end: PAGE TITLE -->
	<div class="container-fluid">
		<c:choose>
			<c:when test="${data.action_type_code != 'CREATE'}">
				<form method="POST" class="ajax" data-handler="PopulateSearch" action="/ac/user/userSearch">
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}"/>
		<div class="form-group">
			<div class="row">
				<div class="col-md-3">
					<cts:Label labelFor="emp_code" name="Employee Code"/>
				</div>
				<div class="col-md-9">
					<cts:TextBox name="emp_code"/>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-md-3">
					<cts:Label labelFor="username" name="User Name"/>
				</div>
				<div class="col-md-9">
					<cts:TextBox name="username"/>
				</div>
			</div>	
		</div>
		<div class="row margin-top-10">
			<div class="col-md-12">
				<cts:Submit cssClass="search pull-right" spanClass="search" name="Search"/>
			</div>
		</div>	
		</form>
		</c:when>
		<c:otherwise>
		<div class="row" >
			<div class="col-md-12">
				<cts:Button name=" New" cssClass="new pull-right" spanClass="plus" dAjax="true" dHref="user/create"/>	
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		<div class="searchresult"></div>
	</div>

</div>
<script>
	function PopulateSearch(data, mode) {
		if (mode == "success") {
			mode = "doc";
		}
		$('.searchresult').text("");
    	var action = GetParameterByName(modalUrl, 'action_type_code');
    	var html = '<div class="table-responsive">';
        html += '   	<table class="table table-striped table-hover" id="user_search_result">';
        html += '   		<thead>';
		html += '				<tr>';
		html += '					<th>Code</th>';
		html += '					<th>Name</th>';
		html += '					<th>&nbsp;</th>';
		html += '				</tr>'
		html += '			</thead>';
		html += '			</tbody>';
    	for (var i = 0; i < data.length;  i++) {
    		html += '			<tr><td><a href="user/show/'+data[i].id +'?mode=' + mode + '" data-ajax="true">' + data[i].empCode + '</a></td>';
    		html += '				<td>' + data[i].empName + '</td>';
    		html += '				<td>';
    		if (action == "SELECT") {
    			var actionCallback = GetParameterByName(modalUrl, 'actioncallback'); 
	    		html += '              	<a href="#" onclick="' + actionCallback + '(\'' + escape(JSON.stringify(data[i])) + '\');">' ;
	    		html += '			    Select</a>';
			}
    		if (!data[i].is_locked) {
    			if (action == "CREATE" || action == "EDIT") {
	    			html += '              	<a href="user/edit/' + data[i].id + '?mode=' + mode + '"';
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
    	InitDataTable("#user_search_result");
    	InitHandlers();
    }

	InitHandlers();
</script>