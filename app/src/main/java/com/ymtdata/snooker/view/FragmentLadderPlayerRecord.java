package com.ymtdata.snooker.view;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymtdata.snooker.R;
import com.ymtdata.snooker.adapter.LadderPlayerRecordAdapter;
import com.ymtdata.snooker.core.CustomApplication;
import com.ymtdata.snooker.core.base.BaseFragment;
import com.ymtdata.snooker.core.utils.ListFactory;
import com.ymtdata.snooker.databinding.FragmentLadderPlayerBinding;
import com.ymtdata.snooker.databinding.FragmentLadderPlayerRecordBinding;
import com.ymtdata.snooker.model.LadderPlayerRecordModel;

/**
 * Created by qiudengjiao on 2017/5/8.
 */

public class FragmentLadderPlayerRecord extends BaseFragment implements View.OnClickListener {

    private LadderPlayerRecordAdapter mLadderPlayerRecordAdapter;
    private ObservableArrayList<LadderPlayerRecordModel> mLadderPlayerRecordModelList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentLadderPlayerRecordBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ladder_player_record, container, false);

        mLadderPlayerRecordModelList = new ObservableArrayList<>();
        setData();
        mLadderPlayerRecordAdapter = new LadderPlayerRecordAdapter(mLadderPlayerRecordModelList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(mLadderPlayerRecordAdapter);

        mLadderPlayerRecordModelList.addOnListChangedCallback(ListFactory.getListChangedCallback(mLadderPlayerRecordAdapter));

        binding.ivRight.setOnClickListener(this);
        binding.tvBack.setOnClickListener(this);

       // binding.recyclerView.addItemDecoration(new GridDividerItemDecoration(dip2px(6), ContextCompat.getColor(getContext(), R.color.colorBrown1)));
        return binding.getRoot();
    }

    public int dip2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getResources().getDisplayMetrics());
    }

    private void setData(){

        for(int i = 0; i < 100; i++){
            LadderPlayerRecordModel st = new LadderPlayerRecordModel();

            st.setId(i +"");
            st.setName("扎进是" + i);
            st.setGender(i+"");

            mLadderPlayerRecordModelList.add(st);
        }
    }

    @Override
    public void onClick(View view) {
          ((CustomApplication) getActivity().getApplication()).fragmentViewChangeTo(view.getTag().toString());
    }
}
