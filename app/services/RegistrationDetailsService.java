package services;

import dao.PasswordDao;
import dao.UserDao;
import dto.UserRegistrationRequest;
import dto.UserRegistrationResponse;
import models.Roles;
import models.Statuses;
import models.User;
import models.UserPassword;

import java.util.Date;

public class RegistrationDetailsService {

    public static UserRegistrationResponse save(UserRegistrationRequest userRegistrationRequest)
    {
        UserRegistrationResponse userRegistrationResponse =  new UserRegistrationResponse();
        try {
            User user = new User();
            UserPassword userPassword = new UserPassword();

            user.setFname(userRegistrationRequest.getFname());
            user.setLname(userRegistrationRequest.getLname());
            userPassword.setPswd(userRegistrationRequest.getPswd());
            userPassword.setUser_id(user);
            user.setEmail(userRegistrationRequest.getEmail());
            user.setMobile(userRegistrationRequest.getMobile());
            user.setPan(userRegistrationRequest.getPan());
            user.setDob(userRegistrationRequest.getDob());
            user.setAadharNo(userRegistrationRequest.getAadharNo());
            user.setStatusId(Statuses.getInstance(Statuses.statusTypeEnum.ACTIVE.getStatus_id()));
            user.setRoleId(Roles.getInstance(Roles.roleTypeEnum.CUSTOMER.getRoleId()));
            user.setCreatedOn(new Date());
          //  user.setPassword(userPassword);
            userRegistrationResponse.setStatusCode(200);
            userRegistrationResponse.setStatusName("success");
            UserDao.saveUser(user);
            PasswordDao.saveUserPswd(userPassword);

        }
        catch (Exception exception){

            System.out.println(exception);
            userRegistrationResponse.setStatusCode(500);
            userRegistrationResponse.setStatusName("Error");

            return userRegistrationResponse;
        }

        return userRegistrationResponse;
    }
}
