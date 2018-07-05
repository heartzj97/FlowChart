package shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyDiamond implements Shape {
    private double upX;
    private double upY;
    private double leftX;
    private double leftY;
    private double downX;
    private double downY;
    private double rightX;
    private double rightY;

    public MyDiamond(double x,double y,double a,double b) {
        upX = x;
        upY = y;
        downX = x;
        downY = y+b;
        leftX = x-a/2;
        leftY = y+b/2;
        rightX = x+a/2;
        rightY = y+b/2;
    }



    @Override
    public void draw(Canvas drawCanvas) {
        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(upX,upY,leftX,leftY);
        gc.strokeLine(upX,upY,rightX,rightY);
        gc.strokeLine(downX,downY,leftX,leftY);
        gc.strokeLine(downX,downY,rightX,rightY);
    }
}
