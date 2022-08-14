package repository.impl;

import entity.Book;
import repository.BaseRepository;
import repository.BookRepository;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepositoryImpl implements BookRepository, BaseRepository<Book> {

    @Override
    public Book create(Book book) throws SQLException {
        String sql = "insert into book (title, text, category, price)values (?,?,?,?)";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getText());
        ps.setLong(3, book.getCategory().getId());
        ps.setDouble(4, book.getPrice());
        ps.executeUpdate();
        return book;
    }

    @Override
    public Book read(Book book) throws SQLException {
        long id = book.getId();
        String sql = "select * from book where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            book.setId(rs.getLong(1));
            book.setTitle(rs.getString(2));
            book.setText(rs.getString(3));
            book.setCategory(ApplicationConstant.getCategoryRepository().findCategory(rs.getLong(4)));
            book.setPrice(rs.getDouble(5));
        }
        return book;
    }

    // TODO: 8/6/2022 add read category method for category


    @Override
    public Book update(Book book) {
        return null;
    }

    public static void createTable() throws SQLException {
        String sql = """
                create table if not exists Book(
                id serial primary key not null,
                title varchar(255),
                text varchar,
                is_borrowed bool,
                category bigint,
                price float)
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.executeUpdate();
    }

    @Override
    public void delete(Book book) throws SQLException {
        String sql = "delete from book where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, book.getId());
        ps.executeUpdate();
    }

    @Override
    public boolean changeStatus(long id) throws SQLException {
        String sql = "update book set is_borrowed = ? where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setBoolean(1, !checkStatus(id));
        ps.executeUpdate();
        return checkStatus(id);
    }

    @Override
    public boolean checkStatus(long id) throws SQLException {
        String sql = "select is_borrowed from book where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        return rs.getBoolean(1);
    }
}
