<%-- 
    Document   : homme
    Created on : 18 oct. 2016, 16:14:18
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titre}</title>
        <script src="JS/jquery-3.1.1.js" type="text/javascript"></script>
        
    </head>
    <body>
        <h1>Hello World!</h1> 
        
        
        <input type="text" value="ecrireVotreNom">
       
        
        <br>
        <input   type="button" onclick="location.href='creerjoueur'"  value="RejoindrPartie">
        
    </body>
</html>
