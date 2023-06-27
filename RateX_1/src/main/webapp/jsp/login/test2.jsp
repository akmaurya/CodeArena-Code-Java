<%@ page import="net.sf.json.JSONObject" %>
<!DOCTYPE html>
<html>
<head>
    
    		
    <style type="text/css">
        div#status{position:fixed; font-size:24px;}
        div#wrap{width:800px; margin:0px auto;}
        div.newData{height:100px; background:#09F; margin:10px 0px;}    
    </style>
</head>
<body>
Hello111
	<script type="text/javascript">
	    <%-- var myVar = '<%= request.getAttribute("objkey") %>';
	    var mytest = eval('(' + myVar + ')');
	    
	    alert(myVar)  ;      // display complete json
	    alert(mytest.age);  // display age 
	    alert(mytest.item1);
	     --%>
	    
	     var myVar = '<%= request.getAttribute("objkey") %>';
		 var mytest = eval('(' + myVar + ')');
		 	 
		 var i = 0;
        function yHandler(){
			// Watch video for line by line explanation of the code
			// http://www.youtube.com/watch?v=eziREnZPml4
			var wrap = document.getElementById('wrap');
			var contentHeight = wrap.offsetHeight;
			var yOffset = window.pageYOffset; 
			var y = 0;
			y = y + contentHeight;
			if(y >= contentHeight) {
				// Ajax call to get more dynamic data goes here
			 
				wrap.innerHTML += '<div class="newData">'+ mytest.items[i].name +'<br>'+ mytest.items[i].description +'</div>';
				i++;
			}
			
			var status = document.getElementById('status');
			status.innerHTML = contentHeight+" | "+y;

		}
        window.onload = yHandler;
        window.onkeydown = yHandler;
	    
	    
	    
    </script>
    
   
    
    
	<div id="status">0 | 0</div>
    <div id="wrap"></div>
</body>
</html>