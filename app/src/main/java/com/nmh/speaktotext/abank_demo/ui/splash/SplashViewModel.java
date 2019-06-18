package com.nmh.speaktotext.abank_demo.ui.splash;

import android.content.Intent;
import android.os.Handler;

import com.nmh.speaktotext.abank_demo.base.BaseViewModel;
import com.nmh.speaktotext.abank_demo.ui.main.MainActivity;

public class SplashViewModel  extends BaseViewModel<SplashNavigator> {

    public  SplashViewModel(){}

    public void startSeeding() {
        getNavigator().openMainActivity();
    }
}
