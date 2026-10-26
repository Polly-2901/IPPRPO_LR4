package repository;

import model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookRepository{
    private final List<Book> books = new ArrayList<>();

    @Override
    public void save(Book book){
        books.removeIf(b -> b.getId().equals(book.getId()));
        books.add(book);
    }

    @Override
    public Optional<Book> findById(Integer id){
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Book> findAll(){
        return new ArrayList<>(books);
    }
}