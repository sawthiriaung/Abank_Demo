package com.nmh.speaktotext.abank_demo.ui.splash;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.nmh.speaktotext.abank_demo.BR;
import com.nmh.speaktotext.abank_demo.ui.main.MainActivity;
import com.nmh.speaktotext.abank_demo.R;
import com.nmh.speaktotext.abank_demo.base.BaseActivity;
import com.nmh.speaktotext.abank_demo.databinding.ActivitySplashBinding;
import com.nmh.speaktotext.abank_demo.utils.ViewModelProviderFactory;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements
        SplashNavigator{

    Handler handler;
    @Inject
    ViewModelProviderFactory factory;
    private SplashViewModel mSplashViewModel;

    public static Intent newIntent(Context context){
        return new Intent(context, SplashActivity.class);
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this, factory).get(SplashViewModel.class);
        return mSplashViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);

        handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                mSplashViewModel.startSeeding();
                finish();
            }
        }, 5000);
    }

//    @Override
//    public void openLoginActivity() {
//        Intent intent = LoginActivity.newIntent(SplashActivity.this);
//        startActivity(intent);
//        finish();
//    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
        }


    }


