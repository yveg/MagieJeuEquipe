<%-- 
    Document   : attentePartie
    Created on : 18 oct. 2016, 16:29:32
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="CSS/forme.css" rel="stylesheet" type="text/css"/>
<script src="JS/jquery-3.1.1.js" type="text/javascript"></script>
<script type="text/javascript">   
    
    setInterval(function(){ 
            $('#parties').text("<c:forEach items='${parties}' var='mesparties'>");
            $('#parties').append("<form:form modelAttribute='mesparties' >");
            $('#parties').append("<input type='submit' value =' ${mesparties.nom}'>");
            $('#parties').append("</form:form></c:forEach>");
        }, 5000);

//<a href="editer_film/${mesfilms.id}">Editer</a>
    function envoyer(){
        alert("ok");
    }
</script>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attente de parties</title>
    </head>
    <body>
        <div class="div1">Page d'attente partie</div>
        <br>
        <p class="shadow">Vous &ecirc;tes: ${joueuractuel}</p> <span class="shadow">Noms des parties :</span><br><br><br>
        <div class="carre">
        <div id="parties">
            <c:forEach items="${parties}" var="mesparties">
                <form:form  modelAttribute="mapartie">
                    <form:input type='submit' path='id' value="${mesparties.id}"/>
                </form:form>
            </c:forEach>
        </div>
            </div>
    </body>
</html>
