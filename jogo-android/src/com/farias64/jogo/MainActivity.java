package com.farias64.jogo;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.view.*;
import android.os.*;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        
        initialize(new Game(), cfg);
        
        View decorView = getWindow().getDecorView();
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
			decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_FULLSCREEN| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		}
    }
}
