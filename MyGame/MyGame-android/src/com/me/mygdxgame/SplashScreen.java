/*package com.me.mygdxgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity 
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash_screen);
		
		Handler handler = new Handler();
		
		handler.postDelayed(new Runnable()
		{
			public void run()
			{
				finish();
				
				Intent intent = new Intent(SplashScreen.this, MyGdxGame.class);
				SplashScreen.this.startActivity(intent);
			}
		}, 2000 );
	}
}*/
