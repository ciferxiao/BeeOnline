package com.bee.beeonline.main.show;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.Toast;

import com.bee.beeonline.BeenApplication;
import com.bee.beeonline.R;
import com.bee.beeonline.base.BasePresenterImpl;
import com.beeonline.library.base.BaseActivity;

import java.util.LinkedHashMap;

@SuppressLint("JavascriptInterface")
public class WebActivity extends BaseActivity {

    private WebView webView;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("ansen", "是否有上一个页面:" + webView.canGoBack());
        if (webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {//点击返回按钮的时候判断有没有上一页
            webView.goBack(); // goBack()表示返回webView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_web;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        webView = findViewById(R.id.webview);
        int goodId = 18;
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("goods_id", goodId);
        String sign = BasePresenterImpl.getSign(map);
        webView.loadUrl("http://api.beeonline.com.cn/v1/api.goods.detail?goods_id=236&token=" + BeenApplication.getToken());//加载url
        webView.addJavascriptInterface(new JavaScriptObject(), "android");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void doBusiness() {

    }

    /**
     * JS调用android的方法
     *
     * @return
     */

    private class JavaScriptObject {
        @JavascriptInterface
        public void getClient(String str) {
            Toast.makeText(WebActivity.this, "html调用客户端:" + str, Toast.LENGTH_LONG);
        }

        @JavascriptInterface
        public void toast(String str) {
            showToast(str);
        }

        @JavascriptInterface
        public void loading(String str) {
            showLoading();
        }

        @JavascriptInterface
        public void hLoading(String str) {
            hideLoading();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //释放资源
        webView.destroy();
        webView = null;
    }
}
