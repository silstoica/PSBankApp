<%--
  Created by IntelliJ IDEA.
  User: sstoica
  Date: 4/19/2018
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="lbl.title" /></title>
</head>
<body>
    <h2>Account Details</h2>

    <p><spring:message code="lbl.accountNo" />: ${account.accountNo}</p>
    <p><spring:message code="lbl.accountHolderName" />: ${account.accountHolderName}</p>
    <p><spring:message code="lbl.balance" />: ${account.balance}</p>

</body>
</html>
