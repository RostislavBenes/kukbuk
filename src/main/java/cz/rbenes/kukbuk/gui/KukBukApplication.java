package cz.rbenes.kukbuk.gui;

import cz.rbenes.kukbuk.config.KukBukConfig;
import cz.rbenes.kukbuk.database.dao.CategoryDao;
import cz.rbenes.kukbuk.service.CategoryService;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by rostik on 4.2.17.
 */
public class KukBukApplication extends Application {

    Logger logger = Logger.getLogger(KukBukApplication.class);

    public static AnnotationConfigApplicationContext applicationContext;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1024, 800, Color.WHEAT);

        CategoryPane categoryPane = new CategoryPane(applicationContext.getBean(CategoryService.class));
        categoryPane.init();
        root.setLeft(categoryPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(KukBukConfig.class);
        launch(args);

    }


}
