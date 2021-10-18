package services;

import dto.LoginRequest;
import dto.LoginResponse;
import models.User;
import models.UserPassword;

public class LoginService {

    public static LoginResponse validateCredentials(LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();
        try {


                User ur = User.find.byId(loginRequest.getId());

                if (ur == null){
                    loginResponse.setStatusCode(400);
                    loginResponse.setStatusName("User ID doesnt exist");
                    return loginResponse;
                }

                UserPassword userPassword =
                        UserPassword.find.query().where()
                                .eq("user_id.id", ur.getId())
                                .eq("pswd", loginRequest.getPassword()).findOne();


                if (userPassword == null) {

                    //System.out.println("Incorrect password for Userid" + loginRequest.getUserId());
                    loginResponse.setStatusCode(404);
                    loginResponse.setStatusName("Incorrect Password");
                    return loginResponse;
                }


                loginResponse.setStatusCode(200);
                loginResponse.setStatusName("Login successful");
                loginResponse.setRoleId(ur.getRoleId().getRole_name());
            }


         catch (Exception exception) {
            System.out.println("Some exception occurred" + exception.getStackTrace().toString());
            loginResponse.setStatusCode(500);
            loginResponse.setStatusName("Some exception occurred");

            return loginResponse;
        }

        // System.out.println("Login successful for user Id " + loginRequest.getUserId());

        return loginResponse;
    }
}



