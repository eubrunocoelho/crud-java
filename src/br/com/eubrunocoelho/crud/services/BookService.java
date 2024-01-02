package br.com.eubrunocoelho.crud.services;

import br.com.eubrunocoelho.crud.DAO.BookDAO;
import br.com.eubrunocoelho.crud.models.Book;

import java.util.List;

public class BookService {
    public void addBook(String title, String author, int pages) {
        BookDAO.addBook(title, author, pages);
    }

    public void findBook(int id) {
        BookDAO.findBook(id);
    }

    public void findAllBooks() {
        List<Book> books = BookDAO.findAllBooks();

        for (Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Título: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthor());
            System.out.println("Páginas: " + book.getPages());
        }
    }
}
