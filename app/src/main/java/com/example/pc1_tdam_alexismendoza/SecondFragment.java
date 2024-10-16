package com.example.pc1_tdam_alexismendoza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pc1_tdam_alexismendoza.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private String dificultad;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String email = SecondFragmentArgs.fromBundle(getArguments()).getEmail();
        binding.txtEmail.setText(email);

        binding.btnRepartir.setOnClickListener(v -> {
            int seleccionado = binding.rdgDificultad.getCheckedRadioButtonId();
            RadioButton radioButton = view.findViewById(seleccionado);
            if (radioButton != null) {
                dificultad = radioButton.getText().toString();

                SecondFragmentDirections.ActionSecondFragmentToTercerFragment action =
                        SecondFragmentDirections.actionSecondFragmentToTercerFragment(email);
                NavHostFragment.findNavController(SecondFragment.this).navigate(action);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}