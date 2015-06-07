package aib.dietwatch;

/**
 * Created by Wojewski on 2015-05-16.
 */

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.annotations.sharedpreferences.Pref;

import aib.dietwatch.data.EmailAndPassword;
import aib.dietwatch.data.User;

@EBean
public class RestLoginBackgroundTask {


    @RootContext
    LoginActivity activity;
    @RestService
    DietWatchRestClient dietWatchRestClient;
    @Background
    void login(EmailAndPassword emailAndPassword) {
        try {
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            User user = dietWatchRestClient.email(emailAndPassword);
            publishResult(user,emailAndPassword.password);

        } catch (Exception e) {
            publishError(e);
        }
    }
    @UiThread
    void publishResult(User user, String password) {
        activity.loginSuccess(user,password );
    }
    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

    @Background
    public void logout (String sessionId){
        try {
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            dietWatchRestClient.setHeader("X-Dreamfactory-Session-Token", sessionId);
            User user = dietWatchRestClient.logout();
            publishLogoutResult(user.isLogout);
        } catch (Exception e) {
            publishLogoutError(e);
        }
    }

    @UiThread
    void publishLogoutResult (Boolean success){
        activity.onLogout(success);
    }


    @UiThread
    void publishLogoutError(Exception e) {
        activity.showErrorUpdate(e);
    }
}
