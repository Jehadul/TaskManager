<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<!-- Template Name: Clip-Two - Responsive Admin Template build with Twitter Bootstrap 3.x | Author: ClipTheme -->
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
	<!--<![endif]-->
	<!-- start: HEAD -->
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
		<link rel="stylesheet" href="/assets/css/googlefonts.css" type="text/css" />
		<link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/vendor/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/vendor/themify-icons/themify-icons.min.css">
		<link rel="stylesheet" href="/vendor/animate.css/animate.min.css" media="screen">
		<link rel="stylesheet" href="/vendor/perfect-scrollbar/perfect-scrollbar.min.css" media="screen">
		<link rel="stylesheet" href="/vendor/switchery/switchery.min.css" media="screen">
		<link rel="stylesheet" href="/assets/css/styles.css">
		<link rel="stylesheet" href="/assets/css/plugins.css">
		<link rel="stylesheet" href="/assets/css/themes/theme-1.css" id="skin_color" />
	</head>

	<!-- end: HEAD -->
	<!-- start: BODY -->
	<body onload='document.loginForm.username.focus();'>

	<div id="login-box">
	</div>
		<!-- start: LOGIN -->
		<div class="row">
			<div class="main-login col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
				<div class="logo margin-top-30">
					<img src="../../assets/images/logo.png" alt="Clip-Two"/>
				</div>
				<!-- start: LOGIN BOX -->
				<div class="box-login">
								
					<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<fieldset>
							<legend>
								Sign in to your account
							</legend>
							<h5 style="color:red">
								<c:if test="${not empty error}">
									<div class="error">${error}</div>
								</c:if>
								<c:if test="${not empty msg}">
									<div class="msg">${msg}</div>
								</c:if>	
								<c:if test="${not empty param.logout}">
									<div class="msg">Logged out successfully</div>
								</c:if>	
								
							</h5>
							<!-- <p>
								 "Please enter your name and password to log in."}
							</p> -->
							<div class="form-group">
								<span class="input-icon">
									<input type="text" class="form-control" name="username" placeholder="Username" style='text-transform:uppercase'>
									<i class="fa fa-user"></i> </span>
							</div>
							<div class="form-group form-actions">
								<span class="input-icon">
									<input type="password" class="form-control password" name="password" placeholder="Password">
									<i class="fa fa-lock"></i>
								</span>
							</div>
							<div class="form-actions">
								<div class="checkbox clip-check check-primary">
									<input type="checkbox" id="remember" value="1">
									<label for="remember">
										Keep me signed in
									</label>
								</div>
								<button type="submit" class="btn btn-primary pull-right">
									Login <i class="fa fa-arrow-circle-right"></i>
								</button>
							</div>
							<div class="forgot-password">
								Forgot your password?
								<a href="login_forgot.html">
									Request reset
								</a> 
							</div>
						</fieldset>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
					<!-- start: COPYRIGHT -->
					<div class="copyright">
						&copy; <span class="current-year"></span><span class="text-bold text-uppercase"> CTrends </span>. <span>All rights reserved</span>
					</div>
					<!-- end: COPYRIGHT -->
				</div>
				<!-- end: LOGIN BOX -->
			</div>
		</div>
		<!-- end: LOGIN -->
		<!-- start: MAIN JAVASCRIPTS -->
		<script src="../../../../vendor/jquery/jquery.min.js"></script>
		<script src="../../../../vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script src="../../../../vendor/switchery/switchery.min.js"></script>
		<script src="../../../../vendor/jquery-validation/jquery.validate.min.js"></script>
		<!-- end: MAIN JAVASCRIPTS -->
		<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script src="../../../../assets/js/login.js"></script>
		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	</body>
	<!-- end: BODY -->
</html>