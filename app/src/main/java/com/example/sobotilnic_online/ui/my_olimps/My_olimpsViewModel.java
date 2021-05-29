package com.example.sobotilnic_online.ui.my_olimps;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class My_olimpsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public My_olimpsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Мои олимпиады");
    }

    public LiveData<String> getText() {
        return mText;
    }
}