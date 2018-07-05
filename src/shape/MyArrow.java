package shape;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class MyArrow implements Shape {

    protected double startX;
    protected double startY;
    protected double endX;
    protected double endY;


    public MyArrow(double centerX,double centerY ,double lineLength) {
        //可补充
        startX = centerX;
        startY = centerY;
        endX = centerX;
        endY = centerY+lineLength;
    }

    @Override
    public void draw(Canvas drawCanvas) {
        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(4);
        gc.strokeLine(startX,startY,endX,endY);
        gc.fillPolygon(new double[]{endX-5,endX,endX+5},new double[]{endY,endY+5,endY},3);

    }


}
