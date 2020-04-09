package graficos;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Variables{
    public static String apikey;
    public static String serviceURL;
    public static String imageURL;
    public static boolean iniciar = false;
    public static boolean bucle = true;
    public static Image imagen = null;
    public static boolean imagenValida = false;
    public static String resul;
    public static String resulFinal;
    public static boolean rec = true;

    public static String darResulLimpio(String resul){
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
            System.out.println("FOREACH EJECUTADO");
            if(x.contains("class:")){//si es una clase
                clase.add(x);
                resulF = resulF + x + "\n";
                System.out.println("FOREACH CLASS");
            }
            else{
                if(x.contains("score:")){//si es un score
                    score.add(x);
                    resulF = resulF + x + "\n";
                    System.out.println("FOREACH SCORE");
                }
            }
        }
        System.out.println("SALIÓ DE darResultadoLimpio");
        return resulF;
    }
}
