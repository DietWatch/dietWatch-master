package aib.dietwatch;

import android.util.Log;

import com.google.android.gms.plus.model.people.Person;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import aib.dietwatch.data.ProductList;

/**
 * Created by student7 on 2015-06-01.
 */
@EBean
public class RestProductBackgroundTask {
    private static final String TAG =RestProductBackgroundTask.class.getSimpleName() ;
    @RootContext
    DietActivity activity;
    @RestService
    DietWatchRestClient dietWatchRestClient;

    /*@Background
    void getProductList() {
        try {
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            ProductList productList = dietWatchRestClient.getProducts();

            publishResult(productList);
            Log.d(TAG, "Wynik" + productList);
        } catch (Exception e) {
            publishError(e);
        }
    }*/

    @Background
    void getProductList() {
        try {
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            ProductList productList = dietWatchRestClient.getProducts();
            publishResult(productList);
        } catch (Exception e) {
            publishError(e);
        }
    }



    @UiThread
    void publishResult(ProductList productList) {
        activity.updateProductList(productList);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }
}
