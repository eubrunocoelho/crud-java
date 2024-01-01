package br.com.eubrunocoelho.crud;

import br.com.eubrunocoelho.crud.database.ConnectionSQLServer;

public class Main {
    public static void main(String[] args) {
        ConnectionSQLServer connectionSQLServer = new ConnectionSQLServer();
        var connection = connectionSQLServer.getConnection();

        System.out.println(connection);
    }
}