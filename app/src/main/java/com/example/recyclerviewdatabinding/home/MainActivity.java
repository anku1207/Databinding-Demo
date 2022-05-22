package com.example.recyclerviewdatabinding.home;

import android.content.Intent;
import android.widget.Toast;

import com.example.recyclerviewdatabinding.BaseActivity;
import com.example.recyclerviewdatabinding.BaseNavigator;
import com.example.recyclerviewdatabinding.R;
import com.example.recyclerviewdatabinding.databinding.ActivityMainBinding;
import com.example.recyclerviewdatabinding.fragment.FragmentActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements MainActivityNavigator {


    @Override
    public void onBinding() {
        mViewModel.init(getResources());
        mBinding.setModel(mViewModel.getMainActivityModel());
        mBinding.setViewModel(mViewModel);
        mBinding.getModel().setButtonText("sdfsdf");
    }

    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void onNoInternetConnection() {

    }

    @Override
    public void showInstallAPP() {
       // Toast.makeText(mContext,mBinding.getModel().getName() , Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,FragmentActivity.class));


    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }



    @Override
    public Class getViewModel() {
        return MainActivityViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return this;
    }

    @Override
    public String getScreenName() {
        return null;
    }
}