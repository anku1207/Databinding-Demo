package com.example.recyclerviewdatabinding;

import android.content.res.Resources;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel<N extends BaseNavigator> extends ViewModel {
    protected N mNavigator;
    protected Resources resources;
    protected MutableLiveData<Boolean> dialogVisibility = new MutableLiveData<>();
    protected MutableLiveData<String> dialogMessage = new MutableLiveData<>();


    public void setResource(Resources res){
        resources = res;
    }

    public Resources getResources() {
        if (resources == null) {
            return App.getContext().getResources();
        }
        return resources;
    }


    public void setNavigator(N mNavigator) {
        this.mNavigator = mNavigator;
    }






}
