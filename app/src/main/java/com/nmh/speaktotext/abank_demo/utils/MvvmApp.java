package com.nmh.speaktotext.abank_demo.utils;

import android.app.Activity;
import android.app.Application;

import com.nmh.speaktotext.abank_demo.BuildConfig;
import com.nmh.speaktotext.abank_demo.di.component.DaggerAppComponent;

import java.security.AlgorithmParameterGenerator;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MvvmApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

//        AppLogger.init();
//
//        CalligraphyConfig.initDefault(mCalligraphyConfig);
    
    }
}
