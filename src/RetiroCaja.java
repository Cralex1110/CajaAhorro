import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class RetiroCaja extends JFrame implements ActionListener{
    Funciones f = new Funciones();
    JComboBox<String> cb_nombres;
    JTextField tf_cant;
    JButton jb_retirar;
    JLabel lb1, lb2;

    public RetiroCaja(){
        setLayout(null);
        setTitle("Retiros");
        setSize(400,250);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(83,94,93));
        setResizable(false);

        Font font = new Font("Verdana", Font.PLAIN, 20);

        lb1 = new JLabel("<html><p align='center', color='white'>Nombre:</p></html>");
        lb1.setBounds(20,20,100,35);
        lb1.setFont(font);
        add(lb1);

        cb_nombres = new JComboBox<>();
        cb_nombres.setBounds(150,20,150,40);
        ArrayList<String> nombres = f.obtenerNombres();
        for(int i=0;i<nombres.size();i++){
            cb_nombres.addItem(nombres.get(i));
        }
        cb_nombres.setFont(font);
        add(cb_nombres);

        lb2 = new JLabel("<html><p align='center', color='white'>Cantidad:</p></html>");
        lb2.setBounds(20,80,100,35);
        lb2.setFont(font);
        add(lb2);

        tf_cant = new JTextField();
        tf_cant.setBounds(150,80,150,40);
        tf_cant.setFont(font);
        add(tf_cant);

        ImageIcon ipagar = new ImageIcon(getClass().getResource("/img/pagar.png"));
        Image imagepag = ipagar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ipagar = new ImageIcon(imagepag);

        jb_retirar = new JButton("Retirar", ipagar);
        jb_retirar.setBounds(100,140,150,35);
        add(jb_retirar);
        jb_retirar.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jb_retirar){
            String nom = cb_nombres.getSelectedItem().toString();
            double can = Double.parseDouble(tf_cant.getText());
            String fecha = f.obtenerFecha();
            f.retirarCaja(nom, can, fecha);
            this.setVisible(false);
        }
    }
}
