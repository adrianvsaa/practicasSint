<?xml version="1.0" encoding="UTF-8"?>
<%@page contentType="application/xml"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="Java"%>
<%@page import="practica3.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<anios>
    <c:set var="anios" value="${listaAnios.toArray()}"/>
    <c:forEach items="${anios}" var="item">
        <anio>${item.getAnio()}</anio>
    </c:forEach>
</anios>