package com.example.android.SEUNotify;

public class Messages {
    private String title;
    private String textMessage;
    private String photoUrl;

    public Messages() {
    }

    public Messages(String title, String textMessage, String photoUrl) {
        this.title = title;
        this.textMessage = textMessage;
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String text) {
        this.title = text;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String name) {
        this.textMessage = textMessage;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}

