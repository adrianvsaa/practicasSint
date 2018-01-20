<?xml version="1.0" encoding="UTF-8"?>
<%@page contentType="application/xml"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="Java"%>
<%@page import="practica3.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<peliculas>
    <c:set var="peliculas" value="${listaPeliculas.toArray()}"/>
    <c:forEach items="${peliculas}" var="item">
        <pelicula duracion="${item.getDuracion()}" langs="${item.getLangs()}">${item.getTitulo()}</pelicula>
    </c:forEach>
</peliculas>