package com.nhom18.lab2_mobile;

import androidx.annotation.NonNull;

public class EmployeeParttime extends Employee{
    @Override
    public double tinhLuong() {
        return 150.0;
    }
    @NonNull
    public String toString() {
        return super.toString() + " -->PartTime=" + tinhLuong();
    }
}
