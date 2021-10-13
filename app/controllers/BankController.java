package controllers;

import dto.*;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.*;

import javax.inject.Inject;
import java.util.List;


public class BankController extends Controller {

    RegistrationDetailsService registrationDetails;

    @Inject
    private FormFactory formFactory;
    public Result saveData(Http.Request request)
    {
        Form<UserRegistrationRequest> registrationForm =
                formFactory.form(UserRegistrationRequest.class).bindFromRequest(request);
     UserRegistrationRequest userRegistrationRequest=registrationForm.get();
     UserRegistrationResponse userRegistrationResponse= registrationDetails.save(userRegistrationRequest);
        return ok(Json.toJson(userRegistrationResponse));
    }


    public Result saveLoginService(Http.Request request)
    {
        Form<LoginRequest> loginForm =
                formFactory.form(LoginRequest.class).bindFromRequest(request);
       LoginRequest loginRequest = loginForm.get();
       LoginResponse loginResponse=LoginService.validateCredentials(loginRequest);
System.out.println("status .. "+loginResponse.getStatusCode());
        System.out.println("status .. "+loginResponse.getStatusName());
        return ok(Json.toJson(loginResponse));
    }

        public Result saveSendMoneyService(Http.Request request)
        {
            Form<SendMoneyRequest> sendMoneyRequestForm =
                    formFactory.form(SendMoneyRequest.class).bindFromRequest(request);
            SendMoneyRequest sendMoneyRequest = sendMoneyRequestForm.get();
            SendMoneyResponse sendMoneyResponse = SendMoneyService.saveMoneyDetails(sendMoneyRequest);

            return ok(Json.toJson(sendMoneyResponse));
        }

        public Result saveDeactivateService(Http.Request request)
        {
            Form<DeactivateRequest> deactivateRequestForm =
                    formFactory.form(DeactivateRequest.class).bindFromRequest(request);
            DeactivateRequest deactivateRequest = deactivateRequestForm.get();
            DeactivateResponse deactivateResponse = DeactivateService.saveDeactivateService(deactivateRequest);

            return ok(Json.toJson(deactivateResponse));
        }

        public Result saveActivateService(Http.Request request)
        {
            Form<ActivateRequest> activateRequestForm =
                    formFactory.form(ActivateRequest.class).bindFromRequest(request);
            ActivateRequest activateRequest = activateRequestForm.get();
            ActivateResponse activateResponse = ActivateService.saveActivateService(activateRequest);

            return ok(Json.toJson(activateResponse));
        }

        public Result saveProfileDetailsService(Http.Request request)
        {
            Form<ProfileDetailsRequest> profileDetailsRequestForm =
                    formFactory.form(ProfileDetailsRequest.class).bindFromRequest(request);
            ProfileDetailsRequest profileDetailsRequest = profileDetailsRequestForm.get();
            ProfileDetailsResponse profileDetailsResponse = ProfileDetailsService.renderProfileDetails(profileDetailsRequest);

            return ok(Json.toJson(profileDetailsResponse));
        }

        public Result ViewListService()
        {
            List<ViewListResponse> viewListResponseList = ViewListService.renderViewList();

            return ok(Json.toJson(viewListResponseList));

        }

        public Result renderAccountStatement(Http.Request request)
        {
            Form<AccountStatementRequest> accountStatementRequestForm =
                    formFactory.form(AccountStatementRequest.class).bindFromRequest(request);
            AccountStatementRequest accountStatementRequest = accountStatementRequestForm.get();
            List<AccountStatementResponse> accountStatementResponseList =
                    AccountStatementService.renderAccountStatement(accountStatementRequest);

            return ok(Json.toJson(accountStatementResponseList));
        }

}
