import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

public class PagarPrestamo extends JFrame implements ActionListener{
    JComboBox<String> noms, cb2;
    JLabel lb1;
    JTextField tf;
    JButton b, ver;
    Funciones f = new Funciones();

    public PagarPrestamo(){
        setLayout(null);
        setTitle("Pagos");
        setSize(400,300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(83,94,93));

        Font font = new Font("Verdana", Font.PLAIN, 20);

        lb1 = new JLabel("<html><p align='right', color='white'>ID:</html></p>");
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

        lb1 = new JLabel("<html><p align='right', color='white'>Cantidad:</html></p>");
        lb1.setBounds(20,80,100,35);
        lb1.setFont(font);
        add(lb1);
        tf = new JTextField();
        tf.setBounds(140,80,150,35);
        tf.setFont(font);
        add(tf);

        lb1= new JLabel("<html><p align='right', color='white'>Concepto:</html></p>");
        lb1.setBounds(20,140,100,35);
        lb1.setFont(font);
        add(lb1);
        cb2 = new JComboBox<String>();
        cb2.setBounds(140,140,150,35);
        cb2.addItem("Pago-reditos");
        cb2.addItem("Pago-prestamo");
        cb2.setFont(font);
        add(cb2);

        ImageIcon ipagar = new ImageIcon(getClass().getResource("/img/pagar.png"));
        Image imagepag = ipagar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ipagar = new ImageIcon(imagepag);

        b = new JButton("Pagar", ipagar);
        b.setBounds(100,200,150,35);
        add(b);
        b.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            Double c = Double.parseDouble(tf.getText());
            if(tf.getText().equals("") || c==0){
                JOptionPane.showMessageDialog(null, "No debes dejar campos vacios o en 0");
            }else{
                Prestamo res = f.datosPrestamo(Integer.parseInt(cb2.getSelectedItem().toString()));
                String nom = res.getNombre();
                if(cb2.getSelectedItem().toString().equals("Pago-reditos")){
                    String fecha = f.obtenerFecha();
                    f.pagarPrestamo(Integer.parseInt(noms.getSelectedItem().toString()), Double.parseDouble(tf.getText()), fecha, nom);
                }else{
                    int resul = f.obtenerIdReditos(Integer.parseInt(noms.getSelectedItem().toString()));
                    if(resul == 0){
                        JOptionPane.showMessageDialog(null, "No existen reditos por pagar", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        f.pagarReditos(Integer.parseInt(noms.getSelectedItem().toString()), Double.parseDouble(tf.getText()), nom, resul);
                    }
                }
                this.setVisible(false);
            }
        }else if(e.getSource()==ver){
            Prestamo res = f.datosPrestamo(Integer.parseInt(cb2.getSelectedItem().toString()));

            JOptionPane.showMessageDialog(null, "ID: " + res.getId() + "\nNombre: " + res.getNombre() + "\nFecha: " + res.getFechaPrestamo() + "\nCantidad: " + res.getCantidadPrestamo() + "\nTermino: " + res.getFechaTermino() + "\nReditos: " + res.getReditos() + "\nTotal: " + res.getTotal(), "Resultado", JOptionPane.PLAIN_MESSAGE);
        }
    }
}