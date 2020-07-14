package com.example.comptermsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class featuresaicswebsite extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featuresaicswebsite);

        webview =(WebView)findViewById(R.id.webview);
        webview.setWebChromeClient(new WebChromeClient());
        webview.loadUrl("https://nasa.gov");

    }
    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }else {
            super.onBackPressed();
        }
    }

}

