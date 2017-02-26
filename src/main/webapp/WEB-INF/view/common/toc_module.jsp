<script type="text/javascript">
	if(!window.jQuery){window.location = "/?desturl=" + escape(window.location.href);}
</script>
<div class="wrap-content container" id="container">
	<section id="page-title" class="padding-top-15 padding-bottom-15">
		<div class="row">
			<div class="col-sm-7">
				<h1 class="mainTitle">${data.moduleDetail.getModShortName()}</h1>
				<span class="mainDescription">${data.moduleDetail.getModFullName()}</span>
			</div>
			<ol class="breadcrumb">
				<li>
					<span>${data.moduleDetail.getSuiteShortName()}</span>
				</li>
				<li class="active">
					<span>${data.moduleDetail.getModShortName()}</span>
				</li>
			</ol>
		</div>
	</section>
	<div class="container-fluid container-fullw bg-white">
		<div class="row">
			<div class="col-sm-7">
				<c:if test="${ data.privGroups.size() > 0}">
				<div class="row">
					<div class="col-sm-4">
						<a href="/toc?type=privgrp&currprivgrp=1&currmodcode=${data.moduleDetail.modCode}" data-ajax="true">
							<div class="text-bold">${data.privGroups.get(0).getPrivGrpName()}</div>
							<img src="assets/images/priv-group-1.jpg"/>
						</a>
					</div>
					<div class="col-sm-8 description1">
						
					</div>
				</div>
				</c:if>
				<br />
				<c:if test="${ data.privGroups.size() > 1}">
				<div class="row">
					<div class="col-sm-4">
						<a href="/toc?type=privgrp&currprivgrp=2&currmodcode=${data.moduleDetail.modCode}" data-ajax="true">
							<div class="text-bold">${data.privGroups.get(1).getPrivGrpName()}</div>
							<img src="assets/images/priv-group-2.jpg"/>
						</a>
					</div>
					<div class="col-sm-8 description2">
						
					</div>
				</div>
				</c:if>
				<br />
				<c:if test="${ data.privGroups.size() > 2}">
				<div class="row">
					<div class="col-sm-4">
						<a href="/toc?type=privgrp&currprivgrp=3&currmodcode=${data.moduleDetail.modCode}" data-ajax="true">
							<div class="text-bold">${data.privGroups.get(2).getPrivGrpName()}</div>
							<img src="assets/images/priv-group-3.jpg"/>
						</a>
					</div>
					<div class="col-sm-8 description3">
						
					</div>
				</div>
				</c:if>
			</div>
			<div class="col-sm-5">
				<img style="width:100%;" src="${data.moduleDetail.getModLogoPath()}">
			</div>
		</div>
	</div>
</div>

<script>
	InitHandlers();
	$(".description1").html(unescape('${data.moduleDetail.getModDescription1()}'));
	$(".description2").html(unescape('${data.moduleDetail.getModDescription2()}'));
	$(".description3").html(unescape('${data.moduleDetail.getModDescription3()}'));
</script>