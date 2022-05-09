<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Preferiti"/>
</jsp:include>

<div style="padding: 20px; margin-top: 20px">
    <h1>WISHLIST</h1>
    <i class="material-icons md-48 md-light">favorite</i>
    <h3>Tutti i cellulari che hai intenzione di acquistare o a cui semplicemente sei interessato.</h3>
    <c:forEach items="${preferiti}" var="cellulare">
        <div class="prodotti">
            <a href="cellulare_servlet?id=<c:out value="${cellulare.id}"/>">
                <img class="imm_prod_index" src="images/${cellulare.nome}.jpg" alt="immagine cellulare">
            </a>
            <form action="rimuovi_preferiti_servlet" method="get" >
                <input type="hidden" name="idCellulare" value="${cellulare.id}">
                <input type="submit" class="bottone" value="Rimuovi">
            </form>
        </div>
    </c:forEach>

    <c:if test="${not empty preferiti}">
        <form method="get" action="rimuovi_preferiti_servlet">
            <input type="submit" class="bottone" name="svuota" value="Svuota">
        </form>
    </c:if>

    <c:if test="${empty preferiti}">
        <div style="padding: 10px">
            <h3>Nessun prodotto nella WishList.</h3>
        </div>
    </c:if>
</div>
<div style="clear: both"></div>

<%@include file="footer.jsp" %>
