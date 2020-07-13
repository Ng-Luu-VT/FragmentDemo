package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayoutFragmentA;
    private FrameLayout frameLayoutFragmentB;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    private TextView txtMain;
    private Button btnMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        frameLayoutFragmentA = findViewById(R.id.actMain_framFragmentA);
        frameLayoutFragmentB = findViewById(R.id.actMain_framFragmentB);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    private void init() {
        FragmentTransaction fragmentTransactionA = fragmentManager.beginTransaction();
        FragmentTransaction fragmentTransactionB = fragmentManager.beginTransaction();
        fragmentTransactionA.add(R.id.actMain_framFragmentA, new FragmentA(), "FragmentA");
        fragmentTransactionB.add(R.id.actMain_framFragmentB, new FragmentB(), "FragmentB");
        fragmentTransactionA.commit();
        fragmentTransactionB.commit();
        txtMain = findViewById(R.id.actMain_tvHello);
        btnMain = findViewById(R.id.actMain_btnChangeText);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragmentA = new FragmentA();

                Bundle bundle = new Bundle();
                bundle.putString("TextA", txtMain.getText().toString());
                fragmentA.setArguments(bundle);

            }
        });
    }


//    public void AddFragment (View view){
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        Fragment fragment = null;
//        switch (view.getId()){
//            case R.id.actMain_btnAddFragmentA: fragment = new FragmentA();
//                break;
//            case R.id.actMain_btnAddFragmentB: fragment = new FragmentB();
//                break;
//        }
//        fragmentTransaction.add(R.id.actMain_framFragment,fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }
}