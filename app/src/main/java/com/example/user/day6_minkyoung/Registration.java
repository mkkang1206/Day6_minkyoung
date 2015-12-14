package com.example.user.day6_minkyoung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Registration extends Activity {
    EditText content;
    EditText time;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        time = (EditText) findViewById(R.id.time02);
        content = (EditText) findViewById(R.id.content02);
        intent = new Intent();
    }

    public void onButton1Clicked(View v) {
        intent.putExtra("time", time.getText().toString());
        intent.putExtra("content", content.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onButton2Clicked(View v) {
        finish();
    }
}
