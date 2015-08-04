package es.guillermoorellana.builditbigger.app.network;

import android.os.AsyncTask;

import es.guillermoorellana.builditbigger.app.ebus.AppBus;
import es.guillermoorellana.jokes.backend.jokes.model.Joke;
import retrofit.RetrofitError;

/**
 * Created on 04/08/2015.
 */
public class GetJokeAsyncTask extends AsyncTask<Void, Void, Joke> {
    private static JokesApi api = new JokesApi();

    @Override
    protected Joke doInBackground(Void... params) {
        Joke joke = null;
        try {
            joke = api.getService().getJoke();
        } catch (RetrofitError e) {
            e.printStackTrace();
        }
        return joke;
    }

    @Override
    protected void onPostExecute(Joke joke) {
        if (joke != null) {
            AppBus.getInstance().post(joke);
        }
    }
}
