package com.example.user.day6_minkyoung;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 아이템으로 보여줄 뷰 정의
 *
 * @author Mike
 */
public class ScheduleTextView extends LinearLayout {
    private Context mContext;
    private TextView content;
    private TextView time;

    public ScheduleTextView(Context context) {
        super(context);
        mContext = context;

        // Layout Inflation
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listschedule, this, true);

        content = (TextView) findViewById(R.id.schedule);
        time = (TextView) findViewById(R.id.time);
    }

    public void setTime(String time) {
        this.time.setText(time);
    }

    public void setContent(String content) {
        this.content.setText(content);
    }
}