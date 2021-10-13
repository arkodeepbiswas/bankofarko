package dao;

import models.UserPassword;

public class PasswordDao {

    public static void saveUserPswd(UserPassword userPassword){

        DbConnector.save(userPassword);
    }
}

