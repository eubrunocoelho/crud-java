package br.com.eubrunocoelho.crud;

import br.com.eubrunocoelho.crud.services.BookService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService book = new BookService();

        while (true) {
            System.out.println("\nO que deseja fazer?");
            System.out.println("A = Adicioanr Livro");
            System.out.println("L = Listar Livros");
            System.out.println("U = Atualizar Livro");
            System.out.println("D = Deletar Livro");
            System.out.println("E = Sair");

            var option = scanner.nextLine();

            if (option.equalsIgnoreCase("A")) {
                System.out.println("\n## ADICIONAR LIVRO ##\n");

                System.out.println("Digite o título do livro:");
                String title = scanner.nextLine();

                System.out.println("Digite o autor do livro:");
                String author = scanner.nextLine();

                System.out.println("Digite a quantidade de páginas do livro:");
                int pages = scanner.nextInt();

                book.addBook(title, author, pages);

                scanner = new Scanner(System.in);
            } else if (option.equalsIgnoreCase("L")) {
                System.out.println("\n## LISTAR LIVROS ##\n");

                book.findAllBooks();

                scanner = new Scanner(System.in);
            } else if (option.equalsIgnoreCase("U")) {
                System.out.println("\n## ATUALIZAR LIVRO ##\n");

                System.out.println("Digite o ID do livro:");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (book.findBook(id)) {
                    System.out.println("Digite o novo título do livro:");
                    String title = scanner.nextLine();

                    System.out.println("Digite o novo autor do livro:");
                    String author = scanner.nextLine();

                    System.out.println("Digite o nova quantidade de páginas do livro:");
                    int pages = scanner.nextInt();

                    book.updateBook(id, title, author, pages);

                    scanner = new Scanner(System.in);
                } else {
                    System.out.println("Não foi encontrado o livro correspondente ao ID: " + id);

                    scanner = new Scanner(System.in);
                }
            } else if (option.equalsIgnoreCase("D")) {
                System.out.println("\n## DELETAR LIVRO ##\n");

                System.out.println("Digite o ID do livro:");
                int id = scanner.nextInt();

                if (book.findBook(id)) {
                    book.deleteBook(id);

                    scanner = new Scanner(System.in);
                } else {
                    System.out.println("Não foi encontrado o livro correspondente ao ID: " + id);

                    scanner = new Scanner(System.in);
                }
            } else if (option.equalsIgnoreCase("E")) {
                break;
            }
        }
    }
}