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

    List<Integer> accountNo;
    List<String> accountName;
    List<Integer> amount;
    List<String> amountName;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        floatingActionButton = findViewById(R.id.floatingActionButton);

        viewPager = findViewById(R.id.viewPager);
        indicator= findViewById (R.id.indicator);

        accountNo = new ArrayList<>();
        accountNo.add(000011112222333);
        accountNo.add(000000000000000);
        accountNo.add(000011112222200);


        accountName = new ArrayList<>();
        accountName.add("Saving Account");
        accountName.add("Current Account");
        accountName.add("ATM Account");

        amount = new ArrayList<>();
        amount.add(1000000000);
        amount.add(2000000000);
        amount.add(1200000000);

        amountName = new ArrayList<>();
        accountName.add("Total Amount");
        accountName.add("Current Amount");
        accountName.add("ATM Amount");

        viewPager.setAdapter(new SliderAdapter(this, accountNo, accountName, amount, amountName));
        indicator.setupWithViewPager(viewPager, true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 4000);
    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < amountName.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }

    }
}
