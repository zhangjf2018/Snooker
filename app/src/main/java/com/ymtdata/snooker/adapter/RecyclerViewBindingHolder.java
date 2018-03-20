package com.ymtdata.snooker.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ymtdata.snooker.BR;

/**
 * Created by ABNER on 2018/3/20.
 */

public class RecyclerViewBindingHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public RecyclerViewBindingHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public RecyclerViewBindingHolder(View itemView) {
        super(itemView);
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }
}
