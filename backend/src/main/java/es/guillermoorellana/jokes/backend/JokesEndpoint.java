/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package es.guillermoorellana.jokes.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import es.guillermoorellana.jokes.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokes",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jokes.guillermoorellana.es",
                ownerName = "backend.jokes.guillermoorellana.es",
                packagePath = ""
        )
)
public class JokesEndpoint {
    
    /**
     * A simple endpoint method that returns a joke
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        Joker mJoker = new Joker();
        response.setData(mJoker.getJoke());
        
        return response;
    }
    
}
