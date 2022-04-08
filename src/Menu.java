import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Menu extends JFrame implements ActionListener{
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lblogo, lbsem, lbdin, lbint, lbpre, lbred, lbret, lbtot;
    private JButton b1,b2,b3,b4,b5,b6,bshow;
    Funciones f = new Funciones();

    public Menu(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Caja 2022");
        setSize(800,450);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        getContentPane().setBackground(new Color(83,94,93));
        setResizable(false);

        ImageIcon logo = new ImageIcon(getClass().getResource("/img/logo.png"));
        int ancho = 220;
        int largo = 300;
        Image imagenlogo = logo.getImage().getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
        logo = new ImageIcon(imagenlogo);
        lblogo = new JLabel();
        lblogo.setIcon(logo);
        lblogo.setBounds(550, 10,ancho,largo);
        add(lblogo);

        Font font = new Font("Verdana", Font.PLAIN, 24);

        ImageIcon iagregar = new ImageIcon(getClass().getResource("/img/agregar.png"));
        Image imageagr = iagregar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        iagregar = new ImageIcon(imageagr);

        ImageIcon ibuscar = new ImageIcon(getClass().getResource("/img/buscar.png"));
        Image imagebus = ibuscar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ibuscar = new ImageIcon(imagebus);

        ImageIcon ipagar = new ImageIcon(getClass().getResource("/img/pagar.png"));
        Image imagepag = ipagar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ipagar = new ImageIcon(imagepag);

        lbsem = new JLabel("<html><p align='right', color='yellow'>Semana: " + f.obtenerSemana() + "</html></p>");
        lbsem.setBounds(20,350,200,40);
        lbsem.setFont(new Font("TimesRoman", Font.BOLD, 12));
        add(lbsem);

        bshow = new JButton("...");
        bshow.setBounds(20,390,20,20);
        add(bshow);
        bshow.addActionListener(this);

        lbdin = new JLabel("<html><p align='right', color='yellow'>Dinero: \t" + f.obtenerDinero() + "</html></p>");
        lbdin.setBounds(170,350,200,40);
        lbdin.setFont(new Font("TimesRoman", Font.BOLD, 12));
        lbdin.setVisible(false);
        add(lbdin);

        lbint = new JLabel("<html><p align='right', color='yellow'>Intereses: " + f.obtenerInteresP() + "</html></p>");
        lbint.setBounds(320,350,200,40);
        lbint.setFont(new Font("TimesRoman", Font.BOLD, 12));
        lbint.setVisible(false);
        add(lbint);

        lbpre = new JLabel("<html><p align='right', color='yellow'>Prestamos: " + (f.obtenerPrestamos() - f.obtenerPagoPrestamo()) + "</html></p>");
        lbpre.setBounds(470,350,200,40);
        lbpre.setFont(new Font("TimesRoman", Font.BOLD, 12));
        lbpre.setVisible(false);
        add(lbpre);

        lbred = new JLabel("<html><p align='right', color='yellow'>Reditos: " + (f.obtenerReditos() - f.obtenerPagoReditos()) + "</html></p>");
        lbred.setBounds(620,350,200,40);
        lbred.setFont(new Font("TimesRoman", Font.BOLD, 12));
        lbred.setVisible(false);
        add(lbred);

        lbret = new JLabel("<html><p align='right', color='yellow'>Retiros: " + f.obtenerRetiros() + "</html></p>");
        lbret.setBounds(170,375,200,40);
        lbret.setFont(new Font("TimesRoman", Font.BOLD, 12));
        lbret.setVisible(false);
        add(lbret);

        lbtot = new JLabel("<html><p align='right', color='yellow'><u>Total: " + ((f.obtenerDinero()+f.obtenerInteresP())-(f.obtenerPrestamos()+f.obtenerReditos()+f.obtenerRetiros())) + "</u></html></p>");
        lbtot.setBounds(320,375,200,40);
        lbtot.setFont(new Font("TimesRoman", Font.BOLD, 12));
        lbtot.setVisible(false);
        add(lbtot);

        lb1 = new JLabel("<html><p align='right', color='white'>1. Agregar persona</html></p>");
        lb1.setBounds(20,20,300,40);
        lb1.setFont(font);
        add(lb1);
        b1 = new JButton("1", iagregar);
        b1.setBounds(340,20,200,40);
        add(b1);
        b1.addActionListener(this);

        lb2 = new JLabel("<html><p align='right', color='white'>2. Agregar aportación</html></p>");
        lb2.setBounds(20,80,300,40);
        lb2.setFont(font);
        add(lb2);
        b2 = new JButton("2", iagregar);
        b2.setBounds(340,80,200,40);
        add(b2);
        b2.addActionListener(this);

        lb3 = new JLabel("<html><p align='right', color='white'>3. Buscar persona</html></p>");
        lb3.setBounds(20,140,300,40);
        lb3.setFont(font);
        add(lb3);
        b3 = new JButton("3", ibuscar);
        b3.setBounds(340,140,200,40);
        add(b3);
        b3.addActionListener(this);

        lb4 = new JLabel("<html><p align='right', color='white'>4. Agregar prestamo</html></p>");
        lb4.setBounds(20,200,300,40);
        lb4.setFont(font);
        add(lb4);
        b4 = new JButton("4", iagregar);
        b4.setBounds(340,200,200,40);
        add(b4);
        b4.addActionListener(this);

        lb5 = new JLabel("<html><p align='right', color='white'>5. Pagar prestamo</html></p>");
        lb5.setBounds(20,260,300,40);
        lb5.setFont(font);
        add(lb5);
        b5 = new JButton("5", ipagar);
        b5.setBounds(340,260,200,40);
        add(b5);
        b5.addActionListener(this);

        lb6 = new JLabel("<html><p align='right', color='white'>6. Retiro caja</html></p>");
        lb6.setBounds(20,320,300,40);
        lb6.setFont(font);
        add(lb6);
        b6 = new JButton("6", ipagar);
        b6.setBounds(340,320,200,40);
        add(b6);
        b6.addActionListener(this);

        f.generarReditos();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            new AgregarPersona();
        }else if(e.getSource()==b2){
            new AgregarAportacion();
        }else if(e.getSource()==b3){
            new BuscarPersona();
        }else if(e.getSource()==b4){
            new AgregarPrestamo();
        }else if(e.getSource()==b5){
            new PagarPrestamo();
        }else if(e.getSource()==bshow){
            if(lbdin.isVisible()==false){
                lbdin.setVisible(true);
                lbint.setVisible(true);
                lbpre.setVisible(true);
                lbred.setVisible(true);
                lbret.setVisible(true);
                lbtot.setVisible(true);
            }else{
                lbdin.setVisible(false);
                lbint.setVisible(false);
                lbpre.setVisible(false);
                lbred.setVisible(false);
                lbret.setVisible(false);
                lbtot.setVisible(false);
            }
        }
    }
}