package files;

import java.nio.file.Path;

public class SubFolderManager extends FileManager{

    private final Path subFolder;

    public SubFolderManager(String rootName, String projectName, String subFolderName) {

        super(rootName, projectName);


        this.subFolder = projectFolder.resolve(subFolderName);

        createSubFolder();
    }

    private void createSubFolder() {
        if (ensureFolderExists(subFolder)) {
            System.out.println("📂 Subcarpeta lista en: " + subFolder.toString());
        }
    }


    public Path getSubFolder() {
        return subFolder;
    }

}
