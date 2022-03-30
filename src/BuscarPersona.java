import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class BuscarPersona extends JFrame{
    JLabel lb1;
    JComboBox<String> nom;
    JButton b1;
    Funciones f = new Funciones();

    public BuscarPersona(){
        setLayout(null);
        setTitle("Buscar");
        setSize(400,200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(83,94,93));

        Font font = new Font("Verdana", Font.PLAIN, 20);

        lb1 = new JLabel("<html><p align='right', color='white'>Nombre:</html></p>");
        lb1.setBounds(20,20,150,40);
        lb1.setFont(font);
        add(lb1);

        nom = new JComboBox<String>();
        ArrayList<String> names = f.obtenerNombres();
        for(int i=0;i<names.size();i++){
            nom.addItem(names.get(i));
        }
        nom.setFont(font);
        nom.setBounds(150,20,200,40);
        add(nom);

        ImageIcon ibuscar = new ImageIcon(getClass().getResource("/img/buscar.png"));
        Image imagebus = ibuscar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ibuscar = new ImageIcon(imagebus);

        b1 = new JButton("Buscar", ibuscar);
        b1.setBounds(100,80,200,40);
        add(b1);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Caja res = f.buscar(nom.getSelectedItem().toString());

                JOptionPane.showMessageDialog(null, "\nNombre: " + res.getNombre() + "\nCantidad: " + res.getCantidad() + "\nIntereses: " + res.getIntereses() + "\nPrestamos: " + res.getPrestamos() + "\nReditos: " + res.getReditos() + "\nRetiros: " + res.getRetiros() + "\nTOTAL: " + res.getTotal() + "\nSeamanas: " + res.getSemanas(), "Resultado", JOptionPane.PLAIN_MESSAGE);
            }
        });
        setVisible(true);
    }
}
