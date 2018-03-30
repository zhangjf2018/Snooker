package com.ymtdata.snooker.test;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * email: redthree3333@gmail.com
 * author: jredthree
 * time: 2016/5/3
 */
public class RecyclerViewHolder_bak extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public RecyclerViewHolder_bak(View itemView) {
        super(itemView);
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }


}

