package co.devgabrielc.br.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static co.devgabrielc.br.helpers.Functions.showAlertError;

public class DatabaseConnection {
    // Função completa para conectar ao Banco de Dados SQLITE3
    private static final String URL = "jdbc:sqlite:db/estoqueti.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Metodo que atualiza após editar algum campo na tabela
    public static void atualizarBancoDeDados(String coluna, Object novoValor, int id) {
        String sql = "UPDATE materiais SET " + coluna + " = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (novoValor instanceof Integer) {
                pstmt.setInt(1, (Integer) novoValor);
            } else if (novoValor instanceof String) {
                pstmt.setString(1, (String) novoValor);
            } else {
                showAlertError("Erro!", "Tipo de dado não suportado.");
            }
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlertError("Erro!", "Erro ao atualizar o Banco de Dados.");
        }
    }
}