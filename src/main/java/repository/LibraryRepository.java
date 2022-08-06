package repository;

import entity.Book;
import entity.Category;

import java.util.List;

public interface LibraryRepository {
    void addToLibrary();
    void deleteOfLibrary();
    List<Book> findBooksByCategory(Category category);
    Book findBookById(Long id);
    List<Book> findAllBooks();
    List<Book> booksBorrowed();


}
