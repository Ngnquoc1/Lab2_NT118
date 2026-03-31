package com.nhom18.lab2_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Bai5Activity extends AppCompatActivity {

    private ArrayList<Dish> dishList;
    private DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);

        EditText etName = findViewById(R.id.etName);
        Spinner spThumbnail = findViewById(R.id.spThumbnail);
        CheckBox cbPromotion = findViewById(R.id.cbPromotion);
        Button btnAddDish = findViewById(R.id.btnAddDish);
        GridView gvDish = findViewById(R.id.gvDish);

        // Thiết lập Adapter cho Spinner
        ThumbnailAdapter thumbnailAdapter = new ThumbnailAdapter(this, Thumbnail.values());
        spThumbnail.setAdapter(thumbnailAdapter);

        // Thiết lập Adapter cho GridView
        dishList = new ArrayList<>();
        dishAdapter = new DishAdapter(this, dishList);
        gvDish.setAdapter(dishAdapter);

        // Xử lý nút Thêm
        btnAddDish.setOnClickListener(v -> {
            String name = etName.getText().toString();
            Thumbnail selectedThumbnail = (Thumbnail) spThumbnail.getSelectedItem();
            boolean isPromotion = cbPromotion.isChecked();

            // Thêm vào danh sách
            Dish newDish = new Dish(name, selectedThumbnail, isPromotion);
            dishList.add(newDish);
            dishAdapter.notifyDataSetChanged();

            // Reset giao diện
            etName.setText("");
            spThumbnail.setSelection(0);
            cbPromotion.setChecked(false);

            // Hiển thị Toast
            Toast.makeText(Bai5Activity.this, "Added successfully", Toast.LENGTH_SHORT).show();
        });

        // Nút điều hướng
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            // Chuyển sang phần RecyclerView
            Intent intent = new Intent(Bai5Activity.this, Bai6Activity.class);
            startActivity(intent);
        });
    }
}