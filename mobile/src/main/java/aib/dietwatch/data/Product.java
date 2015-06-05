package aib.dietwatch.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Mateusz on 2015-05-28.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable, Comparable<Product>{

    public int id;

    public String name;
    public	String	carbs;
    public	String	fat;
    public	String	kcal;
    public	String	proteins;
    public Integer ownerId;

    @Override
    public int compareTo(Product product) {

        if (id > product.id) {
            return -1;
        } else if (id == product.id) {
            return 0;

        } else {
            return 1;
        }

    }}
