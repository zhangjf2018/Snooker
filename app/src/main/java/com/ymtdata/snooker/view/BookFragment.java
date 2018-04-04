package com.ymtdata.snooker.view;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import com.joybar.librarycalendar.data.CalendarDate;
import com.joybar.librarycalendar.fragment.CalendarViewFragment;
import com.joybar.librarycalendar.fragment.CalendarViewPagerFragment;
import com.ymtdata.snooker.R;
import com.ymtdata.snooker.adapter.SnookerTableGridAdapter;
import com.ymtdata.snooker.constant.DateFormatConstant;
import com.ymtdata.snooker.core.base.BaseFragment;
import com.ymtdata.snooker.core.utils.DateUtil;
import com.ymtdata.snooker.databinding.FragmentBookBinding;
import com.ymtdata.snooker.model.SnookerTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiudengjiao on 2017/5/8.
 */

public class BookFragment extends BaseFragment implements
        CalendarView.OnDateSelectedListener,
        CalendarView.OnYearChangeListener,
        View.OnClickListener,
        SeekBar.OnSeekBarChangeListener{

    private SnookerTableGridAdapter mSnookerTableAdapter;
    private List<SnookerTable> mSnookerTables;

    private List<CalendarDate> mListDate = new ArrayList<>();
    private FragmentBookBinding binding;
    private int mYear;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_book, container, false);

        binding.tvMonthYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.calendarLayout.isExpand()) {
                    binding.calendarView.showYearSelectLayout(mYear);
                    return;
                }
                binding.calendarView.showYearSelectLayout(mYear);
            }
        });
        binding.flCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.calendarView.scrollToCurrent();
            }
        });

        binding.calendarView.setOnDateSelectedListener(this);
        binding.calendarView.setOnYearChangeListener(this);
        mYear = binding.calendarView.getCurYear();
        binding.tvMonthYear.setText(formatMonth(binding.calendarView.getCurMonth()) + "月" + binding.calendarView.getCurYear() + "年");
        binding.tvCurrentDay.setText(String.valueOf(binding.calendarView.getCurDay()));
        binding.tvArrLeft.setOnClickListener(this);
        binding.tvArrRight.setOnClickListener(this);
        List<Calendar> schemes = new ArrayList<>();
        int year = binding.calendarView.getCurYear();
        int month = binding.calendarView.getCurMonth();

        binding.tvBookDate.setText(DateUtil.getDate(DateFormatConstant.YYYY_MM_DD));
        binding.tvBookTime.setText(DateUtil.getDate(DateFormatConstant.HH_MM));

//        schemes.add(getSchemeCalendar(year, month, 3, 0xFF40db25, "假"));
//        schemes.add(getSchemeCalendar(year, month, 6, 0xFFe69138, "事"));
//        schemes.add(getSchemeCalendar(year, month, 9, 0xFFdf1356, "议"));
//        schemes.add(getSchemeCalendar(year, month, 13, 0xFFedc56d, "记"));
//        schemes.add(getSchemeCalendar(year, month, 14, 0xFFedc56d, "记"));
//        schemes.add(getSchemeCalendar(year, month, 15, 0xFFaacc44, "假"));
//        schemes.add(getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记"));
//        schemes.add(getSchemeCalendar(year, month, 25, 0xFF13acf0, "假"));
//        binding.calendarView.setSchemeDate(schemes);


        binding.sbHour.setOnSeekBarChangeListener(this);
        binding.sbMin.setOnSeekBarChangeListener(this);
        binding.ivHourAdd.setOnClickListener(this);
        binding.ivHourMinus.setOnClickListener(this);
        binding.ivMinAdd.setOnClickListener(this);
        binding.ivMinMinus.setOnClickListener(this);

        binding.sbHour.setProgress(DateUtil.getCurrHour());
        binding.sbMin.setProgress(DateUtil.getCurrMin());

        return binding.getRoot();
    }

    private String formatMonth(int month){
        return String.format("%02d",month);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        binding.tvBookDate.setText( calendar.getYear() + "-"+formatMonth(calendar.getMonth())+"-"+formatMonth(calendar.getDay()) );
        binding.tvMonthYear.setText(formatMonth(calendar.getMonth()) + "月" + calendar.getYear() + "年");
        mYear = calendar.getYear();
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        return calendar;
    }
    @Override
    public void onYearChange(int year) {
    }


    @Override
    public void onClick(View v) {
        int progress = 0;
        switch (v.getId()){
            case R.id.tv_arrLeft:
                binding.calendarView.scrollToPre();
                break;
            case R.id.tv_arrRight:
                binding.calendarView.scrollToNext();
                break;

            case R.id.iv_hourAdd:
                progress= binding.sbHour.getProgress();
                binding.sbHour.setProgress(progress + 1);
                break;

            case R.id.iv_hourMinus:
                progress = binding.sbHour.getProgress();
                binding.sbHour.setProgress(progress - 1);
                break;

            case R.id.iv_minAdd:
                progress= binding.sbMin.getProgress();
                binding.sbMin.setProgress(progress + 1);
                break;

            case R.id.iv_minMinus:
                progress = binding.sbMin.getProgress();
                binding.sbMin.setProgress(progress - 1);
                break;
        }

        binding.tvBookTime.setText(formatMonth(binding.sbHour.getProgress())+":"+formatMonth(binding.sbMin.getProgress()));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        binding.tvSelectTime.setText(binding.sbHour.getProgress()+" 点 " + binding.sbMin.getProgress()+ " 分");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
