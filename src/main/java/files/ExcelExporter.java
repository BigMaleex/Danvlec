package files;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import files.CloudEntry;
import user.LocalEntry;
import user.UserData;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelExporter {

    private String[][] emotions = {

        // Felicidad (0–24)
        {"Feliz", "Feliz"},
        {"Alegre", "Alegre"},
        {"Interesada", "Interesado"},
        {"Orgullosa", "Orgulloso"},
        {"Aceptada", "Aceptado"},
        {"Poderosa", "Poderoso"},
        {"Pacífica", "Pacífico"},
        {"Íntima", "Íntimo"},
        {"Optimista", "Optimista"},
        {"Liberada", "Liberado"},
        {"Eufórica", "Eufórico"},
        {"Entretenida", "Entretenido"},
        {"Curiosa", "Curioso"},
        {"Reconocida", "Reconocido"},
        {"Segura", "Seguro"},
        {"Respetada", "Respetado"},
        {"Satisfecha", "Satisfecho"},
        {"Valiente", "Valiente"},
        {"Provocativa", "Provocativo"},
        {"Amorosa", "Amoroso"},
        {"Esperanzada", "Esperanzado"},
        {"Sensible", "Sensible"},
        {"Juguetona", "Juguetón"},
        {"Abierta", "Abierto"},
        {"Inspirada", "Inspirado"},

        // Sorpresa (25–37)
        {"Sorprendida", "Sorprendido"},
        {"Sobresaltada", "Sobresaltado"},
        {"Confundida", "Confundido"},
        {"Asombrada", "Asombrado"},
        {"Emocionada", "Emocionado"},
        {"Impactada", "Impactado"},
        {"Consternada", "Consternado"},
        {"Desilusionada", "Desilusionado"},
        {"Perpleja", "Perplejo"},
        {"Atónita", "Atónito"},
        {"Conmocionada", "Conmocionado"},
        {"Ansiosa (Sorpresa)", "Ansioso (Sorpresa)"},
        {"Enérgica", "Enérgico"},

        // Miedo (38–56)
        {"Miedosa", "Miedoso"},
        {"Humillada", "Humillado"},
        {"Rechazada", "Rechazado"},
        {"Sumisa", "Sumiso"},
        {"Insegura (Miedo)", "Inseguro (Miedo)"},
        {"Ansiosa (Miedo)", "Ansioso (Miedo)"},
        {"Asustada", "Asustado"},
        {"Ridiculizada", "Ridiculizado"},
        {"Despreciada (Miedo)", "Despreciado (Miedo)"},
        {"Alienada", "Alienado"},
        {"Inadecuada", "Inadecuado"},
        {"Insignificante", "Insignificante"},
        {"Inútil", "Inútil"},
        {"Inferior", "Inferior"},
        {"Deficiente", "Deficiente"},
        {"Preocupada", "Preocupado"},
        {"Abrumada", "Abrumado"},
        {"Temerosa", "Temeroso"},
        {"Aterrorizada", "Aterrorizado"},

        // Ira (57–80)
        {"Iracunda", "Iracundo"},
        {"Herida", "Herido"},
        {"Amenazada", "Amenazado"},
        {"Odiosa", "Odioso"},
        {"Enojada", "Enojado"},
        {"Agresiva", "Agresivo"},
        {"Frustrada", "Frustrado"},
        {"Distante", "Distante"},
        {"Crítica (Ira)", "Crítico (Ira)"},
        {"Avergonzada (Ira)", "Avergonzado (Ira)"},
        {"Devastada", "Devastado"},
        {"Insegura (Ira)", "Inseguro (Ira)"},
        {"Celosa", "Celoso"},
        {"Resentida", "Resentido"},
        {"Vulnerada", "Vulnerado"},
        {"Furiosa", "Furioso"},
        {"Encolerizada", "Encolerizado"},
        {"Provocada", "Provocado"},
        {"Hostil", "Hostil"},
        {"Enfurecida", "Enfurecido"},
        {"Retraída", "Retraído"},
        {"Desconfiada", "Desconfiado"},
        {"Escéptica", "Escéptico"},
        {"Sarcástica", "Sarcástico"},

        // Asco (81–93)
        {"Asqueada", "Asqueado"},
        {"Desaprobada", "Desaprobado"},
        {"Decepcionada", "Decepcionado"},
        {"Horrible", "Horrible"},
        {"Evasiva", "Evasivo"},
        {"Crítica (Asco)", "Crítico (Asco)"},
        {"Despreciada (Asco)", "Despreciado (Asco)"},
        {"Repugnante", "Repugnante"},
        {"Sublevada", "Sublevado"},
        {"Revulsiva", "Revulsivo"},
        {"Detestable", "Detestable"},
        {"Aversiva", "Aversivo"},
        {"Indecisa", "Indeciso"},

        // Tristeza (94–111)
        {"Triste", "Triste"},
        {"Culpable", "Culpable"},
        {"Abandonada", "Abandonado"},
        {"Desesperada", "Desesperado"},
        {"Deprimida", "Deprimido"},
        {"Solitario", "Solitario"},
        {"Aburrida", "Aburrido"},
        {"Arrepentida", "Arrepentido"},
        {"Avergonzada (Tristeza)", "Avergonzado (Tristeza)"},
        {"Ignorada", "Ignorado"},
        {"Victimizada", "Victimizado"},
        {"Indefensa", "Indefenso"},
        {"Vulnerable", "Vulnerable"},
        {"Introspectiva", "Introspectivo"},
        {"Vacía", "Vacío"},
        {"Aislada", "Aislado"},
        {"Apática", "Apático"},
        {"Indiferente", "Indiferente"}
    };

    private final String[] emotionIDs = {
        "Happy", "Joyful", "Interested", "Proud", "Accepted", "Powerful", "Peaceful",
        "Intimate", "Optimistic", "Free", "Euphoric", "Entertained", "Curious",
        "Recognized", "Secure", "Respected", "Satisfied", "Brave", "Provocative",
        "Loving", "Hopeful", "Sensitive", "Playful", "Open", "Inspired",
        "Surprised", "Startled", "Confused", "Amazed", "Excited", "Shocked",
        "Dismayed", "Disillusioned", "Perplexed", "Astonished", "Stunned",
        "AnxiousSurprise", "Energetic",
        "Fearful", "Humiliated", "Rejected", "Submissive", "InsecureFear",
        "AnxiousFear", "Scared", "Ridiculed", "Despised", "Alienated",
        "Inadequate", "Insignificant", "Useless", "Inferior", "Deficient",
        "Worried", "Overwhelmed", "Afraid", "Terrified",
        "Irate", "Hurt", "Threatened", "Hateful", "Angry", "Aggressive",
        "Frustrated", "Distant", "CriticalAnger", "AshamedAnger", "Devastated",
        "InsecureAnger", "Jealous", "Resentful", "Violated", "Furious",
        "Enraged", "Provoked", "Hostile", "Infuriated", "Withdrawn",
        "Distrustful", "Skeptical", "Sarcastic",
        "Disgusted", "Disapproving", "Disappointed", "Horrified", "Avoidant",
        "CriticalDisgust", "Contemptuous", "Repulsed", "Revolted", "Sickened",
        "Detestable", "Aversive", "Indecisive",
        "Sad", "Guilty", "Abandoned", "Desperate", "Depressed", "Lonely",
        "Bored", "Regretful", "AshamedSadness", "Ignored", "Victimized",
        "Helpless", "Vulnerable", "Introspective", "Empty", "Isolated",
        "Apathetic", "Indifferent"
    };

    private final Map<String, String> emotionsMale   = new HashMap<>();
    private final Map<String, String> emotionsFemale = new HashMap<>();

    // ← El mapa activo se elige una sola vez al construir el exportador
    private final Map<String, String> activeEmotions;

    {
        for (int i = 0; i < emotions.length; i++) {
            emotionsFemale.put(emotionIDs[i], emotions[i][0]);
            emotionsMale.put(emotionIDs[i],   emotions[i][1]);
        }
    }

    public ExcelExporter() {
        this.activeEmotions = (UserData.getSex() == UserData.Sex.MAN)
            ? emotionsMale
            : emotionsFemale;
    }

    // ── Constantes ────────────────────────────────────────────────────────────
    private static final String[] HEADERS = {
        "Fecha/Hora", "Contexto", "Sentimiento", "Emociones Sentidas",
        "Intensidad de las Emociones", "Estado General", "Notas Adicionales"
    };

    private static final DateTimeFormatter DATE_FMT =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // ── Selección de ruta ─────────────────────────────────────────────────────
    public static String selectOutputRoute(String defaultFileName) {
        Frame frame = new Frame();
        FileDialog dialog = new FileDialog(frame, "Guardar archivo", FileDialog.SAVE);
        dialog.setFile(defaultFileName + ".xlsx");
        dialog.setDirectory(System.getProperty("user.home"));
        dialog.setVisible(true);

        String file = dialog.getFile();
        String dir  = dialog.getDirectory();
        frame.dispose();

        if (file == null || dir == null) return null;

        if (!file.toLowerCase().endsWith(".xlsx")) {
            file += ".xlsx";
        }

        return new File(dir, file).getAbsolutePath();
    }

    // ── Modo LOCAL ────────────────────────────────────────────────────────────
    public void exportFromLocal(List<LocalEntry> entries) throws IOException {
        String path = selectOutputRoute("entradas_" + LocalDate.now());
        if (path == null) return;

        List<String[]> rows = new ArrayList<>();
        for (LocalEntry e : entries) {
            rows.add(new String[]{
                e.getDate().format(DATE_FMT),
                e.getContext(),
                e.getFeeling(),
                formatEmotions(e.getEmotions()),
                formatIntensities(e.getEmotions(), e.getScores()),
                mapGeneralState(e.getGeneralState()),
                e.getAdditionalNotes()
            });
        }

        writeExcel(rows, path);
    }

    // ── Modo NUBE ─────────────────────────────────────────────────────────────
    public void exportFromCloud(List<CloudEntry> entries) throws IOException {
        String path = selectOutputRoute("entradas_" + LocalDate.now());
        if (path == null) return;

        List<String[]> rows = new ArrayList<>();
        for (CloudEntry e : entries) {
            rows.add(new String[]{
                e.getDate().format(DATE_FMT),
                e.getContext(),
                e.getFeeling(),
                formatEmotions(e.getEmotions()),
                formatIntensities(e.getEmotions(), e.getScores()),
                mapGeneralState(e.getGeneralState()),
                e.getAdditionalNotes()
            });
        }

        writeExcel(rows, path);
    }

    // ── Motor de escritura ────────────────────────────────────────────────────
    private void writeExcel(List<String[]> rows, String outputPath) throws IOException {
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Entradas");

            CellStyle headerStyle = buildHeaderStyle(wb);
            CellStyle dataStyle   = buildDataStyle(wb);
            CellStyle wrapStyle   = buildWrapStyle(wb);

            int[] colWidths = {5000, 9000, 5000, 7000, 7000, 5000, 9000};
            for (int i = 0; i < colWidths.length; i++)
                sheet.setColumnWidth(i, colWidths[i]);

            Row header = sheet.createRow(0);
            header.setHeightInPoints(22);
            for (int i = 0; i < HEADERS.length; i++) {
                Cell c = header.createCell(i);
                c.setCellValue(HEADERS[i]);
                c.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (String[] data : rows) {
                Row row = sheet.createRow(rowNum++);
                row.setHeightInPoints(70);
                for (int i = 0; i < data.length; i++) {
                    Cell c = row.createCell(i);
                    c.setCellValue(data[i] != null ? data[i] : "");
                    c.setCellStyle((i == 3 || i == 4) ? wrapStyle : dataStyle);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                wb.write(fos);
            }

            System.out.println("✔ Excel exportado en: " + outputPath);
        }
    }

    // ── Estilos ───────────────────────────────────────────────────────────────
    private CellStyle buildHeaderStyle(Workbook wb) {
        Font f = wb.createFont();
        f.setBold(true);
        f.setFontName("Arial");
        f.setFontHeightInPoints((short) 11);
        f.setColor(IndexedColors.WHITE.getIndex());

        CellStyle s = wb.createCellStyle();
        s.setFont(f);
        s.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        s.setAlignment(HorizontalAlignment.CENTER);
        s.setVerticalAlignment(VerticalAlignment.CENTER);
        s.setBorderBottom(BorderStyle.THIN);
        s.setBorderRight(BorderStyle.THIN);
        return s;
    }

    private CellStyle buildDataStyle(Workbook wb) {
        Font f = wb.createFont();
        f.setFontName("Arial");
        f.setFontHeightInPoints((short) 10);

        CellStyle s = wb.createCellStyle();
        s.setFont(f);
        s.setVerticalAlignment(VerticalAlignment.TOP);
        s.setBorderBottom(BorderStyle.HAIR);
        s.setBorderRight(BorderStyle.HAIR);
        return s;
    }

    private CellStyle buildWrapStyle(Workbook wb) {
        CellStyle s = buildDataStyle(wb);
        s.setWrapText(true);
        return s;
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    /** Traduce IDs a nombres según el género del usuario, uno por línea */
    private String formatEmotions(String[] emotionIds) {
        if (emotionIds == null || emotionIds.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < emotionIds.length; i++) {
            // Si el ID no está en el mapa (dato inesperado) muestra el ID tal cual
            sb.append(activeEmotions.getOrDefault(emotionIds[i], emotionIds[i]));
            if (i < emotionIds.length - 1) sb.append("\n");
        }
        return sb.toString();
    }

    private String formatIntensities(String[] emotionIds, int[] scores) {
        if (emotionIds == null || scores == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < emotionIds.length; i++) {
            if (i < scores.length) {
                String label = activeEmotions.getOrDefault(emotionIds[i], emotionIds[i]);
                sb.append(label).append(": ").append(scores[i]).append("/10");
                if (i < emotionIds.length - 1) sb.append("\n");
            }
        }
        return sb.toString();
    }

    private String mapGeneralState(int state) {
        return switch (state) {
            case 1  -> "Extremadamente mal";
            case 2  -> "Muy mal";
            case 3  -> "Mal";
            case 4  -> "Algo mal";
            case 5  -> "Neutro";
            case 6  -> "Algo bien";
            case 7  -> "Bien";
            case 8  -> "Muy bien";
            case 9  -> "Excelente";
            case 10 -> "Extraordinario";
            default -> "Sin definir";
        };
    }
}