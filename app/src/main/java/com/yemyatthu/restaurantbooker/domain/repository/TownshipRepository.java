package com.yemyatthu.restaurantbooker.domain.repository;

import com.yemyatthu.restaurantbooker.domain.model.Township;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public interface TownshipRepository {
    Observable<List<Township>> townships();
}
