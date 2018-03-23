package com.ymtdata.snooker.adapter;

import com.ymtdata.snooker.BR;
import com.ymtdata.snooker.R;
import com.ymtdata.snooker.core.adaper.RecyclerBaseAdapter;
import com.ymtdata.snooker.core.adaper.RecyclerViewHolder;
import com.ymtdata.snooker.model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/2/28.
 */
public class UserAdapter extends RecyclerBaseAdapter<User> {

    public UserAdapter(List<User> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        switch (viewType){
            case 1:
                return R.layout.main_item;
            case 2:
                return R.layout.main_item2;
            default:
                return R.layout.main_item;
        }


    }

    @Override
    public int getVariableId(int viewType) {
        switch (viewType){
            case 1:
                return BR.users;
            case 2:
                return BR.titles;
            default:
                return BR.users;
        }

    }

    @Override
    public int getItemTypePosition(int position) {
        return mData.get(position).getTitle() == null ? 1 : 2;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, User item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
