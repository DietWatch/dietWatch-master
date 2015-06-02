package aib.dietwatch;

/**
 * Created by Wojewski on 2015-05-22.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

@EActivity(R.layout.activity_registerotherdata)
@OptionsMenu(R.menu.menu_main)
public class RegisterOtherDataActivity extends Activity {

    public RadioGroup grupa, cel;
    public RadioButton akt1, akt2, akt3, akt4, cel1, cel2, cel3;


    @Extra
    User user;
    @Extra
    EmailAndPassword emailAndPassword;
    @ViewById
    EditText waga;
    @ViewById
    TextView wzrost;
    @ViewById
    EditText wiek;
    @ViewById
    TextView wynik;



    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;
    @Bean
    @NonConfigurationInstance
    RestLoginAfterRegBackgroundTask restLoginAfterRegBackgroundTask;

    ProgressDialog ringProgressDialog;


    @AfterViews
    void init() {

        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Loading...");
        ringProgressDialog.setIndeterminate(true);
        restLoginAfterRegBackgroundTask.login(emailAndPassword);


    }



    public void onButtonClick(View v) {
        RadioButton mez;
        mez = (RadioButton) findViewById(R.id.mezczyzna);

        double aktywnosc = 1.0;

        cel = (RadioGroup) findViewById(R.id.cel);
        grupa = (RadioGroup) findViewById(R.id.grupa);


        akt1 = (RadioButton) findViewById(R.id.nisko);
        akt2 = (RadioButton) findViewById(R.id.srednio);
        akt3 = (RadioButton) findViewById(R.id.aktywny);
        akt4 = (RadioButton) findViewById(R.id.bardzo);


        switch (grupa.getCheckedRadioButtonId()) {

            case R.id.nisko:
                if (akt1.isChecked()) {
                    aktywnosc = 1.1;
                    break;
                }
            case R.id.srednio:
                if (akt2.isChecked()) {
                    aktywnosc = 1.2;
                    break;
                }
            case R.id.aktywny:
                if (akt3.isChecked()) {
                    aktywnosc = 1.4;
                    break;
                }
            case R.id.bardzo:
                if (akt4.isChecked()) {
                    aktywnosc = 1.5;
                    break;
                }


        }

        int celDane = 0;



        cel1 = (RadioButton) findViewById(R.id.masa);
        cel2 = (RadioButton) findViewById(R.id.odchudzanie);
        cel3 = (RadioButton) findViewById(R.id.nic);

        switch (cel.getCheckedRadioButtonId()) {

            case R.id.masa:
                if (cel1.isChecked()) {
                    celDane = 500;
                    break;
                }
            case R.id.odchudzanie:
                if (cel2.isChecked()) {
                    celDane = -300;
                    break;
                }
            case R.id.nic:
                if (cel3.isChecked()) {
                    celDane = 0;
                    break;
                }

        }

        if (mez.isChecked()) {

            int wagaZ, wzrostZ, wiekZ, wynikZ;

            EditText wa = (EditText) findViewById(R.id.waga);
            EditText wz = (EditText) findViewById(R.id.wzrost);
            EditText wi = (EditText) findViewById(R.id.wiek);

            TextView wy = (TextView) findViewById(R.id.wynik);

            wagaZ = Integer.parseInt(wa.getText().toString());
            wzrostZ = Integer.parseInt(wz.getText().toString());
            wiekZ = Integer.parseInt(wi.getText().toString());

            wynikZ = (int) (((66.47 + (13.75 * wagaZ) + (5 * wzrostZ) - (6.75 * wiekZ)) * aktywnosc) + celDane);

            wy.setText(Integer.toString(wynikZ));
        } else {

            int wagaZ, wzrostZ, wiekZ, wynikZ;

            EditText wa = (EditText) findViewById(R.id.waga);
            EditText wz = (EditText) findViewById(R.id.wzrost);
            EditText wi = (EditText) findViewById(R.id.wiek);

            TextView wy = (TextView) findViewById(R.id.wynik);


            wagaZ = Integer.parseInt(wa.getText().toString());
            wzrostZ = Integer.parseInt(wz.getText().toString());
            wiekZ = Integer.parseInt(wi.getText().toString());

            wynikZ = (int) (((665.09 + (9.56 * wagaZ) + (1.85 * wzrostZ) - (4.67 * wiekZ)) * aktywnosc) + celDane);

            wy.setText(Integer.toString(wynikZ));

        }
    }





    public void loginSuccess(User user) {


        // służy do sprawdzenia czy dziala przekazywanie id
        // Toast.makeText(this, "You id " + user.id + " "+ user.sessionId, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Uzupełnij dane profilowe", Toast.LENGTH_LONG).show();
    }
    @Click
    void btnRegisterClicked() {

        ringProgressDialog.show();
        Information information = new Information();
        information.Weight = waga.getText().toString();
        information.Height = wzrost.getText().toString();
        information.Age = wiek.getText().toString();
        information.BMI = wynik.getText().toString();
        information.EmailFK = emailAndPassword.email;


        if (waga.getText().toString().length() > 3) {
            Toast.makeText(this, "Wrong weight", Toast.LENGTH_LONG).show();
        } else if (wiek.getText().length() > 1 && wzrost.getText().length() > 2) {

            try {
                restBackgroundTask.addInformation(information);
            } catch (NullPointerException e) {
                showError(e);

            }


            ringProgressDialog.dismiss();

            Toast.makeText(this, "Register data", Toast.LENGTH_LONG).show();
            ProfileActivity_.intent(this).information(information).start();

            finish();

        } else {
            Toast.makeText(this, "Error, write all data", Toast.LENGTH_LONG).show();


        }
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }


}