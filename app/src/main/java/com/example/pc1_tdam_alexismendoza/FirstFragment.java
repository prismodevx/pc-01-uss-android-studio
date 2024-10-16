package com.example.pc1_tdam_alexismendoza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pc1_tdam_alexismendoza.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private String pinIngresado = "";
    private String emailActual = "";

    private static final HashMap<String, String> userMap = new HashMap<>();
    static {
        userMap.put("alexis@gmail.com", "1234");
        userMap.put("jersson@gmail.com", "5678");
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        generarBotones();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void generarBotones() {
        GridLayout grid = binding.grid;
        grid.removeAllViews();
        pinIngresado = "";

        List<Integer> digitos = new ArrayList<>();
        for (int i = 0; i <=9; i++) {
            digitos.add(i);
        }
        Collections.shuffle(digitos);

        for (int digito : digitos) {
            Button btn = new Button(getContext());
            btn.setText(String.valueOf(digito));
            btn.setTextSize(24f);
            btn.setPadding(16,16,16,16);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = 0;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.setMargins(8, 8, 8, 8);

            btn.setLayoutParams(params);

            btn.setOnClickListener(v -> {
                if (pinIngresado.length() < 4) {
                    pinIngresado += btn.getText().toString();
                    if (pinIngresado.length() == 4) {
                        validarPin();
                    }
                }
            });

            grid.addView(btn);

            grid.setUseDefaultMargins(true);
            grid.setAlignmentMode(GridLayout.ALIGN_MARGINS);
            grid.setColumnCount(3);
            grid.setRowCount(4);
        }
    }

    private void validarPin() {
        emailActual = binding.edtEmail.getText().toString();
        String pin = userMap.get(emailActual);

        if (pin != null && pin.equals(pinIngresado)) {

            FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                    FirstFragmentDirections.actionFirstFragmentToSecondFragment(emailActual);
            NavHostFragment.findNavController(FirstFragment.this).navigate(action);
        } else {
            Toast.makeText(getContext(), "Error: Ingresaste la clave incorrecta", Toast.LENGTH_SHORT).show();
            generarBotones();
        }
    }
}