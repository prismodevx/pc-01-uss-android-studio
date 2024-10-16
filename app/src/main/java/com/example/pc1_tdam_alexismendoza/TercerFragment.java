package com.example.pc1_tdam_alexismendoza;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.pc1_tdam_alexismendoza.databinding.FragmentSecondBinding;
import com.example.pc1_tdam_alexismendoza.databinding.FragmentTercerBinding;


public class TercerFragment extends Fragment {

    private FragmentTercerBinding binding;

//    public static TercerFragment newInstance(String param1, String param2) {
//        TercerFragment fragment = new TercerFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tercer, container, false);

        binding = FragmentTercerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String email = TercerFragmentArgs.fromBundle(getArguments()).getEmail();
        binding.txtEmail.setText(email);

    }
}