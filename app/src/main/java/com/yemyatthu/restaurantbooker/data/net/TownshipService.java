package com.yemyatthu.restaurantbooker.data.net;

import com.yemyatthu.restaurantbooker.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public interface TownshipService {
    @GET("bins/yy0wl")
    Observable<List<TownshipEntity>> getTownships();
}
