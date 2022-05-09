<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="${operazione} cellulare"/>
</jsp:include>

<div id="contenitore_admin">
    <c:if test="${notifica != null}">
        <h1>${operazione} cellulare</h1>
        <h2>${notifica}</h2>
    </c:if>

    <c:if test="${notifica == null}">
        <h3>Riempi tutti i campi!</h3>
        <form action="amministratore_modifica_inserimento_cellulare_servlet" method="post" enctype="multipart/form-data" >
            <input type="hidden" name="id" value="${cellulare.id}">
            <input type="hidden" name="operazione" value="${operazione}">

            <table id="tleft">
                <tr>
                    <td><h3>Nome</h3></td>
                    <td><input class="textform" type="text" name="nome" value="${cellulare.nome}" required></td>
                </tr>
                <tr>
                    <td><h3>Marca</h3></td>
                    <td><input class="textform" type="text" name="marca" value="${cellulare.marca}" required></td>
                </tr>
                <tr>
                    <td><h3>Schermo</h3></td>
                    <td><input type="number" class="textform" name="schermo" min="1" step="0.01" value="${cellulare.schermo}" required></td>
                </tr>
                <tr>
                    <td><h3>Ram</h3></td>
                    <td><input type="number" min="1" class="textform" name="ram" value="${cellulare.ram}" required>
                    </td>
                </tr>
                <tr>
                    <td><h3>Memoria</h3></td>
                    <td><input type="number" min="16" class="textform" name="memoria" value="${cellulare.memoria}" required>
                    </td>
                </tr>
                <tr>
                    <td><h3>Fotocamera</h3></td>
                    <td><input type="number" min="1" class="textform" name="fotocamera" value="${cellulare.fotocamera}" required>
                    </td>
                </tr>
                <tr>
                    <td><h3>Batteria</h3></td>
                    <td><input type="number" min="1000" class="textform" name="batteria" value="${cellulare.batteria}" required>
                    </td>
                </tr>
                <tr>
                    <td><h3>Prezzo</h3></td>
                    <td><input type="number" min="100" step="0.01" class="textform" name="prezzo" value="${cellulare.prezzo}" required>
                    </td>
                </tr>

                <c:if test="${operazione.equalsIgnoreCase('inserimento')}">
                    <tr>
                        <td><h3>Immagine(Nome file e nome cellulare devono coincidere)</h3></td>
                        <td><input type="file" name="foto"></td>
                    </tr>

                </c:if>
            </table>
            <input style="margin-top: 30px; margin-left: 140px" type="submit" class="bottone" value="${operazione}"><br>
        </form>
    </c:if>

</div>
<div style="clear: both"></div>

<%@include file="footer.jsp" %>
