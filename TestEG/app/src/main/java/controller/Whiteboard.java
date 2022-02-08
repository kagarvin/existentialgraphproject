package controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import model.Node;


public class Whiteboard extends View {

    Node node; // Eventually turn this into a list of nodes

    public Whiteboard(Context context) {
        super(context);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Whiteboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Whiteboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        super.onDraw(canvas);

        if(this.node!=null) {
            canvas.drawOval(this.node, node.bg);
            canvas.drawText(this.node.value,this.node.x,this.node.y,this.node.textColor);
        }

        // git pull [repository] ; ask for login info and you're good;
        // copy paste my things into that folder
        // git add .
        // git commit -m
        // git push [make sure its EG folder]

    }
}

//0xFFFF0000
