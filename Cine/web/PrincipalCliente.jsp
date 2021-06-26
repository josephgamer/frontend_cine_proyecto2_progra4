<%-- 
    Document   : PrincipalCliente
    Created on : 01/06/2021, 04:20:03 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="cartelera" uri="/WEB-INF/tlds/cartelera" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal Cliente</title>
        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
        <link href="css/principal.css" rel="stylesheet" type="text/css"/>
        <link href="css/img.css" rel="stylesheet" type="text/css"/>
        <link href="css/Pop.css" rel="stylesheet" type="text/css"/>
    <div class="logo">

        <img src="images/cartelera.jpeg">

        </head>
        <body>
            <div>
                <td class="campo">
                    <input style="position: absolute; right: 1;" type="search" size="30"
                           id="search" name="search" autocomplete="off" 
                           placeholder=" Search"/>
                </td>
                <td id="b1" class="controles" colspan="2"> 
                    <button style="position: absolute; right: 1;" type="button">Search movies</button>
                </td>
                <p>
            <!--label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label-->
            <a href="index.jsp" >Cerrar sesión</a>
        </p>
            </div>
            <div id="wrapper">

                <div id="contents">
                    <main>
                        <form method="GET" action="AgregarTiquete">
                            <section id="cartelera">
                                <jsp:useBean id="g2" class="modelo.beans.ConjuntoProyeccion" scope="application"></jsp:useBean>
                                ${cartelera:obtenerCartelera(g2, 6)}
                            </section>
                        </form>
                    </main>
                </div>
                <form method="GET" action="AgregarTiquete">
                    <div id="page-mask">
                        <div id="pop-up" onclick="alternar();">
                            <img id="pop-up-img"  alt="">
                        </div>
                    </div>
                </form>

            </div>

        </body>
    
</html>
