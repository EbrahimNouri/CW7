package repository;

import entity.Books;
import entity.Category;

import java.util.List;

public interface LibraryRepository {
    void addToLibrary();
    void deleteOfLibrary();
    List<Books> findBooksByCategory(Category category);
    Books findBookById(Long id);
    List<Books> findAllBooks();
    List<Books> booksBorrowed();


}
