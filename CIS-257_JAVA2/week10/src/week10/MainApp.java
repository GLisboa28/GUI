package week10;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{
    
    @Override
    public void start( Stage primaryStage ) {
      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FxNyResolutions.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene( root );
            FxNyResolutionsController controller = loader.getController();
            NyrData nyrData = new NyrData();
            controller.setModel( nyrData );
            
            primaryStage.setTitle( " New Year's Resolutions" );
            primaryStage.setScene( scene );
            controller.notifyObservers(); //will show all information
            primaryStage.show();
            
            loader = new FXMLLoader(getClass().getResource("FxHistory.fxml"));
            root = loader.load();
            scene = new Scene( root );
            FxHistoryController controllerHistory = loader.getController();
            controllerHistory.setModel( nyrData );
            controller.setHistoryController( controllerHistory );
            
            final Stage stageHistory = new Stage();
            stageHistory.setX(primaryStage.getX()+ primaryStage.getWidth());
            stageHistory.setY( primaryStage.getY());
            
            stageHistory.setTitle("History");
            stageHistory.setScene(scene);
            
            //stageHistory.show();
            //uncomment if you would like historywindow to be visible when the application starts
                    
           } catch (IOException ex) {
               System.out.println(ex.getMessage() );
               System.out.println(ex.getCause() );
               ex.printStackTrace();
           }
               
           }
    public static void main( String[] args) {
        launch( args );
    }

   
    
     }
    
