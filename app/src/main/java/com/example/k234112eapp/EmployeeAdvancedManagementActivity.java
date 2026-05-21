package com.example.k234112eapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k234112eapp.adapters.EmployeeAdapter;
import com.example.k234112eapp.models.Department;
import com.example.k234112eapp.models.Employee;

import java.util.ArrayList;

public class EmployeeAdvancedManagementActivity extends AppCompatActivity {

    ListView lvEmployee;
    ArrayList<Employee>listOfEmployee;
    EmployeeAdapter adapterEmployee;

    Spinner spDepartment;
    ArrayList<Department> listOfDepartment;
    ArrayAdapter<Department> adapterDepartment;
    ImageView img_add_emp, img_edit_emp, img_delete_emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_advanced_management);

        addViews();
        sampleData();
        addEvents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        spDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Department selectedDepartment=listOfDepartment.get(position);
                adapterEmployee.clear();
                adapterEmployee.addAll(selectedDepartment.getListOfEmployee());
                adapterEmployee.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        img_add_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(EmployeeAdvancedManagementActivity.this,
                        AddEmployeeActivity.class);

                startActivityForResult(intent, 999);

            }
        });
    }

    private void sampleData() {
        Department d0 = new Department("-1", "=============All===============");
        Department d1 = new Department("1", "Phong hanh chinh");
        Department d2 = new Department("2", "Phong nhan su");
        Department d3 = new Department("3", "Phong tai chinh");
        Department d4 = new Department("4", "Phong ke hoach");

        listOfDepartment.add(d0);
        listOfDepartment.add(d1);
        listOfDepartment.add(d2);
        listOfDepartment.add(d3);
        listOfDepartment.add(d4);
        adapterDepartment.notifyDataSetChanged();

        d1.addEmployee(new Employee("1", "Bamboo", "0912345678"));
        d2.addEmployee(new Employee("2", "Cuc Cu", "0912345671"));
        d3.addEmployee(new Employee("3", "Cuc Cung", "0912345672"));
        d4.addEmployee(new Employee("4", "Cuc Vang", "0912345673"));
        d4.addEmployee(new Employee("5", "Cuc Vang", "0912345673"));
        d4.addEmployee(new Employee("6", "Cuc Vang", "0912345673"));

        ArrayList<Employee> listOfEmp4 = new ArrayList<>();
        listOfEmp4.add(new Employee("7", "Ton Ngo KHong", "0912345678"));
        listOfEmp4.add(new Employee("8", "Duong Tang", "0912345678"));
        listOfEmp4.add(new Employee("9", "Jaehyun", "0912345678"));
        listOfEmp4.add(new Employee("10", "James", "0912345678"));
        d4.addListEmployee(listOfEmp4);
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

        spDepartment = findViewById(R.id.spDepartment);
        listOfDepartment = new ArrayList<>();
        adapterDepartment = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                listOfDepartment);
        adapterDepartment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDepartment.setAdapter(adapterDepartment);

        img_add_emp  = findViewById(R.id.img_add_emp);
        img_edit_emp = findViewById(R.id.img_edit_emp);
        img_delete_emp = findViewById(R.id.img_delete_emp);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == 888)
        {
            Employee emp = (Employee) data.getSerializableExtra("NEW_EMPLOYEE");
            Department pHuman = listOfDepartment.get(2);
            pHuman.addEmployee(emp);
            adapterEmployee.clear();
            adapterEmployee.addAll(pHuman.getListOfEmployee());
            adapterEmployee.notifyDataSetChanged();
        }
    }
}