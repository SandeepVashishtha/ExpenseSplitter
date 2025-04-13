package com.github.testing.expensesplitter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;  // Changed to VBox instead of StackPane
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/testing/expensesplitter/hello-view.fxml"));
        VBox root = loader.load();  // Cast to VBox since the root element in the FXML is VBox

        // Set the scene
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Expense Splitter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
