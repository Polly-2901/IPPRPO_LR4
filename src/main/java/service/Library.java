package service;

import model.Book;
import repository.IBookRepository;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class Library{
    private final IBookRepository bookRepository;

    public Library(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public boolean issueBook(Integer bookId, Integer readerId){
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if(optionalBook.isEmpty()){
            return false;
        }

        Book book = optionalBook.get();

        if(StringUtils.isBlank(book.getTitle())){
            System.out.println("Ошибка: Название книги не может быть пустым!");
            return false;
        }

        if(book.isIssued()){
            return false;
        }

        book.setIssued(true);
        book.setCurrentReaderId(readerId);
        bookRepository.save(book);
        return true;
    }

    public boolean returnBook(Integer bookId){
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if(optionalBook.isEmpty()){
            return false;
        }

        Book book = optionalBook.get();

        if(!book.isIssued()){
            return  false;
        }

        book.setIssued(false);
        book.setCurrentReaderId(null);
        bookRepository.save(book);
        return true;
    }
}