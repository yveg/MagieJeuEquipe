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
        <!--<script src="JS/magie.js" type="text/javascript"></script>-->
        <script type="text/javascript">
            alert('ciyciy');
            $(document).ready( function(){
                
                alert('coucou');
                setInterval( chargeZoneCartesJoueurAct, 1000 );
            }) );
        </script>
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
                

                <div class="avatar"></div>



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
                    <table>
                        <form class="sortilege">
                            <tr><td><input class="inviz" type="image" value="invisibility" src="Images/sort/invisibilite.png" alt="le joueur prend 1 carte(au hasard) chez tous ses adversaires
                                           Ingr&eacute;dients: corne de licorne + bave de crapaud" />&nbsp;
                                    <span class="invi">
                                        <br>Le joueur prend 1 carte au hasard chez tous ses adversaires<br>
                                        Ingr&eacute;dients n&eacute;cessaires: corne de licorne + bave de crapaud
                                    </span>
                                </td>
                                <td>
                                    <input class="inviz" type="image" value="filtre d'amour" src="Images/sort/elixir.png" alt="le joueur de votre choix vous donne la moitie de ses cartes(au hasard). S il ne possede qu une carte il a perdu" >&nbsp;
                                    <span class="invi">
                                        Le joueur de ton choix te donne la moiti&eacute; de ses cartes au hasard. S il ne poss&egrave;de qu une carte il a perdu.<br>
                                        Ingr&eacute;dients n&eacute;cessaires:  corne de licorne + sang de vierge
                                    </span>
                                </td>
                                <td>
                                    <input class="inviz" type="image"  value="hypnose" src="Images/sort/hypnose.png" />&nbsp;
                                    <span class="invi">
                                        Tu &eacute;change une carte de ton choix contre trois cartes au hasard  de ton adversaire<br>
                                        Ingr&eacute;dients n&eacute;cessaires:  bave de crapaud + lapis-lazuli
                                    </span>
                                </td>
                                <td>
                                    <input class="inviz" type="image"  value="sommeil" src="Images/sort/sommeil.png" />&nbsp;
                                    <span class="invi">
                                        Tu choisis une victime qui ne pourra pas lancer de sorts pendant 2 tours<br>
                                        Ingr&eacute;dients n&eacute;cessaires:  sang de vierge + bave de crapaud
                                    </span>
                                </td>
                                <td>
                                    <input class="inviz" type="image"  value="divination" src="Images/sort/divination.png" />&nbsp;
                                    <span class="invi">
                                        Tu peus voir les cartes de tous les autres joueurs<br>
                                        Ingr&eacute;dients n&eacute;cessaires: lapis-lazuli + aile-de chauve-souris
                                    </span>
                                </td>
                            </tr>
                        </form>
                    </table>
                </div>
                </p>

                <section class="listej">
                    <form>
                        <!--c foreach de joueurs de cette partie a faire
                        <p>
                            <label for="choix_joueurs">Entre un nom de joueur : &nbsp;</label>
                            <input list="player" type="text" id="choix_joueurs" >
        <datalist id="player">
          <option value="Thomas">
          <option value="Julien">
          <option value="Amaury">
          <option value="Edouard">
        </datalist>
                        </p>
                        -->


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
