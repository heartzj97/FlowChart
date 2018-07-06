package shape;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private double a = 60;
    private double b = 40;

    private TextField height;
    private TextField width;
    private Button modify;
    private Button delete;

    public void setA(double i){
        a = i;
    }

    public void setB(double i) {
        b = i;
    }

    @Override
    public void draw(AnchorPane pane, double x, double y, TextField h, TextField w, Button m, Button d) {

        leftUpX = x-a/2;
        leftUpY = y;
        rightUpX = x+a/2;
        rightUpY = y;
        leftDownX = x-a/2;
        leftDownY = y+b;
        rightDownX = x+a/2;
        rightDownY = y+b;
        delete = d;
        height = h;
        width = w;
        modify = m;
        delete = d;

        TextArea textArea = new TextArea();
        textArea.setLayoutX(leftUpX);
        textArea.setLayoutY(leftUpY-6);
        textArea.setPrefSize(rightUpX-leftUpX,rightDownY-rightUpY);
        pane.getChildren().add(textArea);


        textArea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                height.setText(String.valueOf(leftDownY - leftUpY));
                width.setText(String.valueOf(rightUpX - leftUpX));
                modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        pane.getChildren().remove(textArea);
                        rightDownX = rightUpX = leftUpX + Double.parseDouble(width.getText());
                        leftDownY = rightDownY = leftUpY + Double.parseDouble(height.getText());
                        textArea.setPrefSize(rightUpX-leftUpX,rightDownY-rightUpY);
                        pane.getChildren().add(textArea);

                    }
                });
                delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        pane.getChildren().remove(textArea);

                    }
                });
            }
        });

    }
}
