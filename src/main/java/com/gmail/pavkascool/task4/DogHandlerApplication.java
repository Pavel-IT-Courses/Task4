package com.gmail.pavkascool.task4;

import android.app.Application;
import android.content.Context;

import com.gmail.pavkascool.task4.db.DogDatabaseHelper;

public class DogHandlerApplication extends Application {
    private static DogHandlerApplication instance;

    public DogHandlerApplication() {
        instance = this;
    }

    public static Context getDogContext() {
        return instance;
    }

}
