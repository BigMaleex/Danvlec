package controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import user.UserData;
import java.util.ArrayList;

public class EmotionalButtons {

    private String[] emotionsEN = {

    // Happiness (0–24)
    "Happy",
    "Joyful",
    "Interested",
    "Proud",
    "Accepted",
    "Powerful",
    "Peaceful",
    "Intimate",
    "Optimistic",
    "Free",
    "Euphoric",
    "Entertained",
    "Curious",
    "Recognized",
    "Secure",
    "Respected",
    "Satisfied",
    "Brave",
    "Provocative",
    "Loving",
    "Hopeful",
    "Sensitive",
    "Playful",
    "Open",
    "Inspired",

    // Surprise (25–37)
    "Surprised",
    "Startled",
    "Confused",
    "Amazed",
    "Excited",
    "Shocked",
    "Dismayed",
    "Disillusioned",
    "Perplexed",
    "Astonished",
    "Stunned",
    "Anxious",
    "Energetic",

    // Fear (38–56)
    "Fearful",
    "Humiliated",
    "Rejected",
    "Submissive",
    "Insecure",
    "Anxious",
    "Scared",
    "Ridiculed",
    "Despised",
    "Alienated",
    "Inadequate",
    "Insignificant",
    "Useless",
    "Inferior",
    "Deficient",
    "Worried",
    "Overwhelmed",
    "Afraid",
    "Terrified",

    // Anger (57–80)
    "Irate",
    "Hurt",
    "Threatened",
    "Hateful",
    "Angry",
    "Aggressive",
    "Frustrated",
    "Distant",
    "Critical",
    "Ashamed",
    "Devastated",
    "Insecure",
    "Jealous",
    "Resentful",
    "Violated",
    "Furious",
    "Enraged",
    "Provoked",
    "Hostile",
    "Infuriated",
    "Withdrawn",
    "Distrustful",
    "Skeptical",
    "Sarcastic",

    // Disgust (81–93)
    "Disgusted",
    "Disapproving",
    "Disappointed",
    "Horrified",
    "Avoidant",
    "Critical",
    "Contemptuous",
    "Repulsed",
    "Revolted",
    "Sickened",
    "Detestable",
    "Aversive",
    "Indecisive",

    // Sadness (94–111)
    "Sad",
    "Guilty",
    "Abandoned",
    "Desperate",
    "Depressed",
    "Lonely",
    "Bored",
    "Regretful",
    "Ashamed",
    "Ignored",
    "Victimized",
    "Helpless",
    "Vulnerable",
    "Introspective",
    "Empty",
    "Isolated",
    "Apathetic",
    "Indifferent"
};

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
    {"Ansiosa", "Ansioso"},
    {"Enérgica", "Enérgico"},

    // Miedo (38–56)
    {"Miedosa", "Miedoso"},
    {"Humillada", "Humillado"},
    {"Rechazada", "Rechazado"},
    {"Sumisa", "Sumiso"},
    {"Insegura", "Inseguro"},
    {"Ansiosa", "Ansioso"},
    {"Asustada", "Asustado"},
    {"Ridiculizada", "Ridiculizado"},
    {"Despreciada", "Despreciado"},
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
    {"Crítica", "Crítico"},
    {"Avergonzada", "Avergonzado"},
    {"Devastada", "Devastado"},
    {"Insegura", "Inseguro"},
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
    {"Crítica", "Crítico"},
    {"Despreciada", "Despreciado"},
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
    {"Avergonzada", "Avergonzado"},
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

   public Node[] getToggleButtons(){

        ArrayList<ToggleButton> buttons = new ArrayList<ToggleButton>();
        ArrayList<Label> labels = new ArrayList<Label>();
        ArrayList<ImageView> images = new ArrayList<ImageView>();

        int sex = UserData.getSex() == UserData.Sex.MAN ? 1 : 0;

        for(int i = 0; i < emotions.length; i++){

            HBox hbox = new HBox();

            hbox.setAlignment(Pos.CENTER);

            hbox.setSpacing(10);

            Label label = new Label(emotions[i][sex]);

            ImageView image = new ImageView();

            hbox.getChildren().addAll(label, image);

            ToggleButton button = new ToggleButton();
            button.setText(null);

            button.setPadding(new Insets(5));

            button.setGraphic(hbox);

            buttons.add(button);
            labels.add(label);
            images.add(image);

        }

        ArrayList <Node> all = new ArrayList<Node>();

        all.addAll(buttons);
        all.addAll(labels);
        all.addAll(images);

        return all.toArray(new Node [all.size()]);

   }

}
