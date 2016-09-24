<%-- 
    Document   : listarAlumno
    Created on : 22-sep-2016, 20:38:46
    Author     : Miguel González
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Alumnos</title>
    </head>
    <body>
         <table>
            <thead>
                <tr>
                    <th>idAlumno</th>
                    <th>activo</th>
                    <th>tipoBeca</th>
                    <th>fechaSolicitud</th>
                    <th>personal</th>
                    <th>clave_Universidad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="alumno" items="${alumno}">
                    <tr>
                        <td>${alumno.idAlumno}</td>
                        <td>${alumno.activo}</td>
                        <td>${alumno.tipoBeca}</td>
                        <td>${alumno.fechaSolicitud}</td>
                        <td>${alumno.personal}</td>
                        <td>${alumno.clave_Universidad}</td>
                        <td><a href="AlumnoController?action=cambiar&idAlumno=${alumno.idAlumno}">Cambiar</a></td>
                        <td><a href="AlumnoController?action=borrar&idAlumno=${alumno.idAlumno}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="AlumnoController?action=agregar">Nuevo Alumno</a>
        </p>
    </body>
</html>
