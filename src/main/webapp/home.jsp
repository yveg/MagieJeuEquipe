<%-- 
    Document   : homme
    Created on : 18 oct. 2016, 16:14:18
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titre}</title>
        <script src="JS/jquery-3.1.1.js" type="text/javascript"></script>
        <link href="CSS/homepage.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <br>
        <br>
        <h1>MagieMagie</h1> 
        
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        ${msgErreur}
        <br>
        <form:form id="saisiePseudo" modelAttribute="joueur">
            <form:input  id="saisie" path="pseudo"/> 
            <input type="submit"  style="font-face: 'Comic Sans MS'; font-size: larger; color: red; background-color:#ffc00" value="Créer joueur" />
        </form:form>
        <br>
    </body>
</html>
