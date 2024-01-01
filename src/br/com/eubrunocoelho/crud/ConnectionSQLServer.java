package br.com.eubrunocoelho.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLServer {
    public static void getConnection() {
        var url = Configuration.getValue("db.Url");
        var user = Configuration.getValue("db.User");
        var password = Configuration.getValue("db.Password");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer conexão com o banco de dados: " + e.getMessage());
        }
    }
}
