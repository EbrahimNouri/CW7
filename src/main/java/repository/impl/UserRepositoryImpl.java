package repository.impl;

import entity.UserAccount;
import repository.BaseRepository;
import repository.UserRepository;

public class UserRepositoryImpl implements BaseRepository<UserAccount>, UserRepository {


    @Override
    public UserAccount create(UserAccount userAccount) {

        return null;
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
}
