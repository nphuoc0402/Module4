<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/cal" method="post">
    <div>
        <input type="text" name="num1" id="input1">
        <input type="text" name="num2" id="input2">
    </div>
    <div>
        <input type="submit" name="cal" id="add" value= "Addition(+)">
        <input type="submit" name="cal" id="sub" value="Subtraction(-)">
        <input type="submit" name="cal" id="mul" value="Multiplication(X)">
        <input type="submit" name="cal" id="div" value="Division(/)">
    </div>
    <div><c:if test="${cal != null}">
        <c:out value="Result: ${cal}"></c:out>
    </c:if></div>
    <c:if test="${message != null}">
        <c:out value="${message}"></c:out>
    </c:if>
</form>
</body>
</html>
