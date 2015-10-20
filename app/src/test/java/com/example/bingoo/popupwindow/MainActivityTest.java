package com.example.bingoo.popupwindow;


import android.content.Intent;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)

public class MainActivityTest {

    @Test
    public void testActivity(){

        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.button).performClick();

//        Intent expectedIntent = new Intent(activity, MainActivity.class);
//        assertThat(shadowOf(expectedIntent).getNextStartedActivity()).isEqualTo(expectedIntent);
//        Intent expectedIntent = new Intent(activity, MainActivity.class);
//        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        Assert.assertEquals(expectedIntent, actualIntent);
    }

}