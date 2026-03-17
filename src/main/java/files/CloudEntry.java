package files;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CloudEntry {

    private final String context;
    private final String feeling;
    private final String additionalNotes;
    private final String[] emotions;
    private final int[] scores;
    private final int generalState;
    private final LocalDateTime date;

    private CloudEntry(Builder b) {
        this.date            = b.date;
        this.context         = b.context;
        this.feeling         = b.feeling;
        this.additionalNotes = b.additionalNotes;
        this.generalState    = b.generalState;
        this.emotions        = b.emotions.toArray(new String[0]);
        this.scores          = b.scores.stream().mapToInt(Integer::intValue).toArray();
    }

    public LocalDateTime getDate()      { return date; }
    public String getContext()          { return context; }
    public String getFeeling()          { return feeling; }
    public String getAdditionalNotes()  { return additionalNotes; }
    public String[] getEmotions()       { return emotions; }
    public int[] getScores()            { return scores; }
    public int getGeneralState()        { return generalState; }

    // ── Builder ───────────────────────────────────────────────────────────────
    public static class Builder {

        private final LocalDateTime date;
        private final String context;
        private final String feeling;
        private final String additionalNotes;
        private final int generalState;
        private final List<String> emotions = new ArrayList<>();
        private final List<Integer> scores  = new ArrayList<>();

        public Builder(LocalDateTime date, String context, String feeling,
                       String additionalNotes, int generalState) {
            this.date            = date;
            this.context         = context;
            this.feeling         = feeling;
            this.additionalNotes = additionalNotes;
            this.generalState    = generalState;
        }

        public void addEmotion(String emotionID, int score) {
            emotions.add(emotionID);
            scores.add(score);
        }

        public CloudEntry build() {
            return new CloudEntry(this);
        }
    }
}