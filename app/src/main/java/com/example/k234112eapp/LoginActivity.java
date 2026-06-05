package com.example.k234112eapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k234112eapp.models.ListUserAccount;
import com.example.k234112eapp.models.UserAccount;

public class LoginActivity extends AppCompatActivity {

    /*
    declare all variables for interactive views
     */
    EditText edtUserName;
    EditText edtPassword;
    TextView txtMessage;
    CheckBox chkSaveLogin;
    String name_share_pref = "LoginInfo";
    RadioButton radAdmin, radEmployee;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        addViews();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        txtMessage = findViewById(R.id.txtMessage);
        chkSaveLogin = findViewById(R.id.chkSaveLogin);
        radAdmin = findViewById(R.id.radAdmin);
        radEmployee = findViewById(R.id.radEmployee);
    }

    public void loginSystem(View view) {
        String username = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();

        UserAccount uc = ListUserAccount.login(username, password);
        if (uc != null)
        {
            boolean saved = chkSaveLogin.isChecked();
            SharedPreferences preferences = getSharedPreferences(name_share_pref, MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("UserName", username);
            editor.putString("Password", password);
            editor.putBoolean("Saved", saved);
            editor.commit();

            txtMessage.setText(getString(R.string.str_login_success));
            if(radAdmin.isChecked()){
                //phai ktra account nay co quyen admin hay kh (later)
                //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Intent intent = new Intent(LoginActivity.this, OrderManagementActivity.class);
                intent.putExtra("USER_LOGIN", uc);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(LoginActivity.this, EmployeeAdvancedManagementActivity.class);
                startActivity(intent);
            }
        }
        else
        {
            txtMessage.setText(getString(R.string.str_login_failed));
        }
    }

    public void loginSystemOld(View view) {
        String username = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        if (username.equalsIgnoreCase("admin") &&
                password.equals("123"))
        {

            boolean saved = chkSaveLogin.isChecked();
            SharedPreferences preferences = getSharedPreferences(name_share_pref, MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("UserName", username);
            editor.putString("Password", password);
            editor.putBoolean("Saved", saved);
            editor.commit();

            txtMessage.setText(getString(R.string.str_login_success));
            if(radAdmin.isChecked()){
                //phai ktra account nay co quyen admin hay kh (later)


            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(LoginActivity.this, EmployeeAdvancedManagementActivity.class);
            startActivity(intent);
        }}
    }



    public void exitSystem(View view) {
        //finish();
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Confirm exit");
        builder.setMessage("Wanna die?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("YES BABI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("NAH DARLIN'", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        //neu user click chuot o ngoai thi khong tat message confirm: false
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(name_share_pref, MODE_PRIVATE);
        String username = preferences.getString("UserName", "");
        String password = preferences.getString("Password", "");
        boolean saved = preferences.getBoolean("Saved", false);
        if(saved)
        {
            edtUserName.setText(username);
            edtPassword.setText(password);
        }
        chkSaveLogin.setChecked(saved);
    }
}