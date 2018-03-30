package com.ymtdata.snooker.adapter;

import com.ymtdata.snooker.BR;
import com.ymtdata.snooker.R;
import com.ymtdata.snooker.core.adaper.RecyclerBaseAdapter;
import com.ymtdata.snooker.core.adaper.RecyclerViewHolder;
import com.ymtdata.snooker.model.SnookerBabyModel;
import com.ymtdata.snooker.model.SnookerTable;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class SnookerTableBabyListAdapter extends RecyclerBaseAdapter<SnookerBabyModel> {

    public SnookerTableBabyListAdapter(List<SnookerBabyModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.snooker_baby_list_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.snookerBabyModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return mData.get(position).getName() == null ? 1 : 2;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, SnookerBabyModel item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
