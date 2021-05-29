package com.example.sobotilnic_online.ui.search_olimps;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Search_olimpsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Search_olimpsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Поиск олимпиад");
    }

    public LiveData<String> getText() {
        return mText;
    }
}