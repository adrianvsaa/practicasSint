<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="Java"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!Doctype html>
<html>
    <head>
        <title>Transformación de un fichero</title>
        <link rel="stylesheet" type="text/css" href="mml.css"/>
    </head>
    <body>
        <div class="principal">
            <div>
                <form method="GET">
                    <input type='hidden' name='p' value='${param["p"]}'>
                    <input type='hidden' name='fase'>
                    <h1>Transformación de un fichero</h1>
                    <h3>Seleccione el fichero que desea convertir:</h3>
                    <c:set var="ficheros" value="${listaFicheros.toArray()}"/>
                    <c:forEach items="${ficheros}" var="item">
                        <input type='radio' name='fichero' value='${item}'>${item}<br/>
                    </c:forEach>
                    <input type="submit" value="Transformacion a HTML" onclick="document.forms[0].fase.value=22">
                    <input type="submit" value="Transformacion a RSS" onclick="document.forms[0].fase.value=23">
                    <br/>
                    <input type="submit" value="Atras" onclick="document.forms[0].fase.value=0">
                </form>
            </div>
            <footer>
                <p>Diseñado por: Adrián Vázquez Saavedra</p>
            </footer>
        </div>
    </body>
</html>
