package com.ymtdata.snooker.core.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by zhangjifeng on 2018/3/29.
 * email : 414512194@qq.com
 * desc  :
 */

public class BaseFragment extends Fragment {

    protected Activity mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = getActivity();
    }
}
