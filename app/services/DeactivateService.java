package services;

import dao.DeactivateDao;
import dto.DeactivateRequest;
import dto.DeactivateResponse;
import models.Roles;
import models.Statuses;
import models.User;

public class DeactivateService {
    public static DeactivateResponse saveDeactivateService (DeactivateRequest deactivateRequest)
    {
        DeactivateResponse deactivateResponse = new DeactivateResponse();

        try{
                User user = User.find.byId(deactivateRequest.getUserId());
                if (user.getRoleId().getRole_id() == Roles.roleTypeEnum.CUSTOMER.getRoleId() &&
                        user.getStatusId().getStatusId() == Statuses.statusTypeEnum.INACTIVE.getStatus_id())
            {
                deactivateResponse.setStatusCode(414);
                deactivateResponse.setStatusName("User already Inactive");
                return deactivateResponse;
            }

            Statuses statuses = Statuses.find.byId(Statuses.statusTypeEnum.INACTIVE.getStatus_id());
            user.setStatusId(statuses);
            deactivateResponse.setStatusCode(200);
            deactivateResponse.setStatusName("User is Inactive now");
            DeactivateDao.saveDeactivateService(user);
        }
        catch (Exception exception)
        {
            deactivateResponse.setStatusCode(500);
            deactivateResponse.setStatusName("Internal server error " + exception);
            return deactivateResponse;
        }

        return deactivateResponse;
    }
}
