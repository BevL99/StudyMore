package com.example.studymore.ui.Activity;

public class Activity {
    private String activityName;
    private int imageDrawableId;

    public Activity(){

    }

    public Activity(String activityName, int imageDrawableId) {
        this.activityName = activityName;
        this.imageDrawableId = imageDrawableId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }
}
