package com.ymtdata.snooker;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.ymtdata.snooker.adapter.SnookerTableAdapter;
import com.ymtdata.snooker.core.adaper.DividerGridItemDecoration;
import com.ymtdata.snooker.core.adaper.RecyclerViewDivider;
import com.ymtdata.snooker.core.adaper.SpacesItemDecoration;
import com.ymtdata.snooker.databinding.ActivityMainBak2Binding;
import com.ymtdata.snooker.databinding.ActivityMainBakBinding;
import com.ymtdata.snooker.model.Header;
import com.ymtdata.snooker.core.adaper.RecyclerBaseAdapter;
import com.ymtdata.snooker.model.RecyclerModel;
import com.ymtdata.snooker.model.SnookerTable;
import com.ymtdata.snooker.model.User;
import com.ymtdata.snooker.adapter.UserAdapter;
import com.ymtdata.snooker.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import static android.widget.GridLayout.VERTICAL;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class MainActivity extends AppCompatActivity implements RecyclerBaseAdapter.OnHeaderClickListener,RecyclerBaseAdapter.OnFooterClickListener {

    private UserAdapter mAdapter;
    private SnookerTableAdapter mSnookerTableAdapter;
    private List<User> mUsers;
    private List<SnookerTable> mSnookerTables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBak2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_bak2);
        mUsers = new ArrayList<>();
        mSnookerTables = new ArrayList<>();
        setData();
        mAdapter = new UserAdapter(mUsers);
        mSnookerTableAdapter = new SnookerTableAdapter(mSnookerTables);
 //      RecyclerModel<Header> recyclerModel1 = new RecyclerModel<>(R.layout.header_item_1, com.ymtdata.snooker.BR.header1,new Header("我是头部1"));
//        RecyclerModel<Header> recyclerModel2 = new RecyclerModel<>(R.layout.header_item_1, com.ymtdata.snooker.BR.header1,new Header("我是头部2"));

      // mAdapter.addHeadView(recyclerModel1);
        //mAdapter.addHeadView(recyclerModel2);

//        RecyclerModel<Header> recyclerModel3 = new RecyclerModel<>(R.layout.header_item_1, com.ymtdata.snooker.BR.header1,new Header("我是尾部1"));
//        RecyclerModel<Header> recyclerModel4 = new RecyclerModel<>(R.layout.header_item_1, com.ymtdata.snooker.BR.header1,new Header("我是尾部2"));
//        mAdapter.addFootView(recyclerModel3);
//        mAdapter.addFootView(recyclerModel4);
//
//        mAdapter.setHeaderClickListener(this);
//        mAdapter.setFooterClickListener(this);
        //设置布局管理器
        binding.snookerRecyclerView.setLayoutManager(new GridLayoutManager(this, 8, GridLayoutManager.VERTICAL, false ));
        binding.snookerRecyclerView.setAdapter(mSnookerTableAdapter);
      //  binding.snookerRecyclerView.addItemDecoration(new RecyclerViewDivider(this, GridLayoutManager.HORIZONTAL, 10, ContextCompat.getColor(this, R.color.colorBrown)));
binding.snookerRecyclerView.addItemDecoration(new SpacesItemDecoration(dip2px(6), dip2px(6), ContextCompat.getColor(this, R.color.colorBrown1)));
 //       binding.snookerRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAdapter.removeHeadView(0);
//            }
//        });

        mSnookerTableAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("TAG","---"+position);
            }
        });
        mAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("TAG","---"+position);
            }
        });

    }
    public int dip2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getResources().getDisplayMetrics());
    }
    private void setData(){

        for(int i = 0; i < 100; i++){
            User user = new User();
            if(i==5){
                user.setTitle("标题");
            }
            user.setAvatar("http://g.hiphotos.baidu.com/image/h%3D200/sign=4d3fabc3cbfc1e17e2bf8b317a91f67c/6c224f4a20a446230761b9b79c22720e0df3d7bf.jpg");
            user.setName("小米" + i);
            user.setAge(String.valueOf(i));
            mUsers.add(user);

            SnookerTable st = new SnookerTable();

            st.setId(i +"");
            st.setName("VIP" + i);
            st.setStatus(i+"");

            mSnookerTables.add(st);
        }
    }

    @Override
    public void headerClick(View view, int position) {
        switch (position){
            case 0:
                Toast.makeText(this,"我是头部"+position,Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this,"我是头部"+position,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void footerClick(View view, int position) {
        switch (position){
            case 0:
                Toast.makeText(this,"我是尾部"+position,Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this,"我是尾部"+position,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 加载图片方法
     * @param view
     * @param url
     */
    @BindingAdapter({"imageUrl","error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Picasso.with(view.getContext()).load(url).error(error).into(view);
    }
}
