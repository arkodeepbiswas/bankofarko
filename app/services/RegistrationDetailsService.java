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
import java.util.regex.Pattern;

public class RegistrationDetailsService {

    public static UserRegistrationResponse save(UserRegistrationRequest userRegistrationRequest)
    {
        UserRegistrationResponse userRegistrationResponse =  new UserRegistrationResponse();
        try {

            boolean fname = Pattern.matches("^[A-Za-z]{3,29}$", userRegistrationRequest.getFname());
            if (!fname) {
                userRegistrationResponse.setStatusName("please enter correct first name");
                return userRegistrationResponse;
            }

            boolean lname = Pattern.matches("^[A-Za-z]{3,29}$", userRegistrationRequest.getLname());
            if (!lname) {
                userRegistrationResponse.setStatusName("please enter correct last name");
                return userRegistrationResponse;
            }
            boolean mobile = Pattern.matches("^[6-9]\\d{9}$", userRegistrationRequest.getMobile());
            if (!mobile) {
                userRegistrationResponse.setStatusName("please enter correct mobile number");
                return userRegistrationResponse;
            }
            boolean email = Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", userRegistrationRequest.getEmail());
            if (!email) {
                userRegistrationResponse.setStatusName("please enter correct email");
                return userRegistrationResponse;
            }

            boolean aadhar = Pattern.matches("^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$", userRegistrationRequest.getAadharNo());
            if (!aadhar) {
                userRegistrationResponse.setStatusName("please enter correct aadhaar number");
                return userRegistrationResponse;
            }

            boolean pan = Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]", userRegistrationRequest.getPan());
            if (!pan) {
                userRegistrationResponse.setStatusName("please enter correct pan number");
                return userRegistrationResponse;
            }
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
