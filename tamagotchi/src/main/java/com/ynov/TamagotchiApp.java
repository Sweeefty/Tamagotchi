package com.ynov;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TamagotchiApp extends Application {
    private Tamagotchi tamagotchi;
    private Label stateLabel;
    private Label ageLabel;
    private Label happinessLabel;

    @Override
    public void start(Stage stage) {
        tamagotchi = new Tamagotchi();

        stateLabel = new Label("Le Tamagotchi est un " + tamagotchi.state + ".");
        ageLabel = new Label("Le Tamagotchi a " + tamagotchi.age + " ans.");
        happinessLabel = new Label("Le Tamagotchi a " + tamagotchi.happiness + " de bonheur.");

        Button unitTimeButton = new Button("Passer une unité de temps");
        unitTimeButton.setOnAction(e -> unitTime());

        Button feedButton = new Button("Nourrir le Tamagotchi");
        feedButton.setOnAction(e -> feed());

        Button playButton = new Button("Jouer avec le Tamagotchi");
        playButton.setOnAction(e -> play());

        Button cleanButton = new Button("Nettoyer l'environnement du Tamagotchi");
        cleanButton.setOnAction(e -> clean());

        Button healButton = new Button("Soigner le Tamagotchi");
        healButton.setOnAction(e -> heal());

        VBox buttonsBox = new VBox(10, unitTimeButton, feedButton, playButton, cleanButton, healButton);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setPadding(new Insets(10));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.add(stateLabel, 0, 0);
        gridPane.add(ageLabel, 0, 1);
        gridPane.add(happinessLabel, 0, 2);
        gridPane.add(buttonsBox, 0, 3);

        Scene scene = new Scene(gridPane, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Tamagotchi");
        stage.show();
    }

    private void unitTime() {
        tamagotchi.UnitTime();
        updateLabels();
    }

    private void feed() {
        tamagotchi.feed();
        updateLabels();
    }

    private void play() {
        tamagotchi.play();
        updateLabels();
    }

    private void clean() {
        tamagotchi.clean();
        updateLabels();
    }

    private void heal() {
            tamagotchi.heal();
            updateLabels();
        }
        
    private void updateLabels() {
        stateLabel.setText("Le Tamagotchi est un " + tamagotchi.state + ".");
        ageLabel.setText("Le Tamagotchi a " + tamagotchi.age + " ans.");
        happinessLabel.setText("Le Tamagotchi a " + tamagotchi.happiness + " de bonheur.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
