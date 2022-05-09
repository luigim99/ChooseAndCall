<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Confronto"/>
</jsp:include>

<div>
    <c:choose>
        <c:when test="${cellulare1 == null && cellulare2 == null}">
            <div style="padding-top: 50px">
                <h1>Scegli i due cellulari da confrontare</h1>
                <form action="confronta_servlet" method="get">
                    <input type="text" placeholder="Cerca cellulare..." name="cellulare1"  list="ricerca_datalist1" onkeyup="ricerca1(this.value)" onfocus="mettiBordo(this)" onblur="togliBordo(this)" onsubmit="" value="<c:out value='${param.cellulare}'/>" required>
                    <datalist id="ricerca_datalist1"></datalist>
                    <input type="text" placeholder="Cerca cellulare..." name="cellulare2"  list="ricerca_datalist2" onkeyup="ricerca2(this.value)" onfocus="mettiBordo(this)" onblur="togliBordo(this)" value="<c:out value='${param.cellulare}'/>" required>
                    <datalist id="ricerca_datalist2"></datalist>
                    <button type="submit" class="bottone" id="confronta">Confronta</button>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <div>
                <h1>${cellulare1.nome}vs${cellulare2.nome}</h1>
                    <a href="cellulare_servlet?id=<c:out value="${cellulare1.id}"/>">
                        <img class="imm_prod_index" src="images/${cellulare1.nome}.jpg" alt="immagine cellulare1">
                    </a>
                    <a href="cellulare_servlet?id=<c:out value="${cellulare2.id}"/>">
                        <img class="imm_prod_index" src="images/${cellulare2.nome}.jpg" alt="immagine cellulare2">
                    </a>
                    <p>${cellulare1.marca}  marca  ${cellulare2.marca}  </p>
                    <p>${cellulare1.schermo}   schermo    ${cellulare2.schermo}  </p>
                    <p>${cellulare1.ram}   ram    ${cellulare2.ram}  </p>
                    <p>${cellulare1.memoria}   memoria    ${cellulare2.memoria}  </p>
                    <p>${cellulare1.fotocamera}   fotocamera    ${cellulare2.fotocamera}  </p>
                    <p>${cellulare1.batteria}   batteria    ${cellulare2.batteria}  </p
                    <p>${cellulare1.prezzo} prezzo ${cellulare2.prezzo}  </p>

                    <form action="confronta_servlet" method="post">
                        <input type="submit" value="Confronta di nuovo">
                    </form>
            </div>
        </c:otherwise>
</c:choose>
</div>



<%@include file="footer.jsp" %>
