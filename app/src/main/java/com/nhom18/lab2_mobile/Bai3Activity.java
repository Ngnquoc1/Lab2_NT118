package com.nhom18.lab2_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Bai3Activity extends AppCompatActivity {

    private EditText etId, etName;
    private RadioGroup rgType;
    private ArrayList<Employee> employees;
    private ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        // Ánh xạ các thành phần giao diện
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        rgType = findViewById(R.id.rgType);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        ListView lvEmployee = findViewById(R.id.lvEmployee);

        // Khởi tạo danh sách và Adapter
        employees = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        lvEmployee.setAdapter(adapter);

        // Xử lý sự kiện nhấn nút Nhập NV
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmployee();
            }
        });

        // Xử lý thanh điều hướng
        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại màn hình trước đó
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Bài 4. Đảm bảo bạn đã tạo class Bai4Activity.
                Intent intent = new Intent(Bai3Activity.this, Bai4Activity.class);
                startActivity(intent);
            }
        });
    }

    // Hàm xử lý thêm một nhân viên mới
    private void addNewEmployee() {
        // Lấy ra đúng id của Radio Button được checked
        int radId = rgType.getCheckedRadioButtonId();
        String id = etId.getText().toString();
        String name = etName.getText().toString();

        Employee employee;

        if (radId == R.id.rd_chinhthuc) {
            // Tạo instance là FullTime
            employee = new EmployeeFulltime();
        } else {
            // Tạo instance là Parttime
            employee = new EmployeeParttime();
        }

        // FullTime hay Parttime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);

        // Đưa employee vào ArrayList
        employees.add(employee);

        // Cập nhật giao diện
        adapter.notifyDataSetChanged();

        // Reset ô nhập liệu cho người dùng nhập tiếp
        etId.setText("");
        etName.setText("");
        etId.requestFocus();
    }
}