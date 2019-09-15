package com.mindloggerv2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.Holder> {
    ArrayList<CategoryData> datas = new ArrayList<>();
    Context context;

    public CategoryListAdapter(ArrayList<CategoryData> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, null);
        AutoLayout.setView(v);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.Holder holder, int position) {
        CategoryData data = datas.get(position);
        Glide.with(context).load(data.res).apply(new RequestOptions().circleCrop()).into(holder.img);
//        holder.img.setImageResource(data.res);
        holder.title.setText(data.title);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.category_img);
            title = itemView.findViewById(R.id.category_text);
        }
    }
}
