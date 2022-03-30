public class Prestamo {
    private int id;
    private String Nombre;
    private String FechaPrestamo;
    private double CantidadPrestamo;
    private	String FechaTermino;
    private double reditos;
    private double total;
    
    public int getId() {
        return id;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public double getReditos() {
        return reditos;
    }
    public void setReditos(double reditos) {
        this.reditos = reditos;
    }
    public String getFechaTermino() {
        return FechaTermino;
    }
    public void setFechaTermino(String fechaTermino) {
        this.FechaTermino = fechaTermino;
    }
    public double getCantidadPrestamo() {
        return CantidadPrestamo;
    }
    public void setCantidadPrestamo(double cantidadPrestamo) {
        this.CantidadPrestamo = cantidadPrestamo;
    }
    public String getFechaPrestamo() {
        return FechaPrestamo;
    }
    public void setFechaPrestamo(String fechaPrestamo) {
        this.FechaPrestamo = fechaPrestamo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
}
