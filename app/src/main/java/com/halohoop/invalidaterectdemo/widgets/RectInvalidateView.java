package com.halohoop.invalidaterectdemo.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * Created by huanghaiqi on 1/12/17.
 */

public class RectInvalidateView extends View {

    private int mMeasuredWidth;
    private int mMeasuredHeight;
    private Paint mPaint;
    private int mRectWidth;
    private int mWidthDivideCount;
    private int mHeightDivideCount;
    private int mTwiceRectWidth;
    private Shape mShape;
    private Rect mMidRect;

    public RectInvalidateView(Context context) {
        this(context, null);
    }

    public RectInvalidateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectInvalidateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectWidth = 50;
        mTwiceRectWidth = mRectWidth * 2;
        mShape = Shape.CIRCLE;
    }

    public void updateRect() {
        invalidate();
    }

    public void updateAll() {
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMeasuredWidth = getMeasuredWidth();
        mMeasuredHeight = getMeasuredHeight();
        mWidthDivideCount = mMeasuredWidth / mTwiceRectWidth;
        mHeightDivideCount = mMeasuredHeight / mTwiceRectWidth;
        int midX = mMeasuredWidth >> 1;
        int midY = mMeasuredHeight >> 1;
        mMidRect = new Rect(midX - mRectWidth, midY - mRectWidth, midX + mRectWidth, midY +
                mRectWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.BLACK);

        for (int i = 0; i < mHeightDivideCount; i++) {
            int cY = mTwiceRectWidth * (0 + i);
            for (int i1 = 0; i1 < mWidthDivideCount; i1++) {
                int cX = mTwiceRectWidth * (0 + i1);
                if (mShape == Shape.CIRCLE) {
                    canvas.drawCircle(cX, cY, mRectWidth, mPaint);
                } else {
                    canvas.drawRect(cX - mRectWidth + 1, cY - mRectWidth + 1, cX + mRectWidth - 1,
                            cY + mRectWidth - 1, mPaint);
                }
            }
        }

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(mMidRect, mPaint);
    }

    enum Shape {
        CIRCLE, RECT
    }

    public void changeShape() {
        if (mShape == Shape.CIRCLE) {
            mShape = Shape.RECT;
            Toast.makeText(getContext(), "Now Rect", Toast.LENGTH_SHORT).show();
        } else {
            mShape = Shape.CIRCLE;
            Toast.makeText(getContext(), "Now Circle", Toast.LENGTH_SHORT).show();
        }
    }

    public void invalidateRect() {
        invalidate(mMidRect);
    }

}
