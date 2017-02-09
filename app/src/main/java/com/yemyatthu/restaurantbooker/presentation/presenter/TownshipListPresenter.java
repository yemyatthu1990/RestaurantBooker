package com.yemyatthu.restaurantbooker.presentation.presenter;

import com.yemyatthu.restaurantbooker.domain.interactor.DefaultObserver;
import com.yemyatthu.restaurantbooker.domain.interactor.GetTownshipList;
import com.yemyatthu.restaurantbooker.domain.model.Township;
import com.yemyatthu.restaurantbooker.presentation.model.TownshipModel;
import com.yemyatthu.restaurantbooker.presentation.model.mapper.TownshipModelMapper;
import com.yemyatthu.restaurantbooker.presentation.view.TownshipListView;

import java.util.List;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class TownshipListPresenter implements Presenter{
    private TownshipListView townshipListView;
    private final GetTownshipList getTownshipList;
    private final TownshipModelMapper townshipModelMapper;

    public TownshipListPresenter(GetTownshipList getTownshipList,TownshipModelMapper townshipModelMapper){
        this.getTownshipList = getTownshipList;
        this.townshipModelMapper = townshipModelMapper;
    }

    public void setTownshipListView(TownshipListView townshipListView){
        this.townshipListView = townshipListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getTownshipList.dispose();
        this.townshipListView = null;
    }

    public void initialize(){
        this.loadTownshipList();
    }

    private void loadTownshipList() {
        this.showViewLoading();
        this.getTownshipList();
    }

    private void showViewLoading() {
        this.townshipListView.showLoading();
    }

    private void hideViewLoading() {
        this.townshipListView.hideLoading();
    }

    private void showErrorMessage(String errorMessage) {
        this.townshipListView.showError(errorMessage);
    }

    private void showTownshipListInView(List<Township> townships) {
        final List<TownshipModel> townshipModelList =
                this.townshipModelMapper.transformList(townships);
        this.townshipListView.renderTownshipList(townshipModelList);
    }

    private void getTownshipList() {
        this.getTownshipList.execute(new TownshipListObserver(), null);
    }

    private final class TownshipListObserver extends DefaultObserver<List<Township>> {

        @Override public void onComplete() {
            TownshipListPresenter.this.hideViewLoading();
        }

        @Override public void onError(Throwable e) {
            e.printStackTrace();
            TownshipListPresenter.this.hideViewLoading();
            TownshipListPresenter.this.showErrorMessage(e.getLocalizedMessage());
        }

        @Override public void onNext(List<Township> townships) {
            TownshipListPresenter.this.showTownshipListInView(townships);
        }
    }
}
