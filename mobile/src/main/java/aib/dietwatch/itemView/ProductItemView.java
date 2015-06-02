package aib.dietwatch.itemView;

import android.content.Context;
import android.text.TextUtils;
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
        productKcal.setText((Integer.toString(product.kcal)));
        productCarbs.setText((Integer.toString(product.Carbs)));
        productProteins.setText((Integer.toString(product.Proteins)));
        productFat.setText((Integer.toString(product.Fat)));


    }
}
