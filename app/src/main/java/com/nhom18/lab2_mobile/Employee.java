package com.nhom18.lab2_mobile;

import androidx.annotation.NonNull;

/**
 * Base class for all employees.
 * Removed abstract to allow direct instantiation in Bai 4.
 */
public class Employee {
    private String id;
    private String name;
    private boolean isManager;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isManager() { return isManager; }
    public void setManager(boolean manager) { isManager = manager; }

    public double tinhLuong() {
        return 0;
    }

    @NonNull
    @Override
    public String toString() {
        return id + " - " + name;
    }
}