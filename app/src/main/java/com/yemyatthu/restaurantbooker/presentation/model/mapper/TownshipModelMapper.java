package com.yemyatthu.restaurantbooker.presentation.model.mapper;

import com.yemyatthu.restaurantbooker.domain.model.Township;
import com.yemyatthu.restaurantbooker.presentation.model.TownshipModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class TownshipModelMapper {
    public TownshipModelMapper(){

    }
    public TownshipModel transform(Township township){
        TownshipModel townshipModel = null;
        if(township!=null){
            townshipModel = new TownshipModel(township.getId(),township.getName(),township.getImageUrl());
        }
        return townshipModel;
    }

    public List<TownshipModel> transformList(List<Township> townships){
        List<TownshipModel> townshipModels = new ArrayList<>();
        for(Township township:townships){
            if(township!=null){
                townshipModels.add(transform(township));
            }
        }
        return townshipModels;
    }
}
