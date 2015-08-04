package es.guillermoorellana.builditbigger.app.network;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;

/**
 * Created on 04/08/2015.
 */
public class JokesApi {
    public static final String JOKES_API_ENDPOINT = "https://something.appspot.com/v1";
    private final JokesService mJokesService;

    public JokesApi(Executor httpExecutor, Executor callbackExecutor) {
        mJokesService = init(httpExecutor, callbackExecutor);
    }

    private JokesService init(Executor httpExecutor, Executor callbackExecutor) {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(JOKES_API_ENDPOINT)
                .build();
        return restAdapter.create(JokesService.class);
    }

    public JokesApi() {
        Executor httpExecutor = Executors.newSingleThreadExecutor();
        MainThreadExecutor callbackExecutor = new MainThreadExecutor();
        mJokesService = init(httpExecutor, callbackExecutor);
    }

    public JokesService getService() {
        return mJokesService;
    }
}
