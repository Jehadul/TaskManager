var FormWizard = function () {
	"use strict";
    var wizardContent = $('#wizard');
    var wizardForm = $('.wizard-form');
    var numberOfSteps = $('.swMain > ul > li').length;
    var initWizard = function () {
        // function to initiate Wizard Form
        wizardContent.smartWizard({
            selected: 0,
            keyNavigation: false,
            onLeaveStep: leaveAStepCallback,
            onShowStep: onShowStep,
        });
        var numberOfSteps = 0;
        $(".back-step").hide();
            

    };
    

    var onShowStep = function (obj, context) {
    	if(context.toStep == numberOfSteps){
    		$('.anchor').children("li:nth-child(" + context.toStep + ")").children("a").removeClass('wait');
    	}
        $(".next-step").unbind("click").click(function (e) {
            e.preventDefault();
            wizardContent.smartWizard("goForward");
        });
        $(".back-step").unbind("click").click(function (e) {
            e.preventDefault();
            wizardContent.smartWizard("goBackward");
        });
        $(".go-first").unbind("click").click(function (e) {
            e.preventDefault();
            wizardContent.smartWizard("goToStep", 1);
        });

    };
    var leaveAStepCallback = function (obj, context) {
        // return false to stay on step and true to continue navigation


        var isStepValid = validateSteps(context.fromStep, context.toStep)
        if (isStepValid) {
            if (context.toStep == 1) {
                $(".back-step").hide();
                $(".next-step").show();
                $(".btn-save").hide();
            }
            else if (context.toStep == numberOfSteps){
                $(".back-step").show();
                $(".next-step").hide();
                $(".btn-save").show();
            }
            else{
                $(".back-step").show();
                $(".next-step").show();
                $(".btn-save").hide();
            }
            $("html, body").animate({
                scrollTop: 0
            }, "slow");
        }
        return isStepValid;
    };

    var validateSteps = function (stepnumber, nextstep) {
        var isStepValid = false;
        if (numberOfSteps >= nextstep && nextstep > stepnumber) {
        	
            // cache the form element selector
            if (validateStep(stepnumber)) { 
                for (var i=stepnumber; i<=nextstep; i++){
            		$('.anchor').children("li:nth-child(" + i + ")").not("li:nth-child(" + nextstep + ")").children("a").removeClass('wait').addClass('done').children('.stepNumber').addClass('animated tada');
        		}
                isStepValid = true;
                return true;
            };
        } else if (nextstep < stepnumber) {
        	for (var i=nextstep; i<=stepnumber; i++){
        		$('.anchor').children("li:nth-child(" + i + ")").children("a").addClass('wait').children('.stepNumber').removeClass('animated tada');
        	}
            
            return true;
        } 
    };

    var enableAll= function(){
        for (var i = 1; i<=numberOfSteps; i++){
            wizardContent.smartWizard("enableStep", i);
        }
    
    };

    return {
        init: function () {
            initWizard();
        },
        enableAll:function(){
            enableAll();
        }
    };
}();