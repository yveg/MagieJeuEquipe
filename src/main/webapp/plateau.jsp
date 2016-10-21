<%-- 
    Document   : plateau
    Created on : 20 oct. 2016, 11:05:23
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/forme.css" rel="stylesheet" type="text/css"/>
        <script src="JS/jquery-3.1.1.js" type="text/javascript"></script>
        <!--<script type="text/javascript">
            //setInterval("alert("echo"),location.reload(forceGet), 5000);
            //setInterval(function(){ alert("Hello"); }, 5000);
            setInterval(function () {
                location.reload(true);
            }, 5000);
            
            get
        </script>
        -->
    </head>
    <body>
        <h1>Plateau du jeu en cours</h1>
        <p class="shadow">Vous &ecirc;tes: ${joueuractuel}</p>
        <p class="shadow">le tour est &agrave;: ${tour}</p>
        
        <p>voici tes cartes:<br>
            <c:forEach var="displayjoueur" items="${joueurs}">
                    <c:if test="${joueuractuel == displayjoueur.pseudo}">

                        <c:out value="${displayjoueur.pseudo}"></c:out>&nbsp;&nbsp;
                        <c:forEach var="displayingredient" items="${joueurs[0].ingredients}">
                            <input type="image"  src="Images/dos2carte/0001.png" onclick="setidcard" ></input> &nbsp;&nbsp;  
                        </c:forEach>
                    </c:if>
            </c:forEach>
        </p>

        <p>voici tes action possibles:<br>
            <input class="boutton" type="button" value="INVISIBILITE"/> &nbsp;&nbsp;<input type="button" value="
                                                                           FILTRE D’AMOUR"/>&nbsp;&nbsp;<input type="button" value="HYPNOSE"/> &nbsp;&nbsp;<input type="button" value="
                                                                           DIVINATION"/>&nbsp;&nbsp;<input type="button" value="SOMMEIL-PROFOND"/> &nbsp;&nbsp;
        </p>
        <hr class="style18">mmmmm<br>
        <div class="carre">
            <p class="shadow titre">Nom des joueurs en liste:</p>
            <p>
                <c:forEach var="displayjoueur" items="${joueurs}">
                    <c:if test="${joueuractuel != displayjoueur.pseudo}">

                        <c:out value="${displayjoueur.pseudo}"></c:out>&nbsp;&nbsp;
                        <c:forEach var="displayingredient" items="${displayjoueur.ingredients}">
                            <input type="image"  src="Images/dos2carte/0001.png" onclick="setidcard" ></input> &nbsp;&nbsp;  
                        </c:forEach>
                    </c:if>
                </p>
                <hr class="style13">
            </c:forEach>
        </div>

        <hr class="style11">
    </body>
</html>
