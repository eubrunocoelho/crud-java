package br.com.eubrunocoelho.crud;

public class Main {
    public static void main(String[] args) {
        ConnectionSQLServer connectionSQLServer = new ConnectionSQLServer();
        connectionSQLServer.getConnection();
    }
}