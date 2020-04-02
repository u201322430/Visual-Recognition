import java.io.FileNotFoundException;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
import graficos.MarcoTexto;
import graficos.Variables;
//package src.main.java.CreandoMarcos import CreandoMarcos;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MarcoTexto marco1 = new MarcoTexto();

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
                Variables.bucle = false;
            }
            Thread.sleep(1000);
        }


    }
}