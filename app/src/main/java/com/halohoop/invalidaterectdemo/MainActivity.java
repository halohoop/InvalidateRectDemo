package com.halohoop.invalidaterectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.halohoop.invalidaterectdemo.widgets.RectInvalidateView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RectInvalidateView mRiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRiv = (RectInvalidateView) findViewById(R.id.riv);
        Button change = (Button) findViewById(R.id.change);
        Button invalidate = (Button) findViewById(R.id.invalidate);
        Button invalidateRect = (Button) findViewById(R.id.invalidate_rect);
        change.setOnClickListener(this);
        invalidate.setOnClickListener(this);
        invalidateRect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change:
                mRiv.changeShape();
                break;
            case R.id.invalidate:
                mRiv.invalidate();
                break;
            case R.id.invalidate_rect:
                mRiv.invalidateRect();
                break;
        }
    }
}
