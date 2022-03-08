module com.game.survivalgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.survivalgame to javafx.fxml;
    exports com.game.survivalgame;
}
