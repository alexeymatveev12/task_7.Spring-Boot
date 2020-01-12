<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
</head>
<body>

<div align="center">
    <a href="/admin/users">Users</a>
    <form:form method="POST" action="/add2">
        <table border="1" cellpadding="5">
            <caption>
                Add
            </caption>
            <%--валидация данных. сообщение об ошибке--%>
            ${myError}
            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="name" size="45" required="required"/>
                </td>
            </tr>
            <tr>
                <th>Username</th>
                <td>
                    <input type="text" name="username" size="45" required="required"/>
                </td>
            </tr>
            <tr>
                <th>Password</th>
                <td>
                    <input type="text" name="password" size="45" required="required"/>
                </td>
            </tr>
            <tr>
                <th>Role</th>
                <td>
                    <%--передаю "" что бы обойти ошибку 400 ('Required String[] parameter 'checkboxRoles' is not present')--%>
                    <input type="hidden" name="checkboxRoles2" value="1"/>
                    <input type="checkbox" name="checkboxRoles2" value="ROLE_USER"/> ROLE_USER
                    <input type="checkbox" name="checkboxRoles2" value="ROLE_ADMIN"/> ROLE_ADMIN
                </td>

                <th>Role - моя реализация</th>
                <td>
                    <select name="checkboxRoles" id="checkboxRoles">User's rights (user or admin)>
                        <option value="ROLE_USER" selected>User credentials</option>
                        <option value="ROLE_ADMIN">Admin credentials</option>
                    </select>
                </td>


            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </form:form>
    <a href="<c:url value="/perform_logout" />">Logout</a>
</div>

</body>
</html>
