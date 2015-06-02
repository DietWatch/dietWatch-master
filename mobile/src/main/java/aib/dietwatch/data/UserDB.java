package aib.dietwatch.data;

/**
 * Created by Wojewski on 2015-05-17.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDB implements Serializable {

    public String name;
    public String password;
    public String email;


}

