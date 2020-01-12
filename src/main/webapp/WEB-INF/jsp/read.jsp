<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
    <link href="/res/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div align="center">

    <table bordercolor="red" border="1" cellpadding="4" cellspacing="0">
        <caption>
            <h2>Read page in / folder </h2>
        </caption>
        <br/><br/>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Password</th>
            <th>Roles</th>
            <th>Change the record - Update</th>
            <th>Change the record - Delete</th>
        </tr>

        <jsp:useBean id="allUsers" scope="request" type="java.util.List"/>

        <c:forEach var="user" items="${allUsers}">
            <tr>
                <td align="center" size="200"><c:out value="${user.id}"/></td>
                <td align="center" size="30"><c:out value="${user.name}"/></td>
                <td align="center" size="30"><c:out value="${user.username}"/></td>
                <td align="center" size="30"><c:out value="${user.password}"/></td>
                <td align="center" size="30"><c:out value="${user.roles}"/></td>

                <td>Update this User - запрещено</td>
                <td>Delete this User - запрещено</td>

            </tr>
        </c:forEach>

    </table>
    <hr>

    <br/><br/>
    <hr>



    <form action="/create">
        <input type="submit" value="Create the New User" />
    </form>


    &nbsp;&nbsp;&nbsp;

    <a href="<c:url value='/logout' />">Logout</a>


</div>

</body>
</html>
