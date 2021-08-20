package model;

import java.sql.Date;

public class LeetcodeSubscription {
    private final String leetcodeQuestionTag;
    private final String difficulty;
    private final String cadence;
    private Date lastSent;

    public LeetcodeSubscription(String leetcodeQuestionTag, String difficulty, String  cadence) {
            this.leetcodeQuestionTag = leetcodeQuestionTag;
            this.difficulty = difficulty;
            this.cadence = cadence;
            this.lastSent = null;
    }

    public void setLastSentDate(Date lastSent) {
        if(lastSent != null) {
            this.lastSent = lastSent;
        } else {
            throw new NullPointerException("Last sent date cannot be set to null.");
        }
    }

    public String getCadence(){

        return this.cadence;
    }

    public Date getLastSent(){
        return this.lastSent;
    }
}
