<%@ page language="java"  contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登陆</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}"/> </font>
    </c:if>

    <form action="<c:url value='/loginCheck.html'/>">
        <label for="userName">用户名:</label><input type="text" name="userName" id="userName"><br/>
        <label for="password">密&nbsp;&nbsp;码:</label><input type="password" name="password" id="password"><br/>
        <input type="submit" value="登陆"/>
        <input type="reset" value="重置"/>
    </form>
</body>
</html>