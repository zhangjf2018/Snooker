package com.ymtdata.snooker.event.click;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.ymtdata.snooker.R;
import com.ymtdata.snooker.core.CustomApplication;
import com.ymtdata.snooker.core.utils.PopupWindowUtil;
import com.ymtdata.snooker.core.view.NoScrollViewPager;
import com.ymtdata.snooker.databinding.MoreFunctionsBinding;
import com.ymtdata.snooker.view.FragmentStand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ai on 2018/3/25.
 */
public class MoreFunctionsClick implements View.OnClickListener {

    private Context mContext;
    private PopupWindow mPopupWindow;
    private View mMopViewLoc, mChangeViews;

    public MoreFunctionsClick(Context mContext, View popViewLoc, View changeViews) {
        this.mContext = mContext;
        this.mMopViewLoc = popViewLoc;
        this.mChangeViews = changeViews;
    }
    public void popMenu(View view) {
        initPopupWindow();
    }

    @Override
    public void onClick(View view) {
        mPopupWindow.dismiss();
        ((CustomApplication)mContext.getApplicationContext()).fragmentViewChangeTo(view.getTag().toString());
    }

    class popupDismissListener implements PopupWindow.OnDismissListener{
        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }
    }

    protected void initPopupWindow(){

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        MoreFunctionsBinding mDataBinding =  DataBindingUtil.inflate(mInflater, R.layout.more_functions, null, false);
        View popupWindowView = mDataBinding.getRoot();

        int view_id = mContext.getResources().getIdentifier("tv_stand", "id", mContext.getPackageName());
        Log.e("viewId", view_id+"");
       // view_id = popupWindowView.getResources().getIdentifier("tv_ladderPlayer", "id", mContext.getPackageName());
       // Log.e("viewId", view_id+"");
      //  popupWindowView.findViewById(view_id).setVisibility(View.GONE);
        //View popupWindowView = LayoutInflater.from(mContext).inflate(R.layout.more_functions, null);
        //内容，高度，宽度
        mPopupWindow = new PopupWindow(popupWindowView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //动画效果
        mPopupWindow.setAnimationStyle(R.style.AnimationRightFade);
        //菜单背景色
        ColorDrawable dw = new ColorDrawable(0xffffffff);
        mPopupWindow.setBackgroundDrawable(dw);
        int windowPos[] = PopupWindowUtil.calculatePopWindowPos(this.mMopViewLoc, popupWindowView);
        Log.e("mPopupWindow", windowPos[1]+"");
        mPopupWindow.showAtLocation(this.mMopViewLoc, Gravity.RIGHT | Gravity.TOP, 0, windowPos[1]);

        backgroundAlpha(0.5f);
        mPopupWindow.setOnDismissListener(new popupDismissListener());
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        popupWindowView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        initClickListener(mDataBinding);

//        Button open = (Button)popupWindowView.findViewById(R.id.open);
//        Button save = (Button)popupWindowView.findViewById(R.id.save);
//        Button close = (Button)popupWindowView.findViewById(R.id.close);
//
//        open.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "Open", Toast.LENGTH_LONG).show();
//                mPopupWindow.dismiss();
//            }
//        });
    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity)mContext).getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        ((Activity)mContext).getWindow().setAttributes(lp);
    }

    private void initClickListener(MoreFunctionsBinding moreFunctionsBinding){
        moreFunctionsBinding.tvStand.setOnClickListener(this);
        moreFunctionsBinding.tvLadderPlayer.setOnClickListener(this);
        moreFunctionsBinding.tvBooking.setOnClickListener(this);
    }

}
