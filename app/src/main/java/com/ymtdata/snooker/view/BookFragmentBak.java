package com.ymtdata.snooker.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joybar.librarycalendar.data.CalendarDate;
import com.joybar.librarycalendar.fragment.CalendarViewFragment;
import com.joybar.librarycalendar.fragment.CalendarViewPagerFragment;
import com.ymtdata.snooker.R;
import com.ymtdata.snooker.adapter.SnookerTableGridAdapter;
import com.ymtdata.snooker.core.base.BaseFragment;
import com.ymtdata.snooker.databinding.FragmentBookBinding;
import com.ymtdata.snooker.model.SnookerTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiudengjiao on 2017/5/8.
 */

public class BookFragmentBak extends BaseFragment implements
        CalendarViewPagerFragment.OnPageChangeListener,
        CalendarViewFragment.OnDateClickListener,
        CalendarViewFragment.OnDateCancelListener {

    private SnookerTableGridAdapter mSnookerTableAdapter;
    private List<SnookerTable> mSnookerTables;

    private List<CalendarDate> mListDate = new ArrayList<>();
    private FragmentBookBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_book, container, false);


        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        // Fragment fragment = new CalendarViewPagerFragment();
        Fragment fragment = CalendarViewPagerFragment.newInstance(true);
        tx.replace(R.id.fl_content, fragment);
        tx.commit();

        return binding.getRoot();
    }


    @Override
    public void onDateCancel(CalendarDate calendarDate) {
        int year = calendarDate.getSolar().solarYear;
        int month = calendarDate.getSolar().solarMonth;
        int day = calendarDate.getSolar().solarDay;
        binding.tvDate.setText(year + "-" + month + "-" + day);

    }

    @Override
    public void onDateClick(CalendarDate calendarDate) {
        int count = mListDate.size();
        for (int i = 0; i < count; i++) {
            CalendarDate date = mListDate.get(i);
            if (date.getSolar().solarDay == calendarDate.getSolar().solarDay) {
                mListDate.remove(i);
                break;
            }
        }
        binding.tvDate.setText(listToString(mListDate));
    }

    @Override
    public void onPageChange(int year, int month) {
        binding.tvDate.setText(year + "-" + month);
        mListDate.clear();
    }

    private static String listToString(List<CalendarDate> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (CalendarDate date : list) {
            stringBuffer.append(date.getSolar().solarYear + "-" + date.getSolar().solarMonth + "-" + date.getSolar().solarDay).append(" ");
        }
        return stringBuffer.toString();
    }
}
