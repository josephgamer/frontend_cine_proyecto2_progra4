<%-- 
    Document   : AgregarSala
    Created on : 07/06/2021, 03:09:06 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Sala</title>
    </head>
    <body>
        <form class='curs' method="GET" action="AgregarSala">
                <table class="addSala" action="AgregarSala">
                    
                    <tr>
                        <td class="etiqueta">Tipo:&nbsp;</td>
                        <td class="campo"> 
                            <input name="tipo"
                                   placeholder="2D, 3D, Imax"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">Precio:&nbsp;</td>
                        <td class="campo">  
                            <input type = "number" name="precio" id="precio"
                                   placeholder="Precio entrada"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="botones">
                            <button type="submit">Agregar Sala</button>
                        </td>
                    </tr>
                </table>
            </form>
        <p>
            <a href="PrincipalAdmin.jsp" >Ir a la pagina principal</a>
        </p>
    </body>
</html>
