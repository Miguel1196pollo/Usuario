/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.Alumno;

/**
 *
 * @author Miguel Gonzalez 
 */
public interface AlumnoDAO {
    void agregarAlumno(Alumno alumno);
    void borrarAlumno(int idAlumno);
    void cambiarAlumno(Alumno alumno);
    List<Alumno > desplegarAlumno();
    Alumno elegirAlumno(int idAlumno);
}
