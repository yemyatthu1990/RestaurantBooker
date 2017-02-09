package com.yemyatthu.restaurantbooker.domain.interactor;

import com.yemyatthu.restaurantbooker.domain.model.Township;
import com.yemyatthu.restaurantbooker.domain.repository.TownshipRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class GetTownshipList extends UseCase<List<Township>,Void>{
    private final TownshipRepository townshipRepository;
    public GetTownshipList(TownshipRepository townshipRepository){
        this.townshipRepository = townshipRepository;
    }
    @Override
    Observable<List<Township>> buildUseCaseObservable(Void unused) {
        return townshipRepository.townships();
    }
}
