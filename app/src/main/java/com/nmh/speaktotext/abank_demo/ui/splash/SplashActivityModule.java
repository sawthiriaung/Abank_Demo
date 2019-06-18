package com.nmh.speaktotext.abank_demo.ui.splash;

import com.nmh.speaktotext.abank_demo.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    ViewModelProviderFactory provideSplashViewModel() {
        return new ViewModelProviderFactory();
    }
}
