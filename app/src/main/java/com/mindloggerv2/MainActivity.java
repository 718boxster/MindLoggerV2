package com.mindloggerv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView categoryList;
    LinearLayoutManager linearLayoutManager;
    CategoryListAdapter categoryListAdapter;
    ArrayList<CategoryData> categoryData = new ArrayList<>();

    ImageView a11, a21, a31, a41, a51, a61;
    LinearLayout a12, a22, a32, a42, a52, a62;

    ImageView profile1, profile2, profile3, profile4, profile5, profile6;

    boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoLayout.setResizeView(this);
        categoryList = findViewById(R.id.category_list);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryListAdapter = new CategoryListAdapter(categoryData, this);
        categoryList.setAdapter(categoryListAdapter);
        categoryList.setLayoutManager(linearLayoutManager);
        categoryList.addItemDecoration(new RecyclerViewMargin(20,1));
        categoryData.add(new CategoryData("우울함", R.drawable.gloomy));
        categoryData.add(new CategoryData("외로움", R.drawable.lonly));
        categoryData.add(new CategoryData("불안함", R.drawable.worried));
        categoryData.add(new CategoryData("화가남", R.drawable.angry));
        categoryListAdapter.notifyDataSetChanged();

        profile1 = findViewById(R.id.profile1);
        profile2 = findViewById(R.id.profile2);
        profile3 = findViewById(R.id.profile3);
        profile4 = findViewById(R.id.profile4);
        profile5 = findViewById(R.id.profile5);
        profile6 = findViewById(R.id.profile6);

        Glide.with(this).load(R.drawable.profile1).apply(new RequestOptions().circleCrop()).into(profile1);
        Glide.with(this).load(R.drawable.profile2).apply(new RequestOptions().circleCrop()).into(profile2);
        Glide.with(this).load(R.drawable.profile3).apply(new RequestOptions().circleCrop()).into(profile3);
        Glide.with(this).load(R.drawable.profile4).apply(new RequestOptions().circleCrop()).into(profile4);
        Glide.with(this).load(R.drawable.profile5).apply(new RequestOptions().circleCrop()).into(profile5);
        Glide.with(this).load(R.drawable.profile6).apply(new RequestOptions().circleCrop()).into(profile6);

        a11 = findViewById(R.id.a1_1);
        a21 = findViewById(R.id.a2_1);
        a31 = findViewById(R.id.a3_1);
        a41 = findViewById(R.id.a4_1);
        a51 = findViewById(R.id.a5_1);
        a61 = findViewById(R.id.a6_1);

        a12 = findViewById(R.id.a1_2);
        a22 = findViewById(R.id.a2_2);
        a32 = findViewById(R.id.a3_2);
        a42 = findViewById(R.id.a4_2);
        a52 = findViewById(R.id.a5_2);
        a62 = findViewById(R.id.a6_2);

        a11.setOnClickListener(this);
        a21.setOnClickListener(this);
        a31.setOnClickListener(this);
        a41.setOnClickListener(this);
        a51.setOnClickListener(this);
        a61.setOnClickListener(this);

        a12.setOnClickListener(this);
        a22.setOnClickListener(this);
        a32.setOnClickListener(this);
        a42.setOnClickListener(this);
        a52.setOnClickListener(this);
        a62.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Feed.class);
        startActivity(intent);
    }
}
