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

    }
    @Click
    void imageButton1Clicked() {
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




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_diet, menu);
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



    public void showError(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
