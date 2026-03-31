package com.nhom18.lab2_mobile;

import androidx.annotation.NonNull;

public class EmployeeFulltime extends Employee {
    @Override
    public double tinhLuong() {
        return 500.0;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + " -->FullTime=" + tinhLuong();
    }
}