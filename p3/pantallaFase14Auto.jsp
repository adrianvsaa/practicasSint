<?xml version="1.0" encoding="UTF-8"?>
<%@page contentType="application/xml"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="Java"%>
<%@page import="practica3.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<filmografia nombre="${param["act"]}" personaje="${personaje}">
    <c:set var="films" value="${listaFilms.toArray()}"/>
    <c:forEach items="${films}" var="item">
        <c:if test="${empty item.getOscar()}">
            <film>${item.getTitulo()}</film>
        </c:if>
        <c:if test="${not empty item.getOscar()}">
            <film oscar="${item.getOscar()}">${item.getTitulo()}</film>
        </c:if>
    </c:forEach>
</filmografia>