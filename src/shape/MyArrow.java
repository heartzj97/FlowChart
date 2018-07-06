package shape;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class MyArrow implements Shape {

    protected double startX;
    protected double startY;
    protected double endX;
    protected double endY;

    private TextField height;
    private TextField width;
    private Button modify;
    static private double LINEWIDTH = 4;



    public void setParameter(double centerX, double centerY, double lineLength,TextField h,TextField w, Button m) {
        //可补充
        startX = centerX;
        startY = centerY;
        endX = centerX;
        endY = centerY + lineLength;
        height = h;
        width = w;
        modify = m;
    }

    @Override
    public void draw(AnchorPane anchorPane, double x, double y, TextField h, TextField w, Button m) {

        this.setParameter(x,y,40,h,w,m);

        Canvas drawCanvas = new Canvas();
        drawCanvas.setLayoutX(startX - 5);
        drawCanvas.setLayoutY(startY - 5);
        drawCanvas.setHeight(endY - startY + 5);
        drawCanvas.setWidth(10);
        anchorPane.getChildren().add(drawCanvas);
        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(LINEWIDTH);
        gc.strokeLine(5, 0, 5, endY - startY);
        gc.fillPolygon(new double[]{0, 5, 10}, new double[]{endY - startY, endY - startY + 5, endY - startY}, 3);

        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                height.setText(String.valueOf(endY - startY));
                width.setText(String.valueOf(LINEWIDTH));
                modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        gc.clearRect(0, 0, 10, endY - startY + 10);
                        endY = startY + Double.parseDouble(height.getText());
                        drawCanvas.setHeight(endY - startY + 7);
                        gc.strokeLine(5, 0, 5, endY - startY);
                        gc.fillPolygon(new double[]{0, 5, 10}, new double[]{endY - startY, endY - startY + 5, endY - startY}, 3);
                        width.setText(String.valueOf(LINEWIDTH));
                    }
                });
            }
        });
    }
}

