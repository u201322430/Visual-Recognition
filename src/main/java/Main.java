import java.io.FileNotFoundException;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;

import graficos.MarcoTexto.LaminaTexto;
import graficos.MarcoTexto.LaminaResultado;
import graficos.MarcoTexto;
import graficos.Variables;

import javax.swing.*;
//package src.main.java.CreandoMarcos import CreandoMarcos;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MarcoTexto marco1 = new MarcoTexto();
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaTexto miLamina1 = new LaminaTexto();
        marco1.add(miLamina1);
        marco1.setVisible(true);

        while(Variables.bucle == true){
            if (Variables.iniciar == true){
                IamAuthenticator authenticator = new IamAuthenticator(Variables.apikey);
                ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
                        .url(Variables.imageURL)
                        .build();

                VisualRecognition visualRecognition = new VisualRecognition("2018-03-19", authenticator);
                visualRecognition.setServiceUrl(Variables.serviceURL);

                ClassifiedImages resultado = visualRecognition.classify(classifyOptions).execute().getResult();
                System.out.println(resultado);
                Variables.iniciar = false;

                //mostrar el resultadoen marco3
                Variables.resul = resultado.toString();
                System.out.println("Variable.resul = resultado");

                MarcoTexto marco3 = new MarcoTexto();
                marco3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                LaminaResultado miLamina3 = new LaminaResultado();
                marco3.add(miLamina3);
                marco3.setVisible(true);
            }
            Thread.sleep(1000);
        }


    }
}
