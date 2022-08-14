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
    public void createTable() throws SQLException {
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
    public UserAccount create(UserAccount userAccount) throws SQLException {
        String sql = """
                insert into user_account(first_name, last_name,birth_date , user_type, username, password, is_blocked, credit, dor, borrowed_num, reserve_num, returned_num)
                values (?, ?, to_date(?,'yyy/mm/dd'), ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        return setUserAccount(sql);
    }

    @Override
    public UserAccount read(UserAccount userAccount) throws SQLException {
        long id = userAccount.getId();
        return getUserAccount(id);
    }


    @Override
    public UserAccount update(UserAccount userAccount) throws SQLException {
        String sql = "update user_account set first_name = ?, last_name = ?, birth_date = ?, user_type = ?, username = ?, password = ?, is_blocked = ?, credit = ?, dor = ?, borrowed_num = ?, reserve_num = ?, returned_num = ? where id = ?";
        return setUserAccount(sql);
    }

    @Override
    public void delete(UserAccount userAccount) throws SQLException {
        String sql = "delete from user_account where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, userAccount.getId());
        ps.executeUpdate();
    }


    @Override
    public void changePassword(long id) throws SQLException {
        String sql = "update user_account set password = ? where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public UserAccount findById(long id) throws SQLException {
        return getUserAccount(id);
    }


    @Override
    public boolean isUsernameExist(String username) throws SQLException {
        UserAccount userAccount = findByUsername(username);
        return userAccount != null;
    }


    @Override
    public boolean Blocked(UserAccount userAccount) throws SQLException {
        String sql = "select is_blocked from user_account where id = ?";
        ResultSet rs = resultSetById(sql, userAccount.getId());
        if (rs.next()) {
            userAccount.setBlocked(rs.getBoolean("is_blocked"));
        }
        return userAccount.isBlocked();
    }

    @Override
    public Double checkCredit(Long id) throws SQLException {

        String sql = "select credit from user_account where id = ?";
        ResultSet rs = resultSetById(sql, id);
        if (rs.next()) {
            return rs.getDouble("credit");
        } else {
            System.out.println("ERROR 404");
            return 0.0;
        }
    }

    @Override
    public void updateCredit(UserAccount userAccount, double charge) throws SQLException {
        String sql = "update user_account set credit = ? where id = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setDouble(1, userAccount.getCredit() + charge);
        ps.setLong(2, userAccount.getId());
        ps.executeUpdate();
    }


    @Override
    public int noBorrowed(long id) throws SQLException {
        String sql = "select borrowed_num from user_account where id = ?";
        ResultSet rs = resultSetById(sql, id);
        return rs.getInt("borrowed_num");
    }

    @Override
    public int noReserved(long id) throws SQLException {
        String sql = "select reserve_num from user_account where id = ?";
        ResultSet rs = resultSetById(sql, id);
        return rs.getInt("reserve_num");
    }

    @Override
    public int noReturned(long id) throws SQLException {
        String sql = "select returned_num from user_account where id = ?";
        ResultSet rs = resultSetById(sql, id);
        return rs.getInt("returned_num");
    }

    @Override
    public void creatUserType() throws SQLException {
        String sql = "CREATE TYPE user_type AS ENUM('MEMBER_USER', 'ADMINS_USER', 'STUDENT_USER', 'TEACHER_USER');";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.executeUpdate();
    }

    private UserAccount setUserAccount(String sql) throws SQLException {
        UserAccount userAccount = new UserAccount();
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
        ps.executeQuery();
        return userAccount;
    }


    @Override
    public UserAccount findByUsername(String username) throws SQLException {
        UserAccount userAccount = new UserAccount();
        String sql = "select * from user_account where username = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        return ResultSetsAll(userAccount, rs);
    }

    private UserAccount getUserAccount(long id) throws SQLException {
        UserAccount userAccount = new UserAccount();
        String sql = "select * from user_account where id = ?";
        return ResultSetsAll(userAccount, resultSetById(sql, id));
    }

    private UserAccount ResultSetsAll(UserAccount userAccount, ResultSet rs) throws SQLException {
        if (rs.next()) {
            userAccount.setId(rs.getLong(1));
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

    public ResultSet resultSetById(String sql, long id) throws SQLException {
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setLong(1, id);
        return ps.executeQuery();
    }
}
