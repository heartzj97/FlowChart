package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import shape.*;

import static javafx.application.Platform.exit;

public class Control {

    @FXML
    private ImageView myLine;

    @FXML
    private ImageView circle;

    @FXML
    private ScrollPane centerPane;

    @FXML
    private Canvas drawCanvas;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void drawSquare(MouseEvent onMouseClicked) {
        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int flag = 0;
            @Override
            public void handle(MouseEvent event) {
                if(flag==0) {
                    MySquare mySquare = new MySquare(event.getX(), event.getY(), 120, 80);
                    mySquare.draw(drawCanvas);
                    flag = 1;
                }
            }
        });
    }

    @FXML
    public void drawOval(MouseEvent onMouseClicked) {
        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int flag = 0;
            @Override
            public void handle(MouseEvent event) {
                if(flag==0) {
                    MyOval myOval = new MyOval(event.getX(), event.getY(), 120, 80);
                    myOval.draw(drawCanvas);
                    flag = 1;
                }
            }
        });
    }

    @FXML
    public void drawDiamond(MouseEvent onMouseClicked) {
        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int flag = 0;
            @Override
            public void handle(MouseEvent event) {
                if(flag==0) {
                    MyDiamond myDiamond = new MyDiamond(event.getX(), event.getY(), 120, 80);
                    myDiamond.draw(drawCanvas);
                    flag = 1;
                }
            }
        });
    }

    @FXML
    public void drawText(MouseEvent onMouseClicked) {

        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int i = 0;
            @Override
            public void handle(MouseEvent event) {
                if(i==0) {
                    MyText myText = new MyText(event.getX(), event.getY(), 60, 40);
                    myText.draw(drawCanvas);
                    myText.addTextField(anchorPane, event.getX(), event.getY(), 60, 40);
                    i = 1;
                }

            }
        });
    }


    @FXML
    public void drawLine(MouseEvent onMouseClicked) {
        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int flag = 0;
            @Override
            public void handle(MouseEvent event) {
                if(flag==0) {
                    MyArrow myArrow = new MyArrow(event.getX(), event.getY(), 80);
                    myArrow.draw(drawCanvas);
                    flag = 1;
                }
            }
        });


        //MyLine myLine = new MyLine(150, 150, 40);
        GraphicsContext gc = drawCanvas.getGraphicsContext2D();

/*
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(111, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);

*/
    }
}
