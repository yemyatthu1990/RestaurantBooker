package com.yemyatthu.restaurantbooker.presentation.view;

import android.content.Context;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public interface LoadDataView {
    void showLoading();
    void hideLoading();
    void showError(String errorMessage);
    Context context();
}
