package com.android.developer.abhagsain.imagevocabulary.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.developer.abhagsain.imagevocabulary.R;
import com.android.developer.abhagsain.imagevocabulary.model.ImageViews;
import com.android.developer.abhagsain.imagevocabulary.model.Words;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private ImageView m_image_view;
    private Button previous_button;
    private Button next_button;
    private ImageViews images = new ImageViews();
    Stack<Integer> previousPage = new Stack<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_image_view = (ImageView)findViewById(R.id.words_image);
        this.previous_button = (Button)findViewById(R.id.previous_button);
        this.next_button = (Button)findViewById(R.id.next_button);
        setImage(0);
    }

    private void setImage(int load_page) {
        previousPage.push(load_page);
        final Words word  = images.getImage(load_page);
        Drawable image = ContextCompat.getDrawable(this,word.getImageID());
        m_image_view.setImageDrawable(image);
        buttonClicking(word, load_page);
    }

    private void buttonClicking(final Words word, int loadPage) {
        if(word.isLastImage()){
            next_button.setBackgroundColor(getResources().getColor(R.color.disable_button));
            next_button.setEnabled(false);
        }else{
            next_button.setBackgroundColor(getResources().getColor(R.color.enable_button));
            next_button.setEnabled(true);
        }
        if (loadPage==0){
            previous_button.setBackgroundColor(getResources().getColor(R.color.disable_button));
            previous_button.setEnabled(false);
        }else{
            previous_button.setBackgroundColor(getResources().getColor(R.color.enable_button));
            previous_button.setEnabled(true);
        }
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = word.getNextImage();
                setImage(nextPage);
            }
        });

        previous_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                previousPage.pop();
                int previous_page = previousPage.pop();
                setImage(previous_page);
            }
        });
    }
}
