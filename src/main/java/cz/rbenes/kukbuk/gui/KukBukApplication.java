package cz.rbenes.kukbuk.gui;

import cz.rbenes.kukbuk.config.KukBukConfig;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by rostik on 4.2.17.
 */
public class KukBukApplication extends Application {

    public static AnnotationConfigApplicationContext applicationContext;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 800, Color.WHEAT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(KukBukConfig.class);

        launch(args);
    }
}
