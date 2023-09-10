package Models;

import java.util.Date;

public class Communication {
    private String caller;
    private String called;
    private Date timeStart;
    private Date timeEnd;
    private int duration; // en secondes
    private String type;

    // Constructeur
    public Communication(String caller, String called, Date timeStart, Date timeEnd, int duration, String type) {
        this.caller = caller;
        this.called = called;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.duration = duration;
        this.type = type;
    }

    // Getters et Setters
    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCalled() {
        return called;
    }

    public void setCalled(String called) {
        this.called = called;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
