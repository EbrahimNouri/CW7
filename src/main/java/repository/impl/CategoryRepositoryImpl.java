package repository.impl;

import entity.Category;
import repository.BaseRepository;
import repository.CategoryRepository;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepositoryImpl implements CategoryRepository, BaseRepository<Category> {

    public static void creatTable() throws SQLException {
        String sql = """
                create table if not exists category(
                id serial primary key,
                title varchar(255))
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.executeUpdate();
    }
    @Override
    public Category create(Category category) throws SQLException {
        String sql = "insert into category(id, title) VALUES (?,?)";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, category.getId());
        ps.setString(2, category.getTitle());
        ps.executeUpdate();
        return category;
    }

    @Override
    public Category read(Category category) throws SQLException {
        String sql = "select * from category where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1,category.getId());
        ResultSet rs= ps.executeQuery();
        if(rs.next()){
            category.setId(rs.getLong(1));
            category.setTitle(rs.getString(2));
        }
        return category;
    }

    @Override
    public Category update(Category category) throws SQLException {
        String sql = "UPDATE category set id = ? , title = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, category.getId());
        ps.setString(2, category.getTitle());
        ps.executeUpdate();
        return category;
    }

    @Override
    public boolean isCategoryExist(String title) throws SQLException {
        String sql = "select * from category where title = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return true;
        }else return false;
    }

    @Override
    public Category findCategory(long id) throws SQLException {
        Category category = null;
        String sql ="select * from category where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            category.setId(rs.getLong(1));
            category.setTitle(rs.getString(2));
        }
        
        return category;
    }

    @Override
    public void delete(Category category) throws SQLException {
        String sql = "delete from category where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, category.getId());
        ps.executeUpdate();
    }
}
