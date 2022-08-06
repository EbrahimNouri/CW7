package repository;

import entity.UserAccount;

public interface UserRepository {
    void changePassword();
    UserAccount findById(long id);
    UserAccount findByUsername(String username);
    boolean isUsernameExist(String input);
    void createTable();
    boolean Blocked();
    boolean checkCredit(double price);
    void chargeCredit(double charge);
    double updateCredit(double price);
    int noBorrowed(long id);
    int noReserved(long id);
    int noReturned(long id);




}
