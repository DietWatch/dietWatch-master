package aib.dietwatch.itemView;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import aib.dietwatch.R;
import aib.dietwatch.data.Product;

/**
 * Created by Mateusz on 2015-05-28.
 */
@EViewGroup(R.layout.list_item)
public class ProductItemView extends RelativeLayout{
    private static final String TAG = ProductItemView.class.getSimpleName();
    @ViewById
    TextView productName;

    @ViewById
    TextView productKcal;

    @ViewById
    TextView productCarbs;

    @ViewById
    TextView productProteins;

    @ViewById
    TextView productFat;


    public ProductItemView(Context context) {
        super(context);
    }

    public void bind(Product product){
        productName.setText(product.name);
        productKcal.setText(product.kcal);
        productCarbs.setText(product.carbs);
        productProteins.setText(product.proteins);
        productFat.setText(product.fat);


    }
}
