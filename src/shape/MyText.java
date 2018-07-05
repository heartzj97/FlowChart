package shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class MyText implements Shape {

    private double leftUpX;
    private double leftUpY;
    private double rightUpX;
    private double rightUpY;
    private double leftDownX;
    private double leftDownY;
    private double rightDownX;
    private double rightDownY;

    public MyText(double x,double y,double a,double b) {
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
    public void draw(Canvas drawCanvas) {
        GraphicsContext gc = drawCanvas.getGraphicsContext2D();
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(1);
        gc.setLineDashes(3,0);
        gc.strokeLine(leftDownX,leftDownY,rightDownX,rightDownY);
        gc.strokeLine(leftUpX,leftUpY,leftDownX,leftDownY);
        gc.strokeLine(leftUpX,leftUpY,rightUpX,rightUpY);
        gc.strokeLine(rightUpX,rightUpY,rightDownX,rightDownY);

        gc.setLineDashes(0,0);
    }

    public void addTextField(AnchorPane pane, double x, double y,double a, double b) {
        TextArea textArea = new TextArea();
        textArea.setStyle("-fx-background-color:transparent ");
        textArea.setLayoutX(x-a/2);
        textArea.setLayoutY(y-6);
        textArea.setPrefSize(a,b);
        pane.getChildren().add(textArea);

    }

}
