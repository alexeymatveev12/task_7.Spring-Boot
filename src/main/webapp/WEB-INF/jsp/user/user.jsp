
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>REAL User Page</title>
    <link href="/res/styles.css" rel="stylesheet" type="text/css">
</head>
<body>




    <form action="/">
        <input type="submit" value="Go to welcome page......" />
    </form>


<h1>User - страница, которую видит Юзер после логина</h1>
<a href="<c:url value="/perform_logout" />">Logout - buy-buy!</a>


</div>


</div>
</body>
</html>
