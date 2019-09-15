package com.mindloggerv2;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.Holder> {
    ArrayList<TimeTableData> datas = new ArrayList<>();
    View.OnClickListener onClickListener;

    public TimeTableAdapter(ArrayList<TimeTableData> datas, View.OnClickListener onClickListener) {
        this.datas = datas;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_table, null);
        AutoLayout.setView(v);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TimeTableData data = datas.get(position);
        holder.setIsRecyclable(false);
        holder.startsAt.setText(data.getStartsAt());
        holder.endsAt.setText(data.getEndsAt());
        holder.timeBody.setOnClickListener(onClickListener);
        holder.timeBody.setTag("UNSELECTED");
//        if(data.isSelected){
//            holder.timeBody.setBackgroundColor(Color.parseColor("#442393b3"));
//        } else{
//            holder.timeBody.setBackgroundColor(Color.TRANSPARENT);
//        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView startsAt;
        TextView endsAt;
        LinearLayout timeBody;
        public Holder(@NonNull View itemView) {
            super(itemView);
            startsAt = itemView.findViewById(R.id.starts);
            endsAt = itemView.findViewById(R.id.ends);
            timeBody = itemView.findViewById(R.id.time_body);
        }
    }
}
