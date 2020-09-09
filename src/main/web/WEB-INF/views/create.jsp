<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accident</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>

<body>

<form action="<c:url value='/save'/>" method='POST' style="width: 25%;margin-left: 5%">
    <h2>Create accident</h2>
    <div class="form-group">
        <label for="id">ID:</label>
        <input type="number" class="form-control" id="id" aria-describedby="emailHelp" placeholder="id" name="id">
    </div>
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" class="form-control" id="name" placeholder="name" name="name">
    </div>
    <div class="form-group">
        <label for="text">Text:</label>
        <input type="text" class="form-control" id="text" placeholder="text" name="text">
    </div>
    <div class="form-group">
        <label for="address">Address:</label>
        <input type="text" class="form-control" id="address" placeholder="address" name="address">
    </div>
    <div class="form-group">
        <label for="address">Type:</label>
        <select name="type.id" required>
            <c:forEach items="${types}" var="type">
                <option value="${type.id}">${type.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="address">Rule:</label>
        <select name="ruleIds" multiple>
            <c:forEach items="${rules}" var="rule">
                <option value="${rule.id}">${rule.name}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>