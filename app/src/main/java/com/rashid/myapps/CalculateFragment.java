package com.rashid.myapps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;


public class CalculateFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText fn, sn, hasil;
    Button tambah, kurang, kali, bagi, bersih;
    float fn1, sn2, hs3;


    public CalculateFragment() {
    }
    public static CalculateFragment newInstance(String param1, String param2) {
        CalculateFragment fragment = new CalculateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getArguments().getString(ARG_PARAM1);
            getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculate, container, false);

        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Calculate");

        fn = v.findViewById(R.id.fn);
        sn = v.findViewById(R.id.sn);
        hasil = v.findViewById(R.id.result);

        tambah = v.findViewById(R.id.tambah);
        kurang = v.findViewById(R.id.kurang);
        kali = v.findViewById(R.id.kali);
        bagi = v.findViewById(R.id.bagi);
        bersih = v.findViewById(R.id.bersih);


        View.OnClickListener buttonClick = x -> {
            if (fn.getText().toString().isEmpty() && sn.getText().toString().isEmpty()) {
                fn.setError("First Number Required");
                sn.setError("Second Number Required");
                return;
            }
            if (fn.getText().toString().isEmpty()) {
                fn.setError("First Number Required");
                return;
            }
            if (sn.getText().toString().isEmpty()) {
                sn.setError("Second Number Required");
                return;
            }

            fn1 = Float.parseFloat(fn.getText().toString());
            sn2 = Float.parseFloat(sn.getText().toString());
            hs3 = (float) 0;
            if (x.getId() == R.id.tambah) {
                hs3 = fn1 + sn2;
            } else if (x.getId() == R.id.kurang) {
                hs3 = fn1 - sn2;
            } else if (x.getId() == R.id.kali) {
                hs3 = fn1 * sn2;
            } else if (x.getId() == R.id.bagi) {
                hs3 = fn1 / sn2;
            }
            hasil.setText(String.valueOf(hs3));
        };

        tambah.setOnClickListener(buttonClick);
        kurang.setOnClickListener(buttonClick);
        kali.setOnClickListener(buttonClick);
        bagi.setOnClickListener(buttonClick);

        bersih.setOnClickListener(v1 -> {
            if (fn.getText().toString().isEmpty() && sn.getText().toString().isEmpty() && hasil.getText().toString().isEmpty()) {
                Toast.makeText(getActivity(), "Already Clear, DON'T SPAM!!!", Toast.LENGTH_SHORT).show();
                return;
            }
            fn.setText(null);
            sn.setText(null);
            hasil.setText(null);
        });
        return v;
    }
}