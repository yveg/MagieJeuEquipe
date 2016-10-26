<%-- 
    Document   : newjsp
    Created on : 26 oct. 2016, 14:04:21
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<p class="shadow titre">Nom des joueurs en liste:</p>
<p>
    <c:forEach var="displayjoueur" items="${joueurs}">
        <c:if test="${joueuractuel != displayjoueur.pseudo}">

            <c:out value="${displayjoueur.pseudo}"></c:out>&nbsp;&nbsp;
            <c:forEach var="displayingredient" items="${displayjoueur.ingredients}">
                <input type="image"  src="Images/dos2carte/0001.png" onclick="setidcard" ></input> &nbsp;&nbsp;  
            </c:forEach>
        </c:if>
    </p>
    <hr class="style13">
</c:forEach>
