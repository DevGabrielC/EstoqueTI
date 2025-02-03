package co.devgabrielc.br.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

// Tela para escolher materiais que serão adicionados
// Duas alternativas, sendo Ativo Imobilizado e Uso e Consumo
public class AddScreenController {
    @FXML
    private Button cancelButton;
    @FXML
    private Button usoConsumoButton;
    @FXML
    private Button ativoImobilizadoButton;

    // Ação do botão de Ativo Imobilizado
    @FXML
    void handleAtivoImobilizadoScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/devgabrielc/br/screens/AtivoImobilizado.fxml"));
            Parent initialize = loader.load();
            Stage stage = (Stage) ativoImobilizadoButton.getScene().getWindow();
            Scene scene = new Scene(initialize);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleUsoConsumoScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/devgabrielc/br/screens/UsoConsumo.fxml"));
            Parent initialize = loader.load();
            Stage stage = (Stage) usoConsumoButton.getScene().getWindow();
            Scene scene = new Scene(initialize);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void handleCancelar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/devgabrielc/br/screens/MainScreen.fxml"));
            Parent initialize = loader.load();

            Stage stage = (Stage) cancelButton.getScene().getWindow();
            Scene scene = new Scene(initialize);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}