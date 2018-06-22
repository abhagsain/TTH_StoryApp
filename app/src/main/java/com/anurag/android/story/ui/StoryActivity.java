package com.anurag.android.story.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anurag.android.story.R;
import com.anurag.android.story.model.Page;
import com.anurag.android.story.model.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {

    ImageView storyImageView;
    TextView storyTextView;
    Button choice1Button;
    Button choice2Button;
    Story story = new Story();
    String name;
    Stack<Integer> pageStack = new Stack<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = (ImageView)findViewById(R.id.storyImageView);
        storyTextView = (TextView)findViewById(R.id.storyTextView);
        choice1Button = (Button)findViewById(R.id.choiceButton1);
        choice2Button = (Button)findViewById(R.id.choiceButton2);
        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_value));
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        choice1Button.setVisibility(View.VISIBLE);
        choice2Button.setVisibility(View.VISIBLE);
        pageStack.push(pageNumber);
        final Page page = story.getPageNumber(pageNumber);

        Drawable drawable = ContextCompat.getDrawable(this,page.getImageID());
        storyImageView.setImageDrawable(drawable);
        String textDescription = getString(page.getTextID());
        textDescription = String.format(textDescription, name);
        storyTextView.setText(textDescription);
        if (page.FinalOrNot()){

            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setText(R.string.play_again);
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(0);
                }
            });

        }else{

            buttonLoad(page);
        }

    }

    private void buttonLoad(final Page page) {
        choice1Button.setText(page.getChoice1().getTextID());
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });
        choice2Button.setText(page.getChoice2().getTextID());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if(pageStack.isEmpty()){

            super.onBackPressed();
        }else{
            loadPage(pageStack.pop());

        }
    }
}
