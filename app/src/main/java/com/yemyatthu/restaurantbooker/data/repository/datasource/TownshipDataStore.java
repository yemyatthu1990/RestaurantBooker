package com.yemyatthu.restaurantbooker.data.repository.datasource;

import com.yemyatthu.restaurantbooker.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public interface TownshipDataStore {

    Observable<List<TownshipEntity>> townships();

}
