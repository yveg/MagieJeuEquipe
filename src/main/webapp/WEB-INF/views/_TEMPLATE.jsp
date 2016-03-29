<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="monApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Streaming</title>
        <link href="<c:url value="/resources/CSS/style1.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="/resources/JS/angular.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/JS/app.js"/>" type="text/javascript"/></script>
</head>
<body ng-controller="menuController">
    <div class="menu"> 
        <c:import url="_MENU.jsp" />
    </div>
    <div class="content" ng-include="'<c:url value="/"/>' + contentRoute"> 
    </div>
    <div class="footer">
        <c:import url="_FOOTER.jsp"/>
    </div>
</body>
</html>
