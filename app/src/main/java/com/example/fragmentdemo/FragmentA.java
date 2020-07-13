package com.example.fragmentdemo;

import android.os.Build;
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
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class FragmentA extends Fragment {

    TextView tvFragmentA;
    EditText edtTextFragmanetA;
    Button btnFragmentA;

    public static FragmentA newInstance(FragmentA fragmentA, String text) {
        Bundle bundle = new Bundle();
        bundle.putString("Text", text);
        fragmentA.setArguments(bundle);
        return fragmentA;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //lấy view mới ánh xạ được
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        init(view);
        return view;
    }

    private void init(View view) {
        tvFragmentA = view.findViewById(R.id.framentA_tvFagment);
        edtTextFragmanetA = view.findViewById(R.id.framentA_editTextFagment);
        btnFragmentA = view.findViewById(R.id.framentA_btnFagment);

        Bundle bundle = getArguments();
        if (bundle!= null){
            tvFragmentA.setText(bundle.getString("Text"));
        }

        btnFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvMain = getActivity().findViewById(R.id.actMain_tvHello);
                tvMain.setText(edtTextFragmanetA.getText().toString().trim());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
