package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Presentacion extends JFrame {

    // attributes
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel  panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel  labelImage;
    private Escucha escucha;
    private JTextArea textExpectativas;
    private ImageIcon imageuno;
    //methods
    public GUI_Presentacion() {

        initGUI();
        // BASE CONFIGURATION OF WINDOW

        this.setTitle("Mi Presentacion");
        this.setSize(850, 580);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        imageuno = new ImageIcon(getClass().getResource("/recursos/hola.JPG"));
        labelImage.setIcon(imageuno);
        panelDatos.add(labelImage);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    private void initGUI() {

        // definition of container and layout.
        //this.setLayout();

        //create listening and control objects
        escucha = new Escucha();


        //configure Jcomponents

        titulo = new Titulos("Hola soy Luis Felipe, oprime los botones...", Color.BLACK);
        this.add(titulo,BorderLayout.NORTH);


        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi ...",
                             TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                             new Font("Times new Roman",Font.BOLD,18), Color.BLACK));// FONT NO apica color
        this.add(panelDatos, BorderLayout.CENTER);




        miFoto = new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Este es mi Hobby");
        miHobby.addActionListener(escucha);
        misExpectativas= new JButton("Creo que...");
        misExpectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        this.add(panelBotones, BorderLayout.SOUTH);


        labelImage = new JLabel();

        textExpectativas = new JTextArea(10, 12 );



    }

    public static void  main (String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              GUI_Presentacion  miGUIPresentacion = new GUI_Presentacion();

            }
        });


    }

    private class Escucha implements ActionListener{
        private ImageIcon image;

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

            }


        revalidate();
        repaint();
        }
    }


}
