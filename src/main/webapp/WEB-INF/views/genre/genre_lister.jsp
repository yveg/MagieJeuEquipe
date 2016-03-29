<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Liste des genres</h1>
<div>
    <c:forEach items="genres" var="genre">
        ${genre.nom}
    </c:forEach>
</div>
