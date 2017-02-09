package com.yemyatthu.restaurantbooker.data.repository.datasource;

import com.yemyatthu.restaurantbooker.data.cache.TownshipCache;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class TownshipDataStoreFactory {
    private final TownshipCache townshipCache;
    public TownshipDataStoreFactory(TownshipCache townshipCache){
        this.townshipCache = townshipCache;
    }

    public TownshipDataStore create(){
        if(!townshipCache.isExpired() && townshipCache.isCached()){
            return new TownshipLocalDataStore(townshipCache);
        }else{
            return new TownshipCloudDataStore(townshipCache);
        }
    }
}
