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
        <hr class="style18">
        <div class="carre">
            <p class="shadow titre">Nom des joueurs en liste:</p>
            <!-- voir ingredients.joueur_id
            faire foreahc pour chaque ingredients+ display.ingredient.nom
            -->
            <p>
            <c:forEach var="displayjoueur" items="${joueurs}">
                <c:if test="${joueuractuel != displayjoueur.pseudo}">
                   
                    <c:out value="  ${displayjoueur.pseudo}"> </c:out>  &nbsp;&nbsp;
                           <c:forEach var="displayingredient" items="${displayjoueur.ingredients}">
                               <c:out   value ="  ${displayingredient.nom}" ></c:out><input type="image" id="" name="jcard_img01" src="Images/dos2carte/0001.png" onclick="setidcard" /> &nbsp;&nbsp; 555 
                    </c:forEach>
                        
                    
                   
                </c:if>
            </p>
            <hr class="style13">
                <!--<input type="image" name="jcard_img01" src="Images/dos2carte/002.jpg" /><br> &nbsp;&nbsp;-->
            </c:forEach>
        </div>

        <hr>
        <div>
            <p> nom joueur1 ${displayjoueur.pseudo} 
                <input type="image" name="jcard_img01" src="Images/dos2carte/00001.png" />&nbsp;&nbsp;
                <input type="image" id="" name="jcard_img01" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img02" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img03" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img04" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img05" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img06" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
            </p>

            <p> nom joueur2 ${displayjoueur[2].pseudo}
                <input type="image" name="jcard_img02" src="Images/dos2carte/0001.png" />&nbsp;&nbsp;
                <input type="image" id="" name="jcard_img07" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img08" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img09" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_im10" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img11" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img12" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
            </p>

            <p> nom joueur3 
                <input type="image" name="jcard_img03" src="Images/dos2carte/0001.png" />&nbsp;&nbsp;
                <input type="image" name="jcard_img01" src="Images/dos2carte/0001.png" />&nbsp; &nbsp;
                <input type="image" id="" name="jcard_img13" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img14" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img15" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img16" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img17" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
            </p>

        </div>
    </body>
</html>
