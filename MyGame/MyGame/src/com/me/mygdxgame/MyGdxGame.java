package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;


public class MyGdxGame extends Game implements ApplicationListener
{
	Splash splashScreen;
	Level1 gameScreen;
	MainMenu mainMenu;
	Level2 level2;
	
	@Override
	public void create()
	{
		splashScreen = new Splash(this);
		gameScreen = new Level1(this);
		level2 = new Level2(this);
		mainMenu = new MainMenu(this);
		
		Texture.setEnforcePotImages(false);
		System.out.printf("Changing to Screen Class.. \n");
		setScreen(splashScreen);
		System.out.printf("Game Class.. \n");
		
	}
	/*
	private void spawnLog()
	{
		Rectangle log = new Rectangle();
		
		//Random pos.x(min-max) / pos.y(min-max) på gräset
		
		//[(int)pekare.x/48];
		//int posy = ;
		log.x = (int)pekare.x; //pekare.x; //MathUtils.random(0, 768-32);
		log.y = (int)pekare.y; //MathUtils.random(0, 480-32);
		log.width = 32;
		log.height = 32;
		logs.add(log);
		pekare.x = gubbe.x;
		pekare.y = gubbe.y;
		//lastLogSpawn = TimeUtils.nanoTime();
	}*/
	
	@Override
	public void render()
	{
		
		super.render();

	}


	@Override
	public void dispose()
	{
	}
	
	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
		
	}

	@Override
	public void resume()
	{
	}
}
