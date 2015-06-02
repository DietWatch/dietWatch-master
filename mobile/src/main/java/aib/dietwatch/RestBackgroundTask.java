package aib.dietwatch;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import aib.dietwatch.data.Account;
import aib.dietwatch.data.Information;
import aib.dietwatch.data.ProductList;
import aib.dietwatch.data.UserDB;


@EBean
public class RestBackgroundTask {

    @RootContext
    SignupActivity activity;
    @RestService
    DietWatchRestClient dietWatchRestClient;
    @RootContext
    RegisterOtherDataActivity registerOtherDataActivity;

    @Background
    void createUser(Account account){
        try {
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            dietWatchRestClient.createUser(account);
        }
        catch (NullPointerException e){
            publishError(e);
        }
    }
   /* @Background
    void createUserDB(UserDB userDB){
        try {
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            dietWatchRestClient.createUserDB(userDB);
        }
        catch (NullPointerException e){
            publishError(e);
        }
    }*/


    @Background
    void addInformation(Information information){
        try {
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            dietWatchRestClient.addInformation(information);
        }
        catch (NullPointerException e){
            publishError(e);
        }
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
