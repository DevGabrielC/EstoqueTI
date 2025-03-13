package co.devgabrielc.br.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent initialize = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/co/devgabrielc/br/views/LoginScreen.fxml")));
        primaryStage.setTitle("Estoque TI");
        primaryStage.setScene(new Scene(initialize));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}