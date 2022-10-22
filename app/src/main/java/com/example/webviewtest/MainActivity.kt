package com.example.webviewtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    private lateinit var webView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)

        webView.apply {
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient() // 크롬환경에 맞는 세팅을 해줌. 특히, 알람등을 받기위해서는 꼭 선언해주어야함 (alert같은 경우)

            settings.javaScriptEnabled = true

            settings.loadsImagesAutomatically = true
            //새창띄우기 허용
            settings.setSupportMultipleWindows(true)
            //자바스크립트 새창
            settings.javaScriptCanOpenWindowsAutomatically = true
            //화면 줌허용
            settings.setSupportZoom(true)
            //화면확대축소
            settings.builtInZoomControls = true
            //화면사이즈맞추기허용
            settings.useWideViewPort = true

            //캐시허용
            //settings.cacheMode = WebSettings.LOAD_DEFAULT
            settings.setAppCacheEnabled(false)
            settings.domStorageEnabled = true // 로컬 스토리지 사용 여부를 설정하는 속성으로 팝업창등을 '하루동안 보지 않기' 기능 사용에 필요
            settings.allowContentAccess // 웹뷰 내에서 파일 액세스 활성화 여부
            settings.userAgentString = "app" // 웹에서 해당 속성을 통해 앱에서 띄운 웹뷰로 인지 할 수 있도록 합니다.
            settings.defaultTextEncodingName = "UTF-8" // 인코딩 설정
            settings.databaseEnabled = true //Database Storage API 사용 여부 설정
            settings.domStorageEnabled = true


        }

        webView.loadUrl("https://www.google.co.kr")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }
}