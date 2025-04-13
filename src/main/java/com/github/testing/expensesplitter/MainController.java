package com.github.testing.expensesplitter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;

public class MainController {

    @FXML
    private TextField person1Name, person2Name, expenseAmount;

    @FXML
    private Button splitButton;

    // A map to hold the names and the amounts each person has to pay
    private Map<String, Double> expenseDistribution = new HashMap<>();

    public void handleSplitExpenseAction() {
        String name1 = person1Name.getText();
        String name2 = person2Name.getText();
        String amountText = expenseAmount.getText();

        try {
            double totalAmount = Double.parseDouble(amountText);

            // Split the amount equally between the two people
            double individualShare = totalAmount / 2;

            // Add entries for both individuals
            expenseDistribution.put(name1, individualShare);
            expenseDistribution.put(name2, individualShare);

            // Show an alert with the distribution
            showAlert("Expense Split Successful", "Each person has to pay: INR " + individualShare);

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
