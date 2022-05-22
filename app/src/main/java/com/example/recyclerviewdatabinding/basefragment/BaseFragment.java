package com.example.recyclerviewdatabinding.basefragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recyclerviewdatabinding.BaseActivity;
import com.example.recyclerviewdatabinding.BaseViewModel;
import com.example.recyclerviewdatabinding.UICallbacks;

public abstract class BaseFragment <T extends ViewDataBinding, V extends BaseViewModel> extends Fragment implements UICallbacks {

    protected Context mContext;
    protected T mBinding;
    protected V mViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false);
        if (isActivityViewModel()) {
            mViewModel = (V) new ViewModelProvider(getBaseActivity()).get(getViewModel());
        } else {
            mViewModel = (V) new ViewModelProvider(this).get(getViewModel());
            mViewModel.setNavigator(getNavigatorReference());
        }
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getContext();
        if (!isActivityViewModel()) {
          //  createDialog();
        }
        onBinding();
    }


    protected abstract boolean isActivityViewModel();

    protected BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

}
