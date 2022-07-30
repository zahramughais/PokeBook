<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit My Task</title>
</head>
<body>
<div>
    <h1>Edit Expense</h1>
    <a href="/expenses">Go Back</a>
</div>
<h2>Track an expense:</h2>
<form:form action="/expenses/edit/${e.id}" method="post" modelAttribute="e">
<input type="hidden" name="_method" value="put">
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