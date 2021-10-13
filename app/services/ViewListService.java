package services;

import dto.ViewListResponse;
import models.Roles;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class ViewListService {

    public static List<ViewListResponse> renderViewList()
    {
        List<ViewListResponse> viewListResponseList = new ArrayList<ViewListResponse>();

        try
        {
            List<User>userList = User.find.query().where().
                    eq("roleId.role_id" , Roles.roleTypeEnum.CUSTOMER.getRoleId()).findList();

            if (userList.size() == 0)
            {
                ViewListResponse viewListResponse = new ViewListResponse();
                viewListResponse.setStatusCode(412);
                viewListResponse.setStatusName("No list found");
                viewListResponse.add(viewListResponse);
                return viewListResponseList;
            }

            for(User user : userList)
            {
                ViewListResponse viewListResponse = new ViewListResponse();
                viewListResponse.setUserId(user.getId());
                viewListResponse.setCustomerName(user.getFname());
                viewListResponse.setAccountStatus(user.getStatusId().getStatusId());
                viewListResponse.setDob(user.getDob().toString());
                viewListResponse.setAadharNo(user.getAadharNo());
                viewListResponse.setEmail(user.getEmail());
                viewListResponse.setMobile(user.getMobile());
                viewListResponse.setStatusCode(200);
                viewListResponse.setStatusName("Customer list is shown");
                viewListResponseList.add(viewListResponse);
            }

        }
        catch (Exception exception)
        {
            ViewListResponse viewListResponse = new ViewListResponse();
            viewListResponse.setStatusCode(500);
            viewListResponse.setStatusName("oops some exception" + exception);
            viewListResponseList.add(viewListResponse);
            return viewListResponseList;
        }

        return viewListResponseList;
    }

}
