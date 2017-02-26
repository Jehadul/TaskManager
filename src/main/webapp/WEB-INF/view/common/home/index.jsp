<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../header.jsp" %>
	<div class="container-fluid container-fullw bg-gray">
		<div class="loading">
			<img src="/assets/images/loading.gif" />
		</div>
	</div>
<%@include file="../../footer.jsp" %>

<script type="text/javascript">
	var destUrl = GetParameterByName(window.location.href, "desturl");
	if (!destUrl || destUrl == "/" || destUrl == "home" || destUrl == "/home") {
		destUrl = "/noticeboard";
	}
	setTimeout(function(){
		if(destUrl.indexOf("/search")>-1){
			
			ShowModal(destUrl);
		}
		else{
			
			LoadMainContent(destUrl);
			
		}
	}, 300);
</script>