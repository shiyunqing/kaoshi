package com.example.myapplication2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xts.greendaodemo.db.BeanDao;

import java.util.ArrayList;

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Bean> list;

    public TwoAdapter(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_two, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getUrl()).into(viewHolder.imageTwo);
        final Boolean check = list.get(position).getCheck();

        viewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                list.get(position).setCheck(b);
            }
        });
        viewHolder.cb.setChecked(check);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if ()
            }
        });
    }

    public void delete() {
        for (Bean bean : list) {
            if (bean.getCheck()) {
                BeanDao beanDao = BaseApp.getInstance().getDaoSession().getBeanDao();
                beanDao.delete(bean);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageTwo;
        CheckBox cb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTwo = itemView.findViewById(R.id.imageTwo);
            cb = itemView.findViewById(R.id.cb);
        }
    }

  OnClickListener mOnClickListener;

    public void setmOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    interface OnClickListener{
        void mOnClickListener(boolean i);
    }
}
