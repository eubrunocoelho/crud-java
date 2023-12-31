package com.eubrunocoelho.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLServer {
    public static void main(String[] args) {
        var URL = "jdbc:sqlserver://localhost:1433;databaseName=crud_java;encrypt=false";
        var user = "sa";
        var password = "123456";

        try (Connection connection = DriverManager.getConnection(URL, user, password)) {
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer conexão com o banco de dados: " + e.getMessage());
        }
    }
}
