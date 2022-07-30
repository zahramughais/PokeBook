<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>
</head>
<body>
    <div>
        <h1>Expense Details</h1>
        <a href="/expenses">Go Back</a>
    </div>
    <p>Expense Name: <c:out value="${e.expense}"/></p>
    <p>Expense Description: <c:out value="${e.description}"/></p>
    <p>Vendor: <c:out value="${e.vendor}"/></p>
    <p>Amount Spent: $<c:out value="${e.amount}"/></p>

</body>
</html>