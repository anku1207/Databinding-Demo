package com.example.recyclerviewdatabinding;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.recyclerviewdatabinding.home.MainActivity;

public abstract class BaseActivity <T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements UICallbacks {
    protected T mBinding;
    protected V mViewModel;
    protected Context mContext;



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);

        overridePendingTransitionEnter();
        mBinding = DataBindingUtil.setContentView(BaseActivity.this, getLayoutID());
        mBinding.setLifecycleOwner(this);
        mViewModel = (V) new ViewModelProvider(BaseActivity.this).get(getViewModel());
        mViewModel.setNavigator(getNavigatorReference());

        onBinding();
        createDialog();
    }

    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.anim_slide_in_from_right_enter, R.anim.anim_slide_in_from_right_exit);
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.anim_slide_in_from_left_enter, R.anim.anim_slide_in_from_left_exit);
    }



    private void createDialog() {
        LoadingDialog loadingDialog = new LoadingDialog(BaseActivity.this);
        loadingDialog.setCancelable(false);

        mViewModel.dialogMessage.observe(BaseActivity.this, msg -> {
            if (loadingDialog != null) {
                loadingDialog.setDialogMessage(String.valueOf(msg));
            }
        });

        mViewModel.dialogVisibility.observe(this, showDialog -> {

            if ((Boolean) showDialog) {
                if (loadingDialog != null)
                    loadingDialog.showDialog();
            } else {
                if (loadingDialog != null && loadingDialog.isShowing())
                    loadingDialog.dismissDialog();
            }
        });
    }

    protected void replaceFragmentWithAnimation(Fragment fragment, boolean isAddToStack, int container) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment, fragment.getClass().getSimpleName());
        if (isAddToStack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();
    }





}
