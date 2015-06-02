package aib.dietwatch.data;

/**
 * Created by Wojewski on 2015-05-17.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account implements Serializable {

    public String email;
    public String new_password;

   @JsonProperty("session_id")
    public String sessionId;

}