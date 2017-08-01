package pl.lborowy.itemapp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by RENT on 2017-08-01.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this); // dziala dla wszystkich Activity!!
    }
}
