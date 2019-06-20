package com.nmh.speaktotext.abank_demo.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.nmh.speaktotext.abank_demo.R;
import com.nmh.speaktotext.abank_demo.ui.main.adapter.SliderAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    ViewPager viewPager;
    SliderAdapter adapter;
    TabLayout indicator;

    List<Integer> color;
    List<String> colorName;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);

        viewPager = findViewById(R.id.viewPager);
        indicator= findViewById (R.id.indicator);

        color = new ArrayList<>();
        color.add(1000000000);
        color.add(2000000000);
        color.add(300000000);

        colorName = new ArrayList<>();
        colorName.add("Saving Balance");
        colorName.add("Current Balance");
        colorName.add("Total Balance");

        viewPager.setAdapter(new SliderAdapter(this, color, colorName));
        indicator.setupWithViewPager(viewPager, true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < colorName.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }

    }
}
