package aib.dietwatch;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

import aib.dietwatch.data.EmailAndPassword;
import aib.dietwatch.data.Information;
import aib.dietwatch.data.User;


@EActivity(R.layout.activity_login)
public class LoginActivity extends ActionBarActivity {

    @Extra
    User user;

    @Extra
    Information information;

    @Bean
    @NonConfigurationInstance
    RestLoginBackgroundTask restLoginBackgroundTask;

    @ViewById
    EditText email;

    @ViewById
    EditText password;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Loading...");
        ringProgressDialog.setIndeterminate(true);
    }

    @Click
    void loginClicked()    {
        boolean isError = false;

        EmailAndPassword emailAndPassword = new EmailAndPassword();
        emailAndPassword.email = email.getText().toString(); //"example@example.com";
        emailAndPassword.password = password.getText().toString(); //"test00";
//walidacja
        if(TextUtils.isEmpty(emailAndPassword.email)) {
            email.setError("błąd");
            isError = true;
        }
        if(TextUtils.isEmpty(emailAndPassword.password)) {
            password.setError("błąd");
            isError = true;
        }

        if(!isError) {
            ringProgressDialog.show();
            restLoginBackgroundTask.login(emailAndPassword);
        }





    }






    public void loginSuccess(User user) {

        ringProgressDialog.dismiss();
        Toast.makeText(this, "You have logged successful", Toast.LENGTH_LONG).show();

        EmailAndPassword emailAndPassword = new EmailAndPassword();
        emailAndPassword.email = email.getText().toString();
        emailAndPassword.password = password.getText().toString();
        ProfileActivity_.intent(this).information(information).start();

        finish();
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show();
    }

}