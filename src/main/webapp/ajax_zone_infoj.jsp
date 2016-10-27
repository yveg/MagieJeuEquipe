<%-- 
    Document   : newjspaajax_zone_infoj
    Created on : 27 oct. 2016, 14:56:40
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p class="shadow">Vous &ecirc;tes: ${joueuractuel}
<div class="avatar">ici photo <img src="${alvatar}"></div></p>
<p class="shadow">le tour est &agrave;: ${tour}</p>
