<%-- 
    Document   : procesaannadir
    Created on : 11-jun-2018, 17:05:08
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos recibidos:</h1>
        <p>Titulo: <%=request.getParameter("titulo")%></p>
        <p>Descripcion: <%=request.getParameter("descripcion")%></p>
        <p>Completado: <%=request.getParameter("completado")%></p>
        <%

            Tarea t = new Tarea(
                    request.getParameter("titulo"),
                    request.getParameter("descripcion"),
                    request.getParameter("completado") != null
            );
            t.create();
        %>
    </body>
</html>
