package services;

import dao.ActivateDao;
import dto.ActivateRequest;
import dto.ActivateResponse;
import models.Roles;
import models.Statuses;
import models.User;

public class ActivateService {

    public static ActivateResponse saveActivateService(ActivateRequest activateRequest)
    {
        ActivateResponse activateResponse = new ActivateResponse();

        try
        {
            User user = User.find.byId(activateRequest.getUserId());
            if (user.getRoleId().getRole_id() == Roles.roleTypeEnum.CUSTOMER.getRoleId() &&
                    user.getStatusId().getStatusId() == Statuses.statusTypeEnum.ACTIVE.getStatus_id())
            {
                activateResponse.setStatusCode(404);
                activateResponse.setStatusName("User already Active");
                return activateResponse;
            }

            Statuses statuses = Statuses.find.byId(Statuses.statusTypeEnum.ACTIVE.getStatus_id());
            user.setStatusId(statuses);
            activateResponse.setStatusCode(200);
            activateResponse.setStatusName("User is Active now");
            ActivateDao.saveActivateService(user);
        }
        catch (Exception exception)
        {
            activateResponse.setStatusCode(500);
            activateResponse.setStatusName("Oops some internal error" +exception);
            return activateResponse;
        }
        return activateResponse;
    }
}
