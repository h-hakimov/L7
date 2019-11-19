$(document).ready(function() {
	$('#userName').keyup(function() {
		$.ajax({
			url : 'AjaxResponse',
			data : {
				userName : $('#userName').val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});

