package com.yemyatthu.restaurantbooker;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Ye Myat Thu on 2/9/2017.
 */


public class RestaurantBookerApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
