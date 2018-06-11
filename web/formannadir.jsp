<%-- 
    Document   : formannadir.jsp
    Created on : 11-jun-2018, 16:56:25
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="procesaannadir.jsp" method="POST">
            <label for="inputtitulo">Título</label>
            <input type="text" name ="titulo" id="inputtitulo">
            <br>
            <label for="tadescripcion">descripcion</label><br>
            
            <textarea name ="descripcion" id="tadescripcion"></textarea>
            <br>
            <input type="checkbox" name="completado" id="checkcompletado" value="estacompletado">
            <label for="checkcompletado">completado</label>
            <br>
            <input type ="submit">
        </form> 
    </body>
</html>
