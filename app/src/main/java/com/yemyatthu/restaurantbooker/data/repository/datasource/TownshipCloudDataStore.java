package com.yemyatthu.restaurantbooker.data.repository.datasource;

import com.yemyatthu.restaurantbooker.data.cache.TownshipCache;
import com.yemyatthu.restaurantbooker.data.entity.TownshipEntity;
import com.yemyatthu.restaurantbooker.data.net.ServiceGenerator;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class TownshipCloudDataStore implements TownshipDataStore {
    private final TownshipCache townshipCache;
    TownshipCloudDataStore(TownshipCache townshipCache){
        this.townshipCache = townshipCache;
    }
    @Override
    public Observable<List<TownshipEntity>> townships() {
        return ServiceGenerator.getTownshipService().getTownships().doOnNext(new Consumer<List<TownshipEntity>>() {
            @Override
            public void accept(final List<TownshipEntity> townshipEntities) throws Exception {
                townshipCache.put(townshipEntities);
            }
        });
    }
}
