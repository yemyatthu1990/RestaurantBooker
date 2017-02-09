package com.yemyatthu.restaurantbooker.data.repository.datasource;

import com.yemyatthu.restaurantbooker.data.cache.TownshipCache;
import com.yemyatthu.restaurantbooker.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class TownshipLocalDataStore implements TownshipDataStore {
    private final TownshipCache townshipCache;
    TownshipLocalDataStore(TownshipCache townshipCache){
        this.townshipCache = townshipCache;
    }
    //Return a list of townships from DB
    @Override
    public Observable<List<TownshipEntity>> townships() {
      return townshipCache.get();
    }
}
