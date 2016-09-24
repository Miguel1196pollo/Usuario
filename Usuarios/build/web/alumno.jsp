<%-- 
    Document   : alumno
    Created on : 23-sep-2016, 12:52:51
    Author     : Miguel González 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Becas Alumno</title>
    </head>
    <body>
        <form action="AlumnoController" method="post">
            <fieldset>
                <div>
                    <label>ID de Alumno: </label>
                    <input type="text" name="idAlumno" value="${alumno.idAlumno}"
                           placeholder="id"
                           readonly="readonly"/>
                </div>
                <div>
                    <label>Activo: </label>
                    <input type="text" name="activo" value="${alumno.activo}"
                           placeholder="activo"/>
                </div>

                <div>
                    <label>Tipo de Beca </label>
                    <input type="text" name="tipoBeca" value="${alumno.tipoBeca}"
                           placeholder="Tipo de Beca"/>
                </div>
                <div>
                    <label>Fecha Solicitud: </label>
                    <input type="text" name="fechaSolicitud" value="${alumno.fechaSolicitud}"
                           placeholder="Fecha Solicitud"/>
                </div>
                <div>       
                    <label>Personal: </label>
                    <input type="text" name="personal" value="${alumno.personal}"
                           placeholder="personal"/>
                </div>
                <div>       
                    <label>Clave Universidad:  </label>
                    <input type="text" name="claveUniversidad" value="${alumno.clave_Universidad}"
                           placeholder="clave"
                           />
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
