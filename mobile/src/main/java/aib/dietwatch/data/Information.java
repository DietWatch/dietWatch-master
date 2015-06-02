package aib.dietwatch.data;

/**
 * Created by Wojewski on 2015-05-22.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Information implements Serializable {


    @JsonProperty("Weight")
    public String Weight;

    @JsonProperty("Height")
    public String Height;

    @JsonProperty("Age")
    public String Age;

    @JsonProperty("BMI")
    public String BMI;

    @JsonProperty("email2FK")//also
    public String EmailFK;


}



