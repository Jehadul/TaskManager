<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="wrap-content container" id="container">
	<div class="row action-item">
		<div class="col-md-12">
			<a id="link_inbox" href="common/message/inbox?folder=workflow" data-ajax="true">
				<span class="title"><i class="ti-upload"></i> Inbox </span>&nbsp; 
				<span class="badge">${data.msgCountWf}</span>
			</a>
			<a href="common/message/inbox?folder=notification" data-ajax="true"> 
			 	<span class="title"><i class="ti-star"></i> Notification </span>&nbsp;
			 	<span class="badge">${data.msgCountNo}</span>
			</a>
			<a href="common/message/inbox?folder=workflowsent" data-ajax="true"> 
				<span class="title"><i class="ti-upload"></i> Sent </span>
			</a>
			<a href="#" data-ajax="true"> 
				<span class="title accept-all hidden"><i class="ti-check"></i> Accept </span>
			</a>
			<a href="#" data-ajax="true"> 
				<span class="title reject-all hidden"><i class="ti-close"></i> Reject </span>
			</a>
			
			<a href="#" data-ajax="true"> 
				<span class="title delete-all hidden"><i class="ti-trash"></i> Delete All </span>
			</a>
		</div>
	</div>
	<div class="wrap-messages">
		<div id="inbox" class="inbox">
			<!-- start: EMAIL LIST -->
			<div class="col email-list wrap-list">
						<ul class="messages-list perfect-scrollbar">
						<li class="msg-select">					
							<a href="#" onclick="selectAll()">Select all</a> | 
							<a href="#" onclick="selectNone()">Select none</a>
						</li>
						<c:forEach items="${data.message}" var="msg">
							<c:if test="${!msg.status.equals(\"ARCHIVED\")}">
								<c:choose>
									<c:when test="${msg.isRead() == true}">
										<li class="messages-item">
									</c:when>
									<c:otherwise>
										<li class="messages-item unread-msg">
									</c:otherwise>
								</c:choose>
								<a href="#"> 
								<cts:Hidden name="msg_id" cssClass="msg-id" value="${msg.id}"/>
								<cts:Hidden name="msg_wip_id" cssClass="msg-wip-id" value="${msg.refWipId}"/>
								<cts:Hidden name="msg_uri" cssClass="msg-uri" value="${msg.uri}"/>
									<div class="col">
										<img class="messages-item-avatar bordered border-primary" alt="${msg.fromName}" src="assets/photo/${msg.companyCode }${ msg.fromCode }.jpg">
										<br/><cts:CheckBox cssClass="select-msg" name="check_${msg.id}" />
									</div>
									
									<span class="messages-item-from">${msg.fromName}</span>
									<div class="messages-item-time">
										<span class="text">${msg.msgTimestamp}</span>${message.msgTimestamp }
									</div>
								 <span class="messages-item-subject"> ${msg.msgSubject }</span>
								 <span class="messages-item-content"> ${msg.msgType.toLowerCase()}</span>

								</a>
								</li>
							</c:if>
						</c:forEach>
					</ul>
			</div>
			<!-- end: EMAIL LIST -->
			<!-- start: EMAIL READER -->
			<div class="email-reader perfect-scrollbar hidden">
				<div class="col-md-12">
					<div class="message-actions">
						<ul class="actions no-margin no-padding block">
							<li class="no-padding normal-msg"><a href="#"> Reply </a></li>
							<li class="no-padding normal-msg"><a href="#"> Reply all
							</a></li>
							<li class="no-padding normal-msg"><a href="#"> Forward </a>
							</li>
							<li class="no-padding normal-msg notification"><a
								class="btn-delete" href="#"> Delete </a></li>
							<li class="no-padding wf-msg"><a class="btn-open" href="#">
									Open Document </a></li>
						</ul>
					</div>
					<div class="message-header">
						<img class="message-item-avatar" src="">
						<div class="message-time"></div>
						<div class="message-from"></div>
						<div class="message-to"></div>
					</div>
					<div class="message-subject"></div>
					<div class="message-content"></div>
				</div>
			</div>
			<!-- end: EMAIL READER -->
		</div>
	</div>
</div>
<script src="assets/js/pages-messages.js"></script>
<script type="text/javascript">


	Main.initScrollbar();
	Messages.init();
	InitHandlers();	
	
	function selectAll(){ 
		$(".select-msg").prop("checked", "checked");
		showHide();
		
	}
	
	function selectNone(){ 
		$(".select-msg").removeProp("checked");
		showHide();
		
	}	
	
	$(".select-msg").on('click',function(){
		showHide();
	});

	
	
	function showHide(){
		var msgStatus = $(".messages-item-content").text(); 
			if ($.trim(msgStatus) == "workflow") { 
				if($('.select-msg').prop('checked')) { 
					$(".accept-all").removeClass("hidden");	
					$(".reject-all").removeClass("hidden");	
				} else {
					$(".accept-all").addClass("hidden");
					$(".reject-all").addClass("hidden");
				}
			
			 }else{
				 
				 if($('.select-msg').prop('checked')) { 
					 	$(".delete-all").removeClass("hidden");	
					} else {
						$(".delete-all").addClass("hidden");
					}
			} 
	 }
	
	//-----------------------------------------------------------------//
	
		$(".accept-all, .requery, .reject-all").on("click", function(){ 
		 event.preventDefault();
	 	var action = "";
			if ($(this).hasClass("accept-all")) {
				action = "approve";
			}
			else if($(this).hasClass("requery")) {
				action = "requery";
			}
			else if($(this).hasClass("reject-all")) {
				action = "reject";
			}
			
			
		$(".messages-item").each(function(i, item){
		    if($(item).find(".select-msg").prop("checked")){
		    	var msgId = $(item).find(".msg-id").val(); 
		    	var msgWipId = $(item).find(".msg-wip-id").val(); 
		    	var msgUri = $(item).find(".msg-uri").val();
		    	var url = msgUri + '/' + action;
		    	
		    	$.post(url,{
		    		_csrf:"${_csrf.token}",
		    		   id:msgWipId,
		     		step_comment:"Batch",
		    		},function(data,status){
						if(data.outcome == 'success'){
				    		ShowSuccessMsg('Successful', data.message);
				    		LoadMainContent("common/message/inbox"); 
				    	}
				    	else{
				    		ShowErrorMsg('Failed', data.message);
				    	}
			    		           
		    		}
		    	);
		    	
		    }
		});
	
		
			 
		
	});
	
	//----------------------------------delete all---------------------------------------//   	
             	$(".delete-all").on("click", function(){ 
             		$(".messages-item").each(function(i, item){
	             		 if($(item).find(".select-msg").prop("checked")){ 
	             			var msgIds = $(item).find(".msg-id").val(); 
	             			
							swal({
								title: "The message will be deleted parmanently.",
								text: "Are you sure to delete this message?",
								type: "warning",
								showCancelButton: true,
								confirmButtonColor: "#007AFF",
								confirmButtonText: "Yes, delete parmanently!",
								closeOnConfirm: true
							}, function() {
								$.post('common/message/deletemsg',{			        	
									 _csrf: "${_csrf.token}",
						                id: msgIds,
						           
								},function(data){
							    			//LoadMainContent(mainContentUrl);
							    			LoadMainContent("common/message/inbox"); 
							    });
							});
						
	             		 }
             		});
				});
            //----------------------------------end delete all---------------------------------------//
	
	$(".messages-item").on("click",function(){
		var msgId = $(this).find(".msg-id").val();
		var msgItem = $(this).closest('.messages-item');
		$.post('common/message/readmsg',{
            id: msgId,
            _csrf: "${_csrf.token}",
		},function(data){
			
			sutMod = JSON.parse(data);
			//console.log(sutMod);
			data = sutMod.readMsg; //alert(data.msgTimestamp);
           		$(".message-item-avatar").prop("src","assets/photo/" + data.companyCode + data.fromCode + ".jpg");
				$(".message-time").html(data.msgTimestamp);
				$(".message-from").html(data.fromName);
				$(".message-to").html(data.toName);
				$(".message-subject").html(data.msgSubject);
				$(".message-content").html(data.msgBody);
				$(".email-reader").removeClass('hidden');	
            	if (data.msgType == 'WORKFLOW') {
            		$(".actions li:not(.wf-msg)").hide();
            		$(".actions .wf-msg").show();
            	}
            	else if (data.gType == 'NOTIFICATION' || data.msgType == 'WFSENT') {
            		$(".actions li:not(.notification)").hide();
            		$(".actions .notification").show();
            	}
            	else{
            		$(".actions li:not(.normal-msg)").hide();
            		$(".actions .normal-msg").show();
            	} 
            	
            	$(".btn-open").off("click").on("click", function(){ 
					ShowModal('/'+ sutMod.suiteModule[0] + '/' + sutMod.suiteModule[1] + '/' + data.objectTypeCode.toLowerCase() + '/showchange/' + data.refWipId  ,'modal-lg', 'msg-modal');
				});

            	$(".btn-delete").off("click").on("click", function(){
					swal({
						title: "The message will be deleted parmanently.",
						text: "Are you sure to delete this message?",
						type: "warning",
						showCancelButton: true,
						confirmButtonColor: "#007AFF",
						confirmButtonText: "Yes, delete parmanently!",
						closeOnConfirm: true
					}, function() {
						$.post('common/message/deletemsg',{			        	
							 _csrf: "${_csrf.token}",
				            id: msgId,
				           
						},function(data){
					    			LoadMainContent(mainContentUrl);
					    });
					});
				});
         
		      	msgItem.removeClass('unread-msg');

            });
		InitHandlers();
	});
	
</script>
<style>
.msg-select{
	text-align:right;
	font-size:10px;
	padding:2px;
}
.messages-list{
	top:0px;
}
.inbox .email-options {
    width: 150px !important;
    border-right: 1px solid #dee5e7;
    overflow: hidden;
}
.action-item a{
	width:150px;
	display:block;
	padding-bottom:12px;
	float:left;
	border-right: 1px solid #bbb;
	text-align:center;
}
.action-item{
	border-bottom: 1px solid #bbb;
}
.messages-item-checkbox{
	float:left;
}

.messages-list .messages-item {
    padding: 5px 15px 5px 15px;
    min-height:110px;
}
.inbox .email-reader {
    margin-left: 0px; 
}
</style>