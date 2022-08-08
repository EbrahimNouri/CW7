package repository.impl;

import entity.UserAccount;
import entity.Usertype;
import repository.BaseRepository;
import repository.UserRepository;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements BaseRepository<UserAccount>, UserRepository {


    @Override
    public UserAccount create(UserAccount userAccount) throws SQLException {
        String sql = """
                insert into user_account(first_name, last_name,birth_date , user_type, username, password, is_blocked, credit, dor, borrowed_num, reserve_num, returned_num)
                values (?, ?, to_date(?,'yyy/mm/dd'), ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1, userAccount.getFirstname());
        ps.setString(2, userAccount.getLastName());
        ps.setString(3, userAccount.getBirthday());
        ps.setString(4, userAccount.getUsertype().toString());
        ps.setString(5, userAccount.getUsername());
        ps.setString(6, userAccount.getPassword());
        ps.setBoolean(7, userAccount.isBlocked());
        ps.setDouble(8, userAccount.getCredit());
        ps.setString(9, userAccount.getDor());
        ps.setInt(10, userAccount.getBorrowedNum());
        ps.setInt(11, userAccount.getReserveNum());
        ps.setInt(12, userAccount.getReturnedNum());
        ps.executeUpdate();
        return userAccount;
    }

    @Override
    public UserAccount read(Long id) throws SQLException {
        UserAccount userAccount = new UserAccount();
        String sql = "select * from user_account where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            userAccount.setId(id);
            userAccount.setFirstname(rs.getString(2));
            userAccount.setLastName(rs.getString(3));
            userAccount.setBirthday(rs.getString(4));
            Usertype usertype = Usertype.valueOf(rs.getString(5));
            userAccount.setUsertype(usertype);
            userAccount.setUsername(rs.getString(6));
            userAccount.setPassword(rs.getString(7));
            userAccount.setBlocked(rs.getBoolean(8));
            userAccount.setCredit(rs.getDouble(9));
            userAccount.setDor(rs.getString(10));
            userAccount.setBorrowedNum(rs.getInt(11));
            userAccount.setReserveNum(rs.getInt(12));
            userAccount.setReturnedNum(rs.getInt(13));
        }


        return userAccount;
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
                user_type varchar(63),
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
