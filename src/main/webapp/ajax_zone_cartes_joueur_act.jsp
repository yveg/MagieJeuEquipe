<%-- 
    Document   : ajax_zone_cartes_joueur_act
    Created on : 25 oct. 2016, 09:52:37
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<p>alors ingredients ?</p>
<c:forEach items="${ingredientsJoueurAct}" var="ingredient">
    <img class="overmescartes" src="${ingredient.image}"/>
</c:forEach>