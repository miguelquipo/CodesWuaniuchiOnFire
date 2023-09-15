package com.example.kewe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ProfileFragment extends Fragment {
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Obtén una referencia al WebView desde el diseño XML
        webView = rootView.findViewById(R.id.webview);

        // Habilita JavaScript si es necesario
        webView.getSettings().setJavaScriptEnabled(true);

        // Carga una página web en el WebView
        webView.loadUrl("http://192.168.4.1");

        // Configura un WebViewClient para abrir enlaces dentro del WebView
        webView.setWebViewClient(new WebViewClient());

        return rootView;
    }
}