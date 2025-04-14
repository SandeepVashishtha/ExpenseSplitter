package com.github.testing.expensesplitter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private VBox vbox;

    @FXML
    private TextField person1Name, person2Name, expenseAmount;

    @FXML
    private Button splitButton, addPersonButton;

    private final List<TextField> additionalPeople = new ArrayList<>();

    @FXML
    public void handleAddPersonAction() {
        TextField newPersonField = new TextField();
        newPersonField.setPromptText("Enter name of another person");
        additionalPeople.add(newPersonField);
        vbox.getChildren().add(vbox.getChildren().size() - 2, newPersonField); // Add before the last two buttons
    }

    @FXML
    public void handleSplitExpenseAction() {
        List<String> names = new ArrayList<>();
        names.add(person1Name.getText());
        names.add(person2Name.getText());
        for (TextField personField : additionalPeople) {
            names.add(personField.getText());
        }

        String amountText = expenseAmount.getText();

        try {
            double totalAmount = Double.parseDouble(amountText);
            double individualShare = totalAmount / names.size();

            StringBuilder result = new StringBuilder("Each person has to pay: INR " + individualShare + "\n");
            for (String name : names) {
                result.append(name).append(": INR ").append(individualShare).append("\n");
            }

            showAlert("Expense Split Successful", result.toString());

        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid number for the amount.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}