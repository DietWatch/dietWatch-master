package aib.dietwatch;

/**
 * Created by Wojewski on 2015-05-16.
 */


import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import aib.dietwatch.data.Account;
import aib.dietwatch.data.EmailAndPassword;
import aib.dietwatch.data.Information;
import aib.dietwatch.data.Product;
import aib.dietwatch.data.ProductList;
import aib.dietwatch.data.User;
import aib.dietwatch.data.UserDB;


@Rest(rootUrl = "https://dsp-dietwatchaib-44000.cloud.dreamfactory.com:443/rest",
        converters = { MappingJackson2HttpMessageConverter.class })

@RequiresHeader({"X-Dreamfactory-Application-Name"})
public interface DietWatchRestClient extends RestClientHeaders {

    @Post("/user/session")
    User email(EmailAndPassword emailAndPassword);

    @Post("/user/register")
    Account createUser(Account account);
/*
    @Post("/database/user")
    UserDB createUserDB(UserDB userDB);*/

    @Post("/db/informations")
    Information addInformation(Information information);
    @RequiresHeader({"X-Dreamfactory-Application-Name"})
    @Get("/db/productss")
    ProductList getProducts();

}