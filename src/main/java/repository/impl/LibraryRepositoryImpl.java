package repository.impl;

import entity.Books;
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
    public Library read() {
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
    public List<Books> findBooksByCategory(Category category) {
        return null;
    }

    @Override
    public Books findBookById(Long id) {
        return null;
    }

    @Override
    public List<Books> findAllBooks() {
        return null;
    }

    @Override
    public List<Books> booksBorrowed() {
        return null;
    }
}
