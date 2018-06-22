package com.anurag.android.story.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.anurag.android.story.R;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn_main_page);
        edit_text = (EditText)findViewById(R.id.et_main);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = null;
                name = edit_text.getText().toString();
                open_new_activity(name);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        edit_text.setText("");
    }

    protected void open_new_activity(String name) {
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_value), name);
        startActivity(intent);
    }
}
