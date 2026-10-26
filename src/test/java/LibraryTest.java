import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.BookRepository;
import repository.IBookRepository;
import service.Library;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest{
    private Library library;
    private IBookRepository repository;

    @BeforeEach
    void setUp(){
        repository = new BookRepository();
        library = new Library(repository);
    }

    @Test
    @DisplayName("Тест 1: Успешный сценарий — выдача свободной книги")
    void testSuccessfulBookIssuance(){
        Book book = new Book(1, "Призрачный снимок", "Эрве Гибер");
        repository.save(book);

        boolean result = library.issueBook(1,100);

        assertTrue(result, "Свободная книга должна быть успешно выдана");
    }

    @Test
    @DisplayName("Тест 2: (Индивидуальное задание): Ошибка при попытке выдать книгу, которая уже на руках")
    void testIssueBookAlreadyIssuedFails(){
        Book book = new Book(1, "Призрачный снимок", "Эрве Гибер");
        repository.save(book);

        library.issueBook(1, 100);

        boolean result = library.issueBook(1,200);

        assertFalse(result, "Книга, которая уже находится на руках, не может быть выдана повторно");
    }

    @Test
    @DisplayName("Тест 3: Возврат книги делает её снова доступной для выдачи")
    void testReturnAndReissueBook(){
        Book book = new Book(1, "Призрачный снимок", "Эрве Гибер");
        repository.save(book);

        library.issueBook(1,100);
        library.returnBook(1);

        boolean result = library.issueBook(1,200);

        assertTrue(result, "После возврата книга должна быть доступна для выдачи другому читателю");
    }
}