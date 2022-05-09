<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Errore ${requestScope['javax.servlet.error.status_code']}"/>
</jsp:include>

<section>
    <h1>Errore ${requestScope['javax.servlet.error.status_code']}</h1>
    <h1>${requestScope['javax.servlet.error.exception']}</h1>
</section>
<%@include file="footer.jsp"%>
