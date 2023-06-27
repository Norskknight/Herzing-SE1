package gfe.database;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import gfe.database.App.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.core.io.Resource;

@Component
public class StageInitializer implements ApplicationListener<App.StageReadyEvent>{
    
    @Value("classpath:/IngredientStockKeeper.fxml")
    private Resource stockaResource;
    private ApplicationContext applicationContext;


    public StageInitializer(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;

    }
@Override
public void onApplicationEvent(StageReadyEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(stockaResource.getURL());
        fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
        Parent parent = fxmlLoader.load();

        Stage stage = event.getStage();
        stage.setScene(new Scene(parent,800, 600, false, null));
        stage.show();
    } catch (Exception e) {
        throw new RuntimeException();
    }

}



}
