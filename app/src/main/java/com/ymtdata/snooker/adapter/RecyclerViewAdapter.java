package com.ymtdata.snooker.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ymtdata.snooker.BR;
import com.ymtdata.snooker.model.Desktop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABNER on 2018/3/20.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewBindingHolder> {

    List<BindingAdapterItem> items = new ArrayList<>();
    public interface MyItemClickListener {
        public void onItemClick(View view, int position);
    }
    private MyItemClickListener myItemClickListener;

    public List<BindingAdapterItem> getItems() {
        return items;
    }

    public void setItems(List<BindingAdapterItem> items) {
        this.items = items;
    }

    @Override
    public RecyclerViewBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new RecyclerViewBindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewBindingHolder holder, int position) {
        holder.itemView.setOnClickListener(getClickListener(holder.itemView,position));
       // holder.getBinding().setVariable(BR., items.get(position));
        holder.getBinding().executePendingBindings();
      //  holder.bindData(items.get(position));
    }

//    private void bindData(RecyclerViewBindingHolder holder,int variableId ,T item){
//        holder.getBinding().setVariable(variableId, item);
//        holder.getBinding().executePendingBindings();
//    }

    public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }

    private View.OnClickListener getClickListener(final View view, final int pos){

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( null != myItemClickListener) {
                    myItemClickListener.onItemClick(view, pos);
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getViewType();
    }
}
