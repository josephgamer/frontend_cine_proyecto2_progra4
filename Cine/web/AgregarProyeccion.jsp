<%-- 
    Document   : AgregarProyeccion
    Created on : 07/06/2021, 03:08:15 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Proyeccion</title>
    </head>
    <body>
        <form class='profe' method="GET" action="AgregarProyeccion">
            <table class="agregaProyeccion" action="AgregarProyeccion">

                <tr>
                    <td class="etiqueta">Escoger fecha Pelicula:&nbsp;</td>
                    <td class="campo">  
                        <input type="date" name="fecha" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd")
                                                   .format(java.util.Calendar.getInstance().getTime())%>"/>
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">Escoger Pelicula:&nbsp;</td>
                    <td class="campo"> 
                        <select id="peli" name="peli">
                            <%
                                modelo.beans.ConjuntoPelicula cp = new modelo.beans.ConjuntoPelicula();
                                out.println(cp.verNombresPelis());
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">Escoger hora:&nbsp;</td>
                    <td class="campo">  
                        <select id = "hora" name = "hora">
                            <option size = '1'>
                                0800
                            </option>
                            <option size = '1'>
                                1000
                            </option>
                            <option size = '1'>
                                1200
                            </option>
                            <option size = '1'>
                                1400
                            </option>
                            <option size = '1'>
                                1600
                            </option>
                            <option size = '1'>
                                1800
                            </option>
                            <option size = '1'>
                                2000
                            </option>
                            <option size = '1'>
                                2100
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">Agregar Sala:&nbsp;</td>
                    <td class="campo">
                        <select id = "sala" name = "sala">
                            <%
                                modelo.beans.ConjuntoSala cs = new modelo.beans.ConjuntoSala();
                                out.println(cs.verSalas());
                            %>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td colspan="2" class="botones">
                        <button type="submit">Registrar</button>
                    </td>
            </table>
        </form>
        <p>
            <a href="PrincipalAdmin.jsp">Volver</a>
        </p>               

    </body>
</html>
