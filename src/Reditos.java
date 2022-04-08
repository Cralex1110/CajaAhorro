public class Reditos {
    private int idRedito;
    private int idPrestamo;
    private String nombre;	
    private String fechaReditos;
    private double reditosPrestamo;
    private String status;
    
    public int getIdRedito() {
        return idRedito;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getReditosPrestamo() {
        return reditosPrestamo;
    }
    public void setReditosPrestamo(double reditosPrestamo) {
        this.reditosPrestamo = reditosPrestamo;
    }
    public String getFechaReditos() {
        return fechaReditos;
    }
    public void setFechaReditos(String fechaReditos) {
        this.fechaReditos = fechaReditos;
    }
    public int getIdPrestamo() {
        return idPrestamo;
    }
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    public void setIdRedito(int idRedito) {
        this.idRedito = idRedito;
    }
}
