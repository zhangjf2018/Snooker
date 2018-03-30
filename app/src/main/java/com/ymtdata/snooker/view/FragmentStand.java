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
import com.ymtdata.snooker.adapter.SnookerTableBabyListAdapter;
import com.ymtdata.snooker.core.CustomApplication;
import com.ymtdata.snooker.core.base.BaseFragment;
import com.ymtdata.snooker.core.utils.ListFactory;
import com.ymtdata.snooker.databinding.FragmentStandBinding;
import com.ymtdata.snooker.model.SnookerBabyModel;
import com.ymtdata.snooker.view.FragmentStandList;

/**
 * Created by qiudengjiao on 2017/5/8.
 */

public class FragmentStand extends BaseFragment implements View.OnClickListener {

    private SnookerTableBabyListAdapter mSnookerTableBabyAdapter;
    private ObservableArrayList<SnookerBabyModel> mSnookerBabyModelList;
    private ObservableArrayList<SnookerBabyModel> mSnookerBabyModelList3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentStandBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stand, container, false);

        mSnookerBabyModelList = new ObservableArrayList<>();
        mSnookerBabyModelList3 = new ObservableArrayList<>();
        setData();
        mSnookerTableBabyAdapter = new SnookerTableBabyListAdapter(mSnookerBabyModelList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(mSnookerTableBabyAdapter);

       mSnookerBabyModelList.addOnListChangedCallback(ListFactory.getListChangedCallback(mSnookerTableBabyAdapter));

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
            SnookerBabyModel st = new SnookerBabyModel();

            st.setId(i +"");
            st.setName("扎进是" + i);
            st.setNotWholeStandPrice(i+"");

            mSnookerBabyModelList.add(st);
            mSnookerBabyModelList3.add(st);
        }
       // mS
        // nookerBabyModelList = mSnookerBabyModelList2.subList(0,10);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(),"onclick",Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.tv_back:
//                final MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.setFragmentSkipInterface(new MainActivity.FragmentSkipInterface() {
//                    @Override
//                    public void gotoFragment(NoScrollViewPager viewPager) {
//                        /** 跳转到第一个页面的逻辑 */
//                        viewPager.setCurrentItem(0);
//                    }
//                });
//                /** 进行跳转 */
//                mainActivity.skipToFragment();
                ((CustomApplication) getActivity().getApplication()).getmNoScrollViewPager().setCurrentItem(0);
                break;
            case R.id.tv_stand:
                Toast.makeText(getContext(),"lll",Toast.LENGTH_SHORT).show();
                //mSnookerBabyModelList.remove(0);
                Log.e("mSnookerBabyModelList:",mSnookerBabyModelList.size()+"");
//        for(int i=0; i< mSnookerBabyModelList.size();i++){
//
//            mSnookerBabyModelList.remove(i);
//        }

                mSnookerBabyModelList.clear();
                Log.e("mSnookerBabyModelList:",mSnookerBabyModelList.size()+"");
                for(int i=0; i< 5;  ++i){
                    mSnookerBabyModelList.add(mSnookerBabyModelList3.get(i));
                }
                break;
            case R.id.tv_standList:
                Log.e("tv_standList","tv_standList");
                ((CustomApplication) getActivity().getApplication()).fragmentViewChangeTo(FragmentStandList.class);
                break;
        }
    }
}
