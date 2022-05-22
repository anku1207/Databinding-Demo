package com.example.recyclerviewdatabinding;

public interface UICallbacks {
    int getLayoutID();

    void onBinding();

    Class getViewModel();

    BaseNavigator getNavigatorReference();

    String getScreenName();

}
