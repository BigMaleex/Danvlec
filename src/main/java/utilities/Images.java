package utilities;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Images {

    private static Map<String, Image> images = new ConcurrentHashMap<>();

    public static Image getImage(String image) {

        return images.computeIfAbsent(image, key ->{

            InputStream is = Images.class.getResourceAsStream(PathManager.getImagePath(key));

            if(is == null){

                throw new IllegalArgumentException("Imagen no encontrada: " + key);

            }

            return new Image(is);

        });

    }

    public static void clearImages(){

        images.clear();

    }

}
