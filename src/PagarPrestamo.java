import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

public class PagarPrestamo extends JFrame implements ActionListener{
    JComboBox<String> noms, cb;
    JLabel lb1;
    JTextField tf;
    JButton b, b2, ver, ver2;
    Funciones f = new Funciones();

    public PagarPrestamo(){
        setLayout(null);
        setTitle("Pagos");
        setSize(400,300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(83,94,93));
        setResizable(false);

        Font font = new Font("Verdana", Font.PLAIN, 20);

        lb1 = new JLabel("<html><p align='right', color='white'>Prestamo:</html></p>");
        lb1.setBounds(20,20,100,35);
        lb1.setFont(font);
        add(lb1);
        noms = new JComboBox<String>();
        ArrayList<String> names = f.obtenerPrestamosLista();
        for(int i=0;i<names.size();i++){
            noms.addItem(names.get(i));
        }
        noms.setBounds(140,20,150,35);
        noms.setFont(font);
        add(noms);

        ver = new JButton("V");
        ver.setBounds(310,20,35,35);
        add(ver);
        ver.addActionListener(this);

        lb1 = new JLabel("<html><p align='right', color='white'>Reditos:</html></p>");
        lb1.setBounds(20,80,100,35);
        lb1.setFont(font);
        add(lb1);
        cb = new JComboBox<String>();
        ArrayList<String> resd = f.obtenerReditosLista();
        for(int i=0;i<resd.size();i++){
            cb.addItem(resd.get(i));
        }
        cb.setBounds(140,80,150,35);
        cb.setFont(font);
        add(cb);

        ver2 = new JButton("V");
        ver2.setBounds(310,80,35,35);
        add(ver2);
        ver2.addActionListener(this);

        lb1 = new JLabel("<html><p align='right', color='white'>Cantidad:</html></p>");
        lb1.setBounds(20,140,100,35);
        lb1.setFont(font);
        add(lb1);
        tf = new JTextField();
        tf.setBounds(140,140,150,35);
        tf.setFont(font);
        add(tf);

        ImageIcon ipagar = new ImageIcon(getClass().getResource("/img/pagar.png"));
        Image imagepag = ipagar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ipagar = new ImageIcon(imagepag);

        b = new JButton("Prestamo", ipagar);
        b.setBounds(20,200,150,35);
        add(b);
        b.addActionListener(this);

        b2 = new JButton("Reditos", ipagar);
        b2.setBounds(200,200,150,35);
        add(b2);
        b2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            if(tf.getText().equals("") || tf.getText().equals("0")){
                JOptionPane.showMessageDialog(null, "No debes dejar campos vacios o en 0");
            }else{
                Prestamo xd = f.datosPrestamo(noms.getSelectedItem().toString());
                String fecha = f.obtenerFecha();
                f.pagarPrestamo(xd.getId(), Double.parseDouble(tf.getText()), fecha, xd.getNombre());
                this.setVisible(false);
            }
        }else if(e.getSource()==b2){
            if(tf.getText().equals("") || tf.getText().equals("0")){
                JOptionPane.showMessageDialog(null, "No debes dejar campos vacios o en 0");
            }else{
                Reditos res = f.datosReditos(cb.getSelectedItem().toString());
                f.pagarReditos(res.getIdPrestamo(), Double.parseDouble(tf.getText()), res.getNombre(), res.getIdRedito());
                this.setVisible(false);
            }
        }else if(e.getSource()==ver){
            Prestamo res = f.datosPrestamo(noms.getSelectedItem().toString());

            JOptionPane.showMessageDialog(null, "ID: " + res.getId() + "\nNombre: " + res.getNombre() + "\nFecha: " + res.getFechaPrestamo() + "\nCantidad: " + res.getCantidadPrestamo() + "\nTermino: " + res.getFechaTermino() + "\nReditos: " + res.getReditos() + "\nTotal: " + res.getTotal());
        }else if(e.getSource()==ver2){
            Reditos res = f.datosReditos(cb.getSelectedItem().toString());

            JOptionPane.showMessageDialog(null, "ID Redito: " + res.getIdRedito() + "\nID Prestamo: " + res.getIdPrestamo() + "\nNombre: " + res.getNombre() + "\nFecha: " + res.getFechaReditos() + "\nCantidad: " + res.getReditosPrestamo() + "\nStatus" + res.getStatus());
        }
    }
}