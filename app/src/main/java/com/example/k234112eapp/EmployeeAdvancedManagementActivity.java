package com.example.k234112eapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k234112eapp.adapters.EmployeeAdapter;
import com.example.k234112eapp.models.Employee;

import java.util.ArrayList;

public class EmployeeAdvancedManagementActivity extends AppCompatActivity {

    ListView lvEmployee;
    ArrayList<Employee>listOfEmployee;
    EmployeeAdapter adapterEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_advanced_management);

        addViews();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        lvEmployee = findViewById(R.id.lvEmployee);
        listOfEmployee = new ArrayList<>();
        adapterEmployee = new EmployeeAdapter(this, R.layout.item_custom_employee);
        listOfEmployee.add(new Employee("1", "Nguyen Van A", "0912345678"));
        listOfEmployee.add(new Employee("2", "Nguyen Van A", "0912345678"));
        listOfEmployee.add(new Employee("3", "Nguyen Van A", "0912345678"));
        listOfEmployee.add(new Employee("4", "Nguyen Van A", "0912345678"));
        listOfEmployee.add(new Employee("5", "Nguyen Van A", "0912345678"));
        adapterEmployee.addAll(listOfEmployee);
        lvEmployee.setAdapter(adapterEmployee);
        adapterEmployee.notifyDataSetChanged();
    }
}