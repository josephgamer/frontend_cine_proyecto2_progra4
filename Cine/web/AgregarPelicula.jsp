<%-- 
    Document   : AgregarPelicula
    Created on : 07/06/2021, 03:07:27 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Pelicula</title>
    </head>
    <body>
        <form class='curs' method="POST" action="AgregarPeli" enctype="multipart/form-data">
                <table class="addSala" >
                    
                    <tr>
                        <td class="etiqueta">Imagen Pelicula:&nbsp;</td>
                        <td class="campo"> 
                            <input type="file" name="imagen"
                                   placeholder="2D, 3D, Imax"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">Nombre Pelicula:&nbsp;</td>
                        <td class="campo">  
                            <input name="nombre" id="nombre"
                                   placeholder="Nombre Pelicula"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="botones">
                            <button type="submit">Agregar Pelicula</button>
                        </td>
                    </tr>
                </table>
            </form>
        <p>
            <a href="PrincipalAdmin.jsp" >Ir a la pagina principal</a>
        </p>
    </body>
</html>
