package com.yemyatthu.restaurantbooker.data.cache;

import com.yemyatthu.restaurantbooker.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public interface TownshipCache {
    boolean isExpired();
    boolean isCached();
    Observable<List<TownshipEntity>> get();
    void put(List<TownshipEntity> townshipEntities);
}
