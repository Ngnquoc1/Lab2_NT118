package com.nhom18.lab2_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Bai4Activity extends AppCompatActivity {

    private ArrayList<Employee> employeeList;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        EditText etId = findViewById(R.id.etId);
        EditText etFullName = findViewById(R.id.etFullName);
        CheckBox cbManager = findViewById(R.id.cbManager);
        Button btnAdd = findViewById(R.id.btnAdd);
        ListView lvEmployee = findViewById(R.id.lvEmployee);

        employeeList = new ArrayList<>();
        // Gọi Custom Adapter
        adapter = new EmployeeAdapter(this, R.layout.item_employee, employeeList);
        lvEmployee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee emp = new Employee();
                emp.setId(etId.getText().toString());
                emp.setName(etFullName.getText().toString());
                emp.setManager(cbManager.isChecked());

                employeeList.add(emp);
                adapter.notifyDataSetChanged();

                // Reset field
                etId.setText("");
                etFullName.setText("");
                cbManager.setChecked(false);
            }
        });

        // Xử lý nút điều hướng
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        Button btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            // Chuyển sang phần RecyclerView
            Intent intent = new Intent(Bai4Activity.this, Bai5Activity.class);
            startActivity(intent);
        });
    }
}