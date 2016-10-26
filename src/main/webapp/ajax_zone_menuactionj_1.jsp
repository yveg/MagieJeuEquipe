<%-- 
    Document   : ajax_zone_menuactionj
    Created on : 26 oct. 2016, 15:03:55
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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