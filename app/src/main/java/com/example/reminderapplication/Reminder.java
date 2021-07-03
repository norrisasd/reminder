package com.example.reminderapplication;

public class Reminder {
    private int id;
    private String date;
    private String time;
    private String description;

    public Reminder(int id,String date, String time, String description) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    @Override
    public String toString() {
        return
                " date='" + date + '\''+"\t" +
                " time='" + time + '\''+"\n"+
                " description='" + description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
