import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.sql.*;

public class Funciones {
    String  driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://192.168.1.75/caja";
    String user = "root";
    String pw = "";

    public int obtenerDia(){
        Calendar c = Calendar.getInstance();
        int d = c.get(Calendar.DAY_OF_YEAR);
        return d;
    }

    public String obtenerFecha(){
        Calendar c = Calendar.getInstance();
        int year= c.get(Calendar.YEAR);
        int month= c.get(Calendar.MONTH) + 1;
        int day= c.get(Calendar.DAY_OF_MONTH);
        String f = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
        return f;
    }

    public int obtenerSemana(){
        Calendar c = Calendar.getInstance();
        int d = c.get(Calendar.WEEK_OF_YEAR)-1;
        return d;
    }

    public double obtenerInteres(double cant, int dia){
        return (cant*((360d-Double.valueOf(dia))/360d)*(0.05));
    }

    public double obtenerInteresPrestamo(double cant){
        return (cant*0.1);
    }

    public double obtenerDinero(){
        double res = 0;
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT SUM(aportaciones.Cantidad) AS TOTAL FROM `aportaciones`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {  
                String a = rs.getString(1);
                if(a==null){
                    return 0;
                }else{
                    res = Double.parseDouble(rs.getString(1));
                }
            }
            return res;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public double obtenerInteresP(){
        double res = 0;
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT SUM(aportaciones.Interes) AS TOTAL FROM `aportaciones`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {  
                String a = rs.getString(1);
                if(a==null){
                    return 0;
                }else{
                    res = Double.parseDouble(rs.getString(1));
                }
            }
            return res;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public double obtenerPrestamos(){
        double res = 0;
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT SUM(prestamos.CantidadPrestamo) FROM `prestamos`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {
                String a = rs.getString(1);
                if(a==null){
                    return 0;
                }else{
                    res = Double.parseDouble(rs.getString(1));
                }
            }
            return res;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public double obtenerReditos(){
        double res = 0;
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT SUM(reditos.ReditosPrestamo) FROM `reditos`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {
                String a = rs.getString(1);
                if(a==null){
                    return 0;
                }else{
                    res = Double.parseDouble(rs.getString(1));
                }
            }
            return res;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public double obtenerPagoReditos(){
        double res = 0;
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT SUM(pagoreditos.PagoRedito) FROM `pagoreditos`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {
                String a = rs.getString(1);
                if(a==null){
                    return 0;
                }else{
                    res = Double.parseDouble(rs.getString(1));
                }
            }
            return res;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public double obtenerPagoPrestamo(){
        double res = 0;
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT SUM(pagos.PagoPrestamo) FROM `pagos`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {
                String a = rs.getString(1);
                if(a==null){
                    return 0;
                }else{
                    res = Double.parseDouble(rs.getString(1));
                }
            }
            return res;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public double obtenerRetiros(){
        double res = 0;
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT SUM(retiros.Cantidad) FROM `retiros`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {
                String a = rs.getString(1);
                if(a==null){
                    return 0;
                }else{
                    res = Double.parseDouble(rs.getString(1));
                }
            }
            return res;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public ArrayList<String> obtenerNombres(){
        ArrayList<String> names = new ArrayList<String>();
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT Nombre FROM `personas`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {  
                names.add(rs.getString(1));
            }
            return names;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public ArrayList<String> obtenerPrestamosLista(){
        ArrayList<String> names = new ArrayList<String>();
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT IdPrestamo FROM `prestamos`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {  
                names.add(rs.getString(1));
            }
            return names;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public ArrayList<String> obtenerReditosLista(){
        ArrayList<String> names = new ArrayList<String>();
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT IdRedito FROM `reditos`;";

            ResultSet rs = null;
            rs = st.executeQuery(query);

            while (rs.next()) {  
                names.add(rs.getString(1));
            }
            return names;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void agregar(String nom, double mon){
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "INSERT INTO `personas` (`Nombre`, `Pago`) VALUES ('"+nom+"', '"+mon+"')";

            st.execute(query);
            st.close();

            JOptionPane.showMessageDialog(null, "Persona agregada exitosamente");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarAporte(String nom, double can, String fecha, int dia, double red){
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "INSERT INTO `aportaciones` (`IdAporte`, `Nombre`, `Cantidad`, `Fecha`, `Dia`, `Interes`) VALUES (NULL, '"+nom+"', '"+can+"', '"+fecha+"', '"+dia+"', '"+red+"')";

            st.execute(query);
            st.close();

            JOptionPane.showMessageDialog(null, "Aporte agregado exitosamente");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Caja buscar(String nom){
        Caja enc = new Caja();
        try{
            Double pagos=0d, pagosr=0d, redi=0d, pres=0d, reti=0d;
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT SUM(aportaciones.Cantidad), SUM(aportaciones.Interes) FROM aportaciones WHERE aportaciones.Nombre = '"+nom+"';";
            ResultSet rs = null;
            rs = st.executeQuery(query);
            enc.setNombre(nom);
            while (rs.next()) {
                enc.setCantidad(Double.parseDouble(rs.getString(1)));
                enc.setIntereses(Double.parseDouble(rs.getString(2)));
            }
            query = "SELECT SUM(prestamos.CantidadPrestamo) FROM `prestamos` WHERE Nombre = '"+nom+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    pres = 0.0;
                }else{
                    pres = Double.parseDouble(rs.getString(1));
                }
            }
            query = "SELECT SUM(reditos.ReditosPrestamo) FROM reditos WHERE reditos.Nombre = '"+nom+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    redi = 0.0;
                }else{
                    redi = Double.parseDouble(rs.getString(1));
                }
            }
            query = "SELECT SUM(pagos.PagoPrestamo) FROM pagos WHERE pagos.Nombre = '"+nom+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    pagos = 0d;
                }else{
                    pagos = Double.parseDouble(rs.getString(1));
                }
            }
            query = "SELECT SUM(pagoreditos.PagoRedito) FROM pagoreditos WHERE pagoreditos.Nombre = '"+nom+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    pagosr = 0d;
                }else{
                    pagosr = Double.parseDouble(rs.getString(1));
                }
            }
            enc.setPrestamos(pres - pagos);
            enc.setReditos(redi - pagosr);
            double cant = 0;
            query = "SELECT personas.Pago FROM personas WHERE personas.Nombre = '"+nom+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    cant = 0d;
                }else{
                    cant = Double.parseDouble(rs.getString(1));
                }
            }
            enc.setSemanas(enc.getCantidad()/cant);
            query = "SELECT SUM(retiros.Cantidad) FROM retiros WHERE retiros.Nombre = '"+nom+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    reti = 0d;
                }else{
                    reti = Double.parseDouble(rs.getString(1));
                }
            }
            enc.setRetiros(reti);
            enc.setTotal((enc.getCantidad()+enc.getIntereses())-(enc.getPrestamos()+enc.getReditos()+enc.getRetiros()));
            return enc;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void agregarPrestamo(String nom, double can, String fecha){
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "INSERT INTO `prestamos` (`IdPrestamo`, `Nombre`, `FechaPrestamo`, `CantidadPrestamo`, `FechaTermino`) VALUES (NULL, '"+nom+"', '"+fecha+"', '"+can+"', NULL);";

            st.execute(query);
            st.close();

            JOptionPane.showMessageDialog(null, "Prestamo agregado exitosamente");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Prestamo datosPrestamo(String id){
        Prestamo enc = new Prestamo();
        try{
            double cant=0d, redi=0d, pago=0d, pare=0d;
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT * FROM prestamos WHERE prestamos.IdPrestamo = '"+id+"';";
            ResultSet rs = null;
            rs = st.executeQuery(query);
            while (rs.next()) {
                enc.setId(Integer.parseInt(rs.getString(1)));
                enc.setNombre(rs.getString(2));
                enc.setFechaPrestamo(rs.getString(3));
                enc.setCantidadPrestamo(rs.getDouble(4));
                cant = rs.getDouble(4);
                if(rs.getString(5)==null){
                    enc.setFechaTermino("NULL");
                }else{
                    enc.setFechaTermino(rs.getString(5));
                }
            }
            query = "SELECT SUM(reditos.ReditosPrestamo) FROM reditos WHERE reditos.IdPrestamo = '"+id+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    redi = 0d;
                }else{
                    redi = rs.getDouble(1);
                }
            }
            query = "SELECT SUM(pagos.PagoPrestamo) FROM `pagos` WHERE pagos.IdPrestamo = '"+id+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    pago = 0d;
                }else{
                    pago = rs.getDouble(1);
                }
            }
            query = "SELECT SUM(pagoreditos.PagoRedito) FROM pagoreditos WHERE pagoreditos.IdPrestamo = '"+id+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(1)==null){
                    pare = 0d;
                }else{
                    pare = rs.getDouble(1);
                }
            }
            enc.setReditos(redi - pare);
            enc.setTotal((cant + redi)-(pago + pare));

            return enc;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void pagarPrestamo(int id, double can, String fecha, String nom){
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "INSERT INTO `pagos` (`IdPago`, `IdPrestamo`, `Nombre`, `FechaPago`, `PagoPrestamo`) VALUES (NULL, '"+id+"', '"+nom+"', '"+fecha+"', '"+can+"')";

            st.execute(query);
            st.close();

            JOptionPane.showMessageDialog(null, "Pago-prestamo agregado exitosamente");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Reditos datosReditos(String id){
        Reditos enc = new Reditos();
        try{
            double redi=0d, pago=0d;
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "SELECT * FROM reditos WHERE IdRedito = '"+id+"';";
            ResultSet rs = null;
            rs = st.executeQuery(query);
            while (rs.next()) {
                enc.setIdRedito(rs.getInt(1));
                enc.setIdPrestamo(rs.getInt(2));
                enc.setNombre(rs.getString(3));
                enc.setFechaReditos(rs.getString(4));
                enc.setReditosPrestamo(rs.getDouble(5));
                redi = rs.getDouble(5);
            }
            query = "SELECT PagoRedito FROM `pagoreditos` WHERE IdRedito = '"+id+"';";
            rs = st.executeQuery(query);
            while (rs.next()) {
                pago = rs.getDouble(1);
            }
            double total = redi - pago;

            if(total==0d){
                enc.setStatus("Pagado");
            }else{
                enc.setStatus("Sin pagar");
            }

            st.close();
            return enc;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void pagarReditos(int id, double can, String nom, int idred){
        try{
            Class.forName(driver);

            Connection con = null; 
            con = DriverManager.getConnection(url,user,pw);

            Statement st = null;
            st = con.createStatement();

            String query = "INSERT INTO `pagoreditos` (`IdPagoReditos`, `IdRedito`, `IdPrestamo`, `Nombre`, `PagoRedito`) VALUES (NULL, '"+idred+"', '"+id+"', '"+nom+"', '"+can+"')";

            st.execute(query);
            st.close();

            JOptionPane.showMessageDialog(null, "Pago-redito agregado exitosamente");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generarReditos(){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pw);
            Statement st = con.createStatement();

            ArrayList<String> pres = obtenerPrestamosLista();

            for(int i=0;i<pres.size();i++){
                Prestamo prestamo = datosPrestamo(pres.get(i));
                if(prestamo.getTotal()!=0){
                    String hoy = obtenerFecha();
                    String[] part = hoy.split("-");
                    int mes = Integer.parseInt(part[1]);
                    int dia = Integer.parseInt(part[2]);
                    String fecha = prestamo.getFechaPrestamo();
                    String part2[] = fecha.split("-");
                    int mes2 = Integer.parseInt(part2[1]);
                    int dia2 = Integer.parseInt(part2[2]);

                    if(dia == dia2 && mes > mes2){
                        String query = "SELECT * FROM reditos WHERE IdPrestamo = '"+prestamo.getId()+"';";
                        ResultSet rs = null;
                        rs = st.executeQuery(query);

                        ArrayList<String> fechas = new ArrayList<String>();
                        while (rs.next()) {
                            fechas.add(rs.getString(4));
                        }

                        int cont = 0;
                        for(int k=0;k<fechas.size();k++){
                            String tem = fechas.get(k);
                            if(tem.equals(hoy)){
                                cont += 1;
                            }
                        }

                        if(cont==0 || fechas.size()==0){
                            double can = obtenerInteresPrestamo(prestamo.getTotal());
                            query = "INSERT INTO `reditos` (`IdRedito`, `IdPrestamo`, `Nombre`, `FechaReditos`, `ReditosPrestamo`) VALUES (NULL, '"+prestamo.getId()+"', '"+prestamo.getNombre()+"', '"+hoy+"', '"+can+"')";
                            st.execute(query);
                            JOptionPane.showMessageDialog(null, "Reditos generados correctamente");
                        }
                    }
                }
            }

            st.close();
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}