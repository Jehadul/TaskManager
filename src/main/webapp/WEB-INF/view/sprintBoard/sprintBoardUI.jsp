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
									<button type="button" class="btn btn-find"><span class="fa fa-plus"></span></button>	
									</legend>
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

	
</script>