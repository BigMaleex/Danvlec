package controls;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeMaskTextField extends TextField {

    private static final String MASK = "hh:mm AM";
    private static final DateTimeFormatter FORMAT_12H = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);

    public TimeMaskTextField() {
        // 1. Inicializar con la máscara
        setText(MASK);

        // 2. Listener de foco para posicionar el cursor al inicio
        focusedProperty().addListener((obs, wasFocused, isFocused) -> {
            if (isFocused && getText().equals(MASK)) {
                Platform.runLater(() -> positionCaret(0));
            }
        });

        // 3. Bloqueo de clics en posiciones inválidas (como el ":" o el espacio)
        setOnMouseClicked(e -> fixCaretPosition());

        // 4. Filtro principal de teclado
        addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            int pos = getCaretPosition();

            switch (e.getCode()) {
                case BACK_SPACE:
                    e.consume();
                    handleDelete(pos - 1);
                    break;
                case DELETE:
                    e.consume();
                    handleDelete(pos);
                    break;
                case LEFT:
                    e.consume();
                    moveLeft();
                    break;
                case RIGHT:
                    e.consume();
                    moveRight();
                    break;
                case SPACE:
                    e.consume();
                    toggleAmPm();
                    break;
            }
        });

        addEventFilter(KeyEvent.KEY_TYPED, e -> {
            e.consume();
            String input = e.getCharacter();
            if (input.isEmpty()) return;

            char c = input.charAt(0);
            int pos = getCaretPosition();

            if (Character.isDigit(c)) {
                handleDigit(c, pos);
            } else if (c == 'a' || c == 'A' || c == 'p' || c == 'P') {
                setAmPm(c == 'p' || c == 'P');
            }
        });
    }

    private void handleDigit(char c, int pos) {
        // Evitar escribir fuera de los rangos de hora y minuto
        if (pos == 2) pos = 3; // Saltar el ':'
        if (pos >= 5) return;  // No escribir números en AM/PM

        // Validaciones lógicas básicas
        if (pos == 0 && c > '1') return; // Primera cifra hora (0 o 1)
        if (pos == 3 && c > '5') return; // Primera cifra minutos (0 a 5)

        replaceAndAdvance(pos, c);
    }

    private void replaceAndAdvance(int pos, char c) {
        StringBuilder sb = new StringBuilder(getText());
        sb.setCharAt(pos, c);
        setText(sb.toString());

        // Calcular siguiente posición
        int next = pos + 1;
        if (next == 2) next = 3; // Saltar ':'
        if (next == 5) next = 6; // Saltar espacio hacia AM/PM

        if (next > 8) next = 8;
        positionCaret(next);
    }

    private void handleDelete(int pos) {
        if (pos < 0 || pos >= MASK.length()) return;

        // No borrar separadores fijos
        if (pos == 2 || pos == 5) {
            positionCaret(pos);
            return;
        }

        StringBuilder sb = new StringBuilder(getText());
        sb.setCharAt(pos, MASK.charAt(pos)); // Restaurar carácter de la máscara
        setText(sb.toString());
        positionCaret(pos);
    }

    private void moveLeft() {
        int pos = getCaretPosition();
        int next = pos - 1;
        if (next == 2) next = 1;
        if (next == 5) next = 4;
        if (next < 0) next = 0;
        positionCaret(next);
    }

    private void moveRight() {
        int pos = getCaretPosition();
        int next = pos + 1;
        if (next == 2) next = 3;
        if (next == 5) next = 6;
        if (next > 8) next = 8;
        positionCaret(next);
    }

    private void fixCaretPosition() {
        int pos = getCaretPosition();
        if (pos == 2) positionCaret(3);
        if (pos == 5) positionCaret(6);
    }

    private void setAmPm(boolean pm) {
        String current = getText();
        setText(current.substring(0, 6) + (pm ? "PM" : "AM"));
        positionCaret(6);
    }

    private void toggleAmPm() {
        boolean isPm = getText().endsWith("PM");
        setAmPm(!isPm);
    }

    // Evita que el usuario use el ratón para seleccionar y borrar el texto
    @Override
    public void replaceText(int start, int end, String text) {
        if (text.isEmpty() && start == 0 && end == getText().length()) {
            super.replaceText(0, end, MASK);
            positionCaret(0);
        } else {
            super.replaceText(start, end, text);
        }
    }

    /**
     * @return LocalTime si es válido, null si aún tiene 'h' o 'm'
     */
    public LocalTime getLocalTime() {
        String t = getText();
        if (t.contains("h") || t.contains("m")) return null;
        try {
            return LocalTime.parse(t, FORMAT_12H);
        } catch (Exception e) {
            return null;
        }
    }

    public void setLocalTime(LocalTime time) {
        if (time == null) setText(MASK);
        else setText(time.format(FORMAT_12H).toUpperCase());
    }

    @Override
    public void clear() {
        setText(MASK);
        Platform.runLater(() -> positionCaret(0));
    }

}