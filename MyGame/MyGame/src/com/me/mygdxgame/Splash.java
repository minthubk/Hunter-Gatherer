//http://www.caincode.com/libgdx-splash-screen-image-tutorial/

package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash implements Screen
{
	private Texture logo;
	private SpriteBatch spriteBatch;
	private MyGdxGame game;
	public Splash (MyGdxGame game)
	{
		this.game = game;
	}
	Gamedata data = new Gamedata();
	
	@Override
	public void render (float delta)
	{
		GL20 gl = Gdx.graphics.getGL20();
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spriteBatch.begin();
		spriteBatch.draw(logo, 0, 0);
		spriteBatch.end();
		handleInput();
	}

	private void handleInput()
	{
		if(Gdx.input.justTouched())
		{
			data.CurrentLevel = 0;
			game.setScreen(game.mainMenu);
		}
	}
	
	@Override
    public void show()
	{
    	logo = new Texture ( Gdx.files.internal("data/splash.png"));
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
