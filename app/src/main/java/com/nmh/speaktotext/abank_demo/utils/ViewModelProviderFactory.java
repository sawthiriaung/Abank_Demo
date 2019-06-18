package com.nmh.speaktotext.abank_demo.utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.nmh.speaktotext.abank_demo.ui.splash.SplashViewModel;

public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

//    private final DataManager dataManager;
//    private final SchedulerProvider schedulerProvider;

//    public ViewModelProviderFactory(DataManager dataManager,
//                                    SchedulerProvider schedulerProvider) {
//        this.dataManager = dataManager;
//        this.schedulerProvider = schedulerProvider;
//    }

    public ViewModelProviderFactory() {

    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel();
        } throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
