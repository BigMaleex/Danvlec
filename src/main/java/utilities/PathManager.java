package utilities;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Clase para manejar las rutas de archivos en desarrollo y producción
 */
public class PathManager {

    private static final boolean isDevelopment = !isRunningFromJar();

    /**
     * Verifica si la aplicación está corriendo desde un JAR
     * @return true si está ejecutándose desde un JAR, false si es en desarrollo
     */
    private static boolean isRunningFromJar() {
        String protocol = PathManager.class.getResource("").getProtocol();
        return "jar".equals(protocol);
    }

    public static String getHTMLPath(String file){

        if(isDevelopment){

            return "/HTML/" + file;

        }else{

            return "/HTML/" + file;

        }

    }

    /**
     * Obtiene la ruta base de la aplicación
     * @return La ruta base como String
     */
    public static String getBasePath() {
        if (isDevelopment) {
            return "src/main/resources/";
        } else {
            try {
                String jarPath = PathManager.class.getProtectionDomain()
                        .getCodeSource().getLocation().toURI().getPath();
                return new File(jarPath).getParent() + "/";
            } catch (URISyntaxException e) {
                return "./";
            }
        }
    }

    /**
     * Obtiene la ruta para archivos FXML
     * @param fileName Nombre del archivo FXML
     * @return Ruta completa al archivo FXML
     */
    public static String getFxmlPath(String fileName) {
        if (isDevelopment) {
            return "/FXML/" + fileName;
        } else {
            return "/FXML/" + fileName;
        }
    }

    /**
     * Obtiene la ruta para archivos CSS
     * @param fileName Nombre del archivo CSS
     * @return Ruta completa al archivo CSS
     */
    public static String getCssPath(String fileName) {
        if (isDevelopment) {
            return "/CSS/" + fileName;
        } else {
            return "/CSS/" + fileName;
        }
    }

    /**
     * Obtiene la ruta para archivos de imágenes
     * @param fileName Nombre del archivo de imagen
     * @return Ruta completa al archivo de imagen
     */
    public static String getImagePath(String fileName) {
        if (isDevelopment) {
            return "/Images/" + fileName;
        } else {
            return "/Images/" + fileName;
        }
    }

    public static String getFontPath(String fileName) {

        if(isDevelopment) {

            return "/Fonts/" + fileName;

        }else{

            return "/Fonts/" + fileName;

        }


    }
}