package com.nmh.speaktotext.abank_demo.di.builder;

import com.nmh.speaktotext.abank_demo.ui.splash.SplashActivity;
import com.nmh.speaktotext.abank_demo.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindLoginActivity();
}
