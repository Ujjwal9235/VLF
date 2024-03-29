package com.example.vlf

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class HomeActivity : AppCompatActivity() {



    private var mywebView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        mywebView = findViewById<View>(R.id.webview) as WebView
        mywebView!!.setWebViewClient(WebViewClient())
        mywebView!!.loadUrl("http://www.vijaylaxmifoundation.org/")
        val webSettings = mywebView!!.getSettings()
        webSettings.javaScriptEnabled = true
    }

    class mywebClient : WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
            super.onPageStarted(view, url, favicon)
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    override fun onBackPressed() {
        if (mywebView!!.canGoBack()) {
            mywebView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}