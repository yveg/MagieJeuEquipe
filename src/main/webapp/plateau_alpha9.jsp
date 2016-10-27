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
        <script src="JS/magie.js" type="text/javascript"></script>
        <script type="text/javascript">
              
             $(document).ready(function () {
             avatar();
                setInterval(function () {
                    chargeZoneCartesJoueurAct();
                    charge_ajax_zone_autrej();
                    charge_ajax_zone_eventinfo();
                    charge_ajax_zone_menuactionj();
                     }, 1000);
            });
        </script>
    </head>
    <body >
        <h1>Plateau du jeu Magie en cours</h1>
        <section>
            <div class="infoj">
                <p class="shadow">Vous &ecirc;tes: ${joueuractuel}<div class="avatar">ici photo</div></p>
                <p class="shadow">le tour est &agrave;: ${tour}</p>
                
            </div>

            <div class="evenet">
                <span class="essai">an user has been slain<br> Pentakill</span>
            </div>

            <div class="menujoueur">

                <div align="center">
                    <p class="jcarte">
                        Tes cartes d'ingr&eacute;dients s'affichent ici:<br>
                    </p>
                </div>
                </p>
                <hr class="style13">


                <p>Voici tes action possibles:</p>

                <p>
                <div class="menuactionj">
                   Ici s'affichent les sorts disponibles
                </div>
                </p>

                <section class="listej">
                    <form>
                        <p> version java Selectionne un joueur ici: &nbsp;
                            <select name="victime" size="1" onselect="">
                                <c:forEach var="displayjoueur" items="${joueurs}">
                                    <c:if test="${joueuractuel != displayjoueur.pseudo}">
                                        <option>
                                            <c:out value="${displayjoueur.pseudo}"></c:out>
                                        </c:if>
                                    </c:forEach>

                            </select>
                        </p>
                        <p>
                            <label for="choix_joueurs2">(Optionnel)Entre un nom de joueur java : &nbsp;</label>
                            <input list="player2" type="text" id="choix_joueurs2" >
                            <datalist id="player2">
                                <c:forEach var="displayjoueur" items="${joueurs}">
                                    <c:if test="${joueuractuel != displayjoueur.pseudo}">

                                        <c:out value="<option value='${displayjoueur.pseudo}'>" ></c:out>
                                    </c:if>
                                </c:forEach>
                            </datalist>
                        </p>

                    </form>
                </section>

            </div><!--fin menujoueur-->


            <hr class="style18">mmmmm<br>
            <div class="autrej">
              Ici seront les cartes des autres joeurs.
            </div>

            <hr class="style11">
            </body>
            </html>
