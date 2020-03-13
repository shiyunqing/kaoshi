package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication2.presenter.Net_Presenter;
import com.example.myapplication2.view.Evec;
import com.example.myapplication2.view.Net_View;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment implements Net_View {
    private RecyclerView mRv;
    private Net_Presenter presenter;
    private List<User.ResultsBean> beans;
    private RvAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        initView(view);
        presenter = new Net_Presenter(this);
        initData();
        return view;
    }
    private void initData() {
        presenter.getData();
    }
    private void initView(@NonNull final View itemView) {
        mRv = (RecyclerView) itemView.findViewById(R.id.rv);
        mRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        beans = new ArrayList<>();
        adapter = new RvAdapter(getActivity(), beans);
        adapter.setmOnItemClickListener(new RvAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Evec evec = new Evec(position, beans);
               EventBus.getDefault().postSticky(evec);
               startActivity(new Intent(getActivity(),TwoActivity.class));

            }
        });
        mRv.setAdapter(adapter);

    }



    @Override
    public void setData(User user) {
        List<User.ResultsBean> results = user.getResults();
        beans.addAll(results);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setToast(String str) {
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
    }
}
