package com.example.sobotilnic_online.ui.search_sobotilnic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Search_sobotilnicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Search_sobotilnicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Поиск соботыльников");
    }

    public LiveData<String> getText() {
        return mText;
    }
}