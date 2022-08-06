package repository.impl;

import entity.Books;
import repository.BaseRepository;
import repository.BookRepository;

public class BookRepositoryImpl implements BookRepository, BaseRepository<Books> {

    @Override
    public Books create(Books books) {
        return null;
    }

    @Override
    public Books read() {
        return null;
    }

    @Override
    public Books update(Books books) {
        return null;
    }

    @Override
    public void delete(Books books) {

    }

    @Override
    public boolean changeStatus(long id) {
        return false;
    }

    @Override
    public boolean checkStatus(long id) {
        return false;
    }
}
