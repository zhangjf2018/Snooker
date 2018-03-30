package com.ymtdata.snooker;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.ymtdata.snooker.adapter.SnookerTableGridAdapter;
import com.ymtdata.snooker.core.CustomApplication;
import com.ymtdata.snooker.core.adaper.ViewChangeAdapter;
import com.ymtdata.snooker.core.view.NoScrollViewPager;
import com.ymtdata.snooker.databinding.ActivityMainBak3Binding;
import com.ymtdata.snooker.event.click.MoreFunctionsClick;
import com.ymtdata.snooker.core.adaper.RecyclerBaseAdapter;
import com.ymtdata.snooker.model.SnookerTable;
import com.ymtdata.snooker.model.User;
import com.ymtdata.snooker.adapter.UserAdapter;
import com.ymtdata.snooker.view.FragmentHome;
import com.ymtdata.snooker.view.FragmentLadderPlayer;
import com.ymtdata.snooker.view.FragmentStand;
import com.ymtdata.snooker.test.Fragment3;
import com.ymtdata.snooker.view.FragmentStandList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class MainActivity extends AppCompatActivity implements RecyclerBaseAdapter.OnHeaderClickListener,RecyclerBaseAdapter.OnFooterClickListener {

    private UserAdapter mAdapter;
    private SnookerTableGridAdapter mSnookerTableAdapter;
    private List<User> mUsers;
    private List<Fragment> mFragment;
    private List<String> mTitle;
    private List<SnookerTable> mSnookerTables;
    private ViewChangeAdapter mmAdapter;
    private ActivityMainBak3Binding mBinding;
    int i = 0 ;

    private FragmentSkipInterface mFragmentSkipInterface;

    public void setFragmentSkipInterface(FragmentSkipInterface fragmentSkipInterface) {
        mFragmentSkipInterface = fragmentSkipInterface;
    }

    /** Fragment跳转 */
    public void skipToFragment(){
        if(mFragmentSkipInterface != null){
            mFragmentSkipInterface.gotoFragment(this.mBinding.topViewPager);
        }
    }

    public interface FragmentSkipInterface {
        /** ViewPager中子Fragment之间跳转的实现方法 */
        void gotoFragment(NoScrollViewPager viewPager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_bak3);
        mUsers = new ArrayList<>();
        mSnookerTables = new ArrayList<>();
        setData();
        mAdapter = new UserAdapter(mUsers);
        final Context cm = this;
        mSnookerTableAdapter = new SnookerTableGridAdapter(mSnookerTables);

        //初始化Fragment
        FragmentHome fragment1 = new FragmentHome();
        FragmentStand fragment2 = new FragmentStand();
        Fragment3 fragment3 = new Fragment3();
        FragmentStandList fragmentStandList = new FragmentStandList();

        //将Fragment装进列表中
        mFragment = new ArrayList<>();
        mFragment.add(fragment1);
        mFragment.add(fragment2);
        mFragment.add(fragment3);
        mFragment.add(fragmentStandList);
        mFragment.add(new FragmentLadderPlayer());

        ((CustomApplication) getApplication()).initFragmentMap(mFragment);

        //将名称添加daoTab列表
        mTitle = new ArrayList<>();
        mTitle.add("Tab1");
        mTitle.add("Tab2");
        mTitle.add("Tab3");

        //为TabLayout添加Tab名称

        mmAdapter = new ViewChangeAdapter(getSupportFragmentManager(), mFragment, mTitle);

        //ViewPager加载Adapter
        mBinding.topViewPager.setAdapter(mmAdapter);

        mBinding.topViewPager.setNoScroll(true);
        mBinding.topViewPager.setCurrentItem(0);
        ((CustomApplication) getApplication()).setmNoScrollViewPager(mBinding.topViewPager);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                i ++;
                //mBinding.topViewPager.setCurrentItem( i % 2 );
                //每隔1s循环执行run方法
                mHandler.postDelayed(this, 1000);
            }
        };


        mHandler.postDelayed(r, 100);//延时100毫秒

        //TabLayout加载ViewPager
        //mBinding.topTabLayout.setupWithViewPager(mBinding.topViewPager);

//        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
//            @Override
//            public void onInflate(ViewStub stub, View inflated) {
//
//                MainSubBinding binding2 = DataBindingUtil.bind(inflated);
//                binding2.snookerRecyclerView.setLayoutManager(new GridLayoutManager(inflated.getContext(),8));
//                binding2.snookerRecyclerView.setAdapter(mSnookerTableAdapter);
//                binding2.snookerRecyclerView.addItemDecoration(new GridDividerItemDecoration(dip2px(6), ContextCompat.getColor(inflated.getContext(), R.color.colorBrown1)));
//            }
//        });
//
//        if (!binding.viewStub.isInflated()) {
//            binding.viewStub.getViewStub().inflate();
//        }

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
//        binding.snookerRecyclerView.setLayoutManager(new GridLayoutManager(this, 8));
//        binding.snookerRecyclerView.setAdapter(mSnookerTableAdapter);
 //       binding.snookerRecyclerView.addItemDecoration(new GridDividerItemDecoration(dip2px(6), ContextCompat.getColor(this, R.color.colorBrown1)));
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAdapter.removeHeadView(0);
//            }
//        });

        mBinding.setMoreFunctionsEventClick(new MoreFunctionsClick(this, mBinding.btnMoreFunctions, mBinding.topViewPager));


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

    Handler mHandler = new Handler();


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
