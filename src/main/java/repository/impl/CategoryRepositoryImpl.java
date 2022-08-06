package repository.impl;

import entity.Category;
import repository.BaseRepository;
import repository.CategoryRepository;

public class CategoryRepositoryImpl implements CategoryRepository, BaseRepository<Category> {
    @Override
    public Category create(Category category) {
        return null;
    }

    @Override
    public Category read() {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public boolean isCategoryExist() {
        return false;
    }

    @Override
    public Category findCategory(long id) {
        return null;
    }

    @Override
    public void delete(Category category) {
        BaseRepository.super.delete(category);
    }
}
