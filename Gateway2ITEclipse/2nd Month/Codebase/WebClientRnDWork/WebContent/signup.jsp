<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX calls to Servlet using JQuery and JSON</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">


<script>
	    $(document).ready(function() {

		$('input#autoText').autocomplete({
			source : function(request, response) {
				$.ajax({
					url : "/WebClientRnDWork/autoSuggestion",
					data : {
						autoText : request.term
					},
					success : function(responseJson) {
						var items = responseJson;
						response(items);
					}
				});
			}
		});

		$('#country').change(function(event) {
			var $country = $("#country").val();
			$.get('/WebClientRnDWork/stateList.asp', {
				countryname : $country
			}, function(responseJson) {
				var $select = $('#states');
				$select.find('option').remove();
				$.each(responseJson, function(key, value) {
					$('<option>').val(key).text(value).appendTo($select);
				});
			});
		});
	});
</script>
</head>
<body>
	<h1>AJAX calls to Servlet using JQuery and JSON</h1>
	Select Country:
	<select id="country">
		<option>Select Country</option>
		<option value="India">India</option>
		<option value="US">US</option>
	</select> Select State:
	<select id="states">
		<option>Select State</option>
	</select>

	<h1>AJAX calls for AutoSuggestion</h1>
	<input id="autoText" name="autoText" type="text" maxlength="20" />
</body>
</html>