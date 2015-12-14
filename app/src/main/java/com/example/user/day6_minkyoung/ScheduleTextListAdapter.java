package com.example.user.day6_minkyoung;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * 어댑터 클래스 정의
 *
 * @author Mike
 */
public class ScheduleTextListAdapter extends BaseAdapter {

    private Context mContext;
    public ArrayList<ScheduleTextItem> mSchedule;

    public ScheduleTextListAdapter(Context context) {
        mContext = context;
        mSchedule = new ArrayList<ScheduleTextItem>();
    }

    public int getCount() {
        return mSchedule.size();
    }


    @Override
    public Object getItem(int position) {
        return mSchedule.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ScheduleTextView textView;
        if (convertView == null) {
            textView = new ScheduleTextView(mContext);
        } else {
            textView = (ScheduleTextView) convertView;
        }
        ScheduleTextItem curItem = (ScheduleTextItem) mSchedule.get(position);
        textView.setTime(curItem.getTime());
        textView.setContent(curItem.getContent());
        return textView;
    }

}
