<%-- 
    Document   : lister
    Created on : 29 mars 2016, 08:03:25
    Author     : tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Liste des films</h1>
<input type="button" value="Ajouter" ng-click="chargeContenu('/film/ajouter')"/>
<c:forEach items="${films}" var="film">
    ${film.titre}
    <br>
</c:forEach>
