<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="cts" uri="/WEB-INF/custom.tld" %>
<!DOCTYPE html>
<!-- Template Name: Clip-Two - Responsive Admin Template build with Twitter Bootstrap 3.x | Author: ClipTheme -->
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
	<!--<![endif]-->
	<!-- start: HEAD -->
	<head>
		<title>CTrends ERP</title>
		
		<!-- start: META -->
		<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta content="" name="description" />
		<meta content="" name="author" />
		<!-- end: META -->
		<link rel="stylesheet" href="assets/css/googlefonts.css" type="text/css" />
		<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="vendor/themify-icons/themify-icons.min.css">
		<link rel="stylesheet" href="vendor/animate.css/animate.min.css" media="screen">
		<link rel="stylesheet" href="vendor/perfect-scrollbar/perfect-scrollbar.min.css" media="screen">
		<link rel="stylesheet" href="vendor/switchery/switchery.min.css" media="screen">
		<link rel="stylesheet" href="assets/css/styles.css">
		<link rel="stylesheet" href="assets/css/common.css">
		<link rel="stylesheet" href="assets/css/plugins.css">
		<link rel="stylesheet" href="assets/css/themes/${data.emp.uiTheme == null ? "theme-1" :  data.emp.uiTheme }.css" id="skin_color" />
		<link rel="stylesheet" href="vendor/DataTables/css/DT_bootstrap.css" media="screen">
		<link rel="stylesheet" href="vendor/sweetalert/sweet-alert.css" media="screen">
		<link rel="stylesheet" href="vendor/sweetalert/ie9.css" media="screen">
		<link rel="stylesheet" href="vendor/toastr/toastr.min.css" media="screen">
		<link rel="stylesheet" href="vendor/bootstrap-datepicker/bootstrap-datepicker3.standalone.min.css" media="screen">
		<link rel="stylesheet" href="vendor/bootstrap-timepicker/bootstrap-timepicker.min.css" media="screen">
		<link rel="stylesheet" href="vendor/bootstrap-fileinput/jasny-bootstrap.min.css" media="screen">	
		
		<link href="vendor/jstree/themes/default/style.min.css" rel="stylesheet" media="screen">
		
		<!-- start: CSS REQUIRED FOR Calendar PAGE ONLY -->
		<link href="vendor/fullcalendar/fullcalendar.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<!-- end: CSS REQUIRED FOR Calendar PAGE ONLY -->
	</head>
	<!-- end: HEAD -->
	<body>
		<div id="app">
			<!-- sidebar -->
			<div class="sidebar app-aside" id="sidebar">
				<div class="sidebar-container perfect-scrollbar">
					<nav>
						<!-- start: SEARCH FORM -->
						<div class="search-form">
							<a class="s-open" href="#">
								<i class="ti-search"></i>
							</a>
							<form action="/tcodesearch" method="post" class="ajax navbar-form" data-handler="processTcode" >
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<div class="form-group">
									<input type="text" id="tcode" class="form-control" placeholder="Enter T Code..." name="tcode"/>	
									<button type="submit" class="btn tcode-search"><span class="ti-search"></span></button>
								</div>
							</form>
						</div>
						<!-- end: SEARCH FORM -->
						<!-- start: MAIN NAVIGATION MENU -->
						<ul class="main-navigation-menu" style="margin-top:0px;">
						<!-- <a href="google.com" >abcfvvvvvvvvvvv</a> -->
						<c:forEach var="suite" items="${data.empSuites}">
							<li>
								<a href="toc?type=suite&amp;currsuitecode=${ suite.getSuiteCode() }" class="submenu">
									<div class="item-content">
										<div class="item-media">
											<i class="${ suite.getSuiteIcon()}"></i>
										</div>
										<div class="item-inner">
											<span class="title">${ suite.getSuiteShortName() }</span><i class="icon-arrow"></i>
										</div>
									</div>
								</a>
								<ul class="sub-menu">
<!-- layer 2 -->
								<c:forEach var="module" items="${data.empModules}">
									<c:if test="${ suite.getSuiteCode() == module.getSuiteCode() }">
									<li>
										<a href="toc?type=module&amp;currmodcode=${module.getModCode()}" class="submenu">
											<div class="item-content">
												<div class="item-media">
													<i class="${ module.getModuleIcon()} "></i>
												</div>
												<div class="item-inner">
													<span class="title">${ module.getModShortName() }</span><i class="icon-arrow"></i>
												</div>
											</div>
										</a>
										<ul class="sub-menu">
										<c:forEach var="privgrp" items="${data.empPrivGroups}">
											<c:if test="${module.getModCode() == privgrp.getModCode()}">
											<li>
												<a href="toc?type=privgrp&amp;currprivgrp=${ privgrp.getPrivGrpCode() }&amp;currmodcode=${ module.getModCode() }" data-ajax="true">
													<i class="ti-minus"></i>&nbsp;<i class="title">${ privgrp.getPrivGrpName() }</i>
												</a>
											</li>
											</c:if>
										</c:forEach>
										</ul>
									</li>
									</c:if>
								</c:forEach>
<!-- layer 2 ends -->
								</ul>

							</li>
						</c:forEach>
						</ul>
						<!-- end: MAIN NAVIGATION MENU -->						
					</nav>
				</div>
			</div>
			<!-- / sidebar -->-
			<div class="app-content">
				<!-- start: TOP NAVBAR -->
				<header class="navbar navbar-default navbar-static-top">
					<!-- start: NAVBAR HEADER -->
					<div class="navbar-header">
						<a href="#" class="sidebar-mobile-toggler pull-left hidden-md hidden-lg" class="btn btn-navbar sidebar-toggle" data-toggle-class="app-slide-off" data-toggle-target="#app" data-toggle-click-outside="#sidebar">
							<i class="ti-align-justify"></i>
						</a>
						<a class="navbar-brand" href="#">
							<img src="assets/images/logo.png" class="ctrends-logo" alt="CTrends Software and Services"/>
						</a>
						<a href="#" class="sidebar-toggler pull-right visible-md visible-lg" data-toggle-class="app-sidebar-closed" data-toggle-target="#app">
							<i class="ti-align-justify"></i>
						</a>
						<a class="pull-right menu-toggler visible-xs-block" id="menu-toggler" data-toggle="collapse" href=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<i class="ti-view-grid"></i>
						</a>
					</div>
					<!-- end: NAVBAR HEADER -->
					<!-- start: NAVBAR COLLAPSE -->
					<div class="navbar-collapse collapse">
						<div class="col-md-auto"><img class="margin-top-8" width="80" height="50" src="assets/logo/CTS.png" /></div>
						<div class="col-md-auto"><h4 class="margin-top-25">CTrends Software and Services</h4></div>
						<div class="col-md-auto pull-right">
							<ul class="nav navbar-right">
								<!-- start: MESSAGES -->
								<li class="dropdown">
									<a href="common/message/inbox" data-ajax="true">
										<span class="dot-badge partition-red"></span> <i class="ti-comment"></i> <span>MESSAGES</span>
									</a>
								</li>
								<!-- end: MESSAGES -->
								<!-- start: Helpdesk -->
								<li class="dropdown">
									<a href="helpdesk" data-ajax="true">
										<span class="dot-badge partition-red"></span> <i class="fa fa-question-circle"></i> <span>HELPDESK</span>
									</a>
								</li>
								<!-- end: Helpdesk -->								
								<!-- start: ACTIVITIES DROPDOWN -->
								<li class="dropdown">
									<a href class="dropdown-toggle" data-toggle="dropdown">
										<i class="ti-check-box"></i> <span>ACTIVITIES</span>
									</a>
									<ul class="dropdown-menu dropdown-light dropdown-messages dropdown-large">
										<li>
											<span class="dropdown-header"> You have new notifications</span>
										</li>
										<li>
											<div class="drop-down-wrapper ps-container">
												<div class="list-group no-margin">
													<a class="media list-group-item" href="">
														<img class="img-circle" alt="..." src="assets/images/avatar-1.jpg">
														<span class="media-body block no-margin"> Use awesome animate.css <small class="block text-grey">10 minutes ago</small> </span>
													</a>
													<a class="media list-group-item" href="">
														<span class="media-body block no-margin"> 1.0 initial released <small class="block text-grey">1 hour ago</small> </span>
													</a>
												</div>
											</div>
										</li>
										<li class="view-all">
											<a data-ajax="true" href="noticeboard/create">
												Post Notice
											</a>
										</li>
									</ul>
								</li>
								<!-- end: ACTIVITIES DROPDOWN -->
								<!-- start: USER OPTIONS DROPDOWN -->
								<li class="dropdown current-user">
									<a  class="dropdown-toggle" data-toggle="dropdown">
										<img src="assets/photo/${data.emp.username}.jpg" alt="${data.emp.empName}" height="45px" width="45px">
										<span class="username">${data.emp.empName}<i class="ti-angle-down"></i></span>
									</a>
									<ul class="dropdown-menu dropdown-dark">
										<li>
											<a href="hrm/ed/employee/show/' + ${data.emp.id} + '/doc" data-ajax="true">
												My Profile  
											</a>
										</li>
										<li>
											<a href="#" id="lock">
												Lock Screen
											</a>
										</li>
										<li>
											<sec:authorize access="hasRole('ROLE_USER')">
												<!-- For login user -->
												<c:url value="/logout" var="logoutUrl" />
												<form action="${logoutUrl}" method="post" id="logoutForm">
													<input type="hidden" name="${_csrf.parameterName}"
														value="${_csrf.token}" />
												</form>
												<script>
													function formSubmit() {
														LoadMainContent("");
														document.getElementById("logoutForm").submit();
													}
												</script>
										
												<c:if test="${pageContext.request.userPrincipal.name != null}">
													<h2>
														<a href="javascript:formSubmit()"> Log out</a>
													</h2>
												</c:if> 
											</sec:authorize>
								<!-- 			<a href="/logout">
												Log Out
											</a> -->
										</li>
									</ul>
								</li>
								<!-- end: USER OPTIONS DROPDOWN -->
							</ul>
							<!-- start: MENU TOGGLER FOR MOBILE DEVICES -->
							<div class="close-handle visible-xs-block menu-toggler" data-toggle="collapse" href=".navbar-collapse">
								<div class="arrow-left"></div>
								<div class="arrow-right"></div>
							</div>
							<!-- end: MENU TOGGLER FOR MOBILE DEVICES -->
						</div>
					</div>
					<a class="dropdown-off-sidebar" data-toggle-class="app-offsidebar-open" data-toggle-target="#app" data-toggle-click-outside="#off-sidebar" onclick="msgCount(this)">
						&nbsp;
					</a>
					<!-- end: NAVBAR COLLAPSE -->
				</header>
				<!-- end: TOP NAVBAR -->
				<div class="main-content" >
				