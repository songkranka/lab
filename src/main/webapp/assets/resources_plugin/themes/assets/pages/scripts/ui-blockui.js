var UIBlockUI = function() {
    e = function() {
        /*App.blockUI({animate:!0}),window.setTimeout(function(){App.unblockUI()},2e3);//For Edge+*/
        App.blockUI({boxed: true});window.setTimeout(function() {App.unblockUI();}, 2000);//For IE8+ (Default message Loading...)
        /*App.startPageLoading({message: 'กรุณารอสักครู่...'});
        window.setTimeout(function() {
            App.stopPageLoading();
        }, 2000);//For IE8+ (Set Message)*/
    }
    return {
        init: function() {
            e();
        }
    };
}();

jQuery(document).ready(function() {    
   //UIBlockUI.init();
   //App.blockUI();
   App.blockUI({boxed: true});
   $(window).load(function() { 
		App.unblockUI();
	});
});