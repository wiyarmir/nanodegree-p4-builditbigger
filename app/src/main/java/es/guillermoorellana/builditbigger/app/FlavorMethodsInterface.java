package es.guillermoorellana.builditbigger.app;

import android.content.Context;
import android.view.View;

/**
 * Created on 10/08/2015.
 */
public interface FlavorMethodsInterface {
    void setupAds(View view);

    void prepareIntersitial(Context context);

    void showIntersitial();

    void requestNewInterstitial();
}
