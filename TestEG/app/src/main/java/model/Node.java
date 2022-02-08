package model;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.List;

public class Node extends RectF { // Change to view
    public String value;
    Node parent; //if parent is null then it is on sheet of assertion
    List<Node> child;
    float level; // Determines whether it is a cut or not

    //Location
    public float x;
    public float y;

    // Appearance values
    public Paint bg = new Paint(android.R.color.darker_gray);
    int border = 3;
    public Paint textColor = new Paint ();

    public Node(float left, float top, float right, float bottom){
        this.left=left;
        this.right=right;
        this.top=top;
        this.bottom=bottom;
        init();
    }

    public Node(float x, float y){
        this.x=x;
        this.y=y;
        float radius = 100;
        this.left=x-radius;
        this.right=x+radius;
        this.top=y-radius;
        this.bottom=y+radius;
        init();
    }

    private void init(){
        textColor.setTextSize(60);
        this.value="A";
        textColor.setColor(Color.WHITE);
    }




}
