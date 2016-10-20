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
        <script type="text/javascript">
            //setInterval("alert("echo"),location.reload(forceGet), 5000);
            //setInterval(function(){ alert("Hello"); }, 5000);
            setInterval(function () {
                location.reload(true);
            }, 5000);
        </script>
    </head>
    <body>
        <h1>Plateau du jeu en cours</h1>
        <p class="shadow">Vous &ecirc;tes: ${joueuractuel}</p>
        <p class="shadow">le tour est &agrave;: ${tour}</p>
        <hr>
        <div class="carre">
            <!-- scan la table joueurs et append le nom+br>-->
            <c:forEach var="displayjoueur" items="${joueurs}">
                ${displayjoueur.pseudo} &nbsp;&nbsp;
            </c:forEach>
        </div>
        <div>
            <p> nom joueur1 ${displayjoueur.pseudo} <input type="image" name="jcard_img01" src="Images/dos2carte/00001.png" />&nbsp;&nbsp;
                <input type="image" id="" name="jcard_img01" src="Images/dos2carte/00001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img02" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img03" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img04" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img05" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img06" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
            </p>

            <p> nom joueur2 <input type="image" name="jcard_img02" src="Images/dos2carte/0001.png" />&nbsp;&nbsp;
                <input type="image" id="" name="jcard_img071" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img08" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img09" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_im10" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img11" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
                <input type="image" id="" name="jcard_img12" src="Images/dos2carte/0001.png" />&nbsp;&nbsp; 
            </p>

            <p> nom joueur3 <input type="image" name="jcard_img03" src="Images/dos2carte/0001.png" />&nbsp;&nbsp;
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
