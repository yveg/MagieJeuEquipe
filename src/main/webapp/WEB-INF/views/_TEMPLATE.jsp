<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="monApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Streaming</title>
        <link href="<c:url value="/CSS/style1.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="/JS/jquery-2.2.2.js"/>" type="text/javascript"></script>
        <script type="text/javascript">

            var urlAppli = '<c:url value="/"/>';

            function chargeContenu(route) {

                $('.content').load(urlAppli + route);
            }

        </script>
    </head>
    <body>
        <div class="menu"> 
            <c:import url="_MENU.jsp" />
        </div>
        <div class="content"> 
        </div>
        <div class="footer">
            <c:import url="_FOOTER.jsp"/>
        </div>
    </body>
</html>
