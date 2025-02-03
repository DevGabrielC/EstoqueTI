package co.devgabrielc.br.controllers;

import co.devgabrielc.br.database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static co.devgabrielc.br.controllers.LoginController.*;
import static co.devgabrielc.br.helpers.Functions.showAlertError;
import static co.devgabrielc.br.helpers.Functions.showAlertSuccess;

public class RegisterController {
    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField primeiroNomeField;
    @FXML
    private TextField sobrenomeField;
    @FXML
    private TextField userTextField;

    // Lógica para a Tela de Cadastro
    @FXML
    private void handleRegisterButton() {
        String username = userTextField.getText();
        String password = passwordField.getText();
        String fname = primeiroNomeField.getText();
        String lname = sobrenomeField.getText();

        if (username.isEmpty() || password.isEmpty() || fname.isEmpty() || lname.isEmpty()) {
            showAlertError("Erro!", "Campos obrigatórios não preenchidos.");
        } else if (validarCadastro(username)) {
                showAlertError("Erro!", "Já existe um usuário cadastrado com esse nome.");
            } else {
                String query = "INSERT INTO usuarios (username, password, fname, lname) VALUES (?, ?, ?, ?)";
                try (Connection conn = DatabaseConnection.connect();
                     PreparedStatement pstmt = conn.prepareStatement(query)) {

                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    pstmt.setString(3, fname);
                    pstmt.setString(4, lname);

                    int affectedRows = pstmt.executeUpdate();

                    if (affectedRows > 0) {
                        showAlertSuccess("Sucesso!", "Cadastro realizado.");
                    }
                } catch (SQLException e) {
                    showAlertError("Erro!", "Erro ao realizar o cadastro.");
                }
            }
        }

    @FXML
    void handleCancelar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/devgabrielc/br/screens/LoginScreen.fxml"));
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