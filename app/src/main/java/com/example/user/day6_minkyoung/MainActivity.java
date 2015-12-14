package com.example.user.day6_minkyoung;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    CalendarMonthView monthView;
    CalendarMonthAdapter monthViewAdapter;
    TextView monthText;
    int curYear;
    int curMonth;
    int curPosition;
    ListView listView;
    ScheduleTextListAdapter adapter;
    ArrayList<ScheduleTextItem> schedule;

    public static final int REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 월별 캘린더 뷰 객체 참조
        monthView = (CalendarMonthView) findViewById(R.id.monthView);
        monthViewAdapter = new CalendarMonthAdapter(this);
        monthView.setAdapter(monthViewAdapter);

        monthText = (TextView) findViewById(R.id.monthText);
        setMonthText();

        // 리스너 설정
        monthView.setOnDataSelectionListener(new OnDataSelectionListener() {
            public void onDataSelected(AdapterView parent, View v, int position, long id) {
                // 현재 선택한 일자 정보 표시
                MonthItem curItem = (MonthItem) monthViewAdapter.getItem(position);
                int day = curItem.getDay();
                monthViewAdapter.setSelectedPosition(position);
                monthViewAdapter.notifyDataSetChanged();
                curPosition = position;
                schedule = monthViewAdapter.getSchedule(position);
                if (schedule == null) {
                    schedule = new ArrayList<ScheduleTextItem>();
                }
                adapter.mSchedule = schedule;
                adapter.notifyDataSetChanged();
            }
        });

        // 이전 월로 넘어가는 이벤트 처리
        Button monthPrevious = (Button) findViewById(R.id.monthPrevious);
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setPreviousMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });

        // 다음 월로 넘어가는 이벤트 처리
        Button monthNext = (Button) findViewById(R.id.monthNext);
        monthNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setNextMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ScheduleTextListAdapter(this);
        listView.setAdapter(adapter);
    }

    /**
     * 월 표시 텍스트 설정
     */
    private void setMonthText() {
        curYear = monthViewAdapter.getCurYear();
        curMonth = monthViewAdapter.getCurMonth();

        monthText.setText(curYear + "년 " + (curMonth + 1) + "월");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.registration) {
            Intent intent = new Intent(this, Registration.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (intent != null) {
            if (resultCode == RESULT_OK) {
                String time = intent.getStringExtra("time");
                String content = intent.getStringExtra("content");
                ScheduleTextItem scheduleTextItem = new ScheduleTextItem(time, content);

                if (schedule == null) {
                    schedule = new ArrayList<ScheduleTextItem>();
                }

                schedule.add(scheduleTextItem);
                monthViewAdapter.setSchedule(curPosition, schedule);
                adapter.mSchedule = schedule;
                adapter.notifyDataSetChanged();
            }
        }
    }
}

