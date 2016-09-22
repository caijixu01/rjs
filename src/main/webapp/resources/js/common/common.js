$(function() {
	$(document).ajaxError(function(event, jqXHR, ajaxSettings, thrownError) {
		myUtil.alert(thrownError);
	})
});