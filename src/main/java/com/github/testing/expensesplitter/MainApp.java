package com.github.testing.expensesplitter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            URL fxmlLocation = getClass().getResource("/com/github/testing/expensesplitter/hello-view.fxml");
            if (fxmlLocation == null) {
                throw new IOException("FXML file not found at path: /com/github/testing/expensesplitter/hello-view.fxml");
            }

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            AnchorPane root = fxmlLoader.load();

            // Set the scene with the loaded FXML
            Scene scene = new Scene(root);
            primaryStage.setTitle("Expense Splitter");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}