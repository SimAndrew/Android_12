package com.example.andre.myapplication;

import android.accessibilityservice.GestureDescription;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private TextView txt;
    private GestureDetectorCompat gd;

    private AutoCompleteTextView actv;
    private String [] cars = new String[] {
            "Saab",
            "Volvo",
            "BMW",
            "Audi",
            "Ford",
            "Porche",
            "Mercedes-Benz"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.field);
        gd = new GestureDetectorCompat(this, this);
        gd.setOnDoubleTapListener(this);

        actv = (AutoCompleteTextView)findViewById(R.id.Complete);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, cars);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        txt.setText("onLongPress: " + motionEvent.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
