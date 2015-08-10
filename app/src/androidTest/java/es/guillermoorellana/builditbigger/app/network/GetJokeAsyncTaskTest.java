package es.guillermoorellana.builditbigger.app.network;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.guillermoorellana.jokes.backend.jokes.model.Joke;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created on 10/08/2015.
 */
@RunWith(AndroidJUnit4.class)
public class GetJokeAsyncTaskTest {
    
    private GetJokeAsyncTask task;

    @Before
    public void setUp() {
        task = new GetJokeAsyncTask() {
            @Override
            protected void onPostExecute(Joke joke) {
                // avoid calling the bus
            }
        };
    }

    @Test
    public void testDoInBackground() {
        Joke joke = task.doInBackground();
        assertThat(joke).isNotNull();
        assertThat(joke.getText()).isNotEmpty();
    }
}