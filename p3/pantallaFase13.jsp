<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="Java"%>
<%@page import="practica3.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!Doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" type="text/css" href="mml.css"/>
        <title>Servicio de consulta de películas</title>
    </head>
    <body>
        <div class="principal">
            <div>
                <Form method="GET">
                    <input type='hidden' name="fase">
                    <input type='hidden' name='p' value='${param["p"]}'>
                    <input type='hidden' name='anio' value='${param["anio"]}'>
                    <input type='hidden' name='pelicula' value='${param["pelicula"]}'>
                    <h1>Servicio de consulta de películas</h1>
                    <h3>Año=${param["anio"]},Película=${param["pelicula"]}</h3>
                    <h3>Selecciona un actor:</h3>
                    <c:set var="actores" value="${listaActores.toArray()}"/>
                    <c:forEach items="${actores}" var="item" varStatus="loop">
                        <input type='radio' name='act' checked='true' value='${item.getNombre()}'>${loop.index+1}.- ${item.getNombre()}(${item.getDireccion()})<br/>
                    </c:forEach>
                    <input type="submit" value="Enviar" onclick="document.forms[0].fase.value=14">
                    <input type="submit" value="Atrás" onclick="document.forms[0].fase.value=12">
                    <input type="submit" value="Inicio" onclick="document.forms[0].fase.value=0">
                </Form>
            </div>
            <footer>
                <p>Diseñado por: Adrián Vázquez Saavedra</p>
            </footer>
        </div>
    </body>
</html>
