package br.com.eubrunocoelho.crud.DAO;

import br.com.eubrunocoelho.crud.database.ConnectionSQLServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    public static void addUser(String title, String author, int pages) {
        var SQL = "INSERT INTO books (title, author, pages) VALUES (?, ?, ?)";

        try (
                Connection connection = ConnectionSQLServer.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, pages);
            
            int affectedLines = statement.executeUpdate();

            if (affectedLines > 0) {
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