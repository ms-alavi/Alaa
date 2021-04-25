package com.example.alaa.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alaa.R;
import com.example.alaa.databinding.FragmentButtonSheetBinding;
import com.example.alaa.viewmodel.MainViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class ButtonSheetFragment extends BottomSheetDialogFragment {
    public static String TAG = "com.example.alaa.ButtonSheetFragment";
    private FragmentButtonSheetBinding mBinding;
    private MainViewModel mMainViewModel;


    public ButtonSheetFragment() {
        // Required empty public constructor
    }

    public static ButtonSheetFragment newInstance() {
        ButtonSheetFragment fragment = new ButtonSheetFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      mMainViewModel=new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_button_sheet, container, false);

        setListener();


        return mBinding.getRoot();
    }

    private void setListener() {
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });
        mBinding.textView.setText(mMainViewModel.getName().getValue() +" "+mMainViewModel.getFamily().getValue());
    }
}