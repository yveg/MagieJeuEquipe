<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Liste des genres</h1>
<div>
    <input type="button" value="Ajouter" onclick="chargeContenu('/genre/ajouter')"/>
    <c:forEach items="${genres}" var="genre">
        ${genre.nom}
        <br>
    </c:forEach>
</div>
