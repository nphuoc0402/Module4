
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/17/2021
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Recipe</h1>
<c:forEach var="i" begin="0" end="4">
    <p><c:out value="${condiment[i]}"></c:out></p>
</c:forEach>
</body>
</html>
