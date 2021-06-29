<%-- 
    
    Created on : 01/06/2021, 03:09:03 PM
    Author     : Esteban
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="cartelera" uri="/WEB-INF/tlds/cartelera" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NCG Cinema</title>
        <link href="css/principal.css" rel="stylesheet" type="text/css"/>
        <link href="css/img.css" rel="stylesheet" type="text/css"/>
        <link href="css/Pop.css" rel="stylesheet" type="text/css"/>
        <script src="js/PopupMenu.js" type="text/javascript"></script>
        <script src="js/tablero.js" type="text/javascript"></script>
        <script src="js/cargarTabla2.js" type="text/javascript"></script>
        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    </head>
    <jsp:directive.include file="header.jsp" />
    <body background ="images/principal.png">

        <div id="wrapper">

            <div id="contents">
                <main>
                    <form method="GET" action="AgregarTiquete">
                        <section id="cartelera">
                            <jsp:useBean id="g2" class="modelo.beans.ConjuntoProyeccion" scope="application"></jsp:useBean>
                            ${cartelera:obtenerCartelera(g2, 6)}
                            <jsp:directive.include file="footer.jsp" />
                        </section>
                    </form>
                </main>
            </div>
            <form method="GET" action="AgregarTiquete">
                <div id="page-mask">

                    <div id="pop-up" onclick="alternar();">
                        <img id="pop-up-img"  alt="">
                    </div>

                    <center>
                        <img src="images/fondoAzul.jpeg" alt=""/>
                    </center>
                </div>
            </form>

            <nav>

            </nav>

        </div>


        <nav>

        </nav>
    </body>

</html>