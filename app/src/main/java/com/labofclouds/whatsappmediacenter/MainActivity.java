package com.labofclouds.whatsappmediacenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendText(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setPackage("com.whatsapp");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Teste.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void sendImage(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setPackage("com.whatsapp");

        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/sdcard/imagem.jpg")));
        sendIntent.setType("image/*");
        startActivity(Intent.createChooser(sendIntent, "Send"));
    }

    public void sendSound(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setPackage("com.whatsapp");

        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/sdcard/som.mp3")));
        sendIntent.setType("audio/*");
        startActivity(Intent.createChooser(sendIntent, "Send"));
    }

    public void sendVideo(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setPackage("com.whatsapp");

        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/sdcard/video.mov")));
        sendIntent.setType("video/*");
        startActivity(Intent.createChooser(sendIntent, "Send"));
    }
}