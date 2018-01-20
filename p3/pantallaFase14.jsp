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
                    <input type="hidden" name="fase">
                    <input type='hidden' name='p' value='${param["p"]}'>
                    <input type='hidden' name='anio' value='${param["anio"]}'>
                    <input type='hidden' name='pelicula' value='${param["pelicula"]}'>
                    <h1>Servicio de consulta de películas</h1>
                    <h3>Año=${param["anio"]},Película=${param["pelicula"]},Act=${param["act"]}</h3>
                    <h3>El personaje es:${personaje}</h3>
                    <ul>
                        <c:set var="film" value="${films.toArray()}"/>
                        <c:forEach items="${film}" var="item" varStatus="loop">
                            <c:if test="${empty item.getOscar()}">
                                <li>${loop.index+1}.-Titulo=${item.getTitulo()}</li>
                            </c:if>
                            <c:if test="${not empty item.getOscar()}">
                                <li>${loop.index+1}.-Titulo= ${item.getTitulo()},Óscar= ${item.getOscar()}</li>
                            </c:if>
                        </c:forEach>
                    </ul>
                    <input type="submit" value="Atrás" onclick="document.forms[0].fase.value=13">
                    <input type="submit" value="Inicio" onclick="document.forms[0].fase.value=0">
                </Form>
            </div>
            <footer>
                <p>Diseñado por: Adrián Vázquez Saavedra</p>
            </footer>
        </div>
    </body>
</html>
