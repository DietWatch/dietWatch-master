package aib.dietwatch;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.annotations.sharedpreferences.Pref;

import aib.dietwatch.data.Product;
import aib.dietwatch.data.ProductList;
import aib.dietwatch.data.User;

/**
 * Created by student7 on 2015-06-01.
 */
@EBean
public class RestNewProductBackgroundTask {

    @Pref
    UserPreference_ preference;

    @RootContext
    NewProductActivity activity;
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
    void addNewProduct(Product product){
        try{
            dietWatchRestClient.setHeader("X-Dreamfactory-Application-Name", "dietwatch");
            dietWatchRestClient.setHeader("X-Dreamfactory-Session-Token",preference.sessionId().get());
            dietWatchRestClient.addProduct(product);
            publishResult(product);

        }
        catch (Exception e){
            publishError(e);
        }

    }
    @UiThread
    void publishResult(Product product) {
        activity.newProductAdd(product);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }


    }



