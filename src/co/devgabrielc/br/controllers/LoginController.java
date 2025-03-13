package co.devgabrielc.br.controllers;

import co.devgabrielc.br.database.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static co.devgabrielc.br.services.Functions.showAlertError;

public class LoginController {

    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    public static String usuarioLogado;
    @FXML
    private Button registerButton;

    public void setStage(Stage stage) {
    }

    // Ação para acessar a tela principal
    @FXML
    public void handleLoginButton(ActionEvent event) {
        String username = userTextField.getText();
        String password = passwordField.getText();
        // Verifica o login, se as credenciais existirem no banco de dados, usuário irá passar
        if (validarLogin(username, password)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/devgabrielc/br/views/MainScreen.fxml"));
                Parent root = loader.load();

                // Configura o Stage atual para exibir a MainController
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setMaximized(true);
                stage.setTitle("Estoque TI");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlertError("Erro!", "Usuário ou senha incorretos.");
        }
    }

    // Ação para acessar tela de cadastro
    @FXML
    void handleRegisterScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/devgabrielc/br/views/RegisterScreen.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) registerButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Estoque TI");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean validarCadastro(String username) {
        // Query para verificar se o usuário e senha existem no banco, se existirem, retornará erro
        // Caso contrário, o cadastro irá prosseguir
        String query = "SELECT 1 FROM usuarios WHERE username = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Metodo para validar o login
    private boolean validarLogin(String username, String password) {
        String query = "SELECT fname, lname, username, password FROM usuarios WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // Caso exista, irá mostrar na tela principal a mensagem "bom dia, boa tarde, boa noite, fname lname (primeiro e ultimo nome)"
            if (rs.next()) {
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                usuarioLogado = fname + " " + lname;
                rs.close();
                pstmt.close();

                return true;
            } else {
                rs.close();
                pstmt.close();

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }
}