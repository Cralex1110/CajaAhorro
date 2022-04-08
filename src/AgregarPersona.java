import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class AgregarPersona extends JFrame implements ActionListener{
    JLabel lb;
    JButton b;
    JTextField tfnom, tfmon;

    public AgregarPersona(){
        setLayout(null);
        setTitle("Alta Persona");
        setSize(400,250);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(83,94,93));
        setResizable(false);

        Font font = new Font("Verdana", Font.PLAIN, 20);

        lb = new JLabel("<html><p align='right', color='white'>Nombre:</html></p>");
        lb.setFont(font);
        lb.setBounds(20,20,300,40);
        add(lb);

        tfnom = new JTextField();
        tfnom.setBounds(150,20,200,40);
        tfnom.setFont(font);
        add(tfnom);
        tfnom.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                int key = e.getKeyChar();
                boolean mayusculas = key >= 65 && key <= 90;
                boolean minusculas = key >= 97 && key <= 122;
                boolean espacio = key == 32;
                        
                if (!(minusculas || mayusculas || espacio))
                {
                    e.consume();
                }
                if(tfnom.getText().length() >= 50){
                    e.consume();
                }
            }
        });

        tfmon = new JTextField();
        tfmon.setBounds(150,80,200,40);
        tfmon.setFont(font);
        add(tfmon);
        tfmon.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                int key = e.getKeyChar();
                boolean numeros = key >= 48 && key <= 57;
                boolean punto = key == 46;
                if (!(numeros || punto)){
                    e.consume();
                }
            }
        });

        lb = new JLabel("<html><p align='right', color='white'>Monto:</html></p>");
        lb.setFont(font);
        lb.setBounds(20,80,300,40);
        add(lb);

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
            String pr = tfnom.getText();
            String mn = tfmon.getText();
            if(pr.equals("") || mn.equals("")){
                JOptionPane.showMessageDialog(null, "No debes dejar campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else if(tfnom.getText().length()>25){
                JOptionPane.showMessageDialog(null, "El nombre no debe tener más de 25 carácteres", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                Funciones f = new Funciones();
                f.agregar(tfnom.getText(), Double.parseDouble(tfmon.getText()));
                this.setVisible(false);
            }
        }
    }
}
