jQuery(document).ready(function() {
	Main.init();
	InitHandlers();
});

$("#lock").on("click", function(){
	$(".lock-screen-placeholder").load("/lock").show();
	$("#app").hide();
});

var processTcode = function(data){
	if (data.outcome == 'success') {
		$("#tcode").val("");
		if(data.data.indexOf('/search') > 0){
			ShowModal(data.data);
		}
		else{
			LoadMainContent(data.data);
		}
	}
	else{
		ShowErrorMsg("Unavailble", data.message);
	}
};