
package utng.model;

/**
 *
 * @author Miguel González
 */
public class Alumno {
    private int idAlumno;
    private String activo;
    private String tipoBeca;
    private String fechaSolicitud;
    private String personal;
    private int clave_Universidad;

    public Alumno(int idAlumno, String activo, String tipoBeca, String fechaSolicitud, String personal, int clave_Universidad) {
        this.idAlumno = idAlumno;
        this.activo = activo;
        this.tipoBeca = tipoBeca;
        this.fechaSolicitud = fechaSolicitud;
        this.personal = personal;
        this.clave_Universidad = clave_Universidad;
    }
    
    public Alumno(){
        this(0,"","","","",0);
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public int getClave_Universidad() {
        return clave_Universidad;
    }

    public void setClave_Universidad(int clave_Universidad) {
        this.clave_Universidad = clave_Universidad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", activo=" + activo + ", tipoBeca=" + tipoBeca + ", fechaSolicitud=" + fechaSolicitud + ", personal=" + personal + ", clave_Universidad=" + clave_Universidad + '}';
    }

   

   

    

   
       
    
    
}
