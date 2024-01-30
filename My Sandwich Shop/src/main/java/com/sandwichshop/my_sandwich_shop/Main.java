package com.sandwichshop.my_sandwich_shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-window-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        stage.setTitle("My Sandwich Shop!");

        Image image = new Image(Objects.requireNonNull(Main.class.getResource("/icon.png")).toExternalForm());
        stage.getIcons().add(image);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}