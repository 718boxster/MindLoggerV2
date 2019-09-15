package com.mindloggerv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Schedule extends AppCompatActivity implements View.OnClickListener {

    TextView d1;
    TextView d2;
    TextView d3;
    TextView d4;
    TextView d5;
    TextView d6;
    TextView d7;
    TextView d8;
    TextView d9;
    TextView d10;
    TextView d11;
    TextView d12;
    TextView d13;
    TextView d14;
    TextView d15;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        d7 = findViewById(R.id.d7);
        d8 = findViewById(R.id.d8);
        d9 = findViewById(R.id.d9);
        d10 = findViewById(R.id.d10);
        d11 = findViewById(R.id.d11);
        d12 = findViewById(R.id.d12);
        d13 = findViewById(R.id.d13);
        d14 = findViewById(R.id.d14);
        d15 = findViewById(R.id.d15);

        d1.setOnClickListener(this);
        d2.setOnClickListener(this);
        d3.setOnClickListener(this);
        d4.setOnClickListener(this);
        d5.setOnClickListener(this);
        d6.setOnClickListener(this);
        d7.setOnClickListener(this);
        d8.setOnClickListener(this);
        d9.setOnClickListener(this);
        d10.setOnClickListener(this);
        d11.setOnClickListener(this);
        d12.setOnClickListener(this);
        d13.setOnClickListener(this);
        d14.setOnClickListener(this);
        d15.setOnClickListener(this);


        AutoLayout.setResizeView(this);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Schedule.this, Chat.class);
                    startActivity(intent);
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public void onClick(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setOnDialogResult(new Dialog.OnDialogResult() {
            @Override
            public void done(String done) {
                if (ContextCompat.checkSelfPermission(Schedule.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(Schedule.this,
                            new String[]{Manifest.permission.CAMERA},
                            1);
                } else {
                    Intent intent = new Intent(Schedule.this, Chat.class);
                    startActivity(intent);
                }
            }
        });
        dialog.show();
    }
}
