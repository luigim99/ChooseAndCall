<%@ page import="Model.Cellulare" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Ricerca"/>
</jsp:include>

<div>
    <div class="filtri">
        <form action="ricerca_servlet" method="post">
            <h1 style="padding-top: 50px">Cerca il cellulare piu' adatto alle tue esigenze</h1>

            <label for="prezzo">Prezzo</label>
            <select id="prezzo" name="prezzo">
                <option value="1500" selected>1500</option>
                <option value="1000">1000</option>
                <option value="800">800</option>
                <option value="500">500</option>
                <option value="300">300</option>
                <option value="200">200</option>
                <option value="100">100</option>
            </select>

            <label for="schermo">Schermo</label>
            <select id="schermo" name="schermo">
                <option value="4.5" selected>4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
            </select>

            <label for="ram">Ram</label>
            <select id="ram" name="ram">
                <option value="2" selected>2</option>
                <option value="4">4</option>
                <option value="6">6</option>
                <option value="8">8</option>
                <option value="16">16</option>
            </select>

            <label for="memoria">Memoria</label>
            <select id="memoria" name="memoria">
                <option value="32" selected>32</option>
                <option value="64">64</option>
                <option value="128">128</option>
                <option value="256">256</option>
                <option value="512">512</option>
            </select>

            <label for="fotocamera">Fotocamera</label>
            <select id="fotocamera" name="fotocamera">
                <option value="10" selected>10</option>
                <option value="20">20</option>
                <option value="30">30</option>
                <option value="50">50</option>
                <option value="100">100</option>
            </select>

            <label for="batteria">Batteria</label>
            <select id="batteria" name="batteria">
                <option value="1500" selected>1500</option>
                <option value="2000">2000</option>
                <option value="3000">3000</option>
                <option value="4000">4000</option>
                <option value="5000">5000</option>
            </select>

            <label for="ordine">Ordina i risultati in base a</label>
            <select id="ordine" name="ordine">
                <option value="DESC" selected>Prezzo decrescente</option>
                <option value="ASC">Prezzo crescente</option>
            </select>

            <input type="submit" value="Ricerca">
        </form>
    </div>


    <div class="sezione_prodotti">
        <% ArrayList<Cellulare> cellulari= (ArrayList<Cellulare>) request.getAttribute("cellulari");%>
        <% for(Cellulare cellulare:cellulari){%>
        <div class="prodotti">
            <a href="cellulare_servlet?id=<%=cellulare.getId()%>">
                <img src="images/<%=cellulare.getNome()%>.jpg" width="150px" height="150px" alt="immagine_prodotto_<%=cellulare.getNome()%>">
            </a>
            <p><b><%=cellulare.getNome()%></b></p>
        </div>
        <% } %>
    </div>
</div>

<%@include file="footer.jsp" %>