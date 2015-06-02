package aib.dietwatch.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Mateusz on 2015-05-28.
 */
public class Product implements Serializable {
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Carbs")
    public	int	Carbs;
    @JsonProperty("Fat")
    public	int	Fat;
    @JsonProperty("KCAL")
    public	int	kcal;
    @JsonProperty("ProductID")
    public	int	ProductID;
    @JsonProperty("Proteins")
    public	int	Proteins;
    @JsonProperty("WeightP")
    public	double	WeightP;

//    public Product(String name, int Carbs,int Fat, int Kcal, int Proteins, double WeightP) {
//        this.Carbs=Carbs;
//        this.name=name;
//        this.Fat=Fat;
//        this.kcal=Kcal;
//        this.Proteins=Proteins;
//        this.WeightP=WeightP;
//    }
}
