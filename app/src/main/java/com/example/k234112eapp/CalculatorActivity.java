package com.example.k234112eapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    EditText edtFormula;
    Button btnDel, btn_equal;
    TextView txtMC, txtMR, txtMPlus, txtMMinus, txtMS, txtM;

    View.OnClickListener m_onclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        addViews();
        addEvents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get current data;
                String current_data=edtFormula.getText().toString();
                //remove last character
                String new_value="";
                if(current_data.length()>1)
                {
                    new_value=current_data.substring(0,current_data.length()-1);
                }
                edtFormula.setText(new_value);
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                // setp 1 get data
            String formular = edtFormula.getText().toString();
            // step 2 invoke library for formular (find internet)...
            String result = "";
            // result = library_nao_do(formular)
            // step3
            edtFormula.setText(result);
        }
    });

        m_onclick = new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            if(view.equals(txtM))
            {
                //khach hang nhan txtM
            }
            else if (view.equals(txtMMinus))
            {
                // khach hang nhan txtMMinus
            }
            else if (view.equals(txtMPlus))
            {
                // khach hang nhan txtMPlus
            }
            else if (view.equals(txtMR))
            {
                // khach hang nhan txtMR
            }
            else if (view.equals(txtMS))
            {
                // khach hang nhan txtMS
            }
            else if (view.equals(txtMC))
            {
                // khach hang nhan txtMC
            }// kh dung dau == de so sanh vi no kh hieu so sanh o nho khi dung ==
        }
        };
        // m_onclick la bien co kha nang sinh su kien var as listener
        // thuong dung de sharing su kien tu 2 views tro len
        txtM.setOnClickListener(m_onclick);
        txtMMinus.setOnClickListener(m_onclick);
        txtMPlus.setOnClickListener(m_onclick);
        txtMR.setOnClickListener(m_onclick);
        txtMS.setOnClickListener(m_onclick);
        txtMC.setOnClickListener(m_onclick);
    }

    private void addViews() {
        edtFormula = findViewById(R.id.edtFormula);
        btnDel = findViewById(R.id.btnDel);
        btn_equal = findViewById(R.id.btn_equal);

        txtMC = findViewById(R.id.txtMC);
        txtMR = findViewById(R.id.txtMR);
        txtMPlus = findViewById(R.id.txtMPlus);
        txtMMinus = findViewById(R.id.txtMMinus);
        txtMS = findViewById(R.id.txtMS);
        txtM = findViewById(R.id.txtM);

    }

    public void processInputData(View view) {
        Button btn_clicked = (Button) view;
        // old value:
        String old_value = edtFormula.getText().toString();
        // new value:
        String input_value = btn_clicked.getText().toString();
        // new value (lasted value):
        String new_value = old_value + input_value;
        // show value for customer:
        edtFormula.setText(new_value);
    }
}