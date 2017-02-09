package com.yemyatthu.restaurantbooker.data.net;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class ServiceGenerator {
    private static TownshipService townshipService;
    public static TownshipService getTownshipService(){
        if(townshipService==null){
            townshipService = RetrofitHelper.getRetrofit().create(TownshipService.class);
        }
        return townshipService;
    }
}
