package graficos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.text.JTextComponent;

public class MarcoTexto extends JFrame{
    public MarcoTexto(){
        setBounds(700,200,600,350);
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



            JButton btnEjecutar = new JButton("Ejecutar");//se crea el boton
            DameTexto miEvento = new DameTexto();//crea evento
            btnEjecutar.addActionListener(miEvento);//boton ejecuta evento
            add(btnEjecutar);//muestra el boton

        }
        /*static int numeroLineas(String resul){
            int numLineas = 0;



            for (String elemento: array)
                System.out.println(elemento);

            while(resul.has){
                resul.nextLine();
                numLineas++;
            }


            return numLineas;
        }*/
        /*static String darResulLimpio(String resul){
            System.out.println("AQUÍ");
            System.out.println(resul);
            String resulF = "";
            resul = resul.replaceAll("\"", "");//sin "
            resul = resul.replaceAll("              ", "");
            String linea[] = resul.split("\n");//cada linea

            List<String> clase = new ArrayList<String>();
            List<String> score = new ArrayList<String>();
            String[] palabra;
            int nLin = linea.length;

            for (String x: linea){//x será cada linea
                if(x.contains("class:")){//si es una clase
                    clase.add(x);
                    resul = resul + x + "\n";
                }
                else{
                    if(x.contains("score:")){//si es un score
                        score.add(x);
                        resul = resul + x + "\n\n";
                    }
                }
            }
            System.out.println("SALIÓ DE darResultadoLimpio");
            return resulF;
        }*/
        private class DameTexto implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(campo1.getText());
                //System.out.println(campo2.getText());
                //System.out.println(campo3.getText());
                Variables.apikey = campo1.getText();
                Variables.serviceURL = campo2.getText();
                Variables.imageURL = campo3.getText();
                System.out.println("Soy evento clic y Variables.resul es:");
                System.out.println(Variables.resul);
                Variables.apikey = campo1.getText();
                //Variables.resulFinal = Variables.darResulLimpio(Variables.resul);
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
            }
        }
        private JTextField campo1;
        private JTextField campo2;
        private JTextField campo3;
    }
    public static class LaminaResultado extends JPanel {
        public LaminaResultado() {
            JTextArea lbResul = new JTextArea(Variables.resulFinal);
            add(lbResul);
        }
    }
}

