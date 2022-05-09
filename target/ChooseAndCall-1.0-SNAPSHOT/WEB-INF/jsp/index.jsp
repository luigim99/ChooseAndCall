<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Model.Cellulare" %>
<%@ page import="java.util.List" %>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="HomePage"/>
</jsp:include>
<div class="slideshow-container">

<div class="mySlides">
    <a href="ricerca_servlet?query=Samsung">
        <img src="images/slides1" style="width:100%;height:100%">
    </a>
</div>

<div class="mySlides">
    <a href="ricerca_servlet?query=Apple">
        <img src="images/slides2" style="width:100%;height:100%">
    </a>
</div>

<div class="mySlides">
    <a href="ricerca_servlet?query=Xiaomi">
        <img src="images/slides3" style="width:100%;height:100%">
    </a>
</div>

<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<div id="evidenza">
    <div class="sezione_prodotti">
        <h1>Cellulari piu' venduti</h1>
        <c:forEach items="${venduti}" var="cellulare">
            <div class="prodotti">
                <a href="cellulare_servlet?id=<c:out value="${cellulare.id}"/>">
                    <img class="imm_prod_index" src="images/${cellulare.nome}.jpg" alt="immagine cellulare">
                    <p>${cellulare.prezzo} euro</p>
                </a>
            </div>
        </c:forEach>
    </div>
</div>


<div id="confronta">
    <a href="confronta_servlet">
        <h1> Confronta i cellulari per trovare il migliore adatto alle tue esigenze </h1>
        <img class="imm_prod_index" src="images/${cellulare1.nome}.jpg" alt="immagine cellulare">
        <h1 style="display: inline"> VS </h1>
        <img class="imm_prod_index" src="images/${cellulare2.nome}.jpg" alt="immagine cellulare">
    </a>
</div>



<script>
    let slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        if (n > slides.length) {slideIndex = 1}
        if (n < 1) {slideIndex = slides.length}
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slides[slideIndex-1].style.display = "block";
    }

</script>

<%@include file="footer.jsp" %>
