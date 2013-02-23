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
	Map gamemap;
	
	@Override
	public void create()
	{
		splashScreen = new Splash(this);
		gameScreen = new Level1(this);
		level2 = new Level2(this);
		mainMenu = new MainMenu(this);
		gamemap = new Map();
		Texture.setEnforcePotImages(false);
		setScreen(splashScreen);		
	}
	
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
