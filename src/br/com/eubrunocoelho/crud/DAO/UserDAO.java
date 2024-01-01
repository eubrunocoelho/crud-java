package br.com.eubrunocoelho.crud.DAO;

import br.com.eubrunocoelho.crud.database.ConnectionSQLServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public static void addUser(String name, String email, int age, String city) {
        var SQL = "INSERT INTO users (name, email, age, city) VALUES (?, ?, ?, ?)";

        try (
                Connection connection = ConnectionSQLServer.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, age);
            statement.setString(4, city);

            // Execute a instrução SQL dentro do bloco try
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário adicionado com sucesso!");
                connection.close();
            } else {
                System.out.println("Falha ao adicionar usuário.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar o usuário: " + e.getMessage());
            throw new RuntimeException("Erro ao adicionar usuário.", e);
        }
    }
}