package repository;

import entity.Category;

import java.sql.SQLException;

public interface CategoryRepository {
    boolean isCategoryExist(String title) throws SQLException;
    Category findCategory(long id) throws SQLException;

}
