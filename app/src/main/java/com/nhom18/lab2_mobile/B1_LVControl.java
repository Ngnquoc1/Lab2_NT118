package com.nhom18.lab2_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class B1_LVControl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        // 1. Khởi tạo đối tượng listview và textview
        ListView lvPerson = findViewById(R.id.lv_person);
        TextView tvSelection = findViewById(R.id.tvSelection);

        // 2. Khởi tạo mảng chứa dữ liệu
        final String[] arr = {"Teo", "Ty", "Bin", "Bo"};

        // 3. Xây dựng adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        // 4. SetAdapter cho listview
        lvPerson.setAdapter(adapter);

        // 5. Xử lý sự kiện click trên listview
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // arg2 là vị trí phần tử trong Data Source [cite: 13]
                tvSelection.setText("position: " + arg2 + " ; value = " + arr[arg2]);
            }
        });

        // Ánh xạ 2 nút từ file layout_navigation_buttons.xml đã include
        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);

        // ẩn nút Back đi để giao diện hợp lý hơn
        btnBack.setVisibility(View.GONE);

        // Xử lý sự kiện nhấn nút Next để sang màn hình Bài 2
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo Intent chuyển sang Activity của Bài 2
                Intent intent = new Intent(B1_LVControl.this, B2_Array_LVControl.class);
                startActivity(intent);
            }
        });
    }
}