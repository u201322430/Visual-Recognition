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

    public static String ordenaListasString(List<String> clase, List<String> score){
        String resulF = "";
        List<Float> scoreN = new ArrayList<Float>();

        for (String x: score){//x será cada linea
            System.out.println("FOREACH EJECUTADO");
            if(x.contains("score:")){
                x = x.replaceAll("score: ","");
                scoreN.add(Float.parseFloat(x) * 100);
            }
        }
        //hasta aquí clase = ["clase: ***", "clase: ***", ...]
        //      y    scoreN= [0.947, 0.846, 0.984, 0.54, ...]
        //  inicia el swap
        int i, j;
        String auxS;
        float auxF;
        for (i = 0; i < clase.size() - 1; i++) {
            for (j = 0; j < clase.size() - i - 1; j++) {
                if(scoreN.get(j) < scoreN.get(j+1)){
                    System.out.println(scoreN.get(j) + " < " + scoreN.get(j+1) + " => CAMBIO");
                    auxF = scoreN.get(j);
                    scoreN.set(j, scoreN.get(j+1));
                    scoreN.set(j+1, auxF);
                    auxS = clase.get(j);
                    clase.set(j, clase.get(j+1));
                    clase.set(j+1, auxS);
                }
            }
        }
        //  uno los arrays clase y scoreN en el resulF
        for (i = 0; i < clase.size(); i++) {
            resulF = resulF + clase.get(i) + "\n";
            resulF = resulF + "score: " + scoreN.get(i) + "%\n\n";
        }

        return resulF;
    }

    public static String darResulLimpio(String resul){
        System.out.println("AQUÍ");
        System.out.println(resul);
        String resulF = "";
        resul = resul.replaceAll("\"", "");//sin "
        resul = resul.replaceAll("              ", "");
        resul = resul.replaceAll(",", "");
        String linea[] = resul.split("\n");//cada linea

        List<String> clase = new ArrayList<String>();
        List<String> score = new ArrayList<String>();
        String[] palabra;
        int nLin = linea.length;

        for (String x: linea){//x será cada linea
            System.out.println("FOREACH EJECUTADO");
            if(x.contains("class:")){//si es una clase
                clase.add(x);
                //resulF = resulF + x + "\n";
                System.out.println("FOREACH CLASS");
            }
            else{
                if(x.contains("score:")){//si es un score
                    score.add(x);
                    //resulF = resulF + x + "\n";
                    System.out.println("FOREACH SCORE");
                }
            }

        }
        System.out.println("SALIÓ DE darResultadoLimpio");
        //ya se tienen clase y score. Ahora uso ordenaListasString()
        resulF = ordenaListasString(clase, score);

        return resulF;
    }
}
