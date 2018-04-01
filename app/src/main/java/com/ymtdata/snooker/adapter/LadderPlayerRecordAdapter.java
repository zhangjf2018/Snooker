package com.ymtdata.snooker.adapter;

import com.ymtdata.snooker.BR;
import com.ymtdata.snooker.R;
import com.ymtdata.snooker.core.adaper.RecyclerBaseAdapter;
import com.ymtdata.snooker.core.adaper.RecyclerViewHolder;
import com.ymtdata.snooker.model.LadderPlayerModel;
import com.ymtdata.snooker.model.LadderPlayerRecordModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class LadderPlayerRecordAdapter extends RecyclerBaseAdapter<LadderPlayerRecordModel> {

    public LadderPlayerRecordAdapter(List<LadderPlayerRecordModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.ladder_player_record_list_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.ladderPlayerRecordModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return mData.get(position).getName() == null ? 1 : 2;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, LadderPlayerRecordModel item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
