import javafx.application.Application;
import javafx.stage.Stage;
import ui.UIManager;

public class Main extends Application {

    public static UIManager uiManager;

    @Override
    public void start(Stage stage) throws Exception {
        uiManager = new UIManager();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}
