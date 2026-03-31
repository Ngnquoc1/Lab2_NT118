package com.nhom18.lab2_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class EmployeeRecyclerAdapter extends RecyclerView.Adapter<EmployeeRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Employee> employeeList;

    public EmployeeRecyclerAdapter(Context context, ArrayList<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    // 1. Tạo View mới (chỉ gọi khi RecyclerView cần khuôn mới)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(view);
    }

    // 2. Đổ dữ liệu vào View (gọi liên tục khi cuộn danh sách)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employeeList.get(position);

        // Hiển thị tên
        if (employee.getName() != null) {
            holder.tvFullName.setText(employee.getName());
        } else {
            holder.tvFullName.setText("");
        }

        // Kiểm tra chức vụ để hiện Icon hoặc hiện chữ Staff
        if (employee.isManager()) {
            holder.ivManager.setVisibility(View.VISIBLE);
            holder.tvPosition.setVisibility(View.GONE);
        } else {
            holder.ivManager.setVisibility(View.GONE);
            holder.tvPosition.setVisibility(View.VISIBLE);
            holder.tvPosition.setText("Staff");
        }

        // Đổi màu nền xen kẽ cho 2 dòng liên tiếp
        if (position % 2 == 0) {
            holder.llParent.setBackgroundResource(R.color.white);
        } else {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }

    // 3. Trả về tổng số phần tử
    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    // Lớp ViewHolder giúp tái sử dụng View
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName, tvPosition;
        ImageView ivManager;
        LinearLayout llParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ View chỉ 1 lần duy nhất ở đây
            tvFullName = itemView.findViewById(R.id.item_employee_tv_fullname);
            tvPosition = itemView.findViewById(R.id.item_employee_tv_position);
            ivManager = itemView.findViewById(R.id.item_employee_iv_manager);
            llParent = itemView.findViewById(R.id.item_employee_ll_parent);
        }
    }
}