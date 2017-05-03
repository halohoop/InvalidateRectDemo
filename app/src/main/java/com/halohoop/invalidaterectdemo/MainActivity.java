package com.halohoop.invalidaterectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.halohoop.invalidaterectdemo.widgets.FingerView;
import com.halohoop.invalidaterectdemo.widgets.RectInvalidateView;

/**
 * 需要调用View.invalidate(Rect dirty),
 * 需要让Application和activity禁用硬件加速，主要是activity需要禁用，application可不禁用
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RectInvalidateView mRiv;
    private FingerView mFv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRiv = (RectInvalidateView) findViewById(R.id.riv);
        mFv = (FingerView) findViewById(R.id.fv);
        Button change = (Button) findViewById(R.id.change);
        Button invalidate = (Button) findViewById(R.id.invalidate);
        Button invalidateRect = (Button) findViewById(R.id.invalidate_rect);
        Button change_color = (Button) findViewById(R.id.change_color);
        change.setOnClickListener(this);
        invalidate.setOnClickListener(this);
        invalidateRect.setOnClickListener(this);
        change_color.setOnClickListener(this);
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
            case R.id.change_color:
                mFv.changeColor();
                break;
        }
    }
}
