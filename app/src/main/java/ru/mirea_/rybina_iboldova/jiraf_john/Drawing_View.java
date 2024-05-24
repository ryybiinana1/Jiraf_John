package ru.mirea_.rybina_iboldova.jiraf_john;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/*public class DrawingView extends View {

    private Paint paint;
    private List<Line> lines;
    private float startX, startY, stopX, stopY;
    private boolean drawing;

    public DrawingView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.holo_blue_dark));
        paint.setStrokeWidth(5);
        lines = new ArrayList<>();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for (Line line : lines) {
            canvas.drawLine(line.startX, line.startY, line.stopX, line.stopY, paint);
        }
        if (drawing) {
            canvas.drawLine(startX, startY, stopX, stopY, paint);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                drawing = true;
                break;
            case MotionEvent.ACTION_MOVE:
                stopX = event.getX();
                stopY = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                stopX = event.getX();
                stopY = event.getY();
                drawing = false;
                lines.add(new Line(startX, startY, stopX, stopY));
                invalidate();
                break;
        }
        return true;
    }

    static class Line {
        float startX, startY, stopX, stopY;

        Line(float startX, float startY, float stopX, float stopY) {
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
        }
    }
    public List<Line> getLines() {
        return lines;
    }
}*/
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Drawing_View extends View {
    private Paint paint;
    private Path path;
    private List<Path> paths;
    private float startX, startY, endX, endY;

    public Drawing_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.black));
        paint.setStrokeWidth(5);
        path = new Path();
        paths = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Path path : paths) {
            canvas.drawPath(path, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                path = new Path();
                path.moveTo(startX, startY);
                break;
            case MotionEvent.ACTION_MOVE:
                endX = event.getX();
                endY = event.getY();
                path.lineTo(endX, endY);
                break;
            case MotionEvent.ACTION_UP:
                paths.add(path);
                break;
        }
        invalidate();
        return true;
    }

    public void clearLines() {
        paths.clear();
        invalidate();
    }

    public List<Path> getPaths() {
        return paths;
    }
}