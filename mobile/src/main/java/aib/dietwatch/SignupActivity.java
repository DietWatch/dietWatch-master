package aib.dietwatch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import aib.dietwatch.data.Account;
import aib.dietwatch.data.EmailAndPassword;
import aib.dietwatch.data.User;
import aib.dietwatch.data.UserDB;
@OptionsMenu(R.menu.menu_main)
@EActivity (R.layout.activity_signup)

public class SignupActivity extends Activity {
    @Extra
    Account account;
    @Extra
    User user;
    @ViewById
    EditText email;
    @ViewById
    EditText new_password;

    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;
    @Bean
    @NonConfigurationInstance
    RestLoginBackgroundTask restLoginBackgroundTask;

    ProgressDialog ringProgressDialog;
    @AfterViews
    void init() {

        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Loading...");
        ringProgressDialog.setIndeterminate(true);

    }

    @Click
    void zaloz() {

        boolean isError = false;
        Account account = new Account();
        account.email = email.getText().toString();
        account.new_password = new_password.getText().toString();
        if(TextUtils.isEmpty(account.email)) {
            email.setError("błąd");
            isError = true;
        }
        if(TextUtils.isEmpty(account.new_password)) {
            new_password.setError("błąd");
            isError = true;
        }

        if(!isError) {

            if (new_password.getText().toString().length() < 6) {
                Toast.makeText(this, "The password must be at least 6 characters!", Toast.LENGTH_LONG).show();
            } else if (email.getText().length() > 3 ) {
                ringProgressDialog.show();
                try {

                    restBackgroundTask.createUser(account);
                } catch (NullPointerException e) {
                    showError(e);

                }
                EmailAndPassword emailAndPassword = new EmailAndPassword();
                emailAndPassword.email = email.getText().toString(); //"example@example.com";
                emailAndPassword.password = new_password.getText().toString(); //"test00";

                // restLoginBackgroundTask.login(emailAndPassword);

           /* UserDB userDB = new UserDB();
            userDB.email = email.getText().toString();
            userDB.password = new_password.getText().toString();
            try {
                restBackgroundTask.createUserDB(userDB);
            } catch (NullPointerException e) {
                showError(e);

            }*/
                ringProgressDialog.dismiss();
                Toast.makeText(this, "Zarejestrowano", Toast.LENGTH_LONG).show();


                RegisterOtherDataActivity_.intent(this).emailAndPassword(emailAndPassword).start();
                finish();

            } else {
                Toast.makeText(this, "Prosze wypełnić wszystkie pola", Toast.LENGTH_LONG).show();
            }
        }





    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }


}