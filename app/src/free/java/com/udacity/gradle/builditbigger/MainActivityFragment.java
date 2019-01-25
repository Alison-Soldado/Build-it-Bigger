package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mylibrary.DisplayJokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import java.util.Objects;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    PublisherInterstitialAd mPublisherInterstitialAd = null;
    private AppCompatButton buttonTellJokeFree;
    private AdView adView;
    public String joke_loaded = "";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPublisherInterstitialAd = new PublisherInterstitialAd(Objects.requireNonNull(getContext()));
        mPublisherInterstitialAd.setAdUnitId(getString(R.string.id_block));

        mPublisherInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                tellJoke();

                requestNewInterstitial();
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                requestNewInterstitial();
            }
            @Override
            public void onAdLoaded() {

                super.onAdLoaded();
            }
        });

        requestNewInterstitial();

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initComponent(view);
        actionButtonJoke();
        loadAdRequest();
        return view;
    }

    private void initComponent(View view) {
        buttonTellJokeFree = view.findViewById(R.id.fragment_main_tell_joke_button);
        adView = view.findViewById(R.id.fragment_main_adView);
    }

    private void loadAdRequest() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
    }

    private void actionButtonJoke() {
        buttonTellJokeFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPublisherInterstitialAd.isLoaded()) {
                    mPublisherInterstitialAd.show();
                } else {
                    tellJoke();
                }
            }
        });
    }

    private void tellJoke(){
        new AsyncTaskEndpoint().execute(this);
    }

    public void launchDisplayJokeActivity(){
        Intent intent = new Intent(getContext(), DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_KEY, joke_loaded);
        startActivity(intent);
    }

    private void requestNewInterstitial() {
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mPublisherInterstitialAd.loadAd(adRequest);
    }
}
