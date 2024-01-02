package br.com.eubrunocoelho.crud.DAO;

import br.com.eubrunocoelho.crud.database.ConnectionSQLServer;
import br.com.eubrunocoelho.crud.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static void addBook(String title, String author, int pages) {
        var SQL = "INSERT INTO books (title, author, pages) VALUES (?, ?, ?)";

        try (
                Connection connection = ConnectionSQLServer.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, pages);

            var affectedLines = statement.executeUpdate();

            if (affectedLines > 0) {
                System.out.println("Livro adicionado com sucesso!");

                connection.close();
            } else {
                System.out.println("Falha ao adicionar livro.");

                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar o livro: " + e.getMessage());
            throw new RuntimeException("Erro ao adicionar livro.", e);
        }
    }

    public static void findBook(int id) {
        var SQL = "SELECT * FROM books WHERE id = ?";

        try (
                Connection connection = ConnectionSQLServer.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    var title = resultSet.getString("title");
                    var author = resultSet.getString("author");
                    var pages = resultSet.getInt("pages");

                    System.out.println("Livro encontrado: ");
                    System.out.println("ID: " + id);
                    System.out.println("Título: " + title);
                    System.out.println("Autor: " + author);
                    System.out.println("Páginas: " + pages);

                    connection.close();
                } else {
                    System.out.println("Livro não encontrado para o ID: " + id);

                    connection.close();
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao encontrar o livro: " + e.getMessage());
            throw new RuntimeException("Erro ao encontrar o livro.", e);
        }
    }

    public static List<Book> findAllBooks() {
        var SQL = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();

        try (
                Connection connection = ConnectionSQLServer.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL);
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var title = resultSet.getString("title");
                var author = resultSet.getString("author");
                var pages = resultSet.getInt("pages");

                Book book = new Book(id, title, author, pages);
                books.add(book);
            }

            connection.close();
        } catch (SQLException e) {
            System.err.println("Erro ao encontrar os livros: " + e.getMessage());
            throw new RuntimeException("Erro ao encontrar os livros.", e);
        }

        return books;
    }

    public static void updateBook(int id, String title, String author, int pages) {
        var SQL = "UPDATE books SET title = ?, author = ?, pages = ? WHERE id = ?";

        try (
                Connection connection = ConnectionSQLServer.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, pages);
            statement.setInt(4, id);

            var affectedLines = statement.executeUpdate();

            if (affectedLines > 0) {
                System.out.println("Livro atualizado com sucesso!");

                connection.close();
            } else {
                System.out.println("Falha ao atualizar livro.");

                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o livro: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar o livro.", e);
        }
    }

    public static void deleteBook(int id) {
        var SQL = "DELETE FROM books WHERE id = ?";

        try (
                Connection connection = ConnectionSQLServer.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setInt(1, id);

            var affectedLines = statement.executeUpdate();

            if (affectedLines > 0) {
                System.out.println("Livro deletado com sucesso!");

                connection.close();
            } else {
                System.out.println("Falha ao deletar o livro.");

                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o livro: " + e.getMessage());
            throw new RuntimeException("Erro ao deletar livro.", e);
        }
    }
}