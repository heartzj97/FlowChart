package shape;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MyText implements Shape {

    private double leftUpX;
    private double leftUpY;
    private double rightUpX;
    private double rightUpY;
    private double leftDownX;
    private double leftDownY;
    private double rightDownX;
    private double rightDownY;

    public void setParameter(double x,double y,double a,double b) {
        leftUpX = x-a/2;
        leftUpY = y;
        rightUpX = x+a/2;
        rightUpY = y;
        leftDownX = x-a/2;
        leftDownY = y+b;
        rightDownX = x+a/2;
        rightDownY = y+b;
    }

    @Override
    public void draw(AnchorPane pane, double x, double y, TextField h, TextField w, Button m) {
        this.setParameter(x, y, 60, 40);

        TextArea textArea = new TextArea();
        textArea.setLayoutX(leftUpX);
        textArea.setLayoutY(leftUpY-6);
        textArea.setPrefSize(rightUpX-leftUpX,rightDownY-rightUpY);
        pane.getChildren().add(textArea);
    }
}
