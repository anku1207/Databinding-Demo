package com.example.recyclerviewdatabinding.fragment.fragmentcontaner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recyclerviewdatabinding.BaseNavigator;
import com.example.recyclerviewdatabinding.R;
import com.example.recyclerviewdatabinding.basefragment.BaseFragment;
import com.example.recyclerviewdatabinding.databinding.Fragment1Binding;
import com.example.recyclerviewdatabinding.databinding.Fragment2Binding;
import com.example.recyclerviewdatabinding.fragment.FragmentActivityNavigator;
import com.example.recyclerviewdatabinding.fragment.FragmentActivityViewModel;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment_2 extends BaseFragment<Fragment2Binding, FragmentActivityViewModel> {

    @Override
    protected boolean isActivityViewModel() {
        return true;
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_2;
    }

    @Override
    public void onBinding() {
       // mViewModel.init(getResources());
        mBinding.setViewModel(mViewModel);
        mBinding.setModel(mViewModel.getFragmentActivityModel());

        //Toast.makeText(mContext, ""+mViewModel.getFragmentActivityModel().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Class getViewModel() {
        return FragmentActivityViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return null;
    }

    @Override
    public String getScreenName() {
        return null;
    }


}