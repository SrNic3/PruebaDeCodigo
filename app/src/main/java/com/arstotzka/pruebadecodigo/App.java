package com.arstotzka.pruebadecodigo;

import android.app.Application;

import com.arstotzka.pruebadecodigo.DI.AppComponent;
import com.arstotzka.pruebadecodigo.DI.AppModule;
import com.arstotzka.pruebadecodigo.DI.DaggerAppComponent;

/**
 * Created by Dani on 08/04/2017.
 */

public class App extends Application{

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component =  DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getmComponent() {
        return component;
    }
}
