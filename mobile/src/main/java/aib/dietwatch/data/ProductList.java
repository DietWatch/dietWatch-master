package aib.dietwatch.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student7 on 2015-06-01.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductList {

    @JsonProperty("record")
    public List<Product> records = new ArrayList<Product>();
}
