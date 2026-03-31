package com.nhom18.lab2_mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Bai7Activity extends AppCompatActivity {

    private ArrayList<Employee> employeeList;
    private EmployeeRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);

        // 1. Ánh xạ các view nhập liệu
        EditText etId = findViewById(R.id.etId);
        EditText etFullName = findViewById(R.id.etFullName);
        CheckBox cbManager = findViewById(R.id.cbManager);
        Button btnAdd = findViewById(R.id.btnAdd);

        // 2. Cài đặt RecyclerView
        RecyclerView rvEmployee = findViewById(R.id.rvEmployee);

        // Cực kỳ quan trọng: Thiết lập LayoutManager dạng cuộn dọc
        rvEmployee.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo danh sách và Adapter
        employeeList = new ArrayList<>();
        adapter = new EmployeeRecyclerAdapter(this, employeeList);
        rvEmployee.setAdapter(adapter);

        // 3. Xử lý nút Thêm (ADD)
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo đối tượng nhân viên mới
                Employee emp = new Employee();
                emp.setId(etId.getText().toString());
                emp.setName(etFullName.getText().toString());
                emp.setManager(cbManager.isChecked());

                // Thêm vào danh sách
                employeeList.add(emp);

                // Báo cho Adapter cập nhật (Với RecyclerView, bạn có thể dùng lệnh có hiệu ứng mượt hơn)
                // adapter.notifyItemInserted(employeeList.size() - 1);
                adapter.notifyDataSetChanged();

                // Làm sạch form nhập
                etId.setText("");
                etFullName.setText("");
                cbManager.setChecked(false);
                etId.requestFocus();
            }
        });

        // 4. Xử lý điều hướng
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        // Vì đây là bài cuối, ta ẩn nút Next đi
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setVisibility(View.GONE);
    }
}