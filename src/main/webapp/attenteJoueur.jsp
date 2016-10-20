<%-- 
    Document   : attenteJoueur
    Created on : 18 oct. 2016, 16:21:33
    Author     : yves ngambali
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page d attente de joueur</title>
        <link href="CSS/forme.css" rel="stylesheet" type="text/css"/>
        <script src="JS/jquery-3.1.1.js" type="text/javascript"></script>
        <script type="text/javascript">
            //setInterval("alert("echo"),location.reload(forceGet), 5000);
            //setInterval(function(){ alert("Hello"); }, 5000);
            setInterval(function(){ location.reload(true); }, 5000);
        </script>
    </head>
    <body>
        <div class="div1">Page d'attente joueurs avec partie cr&eacute;ee</div>
        
        <p class="shadow">Vous &ecirc;tes: ${joueuractuel}</p> <span class="shadow">Noms des joueurs pr&ecirc;ts:</span><br><br><br>
        <div class="carre">
            <!-- scan la table joueurs et append le nom+br>-->
            <c:forEach var="displayjoueur" items="${nomjoueur}">
                ${displayjoueur.pseudo} <br>
            </c:forEach>
        </div>
        <div class="lancerjeu">
            <input type="button" value="lancer le jeu" onclick="location.href='lancerpartie'">
        </div>
    </body>
</html>
