package om.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
*/
public abstract class AppActivity extends Activity {

    public int systemUiFlags;

    protected WebView webview;

    @Override
    public void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );

        this.requestWindowFeature( Window.FEATURE_NO_TITLE );
        this.getWindow().addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );

        systemUiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
			| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
			| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
			| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
			| View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE
			| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        setSystemUi();

    	webview = new WebView( AppActivity.this );
        webview.setBackgroundColor( 0xff000000 );
		//webview.setInitialScale( 0 );
        //webview.clearCache(true);

		//createWebViewClient();
		//createWebChromeClient();

		WebSettings settings = webview.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setAllowContentAccess(true);
		settings.setAllowFileAccess(true);
		settings.setAllowFileAccessFromFileURLs(true);
		//settings.setAllowUniversalAccessFromFileURLs(true);
		//settings.setDomStorageEnabled(true);
		//settings.setLoadWithOverviewMode(true);
		//settings.setUseWideViewPort(true);
		//settings.setAppCacheEnabled(true);
		//settings.setAppCacheMaxSize( appCacheMaxSize );
		//settings.setAppCachePath( appCachePath );
		//settings.setJavaScriptCanOpenWindowsAutomatically(true);
		//settings.setSupportMultipleWindows(true);

        initAPI();

        setContentView( webview );

        //loadWebApp();
		//webview.loadUrl( "file:///android_asset/index.html" );


        final View decor = getWindow().getDecorView();
        decor.setOnSystemUiVisibilityChangeListener( new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange( int visibility ) {
                if( (visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0 ) {
                    decor.setSystemUiVisibility( systemUiFlags );
                }
            }
        });

    }

	protected void initAPI() {
        bindAPI( new om.android.App( this ), "App" );
        bindAPI( new om.android.Log(), "Log" );
        bindAPI( new om.android.SystemUi( this ), "SystemUi" );
        bindAPI( new om.android.Toast( this ), "Toast" );
        bindAPI( new om.android.Network( this ), "Network" );
		//bindSambaAPI( new samba.android.App(), "App" );
		//bindSambaAPI( new samba.android.App(this), "App" );
		//bindSambaAPI( new samba.android.SystemUi(this), "SystemUi" );
		//bindSambaAPI( new samba.android.Toast(this), "Toast" );
		//bindAppAPI();
	}

    private void bindAPI( Object obj, String id ) {
        webview.addJavascriptInterface( obj, "om_"+id );
    }

    @Override
    public void onPause() {
        super.onPause();
        //callJavascript( "tron.android.App.handleEvent('pause')" );
    }

    @Override
    public void onResume() {
        super.onResume();
        setSystemUi();
        //callJavascript( "tron.android.App.handleEvent('resume')" );
    }

    @Override
    public void onWindowFocusChanged( boolean hasFocus ) {
        super.onWindowFocusChanged( hasFocus );
        if( hasFocus )
			setSystemUi();
    }

    @Override
    public boolean onKeyDown( int keyCode, KeyEvent event ) {
        if( keyCode == KeyEvent.KEYCODE_BACK ) {
            if( webview.canGoBack() ) {
                webview.goBack();
                return true;
            }
        }
        return super.onKeyDown( keyCode, event );
    }

	/*
    protected void loadWebApp() {
        webview.loadUrl( "file:///android_asset/index.html" );
    }
	*/

	/*
    protected void bindAppAPI() {
    }

    protected void bindJavascript( Object obj, String id ) {
        bindAPI( obj, "om_" + id );
    }

    protected void bindAPI( Object obj, String id ) {
        webview.addJavascriptInterface( obj, id );
    }

    protected void createWebViewClient() {
        webview.setWebViewClient( new AppClient() );
    }

    protected void createWebChromeClient() {
        webview.setWebChromeClient( new AppChromeClient() );
    }
	*/

    protected void setSystemUi( int flags ) {
        getWindow().getDecorView().setSystemUiVisibility( flags );
    }

	protected void setSystemUi() {
		setSystemUi( systemUiFlags );
	}
        /*
        public void callJavascript( String script ) {
            // instance.runOnUiThread(new Messenger(instance.view, s));
            //instance.handler.post(new JavascriptMessenger(instance.webview, str));
            webview.loadUrl( "javascript:" + script );
        }
        */

}
