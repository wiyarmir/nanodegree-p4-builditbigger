package es.guillermoorellana.builditbigger.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.OnClick;
import es.guillermoorellana.builditbigger.app.ebus.AppBus;
import es.guillermoorellana.builditbigger.app.network.GetJokeAsyncTask;
import es.guillermoorellana.jokes.android.JokeActivity;
import es.guillermoorellana.jokes.backend.jokes.model.Joke;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = "JOKEAPP";
    private final FlavorMethods flavorMethods;

    public MainActivityFragment() {
        flavorMethods = new FlavorMethods();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppBus.getInstance().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        flavorMethods.setupAds(root);
        flavorMethods.prepareIntersitial(getActivity());
        flavorMethods.requestNewInterstitial();
        ButterKnife.bind(this, root);
        return root;
    }

    @Subscribe
    public void onGetJoke(Joke joke) {
        Intent i = new Intent(getActivity(), JokeActivity.class);
        i.setAction(JokeActivity.ACTION_JOKE);
        i.putExtra(JokeActivity.EXTRA_JOKE, joke.getText());
        startActivity(i);
    }

    @Override
    public void onDestroy() {
        AppBus.getInstance().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void receiveMessage(String message) {
        if ("START".equals(message)) {
            new GetJokeAsyncTask().execute();
        }
    }

    @OnClick(R.id.telljoke)
    public void tellJoke(View view) {
        flavorMethods.showIntersitial();
    }
}
