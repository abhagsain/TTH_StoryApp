package com.android.developer.abhagsain.imagevocabulary.model;

import com.android.developer.abhagsain.imagevocabulary.R;

public class ImageViews {

    Words[] words = new Words[9];

    public ImageViews(){
        words [0] = new Words(R.drawable.image_0,1);
        words [1] = new Words(R.drawable.image_2,2);
        words [2] = new Words(R.drawable.image_3,3);
        words [3] = new Words(R.drawable.image_4,4);
        words [4] = new Words(R.drawable.image_5,5);
        words [5] = new Words(R.drawable.image_6,6);
        words [6] = new Words(R.drawable.image_7,7);
        words [7] = new Words(R.drawable.image_8,8);
        words [8] = new Words(R.drawable.image_9);

    }

    public Words getImage(int imageNumber){

        return words[imageNumber];
    }
}
