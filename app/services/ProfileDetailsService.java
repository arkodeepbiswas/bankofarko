package services;

import dto.ProfileDetailsRequest;
import dto.ProfileDetailsResponse;
import models.User;

public class ProfileDetailsService {

    public  static ProfileDetailsResponse renderProfileDetails(ProfileDetailsRequest profileDetailsRequest)
    {
        ProfileDetailsResponse profileDetailsResponse = new ProfileDetailsResponse();

        try
        {
            User user = User.find.byId(profileDetailsRequest.getUserId());
            profileDetailsResponse.setUserId(user.getId());
            profileDetailsResponse.setFname(user.getFname());
            profileDetailsResponse.setLname(user.getLname());
            profileDetailsResponse.setDob(user.getDob().toString());
            profileDetailsResponse.setEmail(user.getEmail());
            profileDetailsResponse.setPan(user.getPan());
            profileDetailsResponse.setAadharNo(user.getAadharNo());
            profileDetailsResponse.setMobile(user.getMobile());

            profileDetailsResponse.setStatusCode(200);
            profileDetailsResponse.setStatusName("Profile Details Shown");

        }
        catch (Exception exception)
        {
            profileDetailsResponse.setStatusCode(400);
            profileDetailsResponse.setStatusName("Oops looks like there's an error" + exception);
            return profileDetailsResponse;
        }

        return profileDetailsResponse;
    }
}
