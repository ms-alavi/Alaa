package com.example.alaa.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alaa.R;
import com.example.alaa.databinding.FragmentABinding;
import com.example.alaa.viewmodel.MainViewModel;
import com.google.android.material.textfield.TextInputLayout;


public class A_Fragment extends Fragment {
    private FragmentABinding mBinding;
    private MainViewModel mMainViewModel;


    public A_Fragment() {
        // Required empty public constructor
    }

    public static A_Fragment newInstance() {
        A_Fragment fragment = new A_Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_a, container, false);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            mBinding.fab.setImageResource(R.drawable.ic_sun);
        }

        setListener();

        return mBinding.getRoot();
    }

    private void setListener() {
        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    mMainViewModel.setNightMode(false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    mBinding.fab.setImageResource(R.drawable.ic_sun);
                } else {
                    mMainViewModel.setNightMode(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    mBinding.fab.setImageResource(R.drawable.ic_moon);
                }


                getActivity().recreate();


            }
        });
        mBinding.btnOk.setOnClickListener(v -> {
            ButtonSheetFragment buttonSheetFragment = ButtonSheetFragment.newInstance();
            buttonSheetFragment.show(getActivity().getSupportFragmentManager(), ButtonSheetFragment.TAG);
        });
        mBinding.edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mMainViewModel.setName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mBinding.edtFamily.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mMainViewModel.setFamily(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}