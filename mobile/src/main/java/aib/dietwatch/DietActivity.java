package aib.dietwatch;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
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
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;


import aib.dietwatch.adapter.ProductListAdapter;
import aib.dietwatch.data.Product;
import aib.dietwatch.data.ProductList;
import aib.dietwatch.data.User;
import aib.dietwatch.fragments.ProductItemFragmet;

@OptionsMenu(R.menu.menu_diet)
@EActivity(R.layout.activity_diet)
public class DietActivity extends ActionBarActivity {


    @Extra
    User user;

    @Bean
    ProductListAdapter adapter;

    @Bean
    @NonConfigurationInstance
    RestProductBackgroundTask restProductBackgroundTask;

    @Bean
    RestLoginBackgroundTask restLoginBackgroundTask;
    @ViewById
    ListView list;

    @Click(R.id.action_logout)
    void actionLogout() {
        restLoginBackgroundTask.logout(user.sessionId);
    }




    ProgressDialog ringProgressDialog;

    @Click(R.id.addBtn)
    void addBtnClicked(){
        NewProductActivity_.intent(this).start();

    }


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
        FragmentManager manager = getFragmentManager();
        ProductItemFragmet productItemFragmet = new ProductItemFragmet();

        productItemFragmet.show(manager,"asdadsdsa");
    }



    public void showError(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
