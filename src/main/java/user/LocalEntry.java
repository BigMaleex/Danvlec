package user;

import java.time.LocalDateTime;

public class LocalEntry {

    private String context;
    private String feeling;
    private String additionalNotes;
    private String [] emotions;
    private int [] scores;
    private int generalState;
    private LocalDateTime date;

    public LocalEntry(String newContext, String newFeeling, String newAdditionalNotes, String [] newEmotions, int [] newScores, int newGeneralState){

        this.context = newContext;
        this.feeling = newFeeling;
        this.additionalNotes = newAdditionalNotes;
        this.emotions = newEmotions;
        this.scores = newScores;
        this.generalState = newGeneralState;
        this.date = LocalDateTime.now();

    }

    public LocalDateTime getDate(){

        return this.date;

    }

    public String getContext() {
        return context;
    }

    public String getFeeling() {
        return feeling;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public String[] getEmotions() {
        return emotions;
    }

    public int[] getScores() {
        return scores;
    }

    public int getGeneralState() {
        return generalState;
    }
}
