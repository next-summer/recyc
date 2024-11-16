package com.example.myapplication2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MYwork1 extends AppCompatActivity {
    private  String name;
    private  String brith;
    private  String age;
    private String  EVOL;
    private String  identity;
    private int hight;

    private  Integer pic;
    public MYwork1(){

    }
    public MYwork1(String name,String age,String brith,int hight,String identity,String EVOL,Integer pic){
        this.name=name;
        this.brith=brith;
        this.age=age;
        this.hight=hight;
        this.identity=identity;
        this.EVOL=EVOL;
        this.pic=pic;
    }
    public String getName(){
        return name;
    }



    public String getBrith() {
        return brith;
    }

    public String getAge() {
        return age;
    }

    public String getEVOL() {
        return EVOL;
    }

    public String getIdentity() {
        return identity;
    }

    public int getHight() {
        return hight;
    }

    public Integer getPic() {
        return pic;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lysk);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}