package messagebuilder;

import utilities.FileConstants;

import java.awt.*;

public class Notifications {

    public static void showNotification(String title, String message) {
        if (SystemTray.isSupported()) {
            try {
                SystemTray tray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().createImage(FileConstants.faviconImage);
                TrayIcon trayIcon = new TrayIcon(image, "JavaFX App");
                trayIcon.setImageAutoSize(true);
                trayIcon.setToolTip("Notificación");
                tray.add(trayIcon);
                trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
