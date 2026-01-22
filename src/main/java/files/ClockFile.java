package files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.UserClock;
import user.UserClockLS;
import utilities.FileConstants;
import utilities.ScreenManager;

import java.io.File;

public class ClockFile {

    private static final String fileName = "Clock";
    private final UserClockLS clock =  new UserClockLS();
    private final ScreenManager sm = ScreenManager.getInstance();
    private final Logger logger = LoggerFactory.getLogger(ClockFile.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    static {

        loadConfigurations();

    }

    private static void  loadConfigurations() {

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }

    public void createOrUpdateFile(){

        clock.copyAllData();

        try {

            mapper.writeValue(new File(FileManager.projectFolder.resolve(fileName + ".json").toString()), clock);

        }catch(Exception e){

            logger.error(e.getMessage());

        }

    }

    public void readFile(){

        if(FileManager.fileExists(FileManager.projectFolder, fileName, "json")){

            //El archivo existe
           try{

               mapper.readValue(new File(FileManager.projectFolder.resolve(fileName + ".json").toString()), UserClock.class);

               clock.loadAllData();

           }catch(Exception e){

               logger.error(e.getMessage());

           }

        }else{

          //El archivo no existe
            logger.error("El archivo no existe, ClockFile");
            sm.openDynamicPopup(FileConstants.PopupSetClockFXML, "Inicia tu objetivo", controller ->{});

        }

    }

}
