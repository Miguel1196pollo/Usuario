
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Alumno;
import utng.util.UtilDB;

/**
 *
 * @author Miguel González  
 */
public class AlumnoDAOImp implements AlumnoDAO{
  private Connection connection;
  
  public AlumnoDAOImp(){
      connection=UtilDB.getConnection();
  }
    @Override
    public void agregarAlumno(Alumno alumno) {
        try {
            String query = "INSERT INTO Alumno (activo, tipoBeca,fechaSolicitud,personal, clave_Universidad) VALUES(?,?,?,?,?)";
            PreparedStatement co = connection.prepareStatement(query);
            
            co.setString(1, alumno.getActivo());
            co.setString(2, alumno.getTipoBeca());
            co.setString(3, alumno.getFechaSolicitud());
            co.setString(4, alumno.getPersonal());
            co.setInt(5, alumno.getClave_Universidad());
            //co.setInt(6, alumno.getIdAlumno());
            co.executeUpdate();
            co.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarAlumno(int id) {
        try{
            String query = "DELETE FROM Alumno WHERE "
                    + " idAlumno=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setInt(1, id);
            co.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarAlumno(Alumno alumno) {
        try{
            String query = "UPDATE Alumno SET activo=?, tipoBeca=?, fechaSolicitud=?, personal=?, clave_Universidad=?"
                    + " WHERE idAlumno=?";
            PreparedStatement co = connection.prepareStatement(query);
            
            co.setString(1, alumno.getActivo());
            co.setString(2, alumno.getTipoBeca());
            co.setString(3, alumno.getFechaSolicitud());
            co.setString(4, alumno.getPersonal());
            co.setInt(5, alumno.getClave_Universidad());
            co.setInt(6, alumno.getIdAlumno());
            co.executeUpdate();
            co.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Alumno> desplegarAlumno() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Alumno");
            while(rs.next()){
               Alumno alumno= new Alumno(rs.getInt("idAlumno"),
                       rs.getString("activo"),
                       rs.getString("tipoBeca"),
                       rs.getString("fechaSolicitud"),
                       rs.getString("personal"),
                       rs.getInt("clave_Universidad"));

                alumnos.add(alumno);
            }
            rs.close();
            statement.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return alumnos;
    }

    @Override
    public Alumno elegirAlumno(int idAlumno) {
        Alumno alumno=null;
        try{
            String query = " SELECT * FROM Alumno WHERE idAlumno=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idAlumno);
            ResultSet rs= statement.executeQuery();
            
            if(rs.next()){
                alumno= new Alumno(
                rs.getInt("idAlumno"),
                rs.getString("activo"),
                rs.getString("tipoBeca"),
                rs.getString("fechaSolicitud"),
                rs.getString("personal"),
                rs.getInt("clave_Universidad"));
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return alumno;
    }
    
}
