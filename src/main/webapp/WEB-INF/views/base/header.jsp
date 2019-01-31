<%--
  Created by IntelliJ IDEA.
  User: darek
  Date: 31.01.19
  Time: 07:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="doc_header.jsp"%>

<section class="container">
    <header>
        <section class="logo col-3">
            APP
        </section>
        <nav class="col-9">
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                <c:if test="${empty user}">
                    <li><a href="${pageContext.request.contextPath}/user/login">Login</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/register">Register</a></li>
                </c:if>

            </ul>
        </nav>
    </header>
</section>
