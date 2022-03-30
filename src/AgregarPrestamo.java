import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

public class AgregarPrestamo extends JFrame{
    JLabel lb1, lb2;
    JComboBox<String> noms;
    JTextField tf1;
    JButton b1;
    Funciones f = new Funciones();

    public AgregarPrestamo(){
        setLayout(null);
        setTitle("Prestamo");
        setSize(400,220);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(83,94,93));

        Font font = new Font("Verdana", Font.PLAIN, 20);

        lb1 = new JLabel("<html><p align='right', color='white'>Nombre:</html></p>");
        lb1.setBounds(20,20,100,35);
        lb1.setFont(font);
        add(lb1);

        noms = new JComboBox<String>();
        ArrayList<String> names = f.obtenerNombres();
        for(int i=0;i<names.size();i++){
            noms.addItem(names.get(i));
        }
        noms.setBounds(140,20,150,35);
        noms.setFont(font);
        add(noms);

        lb2 = new JLabel("<html><p align='right', color='white'>Cantidad:</html></p>");
        lb2.setBounds(20,70,100,35);
        lb2.setFont(font);
        add(lb2);

        tf1 = new JTextField();
        tf1.setBounds(140,70,150,35);
        tf1.setFont(font);
        add(tf1);
        tf1.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                int key = e.getKeyChar();
                boolean numeros = key >= 48 && key <= 57;
                boolean punto = key == 46;
                if (!(numeros || punto)){
                    e.consume();
                }
            }
        });

        ImageIcon iagregar = new ImageIcon(getClass().getResource("/img/agregar.png"));
        Image imageagr = iagregar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        iagregar = new ImageIcon(imageagr);

        b1 = new JButton("Agregar", iagregar);
        b1.setBounds(50,120,200,40);
        add(b1);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tf1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "No deje campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    String fecha = f.obtenerFecha();
                    f.agregarPrestamo(noms.getSelectedItem().toString(), Double.parseDouble(tf1.getText()), fecha);
                }
            }

        });

        setVisible(true);
    }
}