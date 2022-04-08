import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class AgregarAportacion extends JFrame implements ActionListener{
    Funciones f = new Funciones();
    JComboBox<String> cb;
    JLabel lb;
    JTextField tf;
    JButton b;

    public AgregarAportacion(){
        setLayout(null);
        setTitle("Agregar aporte");
        setSize(400,250);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(83,94,93));
        setResizable(false);

        Font font = new Font("Verdana", Font.PLAIN, 20);

        lb = new JLabel("<html><p align='right', color='white'>Nombre:</html></p>");
        lb.setFont(font);
        lb.setBounds(20,20,150,40);
        add(lb);

        cb = new JComboBox<String>();
        cb.setBounds(150,20,150,40);
        ArrayList<String> names = f.obtenerNombres();
        for(int i=0;i<names.size();i++){
            cb.addItem(names.get(i));
        }
        cb.setFont(font);
        add(cb);

        lb = new JLabel("<html><p align='right', color='white'>Cantidad:</html></p>");
        lb.setBounds(20,80,150,40);
        lb.setFont(font);
        add(lb);

        tf = new JTextField();
        tf.setBounds(150,80,150,40);
        tf.setFont(font);
        add(tf);
        tf.addKeyListener(new KeyAdapter(){
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

        b = new JButton("Agregar", iagregar);
        b.setBounds(100,140,200,40);
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
                String nom = cb.getSelectedItem().toString();
                Double can = Double.parseDouble(tf.getText());
                String fecha = f.obtenerFecha();
                int dia = f.obtenerDia();
                double red = f.obtenerInteres(can, dia);
                f.agregarAporte(nom, can, fecha, dia, red);
            }
        }
    }
}
