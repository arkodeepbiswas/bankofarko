package dao;

import models.User;

public class UserDao {

public static void saveUser(User user){

    DbConnector.save(user);
}

}



