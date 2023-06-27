
<!-- if i want to use c:out -->
<%@ taglib prefix="c" uri="/WEB-INF/tld/c_out.tld" %>
<%@ taglib prefix = "fmt" uri = "/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri = "/WEB-INF/tld/fn.tld" prefix = "fn" %>

<html lang="en">
<head>
    <title>first_page</title>
</head>
<body>
1. First Page Came Via  String Return....
<br><br> Note:- for tags "xmlns" requier in web.xml and applicationcontext.... <br><br>
First tag work -- ${normal}

<br><br>
2. with c:out -- <c:out value="${normal}"/>
<br><br>

3. when tag----
<br><br>
<c:choose>
<c:when test="${normal == '1'}">
value is 1
</c:when>
    <c:otherwise>

        Value is not 1
    </c:otherwise>
</c:choose>
<br><br>

4. auto work -- ${500*2}
<br><br>

5. Session Play with c:set --
<br><br>
<c:set var="ab" value="500" scope="session" />
${ab}<br><br>

remove session -- <c:remove var = "ab"/>
${ab}
<br><br>

6. Catch Exception --
<br>
<c:catch var ="catchException">
    <% int x = 5/0;%>
</c:catch>

Exception is :-   ${catchException}
<br><br>

7. If Tag---<br><br>

<c:if test="${f_val == '1'}">
if tag work f_Val value is ${f_val}
</c:if>
<br><br>

8. Loop with foreach --
<Br><br>
<c:forEach var="i"  begin="10" end="20">
   ${i}
</c:forEach>
<br><br>

9. Array with Tokens -- <br><br>

<c:forTokens items="a,b,c,d,e,f" delims="-" var="var">
${var}
</c:forTokens>
<br><Br>


10. c:params
<c:url value = "/index.jsp" var = "myURL">
    <c:param name = "trackingId" value = "1234"/>
    <c:param name = "reportType" value = "summary"/>
</c:url>
<c:import url = "${myURL}"/>

That means -- "/index.jsp?trackingId=1234;reportType=summary"
<br><br>





L. Get Data From URL  in String Format--<br><br>
<c:import var = "data" url = "/index.jsp"/>
<c:out value = "${data}"/>
<br><br>
<br>

FMT TAGS --------------------------------------------------------------------------------------
<BR><BR>
1. <h3>Number Format:</h3>
<c:set var = "balance" value = "120000.2309" />
<p>Formatted Number (1): <fmt:formatNumber value = "${balance}" type = "currency"/></p>
<p>Formatted Number (2): <fmt:formatNumber type = "number"       maxIntegerDigits = "3" value = "${balance}" /></p>
<p>Formatted Number (3): <fmt:formatNumber type = "number"   maxFractionDigits = "3" value = "${balance}" /></p>
<p>Formatted Number (4): <fmt:formatNumber type = "number"   groupingUsed = "false" value = "${balance}" /></p>
<p>Formatted Number (5): <fmt:formatNumber type = "percent" maxIntegerDigits="3" value = "${balance}" /></p>
<p>Formatted Number (6): <fmt:formatNumber type = "percent" minFractionDigits = "10" value = "${balance}" /></p>
<p>Formatted Number (7): <fmt:formatNumber type = "percent" maxIntegerDigits = "3" value = "${balance}" /></p>
<p>Formatted Number (8): <fmt:formatNumber type = "number" pattern = "###.###E0" value = "${balance}" /></p>
<p>Currency in USA :
    <fmt:setLocale value = "en_US"/>
    <fmt:formatNumber value = "${balance}" type = "currency"/>
</p>
<br><br>

2.  Date Formate
<br>
<c:set var = "now" value = "<%= new java.util.Date()%>" />
<p>Formatted Date (1): <fmt:formatDate type = "time" value = "${now}" /></p>
<p>Formatted Date (2): <fmt:formatDate type = "date" value = "${now}" /></p>
<p>Formatted Date (3): <fmt:formatDate type = "both" value = "${now}" /></p>
<p>Formatted Date (4): <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></p>
<p>Formatted Date (5): <fmt:formatDate type = "both" dateStyle = "medium" timeStyle = "medium" value = "${now}" /></p>
<p>Formatted Date (6): <fmt:formatDate type = "both" dateStyle = "long" timeStyle = "long" value = "${now}" /></p>
<p>Formatted Date (7): <fmt:formatDate pattern = "yyyy-MM-dd" value = "${now}" /></p>
<br><Br>

3. <h3>Date Parsing:</h3>

<c:set var = "now" value = "20-10-2010" />
<fmt:parseDate value = "${now}" var = "parsedEmpDate" pattern = "dd-MM-yyyy" />
<p>Parsed Date: <c:out value = "${parsedEmpDate}" /></p>
<br><br>



FN ---------------------------------------------------------------
<br><Br>
1.   <c:set var = "string1" value = "This is first String"/>
<p>String (1) Length : ${fn:length(string1)}</p>

<Br><br>

2. Replace String   <c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:replace(string1, 'first', 'second')}" />
<p>Final String : ${string2}</p>

<br><br>
${firstv}
</body>
</html>
