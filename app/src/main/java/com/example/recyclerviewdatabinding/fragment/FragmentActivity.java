package com.example.recyclerviewdatabinding.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewdatabinding.BaseActivity;
import com.example.recyclerviewdatabinding.BaseNavigator;
import com.example.recyclerviewdatabinding.R;
import com.example.recyclerviewdatabinding.databinding.ActivityFragmentBinding;
import com.example.recyclerviewdatabinding.databinding.ActivityMainBinding;
import com.example.recyclerviewdatabinding.fragment.fragmentcontaner.Fragment_1;
import com.example.recyclerviewdatabinding.fragment.fragmentcontaner.Fragment_2;
import com.example.recyclerviewdatabinding.home.MainActivityNavigator;
import com.example.recyclerviewdatabinding.home.MainActivityViewModel;

public class FragmentActivity  extends BaseActivity<ActivityFragmentBinding, FragmentActivityViewModel> implements FragmentActivityNavigator {



    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void onNoInternetConnection() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_fragment;
    }

    @Override
    public void onBinding() {
        mViewModel.init(getResources());
        mBinding.setViewModel(mViewModel);
        mBinding.setModel(mViewModel.getFragmentActivityModel());

        Fragment_1 fragment = new Fragment_1();
        replaceFragmentWithAnimation(fragment, false, R.id.container);
    }

    @Override
    public Class getViewModel() {
        return FragmentActivityViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return this;
    }

    @Override
    public String getScreenName() {
        return null;
    }

    @Override
    public void showInstallAPP() {
        Toast.makeText(mContext, "sdfsdfsfdsdf", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void fragment1Click() {
        Toast.makeText(mContext, "fragment 1 click", Toast.LENGTH_SHORT).show();
        Fragment_2 fragment = new Fragment_2();
        replaceFragmentWithAnimation(fragment, true, R.id.container);
    }
}