package aib.dietwatch;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import aib.dietwatch.data.EmailAndPassword;
import aib.dietwatch.data.Information;
import aib.dietwatch.data.User;

@EActivity(R.layout.activity_profile)
public class ProfileActivity extends ActionBarActivity {

    @ViewById
    TextView userEmail;
    @ViewById
    TextView poleBMI;

    @Extra
    EmailAndPassword emailAndPassword;
    @Extra
    User user;
    @Extra
    Information information;
    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;
    @AfterViews


    void init() {
        //Toast.makeText(this, "Your email " + emailAndPassword.email.toString(), Toast.LENGTH_LONG).show();

//        userEmail.setText(information.EmailFK.toString());
//
//        poleBMI.setText(information.BMI.toString());


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }


    @Click
    void button2Clicked(){
        DietActivity_.intent(this).start();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
