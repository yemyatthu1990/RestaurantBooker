package com.yemyatthu.restaurantbooker.data.repository;

import com.yemyatthu.restaurantbooker.data.entity.TownshipEntity;
import com.yemyatthu.restaurantbooker.data.entity.mapper.TownshipMapper;
import com.yemyatthu.restaurantbooker.data.repository.datasource.TownshipDataStoreFactory;
import com.yemyatthu.restaurantbooker.domain.model.Township;
import com.yemyatthu.restaurantbooker.domain.repository.TownshipRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class TownshipDataRepository implements TownshipRepository{
    private final TownshipDataStoreFactory townshipDataStoreFactory;
    private final TownshipMapper townshipMapper;
    public TownshipDataRepository(TownshipDataStoreFactory townshipDataStoreFactory,TownshipMapper townshipMapper){
        this.townshipDataStoreFactory = townshipDataStoreFactory;
        this.townshipMapper = townshipMapper;
    }
    @Override
    public Observable<List<Township>> townships() {
        return townshipDataStoreFactory.create().townships().map(new Function<List<TownshipEntity>, List<Township>>() {
            @Override
            public List<Township> apply(List<TownshipEntity> townshipEntities) throws Exception {
                return townshipMapper.transformList(townshipEntities);
            }
        });
    }
}
