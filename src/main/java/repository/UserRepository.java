package repository;

import entity.UserAccount;

import java.sql.SQLException;

public interface UserRepository {
    void changePassword(long id) throws SQLException;

    UserAccount findById(long id) throws SQLException;

    UserAccount findByUsername(String username) throws SQLException;

    boolean isUsernameExist(String input) throws SQLException;

    void createTable() throws SQLException;

    boolean Blocked(UserAccount userAccount) throws SQLException;

    Double checkCredit(Long id) throws SQLException;

    void updateCredit(UserAccount userAccount,  double charge) throws SQLException;


    int noBorrowed(long id) throws SQLException;

    int noReserved(long id) throws SQLException;

    int noReturned(long id) throws SQLException;
    void creatUserType() throws SQLException;

}