package com.tabardel.weather.ui.views;

import com.tabardel.weather.core.presenters.BasePresenter;

/**
 * Created by TABARDEL_Remy on 17/12/2016.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
