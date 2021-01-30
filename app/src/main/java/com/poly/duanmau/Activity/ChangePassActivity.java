package com.poly.duanmau.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.poly.duanmau.DAO.NguoiDungDao;
import com.poly.duanmau.Database.DatabaseHelper;
import com.poly.duanmau.Model.NguoiDung;
import com.poly.duanmau.R;

public class ChangePassActivity extends AppCompatActivity {
    EditText edtChangeUser, edtChangePass, edtChangeRePass;
    TextInputLayout textInputLayoutEdUser,textInputLayoutPass, textInputLayoutRePass;
    Toolbar toolbar;
    Button btndoimk, btnthoatmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        setTitle("Quản Lý Sách");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // ánh xạ
        btndoimk = findViewById(R.id.btndoimk_ChangePassWord);
        btnthoatmk = findViewById(R.id.btnthoat_ChangePassWord);
        edtChangeUser = findViewById(R.id.edt_changeUser);
        edtChangePass = findViewById(R.id.edt_changePass);
        edtChangeRePass = findViewById(R.id.edt_changeRePass);
        textInputLayoutEdUser = findViewById(R.id.textInputLayoutEdUser);
        textInputLayoutPass = findViewById(R.id.textInputLayoutPass);
        textInputLayoutRePass = findViewById(R.id.textInputLayoutRePass);

        //buuton đổi mật khẩu
        btndoimk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ChangePassActivity.this, R.anim.alpha_click);
                btndoimk.startAnimation(animation);

                NguoiDungDao nguoiDungDAO = new NguoiDungDao(ChangePassActivity.this);
                String userName = edtChangeUser.getText().toString();
                Log.e("username", userName);
                NguoiDung nguoiDung = new NguoiDung(userName, edtChangePass.getText().toString(), "", "");
                if (validateform() == 0) {
                    if (nguoiDungDAO.changePasswordNguoiDung(nguoiDung) > 0) {
                        Toast.makeText(getApplicationContext(), "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Đổi mật khẩu không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //button thoát mật khẩu
        btnthoatmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ChangePassActivity.this, R.anim.alpha_click);
                btnthoatmk.startAnimation(animation);

                edtChangePass.setText("");
                edtChangeRePass.setText("");
                edtChangeUser.setText("");
                startActivity(new Intent(ChangePassActivity.this,MainActivity.class));
            }
        });
    }

    public int validateform() {
        int check = 0;
        if (edtChangeUser.getText().toString().isEmpty() || edtChangePass.getText().toString().isEmpty() || edtChangeRePass.getText().toString().isEmpty()) {
            check = 1;
            Toast.makeText(this, "Bạn phải nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
        }else if (edtChangePass.length() < 6){
            textInputLayoutPass.setError("Bạn phải nhập mật khẩu ít nhất 6 kí tự!");
            check = 1;
        } else if (!edtChangePass.getText().toString().equals(edtChangeRePass.getText().toString())) {
            check = 1;
            textInputLayoutRePass.setError("Mật khẩu không trùng khớp!");
        }
        return check;
    }
}
