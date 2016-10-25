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

            $(document).ready(function () {

                setInterval(function () {

                    $.getJSON("ajax_partie_demarree", function (dto) {
                        if (dto.demarree == true) {
                            location.href = "plateau";
                        }else{
                            $('#listeJoueurs').load("ajax_liste_joueurs_en_attente");
                        }
                    });

                    
                }, 1000);
            });
        </script>
    </head>
    <body>
        <div class="div1">Page d'attente joueurs avec partie cr&eacute;ee</div>

        <p class="shadow">Vous &ecirc;tes: ${joueuractuel}</p> <span class="shadow">Noms des joueurs pr&ecirc;ts:</span><br><br><br>
        <div class="carre" id="listeJoueurs">
            *** AJAX ***
        </div>
        <div class="lancerjeu">
            <a href="lancerpartie">
                <input type="button" value="lancer le jeu">
            </a>
        </div>
    </body>
</html>
