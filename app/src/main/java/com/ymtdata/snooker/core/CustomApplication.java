package com.ymtdata.snooker.core;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.ymtdata.snooker.core.view.NoScrollViewPager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangjifeng on 2018/3/30.
 * email : 414512194@qq.com
 * desc  :
 */

public class CustomApplication extends Application {

    private static Application instance;
    private NoScrollViewPager mNoScrollViewPager;
    private Map<String,Integer> mFragmentMap = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application getInstance(){
        return instance;
    }

    public void setmNoScrollViewPager(NoScrollViewPager mNoScrollViewPager) {
        this.mNoScrollViewPager = mNoScrollViewPager;
    }
    public NoScrollViewPager getmNoScrollViewPager() {
        return mNoScrollViewPager;
    }

    public void initFragmentMap(List<Fragment> list){
        for(int i=0; i< list.size(); ++i){
            Fragment f = list.get(i);
            Log.e("initFragmentMap",f.getClass().getSimpleName() + ":"+ f.getClass().getName());
            mFragmentMap.put(f.getClass().getSimpleName(),i);
        }
    }

    public void fragmentViewChangeTo(Class cl){
        String fragmentName = cl.getSimpleName();
        int viewPagerIndex = mFragmentMap.get(fragmentName);
        mNoScrollViewPager.setCurrentItem(viewPagerIndex);
    }

    public void fragmentViewChangeTo(String fragmentName){
        int viewPagerIndex = mFragmentMap.get(fragmentName);
        mNoScrollViewPager.setCurrentItem(viewPagerIndex);
    }
}
