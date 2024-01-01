package br.com.eubrunocoelho.crud.database;

import br.com.eubrunocoelho.crud.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLServer {
    public static Connection getConnection() {
        var url = Configuration.getValue("db.Url");
        var user = Configuration.getValue("db.User");
        var password = Configuration.getValue("db.Password");

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer conexão com o banco de dados: " + e.getMessage());

            throw new RuntimeException("Erro ao estabelecer conexão com o banco de dados.", e);
        }
    }
}
