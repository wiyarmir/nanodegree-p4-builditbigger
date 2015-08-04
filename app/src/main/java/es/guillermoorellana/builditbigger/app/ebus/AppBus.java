package es.guillermoorellana.builditbigger.app.ebus;

import com.squareup.otto.Bus;

/**
 * Created on 04/08/2015.
 */
public class AppBus extends Bus {
    private static final Bus mInstance = new Bus();

    private AppBus() {
    }

    public static Bus getInstance() {
        return mInstance;
    }
}
