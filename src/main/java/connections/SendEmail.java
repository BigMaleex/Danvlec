package connections;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.mail.util.ByteArrayDataSource;
import utilities.PathManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

public class SendEmail {

    private final Session session;
    private final String fromAddress;

    public SendEmail(String username, String appPassword) {
        this.fromAddress = username;
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        this.session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, appPassword);
            }
        });
    }

    private String loadTemplate(String fileName) throws IOException {
        String resourcePath = PathManager.getHTMLPath(fileName); // Ej: "/HTML/EmailTemplate.html"
        try (InputStream in = getClass().getResourceAsStream(resourcePath)) {
            if (in == null) {

                String actualPathAttempted = getClass().getResource("").getPath() + resourcePath.substring(1); // Intenta mostrar una ruta más absoluta para depuración
                throw new IOException("No se encontró el recurso en classpath: " + resourcePath +
                        ". Asegúrate que 'resources' es una carpeta fuente y está en el classpath." +
                        " Intento de ruta: " + actualPathAttempted);
            }
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }


    private String fillTemplate(String template, Map<String, String> placeholders) {
        String filled = template;
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            filled = filled.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        return filled;
    }

    public void sendTemplateEmail(String to, String subject, String templatePath, Map<String, String> placeholders) throws MessagingException, IOException {

        String rawTemplate = loadTemplate(templatePath);


        String htmlContent = fillTemplate(rawTemplate, placeholders);


        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromAddress));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject, "UTF-8");


        MimeMultipart multipart = new MimeMultipart("related");


        MimeBodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent(htmlContent, "text/html; charset=UTF-8");
        multipart.addBodyPart(htmlBodyPart);


        MimeBodyPart imageBodyPart = new MimeBodyPart();
        String imageResourcePath = PathManager.getImagePath("danvlec-icon-150-x-150.png");

        try (InputStream imageStream = getClass().getResourceAsStream(imageResourcePath)) {
            if (imageStream == null) {
                throw new IOException("No se pudo encontrar la imagen del logo en classpath: " + imageResourcePath +
                        ". Verifica que la ruta es correcta y el archivo existe en 'resources/Images/'.");
            }

            DataSource fds = new ByteArrayDataSource(imageStream, "image/png");
            imageBodyPart.setDataHandler(new DataHandler(fds));

            imageBodyPart.setHeader("Content-ID", "<logoImage>");
            imageBodyPart.setDisposition(MimeBodyPart.INLINE);

            multipart.addBodyPart(imageBodyPart);
        }

        message.setContent(multipart);


        Transport.send(message);
        System.out.println("Correo con plantilla enviado a " + to);
    }

}
