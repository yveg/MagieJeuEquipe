<%-- 
    Document   : ajax_zone_eventinfo
    Created on : 26 oct. 2016, 14:44:05
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
: ${echo2}<br>
changement de tour de ${ancien} pour ${tour} joueuractuel ${joueuractuel}<br>
${acteur} a lance le sort ${sort} <br>
${acteur} a eu n cartes <br>
${victime} a perdu n cartes <br>
${acteur} passe son tour<br>

recuperere chaque evenements (perte de carte, augmentation de carte, tour decale,a qui le tour, sort lancé, sort subi, joueur elimine, joueur gagant)

