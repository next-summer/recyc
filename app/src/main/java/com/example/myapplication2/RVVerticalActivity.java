package com.example.myapplication2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RVVerticalActivity extends AppCompatActivity {
//   竖向布局的交互界面
    private RecyclerView re_vertical;//控件
    private List<MYwork1> listData=new ArrayList<MYwork1>();//界面数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rvvertical);

        initDate();
        re_vertical=findViewById(R.id.rec);
        re_vertical.setLayoutManager(new LinearLayoutManager(this));
//        向组件设置适配器
        MyVertivalAdapter myVertivalAdapter=new MyVertivalAdapter();
        re_vertical.setAdapter(myVertivalAdapter);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    private void initDate() {
        listData=MyDataTools.getInitData();
            }
//    自定义竖向布局适配器
    class MyVertivalAdapter extends RecyclerView.Adapter<MyVertivalAdapter.MyVerticalViewHolder>{

        @NonNull
        @Override
        public MyVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            加载布局item
            MyVerticalViewHolder holder=new MyVerticalViewHolder(LayoutInflater.
                    from(RVVerticalActivity.this).
                    inflate(R.layout.rv_vertical,parent,false));

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyVerticalViewHolder holder, int position) {
            MYwork1 obj=listData.get(position);
            holder.iv_pic.setImageResource(obj.getPic());
            holder.tv_name.setText(obj.getName());
            holder.tv_age.setText(obj.getAge());
            holder.tv_brith.setText(obj.getBrith());
            holder.tv_hight.setText("身高：" + obj.getHight() + "cm");
            holder.tv_identity.setText(obj.getIdentity());
            holder.tv_EVOL.setText("EVOL:" + obj.getEVOL());

        }

        @Override
        public int getItemCount() {
            return listData.size();
        }
//        自定义继承RecyclerView.ViewHolder的holder类
        class MyVerticalViewHolder extends RecyclerView.ViewHolder{
            TextView tv_name,tv_age,tv_brith,tv_hight,tv_identity,tv_EVOL;
            ImageView iv_pic;

             public MyVerticalViewHolder(@NonNull View itemView)
             {
                  super(itemView);
                  tv_name=itemView.findViewById(R.id.tv_name);
                  tv_age=itemView.findViewById(R.id.tv_age);
                  tv_brith=itemView.findViewById(R.id.tv_brith);
                  tv_hight=itemView.findViewById(R.id.tv_hight);
                  tv_identity=itemView.findViewById(R.id.tv_identity);
                  tv_EVOL=itemView.findViewById(R.id.tv_EVOL);
                  iv_pic=itemView.findViewById(R.id.iv_pic);
             }
        }
    }
}