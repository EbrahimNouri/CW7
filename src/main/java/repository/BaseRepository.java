package repository;

import java.sql.SQLException;

public interface BaseRepository <T> {
    T create(T t) throws SQLException;
    T read(T t) throws SQLException;
    T update(T t) throws SQLException;

    default void delete(T t) throws SQLException {}

}