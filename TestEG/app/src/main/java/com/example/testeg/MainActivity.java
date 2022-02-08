package com.example.testeg;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import controller.MainController;

public class MainActivity extends AppCompatActivity {

    public MainController controller;

    //Objects
    public View sheetOfAssertion;
    public TextView console;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Controller
        this.controller = new MainController(this);

        setContentView(R.layout.activity_main);

        this.console = this.findViewById(R.id.Console);
        this.sheetOfAssertion = this.findViewById(R.id.whiteboard);

        //Testing
        controller.updateConsole("Testing Value");

        // User Interaction
        sheetOfAssertion.setOnTouchListener((view, motionEvent) -> {
            int startX ;
            int startY ;
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                startX = (int) motionEvent.getX();
                startY = (int) motionEvent.getY();

                controller.updateConsole("START X:" + Float.valueOf(startX).toString() + "\n START Y:" + Float.valueOf(startY).toString());

                controller.createNode(startX,startY);


                return true;
            }

            return false;
        });

    }


}