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
        <h1>Plateau du jeu Magie en cours</h1>
        <section>
            <div class="infoevent">
        <p class="shadow">Vous &ecirc;tes: ${joueuractuel}</p>
        <p class="shadow">le tour est &agrave;: ${tour}</p>
            </div>
            
            <div class="evenet">
                <span class="essai">an user has been slain<br> Pentakill</span>
            </div>
            
            <div class="menujoueur">
        <p>voici tes cartes:<br>
            <c:forEach var="displayjoueur" items="${joueurs}">
                    <c:if test="${joueuractuel == displayjoueur.pseudo}">

                        <c:out value="${displayjoueur.pseudo}"></c:out>&nbsp;&nbsp;
                    <div class="avatar"></div>
                        <c:forEach var="displayingredient" items="${displayjoueur.ingredients}"> d ${displayjoueur.ingredients} 5
                            <input type="image"  src="Images/dos2carte/0001.png" onclick="setidcard" ></input> &nbsp;&nbsp;  
                        </c:forEach>
                    </c:if>
            </c:forEach>
                            <div align="center">
                                <p class="jcarte">
                                    Tes cartes d'ingr&eacute;dients s'affichent ici:<br>
                                </p>
                            </div>
        </p>
        <hr class="style13">
        
        
        <p>voici tes action possibles:</p>
        
        <form >
            <p  class="boutton">
            <input  type="button" value="INVISIBILITE"/> &nbsp;
            <input type="button" value="FILTRE D’AMOUR"/>&nbsp;
            <input type="button" value="HYPNOSE"/> &nbsp;
            <input type="button" value="DIVINATION"/>&nbsp;
            <input type="button" value="SOMMEIL-PROFOND"/> &nbsp;
             </p>
        </form>
       </div>
            
            
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
