package aib.dietwatch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Click;


@EActivity(R.layout.activity_menu)
public class MenuActivity extends ActionBarActivity {


    @Click
    void zalozClicked() { LoginActivity_.intent(this).start();}


    @Click
    void signupClicked() { SignupActivity_.intent(this).start();}


}
