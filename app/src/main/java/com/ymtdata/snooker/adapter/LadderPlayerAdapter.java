package com.ymtdata.snooker.adapter;

import com.ymtdata.snooker.BR;
import com.ymtdata.snooker.R;
import com.ymtdata.snooker.core.adaper.RecyclerBaseAdapter;
import com.ymtdata.snooker.core.adaper.RecyclerViewHolder;
import com.ymtdata.snooker.model.LadderPlayerModel;
import com.ymtdata.snooker.model.StandListModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class LadderPlayerAdapter extends RecyclerBaseAdapter<LadderPlayerModel> {

    public LadderPlayerAdapter(List<LadderPlayerModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.ladder_player_list_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.ladderPlayerModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return mData.get(position).getName() == null ? 1 : 2;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, LadderPlayerModel item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
