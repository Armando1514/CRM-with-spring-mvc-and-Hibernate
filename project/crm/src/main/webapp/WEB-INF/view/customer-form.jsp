<%--
  Created by IntelliJ IDEA.
  User: malak_000
  Date: 12/20/2021
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new Customer</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
<h3>Save Customer</h3>
<form:form action="saveCustomer" modelAttribute="customer" method="post">
    <form:hidden path="id"/>
    <table>
        <tbody>
        <tr>
            <td> <label> First Name </label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td> <label> Last Name </label></td>
             <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td> <label>Email </label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td> <label>  </label></td>
            <td><input type="submit" value="Save" class="save"></td>
        </tr>
        </tbody>
    </table>
</form:form>
    <a href="${pageContext.request.contextPath}/customer/list">back to list</a>
</div>
</body>
</html>
