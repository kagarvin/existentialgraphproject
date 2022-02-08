package controller;

import android.annotation.SuppressLint;
import android.graphics.Canvas;

import com.example.testeg.MainActivity;

import model.Node;

public class MainController {
   private MainActivity Context;

    public MainController(MainActivity Context){
        this.Context = Context;
        System.out.print(this.Context);
    }

    public void printConsole(){
        System.out.print(Context.console.getText());
    }


    public void updateConsole(String text){
        Context.console.setText(text);
    }

    @SuppressLint("WrongCall")
    public void createNode(int x, int y){
        Whiteboard sheetOfAssertion = (Whiteboard) Context.sheetOfAssertion;

        // Needs to check as well if another node exists in this position

        Node newNode = new Node(x,y);
        Canvas newCanvas = new Canvas();

        sheetOfAssertion.setNode(newNode);

        //How to re-render?
        //sheetOfAssertion.OnDraw(newCanvas);


    }




}
