<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Utenti"/>
</jsp:include>

<div id="contenitore_utenti">
    <div style="overflow-x: auto;">
        <table id="tutenti">
            <tr>
                <th class="bordi id" >id</th>
                <th class="bordi username" >Username</th>
                <th class="bordi nome" >Nome</th>
                <th class="bordi cognome" >Cognome</th>
                <th class="bordi data" >Data di Nascita</th>
                <th class="bordi email" >Email</th>
                <th class="bordi sesso" >Sesso</th>
                <th class="bordi indirizzo" >Indirizzo</th>
                <th class="bordi admin" >Admin</th>
                <th class="bordi ordini" >Ordini</th>
                <th class="bordi azioni" >Azioni</th>
            </tr>
            <jsp:useBean id="utenti" scope="request" type="java.util.List"/>
            <c:forEach items="${utenti}" var="utente">
                <tr>
                    <td class="bordi id">${utente.id}</td>
                    <td class="bordi username">${utente.username}</td>
                    <td class="bordi nome">${utente.nome}</td>
                    <td class="bordi cognome">${utente.cognome}</td>
                    <td class="bordi data">${utente.dataDiNascita}</td>
                    <td class="bordi email">${utente.email}</td>
                    <td class="bordi sesso">${utente.sesso}</td>
                    <td class="bordi indirizzo">Via ${utente.via} ${utente.nCivico}, ${utente.citta} (${utente.provincia})</td>
                    <td class="bordi admin">${utente.admin ? "Si" : "No"}</td>
                    <td class="bordi">
                        <form action="dettagli_servlet" method="get">
                            <input type="hidden" name="id" value="${utente.id}">
                            <input type="submit" value="Dettagli" class="bottone">
                        </form>
                    </td>
                    <td class="bordi">
                        <form action="rimuovi_utente_servlet" method="post">
                            <input type="hidden" name="id" value="${utente.id}">
                            <input type="submit" class="bottone" name="rimuovi" value="Rimuovi">
                        </form>
                        <c:if test="${!utente.admin}">
                            <a href="rendi_amministratore_servlet?id=${utente.id}">
                                <button class="bottone">Rendi Admin</button>
                            </a>
                        </c:if>
                        <c:if test="${utente.admin}">
                            <a href="rendi_amministratore_servlet?id=${utente.id}">
                                <button class="bottone">Togli Admin</button>
                            </a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div style="clear:both "></div>

<%@include file="footer.jsp" %>
