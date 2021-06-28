<%-- 
    Document   : Registro
    Created on : 16/06/2021, 03:33:44 PM
    Author     : YENDRI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de registro</title>
        <link href="css/registro.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="usuarios" class="modelo.beans.ConjuntoUsuario" scope="application">
        </jsp:useBean>

        <div id="wrapper">
            <header>
                <h1 >Formulario de registro de cliente</h1>
            </header>
            <br>

            </br>
            <form class='usu' method="GET" action="RegistroUsuario">
                <table class="formulario" action="RegistroUsuario">

                    <tr>
                        <td class="etiqueta">Id:&nbsp;</td>
                        <td class="campo">  
                            <input type="number" name="Id"
                                   min=100010001 max=999999999
                                   placeholder="(ID)"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">Nombre:&nbsp;</td>
                        <td class="campo">
                            <input name="Nombre" 
                                   placeholder="(Nombre)"/> 
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">Apellido:&nbsp;</td>
                        <td class="campo"> 
                            <input name="Apellido"
                                   placeholder="(Apellido)"/>
                        </td>
                    </tr>
                     <tr>
                        <td class="etiqueta">Contraseña:&nbsp;</td>
                        <td class="campo"> 
                            <input name="Contraseña" type="password"
                                   placeholder="(Numerico)"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="botones">
                            <button type="submit">Registrar</button>
                        </td>
                </table>
            </form>
            <p class='volver'>
                <a href="index.jsp" >Volver al pantalla principal</a>
            </p>

        </div>
    </body>
    <footer>
        <link rel="stylesheet" href="css/registro.css" type="text/css">
        <div>
            <h3>
                Total Soft Inc.&copy; Tsf,Inc
            </h3>
        </div>
    </footer>
</html>
