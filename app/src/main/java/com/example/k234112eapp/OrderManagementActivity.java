package com.example.k234112eapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k234112eapp.models.DataWareHouse;
import com.example.k234112eapp.models.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class OrderManagementActivity extends AppCompatActivity {

    TextView txtFromDate;
    TextView txtToDate;
    ImageView imgFromDate;
    ImageView imgToDate;
    ListView lvOrder;
    ArrayList<Order> orders;
    ArrayAdapter<Order> orderAdapter;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Calendar calFromDate = Calendar.getInstance();
    Calendar calToDate = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener dateFromListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            calFromDate.set(Calendar.YEAR, year);
            calFromDate.set(Calendar.MONTH, month);
            calFromDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            txtFromDate.setText(sdf.format(calFromDate.getTime()));
        }
    };
    DatePickerDialog.OnDateSetListener dateToListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            calToDate.set(Calendar.YEAR, year);
            calToDate.set(Calendar.MONTH, month);
            calToDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            txtToDate.setText(sdf.format(calToDate.getTime()));
        }
    };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_management);

        addViews();
        addEvents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        imgFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFromDate();
            }
        });
        imgToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgClearFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orders = DataWareHouse.getOrders();
                orderAdapter.clear();
                orderAdapter.addAll(orders);
                orderAdapter.notifyDataSetChanged();
            }
        });
        img_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date fromDate = calFromDate.getTime();
                Date toDate = calToDate.getTime();
                orders = DataWareHouse.filterOrdersByDate(fromDate, toDate);
                orderAdapter.clear();
                orderAdapter.addAll(orders);
                orderAdapter.notifyDataSetChanged();

            }
            });
        }

    private void selectFromDate(){
        DatePickerDialog picker = new DatePickerDialog(this,
                dateFromListener,
                calFromDate.get(Calendar.YEAR),
                calFromDate.get(Calendar.MONTH),
                calFromDate.get(Calendar.DAY_OF_MONTH));
        );
        picker.show();
    }

    private void selectToDate() {
            DatePickerDialog picker = new DatePickerDialog(this,
                    dateToListener,
                    calToDate.get(Calendar.YEAR),
                    calToDate.get(Calendar.MONTH),
                    calToDate.get(Calendar.DAY_OF_MONTH));

            );
        picker.show();
    }

private void addViews() {
        txtFromDate = findViewById(R.id.txtFromDate);
        txtToDate = findViewById(R.id.txtToDate);
        imgFromDate = findViewById(R.id.imgFromDate);
        imgToDate = findViewById(R.id.imgToDate);
        imgClearFilter = findViewById(R.id.ic_clear_filter);
        img_filter = findViewById(R.id.ic_filter);

        lvOrder = findViewById(R.id.lvOrder);
        orders = DataWareHouse.getOrders();
        orderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orders);
        lvOrder.setAdapter(orderAdapter);;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order_status, menu);
        return true;
    }

}