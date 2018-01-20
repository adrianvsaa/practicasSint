<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="Java"%>



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
                    <input type='hidden' name='p' value='${param["p"]}'>
                    <input type='hidden' name='errores'>
                    <h1>Servicio de consulta de películas</h1>
                    <h1>Bienvenido a este servicio</h1>
                    <input type='submit' id="enlace" value='Pulse aquí para ver los ficheros erroneos' onclick='document.forms[0].errores.value="si"'>
                    <br/>
                    <h3>Selecciona una consulta</h3>
                    <input type='radio' name='fase' checked='true' value='11'>Consulta 1: Filmografía de un miembro del reparto
                    <br/>
                    <input type='radio' name='fase' value='21'>Consulta 2: Transformación de un fichero
                    <br/>
                    <input type='submit' value='Enviar'>
                </form>
            </div>
            <footer>
                <p>Diseñado por: Adrián Vázquez Saavedra</p>
            </footer>
        </div>
    </body>
</html>
