package com.poly.duanmau.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.poly.duanmau.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void viewNguoiDung(View view) {
        Intent intent = new Intent(MainActivity.this, ListNguoiDungActivity.class);
        startActivity(intent);
    }

    public void viewTheLoai(View view) {
        Intent intent = new Intent(MainActivity.this, ListTheLoaiActivity.class);
        startActivity(intent);
    }

    public void viewBook(View view) {
        Intent intent = new Intent(MainActivity.this, ListSachActivity.class);
        startActivity(intent);
    }

    public void ViewHoaDon(View view) {
        Intent intent = new Intent(MainActivity.this, ListHoaDonActivity.class);
        startActivity(intent);
    }

    public void ViewTopSach(View view) {
        Intent intent = new Intent(MainActivity.this, TopBookActivity.class);
        startActivity(intent);
    }

    public void ViewThongKeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ThongKeActivity.class);
        startActivity(intent);
    }
}
