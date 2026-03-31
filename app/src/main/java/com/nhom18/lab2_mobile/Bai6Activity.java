package com.nhom18.lab2_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Bai6Activity extends AppCompatActivity {

    private ArrayList<Hero> mHeros;
    private RecyclerView mRecyclerHero;
    private HeroAdapter mHeroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6);

        mRecyclerHero = findViewById(R.id.recyclerHero);

        // Cài đặt LayoutManager cho RecyclerView (Dạng danh sách cuộn dọc)
        mRecyclerHero.setLayoutManager(new LinearLayoutManager(this));

        // Tạo dữ liệu
        mHeros = new ArrayList<>();
        createHeroList();

        // Cài đặt Adapter
        mHeroAdapter = new HeroAdapter(this, mHeros);
        mRecyclerHero.setAdapter(mHeroAdapter);

        // Xử lý nút điều hướng
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            // Chuyển sang Bài 7
            Intent intent = new Intent(Bai6Activity.this, Bai7Activity.class);
            startActivity(intent);
        });        btnNext.setOnClickListener(v -> {
            // Chuyển sang Bài 7
            Intent intent = new Intent(Bai6Activity.this, Bai7Activity.class);
            startActivity(intent);
        });
    }

    private void createHeroList() {
        mHeros.add(new Hero("Thor", R.drawable.image_hulk));
        mHeros.add(new Hero("IronMan", R.drawable.image_ironman));
        mHeros.add(new Hero("Hulk", R.drawable.image_hulk));
        mHeros.add(new Hero("SpiderMan", R.drawable.image_spiderman));
        mHeros.add(new Hero("Thor", R.drawable.image_thor));
        mHeros.add(new Hero("IronMan", R.drawable.image_ironman));
    }
}