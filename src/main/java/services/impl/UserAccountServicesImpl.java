package services.impl;

import entity.Usertype;
import services.UserAccountServices;

public class UserAccountServicesImpl implements UserAccountServices {

    @Override
    public double priceCal(Usertype usertype, double price) {
        if (usertype == Usertype.STUDENT_USER) {
            return price * 0.8;
        } else if (usertype == Usertype.ADMINS_USER) {
            return 0;
        } else if (usertype == Usertype.MEMBER_USER) {
            return price;
        } else if (usertype == Usertype.TEACHER_USER) {
            return price * 0.6;
        } else {
            System.out.println("ERROR 404");
            return price;
        }
    }

    @Override
    public void login() {

    }

    @Override
    public void signUp() {

    }
}