package Compilador;

import Compilador.Default.AnalizadorLexico.AnalizarLexicoDefault;
import org.json.JSONObject;

public class EjecutarAnalizadores {

    public JSONObject AnalizarSoloLexico(String expresion, String lenguaje){

        return this.ejecutarAnalizadorLexicoDefault(expresion);

    }

    private JSONObject ejecutarAnalizadorLexicoDefault(String expresion){
        //Analisis únicamente del Analizador Léxico por Default
        AnalizarLexicoDefault LexicoLenguajeNatural = new AnalizarLexicoDefault();
        LexicoLenguajeNatural.EjecutarAnalisisLexico(expresion);
        return (LexicoLenguajeNatural.getResultadoDelAnalisis());
    }

}
