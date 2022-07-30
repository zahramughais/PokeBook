<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
</head>
<body>
<h1>PokeBook</h1>
<table>
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="expense" items="${expenses}">    
        <tr>
            <td><a href="/expenses/${expense.id}"><c:out value="${expense.expense}"/></a></td>
            <td><c:out value="${expense.vendor}"/></td>
            <td><c:out value="${expense.amount}"/>$</td>
            <td><a href="/expenses/edit/${expense.id}">edit</a></td>
            <td>
                <form action="/expenses/delete/${expense.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>Track an expense:</h2>
<form:form action="/expenses/new" method="post" modelAttribute="e">
    <p>
        <form:label path="expense">Expense Name:</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>
        <form:input type="number" step="0.01" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>     
        <form:input path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>