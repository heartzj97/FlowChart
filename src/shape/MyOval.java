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


public class MyOval implements Shape {

    private double ovalX;
    private double ovalY;
    private double ovalA;
    private double ovalB;
    private TextField height;
    private TextField width;
    private Button modify;
    private Button delete;

    public void setParameter(double x, double y, double a, double b, TextField h, TextField w, Button m, Button d) {
        ovalA = a;
        ovalB = b;
        ovalX = x - a / 2;
        ovalY = y;
        height = h;
        width = w;
        modify = m;
        delete = d;
    }
    @Override
    public void draw(AnchorPane anchorPane, double x, double y, TextField h, TextField w, Button m, Button d) {
        this.setParameter(x, y, 120, 80, h, w, m, d);

        Canvas drawCanvas = new Canvas();
        drawCanvas.setLayoutX(ovalX-2);
        drawCanvas.setLayoutY(ovalY-2);
        drawCanvas.setHeight(ovalB+2);
        drawCanvas.setWidth(ovalA+2);

        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(1,1,ovalA,ovalB);

        anchorPane.getChildren().add(drawCanvas);
        drawCanvas.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if(event.getClickCount()==2) {
                    MyText myText = new MyText();
                    myText.setA(ovalA/2);
                    myText.setB(ovalB/2);
                    myText.draw(anchorPane,ovalX+ovalA/2,ovalY+ovalB/4,height,width,modify,delete);
                }
                else if(event.getClickCount()==1) {
                    height.setText(String.valueOf(ovalB));
                    width.setText(String.valueOf(ovalA));
                    modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gc.clearRect(0,0,ovalA+2,ovalB+2);
                            ovalB = Double.parseDouble(height.getText());
                            ovalA = Double.parseDouble(width.getText());
                            drawCanvas.setHeight(ovalB+2);
                            drawCanvas.setWidth(ovalA+2);
                            gc.strokeOval(1,1,ovalA,ovalB);
                        }
                    });
                    delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gc.clearRect(0,0,ovalA+2,ovalB+2);
                        }
                    });
                }
            }
        });
    }

}
