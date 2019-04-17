package com.interview.interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class TwoActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        linearLayout=findViewById(R.id.ll);
        webView=new WebView(this);
        webView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.addView(webView);
        webView.loadUrl("http://shop.cncbox.com/app/index.php?i=6&c=entry&m=ewei_shopv2&do=mobile&r=api.index&mobile=000&pwd=000");
        webViewSet();
        webViewListener();
    }

    private void webViewListener() {
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return super.shouldOverrideKeyEvent(view, event);
            }

            //复写shouldOverrideUrlLoading方法，保证在本app内打开设置的网页
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });
    }

    private void webViewSet() {
        WebSettings settings=webView.getSettings();
        //设置与js的交互
        settings.setJavaScriptEnabled(true);
        //设置自适应屏幕
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

    }

    @Override
    protected void onDestroy() {
        if (linearLayout!=null&&webView!=null){
            linearLayout.removeAllViews();
        }
        webView.destroy();
        super.onDestroy();
    }
}
