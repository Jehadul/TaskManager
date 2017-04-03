<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cts" uri="/WEB-INF/custom.tld"%>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-10 padding-bottom-10">
		<div class="row">
			<div class="col-sm-8">
				<h1 class="mainTitle">Sprint Board</h1>
			</div>
			<ol class="breadcrumb padding-top-20">
				<li><span>Sprint Board</span></li>
				<li class="active"><span>Sprint Board UI</span></li>
			</ol>
		</div>
	</section>

	<div class="container-fluid container-fullw bg-white">
		<cts:AjaxForm action="#" dataHandler="showMessage">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			<div class="alert alert-block alert-danger hidden">
				Please check the fields marked with <span
					class="text-red fa fa-close"></span>.
			</div>

			<div class="row">
				<div class="col-6 col-sm-2">
				
				<fieldset>
									<legend>Stories&nbsp;&nbsp; 
									<button type="button" id="btnAddStories" class="btn btn-find"><span class="fa fa-plus"></span></button>	
									</legend>
									<div class="table-responsive">
					           			<table class="table table-striped table-hover" id=story_list>
						           			<thead>
												<tr>
													
													<th>Name</th>
													
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
				</fieldset>
				</div>
				<div class="col-6 col-sm-2"><fieldset>
									<legend>Tasks&nbsp;&nbsp; 
									<button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>	
									</legend>
				</fieldset>
				</div>
				<div class="col-6 col-sm-2"><fieldset>
									<legend>Progress&nbsp;&nbsp; 
									<button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>	
									</legend>
				</fieldset>
				</div>
				<div class="col-6 col-sm-2"><fieldset>
									<legend>Review&nbsp;&nbsp; 
									<button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>	
									</legend>
				</fieldset>
				</div>
				<div class="col-6 col-sm-2"><fieldset>
									<legend>QA&nbsp;&nbsp; 
									<button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>	
									</legend>
				</fieldset>
				</div>
				<div class="col-6 col-sm-2"><fieldset>
									<legend>Done&nbsp;&nbsp; 
									<button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>	
									</legend>
				</fieldset>
				</div>
			</div>




		</cts:AjaxForm>
	</div>
</div>
<script>

	InitHandlers();
	
	$("#btnAddStories").on("click",function(){
		ShowModal("/taskman/userstory/story/searchstory/?action_type_code=SELECT&actioncallback=loadUserStory");
	});


	var loadUserStory = function(data){ 
		var story = JSON.parse(unescape(data));
		var storyCode          = story.userStoryCode;   
		var storyName          = story.userStoryTitle;   
		var rows = $("#story_list tbody tr");
		
		for(var i = 0; i< rows.length; i++){
			var code = $(rows[i]).find("#code_"+i).attr("value");
	 		if(code == storyCode){
	 			ShowErrorMsg('Sprint Stories already in use');
	 			$(".alert").html(msg);
	 			$(".alert").removeClass("hidden");
			}
			
		}
		

			var html = '<tr>' +					
							'<td>'+ 
								'<input name="story_code[]" type="hidden" id="code_'+i+'" class="project_code view" value="' + storyCode + '" />' +
							 
								'<input name="story_name[]" type="text" class="project_name view"  value="' + storyName + '" />' +
							'</td>'
							
						'</tr>';
					
			$("#story_list tbody").append(html);
			i++;
		
		HideModal('search-modal');	
	};
	
</script>