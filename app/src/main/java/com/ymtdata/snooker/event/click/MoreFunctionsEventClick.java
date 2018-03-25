package com.ymtdata.snooker.event.click;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.ymtdata.snooker.R;

/**
 * Created by ai on 2018/3/25.
 */
public class MoreFunctionsEventClick {

    private Context mContext;
    private PopupWindow mPopupWindow;

    public void popMenu(View view) {
        this.mContext = view.getContext();
        Toast.makeText(view.getContext(),"kkk",Toast.LENGTH_SHORT).show();
        initPopupWindow();
    }

    class popupDismissListener implements PopupWindow.OnDismissListener{

        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }

    }


    protected void initPopupWindow(){
        View popupWindowView = LayoutInflater.from(mContext).inflate(R.layout.more_functions, null);
        //内容，高度，宽度
        mPopupWindow = new PopupWindow(popupWindowView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow = new PopupWindow(popupWindowView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        //动画效果
        mPopupWindow.setAnimationStyle(R.style.AnimationLeftFade);
        //菜单背景色
        ColorDrawable dw = new ColorDrawable(0xffffffff);
        mPopupWindow.setBackgroundDrawable(dw);
        //宽度
        //popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
        //高度
        //popupWindow.setHeight(LayoutParams.FILL_PARENT);
        //显示位置
        mPopupWindow.showAtLocation(LayoutInflater.from(mContext).inflate(R.layout.activity_main_bak2, null), Gravity.RIGHT, 0, 500);

        //设置背景半透明
        backgroundAlpha(0.5f);
        //关闭事件
        mPopupWindow.setOnDismissListener(new popupDismissListener());

        popupWindowView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
    /*if( popupWindow!=null && popupWindow.isShowing()){
     popupWindow.dismiss();
     popupWindow=null;
    }*/
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                return false;
            }
        });

        Button open = (Button)popupWindowView.findViewById(R.id.open);
        Button save = (Button)popupWindowView.findViewById(R.id.save);
        Button close = (Button)popupWindowView.findViewById(R.id.close);


        open.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Open", Toast.LENGTH_LONG).show();
                mPopupWindow.dismiss();
            }
        });


    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)
    {
//        WindowManager wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.alpha = bgAlpha; //0.0-1.0
//        getWindow().setAttributes(lp);
    }
    /**
     * 菜单弹出方向
     *
     */
    public enum Location {

        LEFT,
        RIGHT,
        TOP,
        BOTTOM;

    }
}
