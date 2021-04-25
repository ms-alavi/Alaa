package com.example.alaa.repository;

import androidx.lifecycle.MutableLiveData;

public class Repository {

    private MutableLiveData<String> mName=new MutableLiveData<>();
    private MutableLiveData<String> mFamily=new MutableLiveData<>();
    private MutableLiveData<Boolean> mNightMode=new MutableLiveData<>();

    private static Repository sRepository;
    public static Repository getInstance(){
        if (sRepository==null){
            sRepository=new Repository();
        }
        return sRepository;
    }
    private Repository(){

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

    public void setName(String name) {
        mName .setValue(name);
    }

    public void setFamily(String family) {
        mFamily.setValue(family);
    }

    public void setNightMode(boolean nightMode) {
        mNightMode.setValue(nightMode);
    }
}
