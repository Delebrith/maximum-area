package ui;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Window extends Stage {

    private final int WIDTH = 1500;
    private final int HEIGHT = 1000;

    private Content content;

    public Window(UIManager manager){
        super();
        Group root = new Group();
        Paint paint = new Color(0.75,0.89,0.95,0.6);
        content = new Content(root, WIDTH, HEIGHT, paint, manager);
        this.setScene(content);
        this.setAlwaysOnTop(true);
        this.sizeToScene();
        content.draw();
        this.show();
    }

}
