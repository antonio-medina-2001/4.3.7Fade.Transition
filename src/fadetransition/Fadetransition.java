
package fadetransition;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Fadetransition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane panel = new BorderPane();
        
        Scene scene = new Scene(panel, 400, 400);
        
        Ellipse elipse = new Ellipse(100,80);
        elipse.setFill(Color.RED);
        elipse.setStroke(Color.BLACK);
        
        FadeTransition ft = new FadeTransition(Duration.seconds(3), elipse);
        ft.setFromValue(1);
        ft.setToValue(0.3);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        
        panel.setCenter(elipse);

        // EVENTOS
        elipse.setOnMousePressed(e ->{
            ft.pause();
        });
        elipse.setOnMouseReleased(e ->{    
            ft.playFromStart();
        });
        ft.play();
        
        primaryStage.setTitle("FadeTransition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
