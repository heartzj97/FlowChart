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

public class MyDiamond implements Shape {
    private double upX;
    private double upY;
    private double leftX;
    private double leftY;
    private double downX;
    private double downY;
    private double rightX;
    private double rightY;
    private double diamondA;
    private double diamondB;

    private TextField height;
    private TextField width;
    private Button modify;
    private Button delete;

    public void setParameter(double x,double y,double a,double b, TextField h, TextField w, Button m, Button d) {
        upX = x;
        upY = y;
        downX = x;
        downY = y+b;
        leftX = x-a/2;
        leftY = y+b/2;
        rightX = x+a/2;
        rightY = y+b/2;
        diamondA = a;
        diamondB = b;
        height = h;
        width = w;
        modify = m;
        delete = d;
    }

    @Override
    public void draw(AnchorPane anchorPane, double x, double y, TextField h, TextField w, Button m, Button d) {

        this.setParameter(x, y,120,80, h, w, m, d);

        Canvas drawCanvas = new Canvas();
        drawCanvas.setLayoutX(upX-diamondA/2-2);
        drawCanvas.setLayoutY(upY-2);
        drawCanvas.setHeight(diamondB+2);
        drawCanvas.setWidth(diamondA+2);

        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.strokeLine(diamondA/2,0,0,diamondB/2);
        gc.strokeLine(diamondA/2,0,diamondA,diamondB/2);
        gc.strokeLine(diamondA/2,diamondB,0,diamondB/2);
        gc.strokeLine(diamondA/2,diamondB,diamondA,diamondB/2);

        anchorPane.getChildren().add(drawCanvas);
        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {

                if(event.getClickCount()==1) {
                    height.setText(String.valueOf(diamondB));
                    width.setText(String.valueOf(diamondA));
                    modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gc.clearRect(0,0,diamondA+2,diamondB+2);
                            diamondB = Double.parseDouble(height.getText());
                            diamondA = Double.parseDouble(width.getText());

                            downX = upX = leftX + diamondA/2;
                            rightY = leftY = upY +diamondB/2;
                            downY = upY + diamondB;
                            rightX = leftX + diamondA;

                            drawCanvas.setHeight(diamondB+2);
                            drawCanvas.setWidth(diamondA+2);
                            gc.strokeLine(diamondA/2,0,0,diamondB/2);
                            gc.strokeLine(diamondA/2,0,diamondA,diamondB/2);
                            gc.strokeLine(diamondA/2,diamondB,0,diamondB/2);
                            gc.strokeLine(diamondA/2,diamondB,diamondA,diamondB/2);
                        }
                    });
                    delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gc.clearRect(0,0,diamondA+2,diamondB+2);
                        }
                    });
                }
                else if(event.getClickCount()==2) {
                    MyText myText = new MyText();
                    myText.setA(diamondA/2-3);
                    myText.setB(diamondB/2-3);
                    myText.draw(anchorPane,upX,upY+diamondB/4+5,height,width,modify,delete);
                }
            }
        });
    }
}
