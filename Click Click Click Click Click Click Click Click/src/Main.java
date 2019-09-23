import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("This text should not appear");
        primaryStage.setFullScreen(true);


        Label clics = new Label("1000000000.0");
        Button bouton = new Button("-1");
        Label prix1 = new Label("1");
        Label prix2 = new Label("100");
        Label prix3 = new Label("10000");
        Label prix4 = new Label("10000");
        Label prix5 = new Label("1000000");
        Label multiplieur1 = new Label("-1.0");
        Label multiplieur2 = new Label("-10.0");
        Label multiplieur3 = new Label("-100.0");
        Label multiplieur4 = new Label("1");
        Label multiplieur5 = new Label("5");
        Button upgrade1 = new Button(multiplieur1.getText() + " au prix de +" + prix1.getText());
        Button upgrade2 = new Button(multiplieur2.getText() + " au prix de +" + prix2.getText());
        Button upgrade3 = new Button(multiplieur3.getText() + " au prix de +" + prix3.getText());
        Button upgrade4 = new Button("+" + multiplieur4.getText() + " clic/s au prix de +" + prix4.getText());
        Button upgrade5 = new Button("+" + multiplieur5.getText() + " clic/s au prix de +" + prix5.getText());
        Label clicSeconde = new Label("0");
        Label victoryScreen = new Label("VOUS AVEZ GAGNÉ");


        clics.setTranslateX(900);
        clics.setTranslateY(600);
        bouton.setTranslateX(900);
        bouton.setTranslateY(740);
        clicSeconde.setTranslateX(900);
        clicSeconde.setTranslateY(460);
        bouton.setScaleY(2.5);
        bouton.setScaleX(3);
        clics.setScaleY(8);
        clics.setScaleX(8);
        clicSeconde.setScaleX(3);
        clicSeconde.setScaleY(2.5);
        victoryScreen.setTranslateX(-3000);
        victoryScreen.setTranslateY(450);
        victoryScreen.setScaleX(14);
        victoryScreen.setScaleY(15);

        upgrade1.setTranslateX(900);
        upgrade2.setTranslateX(900);
        upgrade3.setTranslateX(900);
        upgrade4.setTranslateX(900);
        upgrade5.setTranslateX(900);
        upgrade1.setTranslateY(25);
        upgrade2.setTranslateY(112);
        upgrade3.setTranslateY(200);
        upgrade4.setTranslateY(287);
        upgrade5.setTranslateY(374);
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



        final Timeline timeline = new Timeline(new KeyFrame(Duration.millis(Double.parseDouble(clicSeconde.getText())), n -> incrementer(bouton, clics,victoryScreen)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        bouton.setOnAction(event -> {
            incrementer(bouton, clics,victoryScreen);
        });
        upgrade1.setOnAction(event -> {
            acheterUpgrade(multiplieur1, upgrade1, prix1, clics, bouton, clicSeconde);

        });
        upgrade2.setOnAction(event -> {
            acheterUpgrade(multiplieur2, upgrade2, prix2, clics, bouton, clicSeconde);

        });
        upgrade3.setOnAction(event -> {
            acheterUpgrade(multiplieur3, upgrade3, prix3, clics, bouton, clicSeconde);

        });
        upgrade4.setOnAction(event -> {
            acheterUpgrade(multiplieur4, upgrade4, prix4, clics, bouton, clicSeconde);
            timeline.stop();
            timeline.getKeyFrames().setAll(new KeyFrame(Duration.millis(1000 / (Double.parseDouble(multiplieur4.getText()) + (Double.parseDouble(clicSeconde.getText())))), n -> incrementer(bouton, clics,victoryScreen)));
            timeline.play();

        });

        upgrade5.setOnAction(event -> {
            acheterUpgrade(multiplieur5, upgrade5, prix5, clics, bouton, clicSeconde);
            timeline.stop();
            timeline.getKeyFrames().setAll(new KeyFrame(Duration.millis(1000 / ((Double.parseDouble(multiplieur5.getText()) + (Double.parseDouble(clicSeconde.getText()))))), n -> incrementer(bouton, clics,victoryScreen)));
            timeline.play();

        });


        Group groupe = new Group(clics, bouton, upgrade1, upgrade2, upgrade3, upgrade4, upgrade5, clicSeconde, victoryScreen);
        primaryStage.setScene(new Scene(groupe));
        primaryStage.show();


    }

    public static void acheterUpgrade(Label multiplier, Button upgrade, Label prix, Label clics, Button grosBouton, Label clicSeconde) {
        if (Double.parseDouble(multiplier.getText()) < 0) {
            grosBouton.setText(Double.toString(Double.parseDouble(grosBouton.getText()) + Double.parseDouble(multiplier.getText())));
            upgrade.setText(multiplier.getText() + " au prix de +" + prix.getText());
        } else {
            clicSeconde.setText(Double.toString(Double.parseDouble(clicSeconde.getText()) + Double.parseDouble(multiplier.getText())));
            upgrade.setText("+" + multiplier.getText() + " clic/s au prix de +" + prix.getText());
        }
        clics.setText(Double.toString(Double.parseDouble(clics.getText()) + (Double.parseDouble(prix.getText()))));
        prix.setText(Double.toString(Math.round((Double.parseDouble(prix.getText()) + 10) * 1.07) - 10));
    }

    public static void incrementer(Button bouton, Label clics,Label victoryScreen) {
        clics.setText(Double.toString(Double.parseDouble(clics.getText()) + Double.parseDouble(bouton.getText())));
        if (Double.parseDouble(clics.getText()) <= 0) {
            victoryScreen.setTranslateX(875);
        }
    }


}
