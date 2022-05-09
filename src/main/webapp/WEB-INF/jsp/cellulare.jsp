<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Cellulare"/>
</jsp:include>

<div>
    <div>
        <h1>${cellulare.nome}</h1>
        <img alt="immagine cellulare" src="images/${cellulare.nome}.jpg" width="300px" height="300px">
        <p> NOME: ${cellulare.nome}<br>
            MARCA: ${cellulare.marca}<br>
            SCHERMO: ${cellulare.schermo}<br>
            RAM: ${cellulare.ram}<br>
            MEMORIA: ${cellulare.memoria}<br>
            FOTOCAMERA MP: ${cellulare.fotocamera}<br>
            BATTERIA MAH: ${cellulare.batteria}<br>
            PREZZO: ${cellulare.prezzo} euro<br>
        </p>

        <form action="carrello_servlet" method="post">
            <label for="quant">Quantita'</label>
            <input type="number" name="quant" id="quant" min="1" max="10" value="1">
            <input type="hidden" value="${cellulare.id}" id="id" name="id">
            <input type="submit" value="Aggiungi al carrello">
        </form>
    </div>
    <div>
        <form action="preferiti_servlet" method="post">
            <input type="hidden" name="id" value="${cellulare.id}">
            <input type="submit" value="Aggiungi ai preferiti">
        </form>
        <c:if test="${utente!=null && utente.admin}">
            <form action="amministratore_cellulare_servlet" method="post">
                <input type="hidden" name="id" value="${cellulare.id}">
                <input type="submit" name="modifica" value="Modifica">
                <input type="submit" name="rimuovi" value="Rimuovi">
            </form>
        </c:if>
    </div>
</div>

<%@include file="footer.jsp" %>
