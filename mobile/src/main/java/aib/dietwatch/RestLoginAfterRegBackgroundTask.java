package aib.dietwatch;

/**
 * Created by Wojewski on 2015-05-22.
 */


import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import aib.dietwatch.data.EmailAndPassword;
import aib.dietwatch.data.User;

@EBean
public class RestLoginAfterRegBackgroundTask {

    @RootContext
    RegisterOtherDataActivity activity;

    @RestService
    DietWatchRestClient dietWatchRestClient;

    @Background
    void login(EmailAndPassword emailAndPassword) {
        try {
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            User user = dietWatchRestClient.email(emailAndPassword);
            publishResult(user);
        } catch (Exception e) {
            publishError(e);
        }
    }



    @UiThread
    void publishResult(User user) {
        activity.loginSuccess(user);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }
}