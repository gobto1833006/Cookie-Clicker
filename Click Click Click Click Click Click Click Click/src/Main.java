import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("This text should not appear");
        primaryStage.setFullScreen(true);


        Label clics = new Label("1000000000.0");
        Button bouton = new Button("-1");
        Label prix1 = new Label("5");
        Label prix2 = new Label("25");
        Label prix3 = new Label("100");
        Label prix4 = new Label("500");
        Label prix5 = new Label("2500");
        Label multiplieur1 = new Label("-10.0");
        Label multiplieur2 = new Label("-100.0");
        Label multiplieur3 = new Label("-1000.0");
        Label multiplieur4 = new Label("-10000.0");
        Label multiplieur5 = new Label("-100000.0");
        Button upgrade1 = new Button(multiplieur1.getText() + " au prix de +" + prix1.getText());
        Button upgrade2 = new Button(multiplieur2.getText() + " au prix de +" + prix2.getText());
        Button upgrade3 = new Button(multiplieur3.getText() + " au prix de +" + prix3.getText());
        Button upgrade4 = new Button(multiplieur4.getText() + " au prix de +" + prix4.getText());
        Button upgrade5 = new Button(multiplieur5.getText() + " au prix de +" + prix5.getText());


        clics.setTranslateX(900);
        clics.setTranslateY(600);
        bouton.setTranslateX(900);
        bouton.setTranslateY(740);
        bouton.setScaleY(2.5);
        bouton.setScaleX(3);
        clics.setScaleY(8);
        clics.setScaleX(8);

        upgrade1.setTranslateX(900);
        upgrade2.setTranslateX(900);
        upgrade3.setTranslateX(900);
        upgrade4.setTranslateX(900);
        upgrade5.setTranslateX(900);
        upgrade1.setTranslateY(25);
        upgrade2.setTranslateY(100);
        upgrade3.setTranslateY(175);
        upgrade4.setTranslateY(250);
        upgrade5.setTranslateY(325);
        upgrade1.setScaleY(3);
        upgrade2.setScaleY(3);
        upgrade3.setScaleY(3);
        upgrade4.setScaleY(3);
        upgrade5.setScaleY(3);
        upgrade1.setScaleX(3);
        upgrade2.setScaleX(3);
        upgrade3.setScaleX(3);
        upgrade4.setScaleX(3);
        upgrade5.setScaleX(3);

        bouton.setOnAction(event -> {
            clics.setText(Double.toString(Double.parseDouble(clics.getText()) + Double.parseDouble(bouton.getText())));
        });
        upgrade1.setOnAction(event -> {
            acheterUpgrade(multiplieur1, upgrade1, prix1, clics, bouton);
        });
        upgrade2.setOnAction(event -> {
            acheterUpgrade(multiplieur2, upgrade2, prix2, clics, bouton);
        });
        upgrade3.setOnAction(event -> {
            acheterUpgrade(multiplieur3, upgrade3, prix3, clics, bouton);
        });
        upgrade4.setOnAction(event -> {
            acheterUpgrade(multiplieur4, upgrade4, prix4, clics, bouton);
        });
        upgrade5.setOnAction(event -> {
            acheterUpgrade(multiplieur5, upgrade5, prix5, clics, bouton);

        });


        Group groupe = new Group(clics, bouton, upgrade1, upgrade2, upgrade3, upgrade4, upgrade5);
        primaryStage.setScene(new Scene(groupe));
        primaryStage.show();

    }

    public static void acheterUpgrade(Label multiplier, Button upgrade, Label prix, Label clics, Button grosBouton) {
        clics.setText(Double.toString(Double.parseDouble(clics.getText()) + (Double.parseDouble(prix.getText()))));
        grosBouton.setText(Double.toString(Double.parseDouble(grosBouton.getText()) + Double.parseDouble(multiplier.getText())));
        prix.setText(Double.toString(Double.parseDouble(prix.getText()) * 2));
        upgrade.setText(multiplier.getText() + " au prix de +" + prix.getText());
    }


}
