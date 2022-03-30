public class Caja {
    private String nombre;
    private double cantidad;
    private double prestamos;
    private double intereses;
    private double reditos;
    private double retiros;
    private double total;
    private double semanas;

    
    public String getNombre() {
        return nombre;
    }
    public double getRetiros() {
        return retiros;
    }
    public void setRetiros(double retiros) {
        this.retiros = retiros;
    }
    public double getSemanas() {
        return semanas;
    }
    public void setSemanas(double semanas) {
        this.semanas = semanas;
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
    public double getIntereses() {
        return intereses;
    }
    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }
    public double getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(double prestamos) {
        this.prestamos = prestamos;
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
