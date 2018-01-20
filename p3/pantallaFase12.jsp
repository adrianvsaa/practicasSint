<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="Java"%>
<%@page import="practica3.Anio"%>
<%@page import="practica3.Pelicula"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!Doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" type="text/css" href="mml.css"/>
        <title>Servicio de consulta de peliculas</title>
    </head>
    <body>
        <div class="principal">
            <div>
                <Form method="GET">
                    <input type='hidden' name='fase'>
                    <input type='hidden' name='p' value='${param["p"]}'>
                    <input type='hidden' name='anio' value='${param["anio"]}'>
                    <h1>Servicio de consulta de peliculas</h1>
                    <h3>Año=${param["anio"]}</h3>
                    <h3>Selecciona una pelicula:</h3>
                    <c:set var="peliculas" value="${listaPeliculas.toArray()}"/>
                    <c:forEach items="${peliculas}" var="item" varStatus="loop">
                        <input type='radio' name='pelicula' checked='true' value='${item.getTitulo()}'>${loop.index +1}.- ${item.getTitulo()}(${item.getDuracion()}min)<br/>
                    </c:forEach>
                    <input type='submit' value='Enviar' onclick='document.forms[0].fase.value=13'>
                    <input type='submit' value='Atras' onclick='document.forms[0].fase.value=11'>
                    <input type='submit' value='Inicio' onclick='document.forms[0].fase.value=0'>
                </Form>
            </div>
            <footer>
                <p>Diseñado por: Adrián Vázquez Saavedra</p>
            </footer>
        </div>
    </body>
</html>
