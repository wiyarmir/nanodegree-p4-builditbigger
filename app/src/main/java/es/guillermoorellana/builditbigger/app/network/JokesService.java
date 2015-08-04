package es.guillermoorellana.builditbigger.app.network;

import es.guillermoorellana.jokes.backend.jokes.model.Joke;
import retrofit.http.GET;

/**
 * Created on 04/08/2015.
 */
public interface JokesService {
    @GET("/getJoke")
    Joke getJoke();
}
