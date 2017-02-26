<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	if(!window.jQuery){window.location = "/?desturl=" + escape(window.location.href);}
</script>
<div class="wrap-content container" id="container">
	<c:if test="${!currPrivs.isEmpty()}">
	<section id="page-title" class="padding-top-15 padding-bottom-15">
		<div class="row">
			<div class="col-sm-7">
				<h1 class="mainTitle">${currPrivs[0].modShortName}</h1>
				<span class="mainDescription">${currPrivs[0].privGrpName}</span>
			</div>			
			<ol class="breadcrumb">
				<li>
					<span>${currPrivs[0].suiteShortName}</span>
				</li>
				<li>
					<span>${currPrivs[0].modShortName}</span>
				</li>
				<li class="active">
					<span>${currPrivs[0].privGrpName}</span>
				</li>
			</ol>
		</div>
	</section>
	<!-- end: TITLE -->
	<div class="container-fluid container-fullw">
		<div class="panel-group accordion" id="accordion">
			<c:set var="prevLinkGroup" value=""/>
			<c:set var="nextLinkGroup" value=""/>
			<c:forEach var="i" begin="0" end="${currPrivs.size()-1}">
				<c:if test="${!currPrivs[i].linkGroupCode.equals(prevLinkGroup)}">
				<div class="panel"> 
					<div class="panel-heading"> 
						<h6 class="panel-title"> 
							<a class="accordion-toggle bg-transparent height-30 padding-top-5" data-toggle="collapse" data-parent="#accordion" href="#block${currPrivs[i].linkGroupCode}">
								<i class="icon-arrow"></i> 
								<span>${currPrivs[i].linkGroupName}</span> 
							</a> 
						</h6> 
					</div> 
					<div id="block${currPrivs[i].linkGroupCode}" class="panel-collapse collapse"> 
						<div class="panel-body padding-left-0"> 
				</c:if>
				<c:choose>
					<c:when test="${currPrivs[i].pageLink.indexOf(\"search\")>=0}">
						<c:set var="data" value="data-modal='true'"/>
					</c:when>
					<c:otherwise>
						<c:set var="data" value="data-ajax='true'"/>
					</c:otherwise>
				</c:choose>

				<span class="links cl-effect-1">
					<a class="col-md-4" href="${currPrivs[i].pageLink}" ${data}>
						${currPrivs[i].privName}
					</a>
				</span>
				<c:choose>
					<c:when test="${i < currPrivs.size() - 1}">
						<c:set var="nextLinkGroup" value="${currPrivs[i + 1].linkGroupCode}"/>
					</c:when>
					<c:otherwise>
						<c:set var="nextLinkGroup" value=""/>
					</c:otherwise>
				</c:choose>
				<c:if test="${!currPrivs[i].linkGroupCode.equals(nextLinkGroup)}">
						</div>
					</div> 
				</div>
				</c:if>
				<c:set var="prevLinkGroup" value="${currPrivs[i].linkGroupCode}"/>
			</c:forEach>
		</div>
	</div>
	</c:if>	
	<c:if test="${currPrivs.isEmpty()}">
	<div class="text-red margin-top-10">You do not have any access in this group.</div>
	</c:if>
</div>

<script>
	InitHandlers();
</script>