package com.anurag.android.story.model;

public class Page {
    private int textID;
    private int imageID;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinalPage;

    public Page(boolean isFinalPage) {
        this.isFinalPage = isFinalPage;
    }

    public boolean FinalOrNot(){

        return  this.isFinalPage;
    }

    public Page(int imageID, int textID) {
        this.textID = textID;
        this.imageID = imageID;
        this.isFinalPage = true;
    }

    public Page(int imageID, int textID,  Choice choice1, Choice choice2) {
        this.textID = textID;
        this.imageID = imageID;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public int getTextID() {
        return textID;
    }

    public void setTextID(int textID) {
        this.textID = textID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }
}
