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
        <script type="text/javascript">
            setInterval("location.reload(forceGet);", 5000);
        </script>
    </head>
    <body>
        <h1>Page d'attente joueur avec partie cr&eacute;ee</h1>
        
        <div>joueur de ce browser:${nomjj}, noms des joueurs:  <br>
            <!-- scan la table joueurs et append le nom+br>-->
            <c:forEach var="displayjoueur" items="${nomjoueur}">
                ${displayjoueur.nomj} <br>
            </c:forEach>
        </div>
        <div class="lancerjeu">
            <input type="button" value="lancer le jeu" onclick="/lancerjeu">
        </div>
    </body>
</html>
