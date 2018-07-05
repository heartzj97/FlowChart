package shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MySquare implements Shape {
    private double leftUpX;
    private double leftUpY;
    private double rightUpX;
    private double rightUpY;
    private double leftDownX;
    private double leftDownY;
    private double rightDownX;
    private double rightDownY;

    public MySquare(double x, double y, double a, double b) {
        leftUpX = x-a/2;
        leftUpY = y-b/2;
        rightUpX = x+a/2;
        rightUpY = y-b/2;
        leftDownX = x-a/2;
        leftDownY = y+b/2;
        rightDownX = x+a/2;
        rightDownY = y+b/2;
    }


    @Override
    public void draw(Canvas drawCanvas) {
        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(leftUpX,leftUpY,leftDownX,leftDownY);
        gc.strokeLine(leftUpX,leftUpY,rightUpX,rightUpY);
        gc.strokeLine(rightUpX,rightUpY,rightDownX,rightDownY);
        gc.strokeLine(leftDownX,leftDownY,rightDownX,rightDownY);
    }
}
