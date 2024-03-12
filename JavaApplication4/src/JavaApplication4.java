import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaApplication4 extends Application {

    private final String[] countries = {"France", "Lesotho", "USA"};
    private final Color[][] flagColors = {
            {Color.BLUE, Color.WHITE, Color.RED}, // France
            {Color.GREEN, Color.WHITE, Color.BLUE}, // Lesotho
            {Color.RED, Color.WHITE, Color.BLUE}   // USA
            
 
    };
    private Pane[] flagPanes;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flag Display App");

        // Create buttons
        Button[] buttons = new Button[countries.length];
        for (int i = 0; i < countries.length; i++) {
            buttons[i] = new Button(countries[i]);
            buttons[i].setOnAction(e -> handleButtonClick(e));
        }

        // Create Panes for flag display
        flagPanes = new Pane[flagColors.length];
        for (int i = 0; i < flagColors.length; i++) {
            flagPanes[i] = createFlagPane();
        }

        // Create HBoxes for layout
        HBox buttonBox = new HBox(20, buttons);
        HBox flagBox = new HBox(1, flagPanes);

        // Create main layout
        HBox mainLayout = new HBox(20, buttonBox, flagBox);

        // Set up the scene
        Scene scene = new Scene(mainLayout, 600, 200);

        // Set up the stage
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
    }

    private Pane createFlagPane() {
        Pane pane = new Pane();
        pane.setMinSize(50, 20);
        return pane;
    }

    private void handleButtonClick(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String countryName = clickedButton.getText();

        // Find index of clicked country in countries array
        int countryIndex = -1;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].equals(countryName)) {
                countryIndex = i;
                break;
            }
        }

        if (countryIndex != -1) {
            // Update selected country name and flag colors
            System.out.println("Selected country: " + countryName);
            updateFlagPanes(flagColors[countryIndex]);
        }
    }

    private void updateFlagPanes(Color[] colors) {
        for (int i = 0; i < colors.length; i++) {
            flagPanes[i].setBackground(new Background(new BackgroundFill(colors[i], null, null)));
        }
    }
}
