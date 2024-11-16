package com.example.myapplication2;

import java.util.ArrayList;
import java.util.List;

//提供静态数据的工具类，与网络连接时，也可以访问网络，生成动态数据
public class MyDataTools {
    public static List<MYwork1>getInitData(){
        List<MYwork1> listDate=new ArrayList<MYwork1>();
        listDate.add(new MYwork1("沈星回","未知（自称24岁）","10月16日",
                185,"深空猎人","光",R.drawable.hui));
        listDate.add(new MYwork1("祁煜","24岁","3月6日",
                183,"艺术家","火",R.drawable.yu));
        listDate.add(new MYwork1("黎深","27岁","9月5日",
                186,"心脏外科医生","冰",R.drawable.shen));
        listDate.add(new MYwork1("秦彻","28岁","4月18日",
                190,"暗点组织首领","能量操控",R.drawable.che));
        listDate.add(new MYwork1("夏以昼","24岁","3月24日",
                184,"战斗机飞行员","未知",R.drawable.zhou));
        return listDate;

    }


}
