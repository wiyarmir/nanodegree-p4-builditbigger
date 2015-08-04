/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package es.guillermoorellana.jokes.backend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import es.guillermoorellana.jokes.Joker;
import es.guillermoorellana.jokes.backend.Constants;
import es.guillermoorellana.jokes.backend.models.Joke;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokes",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = Constants.API_OWNER,
                ownerName = Constants.API_OWNER,
                packagePath = Constants.API_PACKAGE_PATH
        )
)
public class JokesEndpoint {
    private static final Logger LOG = Logger.getLogger(JokesEndpoint.class.getName());

    /**
     * A simple endpoint method that returns a joke
     */
    @ApiMethod(name = "getJoke")
    public final Joke getJoke() {
        Joke response = new Joke();
        Joker mJoker = new Joker();
        response.setText(mJoker.getJoke());
        
        return response;
    }
    
}
