<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accident</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>
<body>

<table class=" table" style="margin-left: 5%;width: 90%">

    <thead class="thead-dark">
    <tr>
        <th scope="col">id</th>
        <th scope="col">Name</th>
        <th scope="col">Text</th>
        <th scope="col">Address</th>
        <th scope="col">Type</th>
        <th scope="col">Rule ID</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${accidents}" var="accs">
        <tr>
            <th scope="row"><c:out value="${accs.id}"/></th>
            <th scope="row"><c:out value="${accs.name}"/></th>
            <th scope="row"><c:out value="${accs.text}"/></th>
            <th scope="row"><c:out value="${accs.address}"/></th>
            <th scope="row"><c:out value="${accs.type.id}"/></th>
            <th scope="row"><c:forEach items="${accs.rules}" var="rule">${rule.id}  </c:forEach></th>
            <th scope="row"><a href="<c:url value="/update?id=${accs.id}"/> ">update</a></th>
        </tr>
    </c:forEach>
    </tbody>

</table>
<a href="<c:url value='/create'/>" style="margin-left: 90%">Создать</a>


</tbody>
</table>
</body>
</html>
