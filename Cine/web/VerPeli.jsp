<%-- 
    Document   : VerPelis
    Created on : 08/06/2021, 05:51:05 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="galeria" uri="/WEB-INF/tlds/galeria" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Peliculas Disponibles</title>
        <script src="js/getJSON.js" type="text/javascript"></script>
        <script src="js/scripts.js" type="text/javascript"></script>
        <link href="css/img.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--div class="parte1">
            <table id="tabla2"></table>
        </div-->
        <jsp:useBean id="g1" class="modelo.beans.ConjuntoPelicula" scope="application"></jsp:useBean>
        ${galeria:obtenerGaleria(g1, 5)}
        <p>
            <a href="PrincipalAdmin.jsp" >Volver</a>
        </p>
    </body>
</html>
