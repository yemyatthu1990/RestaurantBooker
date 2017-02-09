package com.yemyatthu.restaurantbooker.presentation.view.activity;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yemyatthu.restaurantbooker.R;
import com.yemyatthu.restaurantbooker.data.cache.TownshipCache;
import com.yemyatthu.restaurantbooker.data.cache.TownshipCacheImpl;
import com.yemyatthu.restaurantbooker.data.entity.mapper.TownshipMapper;
import com.yemyatthu.restaurantbooker.data.repository.TownshipDataRepository;
import com.yemyatthu.restaurantbooker.data.repository.datasource.TownshipDataStoreFactory;
import com.yemyatthu.restaurantbooker.domain.interactor.GetTownshipList;
import com.yemyatthu.restaurantbooker.presentation.model.TownshipModel;
import com.yemyatthu.restaurantbooker.presentation.model.mapper.TownshipModelMapper;
import com.yemyatthu.restaurantbooker.presentation.presenter.TownshipListPresenter;
import com.yemyatthu.restaurantbooker.presentation.view.TownshipListView;
import com.yemyatthu.restaurantbooker.presentation.view.adapter.TownshipAdapter;

import java.util.List;

import butterknife.BindView;

public class TownshipListActivity extends BaseActivity implements TownshipListView {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.activity_township_list)
    RelativeLayout activityTownshipList;
    @BindView(R.id.error)
    TextView error;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private TownshipAdapter townshipAdapter;
    private TownshipListPresenter townshipListPresenter;
    private GetTownshipList getTownshipList;
    private TownshipModelMapper townshipModelMapper;
    private TownshipDataRepository townshipDataRepository;
    private TownshipMapper townshipMapper;
    private TownshipDataStoreFactory townshipDataStoreFactory;
    private TownshipCache townshipCache;

    public TownshipListActivity(){

    }
    @Override
    public void renderTownshipList(List<TownshipModel> townshipModels) {
        townshipAdapter.setTownships(townshipModels);
    }

    @Override
    public void showLoading() {
        recycler.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        recycler.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        recycler.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        error.setVisibility(View.VISIBLE);
        error.setText(errorMessage);
    }


    @Override
    public Context context() {
        return this;
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_township_list;
    }

    @Override
    public void initComponents() {
        townshipAdapter = new TownshipAdapter();
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        recycler.setAdapter(townshipAdapter);
        townshipModelMapper = new TownshipModelMapper();
        townshipMapper = new TownshipMapper();
        townshipCache = new TownshipCacheImpl();
        townshipDataStoreFactory = new TownshipDataStoreFactory(townshipCache);
        townshipDataRepository = new TownshipDataRepository(townshipDataStoreFactory,townshipMapper);
        getTownshipList = new GetTownshipList(townshipDataRepository);
        townshipListPresenter = new TownshipListPresenter(getTownshipList,townshipModelMapper);
        townshipListPresenter.setTownshipListView(this);
        townshipListPresenter.initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        townshipListPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        townshipListPresenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        townshipListPresenter.destroy();
    }
}
