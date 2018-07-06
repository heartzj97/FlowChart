package shape;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public interface Shape {
    void draw(AnchorPane anchorPane, double x, double y, TextField h, TextField w, Button m, Button d);
}
