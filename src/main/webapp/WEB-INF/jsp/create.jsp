
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Create User Page</title>
    <link href="/res/styles2.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please input New User info!
    </div>



<%--    <c:url value="/create" var="var"/>--%>
<%--    <form action="${var}" method="POST">--%>

    <form method="post" action="/create">

    <label for="name">User name
        <input class="input-field" type="text" required="required" id="name" name="name">
    </label>

    <label for=username>Username
        <input class="input-field" type="text" required="required" id="username" name="username">
    </label>
    <label for="password">Password
        <input class="input-field" type="password" required="required" id="password" name="password">
    </label>
    <select name="selectedRole" id="selectedRole">User's rights (user or admin)>
        <option value="ROLE_USER" selected>User credentials</option>
        <option value="ROLE_ADMIN">Admin credentials</option>
    </select>

        <hr>
    <input type="submit" value="Create New User">

    </form>


    <a href="<c:url value='/logout' />">Logout</a>


    <div class="form-style-2-heading">
        Already registered! Это я не додумал.


    </div>


</div>
</body>
</html>
