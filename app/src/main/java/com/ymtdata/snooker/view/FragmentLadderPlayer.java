package com.ymtdata.snooker.view;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ymtdata.snooker.R;
import com.ymtdata.snooker.adapter.LadderPlayerAdapter;
import com.ymtdata.snooker.adapter.SnookerTableBabyListAdapter;
import com.ymtdata.snooker.core.CustomApplication;
import com.ymtdata.snooker.core.base.BaseFragment;
import com.ymtdata.snooker.core.utils.ListFactory;
import com.ymtdata.snooker.databinding.FragmentLadderPlayerBinding;
import com.ymtdata.snooker.databinding.FragmentStandBinding;
import com.ymtdata.snooker.model.LadderPlayerModel;
import com.ymtdata.snooker.model.SnookerBabyModel;

/**
 * Created by qiudengjiao on 2017/5/8.
 */

public class FragmentLadderPlayer extends BaseFragment implements View.OnClickListener {

    private LadderPlayerAdapter mLadderPlayerAdapter;
    private ObservableArrayList<LadderPlayerModel> mLadderPlayerModelList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentLadderPlayerBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ladder_player, container, false);

        mLadderPlayerModelList = new ObservableArrayList<>();
        setData();
        mLadderPlayerAdapter = new LadderPlayerAdapter(mLadderPlayerModelList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(mLadderPlayerAdapter);

        mLadderPlayerModelList.addOnListChangedCallback(ListFactory.getListChangedCallback(mLadderPlayerAdapter));

        binding.ivRight.setOnClickListener(this);
        binding.tvBack.setOnClickListener(this);
        binding.tvStandList.setOnClickListener(this);
       // binding.recyclerView.addItemDecoration(new GridDividerItemDecoration(dip2px(6), ContextCompat.getColor(getContext(), R.color.colorBrown1)));
        return binding.getRoot();
    }

    public int dip2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getResources().getDisplayMetrics());
    }

    private void setData(){

        for(int i = 0; i < 100; i++){
            LadderPlayerModel st = new LadderPlayerModel();

            st.setId(i +"");
            st.setName("扎进是" + i);
            st.setGender(i+"");

            mLadderPlayerModelList.add(st);
        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(),"onclick",Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.tv_back:
                ((CustomApplication) getActivity().getApplication()).fragmentViewChangeTo(FragmentHome.class);
                break;
            case R.id.tv_standList:
                Log.e("tv_standList","tv_standList");
                ((CustomApplication) getActivity().getApplication()).fragmentViewChangeTo(FragmentStandList.class);
                break;
        }
    }
}
