package com.example.easyshop.main;

import android.app.Application;
import android.util.Log;

import com.example.easyshop.main.Utilities.MySP;
import com.example.easyshop.main.Utilities.SignalGenerator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MySP.init(this);
        SignalGenerator.init(this);
    }

}
