package com.ymtdata.snooker.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymtdata.snooker.R;
import com.ymtdata.snooker.adapter.SnookerTableGridAdapter;
import com.ymtdata.snooker.core.adaper.GridDividerItemDecoration;
import com.ymtdata.snooker.core.base.BaseFragment;
import com.ymtdata.snooker.databinding.FragmentHomeBinding;
import com.ymtdata.snooker.model.SnookerTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiudengjiao on 2017/5/8.
 */

public class FragmentHome extends BaseFragment {

    private SnookerTableGridAdapter mSnookerTableAdapter;
    private List<SnookerTable> mSnookerTables;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        mSnookerTables = new ArrayList<>();
        setData();
        mSnookerTableAdapter = new SnookerTableGridAdapter(mSnookerTables);
        binding.snookerRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 8));
        binding.snookerRecyclerView.setAdapter(mSnookerTableAdapter);
        binding.snookerRecyclerView.addItemDecoration(new GridDividerItemDecoration(dip2px(6), ContextCompat.getColor(getContext(), R.color.colorBrown1)));

        return binding.getRoot();
    }

    public int dip2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getResources().getDisplayMetrics());
    }

    private void setData(){

        for(int i = 0; i < 100; i++){


            SnookerTable st = new SnookerTable();

            st.setId(i +"");
            st.setName("VIP" + i);
            st.setStatus(i+"");

            mSnookerTables.add(st);
        }
    }
}
