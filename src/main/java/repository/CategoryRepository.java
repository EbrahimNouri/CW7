package repository;

import entity.Category;

public interface CategoryRepository {
    boolean isCategoryExist();
    Category findCategory(long id);
}
