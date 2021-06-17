<%-- 
    Document   : Login
    Created on : 01/06/2021, 03:10:13 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <form action="ServicioLogin" method="post">
            <div class="imgcontainer">
                <img src="images/descarga.png" alt="Avatar" class="avatar" width="250" height="250">
            </div>

            <div class="container">
                <label for="uname"><p style=" text-align: center"><b>Username</b></p></label>
                <input type="text" placeholder="Enter Username" name="uname" 
                       style="display: block; margin: 0 auto; text-align:center; width:396px; height:30px">

                <label for="psw"><p style=" text-align: center"><b>Password</b></p></label>
                <input type="password" placeholder="Enter Password" name="psw" required 
                       style="display: block; margin: 0 auto; text-align:center; width:400px; height:30px">

                <p></p>

                <button type="submit" style="display: block; margin: 0 auto; width:200px; height:40px" 
                        onclick="redireccionLogin()">Login</button>
                <p>
                    <!--label>
                        <input type="checkbox" checked="checked" name="remember"> Remember me
                    </label-->
                    <a href="index.jsp" >Página principal</a>
                </p>
             <jsp:directive.include file="footer.jsp" />
            </div>
        </form>
    </body>
</html>
