<%-- 
    Document   : index
    Created on : 06-jun-2018, 10:27:27
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>

<%
   // código
%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>JSP Page</title>
    </head>
    <body>
        Hoy es <%= java.time.LocalDate.now()%>.             
    </body>
</html>
