package Compilador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompiladorLenguajeUsuario {

    //Obtiene la ruta del proyecto:
    private final String DireccionProyecto = System.getProperty("user.dir").replace("\\", "/");

    public void GenerarAnalizadorLexico(){
        this.GenerarLexicoDefault();
    }

    private void GenerarLexicoDefault() {

        //Ruta de los archivos
        String rutaLexico = DireccionProyecto + "/src/Compilador/Default/CodigoFuente/Lexer.flex";

        File archivo;

        //Para leer Lexer.flex y generar el Analizador Léxico
        archivo = new File(rutaLexico);
        jflex.Main.generate(archivo);

        //Moviendo el archivo Lexer.java
        this.moverArchivos("/src/Compilador/Default/CodigoFuente/Lexer.java","/src/Compilador/Default/AnalizadorLexico/Lexer.java");

    }

    private void moverArchivos(String rutaDelArchivoExistente, String rutaNuevaDelArchivo){
        Path path = Paths.get(DireccionProyecto + rutaNuevaDelArchivo);
        //Eliminando si existe un archivo previo
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException ex) {
                //Logger.getLogger(Tangananica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            Files.move(
                    Paths.get(DireccionProyecto+rutaDelArchivoExistente),
                    path
            );
        } catch (IOException ex) {
            //Logger.getLogger(Tangananica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
