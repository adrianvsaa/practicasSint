<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="Java"%>
<%@page import="practica3.Anio"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!Doctype html>
<html>
    <head>
        <meta charset="ISO-8859-15"/>
        <title>Servicio de consulta de películas</title>
        <link rel="stylesheet" type="text/css" href="mml.css"/>
    </head>
    <body>
        <div class="principal">
            <div>
                <form method="GET" action="">
                    <input type='hidden' name='fase'>
                    <input type='hidden' name='p' value='${param["p"]}'>
                    <h1>Servicio de consulta de películas</h1>
                    <h3>Selecciona un año:</h3>
                    <c:set var="anios" value="${listaAnios.toArray()}"/>
                    <c:forEach items="${anios}" var="item" varStatus="loop">
                        <input type='radio' name='anio' checked='true' value='${item.getAnio()}'>${loop.index +1}.- ${item.getAnio()}<br/>
                    </c:forEach>
                    <input type='submit' value='Enviar' onclick='document.forms[0].fase.value=12'>
                    <br>
                    <input type='submit' value='Atrás' onclick='document.forms[0].fase.value=0'>
                </form>
            </div>
            <footer>
                <p>Diseñado por: Adrián Vázquez Saavedra</p>
            </footer>
        </div>
    </body>
</html>
