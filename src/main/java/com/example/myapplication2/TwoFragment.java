package com.example.myapplication2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xts.greendaodemo.db.BeanDao;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment {
    private RecyclerView mTwoRv;
    private CheckBox mQxCb;
    private TextView mText;
    private Button mBtn;
    private TwoAdapter adapter;
    private List<Bean> beans;
    private ArrayList<Bean> list;
    private int a;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        BeanDao beanDao = BaseApp.getInstance().getDaoSession().getBeanDao();
        beans = beanDao.loadAll();
        list.addAll(beans);
        adapter.notifyDataSetChanged();

    }

    private void initView(@NonNull final View itemView) {
        mTwoRv = (RecyclerView) itemView.findViewById(R.id.rv_two);
        mTwoRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new TwoAdapter(getActivity(), list);



        mText = (TextView) itemView.findViewById(R.id.text);



        mTwoRv.setAdapter(adapter);


        mQxCb = (CheckBox) itemView.findViewById(R.id.cb_qx);
        mQxCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (mQxCb.getText().toString().equals("全选")) {
                    mQxCb.setText("取消");
                    for (int i = 0; i < TwoFragment.this.beans.size(); i++) {
                        TwoFragment.this.beans.get(i).setCheck(true);
                    }

                    mText.setText(list.size()+"/"+list.size());
                } else {
                    mQxCb.setText("全选");
                    for (int i = 0; i < TwoFragment.this.beans.size(); i++) {
                        TwoFragment.this.beans.get(i).setCheck(false);
                    }
                    a--;
                    mText.setText(list.size()+"/"+list.size());
                }

                adapter.notifyDataSetChanged();
            }
        });

        mBtn = (Button) itemView.findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.delete();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCheck()) {
                        list.remove(i);
                        i--;
                    }
                }
                if (list.size()==0){
                    mQxCb.setChecked(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            list.clear();
            initData();
            adapter.notifyDataSetChanged();
        }
    }
}
