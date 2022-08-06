package repository.impl;

import entity.Book;
import entity.Category;
import entity.Library;
import repository.BaseRepository;
import repository.LibraryRepository;

import java.util.List;

public class LibraryRepositoryImpl implements LibraryRepository, BaseRepository<Library> {

    @Override
    public Library create(Library library) {
        return null;
    }

    @Override
    public Library read(Library library) {
        return null;
    }

    @Override
    public Library update(Library library) {
        return null;
    }


    @Override
    public void addToLibrary() {

    }

    @Override
    public void deleteOfLibrary() {

    }

    @Override
    public List<Book> findBooksByCategory(Category category) {
        return null;
    }

    @Override
    public Book findBookById(Long id) {
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public List<Book> booksBorrowed() {
        return null;
    }
}
