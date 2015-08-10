package es.guillermoorellana.jokes.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class JokeActivity extends AppCompatActivity {
    public static final String ACTION_JOKE = "es.guillermoorellana.jokes.android.JOKE";
    public static final String EXTRA_JOKE = "es.guillermoorellana.jokes.android.extra.JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        ((TextView) findViewById(R.id.jokes)).setText(getIntent().getStringExtra(EXTRA_JOKE));

    }

}
