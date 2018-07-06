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
                    MySquare mySquare = new MySquare(event.getX(), event.getY(), 120, 80, height, width, modify);
                    mySquare.draw(anchorPane);
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
                    MyOval myOval = new MyOval(event.getX(), event.getY(), 120, 80, height, width, modify);
                    myOval.draw(anchorPane);
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
                    MyDiamond myDiamond = new MyDiamond(event.getX(), event.getY(), 120, 80, height, width ,modify);
                    myDiamond.draw(anchorPane);
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
                    myText.draw(anchorPane);
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
                    MyArrow myArrow = new MyArrow(event.getX(), event.getY(), 40, height, width, modify);
                    myArrow.draw(anchorPane);
                    flag = 1;
                }
            }
        });
    }
}
