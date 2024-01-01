package br.com.eubrunocoelho.crud;

import br.com.eubrunocoelho.crud.DAO.UserDAO;

public class Main {
    public static void main(String[] args) {
        UserDAO.addUser(
                "Bruno Coelho",
                "eu.brunocoelho@hotmail.com",
                29,
                "São José dos Pinhais - PR, Brasil"
        );
    }
}