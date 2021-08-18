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
    <title>Form</title>
</head>
<body>
<form action="/save" method="post">
    <h1>Sandwich Condiments</h1>
    <div class="checkbox">
        <input type="checkbox" name="condiment" value="Lettuce">
        <label>Lettuce</label>
        <input type="checkbox" name="condiment" value="Tomato">
        <label>Tomato</label>
        <input type="checkbox" name="condiment" value="Mustard">
        <label>Mustard</label>
        <input type="checkbox" name="condiment" value="Sprouts">
        <label>Sprouts</label><br>
        <input type="submit" value="Save">
        <p><strong>${message}</strong></p>
    </div>
</form>
</body>
</html>
