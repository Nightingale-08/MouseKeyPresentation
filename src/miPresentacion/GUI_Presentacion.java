package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
/**
 * This class contains main and GUI Class
 * @autor Luis -F Belalcazar -A luis.felipe.belalcazar@correounivalle.edu.co
 * @version v.1.0.0 date:29/11/2021
 */
public class GUI_Presentacion extends JFrame {

    // attributes
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos, panelMouse;
    private Titulos titulo;
    private JLabel labelImage;
    private Escucha escucha;
    private JTextArea textExpectativas;
    private ImageIcon imageuno;

    /**
     * Constructor of GUI class
     */
    //
    public GUI_Presentacion() {

        initGUI();
        // BASE CONFIGURATION OF WINDOW

        this.setTitle("Mi Presentacion");
        //this.setSize(850, 580);
        this.pack();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        imageuno = new ImageIcon(getClass().getResource("/recursos/hola.JPG"));
        labelImage.setIcon(imageuno);
        panelMouse.add(labelImage);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {

        // definition of container and layout.
        //this.setLayout();

        //create listening and control objects
        escucha = new Escucha();


        //configure Jcomponents

        titulo = new Titulos("Hola soy Luis Felipe, oprime los botones...", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        panelMouse = new JPanel();
        panelMouse.addMouseListener(escucha);
        panelMouse.addMouseMotionListener(escucha);
        panelMouse.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi ...",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Times new Roman", Font.BOLD, 18), Color.BLACK));// FONT NO apica color
        this.add(panelMouse, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(850,540));
        panelMouse.addKeyListener(escucha);
        panelMouse.setFocusable(true);

          /*
        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi ...",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Times new Roman", Font.BOLD, 18), Color.BLACK));// FONT NO apica color
        this.add(panelDatos, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(850,540));
      */

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi Hobby");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        this.add(panelBotones, BorderLayout.SOUTH);


        labelImage = new JLabel();

        textExpectativas = new JTextArea(10, 12);


    }
    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();

            }
        });


    }
    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    private class Escucha extends MouseAdapter implements /*ActionListener,*/ KeyListener {
        private ImageIcon image;

        /*
                @Override
                public void actionPerformed(ActionEvent e) {

                    panelDatos.removeAll();

                   // JOptionPane.showMessageDialog(null,"Oprimiste boton");
                    if (e.getSource()== miFoto){
                        image = new ImageIcon(getClass().getResource("/recursos/miFoto.JPG"));
                        labelImage.setIcon(image);
                        panelDatos.add(labelImage);

                    }else{
                        if(e.getSource() == miHobby){
                            image = new ImageIcon(getClass().getResource("/recursos/Hobby.jpg"));
                            labelImage.setIcon(image);
                            panelDatos.add(labelImage);

                        }else{

                            textExpectativas.setText("No se de java, ni de componentes graficos de ningun tipo.\n\n"+
                                                      "Espero poder aprender a presentar mi codigo con interfaces visuales " +
                                                       "y de forma que atraigan al usuario. \n\n"+
                                                      "Tambien quiero terminar el curso de la mejor manera posible y conociendo el nuevo " +
                                                       " paradigama que se\nnos presenta, para poder aplicar este metodo en lo que sigue de mi carrrera profesional."
                                                      );
                            textExpectativas.setBackground(null);
                           // textExpectativas.setBounds(new Rectangle(130, 149, 125, 20));
                            textExpectativas.setFont (new Font(Font.DIALOG_INPUT, 1, 14));
                            //textExpectativas.


                            panelDatos.add(textExpectativas);
                        }
KeyEvent.getKeyText(e.getKeyCode()).equalsIgnoreCase("m"
                    }


                revalidate();
                repaint();
                }
        */
        @Override
        public void keyTyped(KeyEvent e) {
            panelMouse.removeAll();
           if( e.getSource()==misExpectativas &&  e.getKeyCode()==KeyEvent.VK_M){

                    textExpectativas.setText("No se de java, ni de componentes graficos de ningun tipo.\n\n"+
                            "Espero poder aprender a presentar mi codigo con interfaces visuales " +
                            "y de forma que atraigan al usuario. \n\n"+
                            "Tambien quiero terminar el curso de la mejor manera posible y conociendo el nuevo " +
                            " paradigama que se\nnos presenta, para poder aplicar este metodo en lo que sigue de mi carrrera profesional."
                    );
               textExpectativas.setBackground(null);
               // textExpectativas.setBounds(new Rectangle(130, 149, 125, 20));
               textExpectativas.setFont (new Font(Font.DIALOG_INPUT, 1, 14));
               //textExpectativas.
               panelMouse.add(textExpectativas);

           }
            revalidate();
            repaint();


        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            panelMouse.removeAll();
            if (e.getSource() == miFoto && e.getClickCount()==1 ) {
                image = new ImageIcon(getClass().getResource("/recursos/miFoto.JPG"));
                labelImage.setIcon(image);
                panelMouse.add(labelImage);

            } else {
                if (e.getSource() == miHobby && e.getClickCount()==2) {
                    image = new ImageIcon(getClass().getResource("/recursos/Hobby.jpg"));
                    labelImage.setIcon(image);
                    panelMouse.add(labelImage);


                }


            }

            revalidate();
            repaint();

        }
    }
}