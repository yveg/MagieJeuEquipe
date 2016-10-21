<%-- 
    Document   : attentePartie
    Created on : 18 oct. 2016, 16:29:32
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="JS/jquery-3.1.1.js" type="text/javascript"></script>
<script type="text/javascript">   
    
    setInterval(function(){ 
            $('#parties').text("<c:forEach items='${parties}' var='mesparties'>");
            $('#parties').append("<form:form modelAttribute='mesparties' >");
            $('#parties').append("<input type='submit' value =' ${mesparties.nom}'>");
            $('#parties').append("</form:form></c:forEach>");
        }, 5000);

//<a href="editer_film/${mesfilms.id}">Editer</a>

</script>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attente de parties</title>
    </head>
    <body>
        <h1>
            <u>Parties disponibles :</u>
        </h1>
        <div id="parties">
            <c:forEach items="${parties}" var="mesparties">
                <form:form modelAttribute="parties" >   
                    <form:input path="nom"/>
                    <input type="submit" value='${mesparties}'/>  
                </form:form>
            </c:forEach>
        </div>
    </body>
</html>
