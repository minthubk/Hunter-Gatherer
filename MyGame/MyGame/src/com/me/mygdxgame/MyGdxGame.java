package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;

public class MyGdxGame extends Game implements ApplicationListener, InputProcessor
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
		mainMenu =  new MainMenu(this);
		gamemap = new Map();
		Texture.setEnforcePotImages(false);
		setScreen(splashScreen);	
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
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

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACK)
		{
			if(Gamedata.CurrentLevel > 0)
			{
				setScreen(mainMenu);
			}
			else
				Gdx.app.exit();
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
