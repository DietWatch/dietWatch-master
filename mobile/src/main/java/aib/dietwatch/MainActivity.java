package aib.dietwatch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.Extra;

import aib.dietwatch.data.EmailAndPassword;


@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    public RadioGroup grupa, cel;
    public RadioButton akt1, akt2, akt3, akt4, cel1, cel2, cel3;
    @Extra
    EmailAndPassword emailAndPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //testetstjsasdasdb

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

        int wagaZ, wzrostZ, wiekZ, wynikZ;
                if (mez.isChecked()) {


                    boolean isError = false;
                    EditText wa = (EditText) findViewById(R.id.waga);
                    EditText wz = (EditText) findViewById(R.id.wzrost);
                    EditText wi = (EditText) findViewById(R.id.wiek);

                    TextView wy = (TextView) findViewById(R.id.wynik);
                    if (wa.getText().toString().isEmpty()){
                        wa.setError("dupa");
                        isError = true;

                    }
                    wagaZ = Integer.parseInt(wa.getText().toString());

                    wzrostZ = Integer.parseInt(wz.getText().toString());
                    wiekZ = Integer.parseInt(wi.getText().toString());




                    wynikZ = (int) (((66.47 + (13.75 * wagaZ) + (5 * wzrostZ) - (6.75 * wiekZ)) * aktywnosc) + celDane);

                    wy.setText(Integer.toString(wynikZ));;
                } else {



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

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
