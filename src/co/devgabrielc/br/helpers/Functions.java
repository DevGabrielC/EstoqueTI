package co.devgabrielc.br.helpers;

import co.devgabrielc.br.database.DatabaseConnection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static co.devgabrielc.br.database.DatabaseConnection.connect;
import static co.devgabrielc.br.controllers.LoginController.usuarioLogado;

public class Functions {
    public static void registrarHistorico(String usuario, String acao, String descricao) {
        String historico = "INSERT INTO historico (usuario, acao, descricao, data_hora) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect()) {
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            PreparedStatement pstmt = connect().prepareStatement(historico);
            pstmt.setString(1, usuarioLogado);
            pstmt.setString(2, acao);
            pstmt.setString(3, descricao);
            pstmt.setString(4, dataHora);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo que apresenta mensagem de erro na tela
    public static void showAlertError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    // Metodo que apresenta mensagem de sucesso na tela
    public static void showAlertSuccess(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}