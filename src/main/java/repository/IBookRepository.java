package repository;

import model.Book;
import java.util.List;
import java.util.Optional;

public interface IBookRepository{
    void save(Book book);
    Optional<Book> findById(Integer id);
    List<Book> findAll();
}