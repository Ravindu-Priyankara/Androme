package com.andy.androme;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Loading extends AppCompatActivity {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Bundle bn = getIntent().getExtras();
        webview = findViewById(R.id.webView);
        String name = bn.getString("andy");
        String data = "https://"+name +".com";

        getSupportActionBar().hide();
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(data);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
    private class myWebClient extends WebViewClient{

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    @Override
    public void onBackPressed() {
        if(webview.isFocused() && webview.canGoBack()){
            webview.goBack();
        }else{
            super.onBackPressed();
        }
    }
}