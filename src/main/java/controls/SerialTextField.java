package  controls;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.util.function.UnaryOperator;

public class SerialTextField extends TextField {
    private int maxCaracteresReales;

    public SerialTextField() {
        this(24);
    }

    public SerialTextField(int maxCaracteres) {
        this.maxCaracteresReales = maxCaracteres;
        initFormatter();
    }

    private void initFormatter() {
        // El filtro se ejecuta CADA VEZ que el usuario teclea, pega o borra algo
        UnaryOperator<TextFormatter.Change> filter = change -> {

            // 1. Obtener el texto original antes del cambio
            String oldText = change.getControlText();

            // 2. Obtener el texto completo "propuesto" (cómo quedaría si dejamos pasar el cambio tal cual)
            String newText = change.getControlNewText();

            // 3. LIMPIEZA: Quitar espacios (requisito) y guiones existentes para procesar "en crudo"
            String rawText = newText.replaceAll("[ -]", ""); // Elimina espacios y guiones

            // 4. VALIDACIÓN DE LÍMITE:
            if (rawText.length() > maxCaracteresReales) {
                // Si se pasa del límite, intentamos recortar (útil si pegan un texto muy largo)
                rawText = rawText.substring(0, maxCaracteresReales);
            }

            // 5. RECONSTRUCCIÓN CON FORMATO:
            StringBuilder formattedText = new StringBuilder();
            for (int i = 0; i < rawText.length(); i++) {
                if (i > 0 && i % 4 == 0) {
                    formattedText.append("-");
                }
                formattedText.append(rawText.charAt(i));
            }

            // 6. TRUCO DE JAVA FX:
            // En lugar de aplicar el cambio pequeño, reemplazamos TODO el texto del control
            // con nuestro texto formateado. Esto asegura consistencia total.

            // Configurar el cambio para reemplazar desde el inicio (0) hasta el final del texto antiguo
            change.setRange(0, oldText.length());
            change.setText(formattedText.toString());

            // 7. CÁLCULO DEL CURSOR (Lo más difícil):
            // Si reemplazamos todo el texto, el cursor se pierde. Hay que recalcular dónde debe caer.
            // Lógica: Contamos cuántos caracteres "reales" (no guiones) había antes del cursor en el "newText",
            // y buscamos esa misma posición en el "formattedText".

            int caretPosOriginal = change.getCaretPosition(); // Dónde quiere estar el cursor en el newText
            int anchorPosOriginal = change.getAnchor();

            int realCharsBeforeCaret = 0;
            // Recorremos el newText (con el cambio sucio) hasta la posición del cursor
            // para saber cuántas letras/números reales hemos pasado.
            String textUpToCaret = newText.substring(0, Math.min(newText.length(), caretPosOriginal));
            for (char c : textUpToCaret.toCharArray()) {
                if (c != '-' && c != ' ') {
                    realCharsBeforeCaret++;
                }
            }

            // Ahora encontramos el índice en el texto formateado que corresponde a esos caracteres reales
            int newCaretPos = 0;
            int realCharsFound = 0;
            String finalStr = formattedText.toString();

            for (int i = 0; i < finalStr.length(); i++) {
                if (finalStr.charAt(i) != '-') {
                    realCharsFound++;
                }
                newCaretPos++;
                if (realCharsFound == realCharsBeforeCaret) {
                    break;
                }
            }

            // Ajustar selector y cursor
            change.selectRange(newCaretPos, newCaretPos);

            return change;
        };

        // Aplicamos el formateador. Usamos un Converter por defecto.
        this.setTextFormatter(new TextFormatter<>(filter));
    }

    // Método para cambiar el límite dinámicamente si lo necesitas
    public void setMaxCaracteresReales(int max) {
        this.maxCaracteresReales = max;
        // Opcional: Podrías forzar un re-formateo aquí si el texto actual ya excede el nuevo límite
        this.setText(this.getText());
    }

    // Método útil para obtener el texto limpio sin guiones
    public String getRawText() {
        return this.getText().replaceAll("-", "");
    }
}
