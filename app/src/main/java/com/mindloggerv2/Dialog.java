package com.mindloggerv2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Dialog extends android.app.Dialog {

    RecyclerView timeTable;
    ArrayList<TimeTableData> datas = new ArrayList<>();
    GridLayoutManager linearLayoutManager;
    TimeTableAdapter adapter;

    boolean isSelecting = false;
    boolean isSelectDone = false;
    int startIndex = -1;
    int endIndex = -1;
    OnDialogResult result;
    public Dialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        final TextView title = findViewById(R.id.title);
        AutoLayout.setView(title);

        TextView cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog.this.dismiss();
            }
        });
        AutoLayout.setView(cancel);

        final TextView booking = findViewById(R.id.booking);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "예약되었습니다.", Toast.LENGTH_SHORT).show();
                if(booking.getText().toString().equals("상담하기")) {
                    result.done("done");
                    Dialog.this.dismiss();
                }
                booking.setText("상담하기");
                booking.setTextColor(Color.parseColor("#123456"));
            }
        });
        AutoLayout.setView(booking);


        timeTable = findViewById(R.id.timetable);
        AutoLayout.setView(timeTable);
        int startsHour = 9;
        int mins = 0;
        for (int i = 0; i < 54; i++) {
            if (mins == 60) {
                mins = 0;
                startsHour += 1;
                datas.add(new TimeTableData(
                        String.format("%02d", startsHour) + ":" + String.format("%02d", mins),
                        String.format("%02d", startsHour) + ":" + String.format("%02d", mins + 10)
                ));
            } else {
                if (mins + 10 == 60) {
                    datas.add(new TimeTableData(
                            String.format("%02d", startsHour) + ":" + String.format("%02d", mins),
                            String.format("%02d", startsHour + 1) + ":" + String.format("%02d", 0)
                    ));
                } else {
                    datas.add(new TimeTableData(
                            String.format("%02d", startsHour) + ":" + String.format("%02d", mins),
                            String.format("%02d", startsHour) + ":" + String.format("%02d", mins + 10)
                    ));
                }
            }
            mins += 10;
        }

        adapter = new TimeTableAdapter(datas, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.time_body:
                        int pos = timeTable.getChildLayoutPosition(view);
                        if("SELECTED".equals(timeTable.getChildAt(pos).getTag())){
                            timeTable.getChildAt(pos).setBackgroundColor(Color.TRANSPARENT);
                            timeTable.getChildAt(pos).setTag("UNSELECTED");
                        } else{
                            timeTable.getChildAt(pos).setBackgroundColor(Color.parseColor("#442393b3"));
                            timeTable.getChildAt(pos).setTag("SELECTED");
                        }
                        break;
                }
            }
        });
        linearLayoutManager = new GridLayoutManager(getContext(), 1);
        timeTable.setLayoutManager(linearLayoutManager);
        timeTable.setAdapter(adapter);
        timeTable.addItemDecoration(new DividerItemDecoration(timeTable.getContext(), DividerItemDecoration.VERTICAL));

        adapter.notifyDataSetChanged();
    }

    public void setOnDialogResult(OnDialogResult onDialogResult) {
        result = onDialogResult;
    }

    public interface OnDialogResult {
        void done(String done);
    }
}
