package shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval implements Shape {

    private double ovalX;
    private double ovalY;
    private double ovalA;
    private double ovalB;

    public MyOval(double x, double y, double a, double b) {
        ovalA = a;
        ovalB = b;
        ovalX = x;
        ovalY = y;
    }

    @Override
    public void draw(Canvas drawCanvas) {
        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(ovalX,ovalY,ovalA,ovalB);
    }
}
