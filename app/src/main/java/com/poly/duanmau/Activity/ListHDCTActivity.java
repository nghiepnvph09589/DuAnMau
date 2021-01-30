package com.poly.duanmau.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.poly.duanmau.Adapter.HoaDonChiTietAdapter;
import com.poly.duanmau.DAO.HoaDonChiTietDao;
import com.poly.duanmau.Model.HoaDon;
import com.poly.duanmau.Model.HoaDonChiTiet;
import com.poly.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class ListHDCTActivity extends AppCompatActivity {
    Toolbar toolbarhdct;
    HoaDonChiTietAdapter hoaDonChiTietAdapter;
    ListView lv_hdct;
    HoaDonChiTiet hoaDonChiTiet = null;
    HoaDonChiTietDao hoaDonChiTietDAO;
    List<HoaDonChiTiet> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hdct);
        setTitle("Hóa đơn chi tiết");
        toolbarhdct = findViewById(R.id.toolbar_hoadon);
        setSupportActionBar(toolbarhdct);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        lv_hdct = findViewById(R.id.lv_hdct);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("datagui");
        String maHDnhan = bundle.getString("maHDgui");

        hoaDonChiTietDAO = new HoaDonChiTietDao(ListHDCTActivity.this);
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietDAO.getAllHoaDonChiTiet();

        for (int i = 0; i < hoaDonChiTietList.size(); i++) {
            if (hoaDonChiTietList.get(i).getHoaDon().getMaHoaDon().equals(maHDnhan)) {
                hoaDonChiTiet = hoaDonChiTietList.get(i);
                myList.add(hoaDonChiTiet);
            }
        }

        hoaDonChiTietAdapter = new HoaDonChiTietAdapter(ListHDCTActivity.this, myList);
        lv_hdct.setAdapter(hoaDonChiTietAdapter);
    }

}
