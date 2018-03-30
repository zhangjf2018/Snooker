package com.ymtdata.snooker.adapter;

import com.ymtdata.snooker.BR;
import com.ymtdata.snooker.R;
import com.ymtdata.snooker.core.adaper.RecyclerBaseAdapter;
import com.ymtdata.snooker.core.adaper.RecyclerViewHolder;
import com.ymtdata.snooker.model.SnookerTable;
import com.ymtdata.snooker.model.User;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class SnookerTableGridAdapter extends RecyclerBaseAdapter<SnookerTable> {

    public SnookerTableGridAdapter(List<SnookerTable> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.snooker_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.snookerTable;
    }

    @Override
    public int getItemTypePosition(int position) {
        return mData.get(position).getName() == null ? 1 : 2;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, SnookerTable item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
