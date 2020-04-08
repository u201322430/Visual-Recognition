package graficos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MarcoTexto extends JFrame{
    public MarcoTexto(){
        setBounds(600,300,600,350);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //LaminaTexto miLamina1 = new LaminaTexto();
        //add(miLamina1);
        //setVisible(true);
    }

    public static class LaminaTexto extends JPanel{
        public LaminaTexto(){
            JLabel label1 = new JLabel("apikey");
            add(label1);
            campo1 = new JTextField(50);
            add(campo1);
            JLabel label2 = new JLabel("serviceURL");
            add(label2);
            campo2 = new JTextField(50);
            add(campo2);
            JLabel label3 = new JLabel("imageURL");
            add(label3);
            campo3 = new JTextField(50);
            add(campo3);

            JButton btnShowImage = new JButton("Mostrar Imagen");
            ShowImage eventShowImage = new ShowImage();
            btnShowImage.addActionListener(eventShowImage);
            add(btnShowImage);



            JButton miBoton = new JButton("Ejecutar");//se crea el boton
            DameTexto miEvento = new DameTexto();//crea evento
            miBoton.addActionListener(miEvento);//boton ejecuta evento
            add(miBoton);//muestra el boton

        }

        private class DameTexto implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(campo1.getText());
                //System.out.println(campo2.getText());
                //System.out.println(campo3.getText());
                Variables.apikey = campo1.getText();
                Variables.serviceURL = campo2.getText();
                Variables.imageURL = campo3.getText();
                Variables.iniciar = true;
            }
        }
        private class ShowImage implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Inicializar y asignar url de la imagen a mostrar
                    Variables.imageURL = campo3.getText();
                    URL url = new URL(Variables.imageURL);
                    //Asignacion de url a la imagen
                    Variables.imagen = ImageIO.read(url);
                    System.out.println("Paso 1");
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Variables.imagenValida = true;
                ImageIcon icon = new ImageIcon(Variables.imagen);//ico: info de la imagen
                JLabel imgLabel = new JLabel(icon);

                MarcoTexto marco2 = new MarcoTexto();
                marco2.setBounds(200,100,icon.getIconWidth(),icon.getIconHeight());
                marco2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                marco2.add(imgLabel);

                marco2.setVisible(true);

                System.out.println("Paso 2");
            }
        }
        private JTextField campo1;
        private JTextField campo2;
        private JTextField campo3;
    }
}

