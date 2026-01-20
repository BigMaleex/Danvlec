package connections;

import controllers.PopupBDErrController;
import messagebuilder.MessageBuilder;
import utilities.FileConstants;
import utilities.ScreenManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataManager {

    private static final Logger logger = LoggerFactory.getLogger(DataManager.class);

    private static ScreenManager sm = ScreenManager.getInstance();

    private static final String user = System.getenv("DanvlecBDUser");
    private static final String password = System.getenv("DanvlecBDPassword");

    private static String port;
    private static String ip;
    private static String driver;
    private static String bd;
    private static String url;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        Properties props = new Properties();
        try (InputStream is = DataManager.class.getResourceAsStream("/database.properties")) {
            if (is != null) {
                props.load(is);
                ip = props.getProperty("db.ip", "localhost");
                port = props.getProperty("db.port", "3306");
                bd = props.getProperty("db.name", "danvlec");
                driver = props.getProperty("db.driver", "com.mysql.cj.jdbc.Driver");
            } else {
                logger.warn("No se encontró database.properties, usando valores por defecto.");
                ip = "localhost";
                port = "3306";
                bd = "danvlec";
                driver = "com.mysql.cj.jdbc.Driver";
            }
            url = "jdbc:mysql://" + ip + ":" + port + "/" + bd;
        } catch (IOException e) {
            logger.error("Error al cargar database.properties", e);
        }
    }

    static Connection conexion;

    private static Connection connect() throws SQLException, ClassNotFoundException{

        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);

    }

    protected static Connection validateConnection() throws SQLException{

        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = connect();
            }
        } catch (ClassNotFoundException e) {
            throw new SQLException("Controlador de BD no encontrado", e);
        }
        return conexion;

    }

    public static boolean reloadConnection () throws SQLException{

        try {

            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }

            conexion = connect();

            return conexion != null && !conexion.isClosed();

        } catch (ClassNotFoundException e) {
            throw new SQLException("Controlador de BD no encontrado", e);
        }

    }

    public static boolean changeIP(String newIP){
        ip = newIP;
        url = "jdbc:mysql://"+ip+":"+port+"/"+bd;

        logger.info("Intentando cambiar IP. Nueva url = {}", url);

        try {
            boolean ok = reloadConnection();
            if (ok) {
                logger.info("Conexión exitosa a {}", ip);

                return true;
            } else {
                logger.warn("reloadConnection devolvió false");
                return false;
            }
        } catch (Exception e) {
            logger.error("Error al cambiar IP", e);

            showError(e.toString());

            return false;
        }
    }

    protected static void showError(String error){

        sm.openDynamicPopup(FileConstants.PopupBDErrFXML,"", controller->{
            PopupBDErrController alertController = (PopupBDErrController) controller;
            alertController.initialize();
            alertController.setError(error);
        });

    }

}
