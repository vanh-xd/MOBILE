package com.example.k234112eapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class EmployeeManagementActivity extends AppCompatActivity {

    Button btnExit;
    ListView lvEmployee;
    ArrayList<String>listEmployee;
    ArrayAdapter<String>adapterEmployee;
    EditText edtId, edtName, edtPhone;
    int selectedPosition = -1; // Lưu vị trí nhân viên đang được chọn


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_management);

        addViews();
        addEvents();
        loadData();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadData() {
        listEmployee.add("e1-Teo-0912345671");
        listEmployee.add("e2-Ty-0912345672");
        listEmployee.add("e3-Bin-0912345673");
        listEmployee.add("e4-Bo-0912345674");
        listEmployee.add("e5-Tun-0912345675");
        //keu adapter cap nhat giao dien
        adapterEmployee.notifyDataSetChanged();
    }

    private void addEvents() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processExit();
            }
        });
        lvEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position; // Lưu vị trí khi người dùng chọn
                displayEmployeeInfor(position);
            }
        });
    }

    private void displayEmployeeInfor(int position) {
        String data = listEmployee.get(position);
        String[] items = data.split("-");
        //hien thi items[0] --> id, items[1] --> name, items[2] --> phone
        if (items.length >= 3) {
            edtId.setText(items[0]);
            edtName.setText(items[1]);
            edtPhone.setText(items[2]);
        }
    }

    private void processExit() {
        Dialog custom = new Dialog(this);
        custom.setContentView(R.layout.custom_dialog);
        ImageView imgSave= custom.findViewById(R.id.imgYes);
        ImageView imgCancel= custom.findViewById(R.id.imgCancel);
        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom.dismiss();
            }
        });
    }

    private void addViews() {
        btnExit = findViewById(R.id.btnExit);
        lvEmployee = findViewById(R.id.lvEmployee);
        listEmployee = new ArrayList<>();
        adapterEmployee = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listEmployee);
        lvEmployee.setAdapter(adapterEmployee);

        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
    }
    public void saveEmployee(View view) {
        String id = edtId.getText().toString().trim();
        String name = edtName.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();

        if (id.isEmpty() || name.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra xem ID đã tồn tại chưa
        boolean isExist = false;
        for (String emp : listEmployee) {
            if (emp.startsWith(id + "-")) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            Toast.makeText(this, "ID " + id + " đã tồn tại, không thể thêm mới!", Toast.LENGTH_SHORT).show();
        } else {
            // Nếu chưa có thì thêm mới (cập nhật danh sách)
            String newEmployee = id + "-" + name + "-" + phone;
            listEmployee.add(newEmployee);
            adapterEmployee.notifyDataSetChanged();

            // Xóa trống các ô nhập liệu sau khi lưu
            edtId.setText("");
            edtName.setText("");
            edtPhone.setText("");
            edtId.requestFocus();
            Toast.makeText(this, "Đã lưu nhân viên thành công", Toast.LENGTH_SHORT).show();
        }
    }
    public void removeEmployee(View view) {
        // Kiểm tra nếu chưa chọn nhân viên nào từ danh sách
        if (selectedPosition == -1) {
            Toast.makeText(this, "Vui lòng chọn một nhân viên để xóa!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Hiển thị Dialog xác nhận
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận xóa");
        builder.setMessage("Bạn có chắc chắn muốn xóa nhân viên này không?");
        builder.setIcon(android.R.drawable.ic_delete);

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Xóa khỏi ArrayList
                listEmployee.remove(selectedPosition);
                // Cập nhật lại ListView
                adapterEmployee.notifyDataSetChanged();

                // Xóa trắng các ô nhập liệu
                edtId.setText("");
                edtName.setText("");
                edtPhone.setText("");
                edtId.requestFocus();

                // Reset vị trí chọn về -1
                selectedPosition = -1;

                Toast.makeText(EmployeeManagementActivity.this, "Đã xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }
}