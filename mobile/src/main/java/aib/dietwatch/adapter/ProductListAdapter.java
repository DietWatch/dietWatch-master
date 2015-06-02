package aib.dietwatch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import aib.dietwatch.data.Product;
import aib.dietwatch.data.ProductList;
import aib.dietwatch.itemView.ProductItemView;



/**
 * Created by Mateusz on 2015-05-28.
 */
@EBean
public class ProductListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    List<Product> products = new ArrayList<Product>();
    public ProductListAdapter(){

    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Product getItem(int i) {
        return products.get(i);
    }


    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProductItemView productItemView;
        if (convertView == null) {
            productItemView =  new ProductItemView(context);
        } else {
            productItemView = (ProductItemView) convertView;
        }

        productItemView.bind(getItem(position));

        return productItemView;
    }

    public void update(ProductList productList) {
        products.clear();
        products.addAll(productList.records);
    }
}
