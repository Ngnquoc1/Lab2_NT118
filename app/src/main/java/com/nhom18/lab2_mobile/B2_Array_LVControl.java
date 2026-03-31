package com.nhom18.lab2_mobile;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class B2_Array_LVControl extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        // Ánh xạ các view
        EditText etName = findViewById(R.id.etName);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        ListView lvPerson = findViewById(R.id.lv_person);
        TextView tvSelection = findViewById(R.id.tvSelection);

        // 1. Tạo ArrayList object
        ArrayList<String> names = new ArrayList<>();

        // Xây dựng Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                names
        );
        lvPerson.setAdapter(adapter);

        // 4. Xử lý sự kiện nhấn nút Nhập
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String newName = etName.getText().toString();
                if (!newName.isEmpty()) {
                    // Thêm dữ liệu mới vào arraylist
                    names.add(newName);
                    // Cập nhật dữ liệu mới lên giao diện
                    adapter.notifyDataSetChanged();
                    // Xóa trắng ô nhập liệu sau khi thêm
                    etName.setText("");
                }
            }
        });

        // 5. Xử lý sự kiện chọn một phần tử trong ListView
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvSelection.setText("position: " + position + " ; value = " + names.get(position));
            }
        });

        // 6. Xử lý sự kiện Long click để xóa phần tử
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Xóa phần tử khỏi danh sách
                names.remove(position);
                // Cập nhật lại giao diện
                adapter.notifyDataSetChanged();
                // Trả về true để báo hệ thống rằng sự kiện long click đã được xử lý xong
                return true;
            }
        });

        // 1. Ánh xạ 2 nút từ file layout_navigation_buttons.xml
        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);

        // 2. Xử lý nút Back (Quay lại Bài 1)
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng màn hình hiện tại, Android sẽ tự lùi về màn hình trước đó
                finish();
            }
        });

        // 3. Xử lý nút Next (Tiếp theo sang Bài 3)
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình Bài 3
                Intent intent = new Intent(B2_Array_LVControl.this, Bai3Activity.class);
                startActivity(intent);
            }
        });
    }
}
