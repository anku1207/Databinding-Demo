package com.example.recyclerviewdatabinding.fragment;

import android.content.res.Resources;

import androidx.lifecycle.MutableLiveData;

import com.example.recyclerviewdatabinding.BaseViewModel;
import com.example.recyclerviewdatabinding.home.MainActivityModel;
import com.example.recyclerviewdatabinding.home.MainActivityViewModel;

public class FragmentActivityViewModel extends BaseViewModel<FragmentActivityNavigator> {
    private FragmentActivityModel fragmentActivityModel;

    private MutableLiveData<FragmentActivityModel> fragmentActivityModelMutableLiveData;


    public void init(Resources resources) {
        setResource(resources);
        fragmentActivityModel = new FragmentActivityModel();
        fragmentActivityModelMutableLiveData= new MutableLiveData<>();

    }

    public void setLoadingWithMessage(String message) {
        dialogMessage.setValue(message);
        dialogVisibility.setValue(true);
    }

    public FragmentActivityModel getFragmentActivityModel() {
        return fragmentActivityModel;
    }

    public void test(FragmentActivityModel fragmentActivityModel) {
        // setLoadingWithMessage("fsdfsdf");
        mNavigator.showInstallAPP();
    }

    public void f1Click(FragmentActivityModel fragmentActivityModel) {
        // setLoadingWithMessage("fsdfsdf");
       // mNavigator.fragment1Click();
        fragmentActivityModelMutableLiveData.setValue(fragmentActivityModel);
        fragmentActivityModelMutableLiveData.getValue().setButtonText("hoooooooooooo");
    }

    public void f1Click2(FragmentActivityModel fragmentActivityModel) {
        // setLoadingWithMessage("fsdfsdf");
        // mNavigator.fragment1Click();

        System.out.println(fragmentActivityModel.getButtonText());
    }


}
