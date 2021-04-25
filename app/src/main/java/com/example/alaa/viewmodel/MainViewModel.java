package com.example.alaa.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.alaa.repository.Repository;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<String> mName;
    private MutableLiveData<String> mFamily;
    private MutableLiveData<Boolean> mNightMode;
    private Repository mRepository;

    public void setName(String name) {
        mRepository.setName(name);
    }

    public void setFamily(String family) {
        mRepository.setFamily(family);
    }

    public void setNightMode(boolean nightMode) {
        mRepository.setNightMode(nightMode);
    }

    public MutableLiveData<String> getName() {
        return mName;
    }

    public MutableLiveData<String> getFamily() {
        return mFamily;
    }

    public MutableLiveData<Boolean> getNightMode() {
        return mNightMode;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository = Repository.getInstance();
        mName = mRepository.getName();
        mFamily = mRepository.getFamily();
        mNightMode = mRepository.getNightMode();
    }
}
