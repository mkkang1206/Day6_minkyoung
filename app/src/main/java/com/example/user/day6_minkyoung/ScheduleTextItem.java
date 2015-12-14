package com.example.user.day6_minkyoung;


public class ScheduleTextItem {

    private String time;
    private String content;

    public ScheduleTextItem() {
    }

    public ScheduleTextItem(String inTime, String inContent) {
        time = inTime;
        content = inContent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
