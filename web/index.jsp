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
        <%@include  file="inc/head.jsp" %>
       <title>JSP Page</title>
    </head>
    <body>
        
    <%@include file="inc/header.jsp"%>       
        
       
        <%
            for (Tarea t : tareas) {
         %>
<div class="card mt-2">
  <div class="card-header<%=t.getCompletada()?" text-success":""%>">
    <%=t.getTitulo()%>
  </div>
  <div class="card-body">
    <p class="card-text"><%=t.getDescripcion()%></p>
    <%=t.getCompletada()%>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>         

        <%
            }
        %>  

        <%@include  file="inc/footer.jsp" %>
    </div>
    </body>
</html>
