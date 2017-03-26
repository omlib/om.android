package om.android;

import android.webkit.JavascriptInterface;

public final class Log {

    public String tag;

    public Log( String tag ) {
        this.tag = tag;
    }

    public Log() {
        this( "om" );
    }

    @JavascriptInterface
    public final void debug(String str) {
        android.util.Log.d( tag, str );
    }

    @JavascriptInterface
    public final void error(String str) {
        android.util.Log.e( tag, str );
    }

    @JavascriptInterface
    public final void info(String str) {
        android.util.Log.i( tag, str );
    }

    @JavascriptInterface
    public final void verbose(String str) {
        android.util.Log.v( tag, str );
    }

    @JavascriptInterface
    public final void warn(String str) {
        android.util.Log.w( tag, str );
    }

    @JavascriptInterface
    public final void wtf(String str) {
        android.util.Log.wtf( tag, str );
    }

}
