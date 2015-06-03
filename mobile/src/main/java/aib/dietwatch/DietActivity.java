package aib.dietwatch;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;


import aib.dietwatch.adapter.ProductListAdapter;
import aib.dietwatch.data.Product;
import aib.dietwatch.data.ProductList;
import aib.dietwatch.data.User;

@EActivity(R.layout.activity_diet)
public class DietActivity extends ActionBarActivity {


    @Extra
    User user;

    @Bean
    ProductListAdapter adapter;

    @Bean
    @NonConfigurationInstance
    RestProductBackgroundTask restProductBackgroundTask;
    @ViewById
    ListView list;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init(){

        list.setAdapter(adapter);
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Loading...");
        ringProgressDialog.setIndeterminate(true);
        restProductBackgroundTask.getProductList();


    }



    public void updateProductList(ProductList productList) {
        ringProgressDialog.dismiss();
        adapter.update(productList);
    }


    @ItemClick
    void listItemClicked(Product item) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show();
    }



    public void showError(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
