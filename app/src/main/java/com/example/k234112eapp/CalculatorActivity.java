package com.example.k234112eapp;

import android.content.SharedPreferences;
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
    String name_share_pref = "CalcInfo";

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
                // step 1 get data
                String formula = edtFormula.getText().toString();
            // step 2 invoke library for formular (find internet)...
                try {
                    double result = evaluate(formula.replace(":", "/")); // Đổi dấu : thành / để tính toán

                    // Bước 3: Hiển thị kết quả
                    if (result == (long) result)
                        edtFormula.setText(String.format("%d", (long) result));
                    else
                        edtFormula.setText(String.valueOf(result));
                } catch (Exception e) {
                    edtFormula.setText("Error");
                }
            }

            private void addEvents() {
                // ... (giữ nguyên btnDel, btn_equal)

                // Bổ sung sự kiện cho nút C và CE (Xóa hết)
                findViewById(R.id.btnC).setOnClickListener(v -> edtFormula.setText(""));
                findViewById(R.id.btnCE).setOnClickListener(v -> edtFormula.setText(""));

                // Nút dấu chấm (.)
                findViewById(R.id.btn_dot).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        processInputData(v);
                    }
                });

                // ... (giữ nguyên m_onclick và phần gán cho txtM...)
            }

            // Hàm kiểm tra xem một ký tự có phải toán tử không
            private boolean isOperator(String s) {
                return s.equals("+") || s.equals("-") || s.equals("*") || s.equals(":");
            }

            public void processInputData(View view) {
                Button btn_clicked = (Button) view;
                String old_value = edtFormula.getText().toString();
                String input_value = btn_clicked.getText().toString();

                // Nếu đang hiển thị lỗi, xóa đi trước khi nhập mới
                if (old_value.equals("Error")) {
                    old_value = "";
                }

                // Kiểm tra tránh nhập liên tiếp 2 toán tử (Ví dụ ++ hoặc +*)
                if (isOperator(input_value) && !old_value.isEmpty()) {
                    String lastChar = old_value.substring(old_value.length() - 1);
                    if (isOperator(lastChar)) {
                        // Thay thế toán tử cũ bằng toán tử mới nhất vừa nhấn
                        old_value = old_value.substring(0, old_value.length() - 1);
                    }
                }

                // Tránh bắt đầu biểu thức bằng các dấu *, :, + (dấu - thì có thể cho phép số âm)
                if (old_value.isEmpty() && (input_value.equals("*") || input_value.equals(":") || input_value.equals("+"))) {
                    return;
                }

                edtFormula.setText(old_value + input_value);
            }
        });

        findViewById(R.id.btn_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processInputData(v); // Sử dụng lại hàm "có sẵn" của bạn
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

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences(name_share_pref, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("LastFormula", edtFormula.getText().toString());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(name_share_pref, MODE_PRIVATE);
        String lastFormula = preferences.getString("LastFormula", "");
        edtFormula.setText(lastFormula);
    }

    private double evaluate(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                return parseExpression();
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();
                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }
        }.parse();
    }
}