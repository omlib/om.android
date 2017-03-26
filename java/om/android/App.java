package om.android;

import android.webkit.JavascriptInterface;

public class App {

    private AppActivity activity;

    public App( AppActivity activity ) {
        this.activity = activity;
    }

    @JavascriptInterface
    public final int quit() {
        activity.finish();
        //System.exit(0);
        return 23;
    }

}
