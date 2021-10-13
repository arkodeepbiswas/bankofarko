package dao;

import models.User;

public class ActivateDao {

    public  static void saveActivateService(User user)
    {
        DbConnector.save(user);
    }


}
