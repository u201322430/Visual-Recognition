package graficos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoTexto extends JFrame{
    public MarcoTexto(){
        setBounds(600,300,600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaTexto miLamina1 = new LaminaTexto();
        add(miLamina1);
        setVisible(true);
    }
}

class LaminaTexto extends JPanel{
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

        JButton miBoton = new JButton("Ejecutar");
        DameTexto miEvento = new DameTexto();
        miBoton.addActionListener(miEvento);
        add(miBoton);

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
    private JTextField campo1;
    private JTextField campo2;
    private JTextField campo3;
}