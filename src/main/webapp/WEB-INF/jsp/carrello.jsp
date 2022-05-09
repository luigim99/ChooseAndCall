<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Carrello"/>
</jsp:include>

<div id="carrello_contenitore">
    <h1>Carrello <i class="material-icons md-48 md-light">shopping_cart</i></h1>
    <c:if test="${empty carrello.cellulari}">
        <div id="messaggio">
            <h3>Nessun prodotto nel carrello.</h3>
        </div>
    </c:if>

    <c:forEach items="${carrello.cellulari}" var="cellQuant">
        <div id="prodotti_carrello">
            <a href="cellulare_servlet?id=${cellQuant.cellulare.id}">
                <img class="imm_prod_ev" src="images/${cellQuant.cellulare.nome}.jpg" alt="immagine cellulare">
            </a>

            <h2>${cellQuant.cellulare.nome}</h2>
            <h5>QUANTITA': ${cellQuant.quantita}<br>
                PREZZO SINGOLO: ${cellQuant.cellulare.prezzo} &euro;<br>
                PREZZO TOTALE: ${cellQuant.prezzoTot} &euro; </h5>
            <form action="carrello_servlet" method="post">
                <input type="hidden" name="id" value="${cellQuant.cellulare.id}">
                <input type="submit" class="bottone" value="Rimuovi">
            </form>
        </div>
    </c:forEach>
</div>

<c:if test="${not empty carrello.cellulari}">
    <div id="acquisto">
        <h2><b>TOTALE:</b>${carrello.prezzoTot} &euro; </h2>

        <form action="acquisto_servlet" method="post">
            <input type="hidden" name="prezzoTot" value="${carrello.prezzoTot}">
            <input class="bottone" type="submit" value="Acquista">
        </form>
    </div>
</c:if>

<div style="clear: both"></div>

<%@include file="footer.jsp" %>
