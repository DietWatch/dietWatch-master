package aib.dietwatch.data;

/**
 * Created by Wojewski on 2015-05-16.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailAndPassword implements Serializable {

    public String email;
    public String password;

}