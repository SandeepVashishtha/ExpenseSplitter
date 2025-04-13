module com.github.testing.expensesplitter {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.testing.expensesplitter to javafx.fxml;
    exports com.github.testing.expensesplitter;
}
