<%--
  Created by IntelliJ IDEA.
  User: sstoica
  Date: 4/27/2018
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
    <title>PS Bank Holder Details</title>
</head>
<body>
    <table border="1" width="100%">
        <thead>
            <tr>
                <th><spring:message code="lbl.accountNo"/></th>
                <th><spring:message code="lbl.accountHolderName"/></th>
                <th><spring:message code="lbl.balance"/></th>
                <th> &nbsp; </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${accounts}">
                <c:url var="updateLink" value="/edit">
                    <c:param name="accountNo" value="account.accountNo"/>
                </c:url>
                <tr>
                    <td>${account.accountNo}</td>
                    <td>${account.accountHolderName}</td>
                    <td>${account.balance}</td>
                    <td><a href="${updateLink}">Edit</a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
