<%-- 
    Document   : index
    Created on : 06-jun-2018, 10:27:27
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>

<%
    List<Tarea> tareas = Tarea.obtenerTodas();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="inc/head.html" %>
        <title>JSP Page</title>
    </head>
    <body class="container">
        <%@include file="inc/navbar.jsp"%>
        <div class="animated fadeInUp">
        <% for (Tarea t : tareas) { %>
        <p><%=t.getTitulo() + " / " + t.getDescripcion()%></p>
        <% } %>
        </div>
   <%@include file="inc/footer.html" %>
    </body>
</html>
