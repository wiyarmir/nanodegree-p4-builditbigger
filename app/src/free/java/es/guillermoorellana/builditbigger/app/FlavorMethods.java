package es.guillermoorellana.builditbigger.app;

import android.content.Context;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import es.guillermoorellana.builditbigger.app.ebus.AppBus;

/**
 * Created on 10/08/2015.
 */
public class FlavorMethods implements FlavorMethodsInterface {
    private InterstitialAd mInterstitialAd;

    public void setupAds(View root) {
        AdView mAdView = (AdView) root.findViewById(R.id.adView);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("071ffd9d0ae56eaa")
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void prepareIntersitial(Context context) {
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                AppBus.getInstance().post("START");
            }
        });
    }

    public void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("071ffd9d0ae56eaa")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public void showIntersitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            AppBus.getInstance().post("START");
        }
    }
}
