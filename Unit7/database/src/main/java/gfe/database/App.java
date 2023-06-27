package gfe.database;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private ConfigurableApplicationContext applicationContext;



@Override
public void init() throws Exception {
    applicationContext = new SpringApplicationBuilder(DatabaseApplication.class).run();
}

@Override
public void stop() throws Exception {
   applicationContext.close();
   Platform.exit();
}
    @Override
    public void start(Stage stage) throws IOException {

        applicationContext.publishEvent(new StageReadyEvent(stage));

    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage){
            super(stage);
        }

        public Stage getStage() {
            return ((Stage)getSource());
        }

    }
}