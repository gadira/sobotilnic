package com.example.sobotilnic_online.ui.materials;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MaterialsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MaterialsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Полезные материалы");
    }

    public LiveData<String> getText() {
        return mText;
    }
}