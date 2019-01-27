package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskEndpointTest {
    @Test
    public void testDoInBackground() throws Exception {
        MainActivityFragment fragment = new MainActivityFragment();
        new AsyncTaskEndpoint().execute(fragment);
        Thread.sleep(10000);
        assertNotNull("Error: Fetched Joke = " + fragment.joke_loaded, fragment.joke_loaded);
    }
}
