package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import shape.*;

public class Control {

    @FXML
    private Canvas drawCanvas;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField width;

    @FXML
    private TextField height;

    @FXML
    private Button modify;

    @FXML
    public void drawSquare(MouseEvent onMouseClicked) {
        drawCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int flag = 0;
            @Override
            public void handle(MouseEvent event) {
                if(flag==0) {
                    ShapeFactory factory = new ShapeFactory();
                    Shape myShape = factory.getShape("SQUARE");
                    myShape.draw(anchorPane, event.getX(), event.getY(), height, width, modify);
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
                    ShapeFactory factory = new ShapeFactory();
                    Shape myShape = factory.getShape("OVAL");
                    myShape.draw(anchorPane, event.getX(), event.getY(), height, width, modify);
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
                    ShapeFactory factory = new ShapeFactory();
                    Shape myShape = factory.getShape("DIAMOND");
                    myShape.draw(anchorPane, event.getX(), event.getY(), height, width, modify);
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
                    ShapeFactory factory = new ShapeFactory();
                    Shape myShape = factory.getShape("TEXT");
                    myShape.draw(anchorPane, event.getX(), event.getY(), height, width, modify);
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
                    ShapeFactory factory = new ShapeFactory();
                    Shape myShape = factory.getShape("ARROW");
                    myShape.draw(anchorPane, event.getX(), event.getY(), height, width, modify);
                    flag = 1;
                }
            }
        });
    }
}
