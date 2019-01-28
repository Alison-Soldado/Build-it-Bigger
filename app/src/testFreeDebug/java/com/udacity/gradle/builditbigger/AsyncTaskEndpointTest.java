package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskEndpointTest {
    @Test
    public void testDoInBackground() {
        MainActivityFragment fragment = new MainActivityFragment();
        new AsyncTaskEndpoint().execute(fragment);
        assertNotNull(fragment.joke_loaded);
    }
}
