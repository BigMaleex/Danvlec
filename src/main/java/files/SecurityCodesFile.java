package files;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import user.UserData;
import utilities.FileConstants;
import utilities.PathManager;

public class SecurityCodesFile {

    private static final String LOGO_PATH  = PathManager.getImagePath(FileConstants.faviconImage);
    private static final String FONT_PATH  = PathManager.getFontPath(FileConstants.oswaldSemiBold);

    public static String nombreUsuario;
    public static String apodoUsuario;
    public static String correoUsuario;

    public static String elegirRutaSalida(String defaultFileName) {
        Frame frame = new Frame();
        FileDialog dialog = new FileDialog(frame, "Guardar PDF", FileDialog.SAVE);
        dialog.setFile(defaultFileName + ".pdf");
        dialog.setDirectory(System.getProperty("user.home"));
        dialog.setVisible(true);
        String file = dialog.getFile();
        String dir = dialog.getDirectory();
        frame.dispose();
        if (file == null) return null;
        if (!file.toLowerCase().endsWith(".pdf")) {
            file += ".pdf";
        }
        // Usa la clase File para construir la ruta correcta:
        File salida = new File(dir, file);
        return salida.getAbsolutePath();
    }

    public boolean generarPdf(String[] codigos) throws IOException {
        String nombreCuenta = (apodoUsuario != null && !apodoUsuario.isEmpty()) ? apodoUsuario : nombreUsuario;
        String sanitized = nombreCuenta.replace(" ", "-");
        String defaultName = "Danvlec-BackupCodes-" + sanitized;
        String rutaSalida = elegirRutaSalida(defaultName);
        if (rutaSalida == null) {
            System.out.println("Guardado cancelado por el usuario.");
            return false;
        }
        generarPdfInterno(nombreCuenta, correoUsuario, rutaSalida, Arrays.asList(codigos));
        System.out.println("PDF generado correctamente en: " + rutaSalida);
        return true;
    }

    public void setData(){

        nombreUsuario = UserData.getName();
        apodoUsuario = UserData.getNickname();
        correoUsuario = UserData.getEmail();

    }

    private static void generarPdfInterno(String nombreCuenta, String correoElectronico, String rutaArchivoSalida, java.util.List<String> codigos) throws IOException {
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDImageXObject logo = null;
            try (InputStream is = SecurityCodesFile.class.getResourceAsStream(LOGO_PATH)) {
                if (is != null) logo = PDImageXObject.createFromByteArray(doc, is.readAllBytes(), "logo");
            }

            PDFont baseFont;
            try (InputStream fs = SecurityCodesFile.class.getResourceAsStream(FONT_PATH)) {
                if (fs != null) {
                    baseFont = PDType0Font.load(doc, fs);
                } else {
                    // Usa una fuente embebida como fallback
                    baseFont = PDType0Font.load(doc, SecurityCodesFile.class.getResourceAsStream("/fonts/arial.ttf"));
                }
            }

            float margin = 72f;
            float pageW = page.getMediaBox().getWidth();
            float pageH = page.getMediaBox().getHeight();
            float contentW = pageW - 2 * margin;
            float y = pageH - margin;

            float fontSize = 18f;
            float leading = fontSize * 1.5f;

            Color defaultColor = new Color(18, 18, 18);
            Color nameColor    = new Color(0x19, 0x2d, 0x91);
            Color emailColor   = new Color(0x4d, 0xc0, 0xd4);
            Color warningColor = new Color(0xFF, 0xCC, 0x00);

            String info = "Códigos de seguridad para la cuenta de " + nombreCuenta + " con el correo: " + correoElectronico;
            java.util.List<String> infoLines = wrapText(info, baseFont, fontSize, contentW);
            String[] nameWords = nombreCuenta.split("\\s+");

            try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {

                if (logo != null) {
                    float lw = 80f;
                    float lh = lw / logo.getWidth() * logo.getHeight();
                    float lx = (pageW - lw) / 2;
                    cs.drawImage(logo, lx, y - lh, lw, lh);
                    y -= lh + leading;
                }

                for (int i = 0; i < infoLines.size(); i++) {
                    String ln = infoLines.get(i);
                    String[] words = ln.split("\\s+");
                    boolean lastLine = (i == infoLines.size() - 1);

                    float textWidth = baseFont.getStringWidth(ln) / 1000 * fontSize;
                    float spaceWidth = baseFont.getStringWidth(" ") / 1000 * fontSize;
                    float extraSpace = (!lastLine && words.length > 1)
                            ? (contentW - textWidth) / (words.length - 1)
                            : 0;

                    float x = margin;
                    float wordX = x;

                    for (int j = 0; j < words.length; j++) {
                        String w = words[j];

                        float wordWidth = baseFont.getStringWidth(w) / 1000 * fontSize;
                        Color color = defaultColor;
                        if (Arrays.asList(nameWords).contains(w)) color = nameColor;
                        else if (w.equals(correoElectronico)) color = emailColor;

                        cs.beginText();
                        cs.setFont(baseFont, fontSize);
                        cs.setNonStrokingColor(color);
                        cs.newLineAtOffset(wordX, y);
                        cs.showText(w);
                        cs.endText();

                        wordX += wordWidth + (lastLine ? spaceWidth : spaceWidth + extraSpace);
                    }

                    y -= leading;
                }

                y -= leading;
                for (String code : codigos) {
                    float w = baseFont.getStringWidth(code) / 1000 * fontSize;
                    float x = margin + (contentW - w) / 2;
                    cs.beginText();
                    cs.setFont(baseFont, fontSize);
                    cs.setNonStrokingColor(defaultColor);
                    cs.newLineAtOffset(x, y);
                    cs.showText(code);
                    cs.endText();
                    y -= leading;
                }

                y -= leading / 2;
                String warn = "¡No compartas estos códigos con nadie!";
                float ww = baseFont.getStringWidth(warn) / 1000 * fontSize;
                float wx = margin + (contentW - ww) / 2;
                cs.beginText();
                cs.setFont(baseFont, fontSize);
                cs.setNonStrokingColor(warningColor);
                cs.newLineAtOffset(wx, y);
                cs.showText(warn);
                cs.endText();
            }

            doc.save(rutaArchivoSalida);
        }
    }

    private static java.util.List<String> wrapText(String text, PDFont font, float fontSize, float maxWidth) throws IOException {
        List<String> lines = new ArrayList<>();
        String[] words = text.split("\\s+");
        StringBuilder line = new StringBuilder();
        for (String w : words) {
            float wordWidth = font.getStringWidth(w) / 1000 * fontSize;
            if (wordWidth > maxWidth) {
                StringBuilder part = new StringBuilder();
                for (char c : w.toCharArray()) {
                    part.append(c);
                    float pw = font.getStringWidth(part.toString()) / 1000 * fontSize;
                    if (pw > maxWidth) {
                        part.deleteCharAt(part.length() - 1);
                        if (line.length() > 0) {
                            lines.add(line.toString());
                            line.setLength(0);
                        }
                        lines.add(part.toString());
                        part = new StringBuilder(String.valueOf(c));
                    }
                }
                if (part.length() > 0) {
                    if (line.length() == 0) line.append(part);
                    else {
                        String trial = line + " " + part;
                        float tw = font.getStringWidth(trial) / 1000 * fontSize;
                        if (tw > maxWidth) {
                            lines.add(line.toString());
                            line.setLength(0);
                            line.append(part);
                        } else {
                            line.append(" ").append(part);
                        }
                    }
                }
            } else {
                String trial = (line.length() == 0) ? w : line + " " + w;
                float tw = font.getStringWidth(trial) / 1000 * fontSize;
                if (tw > maxWidth) {
                    lines.add(line.toString());
                    line = new StringBuilder(w);
                } else {
                    line = new StringBuilder(trial);
                }
            }
        }
        if (line.length() > 0) lines.add(line.toString());
        return lines;
    }

}
