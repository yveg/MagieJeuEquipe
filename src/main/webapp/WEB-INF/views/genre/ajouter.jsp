<%-- 
    Document   : lister
    Created on : 29 mars 2016, 08:03:25
    Author     : tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Nouveau film</h1>
<div>
    <form:form modelAttribute="genre" method="POST">
        <label for="nom">Titre</label>
        <form:input path="nom"/>
        <br>
        <input type="button" value="Ajouter" onclick="ajouterGenre()"/>
    </form:form>
</div>