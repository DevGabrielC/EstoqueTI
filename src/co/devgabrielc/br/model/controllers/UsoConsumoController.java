package co.devgabrielc.br.model.controllers;

import co.devgabrielc.br.model.database.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static co.devgabrielc.br.model.controllers.LoginController.*;
import static co.devgabrielc.br.model.services.Functions.*;

public class UsoConsumoController {
    @FXML
    private Button cancelButton;
    @FXML
    private TextArea descricaoArea;
    @FXML
    private TextField grupoEquipamentoField;
    @FXML
    private TextField marcaField;
    @FXML
    private TextField modeloField;
    @FXML
    private TextField quantidadeField;
    @FXML
    private TextField tipoEquipamentoField;

    @FXML
    void handleAddMateriais(ActionEvent event) {
        String grupoEquipamento = grupoEquipamentoField.getText();
        String tipoEquipamento = tipoEquipamentoField.getText();
        String marca = marcaField.getText();
        String modelo = modeloField.getText();
        String quantidade = quantidadeField.getText();
        String descricao = descricaoArea.getText();

        if (tipoEquipamento.isEmpty() || marca.isEmpty() || modelo.isEmpty() || quantidade.isEmpty()) {
            showAlertError("Erro!", "Campos obrigatórios não preenchidos, favor preencher.");
            return;
        }
        String query = "INSERT INTO materiais (grupo_equipamento, tipo_equipamento, marca, modelo, quantidade, descricao) VALUES" +
                "(?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, grupoEquipamento);
            stmt.setString(2, tipoEquipamento);
            stmt.setString(3, marca);
            stmt.setString(4, modelo);
            stmt.setString(5, quantidade);
            stmt.setString(6, descricao);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                if (Integer.parseInt(quantidadeField.getText()) > 1) {
                    showAlertSuccess("Sucesso!", "Materiais adicionados com sucesso!");
                    registrarHistorico(usuarioLogado, "Adição", "Material: " + tipoEquipamento + ", Quantidade: " + quantidade);
                } else {
                    showAlertSuccess("Sucesso!", "Material adicionado com sucesso!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlertError("Erro!", "Ocorreu um erro ao adicionar o(s) material(is). Tente novamente.");
        }
    }

    @FXML
    void handleCancelar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/devgabrielc/br/model/views/AddScreen.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) cancelButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
