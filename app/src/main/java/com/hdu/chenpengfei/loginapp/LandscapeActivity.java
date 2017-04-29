package com.hdu.chenpengfei.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

public class LandscapeActivity extends AppCompatActivity {

    private ImageView imgLandscape;
    private TextView tvIntroduce;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape);

        imgLandscape = (ImageView) findViewById(R.id.img_landscape);
        tvIntroduce = (TextView) findViewById(R.id.tv_introduce);
        toolbar = (Toolbar) findViewById(R.id.landscape_toolbar);

        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 1);
        Landscape landscape = DataSupport.find(Landscape.class, id);
        if (landscape != null){
            imgLandscape.setBackgroundResource(getImgResourceId(id));
            tvIntroduce.setText(landscape.getIntroduce());
        }

    }

    public int getImgResourceId(int id){
        switch (id){
            case 1: return R.drawable.landscape1;
            case 2: return R.drawable.landscape2;
            case 3: return R.drawable.landscape3;
            case 4: return R.drawable.landscape4;
            case 5: return R.drawable.landscape5;
            case 6: return R.drawable.landscape6;
            case 7: return R.drawable.landscape7;
            case 8: return R.drawable.landscape8;
            case 9: return R.drawable.landscape9;
            case 10: return R.drawable.landscape10;
            default: return R.drawable.calendar;
        }
    }
}
