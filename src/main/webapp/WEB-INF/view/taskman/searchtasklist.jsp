<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	if(!window.jQuery){window.location = "/?desturl=" + window.location.href;}
</script>
<div class="wrap-content">
	<!-- start: PAGE TITLE -->
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Search Branch</h1>
			</div>
		</div>
	</section>
	<!-- end: PAGE TITLE -->
	<div class="container-fluid">
		<c:choose>
			<c:when test="${data.action_type_code != 'CREATE'}">
				<form action="/taskman/tman/tasks/tasklistsearch" method="post"
					class="ajax" data-handler="PopulateSearch" >
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}"/>
					<div class="form-group">
						<div class="row">
							<div class="col-md-4 control-label">Task Title</div>
							<div class="col-md-8">
								<input name="task_title" class="form-control" type="text" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-4 control-label">Assignee</div>
							<div class="col-md-8">
								<input name="asignee" class="form-control" type="text" />
							</div>
						</div>
					</div>
					<div class="row margin-top-10">
						<div class="col-md-12">
							<button type="submit" class="btn btn-search pull-right">
								<span class="fa fa-search"> Search</span>
							</button>
						</div>
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col-md-12">
						<button type="submit" data-ajax="true" data-href="/taskman/tman/tasks/tasklist"
							class="btn btn-new pull-right">
							<span class="fa fa-plus"> New</span>
						</button>
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
		html += '   	<table class="table table-striped table-hover" id="task_list_search_result">';
		html += '   		<thead>';
		html += '				<tr>';
		html += '					<th>Task Title</th>';
		html += '					<th>Asignee</th>';			
		html += '					<th>&nbsp;</th>';
		html += '				</tr>'
		html += '			</thead>';
		html += '			<tbody>';
		for (var i = 0; i < data.length; i++) { //alert(data[i].title)
			html += '			<tr><td><a href="/taskman/tman/tasks/show/' + data[i].id +'" data-ajax="true">' + data[i].taskTitle
					+ '</a></td>';
			html += '				<td>' + data[i].asignee + '</td>';
			html += '				<td>';
			if (action == "SELECT") {
				var actionCallback = GetParameterByName(modalUrl,
						'actioncallback');
				html += '              	<a href="#" onclick="' + actionCallback
						+ '(\'' + escape(JSON.stringify(data[i])) + '\');">';
				html += '			    Select</a>';
			}
			if (!data[i].isLocked) {
				if (action == "CREATE" || action == "EDIT") {
					html += '<a href="/taskman/tman/tasks/edit/' +data[i].id +'"';
					html += 'class="btn btn-edit btn-sm" data-ajax="true"><span class="fa fa-edit"></span></a>';
				}
			}
			html += '</td>'
			html += '</tr>';
		}
		;
		html += '			</tbody>';
		html += '	</table>';
		html += '</div>';
		$('.searchresult').append(html);
		InitDataTable("#task_list_search_result");
		InitHandlers();
		
		
		
	}

	InitHandlers();
</script>

