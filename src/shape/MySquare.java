package shape;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

    private TextField height;
    private TextField width;
    private Button modify;

    public void setParameter(double x, double y, double a, double b,TextField h,TextField w,Button m) {
        leftUpX = x-a/2;
        leftUpY = y;
        rightUpX = x+a/2;
        rightUpY = y;
        leftDownX = x-a/2;
        leftDownY = y+b;
        rightDownX = x+a/2;
        rightDownY = y+b;
        height = h;
        width = w;
        modify = m;
    }

    @Override
    public void draw(AnchorPane anchorPane, double x, double y, TextField h, TextField w, Button m) {
        this.setParameter(x, y, 120, 80, h, w, m);

        Canvas drawCanvas = new Canvas();
        drawCanvas.setLayoutX(leftUpX-2);
        drawCanvas.setLayoutY(leftUpY-2);
        drawCanvas.setHeight(leftDownY - leftUpY+2);
        drawCanvas.setWidth(rightUpX - leftUpX+2);

        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.strokeLine(1, 1, 1, leftDownY - leftUpY);
        gc.strokeLine(1, 1, rightDownX - leftDownX, 1);
        gc.strokeLine(rightDownX-leftDownX, rightDownY-leftUpY, 1, leftDownY - leftUpY);
        gc.strokeLine(rightDownX-leftDownX, rightDownY-leftUpY, rightDownX - leftDownX, 1);

        anchorPane.getChildren().add(drawCanvas);
        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if(event.getClickCount()==2) {
                    TextArea textArea = new TextArea();
                    textArea.setLayoutX(leftUpX+6);
                    textArea.setLayoutY(leftUpY+6);
                    textArea.setPrefSize(rightUpX-leftUpX-15,leftDownY-leftUpY-15);
                    anchorPane.getChildren().add(textArea);
                }
                else if(event.getClickCount()==1) {
                    height.setText(String.valueOf(leftDownY-leftUpY));
                    width.setText(String.valueOf(rightDownX-leftDownX));
                    modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gc.clearRect(0,0,rightDownX-leftDownX+2,leftDownY-leftUpY+2);
                            double h = Double.parseDouble(height.getText());
                            double w = Double.parseDouble(width.getText());
                            drawCanvas.setHeight(h+2);
                            drawCanvas.setWidth(w+2);
                            leftDownY = rightDownY = leftUpY+h;
                            rightDownX = rightUpX = leftUpX+w;

                            gc.strokeLine(1, 1, 1, leftDownY - leftUpY);
                            gc.strokeLine(1, 1, rightDownX - leftDownX, 1);
                            gc.strokeLine(rightDownX-leftDownX, rightDownY-leftUpY, 1, leftDownY - leftUpY);
                            gc.strokeLine(rightDownX-leftDownX, rightDownY-leftUpY, rightDownX - leftDownX, 1);
                        }
                    });
                }
            }
        });
    }
}
