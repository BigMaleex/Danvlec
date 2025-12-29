package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    protected static Path rootFolder;
    protected static Path projectFolder;

    public FileManager(String rootName, String projectName) {
        String userHome = System.getProperty("user.home");
        rootFolder = Paths.get(userHome, rootName);
        projectFolder = rootFolder.resolve(projectName);
        ensureProjectFolderExists();
    }

    private static boolean ensureFolderExists(Path folder) {
        try {
            if (Files.exists(folder)) {
                System.out.printf("✔ La carpeta ya existía: %s%n", folder);
            } else {
                Files.createDirectories(folder);
                System.out.printf("✔ Carpeta creada en: %s%n", folder);
            }
            return true;
        } catch (IOException e) {
            System.err.printf("✘ Error al crear carpeta %s: %s%n", folder, e.getMessage());
            return false;
        }
    }

    protected static boolean ensureProjectFolderExists() {
        return ensureFolderExists(rootFolder) && ensureFolderExists(projectFolder);
    }

    protected static boolean fileExists(Path filePath, String fileName, String fileExtension) {

        try{

            Path fullPath = filePath.resolve(fileName + "." + fileExtension);
            return fullPath.toFile().exists();

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

    protected static void createFile(Path filePath, String fileName, String fileExtension) {

        Path fullPath = filePath.resolve(fileName + "." + fileExtension);

        File file = fullPath.toFile();

        try {

            file.createNewFile();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

    protected static void deleteFile(Path filePath, String fileName, String fileExtension) {

        Path fullPath = filePath.resolve(fileName + "." + fileExtension);

        File file = fullPath.toFile();

        try {

            file.delete();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

}