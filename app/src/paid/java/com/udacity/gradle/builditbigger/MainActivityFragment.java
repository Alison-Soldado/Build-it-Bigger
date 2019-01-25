package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylibrary.DisplayJokeActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private AppCompatButton buttonTellJokePaid;
    public String joke_loaded = "";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initComponent(view);
        actionButtonJoke();
        return view;
    }

    private void initComponent(View view) {
        buttonTellJokePaid = view.findViewById(R.id.fragment_main_tell_joke_button);
    }

    private void actionButtonJoke() {
        buttonTellJokePaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke();
            }
        });
    }

    public void getJoke() {
        new AsyncTaskEndpoint().execute(this);
    }

    public void launchDisplayJokeActivity() {
        Intent intent = new Intent(getContext(), DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_KEY, joke_loaded);
        startActivity(intent);
    }
}
