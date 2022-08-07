package repository.impl;

import entity.UserAccount;
import repository.BaseRepository;
import repository.UserRepository;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepositoryImpl implements BaseRepository<UserAccount>, UserRepository {


    @Override
    public UserAccount create(UserAccount userAccount) throws SQLException {
        String sql = """
                insert into user_account(first_name, last_name,birth_date , user_type, username, password, is_blocked, credit, dor, borrowed_num, reserve_num, returned_num)
                values (?, ?, (to_date)?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1, userAccount.getUsertype().toString());
        ps.setString(2, userAccount.getUsername());
        ps.setString(3, userAccount.getPassword());
        ps.setBoolean(4, userAccount.isBlocked());
        ps.setDouble(5, userAccount.getCredit());
        ps.setString(6, userAccount.getDor());
        ps.setInt(7, userAccount.getBorrowedNum());
        ps.setInt(8, userAccount.getReserveNum());
        ps.setInt(9, userAccount.getReturnedNum());
        ps.executeUpdate();
        return userAccount;
    }

    @Override
    public UserAccount read(UserAccount t) {

        return null;
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        return null;
    }

    @Override
    public void delete(UserAccount userAccount) {

    }


    @Override
    public void changePassword() {

    }

    @Override
    public UserAccount findById(long id) {
        return null;
    }

    @Override
    public UserAccount findByUsername(String username) {
        return null;
    }

    @Override
    public boolean isUsernameExist(String input) {
        return false;
    }

    @Override
    public void createTable() {

    }

    @Override
    public boolean Blocked() {
        return false;
    }

    @Override
    public boolean checkCredit(double price) {
        return false;
    }

    @Override
    public void chargeCredit(double charge) {

    }

    @Override
    public double updateCredit(double price) {
        return 0;
    }

    @Override
    public int noBorrowed(long id) {
        return 0;
    }

    @Override
    public int noReserved(long id) {
        return 0;
    }

    @Override
    public int noReturned(long id) {
        return 0;
    }


    public static void creatTable() throws SQLException {
        String sql = """
                create table if not exists user_account (
                id serial primary key ,
                first_name varchar(255),
                last_name varchar(255),
                birth_date date,
                user_type user_type,
                username varchar(255),
                password varchar(255),
                is_blocked varchar(255),
                credit float,
                dor varchar(255),
                borrowed_num int,
                reserve_num int,
                returned_num int)
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.executeUpdate();
    }

    @Override
    public void creatUserType() throws SQLException {
        String sql = "CREATE TYPE user_type AS ENUM('MEMBER_USER', 'ADMINS_USER', 'STUDENT_USER', 'TEACHER_USER');";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.executeUpdate();
    }

}
