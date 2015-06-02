package aib.dietwatch.data;

/**
 * Created by Wojewski on 2015-05-16.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    @JsonProperty("session_id")
    public String sessionId;

    public Integer id;

    @JsonProperty("weight")
    public String weight;

    @JsonProperty("height")
    public String height;

    @JsonProperty("age")
    public String age;

    @JsonProperty("bmi")
    public String bmi;

    public String email;

}

