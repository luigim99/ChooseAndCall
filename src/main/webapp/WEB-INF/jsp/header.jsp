<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>
        ChooseAndCall/${param.pageTitle}
    </title>

    <link rel="icon" href="images/logo.png" type="image/png"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/header_footer.css" rel="stylesheet" type="text/css">
    <link href="css/carrello.css" rel="stylesheet" type="text/css">
    <link href="css/prodotto.css" rel="stylesheet" type="text/css">
    <link href="css/adminprodotto.css" rel="stylesheet" type="text/css">
    <link href="css/adminutenti.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="script/funzioni.js"></script>
</head>
<body>
<header>
    <nav class="barra">
        <a href="." id="logo_contenitore"><img id="logo_chooseandcall" src="images/logo.png" alt="logo"></a>

        <a class="marca" href="ricerca_servlet?query=Samsung" >Samsung</a>
        <a class="marca" href="ricerca_servlet?query=Apple" >Apple</a>
        <a class="marca" href="ricerca_servlet?query=Xiaomi" >Xiaomi</a>


        <div id="ricerca">
            <form action="ricerca_servlet" method="get">
                <input type="text" placeholder="Cerca..." name="query" id="q" onfocus="mettiBordo(this)" onblur="togliBordo(this)" value="<c:out value='${param.query}'/>">
                <button type="submit"><i class="material-icons md-24 md-light">search</i></button>
            </form>
        </div>

        <a href="carrello_servlet" style="float: right; padding-right: 20px; padding-top: 7px"><i id="carrello" class="material-icons md-36 md-light" onmouseover="inC(this)" onmouseout="outC(this)">shopping_cart</i></a>
        <a href="preferiti_servlet" style="float: right; padding-right: 20px; padding-top: 7px"><i id="favoriti" class="material-icons md-36 md-light" onmouseover="inF(this)" onmouseout="outF(this)">favorite</i></a>
        <div id="scelta_account">
            <a href="profilo_servlet" style="float: right; padding-right: 20px; padding-top: 7px"><i  id="account" class="material-icons md-36 md-light">account_circle</i></a>
            <c:choose>
                <c:when test="${utente == null}">
                    <div class="scelte_dropdown">
                        <form action="login_servlet" method="post" autocomplete="off">
                            <input class="textform" type="text" name="username" placeholder="Username"><br>
                            <input class="textform" type="password" name="password" placeholder="Password"><br>
                            <input class="bottone" type="submit" value="Login">
                        </form>
                        <hr style="border-color: darkgoldenrod">
                        <a style="padding: 8px; font-size: 20px" href="registrazione_servlet">Registrati</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="scelte_dropdown">
                        <h3>${utente.username}</h3>
                        <hr style="border-color: darkgoldenrod">

                        <c:if test="${utente.admin}">
                            <a style="padding-left: 8px" href="amministratore_cellulare_servlet">Aggiungi Cellulare</a>
                            <a style="padding-left: 8px" href="amministratore_utenti_servlet">Utenti</a>
                        </c:if>
                        <a style="padding-left: 8px" href="profilo_servlet">Il mio Profilo</a>

                        <form action="logout_servlet" style="text-align: center">
                            <input class="bottone" type="submit" value="Logout">
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <nav id="menu" style="font-size:30px;cursor:pointer" onclick="openBarra()"><i class="material-icons md-light md-36">menu</i></nav>

        <div id="barra_responsive">

            <span id="closeBarra" style="font-size:30px;cursor:pointer" onclick="closeBarra()">&times;</span>

            <a id="ricercaBarraResp">
                <form action="ricerca_servlet" method="get">
                    <input type="text" placeholder="Cerca..." name="query"  onfocus="mettiBordo(this)" onblur="togliBordo(this)" value="<c:out value='${param.query}'/>">
                    <button type="submit"><i class="material-icons md-24 md-light">search</i></button>
                </form>
            </a>

            <a href="carrello_servlet" ><i class="material-icons md-36 md-light"  onmouseover="inC(this)" onmouseout="outC(this)">shopping_cart</i></a>
            <a href="preferiti_servlet" ><i class="material-icons md-36 md-light"  onmouseover="inF(this)" onmouseout="outF(this)">favorite</i></a>

            <c:choose>
                <c:when test="${utente == null}">
                    <a>
                        <form action="login_servlet" method="post" autocomplete="off">
                            <input class="textform" type="text" name="username" placeholder="Username"><br>
                            <input class="textform" type="password" name="password" placeholder="Password"><br>
                            <input class="bottone" type="submit" value="Login">
                        </form>
                    </a>
                    <a href="registrazione_servlet">Registrati</a>
                </c:when>
                <c:otherwise>
                    <c:if test="${utente.admin}">
                        <a href="admin_prodotto_servlet">Aggiungi </a>
                        <a href="admin_utenti_servlet">Utenti</a>
                    </c:if>
                    <a href="profilo_servlet">Il mio Profilo</a>

                    <a href="logout_servlet">Logout</a>
                </c:otherwise>
            </c:choose>
        </div>
        </nav>

    <button id="goup"><i class="material-icons md-48 md-light">keyboard_arrow_up</i></button>
    <c:set var = "alert" scope = "session" value = "${false}"/>
    <c:if test="${utente != null && alert==false}">
        <br><br>
        <div id="alert">
            <span id="closebtn" onclick="nascondiElemento()">&times;</span>
            <h3>Ciao ${utente.nome}!</h3>
        </div>
    </c:if>
</header>

<script>
    $(document).ready(function () {
        var btn = $("#goup");

        $(window).scroll(function () {
            if ($(window).scrollTop() > 300) {
                btn.css("display", "block");
            } else {
                btn.css("display", "none");
            }
        });

        btn.on("click", function (e) {
            e.preventDefault();
            $("html,body").animate({scrollTop: 0}, '300');
        });
    });
</script>

