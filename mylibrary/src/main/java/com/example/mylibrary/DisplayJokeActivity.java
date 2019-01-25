package com.example.mylibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "JOKE_KEY";
    private AppCompatTextView textViewText;
    private String joke;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        initComponent();
        initIntent();
        fillComponent();
    }

    private void initComponent() {
        textViewText = findViewById(R.id.activity_display_joke_text);
    }

    private void initIntent() {
        joke = getIntent().getStringExtra(DisplayJokeActivity.JOKE_KEY);
    }

    private void fillComponent() {
        textViewText.setText(joke);
    }
}
