package com.example.android.retrofit.pojo;

public class Properties {

     public final String title;
     public final long time;
     public final int tsunami;

    public Properties(int alert, long time, String title) {
        this.tsunami = alert;
        this.time = time;
        this.title = title;
    }

    public int getTsunami() {
        return tsunami;
    }

    public long getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }
}
