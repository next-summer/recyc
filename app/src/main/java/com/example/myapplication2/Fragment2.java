package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    private RecyclerView re_vertical;
    private List<MYwork1> listData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_rvvertical, container, false);

        initViews(view);
        initData();
        setupRecyclerView();

        return view;
    }

    private void initViews(View view) {
        re_vertical = view.findViewById(R.id.rec);
    }

    private void initData() {
        listData = MyDataTools.getInitData();
    }

    private void setupRecyclerView() {
        re_vertical.setLayoutManager(new LinearLayoutManager(getContext()));
        MyVertivalAdapter myVertivalAdapter = new MyVertivalAdapter();
        re_vertical.setAdapter(myVertivalAdapter);
    }

    class MyVertivalAdapter extends RecyclerView.Adapter<MyVertivalAdapter.MyVerticalViewHolder> {

        @NonNull
        @Override
        public MyVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            MyVerticalViewHolder holder = new MyVerticalViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.rv_vertical, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyVerticalViewHolder holder, int position) {
            MYwork1 obj = listData.get(position);
            holder.iv_pic.setImageResource(obj.getPic());
            holder.tv_name.setText(obj.getName());
            holder.tv_age.setText(obj.getAge());
            holder.tv_brith.setText(obj.getBrith());
            holder.tv_hight.setText("身高：" + obj.getHight() + "cm");
            holder.tv_identity.setText(obj.getIdentity());
            holder.tv_EVOL.setText("EVOL:" + obj.getEVOL());

            // 设置点击监听器
            holder.iv_pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 创建一个Intent来启动DetailsActivity
                    Context context=getContext();
                    if (context != null) {
                        Intent intent = new Intent(context, details.class);
                    // 将数据放入Intent
                    intent.putExtra("name", obj.getName());
                    intent.putExtra("age", obj.getAge());
                    intent.putExtra("birth", obj.getBrith());
                    intent.putExtra("height", obj.getHight());
                    intent.putExtra("identity", obj.getIdentity());
                    intent.putExtra("EVOL", obj.getEVOL());
                    intent.putExtra("image", obj.getPic()); // 确保getPic()返回的是可以传递的资源ID或URI

                    // 启动Activity
                    context.startActivity(intent);
                }

            else {
                    Log.d("MyVertivalAdapter","context is null");
                }}
            });
        }
        @Override
        public int getItemCount() {
            return listData.size();
        }

        class MyVerticalViewHolder extends RecyclerView.ViewHolder {
            TextView tv_name, tv_age, tv_brith, tv_hight, tv_identity, tv_EVOL;
            ImageView iv_pic;

            public MyVerticalViewHolder(@NonNull View itemView) {
                super(itemView);
                tv_name = itemView.findViewById(R.id.tv_name);
                tv_age = itemView.findViewById(R.id.tv_age);
                tv_brith = itemView.findViewById(R.id.tv_brith);
                tv_hight = itemView.findViewById(R.id.tv_hight);
                tv_identity = itemView.findViewById(R.id.tv_identity);
                tv_EVOL = itemView.findViewById(R.id.tv_EVOL);
                iv_pic = itemView.findViewById(R.id.iv_pic);
            }
        }
    }

}