<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<title>Login</title>
</head>
<body>
    <form:form action="/loginValidation" method="POST" command="user">
      <table>
          <tr>
              <td>User ID:</td>
              <td><form:input path="userId" /></td>
          </tr>
          <tr>
              <td>Password:</td>
              <td><form:password path="password" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Login" />
              </td>
          </tr>
      </table>
  </form:form>
</body>
</html>