<script type="text/javascript">
	if(!window.jQuery){window.location = "/?desturl=" + escape(window.location.href);}
</script>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-15 padding-bottom-15">
		<div class="row">
			<div class="col-sm-7">
				<h1 class="mainTitle">${suiteDetail.getSuiteShortName()}</h1>
				<span class="mainDescription">${suiteDetail.getSuiteFullName()}</span>
			</div>
			<ol class="breadcrumb">
				<li class="active">
					<span>${suiteDetail.getSuiteShortName()}</span>
				</li>
			</ol>
		</div>
	</section>
	<div class="container-fluid container-fullw bg-white">
		<div class="row">
			<div class="col-sm-6 description">
				
			</div>
			<div class="col-sm-6">
				<img style="width:100%;" src="${suiteDetail.getSuiteLogoPath()}">
			</div>
		</div>
	</div>
</div>
<script>
	InitHandlers();
	$(".description").html(unescape('${suiteDetail.getSuiteDescription()}'));

</script>