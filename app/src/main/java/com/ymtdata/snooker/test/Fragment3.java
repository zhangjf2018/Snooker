package com.ymtdata.snooker.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymtdata.snooker.R;
import com.ymtdata.snooker.core.base.BaseFragment;
import com.ymtdata.snooker.databinding.Fragment3Binding;

/**
 * Created by qiudengjiao on 2017/5/8.
 */

public class Fragment3 extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Fragment3Binding binding = DataBindingUtil.inflate(inflater, R.layout.fragment3, container, false);

        return binding.getRoot();
    }
}
