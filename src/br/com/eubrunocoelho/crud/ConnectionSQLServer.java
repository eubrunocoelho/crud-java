package br.com.eubrunocoelho.crud;

public class ConnectionSQLServer {
    public static String getConnection() {
        var Url = Configuration.getValue("db.Url");

        return Url;
    }
}
