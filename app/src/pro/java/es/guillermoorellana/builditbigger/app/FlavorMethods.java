package es.guillermoorellana.builditbigger.app;

import android.content.Context;
import android.view.View;

import es.guillermoorellana.builditbigger.app.ebus.AppBus;

/**
 * Created on 10/08/2015.
 */
public class FlavorMethods implements FlavorMethodsInterface {
    public void setupAds(View root) {
    }

    @Override
    public void prepareIntersitial(Context context) {

    }

    @Override
    public void showIntersitial() {
        AppBus.getInstance().post("START");
    }
}
