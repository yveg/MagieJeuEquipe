<%-- 
    Document   : ajax_zone_cartes_joueur_act
    Created on : 25 oct. 2016, 09:52:37
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- scan la table parties et append le nom+br>-->
    
<c:forEach items="${parties}" var="mesparties">
    <form:form  modelAttribute="mapartie" action="rejoindre_partie">
        <label for="envoyer">${mesparties.nom}</label> 
        <form:input hidden="hidden" path="id" value="${mesparties.id}" type="submit" id="envoyer"></form:input>
    </form:form>
</c:forEach>