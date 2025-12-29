package connections;

import controllers.PopupBDErrController;
import messagebuilder.MessageBuilder;
import utilities.FileConstants;
import utilities.ScreenManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataManager {

    private static ScreenManager sm = ScreenManager.getInstance();

    private static final String user = System.getenv("DanvlecBDUser");
    private static final String password = System.getenv("DanvlecBDPassword");
    private static final String port = "3306";
    private static String ip = "localhost";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String bd = "danvlec";
    private static String url = "jdbc:mysql://"+ip+":"+port+"/"+bd;

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

        System.out.println("[DataManager] Intentando cambiar IP. Nueva url = " + url);

        try {
            boolean ok = reloadConnection();
            if (ok) {
                System.out.println("[DataManager] Conexión exitosa a " + ip);

                return true;
            } else {
                System.out.println("[DataManager] reloadConnection devolvió false");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();

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
