package com.example.sakuralxm.popwindowsfragment;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;


public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}