package com.bb.yzbbanban.test_aidl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by YZBbanban on 2017/7/19.
 */

public class BezierView extends View {
    private Paint mPaint;
    private Path mPath;
    private Point startPoint;
    private Point endPoint;
    private Point assistPoint;


    public BezierView(Context context) {
        this(context,null);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPath = new Path();
        startPoint = new Point(50, 50);
        endPoint = new Point(300, 300);
        assistPoint = new Point(300, 500);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.reset();
        mPath.moveTo(startPoint.x, startPoint.y);
        mPath.quadTo(assistPoint.x, assistPoint.y, endPoint.x, endPoint.y);
        canvas.drawPath(mPath, mPaint);
        canvas.drawPoint(assistPoint.x, assistPoint.y, mPaint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                assistPoint.x = (int) event.getX();
                assistPoint.y = (int) event.getY();
                invalidate();
                break;
        }


        return true;
    }
}
