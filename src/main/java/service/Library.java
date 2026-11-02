package service;

import model.Book;
import repository.IBookRepository;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Library{
    private static final Logger logger = LoggerFactory.getLogger(Library.class);
    private final IBookRepository bookRepository;

    public Library(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public boolean issueBook(Integer bookId, Integer readerId){
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if(optionalBook.isEmpty()){
            logger.warn("Attempt to issue non-existent book with id: {}", bookId);
            return false;
        }

        Book book = optionalBook.get();

        if(StringUtils.isBlank(book.getTitle())){
            System.out.println("Ошибка: Название книги не может быть пустым!");
            return false;
        }

        if(book.isIssued()){
            logger.warn("Attempt to issue already booked/unavailable book: {}", book.getTitle());
            return false;
        }

        book.setIssued(true);
        book.setCurrentReaderId(readerId);
        bookRepository.save(book);

        logger.info("Book successfully issued to reader: {}", book.getTitle());

        return true;
    }

    public boolean returnBook(Integer bookId){
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if(optionalBook.isEmpty()){
            logger.warn("Attempt to return non-existent book with id: {}", bookId);
            return false;
        }

        Book book = optionalBook.get();

        if(!book.isIssued()){
            logger.warn("Attempt to return a book that was not issued: id {}", bookId);
            return false;
        }

        book.setIssued(false);
        book.setCurrentReaderId(null);
        bookRepository.save(book);

        logger.info("Book successfully returned: {}", book.getTitle());

        return true;
    }
}