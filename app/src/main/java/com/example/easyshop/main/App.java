package com.example.easyshop.main;

import android.app.Application;

import com.example.easyshop.main.Utilities.MySP;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MySP.init(this);
//        SignalGenerator.init(this);
    }

}
