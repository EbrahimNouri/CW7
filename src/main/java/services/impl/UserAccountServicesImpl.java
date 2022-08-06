package services.impl;

import entity.UserAccount;
import entity.Usertype;
import services.ApplicationConstant;
import services.UserAccountServices;
import services.UserContext;

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


        String inputUserName = getInput("enter user");
        String inputPassWord = getInput("enter passr");
        if (ApplicationConstant.getUserRepository().isUsernameExist(inputUserName)){
            UserAccount userAccount = ApplicationConstant.getUserRepository().findByUsername(inputUserName);
            if (userAccount.getPassword().equals(inputPassWord))
                System.out.println("welcome "+ userAccount.getUsername());
            UserContext.username=userAccount.getUsername();
            UserContext.id=userAccount.getId();
            UserContext.isBlocked=userAccount.isBlocked();
            UserContext.dor=userAccount.getDor();
        }else{
            System.out.println("this username existed .");
        }


    }
    String getInput(String msg){
        System.out.println(msg);
        return ApplicationConstant.getInput().next();


    }

    @Override
    public void signUp() {
        UserAccount userAccount = new UserAccount();
       String username = "arash";
       if(ApplicationConstant.getUserRepository().isUsernameExist(username))
        ApplicationConstant.getUserRepository().create(userAccount);

    }

    @Override
    public boolean checkNatCode(String natCode) {
        return false;
    }
}