<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://localhost:8080/jsp/tlds/ct" prefix="ct"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upper or Lower Case</title>
</head>
<body>
	<h2>
		Upper Case :
		<ct:changeCase case="upper">
            Hello World kjsdkjsdkaskas askljksallkaslkaslkaslksa aslk
            asklasklsaklask
            
            saklaskasklas
        </ct:changeCase>
	</h2>
	<h2>
		Lower Case :
		<ct:changeCase case="lower">
                Hello World sakjaskjaskjkjsa 
                askjaskjkjsa
                
                samaskklasklsa SDSDSDSDSSDDSDSDDSSDSDSDSDSDSD
        </ct:changeCase>
	</h2>
</body>
</html>