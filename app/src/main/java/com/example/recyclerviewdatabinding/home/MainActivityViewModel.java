package com.example.recyclerviewdatabinding.home;

import android.content.res.Resources;

import com.example.recyclerviewdatabinding.BaseViewModel;

public class MainActivityViewModel extends BaseViewModel<MainActivityNavigator> {

    private MainActivityModel mainActivityModel;


    public void init(Resources resources) {
        setResource(resources);
        mainActivityModel = new MainActivityModel();
    }

    public void setLoadingWithMessage(String message) {
        dialogMessage.setValue(message);
        dialogVisibility.setValue(true);
    }

    public MainActivityModel getMainActivityModel() {
        return mainActivityModel;
    }

    public void test(MainActivityModel mainActivityModel) {
        // setLoadingWithMessage("fsdfsdf");
        mNavigator.showInstallAPP();
    }


}
