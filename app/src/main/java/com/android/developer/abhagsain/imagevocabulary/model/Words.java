package com.android.developer.abhagsain.imagevocabulary.model;

public class Words {
    private int imageID;
    private int nextImage;
    private boolean isLastImage = false;
    public Words(int imageID, int nextImage){
        this.imageID = imageID;
        this.nextImage = nextImage;
    }

    public Words(int imageID){
        this.imageID = imageID;
        isLastImage = true;
    }

    public boolean isLastImage() {
        return isLastImage;
    }

    public int getImageID() {
        return imageID;
    }

    public int getNextImage() {
        return nextImage;
    }
}
