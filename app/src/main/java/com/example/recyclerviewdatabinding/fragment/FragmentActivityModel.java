package com.example.recyclerviewdatabinding.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recyclerviewdatabinding.BR;

public class FragmentActivityModel extends BaseObservable implements Parcelable {
    private String name;
    private String password;
    private String buttonText;

    protected FragmentActivityModel(Parcel in) {
        name = in.readString();
        password = in.readString();
        buttonText = in.readString();
    }


    public FragmentActivityModel() {

    }

    public static final Creator<FragmentActivityModel> CREATOR = new Creator<FragmentActivityModel>() {
        @Override
        public FragmentActivityModel createFromParcel(Parcel in) {
            return new FragmentActivityModel(in);
        }

        @Override
        public FragmentActivityModel[] newArray(int size) {
            return new FragmentActivityModel[size];
        }
    };

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
        notifyPropertyChanged(BR.buttonText);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.name);
        parcel.writeString(this.password);
        parcel.writeString(this.buttonText);

    }
}


