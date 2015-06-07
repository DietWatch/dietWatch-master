package aib.dietwatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

import aib.dietwatch.data.Product;
import aib.dietwatch.data.User;

/**
 * Created by Mateusz on 2015-06-05.
 */
@EActivity(R.layout.activity_newproduct)
public class NewProductActivity extends ActionBarActivity{

    @Bean
    @NonConfigurationInstance
    RestNewProductBackgroundTask restNewProductBackgroundTask;

@Extra
Product product;


    @ViewById
    EditText newProductCarbs;
    @ViewById
    TextView titleNewProduct;
    @ViewById
    EditText newProductName;
    @ViewById
    EditText newProductKcal;
    @ViewById
    EditText newProductProteins;
    @ViewById
    EditText newProductFat;
    @ViewById
    Button  confirmNewProduct;

    @Click
    void confirmNewProductClicked(){
          Product product = new Product();
        product.name = newProductName.getText().toString();
        product.carbs = newProductCarbs.getText().toString();
        product.fat = newProductFat.getText().toString();
        product.proteins = newProductProteins.getText().toString();
        product.kcal= newProductKcal.getText().toString();
        restNewProductBackgroundTask.addNewProduct(product);
        DietActivity_.intent(this).start();
    }


    public void newProductAdd(Product product) {

        Toast.makeText(this,"Dodano nowy produkt",Toast.LENGTH_SHORT).show();
        NewProductActivity_.intent(this).product(product);
    }

    public void showError(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
