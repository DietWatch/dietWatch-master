package aib.dietwatch.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Mateusz on 2015-05-28.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

    public int id;
    public String name;
    public	String	carbs;
    public	String	fat;
    public	String	kcal;
    public	String	proteins;


//    public Product(String name, int Carbs,int Fat, int Kcal, int Proteins, double WeightP) {
//        this.Carbs=Carbs;
//        this.name=name;
//        this.Fat=Fat;
//        this.kcal=Kcal;
//        this.Proteins=Proteins;
//        this.WeightP=WeightP;
//    }
}
