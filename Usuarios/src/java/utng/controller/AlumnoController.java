
package utng.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dao.AlumnoDAOImp;

import utng.model.Alumno;
import utng.dao.AlumnoDAO;

/**
 *
 * @author Miguel González 
 */
public class AlumnoController extends HttpServlet{
    private static final String LISTA_ALUMNOS = "/listarAlumno.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/alumno.jsp";
    private AlumnoDAO dao;
    
    public AlumnoController() {
        dao = new AlumnoDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_ALUMNOS;
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            dao.borrarAlumno(idAlumno);
            request.setAttribute("alumno", dao.desplegarAlumno());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            Alumno alumno = dao.elegirAlumno(idAlumno);
            request.setAttribute("alumno", alumno);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_ALUMNOS;
            request.setAttribute("alumno", dao.desplegarAlumno());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Alumno alumno = new Alumno();
        String idAlumno = request.getParameter("idAlumno");
       alumno.setActivo(request.getParameter("activo"));
        alumno.setTipoBeca(request.getParameter("tipoBeca"));
        alumno.setFechaSolicitud(request.getParameter("fechaSolicitud"));
        alumno.setPersonal(request.getParameter("personal"));
        String clave_Universidad = request.getParameter("clave_Universidad");
        if (idAlumno == null || idAlumno.isEmpty()) {
            dao.agregarAlumno(alumno);
        } else {
            alumno.setIdAlumno(Integer.parseInt(idAlumno));
            dao.cambiarAlumno(alumno);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_ALUMNOS);
        request.setAttribute("alumno", dao.desplegarAlumno());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
