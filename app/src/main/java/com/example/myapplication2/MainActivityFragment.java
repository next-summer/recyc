package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivityFragment extends AppCompatActivity implements View.OnClickListener {
    Fragment fragment1, fragment2, fragment3, fragment4;
    FragmentManager manager;
    FragmentTransaction transaction;
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lysk);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        linearLayout1 = findViewById(R.id.button_chat);
        linearLayout2 = findViewById(R.id.button_contacts);
        linearLayout3 = findViewById(R.id.button_find);
        linearLayout4 = findViewById(R.id.button_mine);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);


        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
//建立交互，赋值
        initial();
        fragment_Hide();
        transaction.commit();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void fragment_Hide() {
        transaction.hide(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);
    }

    void initial() {
        transaction.add(R.id.framelayout, fragment1);
        //连接layout，压入fragment1
        transaction.add(R.id.framelayout, fragment2);
        transaction.add(R.id.framelayout, fragment3);
        transaction.add(R.id.framelayout, fragment4);
    }

    @Override//四个针对视图监听
    public void onClick(View view) {
        // 开始 Fragment 事务
        transaction = manager.beginTransaction();
        fragment_Hide(); // 隐藏所有 Fragment

        // 根据点击的按钮显示相应的 Fragment
        if (view.getId() == R.id.button_chat) {
            transaction.show(fragment1);
        } else if (view.getId() == R.id.button_contacts) {
            transaction.show(fragment2);
        } else if (view.getId() == R.id.button_find) {
            transaction.show(fragment3);
        } else if (view.getId() == R.id.button_mine) {
            transaction.show(fragment4);
        } else {
            // 处理未知点击
        }

        transaction.commit();
    }
}
//
//
