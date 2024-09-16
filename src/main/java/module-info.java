module com.op_test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.op_test to javafx.fxml;
    exports com.op_test;
    exports com.op_test.abilities;
    opens com.op_test.abilities to javafx.fxml;
    exports com.op_test.characters;
    opens com.op_test.characters to javafx.fxml;
    exports com.op_test.player;
    opens com.op_test.player to javafx.fxml;
    exports com.op_test.service;
    opens com.op_test.service to javafx.fxml;
}