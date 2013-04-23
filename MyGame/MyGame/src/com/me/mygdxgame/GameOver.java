package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver implements Screen
{
	private Texture gameover;
	private SpriteBatch spriteBatch;
	private MyGdxGame game;
	public GameOver (MyGdxGame game)
	{
		this.game = game;
	}
	//Gamedata data = new Gamedata();
	
	@Override
	public void render (float delta)
	{
		GL20 gl = Gdx.graphics.getGL20();
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gamedata.CurrentLevel = 0;
		spriteBatch.begin();
		spriteBatch.draw(gameover, 0, 0);
		spriteBatch.end();
		handleInput();
	}

	private void handleInput()
	{
		if(Gdx.input.justTouched())
		{
			Gamedata.CurrentLevel = 0;
			game.setScreen(game.mainMenu);
			//MainMenu.create();
		}
	}
	
	@Override
    public void show()
	{
    	gameover = new Texture ( Gdx.files.internal("data/gameover.png"));
		spriteBatch = new SpriteBatch();
    }

    @Override
    public void resize(int width, int height) 
    {
    }

   @Override
   public void hide() 
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

   public void dispose() 
   {
   }	
}
