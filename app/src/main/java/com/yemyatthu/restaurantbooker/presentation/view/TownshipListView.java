package com.yemyatthu.restaurantbooker.presentation.view;

import com.yemyatthu.restaurantbooker.presentation.model.TownshipModel;

import java.util.List;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public interface TownshipListView extends LoadDataView {
    void renderTownshipList(List<TownshipModel> townshipModels);
}
