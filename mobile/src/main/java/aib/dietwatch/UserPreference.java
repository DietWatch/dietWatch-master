package aib.dietwatch;

import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by Mateusz on 2015-06-05.
 */
@SharedPref(value = SharedPref.Scope.APPLICATION_DEFAULT)
public interface UserPreference  {
    @DefaultInt(0)
    int id();
    @DefaultString("")
    String sessionId();
    @DefaultString("")
    String email();
    @DefaultString("")
    String weight();
    @DefaultString("")
    String height();
    @DefaultString("")
    String age();
    @DefaultString("")
    String bmi();
    @DefaultString("")
    String password();


}
