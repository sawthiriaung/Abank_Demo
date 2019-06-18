package com.nmh.speaktotext.abank_demo.di.component;

import android.app.Application;
import android.content.Context;

import com.nmh.speaktotext.abank_demo.di.builder.ActivityBuilder;
import com.nmh.speaktotext.abank_demo.di.module.AppModule;
import com.nmh.speaktotext.abank_demo.utils.MvvmApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


}
