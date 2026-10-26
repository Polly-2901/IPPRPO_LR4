package org.example;

import model.Book;
import model.Reader;
import repository.BookRepository;
import repository.IBookRepository;
import service.Library;

public class Main {
    public static void main(String[] args){
        System.out.println("Запуск системы библиотеки");

        IBookRepository repository = new BookRepository();
        Library library = new Library(repository);

        Book book1 = new Book(101, "Преступление и наказание", "Ф. М. Достоевский");
        Reader reader1 = new Reader(1, "Иван Иванов");
        Reader reader2 = new Reader(2, "Петр Петров");

        repository.save(book1);

        boolean success1 = library.issueBook(book1.getId(), reader1.getId());
        System.out.println("1. Выдача книги " + reader1.getName() + ": " + success1);

        boolean success2 = library.issueBook(book1.getId(), reader2.getId());
        System.out.println("2. Выдача занятой книги " + reader2.getName() + ": " + success2);

        library.returnBook(book1.getId());
        boolean success3 = library.issueBook(book1.getId(), reader2.getId());
        System.out.println("3. Выдача книги после возврата" + reader2.getName() + ": " + success3);
    }
}

