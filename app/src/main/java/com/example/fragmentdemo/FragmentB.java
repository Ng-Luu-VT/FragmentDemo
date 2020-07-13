package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    TextView tvFragmentB;
    EditText edtTextFragmanetB;
    Button btnFragmentB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //lấy view mới ánh xạ được
        View view = inflater.inflate(R.layout.fragment_b,container,false);

        tvFragmentB = view.findViewById(R.id.framentB_tvFagment);
        edtTextFragmanetB = view.findViewById(R.id.framentB_editTextFagment);
        btnFragmentB = view.findViewById(R.id.framentB_btnFagment);

        btnFragmentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvFragA = getActivity().findViewById(R.id.framentA_tvFagment);
                tvFragA.setText(edtTextFragmanetB.getText().toString().trim());
            }
        });

        return view;
    }
}
