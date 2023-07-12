package com.example.easyshop.main;

import android.app.Application;

import com.example.easyshop.main.Utilities.SignalGenerator;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SignalGenerator.init(this);
    }

}
