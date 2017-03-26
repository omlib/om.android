package om.android;

import android.content.Context;
import android.webkit.JavascriptInterface;

public final class Toast {

    private Context ctx;

    public Toast( Context ctx ) {
        this.ctx = ctx;
    }

    /*
    @JavascriptInterface
    public final void makeText( String msg ) {
        android.widget.Toast.makeText( ctx, msg, android.widget.Toast.LENGTH_SHORT ).show();
    }
    */

    //TODO see hxdroid

    @JavascriptInterface
    public final void show( String msg ) {
        android.widget.Toast.makeText( ctx, msg, android.widget.Toast.LENGTH_SHORT ).show();
    }

}
