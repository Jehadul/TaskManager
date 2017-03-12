
<%-- <%@page import="com.ctrends.ctrendsee.service.common.MessageService"%> --%>
</div>
			</div>
			<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<%@taglib prefix="cts" uri="/WEB-INF/custom.tld" %>	
			<!-- start: FOOTER -->
			<footer>
				<div class="footer-inner">
					<div class="pull-left">
						<span class="text-bold ">Task Manager </span>&nbsp;&copy; <span class="current-year"></span><span class="text-bold text-uppercase"> CTrends</span>. <span>All rights reserved </span>

					</div>

					<div class="pull-right">
						<span class="go-top"><i class="ti-angle-up"></i></span>
					</div>
				</div>
			</footer>
			<!-- end: FOOTER -->
			<!-- start: OFF-SIDEBAR -->
			<div id="off-sidebar" class="sidebar">
				<div class="sidebar-wrapper">
					<ul class="nav nav-tabs nav-justified">
						<li class="active">
							<a href="#off-users" aria-controls="off-users" role="tab" data-toggle="tab">
								<i class="ti-comments"></i>
							</a>
						</li>
						<li>
							<a href="#off-favorites" aria-controls="off-favorites" role="tab" data-toggle="tab">
								<i class="ti-heart"></i>
							</a>
						</li>
						<li>
							<a href="#off-settings" aria-controls="off-settings" role="tab" data-toggle="tab">
								<i class="ti-settings"></i>
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="off-users">
							<div id="users" toggleable active-class="chat-open">
								<div class="users-list">
									<div class="sidebar-content perfect-scrollbar">
										<h5 class="sidebar-title">On-line</h5>
										<ul class="media-list">
											<li class="media">
												<c:forEach items="${data.loginhistory }" var="log" varStatus="i">
													<div class="row">
													   <div class="col-md-11">
													   
													  <c:set var="username" value="${data.loginhistory[i.count-1].username}"></c:set>
															<a data-toggle-class="chat-open" data-toggle-target="#users"  onclick="loadMessage('${data.loginhistory[i.count-1].username}')">
																<i class="fa fa-circle status-online"></i>
																<img alt="..." src="assets/photo/${data.loginhistory[i.count-1].username}.jpg" class="media-object">
																<span class="badge pull-right ${data.loginhistory[i.count-1].username}"></span>
																<div class="media-body">
																	<h4 class="media-heading ">${data.loginhistory[i.count-1].empName }</h4>
																	<span> ${data.loginhistory[i.count-1].desig }</span>
																</div>
															</a>
														
														</div>
													</div>
												</c:forEach>
											</li>
										</ul>
										<h5 class="sidebar-title">Off-line</h5>
										<ul class="media-list">
											<li class="media">
											<c:forEach items="${data.offline}" var="off" varStatus="i">
												<div class="row">
												   <div class="col-md-11">
														<a data-toggle-class="chat-open" data-toggle-target="#users" href="#">
															<img alt="..." src="assets/photo/${data.offline[i.count-1].username}.jpg" class="media-object">
															<div class="media-body">
																<h4 class="media-heading">${data.offline[i.count-1].empName }</h4>
																<span> ${data.offline[i.count-1].desig }</span>
															</div>
														</a>
													</div>
												</div>
												</c:forEach>
											</li>
										</ul>
									</div>
								</div>
								<div class="user-chat">
									<div class="chat-content">
										<div class="sidebar-content perfect-scrollbar">
											<a class="sidebar-back pull-left" href="#" data-toggle-class="chat-open" data-toggle-target="#users"><i class="ti-angle-left"></i> <span>Back</span></a>
											<ol class="discussion msg-content">

											</ol>
										</div>
									</div>
									<div class="message-bar">
										<div class="message-inner">
											<a class="link icon-only" href="#"><i class="fa fa-camera"></i></a>
											<%-- <cts:AjaxForm dataHandler="loadChat" action="common/message/send">
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
												<div class="message-area">
													<textarea name="message" placeholder="Message" id="message"></textarea>
													<cts:Hidden cssClass="to-code" name="to_code" value="" />
												</div>
												<div class="link icon-only">
													<button class="btn btn-send pull-right" type="submit">
															<span class="fa fa-paper-plane"></span>
													</button>
												</div>
											</cts:AjaxForm> --%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="off-favorites">
							<div class="users-list">
								<div class="sidebar-content perfect-scrollbar">
									<h5 class="sidebar-title">Favorites</h5>
									<ul class="media-list">
										<li class="media">
											<a href="#">
												<img alt="..." src="assets/images/avatar-7.jpg" class="media-object">
												<div class="media-body">
													<h4 class="media-heading">Nicole Bell</h4>
													<span> Content Designer </span>
												</div>
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="off-settings">
							<div class="sidebar-content perfect-scrollbar">
								<h5 class="sidebar-title">General Settings</h5>
								<ul class="media-list">
									<li class="media">
										<div class="padding-10">
											<div class="display-table-cell">
												<input type="checkbox" class="js-switch" checked />
											</div>
											<span class="display-table-cell vertical-align-middle padding-left-10">Enable Notifications</span>
										</div>
									</li>
								</ul>
								<div class="save-options">
									<button class="btn btn-success">
										<i class="icon-settings"></i><span>Save Changes</span>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end: OFF-SIDEBAR -->
			<!-- start: SETTINGS -->
			<div class="settings panel panel-default hidden-xs hidden-sm" id="settings">
				<button ct-toggle="toggle" data-toggle-class="active" data-toggle-target="#settings" class="btn btn-default">
					<i class="fa fa-spin fa-gear"></i>
				</button>
				<div class="panel-heading">
					Style Selector
				</div>
				<div class="panel-body">
					<!-- start: FIXED HEADER -->
					<div class="setting-box clearfix">
						<span class="setting-title pull-left"> Fixed header</span>
						<span class="setting-switch pull-right">
							<input type="checkbox" class="js-switch" id="fixed-header" />
						</span>
					</div>
					<!-- end: FIXED HEADER -->
					<!-- start: FIXED SIDEBAR -->
					<div class="setting-box clearfix">
						<span class="setting-title pull-left">Fixed sidebar</span>
						<span class="setting-switch pull-right">
							<input type="checkbox" class="js-switch" id="fixed-sidebar" />
						</span>
					</div>
					<!-- end: FIXED SIDEBAR -->
					<!-- start: CLOSED SIDEBAR -->
					<div class="setting-box clearfix">
						<span class="setting-title pull-left">Closed sidebar</span>
						<span class="setting-switch pull-right">
							<input type="checkbox" class="js-switch" id="closed-sidebar" />
						</span>
					</div>
					<!-- end: CLOSED SIDEBAR -->
					<!-- start: FIXED FOOTER -->
					<div class="setting-box clearfix">
						<span class="setting-title pull-left">Fixed footer</span>
						<span class="setting-switch pull-right">
							<input type="checkbox" class="js-switch" id="fixed-footer" />
						</span>
					</div>
					<!-- end: FIXED FOOTER -->
					<!-- start: THEME SWITCHER -->
					<div class="colors-row setting-box">
						<div class="color-theme theme-1">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-1">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
						<div class="color-theme theme-2">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-2">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
					</div>
					<div class="colors-row setting-box">
						<div class="color-theme theme-3">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-3">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
						<div class="color-theme theme-4">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-4">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
					</div>
					<div class="colors-row setting-box">
						<div class="color-theme theme-5">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-5">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
						<div class="color-theme theme-6">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-6">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
					</div>
					<!-- end: THEME SWITCHER -->
				</div>
			</div>
			<!-- end: SETTINGS -->
		</div>
		<div class="lock-screen-placeholder" style="display:none;">	
		</div>
		<script>
		
		function msgCount(t){
			$.get("common/message/msgcount", function(data) {
				data = JSON.parse(data.data);
				 
				  for(var i=0;i<data.length;i++){
					  $('.'+data[i][0]).text(data[i][1]);
				  }
				});
		};
		var messageContant = "";
		var me = "";
		function loadMessage(to){
			$('.to-code').val(to);
			messageContant = "";
			$.post('common/message/loadMessage',{			        	
				 _csrf: "${_csrf.token}",
	            to_username: to
	           
			},function(data){	
				data = JSON.parse(data.data);
				me = data.me;
				showConversation(data.messages,data.me);		
		    }); 
		}
	function loadChat(data){
		data = JSON.parse(data.data);
		showConversation(data,me);
	}
	function showConversation(data,to){
		messageContant = "";
		
		var cls = "";
		$('.msg-content').html("");
		for(var i=0; i<data.length; i++){
			if(data[i].toUsername != to){
				cls = "self";
			}else{
				cls = "other";
			}
			messageContant += '<li class="'+cls+'">'
			                    +'<div class="message">'
			                        +'<div class="message-text">'
			                            + data[i].msgBody
			                        +'</div>'
			                        +'<div class="message-avatar">'
			                            +'<img src="assets/photo/'+data[i].fromUsername+'.jpg"/>'
			                        +'</div>'
			                    +'</div>'
			           		 +'</li>';
		}
		$('.msg-content').html(messageContant);
		$('#message').val("");
		
	}	
	
/* 	$( "#lock" ).click(function() {
		  alert( "Handler for .click() called." );
	}); */
        
</script>
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="vendor/modernizr/modernizr.js"></script>
		<script src="vendor/jquery-cookie/jquery.cookie.js"></script>
		<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script src="vendor/switchery/switchery.min.js"></script>
		<script src="vendor/sweetalert/sweet-alert.min.js"></script>
		<script src="vendor/toastr/toastr.min.js"></script>
		<script src="vendor/DataTables/jquery.dataTables.min.js"></script>
		<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
		<script src="vendor/maskedinput/jquery.maskedinput.min.js"></script>
		<script src="vendor/bootstrap-touchspin/jquery.bootstrap-touchspin.min.js"></script>
		<script src="vendor/autosize/autosize.min.js"></script>
		<script src="vendor/selectFx/classie.js"></script>
		<script src="vendor/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
		<script src="vendor/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
		<script src="vendor/bootstrap-fileinput/jasny-bootstrap.js"></script>
		<script src="vendor/ckeditor/ckeditor.js"></script>
		<script src="vendor/jstree/jstree.min.js"></script>
		<script src="assets/js/colresize.js"></script>
		<script src="assets/js/main.js"></script>
		<script src="assets/js/form-elements.js"></script>
		<script src="assets/js/common.js"></script>
		<script src="assets/js/layout.js"></script>

		
		<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		
		<script src="vendor/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>
		<script src="vendor/moment/moment.min.js"></script>
		<script src="vendor/fullcalendar/fullcalendar.min.js"></script>
		<script src="vendor/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
		
		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->	
		<script src="assets/js/accounting.min.js"></script>
		<script src="assets/js/accounting.js"></script>
	</body>
</html>
			
