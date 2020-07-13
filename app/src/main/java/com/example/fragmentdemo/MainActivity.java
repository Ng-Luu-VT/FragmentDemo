package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private TextView txtMain;
    private Button btnAddFragA;
    private Button btnAddFragB;
    private Button btnMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    private void init() {
//        FragmentTransaction fragmentTransactionA = fragmentManager.beginTransaction();
//        FragmentTransaction fragmentTransactionB = fragmentManager.beginTransaction();
//        fragmentTransactionA.add(R.id.actMain_framFragmentA, new FragmentA(), "FragmentA");
//        fragmentTransactionB.add(R.id.actMain_framFragmentB, new FragmentB(), "FragmentB");
//        fragmentTransactionA.commit();
//        fragmentTransactionB.commit();
        txtMain = findViewById(R.id.actMain_tvHello);
        btnAddFragA = findViewById(R.id.actMain_btnAddFragmentA);
        btnAddFragB = findViewById(R.id.actMain_btnAddFragmentB);
        btnMain = findViewById(R.id.actMain_btnChangeText);
        final FragmentA fragmentA = new FragmentA();
        final FragmentB fragmentB = new FragmentB();
        btnAddFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(fragmentA);
            }
        });
        btnAddFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(fragmentB);
            }
        });
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA.newInstance(fragmentA,txtMain.getText().toString().trim());
//                Bundle bundle = new Bundle();
//                bundle.putString("Text",txtMain.getText().toString().trim());
//                fragmentA.setArguments(bundle);
            }
        });
    }

    // dặt sai tên hàm, tên hàm dặt theo kiểu chữ thường đầu chữ tiếp theo ngăn cáh bang chư in hoaoa
    // giờ tạo hàm click gọi này truyền fragment tương ứng
    public void addFragment (Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // tất c fragment ađ vào trong llContent
        // fragment phải đứa nó vào stack sau này 1 acityvy mình sẽ sxài rất nhiều fragment
        fragmentTransaction.add(R.id.llContent,fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
}