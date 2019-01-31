<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: darek
  Date: 31.01.19
  Time: 08:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../base/header.jsp"%>

<section class="container">
    <form:form method="post" modelAttribute="user">
        <form:input path="username" placeholder="Username" cssClass="form-control"/>
        <form:errors path="username" element="div" cssClass="badge badge-danger"/>
        <c:if test="${not empty loginErr}"><div class="badge badge-danger">${loginErr}</div></c:if>

        <form:password path="password" placeholder="Password" cssClass="form-control"/>
        <form:errors path="password" element="div" cssClass="badge badge-danger"/>
        <c:if test="${not empty pwdErr}"><div class="badge badge-danger">${pwdErr}</div></c:if>

        <form:password path="repeatPwd" placeholder="Repeat password" cssClass="form-control"/>
        <form:errors path="repeatPwd" element="div" cssClass="badge badge-danger"/>

        <form:input path="email" placeholder="eMail" cssClass="form-control"/>
        <form:errors path="email" element="div" cssClass="badge badge-danger"/>


        <input type="submit" value="Register"/>
    </form:form>
</section>

<%@include file="../base/footer.jsp"%>