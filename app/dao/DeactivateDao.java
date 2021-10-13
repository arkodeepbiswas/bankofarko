package dao;

import models.User;

public class DeactivateDao {

public  static void saveDeactivateService(User user)
{
    DbConnector.save(user);
}

}
