package controls;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * TextField con máscara permanente "dd/mm/yyyy".
 * Los caracteres se sobrescriben al escribir y se restauran al borrar.
 */
public class DateMaskTextField extends TextField {

    private static final String MASK = "dd/mm/yyyy";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DateMaskTextField() {
        // Inicializar con la máscara
        setText(MASK);

        // Listener de foco para posicionar el cursor al inicio
        focusedProperty().addListener((obs, wasFocused, isFocused) -> {
            if (isFocused && getText().equals(MASK)) {
                Platform.runLater(() -> positionCaret(0));
            }
        });

        // Forzar posición válida al hacer click
        setOnMouseClicked(e -> fixCaretPosition());

        // Filtro de teclas de control (Flechas, Borrar)
        addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            int pos = getCaretPosition();
            switch (e.getCode()) {
                case BACK_SPACE -> {
                    e.consume();
                    handleDelete(pos - 1);
                }
                case DELETE -> {
                    e.consume();
                    handleDelete(pos);
                }
                case LEFT -> {
                    e.consume();
                    moveLeft();
                }
                case RIGHT -> {
                    e.consume();
                    moveRight();
                }
                case V -> {
                    if (e.isControlDown()) {
                        e.consume();
                        pasteFromClipboard();
                    }
                }
            }
        });

        // Filtro de escritura (solo números)
        addEventFilter(KeyEvent.KEY_TYPED, e -> {
            e.consume();
            String input = e.getCharacter();
            if (input.isEmpty() || !Character.isDigit(input.charAt(0))) return;

            handleDigit(input.charAt(0), getCaretPosition());
        });
    }

    /* ================= Lógica de Edición ================= */

    private void handleDigit(char c, int pos) {
        // Saltar los separadores '/'
        if (pos == 2 || pos == 5) pos++;

        // Si estamos fuera de rango, no hacer nada
        if (pos >= MASK.length()) return;

        replaceAndAdvance(pos, c);
    }

    private void replaceAndAdvance(int pos, char c) {
        StringBuilder sb = new StringBuilder(getText());
        sb.setCharAt(pos, c);
        setText(sb.toString());

        // Calcular siguiente posición saltando '/'
        int next = pos + 1;
        if (next == 2 || next == 5) next++;

        if (next > MASK.length()) next = MASK.length();
        positionCaret(next);
    }

    private void handleDelete(int pos) {
        if (pos < 0 || pos >= MASK.length()) return;

        // No permitir borrar los '/'
        if (pos == 2 || pos == 5) {
            positionCaret(pos);
            return;
        }

        StringBuilder sb = new StringBuilder(getText());
        sb.setCharAt(pos, MASK.charAt(pos)); // Restaurar 'd', 'm' o 'y'
        setText(sb.toString());
        positionCaret(pos);
    }

    /* ================= Navegación ================= */

    private void moveLeft() {
        int pos = getCaretPosition();
        int next = pos - 1;
        if (next == 2 || next == 5) next--;
        if (next < 0) next = 0;
        positionCaret(next);
    }

    private void moveRight() {
        int pos = getCaretPosition();
        int next = pos + 1;
        if (next == 2 || next == 5) next++;
        if (next > MASK.length()) next = MASK.length();
        positionCaret(next);
    }

    private void fixCaretPosition() {
        int pos = getCaretPosition();
        if (pos == 2) positionCaret(3);
        if (pos == 5) positionCaret(6);
    }

    /* ================= API ================= */

    /**
     * Devuelve el objeto LocalDate.
     * LocalDate.toString() devuelve por defecto el formato ISO-8601 (yyyy-MM-dd).
     */
    public LocalDate getLocalDate() {
        String t = getText();
        // Si contiene letras de la máscara, está incompleto
        if (t.matches(".*[dmy].*")) return null;

        try {
            return LocalDate.parse(t, FORMATTER);
        } catch (Exception e) {
            return null; // Fecha inválida (ej: 31/02/2024)
        }
    }

    /**
     * Establece la fecha desde un objeto LocalDate al formato visual dd/mm/yyyy
     */
    public void setLocalDate(LocalDate date) {
        if (date == null) {
            setText(MASK);
        } else {
            setText(date.format(FORMATTER));
        }
    }

    @Override
    public void replaceText(int start, int end, String text) {
        // Bloquear borrado masivo
        if (text.isEmpty() && start == 0 && end == getText().length()) {
            super.replaceText(0, end, MASK);
            positionCaret(0);
        } else {
            super.replaceText(start, end, text);
        }
    }

    private void pasteFromClipboard() {
        Clipboard cb = Clipboard.getSystemClipboard();
        if (cb.hasString()) {
            String s = cb.getString().trim();
            // Intenta parsear yyyy-MM-dd o dd/MM/yyyy
            try {
                LocalDate date;
                if (s.contains("-")) date = LocalDate.parse(s);
                else date = LocalDate.parse(s, FORMATTER);
                setLocalDate(date);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void clear() {
        setText(MASK);
        Platform.runLater(() -> positionCaret(0));
    }

}